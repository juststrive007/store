package cn.study.store.service.impl;

import cn.study.store.entity.User;
import cn.study.store.mapper.UserMapper;
import cn.study.store.service.IUserService;
import cn.study.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.xml.crypto.Data;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * @author wm
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        //查找用户
        User result = userMapper.findByUsername(user.getUsername());
        if (result != null) {
            throw new UsernameDuplicatedException("用户名已存在");
        }
        //插入用户
        /**补全数据
         * 补全数据： isDelete
         * 补全数据：4个日志属性
         * 插入数据
         * */
        //密码加密
        String salt = UUID.randomUUID().toString().toUpperCase();
        String password = getMd5Password(user.getPassword(), salt).toUpperCase();
        user.setPassword(password);
        user.setSalt(salt);
        //配置参数
        user.setIsDelete(0);
        Date time = new Date();
        user.setCreateTime(time);
        user.setCreateUser(user.getUsername());
        user.setModifiedTime(time);
        user.setModifiedUser(user.getUsername());

        Integer ret = userMapper.insert(user);
        if (ret != 1) {
            throw new InsertException("数据库插入失败");
        }
    }

    @Override
    public User login(String username, String password) {
        //查找用户
        User result = userMapper.findByUsername(username);
        //用户是否存在判断
        if (result == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        //密码判断
        String md5Password = getMd5Password(password, result.getSalt()).toUpperCase(Locale.ROOT);
        if (!(md5Password.equals(result.getPassword()))) {
            throw new PasswordNotMatchException("用户密码错误");
        }
        //用户匹配，处理返回数据
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }

    @Override
    public void update(Integer uid, String username, String oldPassword, String newPassword) {
        //查询uid状态
        User user = userMapper.findById(uid);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if (user.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }

        String oldMd5Password = getMd5Password(oldPassword, user.getSalt()).toUpperCase();
        if (!user.getPassword().equals(oldMd5Password)) {
            throw new PasswordNotMatchException("密码错误");
        }

        //计算新密码，
        String newMd5Password = getMd5Password(newPassword, user.getSalt()).toUpperCase();
        Date modifiedTime = new Date();
        Integer result = userMapper.updatePasswordByUid(uid, newMd5Password, username, modifiedTime);
        if (result != 1) {
            throw new UpdateException("密码修改失败");
        }
    }

    @Override
    public User getInfo(Integer uid) {
        //查询用户信息
        User result = userMapper.findById(uid);
        if (result == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        //封装结果
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setGender(result.getGender());
        user.setEmail(result.getEmail());
        return user;
    }

    @Override
    public void updateInfoByUid(Integer uid, String username, User user) {
        //查询uid状态
        User userinfo = userMapper.findById(uid);
        if (userinfo == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if (userinfo.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }
        //填充用户数据
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1) {
            throw new UpdateException("更新用户数据失败");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String username, String avatar) {
        //查询uid状态
        User userinfo = userMapper.findById(uid);
        if (userinfo == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if (userinfo.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }

        Integer ret = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if (ret != 1) {
            throw new UpdateException("更新头像失败");
        }
    }


    private String getMd5Password(String password, String salt) {
        //加密规则
        //1.将盐拼接在密码的前后各一次
        //2.摘要运算5次
        String str = salt + password + salt;
        for (int i = 0; i < 5; i++) {
            str = DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
        }
        return str;
    }
}

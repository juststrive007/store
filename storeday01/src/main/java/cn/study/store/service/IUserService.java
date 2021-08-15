package cn.study.store.service;

import cn.study.store.entity.User;
import org.springframework.stereotype.Service;

/**
 * 用户操作接口
 * @author wm
 */

public interface IUserService {

    /**
     * 用户注册
     * @param user 用户
     */
    void reg(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return 用户数据User类
     */
    User login(String username,String password);

    /**
     * 修改用户密码
     * @param uid  用户id
     * @param username 修改用户名
     * @param oldPassword 老密码
     * @param newPassword 新密码
     */
    void update(Integer uid,String username,String oldPassword,String newPassword);

    /**
     * 获取用户信息
     * @param uid 用户id
     * @return User 用户所有信息
     */
    User getInfo(Integer uid);

    /**
     * 更新用户数据
     * @param uid 当前用户id
     * @param username 当前用户名称
     * @param user User 用户数据
     */
    void updateInfoByUid(Integer uid, String username, User user);

    /**
     * 更改用户头像
     * @param uid 当前用户id
     * @param username 当前用户名称
     * @param avatar 用户头像路径
     */
    void changeAvatar(Integer uid,String username,String avatar);

}



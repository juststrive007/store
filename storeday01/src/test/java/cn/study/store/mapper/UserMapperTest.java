package cn.study.store.mapper;

import cn.study.store.entity.User;
import cn.study.store.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insert(){
        User user=new User();
        user.setUsername("wm");
        user.setPassword("12333");
        user.setPhone("11111111");

        Integer result= userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void updateAvatarByUid(){
        Integer uid = 17;
        String avatar="/root/wm";
        Date modifiedTime = new Date();
        String modifiedUser = "wan";
        Integer ret = userMapper.updateAvatarByUid(uid,avatar,modifiedUser,modifiedTime);
        System.err.println(ret);
    }

    @Test
    public void updateByUid(){
        Integer uid = 11;
        String password = "www";
        Date modifiedTime = new Date();
        String modifedUser = "111";
        Integer ret = userMapper.updatePasswordByUid(uid,password,modifedUser,modifiedTime);
        System.out.println(ret);
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(15);
        user.setModifiedUser("wm");
        user.setModifiedTime(new Date());
        user.setEmail("111");
        user.setPhone("111");
        user.setGender(1);
        Integer resutl = userMapper.updateInfoByUid(user);
        System.err.println(resutl);
    }

    @Test
    public void findByUsername(){
        String username="wm";
        User user=userMapper.findByUsername(username);
        System.err.println(user);
    }

    @Test
    public void findByid(){
        Integer uid = 11;
        User user = userMapper.findById(uid);
        System.err.println(user);

    }

}

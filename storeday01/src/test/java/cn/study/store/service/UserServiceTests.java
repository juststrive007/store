package cn.study.store.service;

import cn.study.store.entity.User;
import cn.study.store.service.IUserService;
import cn.study.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    IUserService service;

    @Test
    public void reg() {

        try {
            User user = new User();
            user.setUsername("test3");
            user.setPassword("wwww");
            service.reg(user);
            System.err.println("ok");
        } catch (ServiceException e) {
            System.err.println(e.getClass());
        }

    }

    @Test
    public void login() {
        try {
            String username = "msi";
            String password = "wwww";
            User user = service.login(username, password);
            System.err.println(user);
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void update() {
        Integer uid = 15;
        String username = "msi";
        String password = "111";
        String newPassword = "1111";
        try {
            service.update(uid, username, password, newPassword);
            System.err.println("OK");
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void updateInfoByUid() {
        Integer uid = 15;
        String username = "msi";
        String phone = "111111";
        String email = "email";
        User user = new User();
        user.setPhone(phone);
        user.setEmail(email);
        user.setGender(1);
        try {
            service.updateInfoByUid(uid, username, user);
            System.err.println("ok");
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void changeAvatarByUid() {
        Integer uid = 17;
        String username = "msi";
        String avatar = "/opt";
        try {

            service.changeAvatar(uid, username, avatar);
            System.err.println("ok");
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
        }

    }

    @Test
    public void getInfo() {
        Integer uid = 6;
        try {
            User user = service.getInfo(uid);
            System.err.println(user);
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
        }
    }
}

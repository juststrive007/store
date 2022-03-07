package cn.study.store.controller;

import cn.study.store.entity.User;
import cn.study.store.service.IUserService;
import cn.study.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 用户操作控制器类
 *
 * @author wm
 */
@RequestMapping("users")
@RestController
public class UserController extends BaseController {
    @Autowired
    IUserService iUserService;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        iUserService.reg(user);
        return new JsonResult<Void>(OK);
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password,
                                  HttpSession session) {
        //调用userServicede login()方法
        User user = iUserService.login(username, password);
        //将uid、password放入session
        session.setAttribute("uid", user.getUid());
        session.setAttribute("username", user.getUsername());
        System.err.println("用户登录成功" + username + "," + password);
        //返回
        return new JsonResult<User>(OK, user);

    }

    /**
     * 修改用户密码
     *
     * @param oldPassword 老密码
     * @param newPassword 新密码
     * @param session     httpsession 包含用户的数据
     * @return 返回结果
     */
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(
            String oldPassword, String newPassword, HttpSession session
    ) {
        //获取参数
        String username = session.getAttribute("username").toString();
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        //调用
        iUserService.update(uid, username, oldPassword, newPassword);
        //返回
        return new JsonResult<>(OK);
    }

    /**
     * 获取用户信息
     *
     * @param session httpsession
     * @return User 信息
     */
    @GetMapping("info")
    public JsonResult<User> getinfo(HttpSession session) {

        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        User user = iUserService.getInfo(uid);

        return new JsonResult<>(OK, user);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        String username = session.getAttribute("username").toString();
        iUserService.updateInfoByUid(uid, username, user);
        return new JsonResult<>(OK);
    }

    @PostMapping("change_avatar")
    public JsonResult<String> changeAvatar(@RequestParam("file") MultipartFile file,
                                           HttpSession session) {
        //原始文件名
        String originFilename = file.getOriginalFilename();
        //保存上传头像的文件夹
        String dir = session.getServletContext().getRealPath("upload");
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        //保存上传头像的文件名
        String name = System.currentTimeMillis() +"-"+ System.nanoTime();
        String suffix = "";
        int i = originFilename.indexOf(".");
        if (i > 0) {
            suffix = originFilename.substring(i);
        }
        String filename = name + suffix;

        //用户头像路径
        String avatar = "/upload/"+filename;
        //保存文件
        try {
            File dest = new File(dir,filename);
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        String username = session.getAttribute("username").toString();


        iUserService.changeAvatar(uid, username, avatar);

        return new JsonResult<>(OK,avatar);
    }


}

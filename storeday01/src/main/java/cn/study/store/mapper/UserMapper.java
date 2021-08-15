package cn.study.store.mapper;

import cn.study.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 处理用户数据增删改查的持久层接口
 */
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 更新用户头像
     * @param uid  用户ID
     * @param avatar 头像路径
     * @param modifiedUser 修改用户
     * @param modifiedTime 修改时间
     * @return 受影响行数
     */
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar")String avatar,
            @Param("modifiedUser")String modifiedUser,
            @Param("modifiedTime")Date modifiedTime
    );

    /**
     * 更新用户密码
     * @param uid 用户id
     * @param password 新密码
     * @param modifiedUser 修改用户
     * @param modifiedTime 修改时间
     * @return 修改行数
     */
    Integer  updatePasswordByUid(
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime
    );

    /**
     * 根据用户名查询用户数据
     * @param name 用户名
     * @return 匹配用户数据，如果没有返回null
     */
    User findByUsername(String name);

    /**
     * 根据ID查找用户数据
     * @param uid 用户id
     * @return id对应的用户数据
     */
    User findById(Integer uid);

    /**
     * 根据用户id修改用户数据
     * @param user 封装了用户的id及新修改的用户数据
     * @return 修改行数
     */
    Integer updateInfoByUid(User user);


}

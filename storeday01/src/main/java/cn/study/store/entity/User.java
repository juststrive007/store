package cn.study.store.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Objects;

/**
 * 用户实体类
 * @author wm
 * @version 1.0
 * @since 0.0
 * @see BaseEntity
 */
@Data
public class User extends BaseEntity{
    private static final long serialVersionUID = 1638130740689189345L;
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private Integer gender;
    private String phone;
    private String email;
    private String avatar;
    private Integer isDelete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return uid.equals(user.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uid);
    }
}

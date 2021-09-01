package cn.study.store.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类
 *
 * @author wm
 */
@Data
abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -1L;

    private String createUser;
    private Date createTime;
    private String modifiedUser;
    private Date modifiedTime;

}

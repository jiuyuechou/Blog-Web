package com.muxui.blog.service.auth.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * @author ouyang
 * @title :
 * @description :
 * @createDate 2020/6/16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("muxui_auth_user")
public class AuthUser extends Model<AuthUser> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String socialId;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 密码
     */
    private String password;

    /**
     * 别名
     */
    private String name;

    /**
     * 角色主键 1 普通用户 2 admin
     */
    private Long roleId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 注册时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    /**
     * 个人介绍
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String introduction;

    /**
     * 用户状态 0 正常 1 锁定
     */
    private Integer status;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}

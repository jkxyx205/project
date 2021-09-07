package com.rick.project.user.dao.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rick.project.user.dao.enums.UserStatusEnum;
import lombok.Data;

import java.time.Instant;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@TableName("sys_user")
@Data
public class UserDO {

    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String username;

    private String password;

    private String name;

    private UserStatusEnum status;

    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private Instant createdTime;
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private Long createdBy;
    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    private Instant updatedTime;
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;

    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @JsonIgnore
    private Boolean deleted;
}

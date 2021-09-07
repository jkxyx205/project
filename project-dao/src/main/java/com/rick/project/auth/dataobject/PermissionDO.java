package com.rick.project.auth.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * All rights Reserved, Designed By www.xhope.top
 *
 * @version V1.0
 * @Description: 权限表
 * @author: Rick.Xu
 * @date: 12/19/19 1:39 PM
 * @Copyright: 2019 www.yodean.com. All rights reserved.
 */
@Data
@TableName("sys_auth_permission")
public class PermissionDO {

    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private String permission;

    private Long pid;

    private Integer seqIndex;

}

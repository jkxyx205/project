package com.rick.project.sys.data.dao.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Rick
 * @createdAt 2021-09-06 17:05:00
 */
@TableName("sys_property")
@Data
public class PropertyDO {

    @TableId
    private String name;

    private String value;

}

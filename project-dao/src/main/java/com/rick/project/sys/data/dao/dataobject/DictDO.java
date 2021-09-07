package com.rick.project.sys.data.dao.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;


/**
 * @author rick
 */
@Data
@TableName("sys_dict")
@Builder
public class DictDO {

    private String type;

    private String name;

    private String label;

    private Integer sort;
}

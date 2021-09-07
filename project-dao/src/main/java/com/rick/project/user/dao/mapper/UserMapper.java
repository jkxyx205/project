package com.rick.project.user.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rick.project.user.dao.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    UserDO selectByName(String name);
}

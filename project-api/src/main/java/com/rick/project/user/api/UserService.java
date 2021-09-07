package com.rick.project.user.api;

import com.rick.db.dto.Grid;
import com.rick.project.user.dao.dataobject.UserDO;

import java.util.Map;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    UserDO getUserById(Long id);

    UserDO getUserByName(String name);

    Grid<UserDO> page1();
    Grid<UserDO> page2();
    Grid<Map<String, Object>> page3();
}

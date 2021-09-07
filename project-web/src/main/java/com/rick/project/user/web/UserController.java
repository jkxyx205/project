package com.rick.project.user.web;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rick.db.dto.Grid;
import com.rick.project.user.api.UserService;
import com.rick.project.user.dao.dataobject.UserDO;
import com.rick.project.user.dao.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * http://localhost:8080/users/1
     * @param id
     * @return
     * {
     * 	"id": "1",
     * 	"username": "jkxyx205",
     * 	"password": "123456",
     * 	"name": "Rick",
     * 	"status": "NORMAL",
     * 	"createdTime": "2021-09-01T03:18:03Z",
     * 	"createdBy": 1,
     * 	"updatedTime": "2021-09-06T03:18:08Z",
     * 	"updatedBy": 2
     * }
     */
    @RequestMapping("/{id}")
    public UserDO getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }


    /**
     * http://localhost:8080/users?name=Rick
     * @param name
     * @return
     */
    @RequestMapping
    public UserDO getUserByName(String name) {
        return userService.getUserByName(name);
    }

}



/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rick.project.user.mybatis.controller;

import java.util.List;

import com.rick.project.user.mybatis.entity.MybatisUser;
import com.rick.project.user.mybatis.mapper.MybatisUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis/users")
@RequiredArgsConstructor
public class MybatisUserController {

    private final MybatisUserMapper mybatisUserMapper;

    /**
     * http://localhost:8080/mybatis/users
     * @return
     * [{
     * 	"id": 1,
     * 	"username": "jkxyx205",
     * 	"password": "123456"
     * }]
     */
    @RequestMapping
    public List<MybatisUser> findAll(){
        return mybatisUserMapper.findAll();
    }

}
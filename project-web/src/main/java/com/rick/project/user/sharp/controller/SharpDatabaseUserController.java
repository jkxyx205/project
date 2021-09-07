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
package com.rick.project.user.sharp.controller;

import com.google.common.collect.Maps;
import com.rick.db.dto.Grid;
import com.rick.db.plugin.GridUtils;
import com.rick.db.plugin.mybatis.MappedSharpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sharp/users")
@RequiredArgsConstructor
public class SharpDatabaseUserController {

    private final MappedSharpService  mappedSharpService;

    /**
     * http://localhost:8080/sharp/users/page
     * {
     * 	"page": 1,
     * 	"pageSize": 15,
     * 	"records": 1,
     * 	"totalPages": 1,
     * 	"rows": [{
     * 		"id": 1,
     * 		"username": "jkxyx205",
     * 		"name": "Rick"
     *        }]
     * }
     * @return
     */
    @RequestMapping("page")
    public Grid<Map<String, Object>> page(){
        Map<String, Object> params = Maps.newHashMapWithExpectedSize(1);
        params.put("name", "Rick");
        return GridUtils.list("        SELECT id, username, name\n" +
                "        FROM sys_user\n" +
                "        WHERE name = :name", params, null, null);
    }

    /**
     * http://localhost:8080/sharp/users/list
     * [{
     * 	"id": 1,
     * 	"username": "jkxyx205",
     * 	"name": "Rick",
     * 	"extra": "extra text"
     * }]
     * @return
     */
    @RequestMapping("list")
    public List<Map<String, Object>> list(){
        Map<String, Object> params = Maps.newHashMapWithExpectedSize(1);
        params.put("name", "Rick");

        return mappedSharpService.handle("com.rick.project.user.dao.mapper.UserMapper.selectWithSharp",
                params,
                (sharpService, sql, params1) -> sharpService.query(sql, params1));

    }

}
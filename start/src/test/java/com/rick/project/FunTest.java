package com.rick.project;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.rick.db.dto.Grid;
import com.rick.db.plugin.GridUtils;
import com.rick.db.plugin.mybatis.MappedSharpService;
import com.rick.project.user.api.UserService;
import com.rick.project.user.dao.dataobject.UserDO;
import com.rick.project.user.dao.mapper.UserMapper;
import com.rick.project.user.mybatis.entity.MybatisUser;
import com.rick.project.user.mybatis.mapper.MybatisUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FunTest {

    @Autowired
    private MybatisUserMapper mybatisUserMapper;

    @Autowired
    private MappedSharpService mappedSharpService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceImpl<UserMapper, UserDO> userDAO;

    /**
     * 通过Mapper操作数据
     *     <select id="findAll" resultType="com.rick.project.user.mybatis.entity.MybatisUser">
     *         SELECT * FROM sys_user
     *     </select>
     */
    @Test
    public void testMybatis() {
        List<MybatisUser> all = mybatisUserMapper.findAll();
        Assert.assertEquals(2, all.size());
    }

    /**
     * 查询列表GridUtils
     */
    @Test
    public void testGridUtils() {
        Map<String, Object> params = Maps.newHashMapWithExpectedSize(1);
        params.put("name", "Rick");
        Grid<Map<String, Object>> list = GridUtils.list("SELECT id, username, name\n" +
                "        FROM sys_user\n" +
                "        WHERE name = :name", params, null, null);
        Assert.assertEquals(1, list.getRecords());
    }

    /**
     * Mapper.xml
     *     <select id="selectWithSharp" parameterType="string" resultType="com.rick.project.user.dao.dataobject.UserDO">
     *         SELECT id, username, name, 'extra text' as extra
     *         FROM sys_user
     *         WHERE name = :name
     *     </select>
     */
    @Test
    public void testMappedSharpService() {
        Map<String, Object> params = Maps.newHashMapWithExpectedSize(1);
        params.put("name", "Jim");

        List<Map<String, Object>> list = mappedSharpService.handle("com.rick.project.user.dao.mapper.UserMapper.selectWithSharp",
                params,
                (sharpService, sql, params1) -> sharpService.query(sql, params1));
        Assert.assertEquals(0, list.size());
    }

    /**
     * 测试ServiceImpl
     */
    @Test
    public void testPage() {
        UserDO user1 = userService.getUserById(1L);

        UserDO user2 = userService.getUserByName("Ashley");

        Assert.assertEquals("Rick", user1.getName());
        Assert.assertEquals(2L, user2.getId().longValue());
    }

}
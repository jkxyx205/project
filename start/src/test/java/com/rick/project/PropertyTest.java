package com.rick.project;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.rick.db.dto.Grid;
import com.rick.db.plugin.GridUtils;
import com.rick.db.plugin.mybatis.MappedSharpService;
import com.rick.project.sys.data.PropertyNameConstant;
import com.rick.project.sys.data.api.PropertyService;
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
public class PropertyTest {

    @Autowired
    private PropertyService propertyService;


    @Test
    public void testGetProperty() {
        String property = propertyService.getProperty(PropertyNameConstant.PROPERTY_HELLO);
        Assert.assertEquals("world", property);
    }

}
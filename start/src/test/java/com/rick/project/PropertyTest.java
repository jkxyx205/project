package com.rick.project;

import com.rick.meta.props.service.PropertyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyTest {

    @Autowired
    private PropertyService propertyService;


    @Test
    public void testGetProperty() {
        String property = propertyService.getProperty("hello");
        Assert.assertEquals("world", property);
    }

}
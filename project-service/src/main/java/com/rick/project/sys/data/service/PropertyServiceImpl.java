package com.rick.project.sys.data.service;

import com.rick.project.sys.data.api.PropertyService;
import com.rick.project.sys.data.dao.dataobject.PropertyDO;
import com.rick.project.sys.data.dao.mapper.PropertyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Rick
 * @createdAt 2021-09-06 17:16:00
 */
@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyMapper propertyMapper;

    @Override
    public String getProperty(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        PropertyDO propertyDO = propertyMapper.selectById(name);

        return Objects.isNull(propertyDO) ? null : propertyDO.getValue();
    }
}

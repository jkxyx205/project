package com.rick.project.sys.data.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rick.db.plugin.GridUtils;
import com.rick.db.service.SharpService;
import com.rick.project.sys.data.DictProperties;
import com.rick.project.sys.data.api.DictService;
import com.rick.project.sys.data.dao.dataobject.DictDO;
import com.rick.project.sys.data.dao.impl.DictDAO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Rick
 * @createdAt 2021-09-06 17:45:00
 */
@Service
@RequiredArgsConstructor
public class DictServiceImpl implements DictService, InitializingBean {

    private final DictDAO dictDAO;

    private final DictProperties dictProperties;

    private final SharpService sharpService;

    @Override
    public Optional<DictDO> getDictByTypeAndName(String type, String name) {
        Assert.hasText(type, "type cannot be empty");
        Assert.hasText(name, "name cannot be empty");
//        return dictDAO.getOne(DictDO.builder().type(type).name(name).build());
        return DictUtils.getDictLabel(type, name);
    }

    @Override
    public List<DictDO> getDictByType(String type) {
        Assert.hasText(type, "type cannot be empty");
//        return dictDAO.list(DictDO.builder().type(type).build());
        return DictUtils.getDict(type);
    }

    @Override
    public void afterPropertiesSet() {
        // sys_dict
        List<DictDO> list = dictDAO.list();

        Map<String, List<DictDO>> map = list.stream().collect(Collectors.groupingBy(DictDO::getType));
        DictUtils.dictMap = Maps.newHashMapWithExpectedSize(dictProperties.getItems().size() + map.size());

        for (Map.Entry<String, List<DictDO>> en : map.entrySet()) {
            DictUtils.dictMap.put(en.getKey(), en.getValue().stream().sorted(Comparator.comparing(DictDO::getSort)).collect(Collectors.toList()));
        }

        // yml
        for (DictProperties.Item item : dictProperties.getItems()) {
            if (Objects.nonNull(item.getMap())) {
                initMap(item.getType(), item.getMap());
            } else if (Objects.nonNull(item.getSql())) {
                initSQL(item.getType(), item.getSql());
            }
        }
    }

    private void initSQL(String type, String sql) {
        initMap(type, sharpService.queryForKeyValue(sql, null));
    }

    private void initMap(String type, Map<String, String> map) {
        List<DictDO> list = Lists.newArrayListWithExpectedSize(map.size());
        int i = 0;
        for (Map.Entry<String, String> en : map.entrySet()) {
            list.add(DictDO.builder().type(type)
                    .name(en.getKey())
                    .label(en.getValue())
                    .sort(i++).build());

        }
        DictUtils.dictMap.put(type, list);
    }
}
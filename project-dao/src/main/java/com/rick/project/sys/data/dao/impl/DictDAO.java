package com.rick.project.sys.data.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rick.project.sys.data.dao.dataobject.DictDO;
import com.rick.project.sys.data.dao.mapper.DictMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * @author Rick
 * @createdAt 2021-09-06 17:34:00
 */
@Repository
public class DictDAO extends ServiceImpl<DictMapper, DictDO> {

    public List<DictDO> list(DictDO dictDO) {
        return list(buildWrapper(dictDO));
    }

    public DictDO getOne(DictDO dictDO) {
        return getOne(buildWrapper(dictDO));
    }

    private LambdaQueryWrapper<DictDO> buildWrapper(DictDO dictDO) {
        LambdaQueryWrapper<DictDO> wrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(dictDO.getType())) {
            wrapper.eq(DictDO::getType, dictDO.getType());
        }
        if (Objects.nonNull(dictDO.getName())) {
            wrapper.eq(DictDO::getName, dictDO.getName());
        }
        return wrapper;
    }

}

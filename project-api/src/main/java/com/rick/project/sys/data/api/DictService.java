package com.rick.project.sys.data.api;

import com.rick.project.sys.data.dao.dataobject.DictDO;

import java.util.List;
import java.util.Optional;

/**
 * @author Rick
 * @createdAt 2021-09-06 17:14:00
 */
public interface DictService {

    Optional<DictDO> getDictByTypeAndName(String type, String name);

    List<DictDO> getDictByType(String type);
}

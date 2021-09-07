package com.rick.project.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.rick.db.dto.Grid;
import com.rick.db.dto.PageModel;
import com.rick.db.plugin.GridUtils;
import com.rick.db.plugin.SQLUtils;
import com.rick.project.user.api.UserService;
import com.rick.project.user.dao.dataobject.UserDO;
import com.rick.project.user.dao.mapper.UserMapper;
import com.rick.project.util.GridFormatterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ServiceImpl<UserMapper, UserDO> userDAO;

    @Override
    public UserDO getUserById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public UserDO getUserByName(String name) {
        return userDAO.getBaseMapper().selectByName(name);
    }

    /**
     * Mybatis Plus实现
     * @return
     */
    @Override
    public Grid<UserDO> page1() {
        Page<UserDO> page = userDAO.page(new Page<>(1, 1));
        return GridFormatterUtils.of(page);
    }

    /**
     * pagehelper实现
     * @return
     */
    @Override
    public Grid<UserDO> page2() {
        PageHelper.startPage(1,2
                , SQLUtils.getOrderBy("sys_user"
                        , "name", false, new String[] {"name"}));

        List<UserDO> list = userDAO.list();
        // 将查询到的数据封装到PageInfo对象
        PageInfo<UserDO> pageInfo = new PageInfo(list);
        //分割数据成功
        return GridFormatterUtils.of(pageInfo);
    }

    /**
     * sharp database实现
     * @return
     */
    @Override
    public Grid<Map<String, Object>> page3() {
        Map<String, Object> params = Maps.newLinkedHashMapWithExpectedSize(2);
        params.put(PageModel.PARAM_PAGE,  1);
        params.put(PageModel.PARAM_SIZE,  2);

        return GridUtils.list("SELECT id, username, name, 'extra text' as extra\n" +
                "        FROM sys_user\n" +
                "        WHERE name = :name", params);
    }
}

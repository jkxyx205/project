package com.rick.project.user.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rick.project.user.dao.dataobject.UserDO;
import com.rick.project.user.dao.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Rick
 * @createdAt 2021-09-06 17:34:00
 */
@Repository
public class UserDAO extends ServiceImpl<UserMapper, UserDO> {}

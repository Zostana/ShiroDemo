package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.example.entity.Users;
import com.example.mapper.UsersMapper;
import com.example.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;
import org.apache.catalina.Wrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhang
 * @since 2019-11-06
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 通过用户名获取用户
     * @param userName
     * @return
     */
    public Users getByUserName(String userName) {
        if (!StringUtils.isEmpty(userName)) {
            return usersMapper.selectOne(Wrappers.<Users>lambdaQuery().eq(Users::getUsername, userName));
        } else {
            return null;
        }
    }
}

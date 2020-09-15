package com.thz.mybatis_plus_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thz.mybatis_plus_demo.entity.User;
import com.thz.mybatis_plus_demo.mapper.UserMapper;
import com.thz.mybatis_plus_demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author thz
 * @since 2020-07-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     * @param page
     * @return
     */
    public IPage<User> PageList(Page<User> page){
        return   userMapper.selectPage(page, null);
    }

    @Override
    public IPage<User> PageByAll(User user, Page<User> page) {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        System.out.println(user);
//        if (user.getName() != null && !"".equals(user.getName())){
//            queryWrapper.eq("name",user.getName());
//        }else if (user.getEmail() != null && !"".equals(user.getEmail())){
//            queryWrapper.eq("email",user.getEmail());
//        }else if (user.getAge() != null && user.getAge() != 0){
//            queryWrapper.eq("age",user.getAge());
//        }
//        return userMapper.selectPage(page,queryWrapper);

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        if (user.getName() != null && !"".equals(user.getName())){
            queryWrapper.eq(User::getName,user.getName());
        }else if (user.getEmail() != null && !"".equals(user.getEmail())){
            queryWrapper.eq(User::getEmail,user.getEmail());
        }else if (user.getAge() != null && user.getAge() != 0){
            queryWrapper.eq(User::getAge,user.getAge());
        }
        return userMapper.selectPage(page,queryWrapper);
    }


}

package com.thz.mybatis_plus_demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thz.mybatis_plus_demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author thz
 * @since 2020-07-31
 */
public interface UserService extends IService<User> {

    public IPage<User> PageList(Page<User> page);

    public IPage<User> PageByAll(User user, Page<User> page);

}

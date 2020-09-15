package com.thz.mybatis_plus_demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thz.mybatis_plus_demo.entity.User;
import com.thz.mybatis_plus_demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author thz
 * @since 2020-07-31
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关接口")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("list")
    @ResponseBody
    @ApiOperation("查询所有")
    public String list(){
        List<User> list = new ArrayList<User>();
        list = userService.list();
        return list.toString();
    }

    @PostMapping
    @ApiOperation("新增")
    @Transactional(rollbackFor = Exception.class)
    public void save(@RequestBody User user){
        userService.save(user);
    }


    @DeleteMapping("{id}")
    @ApiOperation("删除")
    public void delete(@PathVariable("id") String id){
        userService.removeById(id);
    }

    @PutMapping()
    @ApiOperation("修改")
    public void update(@RequestBody User user){
        System.out.println("123");
        userService.updateById(user);
    }



    @GetMapping("/Page")
    @ApiOperation("分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNo",value = "当前页",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer",defaultValue = "2")})
    public IPage<User> findByPage(Integer pageNo , Integer pageSize) {
        Page<User> page = new Page<>(pageNo,pageSize);

        return userService.PageList(page);
    }

    @PostMapping("/PageByAll")
    @ApiOperation("条件分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNo",value = "当前页",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页条数",dataType = "Integer",defaultValue = "2")})
    public IPage<User> findByPage(@RequestBody User user, Integer pageNo , Integer pageSize) {
        System.out.println(user);
        Page<User> page = new Page<>(pageNo,pageSize);
        return userService.PageByAll(user,page);
    }



}


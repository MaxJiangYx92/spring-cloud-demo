package com.test.demo.springcloudribbon.service;

import com.test.demo.common.pojo.UserDO;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author JiangYx
 * @Project
 * @Title
 * @Package
 * @Create 2018/6/19 9:56
 * @Update -
 * @Description
 */
public interface UserService {
    UserDO find(String name);

    Future<UserDO> find2(String name);

    List<UserDO> findAll(String names);

    List<UserDO> findAll(List<String> names);
}

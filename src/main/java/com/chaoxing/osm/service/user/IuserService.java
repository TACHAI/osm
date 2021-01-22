package com.chaoxing.osm.service.user;

import com.chaoxing.osm.bean.po.user.User;
import com.chaoxing.osm.common.ServerResponse;

/**
 * @ClassName IuserService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:52
 */
public interface IuserService {
    // 登录
    ServerResponse<User> login(String name, String password);
    // 根据id查询
    ServerResponse<User> selectById(Integer id);
    // 插入用户
    ServerResponse<String> insertUser(User user);
    // 更新用户
    ServerResponse<String> updateUser(User user);
}

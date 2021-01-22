package com.chaoxing.osm.service.user.impl;

import com.chaoxing.osm.bean.po.user.User;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.user.UserMapper;
import com.chaoxing.osm.security.TokenUtil;
import com.chaoxing.osm.service.user.IuserService;
import com.chaoxing.osm.utils.MD5Util;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-14 9:53
 */
@Service("iuserService")
public class UserServiceImpl implements IuserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TokenUtil tokenUtil;


    /**
     * @param name 用户名
     * @param password 密码
     * @return 结果（成功/失败）
     */
    @Override
    public ServerResponse<User> login(String name, String password) {
        if(Strings.isNotBlank(name)&&Strings.isNotBlank(password)){
            password  = MD5Util.MD5(password);
            User user = userMapper.login(name,password);
            if(user!=null){
                String token = tokenUtil.getToken(user);
                user.setPassword(token);
                return ServerResponse.createBySuccess(user);
            }else {
                return ServerResponse.createByErrorMessage("用户名或密码错误");
            }
        }
        return ServerResponse.createByErrorMessage("用户名或密码为空");
    }

    /**
     * @param id userId
     * @return
     */
    @Override
    public ServerResponse<User> selectById(Integer id) {
        if(id!=null){
            User user=userMapper.selectByPrimaryKey(id);
            if(user!=null){
                return ServerResponse.createBySuccess(user);
            }
            return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
        }
        return ServerResponse.createByErrorMessage(ResponseString.PARAMS_IS_EMPTY);
    }

    // TODO 有需求再做
    @Override
    public ServerResponse<String> insertUser(User user) {
        return null;

    }
    /**
     * @param user user信息
     * @return
     */
    @Override
    public ServerResponse<String> updateUser(User user) {
        if(user.getId()!=null){
            User res =  userMapper.selectByPrimaryKey(user.getId());
            if(res!=null){
                String pwd = MD5Util.MD5(user.getPassword());
                user.setPassword(pwd);
                int result = userMapper.updateByPrimaryKeySelective(user);
                if(result>0){
                    return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
                }
                return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
            }
        }
        return ServerResponse.createByErrorMessage(ResponseString.PARAMS_IS_EMPTY);
    }
}

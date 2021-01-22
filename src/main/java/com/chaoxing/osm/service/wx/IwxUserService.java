package com.chaoxing.osm.service.wx;


import com.chaoxing.osm.bean.po.user.WxUser;
import com.chaoxing.osm.common.ServerResponse;

/**
 * @ClassName LiveController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-07
 */
public interface IwxUserService {
    /**
     * 通过前端来的code 请求微信获得用户信息
     * @param code
     * @return
     */
    ServerResponse<WxUser> getWxUser(String code) ;
}

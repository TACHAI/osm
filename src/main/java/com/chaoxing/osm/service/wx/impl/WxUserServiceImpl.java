package com.chaoxing.osm.service.wx.impl;

import com.alibaba.fastjson.JSONObject;
import com.chaoxing.osm.bean.po.user.WxUser;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.user.WxUserMapper;
import com.chaoxing.osm.service.wx.IwxUserService;
import com.chaoxing.osm.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName WxUserServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
@Service("iwxUserService")
public class WxUserServiceImpl implements IwxUserService {
    // todo 要修改
    private static String APPID;
    private static String APPSECRET;

    @Value("${wechat.APPID}")
    public void setAppId(String APPID){
        WxUserServiceImpl.APPID=APPID;
    }

    @Value("${wechat.APPSECRET}")
    public void setSecret(String APPSECRET){
        WxUserServiceImpl.APPSECRET=APPSECRET;
    }



    @Autowired
    private WxUserMapper wxUserMapper;

    @Override
    public ServerResponse<WxUser> getWxUser(String code){

//        WxMpService wxMpService = new WxMpServiceImpl();
//        // 获得access token
//        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
//        // 获得用户基本信息
//        WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken,null);


        // 根据前端的code 来获取access_token
        String tokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+APPSECRET+"&code="+code+"&grant_type=authorization_code";
        ServerResponse<String> response = HttpUtil.doGet(tokenUrl);
        if(response.getStatus()!=200){
            return ServerResponse.createByErrorMessage(response.getMsg());
        }
        String tokenRes = response.getData();

        JSONObject jsonObject = JSONObject.parseObject(tokenRes);
        String access_token = jsonObject.getString("access_token");
        String openId = jsonObject.getString("openid");

        WxUser wxUser = wxUserMapper.selectByOpenId(openId);
        if(wxUser == null){
            //根据access_token来获取用户信息
            String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openId+"&lang=zh_CN";
            String userInfo = HttpUtil.doGet(userInfoUrl).getData();
            wxUser = new WxUser();
            JSONObject userJson = JSONObject.parseObject(userInfo);
            wxUser.setPickname(userJson.getString("nickname"));
            wxUser.setProvince(userJson.getString("province"));
            wxUser.setSex(userJson.getString("sex"));
            wxUser.setHeadimgurl(userJson.getString("headimgurl"));
            wxUser.setOpenid(userJson.getString("openid"));
            wxUser.setCountry(userJson.getString("country"));
            wxUser.setCreateTime(new Date());
            wxUserMapper.insert(wxUser);
        }
        wxUser = wxUserMapper.selectByOpenId(openId);

        return ServerResponse.createBySuccess(wxUser);
    }

    //https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
}

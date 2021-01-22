package com.chaoxing.osm.dao.user;

import com.chaoxing.osm.bean.po.user.WxUser;
import org.apache.ibatis.annotations.Param;

public interface WxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);

    WxUser selectByOpenId(@Param("openId") String openId);

}
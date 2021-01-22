package com.chaoxing.osm.service.live.impl;

import com.chaoxing.osm.bean.po.live.BackLive;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.live.BackLiveMapper;
import com.chaoxing.osm.service.live.IbackLiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BackLiveServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-21 10:24
 */
@Service("ibackLiveService")
public class BackLiveServiceImpl implements IbackLiveService {
    @Autowired
    private BackLiveMapper backLiveMapper;

    @Override
    public ServerResponse<List<BackLive>> selectList(String liveName,String uuid) {
        List<BackLive> list = backLiveMapper.selectList(liveName,uuid);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<BackLive> selectById(Integer id) {
        BackLive live = backLiveMapper.selectByPrimaryKey(id);
        return ServerResponse.createBySuccess(live);
    }
}

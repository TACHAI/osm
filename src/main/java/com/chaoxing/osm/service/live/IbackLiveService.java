package com.chaoxing.osm.service.live;

import com.chaoxing.osm.bean.po.live.BackLive;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @Author https://github.com/TACHAI
 * @Date 2020-05-21 10:23
 */
public interface IbackLiveService {
    ServerResponse<List<BackLive>> selectList(String liveName,String uuid);

    ServerResponse<BackLive> selectById(Integer id);
}

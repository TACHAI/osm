package com.chaoxing.osm.service.live;



import com.chaoxing.osm.bean.po.live.Live;
import com.chaoxing.osm.bean.vo.live.LiveVO;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @ClassName IliveService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-07
 */
public interface IliveService {

    ServerResponse<String> add(Live live);

    ServerResponse<String> update(Live live);

    ServerResponse<List<LiveVO>> selectList(String userId, String liveName,String uuid);

    ServerResponse<List<LiveVO>> selectList(String liveName,String uuid);

    ServerResponse<Live> view(Integer id);

    ServerResponse<LiveVO> selectById(Integer id);

    ServerResponse<Live> living();

    ServerResponse<String> deleteById(Integer id);
}

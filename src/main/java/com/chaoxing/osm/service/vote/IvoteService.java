package com.chaoxing.osm.service.vote;


import com.chaoxing.osm.bean.po.vote.Vote;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @ClassName IvoteService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
public interface IvoteService {

    ServerResponse<String> add(Vote vote);

    ServerResponse<String> deleteById(Integer id);

    ServerResponse<String> update(Vote vote);

    ServerResponse<List<Vote>> selectList(String uuid);

    ServerResponse<Vote> selectById(Integer id);
}

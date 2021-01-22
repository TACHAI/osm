package com.chaoxing.osm.service.vote;



import com.chaoxing.osm.bean.po.vote.VoteWork;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @ClassName IvoteWorkService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
public interface IvoteWorkService {

    ServerResponse<String> add(VoteWork voteWork);

    ServerResponse<String> deleteById(Integer id);

    ServerResponse<String> update(VoteWork voteWork);

    ServerResponse<List<VoteWork>> list(Integer voteId);

    ServerResponse<VoteWork> selectById(Integer id);
}

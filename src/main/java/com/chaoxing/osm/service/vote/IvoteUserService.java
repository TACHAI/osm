package com.chaoxing.osm.service.vote;


import com.chaoxing.osm.bean.po.vote.VoteUser;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @ClassName LiveController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-07
 */
public interface IvoteUserService {

    ServerResponse<String> add(VoteUser voteUser);

    ServerResponse<List<VoteUser>> selectListByVoteId(Integer voteId);

}

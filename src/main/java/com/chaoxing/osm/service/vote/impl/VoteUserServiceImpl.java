package com.chaoxing.osm.service.vote.impl;


import com.chaoxing.osm.bean.po.vote.Vote;
import com.chaoxing.osm.bean.po.vote.VoteUser;
import com.chaoxing.osm.bean.po.vote.VoteWork;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.vote.VoteMapper;
import com.chaoxing.osm.dao.vote.VoteUserMapper;
import com.chaoxing.osm.dao.vote.VoteWorkMapper;
import com.chaoxing.osm.service.vote.IvoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName VoteUserServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
@Service("ivoteUserService")
public class VoteUserServiceImpl implements IvoteUserService {

    @Autowired
    private VoteUserMapper voteUserMapper;
    @Autowired
    private VoteMapper voteMapper;
    @Autowired
    private VoteWorkMapper voteWorkMapper;

    @Override
    public ServerResponse<String> add(VoteUser voteUser) {
        VoteUser user = voteUserMapper.selectByVoteIdAndUserId(voteUser.getVoteId(),voteUser.getUserId());
        if(user !=null){
            return ServerResponse.createByErrorMessage("用户已投票不能再投");
        }
        Date now = new Date();
        Vote vote = voteMapper.selectByPrimaryKey(voteUser.getVoteId());
        if(now.getTime()<vote.getVstartTime().getTime()||now.getTime() >vote.getVendTime().getTime()){
            return ServerResponse.createByErrorMessage("应该在规定的日期内投票");
        }


        voteUser.setCreateTime(now);
        voteUserMapper.insert(voteUser);
        // 作品票数加一
        VoteWork work = voteWorkMapper.selectByPrimaryKey(voteUser.getVoteWorkId());
        work.setPv(work.getPv()+1);
        voteWorkMapper.updateByPrimaryKeySelective(work);
        return ServerResponse.createBySuccessMessage("投票成功");
    }

    @Override
    public ServerResponse<List<VoteUser>> selectListByVoteId(Integer voteId) {
        List<VoteUser> list = voteUserMapper.selectListByVoteId(voteId);
        return ServerResponse.createBySuccess(list);
    }

}

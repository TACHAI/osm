package com.chaoxing.osm.service.vote.impl;

import com.chaoxing.osm.bean.po.vote.Vote;
import com.chaoxing.osm.bean.po.vote.VoteWork;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.vote.VoteMapper;
import com.chaoxing.osm.dao.vote.VoteWorkMapper;
import com.chaoxing.osm.service.vote.IvoteWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName VoteWorkServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
@Service("ivoteWorkService")
public class VoteWorkServiceImpl implements IvoteWorkService {

    @Autowired
    private VoteWorkMapper voteWorkMapper;
    @Autowired
    private VoteMapper voteMapper;

    @Override
    public ServerResponse<String> add(VoteWork voteWork) {
        Date now = new Date();
        Vote vote = voteMapper.selectByPrimaryKey(voteWork.getVoteId());
        if(now.getTime()<vote.getUstartTime().getTime()||now.getTime()>vote.getUendTime().getTime()){
            return ServerResponse.createByErrorMessage("上传作品应该在规定的日期内");
        }
        voteWork.setCreateTime(now);
        voteWork.setIsDelete(ResponseString.UN_DELETE);

        voteWork.setPv(ResponseString.UN_DELETE);
        voteWorkMapper.insert(voteWork);
        return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
    }

    @Override
    public ServerResponse<String> deleteById(Integer id) {
        VoteWork voteWork = voteWorkMapper.selectByPrimaryKey(id);
        if(voteWork==null){
            return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
        }
        voteWork.setIsDelete(ResponseString.IS_DELETE);
        voteWork.setUpdateTime(new Date());
        voteWorkMapper.updateByPrimaryKeySelective(voteWork);
        return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
    }

    @Override
    public ServerResponse<String> update(VoteWork voteWork) {
        voteWorkMapper.updateByPrimaryKeySelective(voteWork);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);    }

    @Override
    public ServerResponse<List<VoteWork>> list(Integer voteId) {
        List<VoteWork> list = voteWorkMapper.selectList(voteId);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<VoteWork> selectById(Integer id) {
        VoteWork voteWork = voteWorkMapper.selectByPrimaryKey(id);
        return ServerResponse.createBySuccess(voteWork);
    }
}

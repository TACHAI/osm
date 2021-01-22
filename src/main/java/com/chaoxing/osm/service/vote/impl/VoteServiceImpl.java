package com.chaoxing.osm.service.vote.impl;

import com.chaoxing.osm.bean.po.vote.Vote;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.vote.VoteMapper;
import com.chaoxing.osm.service.vote.IvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName VoteServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
@Service("ivoteService")
public class VoteServiceImpl implements IvoteService {
    @Autowired
    private VoteMapper voteMapper;

    @Override
    public ServerResponse<String> add(Vote vote) {
        vote.setCreateTime(new Date());
        vote.setIsDelete(ResponseString.UN_DELETE);
        int res =voteMapper.insert(vote);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<String> deleteById(Integer id) {
        Vote vote = voteMapper.selectByPrimaryKey(id);
        if(vote==null){
            return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
        }
        vote.setIsDelete(ResponseString.IS_DELETE);
        voteMapper.updateByPrimaryKeySelective(vote);
        return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
    }

    @Override
    public ServerResponse<String> update(Vote vote) {

        voteMapper.updateByPrimaryKeySelective(vote);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);    }

    @Override
    public ServerResponse<List<Vote>> selectList(String uuid) {
        List<Vote> list = voteMapper.selectList(uuid);

        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<Vote> selectById(Integer id) {
        if(id == null){
            return ServerResponse.createByErrorMessage(ResponseString.PARAMS_IS_EMPTY);
        }
        Vote vote = voteMapper.selectByPrimaryKey(id);
        System.out.println("vote"+id);
        System.out.println("vote"+vote.getName());
        if(vote==null){
            return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
        }
        return ServerResponse.createBySuccess(vote,ResponseString.SELECT_SUCCESS);
    }
}

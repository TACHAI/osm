package com.chaoxing.osm.service.activity.impl;

import com.chaoxing.osm.bean.po.activity.Activity;
import com.chaoxing.osm.bean.po.activity.ActivityUser;
import com.chaoxing.osm.bean.vo.activity.ActivityVO;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.activity.ActivityMapper;
import com.chaoxing.osm.dao.activity.ActivityUserMapper;
import com.chaoxing.osm.service.activity.IactivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ActivityServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
@Service("iactivityService")
public class ActivityServiceImpl implements IactivityService {
    private static final String SUCCESS = "1";

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityUserMapper activityUserMapper;
    @Override
    public ServerResponse<String> add(Activity activity) {
        activity.setIsDelete(ResponseString.UN_DELETE);
        activity.setStatus("0");
        activity.setCreateTime(new Date());
        int res = activityMapper.insert(activity);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createBySuccessMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<List<Activity>> list(String uuid) {

        List<Activity> list = activityMapper.selectList(uuid);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<String> delete(Integer id) {
        Activity activity = activityMapper.selectByPrimaryKey(id);
        if(activity==null){
            return ServerResponse.createByErrorMessage(ResponseString.PARAMS_IS_EMPTY);
        }
        activity.setIsDelete(ResponseString.IS_DELETE);
        int res = activityMapper.updateByPrimaryKeySelective(activity);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
        }
        return ServerResponse.createBySuccessMessage(ResponseString.DELETE_FAIL);
    }

    @Override
    public ServerResponse<String> status(Integer id) {
        Activity activity = activityMapper.selectByPrimaryKey(id);
        if(activity== null){
            return ServerResponse.createByErrorMessage(ResponseString.PARAMS_IS_EMPTY);
        }
        if(SUCCESS.equals(activity.getStatus())){
            activity.setStatus(ResponseString.UN_DELETE+"");
        }else {
            activity.setStatus(ResponseString.IS_DELETE+"");
        }
        activityMapper.updateByPrimaryKeySelective(activity);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
    }

    @Override
    public ServerResponse<List<ActivityVO>> listVO(String uuid) {
        List<Activity> list = activityMapper.selectList(uuid);
        List<ActivityVO> voList = new ArrayList<>(16);
        list.forEach(e->{
            ActivityVO vo = new ActivityVO();
            vo.setId(e.getId());
            vo.setTitle(e.getTitle());
            vo.setAddress(e.getAddress());
            vo.setAuther(e.getAuther());
            vo.setActivitytime(e.getActivitytime());
            vo.setCover(e.getCover());
            vo.setOrganizer(e.getOrganizer());
            vo.setTitle(e.getTitle());
            vo.setDetail(e.getDetail());
            vo.setStatus(e.getStatus());
            List<ActivityUser> userList = activityUserMapper.selectList(e.getId());
            vo.setCount(userList.size());
            voList.add(vo);
        });
        return ServerResponse.createBySuccess(voList);
    }

    @Override
    public ServerResponse<String> update(Activity activity) {
        activityMapper.updateByPrimaryKeySelective(activity);
        return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
    }

    @Override
    public ServerResponse<Activity> selectById(Integer id) {
        Activity activity = activityMapper.selectByPrimaryKey(id);
        return ServerResponse.createBySuccess(activity,ResponseString.SELECT_SUCCESS);
    }
}

package com.chaoxing.osm.service.activity;

import com.chaoxing.osm.bean.po.activity.Activity;
import com.chaoxing.osm.bean.vo.activity.ActivityVO;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @ClassName LiveController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-07
 */
public interface IactivityService {

    ServerResponse<String> add(Activity activity);

    ServerResponse<List<Activity>> list(String uuid);

    ServerResponse<String> delete(Integer id);

    ServerResponse<String> status(Integer id);

    ServerResponse<List<ActivityVO>> listVO(String uuid);

    ServerResponse<String> update(Activity activity);

    ServerResponse<Activity> selectById(Integer id);
}

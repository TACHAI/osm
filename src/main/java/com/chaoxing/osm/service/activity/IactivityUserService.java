package com.chaoxing.osm.service.activity;


import com.chaoxing.osm.bean.po.activity.ActivityUser;
import com.chaoxing.osm.common.ServerResponse;

import java.io.File;
import java.util.List;

/**
 * @ClassName IactivityUserService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
public interface IactivityUserService {

    ServerResponse<String> add(ActivityUser user);

    ServerResponse<List<ActivityUser>> list(Integer activityId);

    File createUserExcelFile(Integer activityId);
}

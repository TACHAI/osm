package com.chaoxing.osm.service.user;

import com.chaoxing.osm.bean.po.user.Unit;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IunitService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-19 9:10
 */
public interface IunitService {
    ServerResponse<String> addUnit(Unit unit);

    ServerResponse<String> deleteUnitById(Integer id);

    ServerResponse<String> deleteUnitByUUID(String uuid);

    ServerResponse<String> updateUnit(Unit unit);

    ServerResponse<Unit> selectByPrimaryKey(Integer id);

    ServerResponse<List<Unit>> selectByName(String name);

    ServerResponse<Unit> selectByUUID(String uuid);

    ServerResponse<List<Unit>> selectAll(String unitName);

    ServerResponse<Map<String,String>> allApps( );
}

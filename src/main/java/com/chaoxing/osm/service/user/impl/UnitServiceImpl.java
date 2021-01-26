package com.chaoxing.osm.service.user.impl;

import com.chaoxing.osm.bean.po.user.Unit;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.config.MyConfig;
import com.chaoxing.osm.dao.user.UnitMapper;
import com.chaoxing.osm.service.user.IunitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UnitServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-19 9:11
 */
@Service("iunitService")
public class UnitServiceImpl implements IunitService {
    @Autowired
    private UnitMapper unitMapper;
    @Autowired
    private MyConfig myConfig;

    @Override
    public ServerResponse<String> addUnit(Unit unit) {
        unit.setCreatDate(new Date());
        unit.setIsDelete(ResponseString.UN_DELETE);
        int res = unitMapper.insert(unit);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<String> deleteUnitById(Integer id) {
        Unit unit = unitMapper.selectByPrimaryKey(id);
        if(unit!=null){
            unit.setIsDelete(ResponseString.IS_DELETE);
            unitMapper.updateByPrimaryKeySelective(unit);
            return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DELETE_FAIL);
    }

    @Override
    public ServerResponse<String> deleteUnitByUUID(String uuid) {
        int res =  unitMapper.deleteByUUID(uuid);
        if(res>0){
            return  ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DELETE_FAIL);
    }

    @Override
    public ServerResponse<String> updateUnit(Unit unit) {
        int res = unitMapper.updateByPrimaryKeySelective(unit);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
    }

    @Override
    public ServerResponse<Unit> selectByPrimaryKey(Integer id) {
        Unit unit = unitMapper.selectByPrimaryKey(id);
        if(unit!=null){
            return ServerResponse.createBySuccess(unit);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }

    @Override
    public ServerResponse<List<Unit>> selectByName(String name) {
        List<Unit> unit = unitMapper.selectByName(name);
        if(unit != null){
            return ServerResponse.createBySuccess(unit);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }

    @Override
    public ServerResponse<Unit> selectByUUID(String uuid) {
        Unit unit = unitMapper.selectByUUID(uuid);
        if(unit!=null){
            return ServerResponse.createBySuccess(unit);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }

    @Override
    public ServerResponse<List<Unit>> selectAll(String  unitName) {
        List<Unit> list = unitMapper.selectAll(unitName);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<Map<String,String>> allApps() {

        return ServerResponse.createBySuccess(myConfig.getApps());
    }
}

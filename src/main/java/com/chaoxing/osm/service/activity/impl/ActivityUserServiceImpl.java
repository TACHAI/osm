package com.chaoxing.osm.service.activity.impl;


import com.chaoxing.osm.bean.po.activity.Activity;
import com.chaoxing.osm.bean.po.activity.ActivityUser;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.activity.ActivityMapper;
import com.chaoxing.osm.dao.activity.ActivityUserMapper;
import com.chaoxing.osm.service.activity.IactivityUserService;
import com.chaoxing.osm.utils.DateUtil;
import com.chaoxing.osm.utils.PoiUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ActivityUserServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-08
 */
@Service("iactivityUserService")
public class ActivityUserServiceImpl implements IactivityUserService {
    @Autowired
    private ActivityUserMapper activityUserMapper;
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public ServerResponse<String> add(ActivityUser user) {

        Integer activityId = user.getActivityId();
        // 判断活动是否下架
        Activity activity = activityMapper.selectByPrimaryKey(activityId);
        if(activity != null&&"1".equalsIgnoreCase(activity.getStatus())){
            return ServerResponse.createByErrorMessage("该活动已下架不能报名");
        }
        // 判断是否已经报名
        ActivityUser done = activityUserMapper.selectByPhone(activityId,user.getPhone());
        if(done != null ){
            return ServerResponse.createByErrorMessage("该用户已报名请勿重复报名");
        }
        user.setCreateTime(new Date());
        user.setIsDelete(ResponseString.UN_DELETE);
        int res = activityUserMapper.insert(user);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<List<ActivityUser>> list(Integer activityId) {
        List<ActivityUser> list = activityUserMapper.selectList(activityId);
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public File createUserExcelFile(Integer activityId) {
        List<ActivityUser> list = activityUserMapper.selectList(activityId);
        String activityName = activityMapper.selectByPrimaryKey(activityId).getTitle();
        System.out.println(activityName);
        return createUserExcelFile(list,activityName);
    }

    public static File createUserExcelFile(List<?> list,String activityName){
        if(list == null){
            list = new ArrayList<> ();
        }
        Workbook workbook = new XSSFWorkbook();
        //创建一个sheet,括号里面可以输入sheet名称，默认为sheet0
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        int columnIndex = 0;
        row0.createCell(columnIndex).setCellValue("No");
        row0.createCell(++columnIndex).setCellValue("用户名");
        row0.createCell(++columnIndex).setCellValue("手机号");
        row0.createCell(++columnIndex).setCellValue("备注");
        row0.createCell(++columnIndex).setCellValue("报名时间");
        for(int i=0;i<list.size();i++){
            ActivityUser user = (ActivityUser) list.get(i);
            Row row = sheet.createRow(i+1);
            for(int j=0;j<columnIndex+1;j++){
                row.createCell(j);
            }
            columnIndex=0;
            row.getCell(columnIndex).setCellValue(i+1);
            row.getCell(++columnIndex).setCellValue(user.getName());
            row.getCell(++columnIndex).setCellValue(user.getPhone());
            row.getCell(++columnIndex).setCellValue(user.getDetail());
            row.getCell(++columnIndex).setCellValue(DateUtil.dateToStr(user.getCreateTime(),DateUtil.DEFAULT_FORMAT));

        }

        return PoiUtils.createExcelFile(workbook,activityName);
    }
}

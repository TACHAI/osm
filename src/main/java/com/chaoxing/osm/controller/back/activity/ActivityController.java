package com.chaoxing.osm.controller.back.activity;

import com.chaoxing.osm.bean.po.activity.Activity;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.AddPermission;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.activity.IactivityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName ActivityController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 11:01
 */
@Api(tags = "ActivityController|活动管理模块")
@RequestMapping("/api/back/activity/")
@RestController
public class ActivityController {

    @Autowired
    private IactivityService activityService;


    @ApiOperation("活动分页")
    @UserLoginToken
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                       @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,
                       @Validated @NotNull(message="单位uuid不能为空")@RequestParam("uuid") String uuid){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        //recommend 100是banner 推荐200
        List<Activity> list =  activityService.list( uuid).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }



    @ApiOperation("添加活动")
    @UserLoginToken
    @AddPermission("activity")
    @PostMapping("addActivity")
    public ServerResponse<String> addActivity(Activity activity){
        return activityService.add(activity);
    }

    @ApiOperation("删除活动")
    @UserLoginToken
    @GetMapping("delActivity")
    public ServerResponse<String> delActivity(@Validated @NotNull(message="活动id不能为空")@RequestParam("id") Integer id){
        return activityService.delete(id);
    }

    @ApiOperation("修改活动")
    @UserLoginToken
    @PostMapping("updateActivity")
    public ServerResponse<String> update(Activity activity){
        return activityService.update(activity);
    }

    @ApiOperation("上下架")
    @GetMapping("status")
    public ServerResponse<String> status(@Validated @NotNull(message="活动id不能为空")@RequestParam("id")Integer id){
        return activityService.status(id);
    }


}

package com.chaoxing.osm.controller.fore;

import com.chaoxing.osm.bean.po.activity.Activity;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
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
 * @ClassName ActivityForeController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 15:45
 */
@Api(tags = "ActivityForeController|前端活动管理模块")
@RequestMapping("/api/fore/activity/")
@RestController
public class ActivityForeController {
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

    @ApiOperation("活动详情")
    @PostMapping("selectById")
    public ServerResponse<Activity> selectById(Integer id){
        return activityService.selectById(id);
    }
}

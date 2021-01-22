package com.chaoxing.osm.controller.back.activity;

import com.chaoxing.osm.bean.po.activity.ActivityUser;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.activity.IactivityUserService;
import com.chaoxing.osm.utils.FileUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * @ClassName ActivityUserController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 15:48
 */
@Api(value="活动用户接口",tags = {"活动用户接口"})
@RestController
@RequestMapping("/api/back/activityuser/")
public class ActivityUserController {

    @Autowired
    private IactivityUserService iactivityUserService;


    @ApiOperation("用户分页")
    @UserLoginToken
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber, Integer activityId){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        //recommend 100是banner 推荐200
        List<ActivityUser> list =  iactivityUserService.list(activityId).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }

    @ApiOperation("新增活动用户")
    @UserLoginToken
    @PostMapping("add")
    public ServerResponse<String> add(@Validated ActivityUser user){
        return iactivityUserService.add(user);
    }


    @ApiOperation("导出报名用户花名册excel")
    @UserLoginToken
    @GetMapping(value="/exportExcelUser")
    public void exportExcelUser(Integer activityId, HttpServletResponse res) {
        File file = iactivityUserService.createUserExcelFile(activityId);
        FileUtil.downloadFile(res, file, file.getName());
    }
}

package com.chaoxing.osm.controller.back;

import com.chaoxing.osm.bean.po.live.BackLive;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.live.LiveReservationMapper;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.live.IliveService;
import com.chaoxing.osm.service.live.impl.BackLiveServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BackLiveController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 15:19
 */

@Api(value="直播推流地址接口",tags = {"直播推流地址接口"})
@RestController
@RequestMapping("/api/back/backlive/")
public class BackLiveController {

    @Autowired
    private BackLiveServiceImpl backLiveServiceImpl;



    @ApiOperation("后端直播信息分页")
    @UserLoginToken
    @GetMapping("backlistByPage")
    public PageVO backlist(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber, String liveName,String uuid){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<BackLive> list =  backLiveServiceImpl.selectList(liveName,uuid).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }

    @UserLoginToken
    @GetMapping("getBackLiveById")
    public ServerResponse<BackLive> selectById(Integer id){
        return backLiveServiceImpl.selectById(id);
    }

}

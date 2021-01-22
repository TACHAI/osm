package com.chaoxing.osm.controller.back;

import com.chaoxing.osm.bean.po.live.Live;
import com.chaoxing.osm.bean.po.live.LiveReservation;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.bean.vo.live.LiveVO;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.live.LiveReservationMapper;
import com.chaoxing.osm.security.AddPermission;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.live.IliveService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName LiveController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 15:30
 */

@Api(value="直播推流地址接口",tags = {"直播推流地址接口"})
@RestController
@RequestMapping("/api/back/live/")
public class LiveController {

    @Autowired
    private IliveService iliveService;
    @Autowired
    private LiveReservationMapper liveMapper;

    @ApiOperation("后端直播分页")
    @GetMapping("backlistByPage")
    public PageVO backlist(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber, String liveName,String uuid){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<LiveVO> list =  iliveService.selectList(liveName,uuid).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }





    @ApiOperation("直播新增接口")
    @UserLoginToken
    @AddPermission("live")
    @PostMapping("add")
    public ServerResponse<String> add(@Validated Live live){
        return iliveService.add(live);
    }

    @ApiOperation("直播修改接口")
    @UserLoginToken
    @PostMapping("update")
    public ServerResponse<String> update(Live live){
        return iliveService.update(live);
    }


    @ApiOperation("直播预告修改")
    @UserLoginToken
    @PostMapping("updateLiveReservation")
    public ServerResponse <String>updateLiveReservation (LiveReservation liveReservation){
        int res = liveMapper.updateByPrimaryKeySelective(liveReservation);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
        }else {
            return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
        }
    }

    @ApiOperation("直播删除")
    @UserLoginToken
    @PostMapping("delete")
    public ServerResponse<String> deleteById(Integer id){
        return iliveService.deleteById(id);
    }

}

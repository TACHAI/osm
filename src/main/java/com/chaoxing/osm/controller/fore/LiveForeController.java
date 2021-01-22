package com.chaoxing.osm.controller.fore;

import com.chaoxing.osm.bean.po.live.Live;
import com.chaoxing.osm.bean.po.live.LiveReservation;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.bean.vo.live.LiveVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.live.LiveReservationMapper;
import com.chaoxing.osm.service.live.IliveService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName LiveForeController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 15:33
 */
@Api(value="直播推流地址接口",tags = {"前端直播推流地址接口"})
@RestController
@RequestMapping("/api/fore/live/")
public class LiveForeController {
    @Autowired
    private IliveService iliveService;
    @Autowired
    private LiveReservationMapper liveMapper;

    @ApiOperation("前端直播分页")
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber, String userId, String liveName, String uuid){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        //recommend 100是banner 推荐200
        List<LiveVO> list =  iliveService.selectList(userId,liveName,uuid).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }

    @ApiOperation("记录浏览记录")
    @PostMapping("view")
    public ServerResponse<Live> view(Integer id){
        return iliveService.view( id);
    }

    @ApiOperation("id单个live")
    @GetMapping("selectById")
    public ServerResponse<LiveVO> selectById(Integer id){
        return iliveService.selectById(id);
    }

    // 查看最新的直播是否正在直播
    @ApiOperation("正在直播")
    @GetMapping("living")
    public ServerResponse < Live> living(){
        return iliveService.living();
    }
    // 直播预告还要做
    @ApiOperation("直播预告")
    @GetMapping("liveReservation")
    public ServerResponse <LiveReservation> getLive(){
        LiveReservation live = liveMapper.selectByPrimaryKey(1);
        return ServerResponse.createBySuccess(live);
    }

}

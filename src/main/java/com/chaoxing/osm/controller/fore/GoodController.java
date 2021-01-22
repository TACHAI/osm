package com.chaoxing.osm.controller.fore;

import com.chaoxing.osm.bean.po.live.Good;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.live.GoodMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName GoodController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 15:38
 */
@Api(value="直播点赞接口",tags = {"直播点赞接口"})
@RestController
@RequestMapping("/api/fore/live/good/")
public class GoodController {
    @Autowired
    private GoodMapper goodMapper;


    @PostMapping("click")
    public ServerResponse<String> click(Integer liveId){
        // Good good = goodMapper.selectByUserIdAndLiveId(userId,liveId);
        Good good = new Good();
        good.setLiveId(liveId);
        //good.setUserId(userId);
        good.setCreateTime(new Date());
        good.setStatus(ResponseString.UN_DELETE);
        goodMapper.insert(good);
        return ServerResponse.createBySuccessMessage("点赞成功");
    }
}

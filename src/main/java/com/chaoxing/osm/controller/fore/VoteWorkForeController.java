package com.chaoxing.osm.controller.fore;

import com.chaoxing.osm.service.vote.IvoteWorkService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VoteWorkForeController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 15:14
 */
@Api(value = "投票作品接口",tags = {"前端投票作品接口"})
@RestController
@RequestMapping("/api/fore/votework/")
public class VoteWorkForeController {
    @Autowired
    private IvoteWorkService voteWorkService;
}

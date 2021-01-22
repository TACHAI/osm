package com.chaoxing.osm.controller.fore;

import com.chaoxing.osm.bean.po.vote.VoteUser;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.service.vote.IvoteUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName VoteUserForeController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 15:12
 */
@Api(value="投票-前端用户接口",tags = {"投票-前端用户接口"})
@RequestMapping("/api/fore/voteuser/")
@RestController
public class VoteUserForeController {
    @Autowired
    private IvoteUserService voteUserService;

    @ApiOperation("投票-用户新增接口")
    @PostMapping("add")
    public ServerResponse<String> add(@Validated VoteUser voteUser){
        return voteUserService.add(voteUser);
    }
}

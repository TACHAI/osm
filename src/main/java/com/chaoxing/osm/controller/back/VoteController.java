package com.chaoxing.osm.controller.back;

import com.chaoxing.osm.bean.po.vote.Vote;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.AddPermission;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.vote.IvoteService;
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
 * @ClassName VoteController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 14:21
 */
@Api(tags = "VoteController|投票管理模块")
@RequestMapping("/api/back/vote/")
@RestController
public class VoteController {

    @Autowired
    private IvoteService voteService;

    @ApiOperation("投票分页")
    @UserLoginToken
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                       @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,
                       @Validated @NotNull(message="单位uuid不能为空")@RequestParam("uuid") String uuid){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<Vote> list =  voteService.selectList(uuid).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }


    @ApiOperation("投票新增接口")
    @UserLoginToken
    @AddPermission("vote")
    @PostMapping("add")
    public ServerResponse<String> add(@Validated Vote vote){
        return voteService.add(vote);
    }


    @ApiOperation("投票删除接口")
    @UserLoginToken
    @PostMapping("deleteById")
    public ServerResponse<String> deleteById(Integer id){
        return voteService.deleteById(id);
    }

    @ApiOperation("投票修改接口")
    @UserLoginToken
    @PostMapping("update")
    public ServerResponse<String> update(Vote vote){
        return voteService.update(vote);
    }

    @ApiOperation("投票详情接口")
    @UserLoginToken
    @PostMapping("selectById")
    public ServerResponse<Vote> selectById(Integer id){
        return voteService.selectById(id);
    }


}

package com.chaoxing.osm.controller.back;

import com.chaoxing.osm.bean.po.vote.VoteWork;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.vote.IvoteWorkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName VoteWorkController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 14:43
 */
@Api(value = "投票作品接口",tags = {"投票作品接口"})
@RestController
@RequestMapping("/api/back/votework/")
public class VoteWorkController {
    @Autowired
    private IvoteWorkService voteWorkService;


    @ApiOperation("投票作品分页接口")
    @UserLoginToken
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber, Integer voteId){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        //recommend 100是banner 推荐200
        List<VoteWork> list =  voteWorkService.list(voteId).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }


    @ApiOperation("投票作品新增接口")
    @UserLoginToken
    @PostMapping("add")
    public ServerResponse<String> add(@Validated VoteWork voteWork){
        return voteWorkService.add(voteWork);
    }

    @ApiOperation("投票作品详情接口")
    @UserLoginToken
    @PostMapping("selectById")
    public ServerResponse<VoteWork> selectById(Integer id){
        return voteWorkService.selectById(id);
    }

    @ApiOperation("投票作品修改接口")
    @UserLoginToken
    @PostMapping("update")
    public ServerResponse<String> update(VoteWork voteWork){
        return voteWorkService.update(voteWork);
    }

    @ApiOperation("投票作品删除接口")
    @UserLoginToken
    @PostMapping("deleteById")
    public ServerResponse<String> deleteById(Integer id){
        return voteWorkService.deleteById(id);
    }
}

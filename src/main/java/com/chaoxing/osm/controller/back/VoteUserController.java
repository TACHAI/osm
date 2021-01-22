package com.chaoxing.osm.controller.back;

import com.chaoxing.osm.bean.po.vote.VoteUser;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.vote.IvoteUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName VoteUserController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 14:43
 */
@Api(value="投票-用户接口",tags = {"投票-用户接口"})
@RequestMapping("/api/back/voteuser/")
@RestController
public class VoteUserController {
    @Autowired
    private IvoteUserService voteUserService;

    @ApiOperation("投票分页")
    @UserLoginToken
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber, Integer voteId){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<VoteUser> list =  voteUserService.selectListByVoteId(voteId).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }

}

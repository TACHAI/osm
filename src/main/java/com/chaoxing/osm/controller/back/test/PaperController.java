package com.chaoxing.osm.controller.back.test;

import com.chaoxing.osm.bean.po.test.Paper;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.AddPermission;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.test.IpaperService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PaperController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Api(value = "试卷接口",tags = {"试卷接口"})
@RestController
@RequestMapping("/api/back/paper/")
public class PaperController {
    @Autowired
    private IpaperService ipaperService;

    @ApiOperation("后端试卷分页")
    @UserLoginToken
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,String uuid){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        //recommend 100是banner 推荐200
        List<Paper> list =  ipaperService.list(uuid).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }

    @ApiOperation("新增试卷接口")
    @UserLoginToken
    @AddPermission("paper")
    @PostMapping("add")
    public ServerResponse<String> add(@Validated Paper paper){
        return ipaperService.add(paper);
    }

    @ApiOperation("删除试卷接口")
    @UserLoginToken
    @PostMapping("deleteById")
    public ServerResponse <String> delete(Integer id){
        return ipaperService.deleteById(id);
    }

    @ApiOperation("修改试卷接口")
    @UserLoginToken
    @PostMapping("update")
    public ServerResponse<String> update(Paper paper){
        return ipaperService.update(paper);
    }

    @ApiOperation("上下架")
    @UserLoginToken
    @GetMapping("status")
    public ServerResponse<String> status(Integer id){
        return ipaperService.status(id);
    }
}

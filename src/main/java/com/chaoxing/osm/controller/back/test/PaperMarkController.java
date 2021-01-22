package com.chaoxing.osm.controller.back.test;

import com.chaoxing.osm.bean.dto.test.PaperMarkDTO;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.bean.vo.test.PaperMarkVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.test.IpaperMarkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PaperMarkController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Api(value = "考试成绩排行",tags = {"考试成绩排行"})
@RestController
@RequestMapping("/api/back/papermark/")
public class PaperMarkController {

    @Autowired
    private IpaperMarkService ipaperMarkService;

    @ApiOperation("成绩排行")
    @UserLoginToken
    @GetMapping("order")
    public ServerResponse<PaperMarkVO> list(Integer paperId, Integer userId){
        return ipaperMarkService.listByPaperId(paperId,userId);
    }

    @ApiOperation("成绩分页")
    @UserLoginToken
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,Integer paperId){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        //recommend 100是banner
        // 推荐200
        List<PaperMarkDTO> list =  ipaperMarkService.listAllByPaperId(paperId).getData();
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

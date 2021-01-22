package com.chaoxing.osm.controller.fore;

import com.chaoxing.osm.bean.dto.test.PaperDTO;
import com.chaoxing.osm.bean.po.test.Paper;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.bean.vo.test.PaperVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.service.test.IpaperQuestionService;
import com.chaoxing.osm.service.test.IpaperService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PaperForeController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2021-01-22 16:18
 */
@Api(value = "前端试卷接口",tags = {"前端试卷接口"})
@RestController
@RequestMapping("/api/fore/paper/")
public class PaperForeController {

    @Autowired
    private IpaperService ipaperService;
    @Autowired
    private IpaperQuestionService ipaperQuestionService;
    @ApiOperation("提交试卷")

    @PostMapping(value = "finishJob", produces = "application/json;charset=UTF-8")
    public ServerResponse<String> finishJob(@RequestBody PaperDTO paperDTO){
        // 直接将json信息打印出来
        return  ipaperService.finishJob(paperDTO);
    }


    @ApiOperation("试卷题目列表")
    @GetMapping("list")
    public ServerResponse<PaperVO> listQuestion(Integer paperId){
        return ipaperQuestionService.listQuestionByPaperId(paperId);
    }

    @ApiOperation("前端试卷分页")
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,String uuid){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        //recommend 100是banner 推荐200
        List<Paper> list =  ipaperService.foreList(uuid).getData();
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

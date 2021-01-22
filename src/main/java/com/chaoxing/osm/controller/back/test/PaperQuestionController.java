package com.chaoxing.osm.controller.back.test;

import com.chaoxing.osm.bean.po.test.PaperQuestion;
import com.chaoxing.osm.bean.vo.PageVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.test.IpaperQuestionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName PaperQuestionController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Api(value = "试卷题目接口",tags = {"试卷题目接口"})
@RestController
@RequestMapping("/api/back/paperquestion/")
public class PaperQuestionController {

    @Autowired
    private IpaperQuestionService ipaperQuestionService;

    @ApiOperation("试卷题目")
    @UserLoginToken
    @GetMapping("listByPage")
    public PageVO list(@RequestParam(value = "pageSize",defaultValue = "5")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber,Integer paperId){

        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<PaperQuestion> list =  ipaperQuestionService.listByPaperId(paperId).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }




    @ApiOperation("试卷题目添加")
    @PostMapping("add")
    public ServerResponse<String> add(@Validated PaperQuestion paperQuestion){
        return ipaperQuestionService.add(paperQuestion);
    }

    @ApiOperation("试卷题目删除")
    @PostMapping("deleteById")
    public ServerResponse<String> deleteById(Integer id){
        return ipaperQuestionService.delete(id);
    }

    @ApiOperation("试卷题目修改")
    @PostMapping("update")
    public ServerResponse<String> update(PaperQuestion paperQuestion){
        return ipaperQuestionService.update(paperQuestion);
    }


    @ApiOperation("试卷题目导入")
    @PostMapping("import")
    public ServerResponse<String> importQuestion(Integer paperId,@RequestParam("file") MultipartFile file){
        return ipaperQuestionService.importQuestion(paperId,file);
    }
}

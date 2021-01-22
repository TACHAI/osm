package com.chaoxing.osm.controller.back.test;

import com.chaoxing.osm.bean.po.test.PaperAnswer;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.test.IpaperAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PaperAnswerController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Api(value = "试卷答案接口",tags ={"试卷答案接口"})
@RestController
@RequestMapping("/api/back/paperanswer/")
public class PaperAnswerController {
    @Autowired
    private IpaperAnswerService ipaperAnswerService;

    @ApiOperation("试卷答案")
    @UserLoginToken
    @GetMapping("list")
    public ServerResponse< List<PaperAnswer>> list(Integer questionId){
        return ipaperAnswerService.listByPaperQuestionId(questionId);
    }


   @ApiOperation("试卷答案添加")
   @UserLoginToken
   @PostMapping("add")
    public ServerResponse<String> add(@Validated  PaperAnswer paperAnswer){
       return ipaperAnswerService.add(paperAnswer);
    }

    @ApiOperation("试卷答案修改")
    @UserLoginToken
    @PostMapping("update")
    public ServerResponse<String>update(PaperAnswer paperAnswer){
        return ipaperAnswerService.update(paperAnswer);
    }

    @ApiOperation("试卷答案删除")
    @UserLoginToken
    @PostMapping("deleteById")
    public ServerResponse<String> delete(Integer id){
        return ipaperAnswerService.delete(id);
    }
}

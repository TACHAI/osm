package com.chaoxing.osm.controller.back.test;

import com.chaoxing.osm.bean.vo.test.DonePaperVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.security.UserLoginToken;
import com.chaoxing.osm.service.test.IPaperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaperLogController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-12-04 10:51
 */
@Api(value = "答卷内容接口",tags = {"答卷内容接口"})
@RestController
@RequestMapping("/api/back/paperLog/")
public class PaperLogController {
    @Autowired
    private IPaperLogService paperLogService;


    @ApiOperation("获取答卷")
    @UserLoginToken
    @GetMapping("getPaperLog")
    public ServerResponse<DonePaperVO> list(Integer paperId, Integer userId){
        return  paperLogService.getByUserIdAndPaperId(userId,paperId);
    }

}

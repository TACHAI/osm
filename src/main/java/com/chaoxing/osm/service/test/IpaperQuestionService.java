package com.chaoxing.osm.service.test;


import com.chaoxing.osm.bean.po.test.PaperQuestion;
import com.chaoxing.osm.bean.vo.test.PaperVO;
import com.chaoxing.osm.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName LiveController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-07
 */
public interface IpaperQuestionService {

    ServerResponse<List<PaperQuestion>> listByPaperId(Integer paperId);

    ServerResponse<String> add(PaperQuestion paperQuestion);

    ServerResponse<String> delete(Integer id);

    ServerResponse<String> update(PaperQuestion paperQuestion);

    ServerResponse<PaperVO> listQuestionByPaperId(Integer paperId);

    ServerResponse<String> importQuestion(Integer paperId, MultipartFile file);
}

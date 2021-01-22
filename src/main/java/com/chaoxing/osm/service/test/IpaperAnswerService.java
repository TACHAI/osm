package com.chaoxing.osm.service.test;

import com.chaoxing.osm.bean.po.test.PaperAnswer;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @ClassName IpaperAnswerService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
public interface IpaperAnswerService {

    ServerResponse<List<PaperAnswer>> listByPaperQuestionId(Integer questionId);

    ServerResponse <String> add(PaperAnswer paperAnswer);

    ServerResponse<String> delete(Integer id);

    ServerResponse <String> update(PaperAnswer paperAnswer);

}

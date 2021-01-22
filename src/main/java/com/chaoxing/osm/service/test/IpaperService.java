package com.chaoxing.osm.service.test;

import com.chaoxing.osm.bean.dto.test.PaperDTO;
import com.chaoxing.osm.bean.po.test.Paper;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @ClassName IpaperService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
public interface IpaperService {

    ServerResponse<List<Paper>> foreList(String uuid);

    ServerResponse<List<Paper>> list(String uuid);

    ServerResponse<String> add(Paper paper);

    ServerResponse<String> deleteById(Integer id);

    ServerResponse<String> update(Paper paper);

    ServerResponse<String> finishJob(PaperDTO paperDTO);

    ServerResponse<String> status(Integer id);
}

package com.chaoxing.osm.service.test;

import com.chaoxing.osm.bean.dto.test.PaperMarkDTO;
import com.chaoxing.osm.bean.vo.test.PaperMarkVO;
import com.chaoxing.osm.common.ServerResponse;

import java.util.List;

/**
 * @ClassName IpaperMarkService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
public interface IpaperMarkService {

    ServerResponse<PaperMarkVO> listByPaperId(Integer paperId, Integer usrId);
    ServerResponse<List<PaperMarkDTO>> listAllByPaperId(Integer paperId);

}

package com.chaoxing.osm.service.test;

import com.chaoxing.osm.bean.po.test.PaperLog;
import com.chaoxing.osm.bean.vo.test.DonePaperVO;
import com.chaoxing.osm.common.ServerResponse;

/**
 * @ClassName IPaperLogService
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-12-04 10:11
 */
public interface IPaperLogService {
    ServerResponse<String> add(PaperLog log);

    ServerResponse<DonePaperVO> getByUserIdAndPaperId(Integer userId, Integer paperId);
}

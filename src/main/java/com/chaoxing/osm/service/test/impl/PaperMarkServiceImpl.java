package com.chaoxing.osm.service.test.impl;

import com.chaoxing.osm.bean.dto.test.PaperMarkDTO;
import com.chaoxing.osm.bean.po.test.PaperMark;
import com.chaoxing.osm.bean.po.user.WxUser;
import com.chaoxing.osm.bean.vo.test.PaperMarkVO;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.test.PaperMarkMapper;
import com.chaoxing.osm.dao.user.WxUserMapper;
import com.chaoxing.osm.service.test.IpaperMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PaperMarkServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-09
 */
@Service("ipaperMarkService")
public class PaperMarkServiceImpl implements IpaperMarkService {
    @Autowired
    private PaperMarkMapper paperMarkMapper;
    @Autowired
    private WxUserMapper wxUserMapper;

    @Override
    public ServerResponse<PaperMarkVO> listByPaperId(Integer paperId, Integer userId) {
        PaperMarkVO vo = new PaperMarkVO();
        PaperMark pm = paperMarkMapper.selectByPaperIdAndUserId(paperId,userId);
        WxUser user = wxUserMapper.selectByPrimaryKey(userId);
        if(user != null){
            vo.setUserName(user.getPickname());
            if(pm.getMark()==null){
                vo.setMark(0);
            }else {
                vo.setMark(pm.getMark());
            }
            vo.setHeadimgurl(user.getHeadimgurl());
        }

        List<PaperMarkDTO> list = paperMarkMapper.selectByPaperId(paperId);
        vo.setData(list);
        return ServerResponse.createBySuccess(vo);
    }

    @Override
    public ServerResponse<List<PaperMarkDTO>> listAllByPaperId(Integer paperId) {
        List<PaperMarkDTO> list = paperMarkMapper.selectOrderByPaperId(paperId);

        return ServerResponse.createBySuccess(list);
    }

}

package com.chaoxing.osm.service.live.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chaoxing.osm.bean.po.live.BackLive;
import com.chaoxing.osm.bean.po.live.Live;
import com.chaoxing.osm.bean.po.live.Good;
import com.chaoxing.osm.bean.vo.live.LiveVO;
import com.chaoxing.osm.common.ResponseString;
import com.chaoxing.osm.common.ServerResponse;
import com.chaoxing.osm.dao.live.BackLiveMapper;
import com.chaoxing.osm.dao.live.LiveMapper;
import com.chaoxing.osm.dao.live.GoodMapper;
import com.chaoxing.osm.service.live.IliveService;
import com.chaoxing.osm.utils.HttpUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName LiveServiceImpl
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-05-07
 */
@Service("iliveService")
public class LiveServiceImpl implements IliveService {
    private static final String SUCCESS = "1";

    private static String anchorId;
    private static String sourceKey;
    private static String source;
    private static String schoolId;

    @Value("${live.anchorId}")
    public void setAnchorId(String anchorId){
        LiveServiceImpl.anchorId=anchorId;
    }

    @Value("${live.sourceKey}")
    public void setSourceKey(String sourceKey){
        LiveServiceImpl.sourceKey=sourceKey;
    }

    @Value("${live.source}")
    public void setSource(String source){
        LiveServiceImpl.source=source;
    }

    @Value("${live.schoolId}")
    public void setSchoolId(String schoolId){
        LiveServiceImpl.schoolId=schoolId;
    }


    @Autowired
    private LiveMapper liveMapper;

    @Autowired
    private BackLiveMapper backLiveMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public ServerResponse<String> add(Live live) {
        BackLive back = new BackLive();

        String introduce = live.getIntroduction();
        try {
            introduce = URLEncoder.encode(introduce, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String url = "https://zhibo.chaoxing.com/apis/live/serverCreateLive?title=" + live.getTitle().trim() + "&introduce="
                + introduce + "&source=" + source + "&sourceKey="
                + sourceKey + "&anchorId=" + anchorId + "&ifreview=" + live.getReplay();
        String result = HttpUtil.doGet(url).getData();

        JSONObject job = JSON.parseObject(result);

        String results = job.getString("result");
        if (SUCCESS.endsWith(results)) {
            // 保存live
            live.setPv(0);
            live.setStatus(0);
            live.setCreateTime(new Date());
            live.setIsDelete(ResponseString.UN_DELETE);
            liveMapper.insert(live);
            JSONObject data = (JSONObject) job.get("data");
            String liveIntroduce = data.getString("liveIntroduce");
            String viewerName = data.getString("ViewerName");
            String thumb = data.getString("thumb");
            String liveTitle = data.getString("liveTitle");
            String type = data.getString("type");
            String userName=data.getString("userName");
            String primaryId = data.getString("primaryId");
            String pageNum = data.getString("pageNum");
            String streamName = data.getString("streamName");
            JSONObject pullUrl = (JSONObject) data.get("pullUrl");
            String rtmpPullUrl = pullUrl.getString("rtmpPullUrl");
            String originalPullUrl = pullUrl.getString("originalPullUrl");
            String streamNameAlone = data.getString("streamNameAlone");
            String vdoid = data.getString("vdoid");
            String modeType = data.getString("modeType");
            String pushUrl = data.getString("pushUrl");
            JSONObject downUrl = (JSONObject) data.get("downUrl");
            String mp4Url = downUrl.getString("mp4Url");
            String m3u8Url = downUrl.getString("m3u8Url");
            String puid = data.getString("puid");
            String chatRoomId = data.getString("chatRoomId");
            String iconUrl = data.getString("iconUrl");
            String ifreview = data.getString("ifreview");
            back.setId(live.getId());
            back.setMp4Address(mp4Url);
            back.setReplay(Integer.parseInt(ifreview));
            back.setIntroduction(liveIntroduce);
            back.setTitle(liveTitle);
            back.setM3u8Address(m3u8Url);
            back.setM3u8PullAddress(originalPullUrl);
            back.setStramId(vdoid);
            back.setPushStramAddress(pushUrl);
            back.setRtmpPullAddress(rtmpPullUrl);
            back.setVideoStreamName(streamName);
            // fileAddress存直播数据数据主键
            back.setFileAddress(primaryId);
            // pullStreamAddress存放 没有拼接过的流名称  这个字段要用来查询列表
            back.setPullStreamAddress(streamNameAlone);
            back.setIntroduction(live.getIntroduction());
            back.setAddress(live.getAddress());
            back.setCreateTime(new Date());
            back.setIsDelete(ResponseString.UN_DELETE);
            back.setUpdateTime(new Date());
            backLiveMapper.insert(back);
            return ServerResponse.createBySuccess(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);

    }

    @Override
    public ServerResponse<String> update(Live live) {
        int res =liveMapper.updateByPrimaryKeySelective(live);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
    }

    @Override
    public ServerResponse<List<LiveVO>> selectList(String userId, String liveName,String uuid) {
        List<Live> list = liveMapper.selectListfore(liveName,uuid);
        List<LiveVO> listVO = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            LiveVO vo = new LiveVO();
            BackLive backLive = backLiveMapper.selectByPrimaryKey(list.get(i).getId());
            BeanUtils.copyProperties(list.get(i),vo);
            List<Good> goods = goodMapper.selectGoogByLiveId(list.get(i).getId());
            vo.setM3u8Address(backLive.getM3u8Address());
            vo.setM3u8PullAddress(backLive.getM3u8PullAddress());
            vo.setMp4Address(backLive.getMp4Address());
            vo.setGood(goods.size());
            listVO.add(vo);
        }
        return ServerResponse.createBySuccess(listVO);
    }

    @Override
    public ServerResponse<List<LiveVO>> selectList(String liveName,String uuid) {
        List<Live> list = liveMapper.selectList(liveName,uuid);
        List<LiveVO> listVO = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            LiveVO vo = new LiveVO();
            BeanUtils.copyProperties(list.get(i),vo);
            listVO.add(vo);
        }
        return ServerResponse.createBySuccess(listVO);    }

    @Override
    public ServerResponse<Live> view(Integer id) {
        Live live = liveMapper.selectByPrimaryKey(id);
        if(live!=null){
            int sum = live.getPv();
            sum++;
            live.setPv(sum);
            liveMapper.updateByPrimaryKeySelective(live);
            return ServerResponse.createBySuccess(live);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }

    @Override
    public ServerResponse<LiveVO> selectById(Integer id) {
        Live live = liveMapper.selectByPrimaryKey(id);
        if(live!=null){
            List<Good> list =goodMapper.selectGoogByLiveId(id);
            LiveVO vo =  new LiveVO();
            BackLive back = backLiveMapper.selectByPrimaryKey(id);
            BeanUtils.copyProperties(live,vo);

            vo.setGood(list.size());
            vo.setMp4Address(back.getMp4Address());
            vo.setM3u8PullAddress(back.getM3u8PullAddress());
            vo.setM3u8Address(back.getM3u8Address());
            vo.setMp4Address(back.getMp4Address());
            return ServerResponse.createBySuccess(vo);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }

    @Override
    public ServerResponse<Live> living() {
        List<Live> list = liveMapper.selectList(null,null);
        if(list.size()>0){
            Live live = list.get(0);
            BackLive back = backLiveMapper.selectByPrimaryKey(live.getId());
            //String url = "https://zhibo.chaoxing.com/apis/live/getStatisticsOfOne?streamName=" + back.getVideoStreamName()+"&vdoid="+back.getStramId()+"&schoolId="+schoolId;

            String url ="https://live.superlib.com/zhibo/getLiveDetail?streamName="+back.getPullStreamAddress()+"&vdoid="+back.getStramId();
            String result = HttpUtil.doGet(url).getData();

            JSONObject job = JSON.parseObject(result);

            String status = job.getJSONObject("description").getString("liveStatus");
            // 获取直播的状态 0 未开始 1进行中，3中断，4已结束
            if("0".equals(status)){
                return ServerResponse.createByErrorMessage("还未开始直播");
            }else if("1".equals(status)) {
                int pv= job.getIntValue("watcherNum");
                live.setPv(pv);
                live.setVideo(back.getM3u8PullAddress());
                return ServerResponse.createBySuccess(live);
            }else {
                return ServerResponse.createByErrorMessage("直播已结束");
            }
        }
        return ServerResponse.createByErrorMessage("还未开始直播");
    }

    @Override
    public ServerResponse<String> deleteById(Integer id) {
        Live live = liveMapper.selectByPrimaryKey(id);
        if(live!=null){
            live.setIsDelete(ResponseString.IS_DELETE);
            liveMapper.updateByPrimaryKeySelective(live);
        }
        return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
    }
}

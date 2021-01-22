package com.chaoxing.osm.dao.live;

import com.chaoxing.osm.bean.po.live.LiveReservation;

public interface LiveReservationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LiveReservation record);

    int insertSelective(LiveReservation record);

    LiveReservation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LiveReservation record);

    int updateByPrimaryKey(LiveReservation record);
}
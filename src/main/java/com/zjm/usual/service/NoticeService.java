package com.zjm.usual.service;

import com.zjm.usual.bean.Notice;

import java.util.List;

/**
 * @program: PMS
 * @description: 通知公告接口
 * @author: Mr.
 * @create: 2019-04-11 19:02
 **/
public interface NoticeService {
    void seaveInfo(Notice notice);

    List<Notice> showAll();

    Notice infoByNid(Integer nid);
}

package com.zjm.usual.service;

import com.zjm.usual.bean.Notice;
import com.zjm.usual.bean.NoticeExample;
import com.zjm.usual.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PMS
 * @description: 通知公告实现类
 * @author: Mr.
 * @create: 2019-04-11 19:02
 **/
@Service
public class NoticeServiceImlp implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public void seaveInfo(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public List<Notice> showAll() {
        NoticeExample noticeExample=new NoticeExample();
        noticeExample.setOrderByClause("ndate desc limit 0,3");
        return noticeMapper.selectByExample(noticeExample);
    }

    @Override
    public Notice infoByNid(Integer nid) {
        return noticeMapper.selectByPrimaryKey(nid);
    }
}

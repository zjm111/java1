package com.zjm.usual.service;

import com.zjm.usual.bean.TieZi;
import com.zjm.usual.mapper.TieZiMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PMS
 * @description: 帖子实现类
 * @author: Mr.
 * @create: 2019-04-15 19:46
 **/
@Service
public class TieZiServiceImpl implements TieZiService{

    @Resource
    private TieZiMapper tieZiMapper;

    public void seaveInfo(TieZi tieZi) {
        tieZiMapper.seaveInfo(tieZi);
    }

    public List<TieZi> tzlist() {
        return tieZiMapper.tzlist();
    }
}

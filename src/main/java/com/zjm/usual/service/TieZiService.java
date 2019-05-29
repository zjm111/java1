package com.zjm.usual.service;

import com.zjm.usual.bean.TieZi;

import java.util.List;

/**
 * @program: PMS
 * @description: 帖子接口
 * @author: Mr.
 * @create: 2019-04-15 19:46
 **/
public interface TieZiService {
    void seaveInfo(TieZi tieZi);

    List<TieZi> tzlist();
}

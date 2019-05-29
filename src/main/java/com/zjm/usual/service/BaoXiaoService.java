package com.zjm.usual.service;

import com.github.pagehelper.PageInfo;
import com.zjm.usual.bean.Baoxiao;

import java.util.Map;

/**
 * @program: PMS
 * @description: 报销接口
 * @author: Mr.
 * @create: 2019-04-10 17:52
 **/
public interface BaoXiaoService {
    boolean saveInfo(Baoxiao baoxiao);

    PageInfo<Baoxiao> getBaoXiaoList(String pageNum, Map<String,Object> paramMap);

    Baoxiao genggai(String bxid);

    boolean genggai1(Baoxiao baoxiao);
}

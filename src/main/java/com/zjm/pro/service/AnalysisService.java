package com.zjm.pro.service;

import com.zjm.pro.bean.Analysis;

import java.util.List;

/**
 * @program: PMS
 * @description: 需求分析接口
 * @author: Mr.
 * @create: 2019-04-08 19:01
 **/
public interface AnalysisService {
    boolean saveInfo(Analysis analysis);

    Analysis getAnalyseWithId(Integer pid);

    List<Analysis> anlist();
}

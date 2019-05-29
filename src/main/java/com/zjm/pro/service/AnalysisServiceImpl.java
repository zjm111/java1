package com.zjm.pro.service;

import com.zjm.pro.bean.Analysis;
import com.zjm.pro.bean.AnalysisExample;
import com.zjm.pro.mapper.AnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: PMS
 * @description: 需求分析实现类
 * @author: Mr.
 * @create: 2019-04-08 19:01
 **/
@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private AnalysisMapper analysisMapper;

    @Override
    public boolean saveInfo(Analysis analysis) {
        int i = analysisMapper.insert(analysis);
        return i==1;
    }

    @Override
    public Analysis getAnalyseWithId(Integer pid) {
        return analysisMapper.selectByPrimaryKey(pid);
    }

    @Override
    public List<Analysis> anlist() {
        AnalysisExample analysisExample=new AnalysisExample();
        return analysisMapper.selectByExample(analysisExample);
    }
}

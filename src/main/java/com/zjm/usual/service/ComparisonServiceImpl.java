package com.zjm.usual.service;

import com.zjm.usual.bean.Comparison;
import com.zjm.usual.mapper.ComparisonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PMS
 * @description: 对标实现类
 * @author: Mr.
 * @create: 2019-04-15 21:44
 **/
@Service
public class ComparisonServiceImpl implements ComparisonService {
    @Resource ComparisonMapper comparisonMapper;

    public boolean saveInfo(Comparison comparison) {

        return comparisonMapper.saveInfo(comparison)==1;
    }

    public List<Comparison> complist() {
        return comparisonMapper.complist();
    }
}

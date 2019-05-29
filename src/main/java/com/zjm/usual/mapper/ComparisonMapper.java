package com.zjm.usual.mapper;

import com.zjm.usual.bean.Comparison;

import java.util.List;

public interface ComparisonMapper {

    int saveInfo(Comparison comparison);

    List<Comparison> complist();
}
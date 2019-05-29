package com.zjm.usual.mapper;

import com.zjm.usual.bean.TieZi;

import java.util.List;

public interface TieZiMapper{
    void seaveInfo(TieZi tieZi);

    List<TieZi> tzlist();
}

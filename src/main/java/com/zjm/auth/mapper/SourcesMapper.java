package com.zjm.auth.mapper;

import com.zjm.auth.bean.Sources;
import com.zjm.auth.bean.SourcesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourcesMapper {
    int countByExample(SourcesExample example);

    int deleteByExample(SourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sources record);

    int insertSelective(Sources record);

    List<Sources> selectByExample(SourcesExample example);

    Sources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sources record, @Param("example") SourcesExample example);

    int updateByExample(@Param("record") Sources record, @Param("example") SourcesExample example);

    int updateByPrimaryKeySelective(Sources record);

    int updateByPrimaryKey(Sources record);

    List<Sources> getSecondSourcesByEid(Integer eid);

    List<Sources> selectChildren(@Param("pid") Integer pid, @Param("eid") Integer eid);
}
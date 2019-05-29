package com.zjm.auth.service;

import com.zjm.auth.bean.Sources;
import com.zjm.auth.bean.SourcesExample;
import com.zjm.auth.mapper.SourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PMS
 * @description: 权限实现类
 * @author: Mr.
 * @create: 2019-04-16 16:54
 **/
@Service
public class SourcesServiceImpl implements SourcesService {
    @Resource
    private SourcesMapper sourcesMapper;

    public List<Sources> getSourcesById(int i) {
        SourcesExample example=new SourcesExample();
        SourcesExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(i);
        return sourcesMapper.selectByExample(example);
    }

    public boolean add(Sources sources) {
        return sourcesMapper.insert(sources)==1;
    }

    public Sources getOneById(Integer id) {
        return sourcesMapper.selectByPrimaryKey(id);
    }

    public boolean updateInfo(Sources sources) {
        return sourcesMapper.updateByPrimaryKeySelective(sources)==1;
    }

    public boolean delete(Integer id) {
    return sourcesMapper.deleteByPrimaryKey(id)==1;
    }

    public List<Sources> getSourcesByEid(Integer eid) {
        List<Sources> sourcesList = sourcesMapper.getSecondSourcesByEid(eid);
        for (Sources sources : sourcesList) {
            Integer pid = sources.getId();

            List<Sources> children = sourcesMapper.selectChildren(pid,eid);
            sources.setChildren(children);
        }
        return sourcesList;
    }
}

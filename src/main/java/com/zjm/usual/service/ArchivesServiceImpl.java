package com.zjm.usual.service;

import com.zjm.usual.bean.Archives;
import com.zjm.usual.mapper.ArchivesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: PMS
 * @description: 我的档案实现类
 * @author: Mr.
 * @create: 2019-04-12 13:33
 **/
@Service
public class ArchivesServiceImpl implements  ArchivesService {
    @Resource
    private ArchivesMapper archivesMapper;

    @Override
    public Archives mfmi() {
        Archives archives=archivesMapper.mfmi();
        return archives;
    }
}

package com.zjm.emp.service;

import com.zjm.emp.bean.Position;
import com.zjm.emp.mapper.PositionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PMS
 * @description: 级别实现类
 * @author: Mr.
 * @create: 2019-04-16 23:04
 **/
@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionMapper positionMapper;

    public List<Position> saveInfo() {
        return positionMapper.selectByExample(null);
    }
}

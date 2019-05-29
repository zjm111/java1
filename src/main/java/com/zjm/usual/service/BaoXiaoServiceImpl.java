package com.zjm.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjm.usual.bean.Baoxiao;
import com.zjm.usual.mapper.BaoxiaoMapper;
import com.zjm.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: PMS
 * @description: 报销实现类
 * @author: Mr.
 * @create: 2019-04-10 17:53
 **/
@Service
public class BaoXiaoServiceImpl implements BaoXiaoService{
    @Resource
    private BaoxiaoMapper baoxiaoMapper;

    @Override
    public boolean saveInfo(Baoxiao baoxiao) {
        return baoxiaoMapper.insert(baoxiao)==1;
    }

    @Override
    public PageInfo<Baoxiao> getBaoXiaoList(String pageNum,Map<String,Object>paramMap) {
        Integer pageNo=1;
        try {
            pageNo=Integer.parseInt(pageNum);
        }catch (Exception ex){}
        Map<String,String> resultMap=parseparamMapToMyBatisMap(paramMap);
        PageHelper.startPage(pageNo, PageUtils.PAGE_SIZE);
        List<Baoxiao> list=baoxiaoMapper.selectBaoXiaoListWithParams(resultMap);
        PageInfo<Baoxiao> page=new PageInfo<Baoxiao>(list,5);
        return page;
    }
    private Map<String, String> parseparamMapToMyBatisMap(Map<String, Object> paramMap) {
        Set<Map.Entry<String,Object>> entries=paramMap.entrySet();
        Map<String,String> resultMap=new HashMap<String, String>();
        for (Map.Entry<String,Object> entry:entries){
            String key=entry.getKey();
            String value=(String) entry.getValue();
            if (key.contains("like_")){
                key=key.substring(5);
                value="%"+value+"%";
            }
            resultMap.put(key,value);
        }
        return resultMap;
    }

    @Override
    public Baoxiao genggai(String bxid) {
        return baoxiaoMapper.selectByPrimaryKey(bxid);
    }

    @Override
    public boolean genggai1(Baoxiao baoxiao) {
        return baoxiaoMapper.updateByPrimaryKeySelective(baoxiao)==1;
    }



}

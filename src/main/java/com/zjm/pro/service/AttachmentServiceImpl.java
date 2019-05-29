package com.zjm.pro.service;

import com.zjm.pro.bean.Attachment;
import com.zjm.pro.mapper.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: PMS
 * @description: 附件实现类
 * @author: Mr.
 * @create: 2019-04-08 22:06
 **/
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentMapper attachmentMapper;
    @Override
    public boolean saveInfo(Attachment attachment) {
        int insert = attachmentMapper.insert(attachment);
        return insert==1;
    }
}

package com.zjm.pro.controller;

import com.zjm.pro.bean.Attachment;
import com.zjm.pro.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

/**
 * @program: PMS
 * @description: 附件
 * @author: Mr.
 * @create: 2019-04-08 21:36
 **/
@Controller
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public String saveInfo(HttpSession httpSession, Attachment attachment, @RequestParam("file")MultipartFile file, RedirectAttributes re){
        String originalFilename = file.getOriginalFilename();
        String realName= UUID.randomUUID().toString().replaceAll("-","")+"_"+originalFilename;
        attachment.setPath(realName);
        ServletContext servletContext = httpSession.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        File directory=new File(realPath);
        if (!directory.exists()){
            directory.mkdir();
        }
        try {
            //保存文件到本地
            file.transferTo(new File(realPath+"/"+realName));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        boolean result=attachmentService.saveInfo(attachment);
        if (result){
            return "redirect:/project-file.jsp";
        }else {
            re.addFlashAttribute("msg","上传失败");
            return "redirect:/project-file-add.jsp";

        }
    }
}

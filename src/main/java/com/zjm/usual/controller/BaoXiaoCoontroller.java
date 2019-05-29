package com.zjm.usual.controller;

import com.github.pagehelper.PageInfo;
import com.zjm.emp.bean.Employee;
import com.zjm.usual.bean.Baoxiao;
import com.zjm.usual.service.BaoXiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @program: PMS
 * @description: 报销
 * @author: Mr.
 * @create: 2019-04-10 17:50
 **/
@Controller
@RequestMapping("/baoxiao")
public class BaoXiaoCoontroller {
    @Autowired
    private BaoXiaoService baoXiaoService;

    @RequestMapping(value = ("/saveInfo"),method = RequestMethod.POST)
    public String saveInfo(Baoxiao baoxiao, HttpSession session, Map<String,Object> map){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        baoxiao.setBxid(uuid);
        Employee employee= (Employee) session.getAttribute("activeUser");
        Integer eid = employee.getEid();
        baoxiao.setEmpFk(eid);
        baoxiao.setBxstatus(0);
        boolean result=baoXiaoService.saveInfo(baoxiao);
        if (result){
            return "redirect:/baoxiao/list";
        }else {
            map.put("msg","报销失败");
            return "mybaoxiao-add";
        }
    }

    @RequestMapping(value = ("/list"),method = RequestMethod.GET)
    public ModelAndView getBaoXiaoList(HttpServletRequest request,@RequestParam(value = "pageNum",defaultValue = "1") String pageNum){
        Map<String,Object> paramMap= WebUtils.getParametersStartingWith(request,"search_");
        PageInfo<Baoxiao> page= baoXiaoService.getBaoXiaoList(pageNum,paramMap);
        ModelAndView mv=new ModelAndView("mybaoxiao-base");
        mv.addObject("page",page);
        String queruString=parseParamMapToQueryString(paramMap);
        mv.addObject("queruString",queruString);
        String requestURL = request.getRequestURL().toString();
        mv.addObject("url",requestURL);
        return mv;
    }

    private String parseParamMapToQueryString(Map<String, Object> paramMap) {
        StringBuilder builder=new StringBuilder();
        Set<Map.Entry<String,Object>> entries=paramMap.entrySet();
        for (Map.Entry<String,Object> entry:entries){
            String key = entry.getKey();
            String value = (String) entry.getValue();
            builder.append("&").append("search_").append(key).append("=").append(value);
        }
        return builder.toString();
    }

    @RequestMapping(value = "/genggai",method = RequestMethod.GET)
    public ModelAndView genggai(String bxid){
        ModelAndView mv=new ModelAndView("mybaoxiao-edit");
        Baoxiao baoxiao=baoXiaoService.genggai(bxid);
        mv.addObject("nnbx",baoxiao);
        return mv;
    }
    @RequestMapping(value = "/genggai1",method = RequestMethod.PUT)
    public String genggai1(Baoxiao baoxiao, RedirectAttributes re){
          boolean result=baoXiaoService.genggai1(baoxiao);
        if (result){
            return "redirect:/baoxiao/list";
        }else {
            re.addFlashAttribute("msg","修改失败");
            return "redirect:/mybaoxiao-edit.jsp";
        }
    }
}

package com.zjm.emp.controller;

import com.zjm.auth.service.SourcesService;
import com.zjm.emp.bean.Employee;
import com.zjm.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: PMS
 * @description: 员工
 * @author: Mr.
 * @create: 2019-04-07 22:37
 **/
@Controller
@RequestMapping(value = "/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SourcesService sourcesService;
    @Autowired
    private JedisPool jedisPool;

    //查询职位为项目经理的员工列表
    @RequestMapping(value = "/mgls",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getManagetList(){
        return  employeeService.getManagerList();
    }
    //查询所有员工信息
    @RequestMapping(value = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Employee employee, String code, HttpSession session, RedirectAttributes re){
        String kaptchaSessionKey = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
        session.removeAttribute("KAPTCHA_SESSION_KEY");
        if(code.equalsIgnoreCase(kaptchaSessionKey)) {
            Employee result = employeeService.login(employee);
            if (result != null) {
                Integer eid=result.getEid();
//                Jedis jedis = jedisPool.getResource();
//                String sourcess = jedis.get(eid + "");
//                List<Sources> sourcesList = JSON.parseArray(sourcess, Sources.class);
//                if (sourcesList==null){
                   List sourcesList=sourcesService.getSourcesByEid(eid);
//                    jedis.set(eid+"",JSON.toJSONString(sourcesList));
//                }
                session.setAttribute("sourcesList", sourcesList);
                session.setAttribute("activeUser", result);
                return "redirect:/index.jsp";
            } else {
                return "redirect:/login.jsp";
            }
        }else {
            re.addFlashAttribute("msg","验证码错误！");
            return "redirect:/login";
        }
    }
}

package com.zjm.cus.controller;

import com.zjm.cus.bean.Customer;
import com.zjm.cus.service.CustomerService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 客户信息管理
* */
@Controller
@RequestMapping("/cus")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/export",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object>  exportExcel() throws Exception{
        List<Customer> customers = customerService.showInfo();
        Workbook wb=new HSSFWorkbook();
        Sheet customers1 = wb.createSheet("customers");
        customers1.setColumnWidth(4,4000);
        customers1.setColumnWidth(5,4000);
        customers1.setColumnWidth(6,4000);
        customers1.autoSizeColumn(7);
        Row row = customers1.createRow(0);

        //创建样式
        HSSFCellStyle cellStyle = (HSSFCellStyle) wb.createCellStyle();
        //日期
        HSSFDataFormat format=(HSSFDataFormat) wb.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("yyyy年MM月dd日"));

        HSSFCell cell[] =new HSSFCell[9];
        for (int i=0;i<cell.length;i++){
            cell[i]=(HSSFCell) row.createCell(i);
        }
        cell[0].setCellValue("ID");
        cell[1].setCellValue("公司名称");
        cell[2].setCellValue("公司联系人");
        cell[3].setCellValue("公司地址");
        cell[4].setCellValue("联系人电话");
        cell[5].setCellValue("公司座机");
        cell[6].setCellValue("公司简介");
        cell[7].setCellValue("备注");
        cell[8].setCellValue("添加时间");
        for (int i=0;i<customers.size();i++){
            Customer customer = customers.get(i);
            Row row1 = customers1.createRow(i + 1);
            HSSFCell dataCell[]=new HSSFCell[9];
            for(int j = 0; j < dataCell.length; j++){
                //取得第一行所有列
                dataCell[j] = (HSSFCell) row1.createCell(j);
            }
            dataCell[0].setCellValue(customer.getId());
            dataCell[1].setCellValue(customer.getComname());
            dataCell[2].setCellValue(customer.getCompanyperson());
            dataCell[3].setCellValue(customer.getComaddress());
            dataCell[4].setCellValue(customer.getComphone());
            dataCell[5].setCellValue(customer.getCamera());
            dataCell[6].setCellValue(customer.getPresent());
            dataCell[7].setCellValue(customer.getRemark());
            dataCell[8].setCellStyle(cellStyle);
            dataCell[8].setCellValue(customer.getAddtime());

        }
        wb.write(new FileOutputStream(new File("C:\\Users\\83678\\Desktop\\customer.xls")));
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("statusCode",200);
        map.put("msg","导出成功");
        return map;
    }

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Customer customer){
        boolean result=customerService.saveInfo(customer);
        if (result) {
            return "redirect:/customer.jsp";
        }else{
            return "redirect:/customer-add.jsp";
        }
    }
    @RequestMapping(value = "showInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> showInfo() {
        return  customerService.showInfo();
    }
    @RequestMapping(value = "searchInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> searchInfo(int tj, String gjz,int px) {
        return  customerService.searchInfo(tj,gjz,px);
    }
    @RequestMapping(value = "/showDetails/{id}",method = RequestMethod.GET)
    public ModelAndView showDetails(@PathVariable("id") Integer cid){
        ModelAndView mv =new ModelAndView("customer-look");
        Customer customer=customerService.showDetails(cid);
        mv.addObject("cus",customer);
        return mv;
    }
    @RequestMapping(value = "/showDetail/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Customer showDetail(@PathVariable("id") Integer cid){
        System.err.println(cid);
        Customer customer = customerService.showDetails(cid);
        return customer;
    }
    @RequestMapping(value = "/updatecus",method = RequestMethod.PUT)
    public String updatecus(Customer customer){
    customerService.updatecus(customer);
    return "redirect:/customer.jsp";
    }
    @RequestMapping(value = "/deletecus/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deletecus(@PathVariable("ids") String ids){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
         boolean result=customerService.deletecus(ids);
         map.put("statusCode",200);
         map.put("message","删除成功");
        }catch (Exception ex){
            map.put("statusCode",500);
            map.put("message",ex.getMessage());
        }
        return map;
    }
}

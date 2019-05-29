package com.zjm.cus.service;

import com.zjm.cus.bean.Customer;

import java.util.List;

/**
 * @program: PMS
 * @description: 客户信息管理接口
 * @author: Mr
 * @create: 2019-04-03 18:50
 **/
public interface CustomerService {
    boolean saveInfo(Customer customer);

    List<Customer> showInfo();

    List<Customer> searchInfo(int tj, String gjz, int px);

    Customer showDetails(Integer cid);

    void updatecus(Customer customer);

    boolean deletecus(String ids);
}

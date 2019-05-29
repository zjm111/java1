package com.zjm.cus.service;

import com.zjm.cus.bean.Customer;
import com.zjm.cus.bean.CustomerExample;
import com.zjm.cus.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: PMS
 * @description: 客户信息管理实现类
 * @author: Mr.
 * @create: 2019-04-03 18:52
 **/
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public boolean saveInfo(Customer customer) {
        customer.setAddtime(new Date());
        int result = customerMapper.insert(customer);
        return result>0;
    }

    @Override
    public List<Customer> showInfo() {
        CustomerExample customerExample=new CustomerExample();
        return customerMapper.selectByExample(customerExample);
    }

    @Override
    public List<Customer> searchInfo(int tj, String gjz, int px) {
        CustomerExample customerExample=new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        CustomerExample.Criteria criteria1 = customerExample.createCriteria();
        if (tj==0){
            criteria.andComnameLike("%"+gjz+"%");
            criteria1.andCompanypersonLike("%"+gjz+"%");
            customerExample.or(criteria1);
        }else if(tj==1){
            criteria.andComnameLike("%"+gjz+"%");
        }else{
            criteria.andCompanypersonLike("%"+gjz+"%");
        }
        if (px==1){
            customerExample.setOrderByClause("id");
        }
        return customerMapper.selectByExample(customerExample);
    }

    @Override
    public Customer showDetails(Integer cid) {
        return customerMapper.selectByPrimaryKey(cid);
    }

    @Override
    public void updatecus(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public boolean deletecus(String ids) {
        String[] idArr=ids.split(",");
        for (int i=0;i<idArr.length;i++){
      
            customerMapper.deleteByPrimaryKey(Integer.parseInt(idArr[i]));
        
        }
        return true;
   
    }

}

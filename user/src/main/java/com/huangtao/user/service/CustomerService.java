package com.huangtao.user.service;

import com.huangtao.user.domain.CustomerDO;
import com.huangtao.user.repo.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    public Boolean delCustomer(String id) {
        return customerDAO.deleteCustomerDOById(id) > 0;
    }

    public Boolean updateCustomerInfo(CustomerDO customerDO) {
        return customerDAO.update(customerDO) > 0;
    }

    public CustomerDO getCustomerById(String id) {
        return customerDAO.getCustomerById(id);
    }

    public Boolean save(CustomerDO customerDO) {
        return customerDAO.save(customerDO) > 0;
    }

    public Boolean isExist(CustomerDO customerDO) {
        CustomerDO customerDO1 = customerDAO.getCustomerById(customerDO.getId());
        if (customerDO.getCustomerPassword().equals(customerDO1.getCustomerPassword())) {
            return true;
        }
        return false;
    }
}

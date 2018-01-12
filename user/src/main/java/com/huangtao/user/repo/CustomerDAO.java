package com.huangtao.user.repo;

import com.huangtao.user.domain.CustomerDO;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO {

    int deleteCustomerDOById(String id);


    int update(CustomerDO customerDO);

    CustomerDO getCustomerById(String id);

    int save(CustomerDO customerDO);

}

package com.huangtao.user.repo;

import com.huangtao.user.domain.CustomerDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO {

    //根据id删除用户
    @Delete("delete form custom_all where custom_id=#{id}")
    int deleteCustomerDOById(String id);

    //更新用户信息
    int update(CustomerDO customerDO);

    //根据id查询用户
    @Select("select * from custom_all where custom_id=#{id}")
    CustomerDO getCustomerById(String id);

    //新增用户
    @Insert("insert into custom_all values(#{custom_id},#{custom_name},#{custom_state},#{custom_qq},#{custom_tel},#{custom_mail},#{custom_password})")
    int save(CustomerDO customerDO);

}

package com.huangtao.order.repo;

import com.huangtao.order.domain.OrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface OrderDAO {

    //增加订单
    @Insert("insert into order_all values(#{order_id},#{order_custom_id},#{order_custom_name},#{order_state},#{store_addr_all},#{end_addr_all},#{order_store_id},#{order_store_name})")
    int saveOrder(OrderDO orderDo);

    //根据订单ID查询订单
    @Select("SELECT a.*,b.* FROM t_order_all a,order_all b WHERE b.order_id=a.order_id AND\n" + "  b.order_id=#{id}")
    OrderDO getOrderDOById(String id);


    //订单完成更新订单状态 0:未完成 1：已完成
    @Update("update  order_all set order_state=1 where order_id=#{id}")
    int updateOrderStateById(String id);


}

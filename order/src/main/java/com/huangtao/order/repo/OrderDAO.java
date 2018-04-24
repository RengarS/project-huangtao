package com.huangtao.order.repo;

import domains.order.OrderDO;
import domains.order.OrderFood;
import domains.order.dto.OrderDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDAO {

    /**
     * 增加订单
     */
    @Insert("insert into order_all values(#{order_id},#{order_custom_id},#{order_custom_name},#{order_state}," +
            "#{store_addr_all},#{end_addr_all},#{order_store_id},#{order_store_name})")
    int saveOrder(OrderDO orderDo);

    /**
     * 根据订单ID查询订单
     *
     * @param id
     * @return
     */
    @Select("select * from order_all where order_id = #{id}")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_custom_id", property = "orderCustomId"),
            @Result(column = "order_custom_name", property = "orderCustomName"),
            @Result(column = "order_state", property = "orderState"),
            @Result(column = "store_addr_all", property = "storeAddrAll"),
            @Result(column = "end_addr_all", property = "endAddrAll"),
            @Result(column = "order_store_id", property = "orderStoreId"),
            @Result(column = "order_store_name", property = "orderStoreName"),

            @Result(property = "foods", column = "order_id", javaType = List.class,
                    many = @Many(select = "getOrderFoodByOrderId"))
    })
    OrderDTO getOrderDOById(String id);

    @Select("select * from t_order_all where order_id = #{orderId}")
    OrderFood getOrderFoodByOrderId(String orderId);

    /**
     * 订单完成更新订单状态 0:未完成 1：已完成
     *
     * @param id
     * @return
     */
    @Update("update  order_all set order_state=1 where order_id=#{id}")
    int updateOrderStateById(String id);


}

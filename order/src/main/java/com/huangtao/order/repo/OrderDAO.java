package com.huangtao.order.repo;

import domains.order.*;
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
     * 根据用户查询订单
     *
     * @param name
     * @return
     */
    @Select("select a.*,b.url from order_all a,store_all b where a.order_custom_name = #{name} AND a.order_store_name=b.store_name")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_store_name", property = "StoreName"),
            @Result(column = "url", property = "StorePhotoUrl"),
            @Result(column = "order_state", property = "orderState"),
            @Result(column = "order_cost", property = "orderCost"),
            @Result(column = "order_end_date", property = "orderEndDate"),
            @Result(property = "list", column = "order_id", javaType = List.class,
                    many = @Many(select = "getOrderFoodByOrderId"))
    })
    List<OrderAllDO> getOrderDOByName(String name);

    @Select("select * from t_order_all where order_id = #{orderId}")
    OrderFoods getOrderFoodByOrderId(String orderId);

    /**
     * 订单完成更新订单状态 0:待处理 1：配送中  2:已完成(PC端用，商家接单，将状态0-->1)
     *
     * @param id
     * @return
     */
    @Update("update  order_all set order_state=1 where order_id=#{id} and order_state=0")
    int updateOrderStateById(String id);


    /**
     * 订单完成更新订单状态 0:待处理 1：配送中  2:已完成(移动端用，客户确认收货，将状态1-->2)
     * @param id
     * @return
     */
    @Update("update  order_all set order_state=2 where order_id=#{id} and order_state=1")
    int updateOrderStateEnd(String id);

    /**
     * 新增订单(增加顾客信息)
     *
     * @param orderVO
     * @return
     */
    @Insert("insert into order_all(order_id,order_state,order_custom_name,order_store_name,end_addr_all,order_custom_tel,order_end_date) values(#{orderId},0,#{orderCustomName},#{orderStoreName},#{endAddrAll},#{orderCustomTel},date_add(SYSDATE(),INTERVAL 30 MINUTE))")
    int addOrder( OrderVO orderVO);


    /**
     * 新增订单(增加商品信息)
     *
     * @param orderFoods
     * @return
     */
    @Insert("insert into t_order_all(order_id,food_id,food_name,state,numb,price) values(#{orderId},#{foodId},#{foodName},0,#{numb},#{price})")
    int addOrderTemp( OrderFoods orderFoods);


    /**
     * PC端根据商铺ID获取该商铺尚未完成的订单
     * @param storeId
     * @return
     */
    @Select("select * from order_all where order_store_id = #{storeId} and order_state <> 2")
    List<OrderListVO> getOrderByStoreId(String storeId);
}

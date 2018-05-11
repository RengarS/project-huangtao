package com.huangtao.order.repo;

import domains.order.FoodsDO;
import domains.order.OldFood;
import domains.order.dto.Foods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FoodsDAO {

    @Select("select a.food_id,a.food_name,a.url,a.sales,a.rating,food_price,a.numb from food_all a where a.food_store_name=#{name} and a.food_state=0")
    @Results({@Result(column = "food_name", property = "name"),
              @Result(column = "food_price", property = "price"),
              @Result(column = "food_id", property = "foodId")})
    List<FoodsDO> getFoods(String name);

    @Select("select DISTINCT typename from food_all where food_store_name =#{storeName}")
    List<String> getTypeName(String storeName);

    @Results({@Result(column = "food_name", property = "name"),
            @Result(column = "food_price", property = "price"),
            @Result(column = "food_id", property = "foodId")})
    @Select("select * from food_all where typename=#{type} and food_store_name = #{storeName} and food_state=0")
    List<FoodsDO> getFoodsByType(@Param("type") String type, @Param("storeName") String storeName);


    /**
     * PC端根据商家ID获取所有的商品
     * @param id
     * @return
     */
    @Select("select * from food_all where food_store_id=#{id}")
    List<Foods>  getAllFoods(String id);

    /**
     * 更新商品
     * @param foodId
     * @param foodPrice
     * @return
     */
    @Update("update food_all a set a.food_price=#{foodPrice},a.food_name=#{foodName},a.food_state=#{foodState},a.url=#{imageUrl},a.food_desc=#{foodDesc} where a.food_id=#{foodId}")
    int updatefood(@Param("foodId") String foodId, @Param("foodPrice") String foodPrice,@Param("foodName") String foodName,@Param("foodDesc") String foodDesc,@Param("imageUrl") String imageUrl,@Param("foodState") String foodState);

    /**
     * PC端根据商品Id获取老的商品信息供更新用
     * @param id
     * @return
     */
    @Select("select * from food_all where food_id=#{foodId}")
    OldFood getOldFoodById(String id);
}



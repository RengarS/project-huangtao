package com.huangtao.order.repo;

import domains.order.dto.FoodsDO;
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
}

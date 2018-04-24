package com.huangtao.order.repo;

import domains.order.dto.FoodsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface FoodsDAO {

    @Select("select a.store_name,a.url,a.sales,a.rating,food_price,a.numb from food_all a where a.food_store_name=#{name} and a.food_state=0")
    @Results({@Result(column = "store_name",property = "name"),
              @Result(column = "food_price",property = "price")})
    List<FoodsDO> getFoods(String name);
}

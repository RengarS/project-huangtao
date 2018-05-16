package com.huangtao.order.repo;

import domains.order.ShopsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ShopsDAO {



    @Select("SELECT a.store_name,a.url,a.star,a.sales,a.initial_price,a.distribution_price,a.distance,a.time FROM store_all a")
    @Results({@Result(column ="store_name",property = "name"),
              @Result(column ="initial_price",property = "initial_price"),
              @Result(column ="distribution_price",property = "distribution_price")})
    List<ShopsDO> getshops();


    @Select("SELECT a.store_name,a.url,a.star,a.sales,a.initial_price,a.distribution_price,a.distance,a.time FROM store_all a order by a.sales")
    @Results({@Result(column ="store_name",property = "name"),
            @Result(column ="initial_price",property = "initial_price"),
            @Result(column ="distribution_price",property = "distribution_price")})
    List<ShopsDO> showShopsOrderBySales();


    @Select("SELECT a.store_name,a.url,a.star,a.sales,a.initial_price,a.distribution_price,a.distance,a.time FROM store_all a order by a.distance")
    @Results({@Result(column ="store_name",property = "name"),
            @Result(column ="initial_price",property = "initial_price"),
            @Result(column ="distribution_price",property = "distribution_price")})
    List<ShopsDO> showShopsOrderByDistance();
}


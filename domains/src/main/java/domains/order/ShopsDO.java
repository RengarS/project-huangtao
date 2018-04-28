package domains.order;

import lombok.Data;

@Data
public class ShopsDO {

    private String name;   //商铺名字
    private String url;    //商家图片地址
    private String star;   //好评星级
    private String sales;  //已售量
    private String initial_price; //起送价格
    private String distribution_price; //配送价格
    private String distance; //距离
    private String time; //预计配送时间

}

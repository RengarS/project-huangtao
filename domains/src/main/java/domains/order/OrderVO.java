package domains.order;

import lombok.Data;

import java.util.List;

//微信小程序传来的订单实体
@Data
public class OrderVO {


    private String orderCustomName;//顾客名称
    private String orderStoreName;//订单所属商店名称
    private String endAddrAll; //配送地址
    private String orderCustomTel; //顾客电话
    private List<OrderFoods> list;
}

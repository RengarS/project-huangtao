package com.huangtao.web.controller;

import domains.item.Comment;
import domains.item.Item;
import domains.responses.MapResponse;
import domains.responses.ObjectResponse;
import domains.servers.ServerName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/item/")
public class StoreItemsController {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 商品详情和评论
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @SuppressWarnings("unchecked")
    public MapResponse<String, List> itemPage(@PathVariable("id") String id) {
        List<Comment> comments = restTemplate.getForObject(ServerName.ITEM_SERVICE + "/items/comments/" + id, List.class);
        List<Item> items = restTemplate.getForObject(ServerName.ITEM_SERVICE + "/items/itemDetail/" + id, List.class);
        MapResponse<String, List> response = new MapResponse<>();
        response.getData().put("comments", comments);
        response.getData().put("items", items);
        return response;
    }

    /**
     * 添加一件商品到购物车
     *
     * @param userId
     * @param itemId
     * @return
     */
    @PostMapping("/cart/add")
    public ObjectResponse<Boolean> addItemToCart(@RequestParam("userId") String userId, @RequestParam("itemId") String itemId) {
        return null;
    }

    /**
     * 购物车移除一件商品
     *
     * @param userId
     * @param itemId
     * @return
     */
    @PostMapping("/cart/remove")
    public ObjectResponse<Boolean> removeOneFromCart(@RequestParam("userId") String userId, @RequestParam("itemId") String itemId) {
        return null;
    }

    /**
     * 结算订单
     *
     * @param userId
     * @param itemId
     * @return
     */
    @PostMapping("/order/settlement")
    public ObjectResponse<Boolean> settlement(@RequestParam("userId") String userId, @RequestParam("itemId") String itemId) {
        return null;
    }
}

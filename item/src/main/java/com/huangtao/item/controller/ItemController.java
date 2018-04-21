package com.huangtao.item.controller;

import domains.item.Comment;
import domains.item.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/items/")
public class ItemController {

    @GetMapping("/comments/{id}")
    public List<Comment> getStoreComment(@PathVariable("id") String id) {
        List<Comment> comments = new LinkedList<>();
        comments.add(new Comment());
        comments.add(new Comment());

        return comments;
    }

    @GetMapping("/itemDetail/{id}")
    public List<Item> getStoreItems(@PathVariable("id") String id) {
        List<Item> items = new LinkedList<>();
        items.add(new Item());
        items.add(new Item());
        return items;
    }

    @GetMapping(value = "/index")
    public String TestController() {
        return "我是  itemS";
    }
}

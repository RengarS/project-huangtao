package com.huangtao.web.controller;

import domains.user.CustomerDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public CustomerDTO getUserInfo(@PathVariable("id") String id) {

        return restTemplate.getForObject("http://user/user/see/" + id, CustomerDTO.class);
    }

    /**
     * PC端登录时获取对应的店铺ID
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/logincheck")
    public String getStoreIdLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        return restTemplate.getForObject("http://user/user/logincheck?username="+username+"&password="+password,String.class);
    }

}



















@Data
class User {
    private int id;
    private String name;
}

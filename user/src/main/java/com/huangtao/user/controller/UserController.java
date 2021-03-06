package com.huangtao.user.controller;

import com.huangtao.user.domain.CustomerDO;
import com.huangtao.user.service.CustomerService;
import domains.user.CustomerDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/login")
    public boolean login(@RequestParam("username") String username, String password) {
        if (!username.trim().equals("") && !password.trim().equals("")) {
            String password1 = password.trim();
            if (password1.length() >= 6 && password1.length() <= 16) {
                CustomerDO customerDO = new CustomerDO();
                customerDO.setCustomerName(username);
                customerDO.setCustomerPassword(password);
                return customerService.isExist(customerDO);
            } else {
                throw new RuntimeException("");
            }
        } else {
            throw new RuntimeException("");
        }

    }

    @PostMapping("/register")
    public boolean register(@RequestParam @NotBlank Object object) {
        return customerService.save((CustomerDO) object);
    }


    @PostMapping("/update")
    public boolean update(@RequestParam @NotBlank Object object) {
        return customerService.updateCustomerInfo((CustomerDO) object);
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") @NotBlank String id) {
        return customerService.delCustomer(id);
    }

    @GetMapping("/see/{id}")
    public CustomerDTO see(@PathVariable("id") @NotBlank String id) {
        return new CustomerDTO();
    }

    @GetMapping("/logincheck")
    public String getStoreIdLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        return customerService.getStoreIdLogin(username,password);
    }
}

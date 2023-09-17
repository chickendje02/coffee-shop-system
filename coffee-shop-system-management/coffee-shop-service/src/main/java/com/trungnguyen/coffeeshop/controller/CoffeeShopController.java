package com.trungnguyen.coffeeshop.controller;


import com.trungnguyen.coffeeshop.entity.CoffeeShop;
import com.trungnguyen.coffeeshop.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/coffee-shop")
public class CoffeeShopController {

    @Autowired
    private CoffeeShopService coffeeShopService;

    @GetMapping
    public ResponseEntity<List<CoffeeShop>> getList() {
        return ResponseEntity.ok(coffeeShopService.getList());
    }
}

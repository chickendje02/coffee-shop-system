package com.trungnguyen.coffeeshopservice.controller;


import com.trungnguyen.coffeeshopservice.entity.Menu;
import com.trungnguyen.coffeeshopservice.producer.CoffeeShopProducer;
import com.trungnguyen.coffeeshopservice.service.CoffeeShopService;
import com.trungnguyen.coffeeshopservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/menu")
public class MenuController {

    @Autowired
    private CoffeeShopProducer coffeeShopProducer;

    @Autowired
    private MenuService menuService;



    @GetMapping
    public ResponseEntity<List<Menu>> getList(){
        coffeeShopProducer.sendMessage("test");
        return ResponseEntity.ok(menuService.getListMenu());
    }
}

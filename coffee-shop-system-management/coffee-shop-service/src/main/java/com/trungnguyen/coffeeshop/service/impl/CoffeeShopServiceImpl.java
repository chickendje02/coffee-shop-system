package com.trungnguyen.coffeeshop.service.impl;

import com.trungnguyen.coffeeshop.entity.CoffeeShop;
import com.trungnguyen.coffeeshop.repository.CoffeeShopRepository;
import com.trungnguyen.coffeeshop.service.CoffeeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeShopServiceImpl implements CoffeeShopService {

    @Autowired
    CoffeeShopRepository coffeeShopRepository;

    @Override
    public List<CoffeeShop> getList() {
        return coffeeShopRepository.findAll();
    }
}

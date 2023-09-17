package com.trungnguyen.coffeeshopservice.service.impl;

import com.trungnguyen.coffeeshopservice.entity.CoffeeShop;
import com.trungnguyen.coffeeshopservice.repository.CoffeeShopRepository;
import com.trungnguyen.coffeeshopservice.service.CoffeeShopService;
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

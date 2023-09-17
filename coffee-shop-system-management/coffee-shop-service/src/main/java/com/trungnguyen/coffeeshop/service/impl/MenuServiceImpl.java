package com.trungnguyen.coffeeshopservice.service.impl;

import com.trungnguyen.coffeeshopservice.entity.Menu;
import com.trungnguyen.coffeeshopservice.repository.MenuRepository;
import com.trungnguyen.coffeeshopservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;
    @Override
    public List<Menu> getListMenu() {
        return menuRepository.findAll();
    }
}

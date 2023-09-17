package com.trungnguyen.coffeeshop.service.impl;

import com.trungnguyen.coffeeshop.entity.Menu;
import com.trungnguyen.coffeeshop.repository.MenuRepository;
import com.trungnguyen.coffeeshop.service.MenuService;
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

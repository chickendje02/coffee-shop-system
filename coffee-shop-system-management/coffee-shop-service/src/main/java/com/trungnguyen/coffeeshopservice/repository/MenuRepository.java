package com.trungnguyen.coffeeshopservice.repository;

import com.trungnguyen.coffeeshopservice.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {


}

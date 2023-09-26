package com.trungnguyen.coffeeshop;

import com.trungnguyen.coffeeshop.configuration.DatabaseTestConfiguration;
import com.trungnguyen.coffeeshop.entity.CoffeeShop;
import com.trungnguyen.coffeeshop.entity.Menu;
import com.trungnguyen.coffeeshop.repository.CoffeeShopRepository;
import com.trungnguyen.coffeeshop.repository.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=none"
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {DatabaseTestConfiguration.class})
class CoffeeShopServiceApplicationTests {

    @Autowired
    private CoffeeShopRepository coffeeShopRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Test
    void checkIfCanInitLiquibaseConfigCoffeeShop() {
        List<CoffeeShop> list = coffeeShopRepository.findAll();
        Assertions.assertEquals(list.size(), 3);
    }

    @Test
    void checkIfCanInitLiquibaseConfigMenu() {
        List<Menu> list = menuRepository.findAll();
        Assertions.assertEquals(list.size(), 4);
    }

}

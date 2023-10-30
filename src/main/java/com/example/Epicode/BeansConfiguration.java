package com.example.Epicode;

import com.example.Epicode.Entities.MenuItem;
import com.example.Epicode.Entities.Menù;
import com.example.Epicode.Entities.Pizza;
import com.example.Epicode.Entities.Toppings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class BeansConfiguration {


    @Bean
    Menù getMenu() {
        return new Menù();
    }

    @Bean
    Toppings getToppingProsciutto() {
        return new Toppings("Prosciutto",1,50,getMenu());
    }
    @Bean
    Toppings getToppingWurstel() {
        return new Toppings("Wurstel",2,100,getMenu());
    }
    @Bean
    Toppings getToppingPatatine() {
        return new Toppings("Patatine",1,150,getMenu());
    }

    List<Toppings> margherita = new ArrayList<>();
    @Bean
    public List<Toppings> prosciutto() {
        List<Toppings> prosciutto = new ArrayList<>();
        prosciutto.add(getToppingProsciutto());
        return prosciutto;
    }
    @Bean
    public List<Toppings> americana() {
        List<Toppings> americana = new ArrayList<>();
        americana.add(getToppingWurstel());
        americana.add(getToppingPatatine());
        return americana;
    }
    @Bean
    public int getCalories (MenuItem menuItem,List<Toppings> toppingsList){
        final int menuItemCalories = menuItem.getCalories();
        int toppingListCalories = toppingsList.stream()
                .mapToInt(Toppings::getCalories)
                .sum();

        return menuItemCalories+toppingListCalories;
    }


    @Bean
    MenuItem getPizzaMargherita() {
        return new Pizza("Margherita",5,getCalories(getPizzaMargherita(),margherita),getMenu(),margherita);

    }
    @Bean
    MenuItem getPizzaProsciutto() {
        return new Pizza("Americana",5,getCalories(getPizzaProsciutto(),prosciutto()),getMenu(),prosciutto());

    }

    @Bean
    MenuItem getPizzaAmericana() {
        return new Pizza("Americana",5,getCalories(getPizzaAmericana(),americana()),getMenu(),americana());

    }




}

package com.example.Epicode;

import com.example.Epicode.Entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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

    List<Toppings> margherit = new ArrayList<>();
    @Bean
    public List<Toppings> schinken() {
        List<Toppings> prosciutto = new ArrayList<>();
        prosciutto.add(getToppingProsciutto());
        return prosciutto;
    }
    @Bean
    public List<Toppings> american() {
        List<Toppings> americana = new ArrayList<>();
        americana.add(getToppingWurstel());
        americana.add(getToppingPatatine());
        return americana;
    }


    private int getCaloriess(List<Toppings> toppingsList){
        int menuItemCalories = 100;
        int toppingListCalories = toppingsList.stream()
                .mapToInt(Toppings::getCalories)
                .sum();

        return menuItemCalories+toppingListCalories;
    }

    public int getPrices (List<Toppings> toppingsList){
        int menuItemPrice = 5;
        int toppingListCalories = toppingsList.stream()
                .mapToInt(Toppings::getPrezzo).sum();

        return menuItemPrice+toppingListCalories;
    }

    @Bean
    MenuItem getPizzaMargherita() {
        return new Pizza("Margherita",getPrices(margherit),getCaloriess(margherit),getMenu(),margherit);

    }



    @Bean
    MenuItem getPizzaProsciutto() {
        return new Pizza("Prosciutto",getPrices(schinken()),getCaloriess(schinken()),getMenu(),schinken());

    }

    @Bean
    MenuItem getPizzaAmericana() {
        return new Pizza("Americana",getPrices(american()),getCaloriess(american()),getMenu(),american());

    }


    @Bean
    MenuItem getCocaCola() {
        return new Bibite("Coke",3,200,getMenu());

    }
    @Bean
    MenuItem getFanta() {
        return new Bibite("Fanta",3,150,getMenu());

    }
    @Bean
    MenuItem getSprite() {
        return new Bibite("Sprite",2,120,getMenu());

    }

    @Bean
    @Scope("prototype")
    int getTotale(List<MenuItem> menuItemList) {
        int totale = menuItemList.stream()
                .mapToInt(MenuItem::getPrezzo)
                .sum();
     return totale;
    }


}

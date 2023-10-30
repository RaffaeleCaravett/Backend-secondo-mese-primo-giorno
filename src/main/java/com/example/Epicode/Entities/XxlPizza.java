package com.example.Epicode.Entities;

import com.example.Epicode.Interfaces.PizzaDecorator;

public class XxlPizza implements PizzaDecorator {
    @Override
    public Pizza decorate(Pizza pizza) {
        return new Pizza(pizza.getName() + " XXL", pizza.getPrezzo() * 2, pizza.getCalories()*2, pizza.getMenu(),pizza.getToppings());
    }
}

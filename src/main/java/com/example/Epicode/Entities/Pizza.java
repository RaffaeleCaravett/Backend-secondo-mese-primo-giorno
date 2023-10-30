package com.example.Epicode.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.awt.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@DiscriminatorValue("pizza")
public class Pizza extends MenuItem {
    private String base;
    private List<Toppings> toppings;

    public Pizza() {
    }

    public Pizza( String name, int prezzo, int calories, Menù menu, List<Toppings> toppings) {
        super( name, prezzo, calories, menu);
        this.base= "Pomodoro, mozzarella";
        this.toppings=toppings;
    }

}

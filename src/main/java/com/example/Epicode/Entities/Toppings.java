package com.example.Epicode.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Toppings extends MenuItem {
    public Toppings() {
    }

    public Toppings( String name, int prezzo, int calories, Menù menu) {
        super( name, prezzo, calories, menu);
    }
}

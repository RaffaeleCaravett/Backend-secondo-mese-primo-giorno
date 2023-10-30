package com.example.Epicode.Entities;


import lombok.*;

import javax.persistence.*;
import java.awt.*;


@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "item_type")
public abstract class MenuItem {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int prezzo;
    private int calories=100;
    @ManyToOne
    @JoinColumn(name = "menù", nullable = false)
    private Menù menu;

public MenuItem(){}
    public MenuItem( String name, int prezzo, int calories1, Menù menu) {
        this.name = name;
        this.prezzo = prezzo;
        this.calories = calories+ calories1;
        this.menu = menu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Menù getMenu() {
        return menu;
    }

    public void setMenu(Menù menu) {
        this.menu = menu;
    }
}

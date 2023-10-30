package com.example.Epicode.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@ToString
@Entity
public class Menù {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "menu")
    @OrderBy("id ASC")
    private List<Pizza> pizze;
    @OneToMany(mappedBy = "menu")
    @OrderBy("id ASC")
    private List<Bibite> bibite;
    @OneToMany(mappedBy = "menu")
    @OrderBy("id ASC")
    private List<Toppings> toppings;

    public Menù(){}

    public Menù(long id, List<Pizza> pizze, List<Bibite> bibite, List<Toppings> toppings) {
        this.id = id;
        this.pizze = pizze;
        this.bibite = bibite;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Menù{"+
                "\n  id=" + id +
                "\n  pizze=" + pizze +
                "\n  bibite=" + bibite +
                "\n  toppings=" + toppings +
                "\n}";
    }
}

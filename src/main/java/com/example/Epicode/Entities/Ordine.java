package com.example.Epicode.Entities;

import com.example.Epicode.Enums.OrderState;
import lombok.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("ordine_component")
@PropertySource("application.properties")
public class Ordine {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany
    @JoinTable(name = "tavoli_ordini",
            joinColumns = @JoinColumn(name = "ordine_id"),
            inverseJoinColumns = @JoinColumn(name = "tavolo_id"))
    private Tavolo tavolo;

    private Menù menù;

    private OrderState stato;

    private int coperti;

    private LocalTime time;

    private double totale;


    
}

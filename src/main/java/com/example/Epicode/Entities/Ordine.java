package com.example.Epicode.Entities;

import com.example.Epicode.Enums.OrderState;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("ordine_component")

public class Ordine {

    @Autowired
    private Environment env;

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

    @Value("${costo.coperto}")
    private int costoCoperto;


    public void setTotale() {

        int totaleCoperti = costoCoperto*coperti;
        int totaleMenuItems =  menù.getBibite().stream()
                .mapToInt(Bibite::getPrezzo).sum()+
        menù.getPizze().stream()
                .mapToInt(Pizza::getPrezzo).sum();

        this.totale = totaleCoperti+totaleMenuItems;
    }
}

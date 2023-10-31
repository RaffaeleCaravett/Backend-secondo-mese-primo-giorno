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

    private int costoCoperto;

    public Ordine(long id, Tavolo tavolo, Menù menù, OrderState stato, int coperti, LocalTime time, double totale,   @Value("${costo.coperto}") int costoCoperto) {
        this.id = id;
        this.tavolo = tavolo;
        this.menù = menù;
        this.stato = stato;
        this.coperti = coperti;
        this.time = time;
        this.totale = totale;
        this.costoCoperto = costoCoperto;
    }

    public void setTotale() {

        int totaleCoperti = costoCoperto*coperti;
        int totaleMenuItems =  menù.getBibite().stream()
                .mapToInt(Bibite::getPrezzo).sum()+
        menù.getPizze().stream()
                .mapToInt(Pizza::getPrezzo).sum();

        this.totale = totaleCoperti+totaleMenuItems;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", tavolo=" + tavolo.getId() +
                ", pizze =" + menù.getPizze().toString() +
                ", bibite =" + menù.getBibite().toString() +
                ", stato=" + stato +
                ", coperti=" + coperti +
                ", time=" + time +
                ", totale=" + totale +
                '}';
    }
}

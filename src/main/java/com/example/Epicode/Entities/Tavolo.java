package com.example.Epicode.Entities;

import com.example.Epicode.Enums.Stato;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component("tavolo_component")
public class Tavolo {
    @Id
    @GeneratedValue
    private Long id;

    private int maxCoperti;
    private Stato stato;

    @ManyToMany
    @JoinTable(name = "tavoli_ordini",
            joinColumns = @JoinColumn(name = "tavolo_id"),
            inverseJoinColumns = @JoinColumn(name = "ordine_id"))
    private Ordine ordine;

    public void setOrdine(Ordine ordine) {
        if(ordine.getCoperti()<=maxCoperti)this.ordine = ordine;
        else throw new IllegalArgumentException("Questo tavolo è per al massimo " + maxCoperti + (maxCoperti==1?" persona.":" persone"));
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "id=" + id +
                ", maxCoperti=" + maxCoperti +
                ", stato=" + stato +
                ", ordine=" + ordine.getId() +
                '}';
    }
}

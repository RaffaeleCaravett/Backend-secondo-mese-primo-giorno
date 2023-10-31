package com.example.Epicode;

import com.example.Epicode.Entities.*;
import com.example.Epicode.Enums.OrderState;
import com.example.Epicode.Enums.Stato;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Component("runner")
@Slf4j
public class Runner implements CommandLineRunner {
    private final Menù menù;
    private final Tavolo tavolo;
    private final Ordine ordine;

    public Runner(Menù menù, Tavolo tavolo, Ordine ordine) {
        this.menù = menù;
        this.tavolo = tavolo;
        this.ordine = ordine;
    }
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Runner.class);

        List<Pizza> pizze = new ArrayList<>();
        pizze.add((Pizza) ctx.getBean("getPizzaMargherita"));
        pizze.add((Pizza) ctx.getBean("getPizzaAmericanaMaxi"));

        List<Toppings> toppings = new ArrayList<>();

        List<Bibite> bibites = new ArrayList<>();
        bibites.add((Bibite) ctx.getBean("getCocaCola"));
        bibites.add((Bibite) ctx.getBean("getSprite"));

        Menù menù = new Menù(1,pizze,bibites,toppings);

        pizze.forEach(System.out::println);
        toppings.forEach(t -> System.out.println(t.toString()));
        bibites.forEach(System.out::println);
        System.out.println(menù);

        Tavolo tavolo1 = (Tavolo) ctx.getBean("tavolo_component");
        tavolo1.setMaxCoperti(4);
        tavolo1.setStato(Stato.LIBERO);


        Ordine ordine1 = (Ordine) ctx.getBean("ordine_component");
        ordine1.setCoperti(3);
        ordine1.setStato(OrderState.IN_CORSO);
        ordine1.setTime(LocalTime.now());
        ordine1.setTavolo(tavolo1);
        ordine1.setMenù(menù);
        ordine1.setTotale();
        tavolo1.setOrdine(ordine1);

        ctx.close();

log.info(menù.toString());

    }
}
package com.example.Epicode;

import com.example.Epicode.Entities.*;
import com.example.Epicode.Enums.OrderState;
import com.example.Epicode.Enums.Stato;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Slf4j
@ComponentScan("com.example.Epicode")
public class EpicodeApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EpicodeApplication.class, args);

configurationClass();
		System.out.println("------------------");
runner();
	}

		public static void configurationClass() {
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EpicodeApplication.class);

			List<Pizza> pizze = new ArrayList<>();
			pizze.add((Pizza) ctx.getBean("getPizzaMargherita"));
			pizze.add((Pizza) ctx.getBean("getPizzaProsciutto"));
			pizze.add((Pizza) ctx.getBean("getPizzaAmericana"));
			pizze.add((Pizza) ctx.getBean("getPizzaMargheritaMaxi"));
			pizze.add((Pizza) ctx.getBean("getPizzaProsciuttoMaxi"));
			pizze.add((Pizza) ctx.getBean("getPizzaAmericanaMaxi"));

			List<Toppings> toppings = new ArrayList<>();
			toppings.add((Toppings) ctx.getBean("getToppingProsciutto"));
			toppings.add((Toppings) ctx.getBean("getToppingWurstel"));
			toppings.add((Toppings) ctx.getBean("getToppingPatatine"));

			List<Bibite> bibites = new ArrayList<>();
			bibites.add((Bibite) ctx.getBean("getCocaCola"));
			bibites.add((Bibite) ctx.getBean("getFanta"));
			bibites.add((Bibite) ctx.getBean("getSprite"));

			Menù menù = new Menù(1,pizze,bibites,toppings);

			pizze.forEach(System.out::println);
			toppings.forEach(t -> System.out.println(t.toString()));
			bibites.forEach(System.out::println);
			System.out.println(menù);

			ctx.close();
		}

public static void runner() throws Exception {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EpicodeApplication.class);
	Runner runner = (Runner) ctx.getBean("runner");
	try {
		runner.run();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}
}

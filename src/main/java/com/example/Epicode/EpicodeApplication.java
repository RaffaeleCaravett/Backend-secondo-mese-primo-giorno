package com.example.Epicode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class EpicodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpicodeApplication.class, args);

		// METODO TRADIZIONALE

/*        FrontendStudent f = new FrontendStudent("Aldo Baglio");
        BackendStudent b = new BackendStudent("Giovanni Storti");
        FullstackStudent fs = new FullstackStudent("Giacomo Poretti");

        Interviewer i1 = new Interviewer(f);
        Interviewer i2 = new Interviewer(b);
        Interviewer i3 = new Interviewer(fs);

        i1.askQuestion();
        i2.askQuestion();
        i3.askQuestion();*/

		// configWithXML();


	}



}

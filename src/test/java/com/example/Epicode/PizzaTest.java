package com.example.Epicode;

import com.example.Epicode.Entities.Pizza;
import com.example.Epicode.Entities.Toppings;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class PizzaTest {
    @Autowired
    @Qualifier("getPizzaMargherita")
    private  Pizza margheritaPizza;
    @Autowired
    @Qualifier("getPizzaProsciutto")
    private  Pizza pizzaProsciutto;
private static AnnotationConfigApplicationContext ctx;

private Pizza testPizza;
    private List<Pizza> list = new ArrayList<>();
@BeforeAll
        static void beforeAll(){
log.info("Before All");
    ctx = new AnnotationConfigApplicationContext(EpicodeApplication.class);
}

@BeforeEach
void beforeEach(){
    testPizza=margheritaPizza;
}

    @Test
    public void testNotNull(){

    assertNotNull(testPizza);
    }

    @Test
    public void testIsSame() {
        Pizza pizza = margheritaPizza;
        assertSame(pizza, testPizza);
    }

    @Test
    public void testIsDifferent(){
      Pizza pizzaProciutt1 = pizzaProsciutto;
        assertNotSame(pizzaProciutt1,testPizza);
    }




    @Test
    public void testIsLessOrEqual(){
    list.add(pizzaProsciutto);
        list.add(margheritaPizza);
        assertFalse(list.size()>2);
    }

    @ParameterizedTest
    @CsvSource({"Margherita, Margherita" ,"Prosciutto,Prosciutto"})
    void testParameterizedStrings(String a, String nameParameter){
        String name = a;
        assertEquals(nameParameter, name);
    }
    @AfterAll
    static void afterAll(){
        ctx.close();
    }


}

package bettapiac.exu2w1d1;

import bettapiac.exu2w1d1.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Exu2w1d1ApplicationTests {
    @Autowired
    private AnnotationConfigApplicationContext ctx;
    @Autowired
    private Table t1;
    @Autowired
    private Pizza margherita;
    @Autowired
    private Menu menu;
    @Value("${app.coverChargePrice}")
    private double coverChargePrice;


    @BeforeEach
    void setupTableStatus() {
        t1.setStatus(TableStatus.FREE);
    }

    @Test
    void testCoverChargePropertyVisualization() {

        System.out.println("Test valore di CoverChargePrice: " + coverChargePrice);
        assertEquals(coverChargePrice, 3.50);
    }

    @Test
    void testSetTableStatus() {
        System.out.println("Test cambio stato del tavolo da: " + t1.getStatus());
        assertEquals(t1.getStatus(), TableStatus.FREE);
        t1.setStatus(TableStatus.TAKEN);
        System.out.println("Valore cambiato: " + t1.getStatus());
        assertEquals(t1.getStatus(), TableStatus.TAKEN);

    }

    @Test
    void testToppingListFromAPizza() {
        List<Topping> expected = List.of(
                ctx.getBean("pomodoro", Topping.class),
                ctx.getBean("mozzarella", Topping.class));
        assertEquals(margherita.getToppingsList(), expected);

    }

    @ParameterizedTest
    @CsvSource({"prosciutto, 180", "nduja, 200", "funghi, 270"})
    void testToppingCalories(String topping, int expectedCalories) {
        Topping toppingTaken = ctx.getBean(topping, Topping.class);
        int result = toppingTaken.getCalories();
        System.out.println(result);
        assertEquals(result, expectedCalories);
    }


    @ParameterizedTest
    @CsvSource({"0, 2, 1,1, 3, 33.0", "1, 2,1,0, 2, 29.50 "})
        //3 + 8 + 3 + 3 + (3*3.50)= 33,0
        // 3 + 8 + 8.50 + 3 + (2*3.50) = 29,50
    void testTotalOrderCalculation(int i1, int i2, int i3, int i4, int nCovers, double expectedResult) {
        Order order1 = new Order(
                "O01", t1,
                List.of(menu.getDrinksList().get(i1), menu.getPizzasList().get(i2), menu.getPizzasList().get(i3), menu.getDrinksList().get(i4)),
                OrderStatus.PROCESSING, nCovers, coverChargePrice);
        assertEquals(order1.getTotalPrice(), expectedResult);
    }

}

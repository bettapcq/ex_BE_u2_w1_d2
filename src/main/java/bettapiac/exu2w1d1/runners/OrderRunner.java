package bettapiac.exu2w1d1.runners;

import bettapiac.exu2w1d1.entities.Menu;
import bettapiac.exu2w1d1.entities.Order;
import bettapiac.exu2w1d1.entities.OrderStatus;
import bettapiac.exu2w1d1.entities.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRunner implements CommandLineRunner {
    @Autowired
    private Menu menu;

    @Value("${app.coverChargePrice}")
    private double coverChargePrice;

    @Autowired
    private Table t1;

    @Override
    public void run(String... args) throws Exception {
        menu.printMenu();

        Order order1 = new Order(
                "O01", t1,
                List.of(menu.getDrinksList().get(1), menu.getPizzasList().get(3), menu.getPizzasList().get(0), menu.getDrinksList().get(1)),
                OrderStatus.PROCESSING, 2, coverChargePrice);

        System.out.println(order1);

    }
}

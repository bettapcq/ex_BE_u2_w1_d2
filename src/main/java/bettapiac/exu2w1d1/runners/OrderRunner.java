package bettapiac.exu2w1d1.runners;

import bettapiac.exu2w1d1.entities.Menu;
import bettapiac.exu2w1d1.entities.Order;
import bettapiac.exu2w1d1.entities.OrderStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRunner implements CommandLineRunner {
    private Menu menu;

    @Override
    public void run(String... args) throws Exception {
        menu.printMenu();

        Order order1 = new Order(
                "O01",
                List.of(menu.getDrinksList().get(1), menu.getPizzasList().get(3), menu.getPizzasList().get(1), menu.getDrinksList()),
                OrderStatus.PROCESSING,
        );
    }
}

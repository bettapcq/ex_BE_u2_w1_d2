package bettapiac.exu2w1d1.config;

import bettapiac.exu2w1d1.entities.Drink;
import bettapiac.exu2w1d1.entities.Menu;
import bettapiac.exu2w1d1.entities.Pizza;
import bettapiac.exu2w1d1.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigClass {

    @Bean
    public Topping pomodoro() {
        return new Topping("Pomodoro", 2.30, 150, false);
    }

    @Bean
    public Topping mozzarella() {
        return new Topping("Mozzarella", 2.70, 200, false);
    }

    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 3.50, 180, false);
    }

    @Bean
    public Topping nduja() {
        return new Topping("'nduja", 3.70, 200, true);
    }

    @Bean
    public Topping funghi() {
        return new Topping("funghi", 3.00, 270, false);
    }

    @Bean
    public Topping salamino() {
        return new Topping("salamino", 3.00, 300, true);
    }

    //MARGHERITA (BASE)
    @Bean
    public Pizza margherita() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(pomodoro());
        toppingList.add(mozzarella());
        Double totPrice = toppingList.stream().mapToDouble(Topping::getPrice).sum();
        int totCalories = toppingList.stream().mapToInt(Topping::getCalories).sum();
        return new Pizza("Margherita", totPrice, totCalories, toppingList);

    }

    //PIZZA CONDITA

    public Pizza creaPizza(String name, List<Topping> toppings) {
        List<Topping> toppingList = new ArrayList<>(margherita().getToppingsList());
        toppingList.addAll(toppings);
        Double totPrice = toppingList.stream().mapToDouble(Topping::getPrice).sum();
        int totCalories = toppingList.stream().mapToInt(Topping::getCalories).sum();
        return new Pizza(name, totPrice, totCalories, toppingList);
    }

    @Bean
    public Pizza prosciuttosa() {
        return creaPizza("Prosciuttosa", List.of(prosciutto()));
    }

    @Bean
    public Pizza montanara() {
        return creaPizza("Montanara", List.of(funghi()));
    }

    @Bean
    public Pizza diavola() {
        return creaPizza("Diavola", List.of(salamino(), nduja()));
    }

    // Drink
    @Bean
    public Drink cocaCola() {
        return new Drink("Coca-Cola", 3.0, 150);
    }

    // Drink
    @Bean
    public Drink sprite() {
        return new Drink("Sprite", 3.0, 150);
    }

    // Menu
    @Bean
    public Menu getMenu() {
        return new Menu(
                List.of(
                        margherita(),
                        prosciuttosa(),
                        montanara(),
                        diavola()
                ),
                List.of(cocaCola(),
                        sprite()

                ));
    }
}


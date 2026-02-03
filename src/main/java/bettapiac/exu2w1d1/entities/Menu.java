package bettapiac.exu2w1d1.entities;

import java.util.List;

public class Menu {
    private List<Pizza> pizzasList;
    private List<Drink> drinksList;

    public Menu(List<Pizza> pizzasList, List<Drink> drinksList) {
        this.pizzasList = pizzasList;
        this.drinksList = drinksList;
    }

    public List<Pizza> getPizzasList() {
        return pizzasList;
    }

    public void setPizzasList(List<Pizza> pizzasList) {
        this.pizzasList = pizzasList;
    }

    public List<Drink> getDrinksList() {
        return drinksList;
    }

    public void setDrinksList(List<Drink> drinksList) {
        this.drinksList = drinksList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "pizzasList=" + pizzasList +
                ", drinksList=" + drinksList +
                '}';
    }

    public void printMenu() {
        System.out.println("__MENU__");

        System.out.println("__PIZZAS__");
        pizzasList.forEach(pizza -> System.out.println(pizza.getName() + " / " + pizza.getCalories()
                        + " Kgcal / " + pizza.getToppingsList().stream().map(topping -> topping.getName()).toList().toString()
                        + " / " + pizza.getPrice() + "€"
                )
        );

        System.out.println("__DRINKS__");
        drinksList.forEach(drink -> System.out.println(drink.getName() + " / " + drink.getCalories() + " Kgcal / " + drink.getPrice() + "€"));
    }
}

package bettapiac.exu2w1d1.entities;

import java.util.List;

public class Pizza extends MenuItem {
    private List<Topping> toppingsList;


    public Pizza(String name, Double price, int calories, List<Topping> toppingsList) {
        super(name, price, calories);
        this.toppingsList = toppingsList;
    }

    public List<Topping> getToppingsList() {
        return toppingsList;
    }

    public void setToppingsList(List<Topping> toppingsList) {
        this.toppingsList = toppingsList;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppingsList=" + toppingsList +
                '}';
    }
}

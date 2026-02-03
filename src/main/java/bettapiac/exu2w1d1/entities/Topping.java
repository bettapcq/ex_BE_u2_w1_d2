package bettapiac.exu2w1d1.entities;

public class Topping extends MenuItem {

    private boolean spicy;

    public Topping(String name, Double price, int calories, boolean spicy) {
        super(name, price, calories);
        this.spicy = spicy;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "spicy=" + spicy +
                '}';
    }
}

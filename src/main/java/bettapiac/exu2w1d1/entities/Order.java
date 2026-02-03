package bettapiac.exu2w1d1.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@PropertySource("application.properties")
public class Order {
    private String id;
    private Table table;
    private List<MenuItem> menuItems;
    private OrderStatus status;
    private int coverChargesNumber;
    private LocalDateTime orderTime;
    private double coverChargePrice;
    private double totalPrice;

    public Order(String id, Table table, List<MenuItem> menuItems, OrderStatus status, int coverChargesNumber, double coverChargePrice) {
        this.id = id;
        this.table = table;
        this.menuItems = menuItems;
        this.status = status;
        this.coverChargesNumber = coverChargesNumber;
        this.orderTime = LocalDateTime.now();
        this.coverChargePrice = coverChargePrice;
        getTotal();
    }

    private void getTotal() {
        double sum = 0;
        for (MenuItem item : menuItems) {
            sum += item.getPrice();
        }
        sum += coverChargesNumber * coverChargePrice;
        this.totalPrice = sum;
    }

    @Override
    public String toString() {
        return "__Order_id= '" + id + "\n"
                + "table=" + table.getNumber() + "\n"
                + "menuItems=" + menuItems.toString() + "\n"
                + "status=" + status + "\n"
                + "orderTime=" + orderTime + "\n"
                + "coverChargesNumber=" + coverChargesNumber + "\n"
                + "coverChargePrice=" + coverChargePrice + "\n"
                + "totalPrice=" + totalPrice + " €" + "\n"
                + "________";
    }
}

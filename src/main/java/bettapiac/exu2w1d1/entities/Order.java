package bettapiac.exu2w1d1.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
@PropertySource("application.properties")
@Component
public class Order {
    private String id;
    private List<MenuItem> menuItems;
    private OrderStatus status;
    private int coverChargesNumber;
    private LocalDateTime orderTime;
    
    private Double coverChargePrice;
    private Double totalPrice;

    public Order(String id, List<MenuItem> menuItems, OrderStatus status, int coverChargesNumber, LocalDateTime orderTime) {
        this.id = id;
        this.menuItems = menuItems;
        this.status = status;
        this.coverChargesNumber = coverChargesNumber;
        this.orderTime = orderTime;
        getTotal();
    }

    private void getTotal() {
        double sum = 0;
        for (MenuItem item : menuItems) {
            sum += item.getPrice();
        }
        sum += coverChargesNumber * (coverChargePrice != null ? coverChargePrice : 0);
        this.totalPrice = sum;
    }

}

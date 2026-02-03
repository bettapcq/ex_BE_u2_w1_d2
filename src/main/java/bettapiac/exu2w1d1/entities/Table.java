package bettapiac.exu2w1d1.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Table {
    private int number;
    private int maxCoversNum;
    private TableStatus status;

    public Table(int number, int maxCoversNum, TableStatus status) {
        this.number = number;
        this.maxCoversNum = maxCoversNum;
        this.status = status;
    }
}

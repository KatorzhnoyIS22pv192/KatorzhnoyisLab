package tech.reliab.course.katorzhnoy.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class BankAtm {
    private Long id;
    private String name;
    private String status;
    @ToString.Exclude
    private Bank bank;
    private String location;
    @ToString.Exclude
    private Employee servingEmployee;
    private Boolean extradition;
    private Boolean introduction;
    private Long moneyAmount;
    private Integer maintenanceCost;

}

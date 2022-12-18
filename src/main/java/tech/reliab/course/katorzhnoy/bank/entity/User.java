package tech.reliab.course.katorzhnoy.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private Long id;
    private String fullName;
    private LocalDateTime birthday;
    private String workPlace;
    private Integer income;
    private Bank banks;
    @ToString.Exclude
    private CreditAccount creditAccounts;
    @ToString.Exclude
    private PaymentAccount paymentAccounts;
    private Integer rate;
}
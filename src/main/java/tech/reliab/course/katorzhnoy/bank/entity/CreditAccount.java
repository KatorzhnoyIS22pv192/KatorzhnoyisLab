package tech.reliab.course.katorzhnoy.bank.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
public class CreditAccount {
    private Long id;
    private User user;
    private String bankName;
    private LocalDate creditStart;
    private LocalDate creditEnd;
    private Integer creditMonthCount;
    private Long creditAmount;
    private Long monthPayment;
    private Integer interestRate;
    @ToString.Exclude
    private Employee creditor;
    private PaymentAccount paymentAccount;
}

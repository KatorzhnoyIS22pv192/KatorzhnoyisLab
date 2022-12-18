package tech.reliab.course.katorzhnoy.bank.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Employee {
    private Long id;
    private String fullName;
    private LocalDateTime birthday;
    private String post;
    private Bank bank;
    private Boolean remotely;
    private BankOffice office;
    private Boolean creditAvailable;
    private Integer salary;
}
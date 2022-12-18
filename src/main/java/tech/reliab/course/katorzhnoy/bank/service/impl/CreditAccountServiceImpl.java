package tech.reliab.course.katorzhnoy.bank.service.impl;

import tech.reliab.course.katorzhnoy.bank.entity.CreditAccount;
import tech.reliab.course.katorzhnoy.bank.entity.Employee;
import tech.reliab.course.katorzhnoy.bank.entity.PaymentAccount;
import tech.reliab.course.katorzhnoy.bank.entity.User;
import tech.reliab.course.katorzhnoy.bank.service.BankService;
import tech.reliab.course.katorzhnoy.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.time.Period;

public class CreditAccountServiceImpl implements CreditAccountService {

    private CreditAccount creditAccount;
    private final BankService bankService;
    private static Long idGenerator = 0L;

    public CreditAccountServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public CreditAccount create(User user, String bankName,
                                LocalDate creditBegin, LocalDate creditEnd,
                                Long creditAmount, Long mouthPayment,
                                Employee employee, PaymentAccount paymentAccount) {
        var bank = this.bankService.getBank();
        this.creditAccount = CreditAccount
                .builder()
                .id(idGenerator++)
                .user(user)
                .bankName(bankName)
                .creditStart(creditBegin)
                .creditEnd(creditEnd)
                .creditMonthCount(Period.between(creditBegin, creditEnd).getMonths())
                .creditAmount(creditAmount)
                .monthPayment(mouthPayment)
                .interestRate(bank.getInterestRate())
                .creditor(employee)
                .paymentAccount(paymentAccount)
                .build();

        return this.creditAccount;
    }

    @Override
    public CreditAccount getCreditAccount() {
        return this.creditAccount;
    }

    @Override
    public void update(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    @Override
    public void delete(CreditAccount creditAccount) {
        this.creditAccount = null;
    }
}
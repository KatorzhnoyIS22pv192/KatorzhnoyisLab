package tech.reliab.course.katorzhnoy.bank.service.impl;

import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.entity.Employee;
import tech.reliab.course.katorzhnoy.bank.entity.User;
import tech.reliab.course.katorzhnoy.bank.service.BankService;
import tech.reliab.course.katorzhnoy.bank.service.CreditAccountService;
import tech.reliab.course.katorzhnoy.bank.service.PaymentAccountService;
import tech.reliab.course.katorzhnoy.bank.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class UserServiceImpl implements UserService {

    private User user;
    private final BankService bankService;
    private final PaymentAccountService paymentAccountService;
    private final CreditAccountService creditAccountService;
    private Employee employee;
    private static Long idGenerator = 0L;


    public UserServiceImpl(BankService bankService, PaymentAccountService paymentAccountService, CreditAccountService creditAccountService) {
        this.bankService = bankService;
        this.paymentAccountService = paymentAccountService;
        this.creditAccountService = creditAccountService;
    }

    @Override
    public User create(String fullName,
                       String workPlace,
                       Bank bank) {

        Random random = new Random();
        var userIncome = random.nextInt(10_000);
        this.user = User
                .builder()
                .id(idGenerator++)
                .fullName(fullName)
                .birthday(LocalDateTime.now().minusYears(random.nextLong(20, 50)))
                .workPlace(workPlace)
                .income(userIncome)
                .banks(bank)
                .rate(userIncome / 10)
                .build();




        var paymentAccount = this.paymentAccountService.create(this.user, bank.getName());

        var creditAccount = this.creditAccountService
                .create(this.user, bank.getName(),
                        LocalDate.now(), LocalDate.now(),
                        100_000L, 1000L,
                        this.employee, paymentAccount);
        this.user.setPaymentAccounts(paymentAccount);
        this.user.setCreditAccounts(creditAccount);

        this.bankService.addClient(bank);

        return this.user;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void update(User user) {
        this.user = user;
    }

    @Override
    public void delete(User user) {
        this.user = null;
        bankService.deleteClient(user.getBanks());
    }
}
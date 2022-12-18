package tech.reliab.course.katorzhnoy.bank.service.impl;

import tech.reliab.course.katorzhnoy.bank.entity.PaymentAccount;
import tech.reliab.course.katorzhnoy.bank.entity.User;
import tech.reliab.course.katorzhnoy.bank.service.PaymentAccountService;

import java.util.Random;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private PaymentAccount paymentAccount;
    private static Long idGenerator = 0L;


    @Override
    public PaymentAccount create(User user, String bankName) {
        Random random = new Random();
        this.paymentAccount = PaymentAccount
                .builder()
                .id(++idGenerator)
                .user(user)
                .bank(bankName)
                .moneyAmount(random.nextInt(100_000))
                .build();

        return this.paymentAccount;
    }

    @Override
    public PaymentAccount getPaymentAccount() {
        return this.paymentAccount;
    }

    @Override
    public void update(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    @Override
    public void delete(PaymentAccount paymentAccount) {
        this.paymentAccount = null;
    }
}
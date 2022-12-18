package tech.reliab.course.katorzhnoy.bank.service;

import tech.reliab.course.katorzhnoy.bank.entity.PaymentAccount;
import tech.reliab.course.katorzhnoy.bank.entity.User;

public interface PaymentAccountService {

    /**
     * Создает платежный аккаунт
     * @param user      пользователь
     * @param bankName  имя банка
     */
    PaymentAccount create(User user, String bankName);

    /**
     * Возвращает платежный аккаунт
     */
    PaymentAccount getPaymentAccount();

    /**
     * Возвращает платежный аккаунт
     */
    void update(PaymentAccount paymentAccount);

    /**
     * Удаляет платежный аккаунт
     */
    void delete(PaymentAccount paymentAccount);
}
package tech.reliab.course.katorzhnoy.bank.service;

import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.entity.BankAtm;
import tech.reliab.course.katorzhnoy.bank.entity.BankOffice;

public interface BankOfficeService {

    /**
     * Создает офис
     * @param name      имя офиса
     * @param address   адресс
     * @param bank      банк
     */
    BankOffice create(String name, String address, Bank bank, String status);

    /**
     * Возвращает офис
     */
    BankOffice getBankOffice();

    /**
     * Обновляет офис
     */
    void update(BankOffice bankOffice);

    /**
     * Удаляет банк
     */
    void delete(BankOffice bankOffice);

    /**
     * Добавляет банкомат в офис
     */
    void addAtm(BankOffice office, BankAtm bankAtm);
}
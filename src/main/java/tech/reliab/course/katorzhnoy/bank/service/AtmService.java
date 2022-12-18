package tech.reliab.course.katorzhnoy.bank.service;

import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.entity.BankAtm;
import tech.reliab.course.katorzhnoy.bank.entity.BankOffice;
import tech.reliab.course.katorzhnoy.bank.entity.Employee;

public interface AtmService {

    /**
     * Создает банкомат
     * @param name      имя банкомата
     * @param bank      банк, к котором пренадлежит банкомат
     * @param office    офис
     * @param employee  обслуживающий сотрудник
     */
    BankAtm create(String name, Bank bank, BankOffice office, Employee employee, String status);

    /**
     * Возвращает банкомат
     */
    BankAtm getBankAtm();

    /**
     * Удаляет банкомат
     */
    void delete(BankAtm bankAtm);

    /**
     * Обновляет банкомат
     */
    void update(BankAtm bankAtm);
}
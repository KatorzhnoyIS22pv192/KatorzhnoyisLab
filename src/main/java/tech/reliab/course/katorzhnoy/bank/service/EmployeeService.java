package tech.reliab.course.katorzhnoy.bank.service;

import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.entity.BankOffice;
import tech.reliab.course.katorzhnoy.bank.entity.Employee;

public interface EmployeeService {

    /**
     * Создает сотрудника банка
     * @param fullName      имя
     * @param post          должность
     * @param bank          банк
     * @param office        офис
     */
    Employee create(String fullName, String post, Bank bank, BankOffice office);

    /**
     * Возвращает сотрудника
     */
    Employee getEmployee();

    /**
     * Обновляет сотрудника
     */
    void update(Employee employee);

    /**
     * Удаляет сотрудника
     */
    void delete(Employee employee);
}
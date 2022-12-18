package tech.reliab.course.katorzhnoy.bank.service;

import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.entity.User;

public interface UserService {

    /**
     * Создает пользователя
     * @param fullName      имя
     * @param workPlace     место работы
     * @param bank          банк
     */
    User create(String fullName, String workPlace, Bank bank);

    /**
     * Возвращает пользователя
     */
    User getUser();

    /**
     * Обновляет пользователя
     */
    void update(User user);

    /**
     * Удаляет пользователя
     */
    void delete(User user);

}
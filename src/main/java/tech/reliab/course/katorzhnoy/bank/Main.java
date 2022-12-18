package tech.reliab.course.katorzhnoy.bank;

import tech.reliab.course.katorzhnoy.bank.service.*;
import tech.reliab.course.katorzhnoy.bank.service.impl.*;

public class Main {

    public static void main(String[] args) {

        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankService);
        AtmService atmService = new AtmServiceImpl(bankService, bankOfficeService);
        EmployeeService employeeService = new EmployeeServiceImpl(bankService);
        CreditAccountService creditAccountService = new CreditAccountServiceImpl(bankService);
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        UserService userService = new UserServiceImpl(bankService, paymentAccountService, creditAccountService);


        // создаем банк
        var bank = bankService.createBank("Сбербанк");

        // создаем офис
        var bankOffice = bankOfficeService.create("Офис 1", "Адрес 1, улица 1, дом 1", bank, "работает");

        // создаем работника
        var employee = employeeService.create("Иванов Иван Иванович",
                "Директор", bank, bankOffice);

        // создаем банкомат
        var atm = atmService.create("Банкомат 1", bank, bankOffice, employee, "работает");

        // создаем клиента
        var user = userService.create("Иванов Иван Иванович", "Магнит", bank);

        var creditAccount = creditAccountService.getCreditAccount();
        var paymentAccount = paymentAccountService.getPaymentAccount();

        System.out.println();
        System.out.println(bank);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(atm);
        System.out.println(user);
        System.out.println(creditAccount);
        System.out.println(paymentAccount);
    }
}
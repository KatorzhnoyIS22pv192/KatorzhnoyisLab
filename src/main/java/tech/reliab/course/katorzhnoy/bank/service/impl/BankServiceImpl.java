package tech.reliab.course.katorzhnoy.bank.service.impl;

import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.service.BankService;

import java.util.Random;

public class BankServiceImpl implements BankService {

    private Bank bank;
    private static Long idGenerator = 0L;


    @Override
    public Bank createBank(String name) {
        Random random = new Random();
        var rate = random.nextInt(100);
        this.bank = Bank
                .builder()
                .id(idGenerator++)
                .name(name)
                .officeCount(0)
                .atmCount(0)
                .employeeCount(0)
                .clientCount(0)
                .rate(rate)
                .moneyAmount(random.nextLong(1_000_000L))
                .interestRate((int) (20 - rate / 10D))
                .build();

        return bank;
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }

    @Override
    public void update(Bank bank) {
        this.bank = bank;
    }


    @Override
    public void delete(Bank bank) {
        this.bank = null;
    }


    @Override
    public void addAtm(Bank bank) {
        var bankAtmCount = bank.getAtmCount();
        bank.setAtmCount(++bankAtmCount);
        this.update(bank);
    }

    @Override
    public void deleteAtm(Bank bank) {
        var bankAtmCount = bank.getAtmCount();
        bank.setAtmCount(--bankAtmCount);
        this.update(bank);
    }

    @Override
    public void addBankOffice(Bank bank) {
        var officeCount = bank.getOfficeCount();
        bank.setOfficeCount(++officeCount);
        this.update(bank);
    }

    @Override
    public void deleteBankOffice(Bank bank) {
        var officeCount = bank.getOfficeCount();
        bank.setOfficeCount(--officeCount);
        this.update(bank);
    }

    @Override
    public void addEmployee(Bank bank) {
        var employeeCount = bank.getEmployeeCount();
        bank.setEmployeeCount(++employeeCount);
        this.update(bank);
    }

    @Override
    public void deleteEmployee(Bank bank) {
        var employeeCount = bank.getEmployeeCount();
        bank.setEmployeeCount(--employeeCount);
        this.update(bank);
    }

    @Override
    public void addClient(Bank bank) {
        var clientCount = bank.getClientCount();
        bank.setClientCount(++clientCount);
        this.update(bank);
    }

    @Override
    public void deleteClient(Bank bank) {
        var clientCount = bank.getClientCount();
        bank.setClientCount(--clientCount);
        this.update(bank);
    }
}
package tech.reliab.course.katorzhnoy.bank.service.impl;

import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.entity.BankAtm;
import tech.reliab.course.katorzhnoy.bank.entity.BankOffice;
import tech.reliab.course.katorzhnoy.bank.entity.Employee;
import tech.reliab.course.katorzhnoy.bank.service.AtmService;
import tech.reliab.course.katorzhnoy.bank.service.BankOfficeService;
import tech.reliab.course.katorzhnoy.bank.service.BankService;

import java.util.Random;


public class AtmServiceImpl implements AtmService {

    private final BankService bankService;
    private final BankOfficeService bankOfficeService;
    private static Long idGenerator = 0L;

    private BankAtm bankAtm;


    public AtmServiceImpl(BankService bankService, BankOfficeService bankOfficeService) {
        this.bankService = bankService;
        this.bankOfficeService = bankOfficeService;
    }

    @Override
    public BankAtm create(String name, Bank bank, BankOffice office, Employee employee, String status) {
        Random random = new Random();
        this.bankAtm = BankAtm
                .builder()
                .id(idGenerator++)
                .name(name)
                .location(office.getAddress())
                .status(status)
                .bank(bank)
                .servingEmployee(employee)
                .extradition(random.nextBoolean())
                .introduction(random.nextBoolean())
                .moneyAmount(bank.getMoneyAmount())
                .maintenanceCost(random.nextInt(100000))
                .build();

        this.bankService.addAtm(bank);
        this.bankOfficeService.addAtm(office, bankAtm);

        return this.bankAtm;

    }

    @Override
    public BankAtm getBankAtm() {
        return this.bankAtm;
    }

    @Override
    public void delete(BankAtm bankAtm) {
        this.bankAtm = null;
        bankService.deleteAtm(bankAtm.getBank());
    }

    @Override
    public void update(BankAtm bankAtm) {
        this.bankAtm = bankAtm;
    }
}
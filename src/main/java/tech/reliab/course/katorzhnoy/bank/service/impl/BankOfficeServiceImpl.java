package tech.reliab.course.katorzhnoy.bank.service.impl;

import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.entity.BankAtm;
import tech.reliab.course.katorzhnoy.bank.entity.BankOffice;
import tech.reliab.course.katorzhnoy.bank.service.BankOfficeService;
import tech.reliab.course.katorzhnoy.bank.service.BankService;

import java.util.Random;

public class BankOfficeServiceImpl implements BankOfficeService {

    private BankOffice bankOffice;
    private final BankService bankService;
    private static Long idGenerator = 0L;

    public BankOfficeServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public BankOffice create(String name, String address, Bank bank, String status) {
        Random random = new Random();
        this.bankOffice = BankOffice
                .builder()
                .id(idGenerator++)
                .name(name)
                .address(address)
                .status(status)
                .placeAtmAvailable(random.nextBoolean())
                .atmCount(bank.getAtmCount())
                .creditAvailable(random.nextBoolean())
                .extradition(random.nextBoolean())
                .introduction(random.nextBoolean())
                .moneyAmount(bank.getMoneyAmount())
                .rentCost(random.nextInt(100_000))
                .bank(bank)
                .build();
        this.bankService.addBankOffice(bank);

        return bankOffice;
    }

    @Override
    public BankOffice getBankOffice() {
        return this.bankOffice;
    }

    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    @Override
    public void delete(BankOffice bankOffice) {
        this.bankOffice = null;
        bankService.deleteBankOffice(bankOffice.getBank());
    }

    @Override
    public void addAtm(BankOffice bankOffice, BankAtm bankAtm) {
        var atmCount = bankOffice.getAtmCount();
        this.bankOffice.setAtmCount(++atmCount);
    }
}


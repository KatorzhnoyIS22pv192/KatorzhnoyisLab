package tech.reliab.course.katorzhnoy.bank.service.impl;

import org.apache.commons.lang3.StringUtils;
import tech.reliab.course.katorzhnoy.bank.entity.Bank;
import tech.reliab.course.katorzhnoy.bank.entity.BankOffice;
import tech.reliab.course.katorzhnoy.bank.entity.Employee;
import tech.reliab.course.katorzhnoy.bank.service.BankService;
import tech.reliab.course.katorzhnoy.bank.service.EmployeeService;

import java.time.LocalDateTime;
import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService {

    private Employee employee;
    private final BankService bankService;
    private static Long idGenerator = 0L;

    public EmployeeServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public Employee create(String fullName, String post, Bank bank, BankOffice office) {
        Random random = new Random();
        this.employee = Employee
                .builder()
                .id(idGenerator++)
                .fullName(fullName)
                .birthday(LocalDateTime.now().minusYears(random.nextLong(20, 50)))
                .post(post)
                .bank(bank)
                .remotely(random.nextBoolean())
                .office(office)
                .creditAvailable(StringUtils.equals(post, "Кредитор"))
                .salary(random.nextInt(15000, 50000))
                .build();
        bankService.addEmployee(bank);

        return employee;
    }

    @Override
    public Employee getEmployee() {
        return this.employee;
    }

    @Override
    public void update(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void delete(Employee employee) {
        this.employee = null;
        bankService.deleteEmployee(employee.getBank());
    }
}
package com.employee.management.test;

import java.util.List;

import com.employee.management.bean.EmployeeBean;
import com.employee.management.service.EmployeeService;
import com.employee.management.util.EmployeeUtil;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        // 1. Add Employees
        EmployeeBean e1 = new EmployeeBean(101, "John Doe", "IT", 55000);
        EmployeeBean e2 = new EmployeeBean(102, "Jane Smith", "HR", 45000);

        service.addEmployee(e1);
        service.addEmployee(e2);

        // 2. Show Employees
        System.out.println("\n📌 Employees List:");
        printEmployees(service.getAllEmployees());

        // 3. Update Salary
        e1.setSalary(60000);
        service.updateEmployee(e1);

        System.out.println("\n✅ Employee updated!");
        printEmployees(service.getAllEmployees());

        // 4. Delete Employee
        service.deleteEmployee(102);
        System.out.println("\n✅ Employee with ID 102 deleted!");
        printEmployees(service.getAllEmployees());
    }

    // Utility method to print employees
    private static void printEmployees(List<EmployeeBean> employees) {
        for (EmployeeBean emp : employees) {
            System.out.println(emp.getId() + " | " + emp.getName() + " | " +
                               emp.getDepartment() + " | " +
                               EmployeeUtil.formatSalary(emp.getSalary()));
        }
    }
}

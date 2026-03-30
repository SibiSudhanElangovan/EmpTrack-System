package com.employee.management.service;

import java.util.List;

import com.employee.management.bean.EmployeeBean;
import com.employee.management.dao.EmployeeDao;

public class EmployeeService {
    private EmployeeDao dao = new EmployeeDao();

    // Add employee with simple validation
    public boolean addEmployee(EmployeeBean emp) {
        if (emp.getSalary() <= 0) {
            System.out.println("❌ Salary must be greater than 0!");
            return false;
        }
        if (emp.getName() == null || emp.getName().isEmpty()) {
            System.out.println("❌ Name cannot be empty!");
            return false;
        }
        return dao.addEmployee(emp) > 0;
    }

    // Update employee
    public boolean updateEmployee(EmployeeBean emp) {
        return dao.updateEmployee(emp) > 0;
    }

    // Delete employee
    public boolean deleteEmployee(int id) {
        return dao.deleteEmployee(id) > 0;
    }

    // Get all employees
    public List<EmployeeBean> getAllEmployees() {
        return dao.getAllEmployees();
    }
}

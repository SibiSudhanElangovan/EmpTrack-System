package com.employee.management.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.employee.management.bean.EmployeeBean;
import com.employee.management.util.EmployeeUtil;

public class EmployeeDao {

    // Insert Employee
    public int addEmployee(EmployeeBean emp) {
        int status = 0;
        try (Connection con = EmployeeUtil.getConnection()) {
            String sql = "INSERT INTO employee(id, name, department, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Get All Employees
    public List<EmployeeBean> getAllEmployees() {
        List<EmployeeBean> list = new ArrayList<>();
        try (Connection con = EmployeeUtil.getConnection()) {
            String sql = "SELECT * FROM employee";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeBean emp = new EmployeeBean(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                );
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Delete Employee
    public int deleteEmployee(int id) {
        int status = 0;
        try (Connection con = EmployeeUtil.getConnection()) {
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Update Employee
    public int updateEmployee(EmployeeBean emp) {
        int status = 0;
        try (Connection con = EmployeeUtil.getConnection()) {
            String sql = "UPDATE employee SET name=?, department=?, salary=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, emp.getId());
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}

package com.employee.ui;

import javax.swing.*;

import com.employee.management.bean.EmployeeBean;
import com.employee.management.service.EmployeeService;

import java.util.List;

public class EmployeeUI {

    private static EmployeeService service = new EmployeeService();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Employee Management System");

        // Labels
        JLabel l1 = new JLabel("ID:");
        l1.setBounds(30, 30, 100, 30);

        JLabel l2 = new JLabel("Name:");
        l2.setBounds(30, 70, 100, 30);

        JLabel l3 = new JLabel("Department:");
        l3.setBounds(30, 110, 100, 30);

        JLabel l4 = new JLabel("Salary:");
        l4.setBounds(30, 150, 100, 30);

        // Text Fields
        JTextField t1 = new JTextField();
        t1.setBounds(130, 30, 150, 30);

        JTextField t2 = new JTextField();
        t2.setBounds(130, 70, 150, 30);

        JTextField t3 = new JTextField();
        t3.setBounds(130, 110, 150, 30);

        JTextField t4 = new JTextField();
        t4.setBounds(130, 150, 150, 30);

        // Buttons
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(30, 200, 80, 30);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(120, 200, 90, 30);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(220, 200, 90, 30);

        JButton viewBtn = new JButton("View");
        viewBtn.setBounds(320, 200, 80, 30);

        // Text Area
        JTextArea area = new JTextArea();
        JScrollPane pane = new JScrollPane(area);
        pane.setBounds(30, 250, 370, 150);

        // 🔥 ADD
        addBtn.addActionListener(e -> {
            try {
                EmployeeBean emp = new EmployeeBean(
                    Integer.parseInt(t1.getText()),
                    t2.getText(),
                    t3.getText(),
                    Double.parseDouble(t4.getText())
                );

                boolean status = service.addEmployee(emp);

                if (status)
                    area.setText("✅ Employee Added");
                else
                    area.setText("❌ Failed to Add");

            } catch (Exception ex) {
                area.setText("⚠️ Invalid Input");
            }
        });

        // 🔥 UPDATE
        updateBtn.addActionListener(e -> {
            try {
                EmployeeBean emp = new EmployeeBean(
                    Integer.parseInt(t1.getText()),
                    t2.getText(),
                    t3.getText(),
                    Double.parseDouble(t4.getText())
                );

                boolean status = service.updateEmployee(emp);

                area.setText(status ? "✅ Updated" : "❌ Failed");

            } catch (Exception ex) {
                area.setText("⚠️ Error");
            }
        });

        // 🔥 DELETE
        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(t1.getText());
                boolean status = service.deleteEmployee(id);

                area.setText(status ? "✅ Deleted" : "❌ Not Found");

            } catch (Exception ex) {
                area.setText("⚠️ Error");
            }
        });

        // 🔥 VIEW
        viewBtn.addActionListener(e -> {
            List<EmployeeBean> list = service.getAllEmployees();

            StringBuilder sb = new StringBuilder();

            for (EmployeeBean emp : list) {
                sb.append(emp.getId()).append(" | ")
                  .append(emp.getName()).append(" | ")
                  .append(emp.getDepartment()).append(" | ")
                  .append(emp.getSalary()).append("\n");
            }

            area.setText(sb.toString());
        });

        // Add components
        frame.add(l1); frame.add(l2); frame.add(l3); frame.add(l4);
        frame.add(t1); frame.add(t2); frame.add(t3); frame.add(t4);
        frame.add(addBtn); frame.add(updateBtn);
        frame.add(deleteBtn); frame.add(viewBtn);
        frame.add(pane);

        frame.setSize(450, 450);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
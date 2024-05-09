package com.example.ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class EmployeeInfoDialog extends JDialog {
    private JTextField nameField;
    private JTextField departmentField;
    private JSpinner ageSpinner;

    public EmployeeInfoDialog(JFrame parent) {
        super(parent, "添加员工信息", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // 创建输入字段
        nameField = new JTextField(20);
        departmentField = new JTextField(20);
        ageSpinner = new JSpinner(new SpinnerNumberModel(18, 18, 100, 1));

        // 创建布局并添加组件
        BackgroundPanel panel = new BackgroundPanel();
        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("部门:"));
        panel.add(departmentField);
        panel.add(new JLabel("年龄:"));
        panel.add(ageSpinner);

        // 添加确认和取消按钮
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton confirmButton = new JButton("确认");
        JButton cancelButton = new JButton("取消");
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // 将所有组件添加到对话框
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    public String getEmployeeName() {
        return nameField.getText();
    }

    public String getEmployeeDepartment() {
        return departmentField.getText();
    }

    public int getEmployeeAge() {
        return (int) ageSpinner.getValue();
    }
}

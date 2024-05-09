package com.example.ui;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.io.IOException;

// 继承Frame
public class AdminPortalFrame extends JFrame {
    
    // private MainFrame mainFrame;

    public AdminPortalFrame(MainFrame mainFrame){
        super("AdminPortal");
        // this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents() {
        
        // 设置窗口标题
        setTitle(Constants.ADMIN_PORTAL);
        // 设置默认关闭操作，不退出只是隐藏
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        // 设置窗口大小
        setSize(800, 600);
        // 设置窗口位置为正中间
        setLocationRelativeTo(null);

        // 创建背景面板
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new GridBagLayout());

        // 使用GridBagLayout布局管理器
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);

        // 添加按钮查询员工信息
        JButton btnQueryInfo = new JButton("查询信息");
        btnQueryInfo.setFont(new Font("微软雅黑", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(btnQueryInfo, gbc);
        // 添加按钮添加信息
        JButton btnAddInfo = new JButton("添加信息");
        btnAddInfo.setFont(new Font("微软雅黑", Font.BOLD, 24));
        gbc.gridx = 1;
        gbc.gridy = 0;
        backgroundPanel.add(btnAddInfo, gbc);
        btnAddInfo.addActionListener(e -> {
            EmployeeInfoDialog employeeInfoDialog = new EmployeeInfoDialog(this);
            employeeInfoDialog.setVisible(true);
        });
        // 添加按钮修改信息
        
        // 添加按钮删除信息
        // 添加按钮退出系统
        // 添加到窗口中
        add(backgroundPanel, BorderLayout.CENTER);
    }

}

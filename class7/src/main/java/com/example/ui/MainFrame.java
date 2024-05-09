package com.example.ui;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame{
    private EmployeePortalFrame employeePortalFrame;
    private AdminPortalFrame adminPortalFrame;
    
    /* Constructor1
     * 有参的构造方法
     * 传入EmployeePartalFrame和AdminPortalFrame参数
     * 生成有主页面组件的容器
     */
    public MainFrame(){
        this.employeePortalFrame = new EmployeePortalFrame(this);
        this.adminPortalFrame = new AdminPortalFrame(this);
        initComponents();
    }
    /* Constructor2
     * 默认的构造函数
     * 无参时默认产生一个没有任何组件的容器
     */
    /* public MainFrame() {
        this.employeePortalFrame = new EmployeePortalFrame();
        this.adminPortalFrame = new AdminPortalFrame();
        initComponents();
    } */
    
    private void initComponents() {

        setTitle(Constants.TITLE);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600 , 400);
        setLocationRelativeTo(null);

        // 创建背景面板
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new GridBagLayout());

        // 创建菜单面板,使用GridBagLayout布局
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);

        // 创建标题标签
        JLabel titleLabel = new JLabel("欢迎使用" + Constants.TITLE);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD,24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        backgroundPanel.add(titleLabel, gbc);

        // 创建分割线
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        backgroundPanel.setBorder(border);

        JLabel roleLabel = new JLabel("请选择登录角色");
        roleLabel.setFont(new Font("微软雅黑", Font.PLAIN,18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        backgroundPanel.add(roleLabel, gbc);
        

        // 创建员工登录按钮
        JButton employeeButton = new JButton("员工登录");
        employeeButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        employeeButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        backgroundPanel.add(employeeButton, gbc);

        // 创建管理员登录按钮
        JButton adminButton = new JButton("管理员登录");
        adminButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        adminButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        backgroundPanel.add(adminButton, gbc);

        // 绑定事件监听器
        employeeButton.addActionListener(e -> {openEmployeePortalFrame();});
        adminButton.addActionListener(e -> {try {
            openAdminDialog();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }});

        // 添加到主面板
        add(backgroundPanel, BorderLayout.CENTER);
    }

    void openEmployeePortalFrame() {
        employeePortalFrame.setVisible(true);
        this.setVisible(false);
    }

    void openAdminDialog() throws IOException {
        AdminLoginDialog adminLoginDialog = new AdminLoginDialog(this);
        adminLoginDialog.setVisible(true);
        this.setVisible(false);
    }

    void openAdminPortalFrame() throws IOException{
        AdminPortalFrame adminPortalFrame = new AdminPortalFrame(this);
        adminPortalFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        adminPortalFrame.setVisible(true);
        this.setVisible(false); 
    }
}
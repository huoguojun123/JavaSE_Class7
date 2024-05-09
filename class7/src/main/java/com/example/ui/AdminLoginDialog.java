package com.example.ui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPasswordField;

public class AdminLoginDialog extends JDialog {

    // 分别定义对话框中需要获取输入值的组件
    private JTextField adminnameField = new JTextField(10);
    private JPasswordField adminpasswordField = new JPasswordField(10);
    private JButton adminLoginButton;
    private MainFrame mainFrame;

    // 构造方法，传入父窗体
    public AdminLoginDialog(MainFrame mainFrame) throws IOException {
        super(mainFrame, "Login" ,true);
        this.mainFrame = mainFrame;
        initComponents();
    }

    // 初始化各个组件
    private void initComponents() throws IOException {

        // 设置标题
        setTitle(Constants.ADMIN_LOGIN_TITLE);
        // 设置默认关闭方式为隐藏页面而并不是直接退出
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // 设置窗口大小
        setSize(500, 400);
        // 设置窗口位置居中
        setLocationRelativeTo(null);

        // 同主窗口，也使用GridBagLayout布局
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.top = 10;
        gbc.insets.bottom = 10;
        gbc.insets.left = 10;
        gbc.insets.right = 10;
        
        // 创建用户名标签和输入框
        JLabel adminnameLabel = new JLabel("管理员用户名：");
        adminnameLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(adminnameLabel, gbc); // 添加到对话框中

        adminnameField.setFont(new Font("微软雅黑", Font.BOLD, 16));
        adminnameField.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(adminnameField, gbc); // 添加到对话框中

        // 创建密码标签和输入框
        JLabel passwordLabel = new JLabel("管理员密码：");
        passwordLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(passwordLabel, gbc);

       
        adminpasswordField.setFont(new Font("微软雅黑", Font.BOLD, 16));
        adminpasswordField.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(adminpasswordField, gbc);

        // 创建登录按钮
        /* 这里创建ImageIcon对象使用到了Class类(Object一个子类)
         * 通过AdminLoginDialog.class获取到Class对象
         * 使用Class的getResource获取到classpath根目录的地址
         * 而resource文件夹会被Maven打包到classpath根目录中
         */
        ImageIcon clickHereIcon = new ImageIcon(AdminLoginDialog.class.getResource("/clickhere.png"));
        adminLoginButton = new JButton("登录",clickHereIcon);
        adminLoginButton.setPreferredSize(new Dimension(150, 40));
        adminLoginButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(adminLoginButton, gbc);

        // 为登录按钮添加监听程序
        adminLoginButton.addActionListener(e -> {try {
            authenticate();
        } catch(IOException e1){
            System.out.println("出错了："+ e1.toString());
        }});

    }
    
    private void authenticate() throws IOException {
        String adminname = adminnameField.getText();
        String password = new String(adminpasswordField.getPassword());

        // 根据验证结果返回不同的操作
        if(isAdminUser(adminname, password)){
            // 验证成功，打开管理员页面
            // openAdminPortalFrame();
            // 关闭验证页面
            this.setVisible(false);
            mainFrame.openAdminPortalFrame();
        }else{
            JOptionPane.showMessageDialog(this, "登录失败", "账号或者密码错误", JOptionPane.ERROR_MESSAGE);
        }
    }
    private boolean isAdminUser(String name, String password){
        // 简单的将管理员账号设置为admin，密码设置为password
        return (name.equals("1") && password.equals("1"));
    }
}

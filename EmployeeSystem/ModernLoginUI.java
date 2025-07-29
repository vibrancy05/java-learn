package EmployeeSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ModernLoginUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private Runnable loginSuccessCallback;

    // 模拟用户数据库
    private static Map<String, String> userDatabase = new HashMap<>();
    static {
        // 初始化一个测试用户
        userDatabase.put("admin", "123456");
    }

    public ModernLoginUI() {
        super("系统登录/注册");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 550); // 增加高度以容纳注册按钮
        this.setLocationRelativeTo(null);
        initLoginUI();
    }

    public void setLoginSuccessCallback(Runnable callback) {
        this.loginSuccessCallback = callback;
    }

    private void initLoginUI() {
        // 主面板
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(70, 130, 180), 0, getHeight(), new Color(176, 224, 230));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 30, 40, 30));

        // 标题
        JLabel titleLabel = new JLabel("欢迎登录", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        // 表单面板
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 0, 15)); // 改为4行以容纳注册按钮
        formPanel.setOpaque(false);

        // 用户名输入框
        JPanel usernamePanel = new JPanel(new BorderLayout());
        usernamePanel.setOpaque(false);
        JLabel usernameLabel = new JLabel("用户名");
        usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameLabel.setForeground(Color.WHITE);
        usernameField = createStyledTextField();
        usernamePanel.add(usernameLabel, BorderLayout.NORTH);
        usernamePanel.add(usernameField, BorderLayout.CENTER);

        // 密码输入框
        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.setOpaque(false);
        JLabel passwordLabel = new JLabel("密码");
        passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordLabel.setForeground(Color.WHITE);
        passwordField = createStyledPasswordField();
        passwordPanel.add(passwordLabel, BorderLayout.NORTH);
        passwordPanel.add(passwordField, BorderLayout.CENTER);

        // 登录按钮
        loginButton = new JButton("登录");
        styleButton(loginButton, new Color(70, 130, 180));
        loginButton.addActionListener(e -> handleLogin());

        // 注册按钮
        registerButton = new JButton("注册新账号");
        styleButton(registerButton, new Color(100, 150, 200));
        registerButton.addActionListener(e -> showRegisterDialog());

        // 添加组件
        formPanel.add(usernamePanel);
        formPanel.add(passwordPanel);
        formPanel.add(loginButton);
        formPanel.add(registerButton);

        // 关闭按钮
        JButton closeButton = new JButton("×");
        closeButton.setFont(new Font("Arial", Font.BOLD, 24));
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> System.exit(0));

        mainPanel.add(closeButton, BorderLayout.NORTH);
        mainPanel.add(titleLabel, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "用户名和密码不能为空", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!userDatabase.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "用户名不存在", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!userDatabase.get(username).equals(password)) {
            JOptionPane.showMessageDialog(this, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "登录成功", "提示", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        if (loginSuccessCallback != null) {
            loginSuccessCallback.run();
        }
    }

    private void showRegisterDialog() {
        JDialog registerDialog = new JDialog(this, "注册新账号", true);
        registerDialog.setSize(350, 300);
        registerDialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 用户名输入
        JPanel usernamePanel = new JPanel(new BorderLayout());
        JLabel usernameLabel = new JLabel("用户名:");
        JTextField regUsernameField = new JTextField();
        usernamePanel.add(usernameLabel, BorderLayout.WEST);
        usernamePanel.add(regUsernameField, BorderLayout.CENTER);

        // 密码输入
        JPanel passwordPanel = new JPanel(new BorderLayout());
        JLabel passwordLabel = new JLabel("密码:");
        JPasswordField regPasswordField = new JPasswordField();
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(regPasswordField, BorderLayout.CENTER);

        // 确认密码
        JPanel confirmPanel = new JPanel(new BorderLayout());
        JLabel confirmLabel = new JLabel("确认密码:");
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPanel.add(confirmLabel, BorderLayout.WEST);
        confirmPanel.add(confirmPasswordField, BorderLayout.CENTER);

        // 注册按钮
        JButton confirmRegButton = new JButton("确认注册");
        styleButton(confirmRegButton, new Color(100, 150, 200));
        confirmRegButton.addActionListener(e -> {
            String username = regUsernameField.getText();
            String password = new String(regPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(registerDialog, "用户名和密码不能为空", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (userDatabase.containsKey(username)) {
                JOptionPane.showMessageDialog(registerDialog, "用户名已存在", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(registerDialog, "两次输入的密码不一致", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (password.length() < 6) {
                JOptionPane.showMessageDialog(registerDialog, "密码长度不能少于6位", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            userDatabase.put(username, password);
            JOptionPane.showMessageDialog(registerDialog, "注册成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            registerDialog.dispose();
        });

        panel.add(usernamePanel);
        panel.add(passwordPanel);
        panel.add(confirmPanel);
        panel.add(confirmRegButton);

        registerDialog.add(panel);
        registerDialog.setVisible(true);
    }

    private JTextField createStyledTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 255, 255, 100), 1),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        textField.setOpaque(false);
        textField.setForeground(Color.WHITE);
        textField.setBackground(new Color(255, 255, 255, 30));
        return textField;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 255, 255, 100), 1),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new Color(255, 255, 255, 30));
        return passwordField;
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("微软雅黑", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });
    }
}

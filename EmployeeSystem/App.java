package EmployeeSystem;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                ModernLoginUI loginUI = new ModernLoginUI();
                loginUI.setLoginSuccessCallback(() -> {
                    MainApplication mainApp = new MainApplication();
                    mainApp.setVisible(true);
                });

                loginUI.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "系统初始化失败: " + e.getMessage(),
                        "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

package EmployeeSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends JFrame {
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private List<Employee> employees = new ArrayList<>();
    private JTextField searchField;

    public MainApplication() {
        setTitle("员工管理系统");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 初始化测试数据
        initializeSampleData();

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 顶部搜索和添加面板
        JPanel topPanel = createTopPanel();
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // 中间表格
        JScrollPane tableScrollPane = createEmployeeTable();
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void initializeSampleData() {
        for (int i = 1; i <= 20; i++) {
            employees.add(new Employee(
                    "EMP" + String.format("%03d", i),
                    "员工" + i,
                    i % 2 == 0 ? "男" : "女",
                    20 + (i % 10),
                    "部门" + (i % 5 + 1),
                    "1380013800" + (i % 10),
                    (5000 + i * 500) + "元"
            ));
        }
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // 搜索框
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.8;
        searchField = new JTextField(20);
        searchField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        panel.add(searchField, gbc);

        // 搜索按钮
        gbc.gridx = 1;
        gbc.weightx = 0.1;
        JButton searchButton = new JButton("搜索");
        styleButton(searchButton, new Color(70, 130, 180));
        searchButton.setForeground(Color.BLACK);
        searchButton.addActionListener(e -> searchEmployees());
        panel.add(searchButton, gbc);

        // 添加员工按钮
        gbc.gridx = 2;
        gbc.weightx = 0.1;
        JButton addButton = new JButton("添加员工");
        styleButton(addButton, new Color(0, 150, 0));
        addButton.setForeground(Color.BLACK);
        addButton.addActionListener(e -> showAddEmployeeDialog());
        panel.add(addButton, gbc);

        return panel;
    }

    private JScrollPane createEmployeeTable() {
        // 表头
        String[] columnNames = {"员工ID", "姓名", "性别", "年龄", "部门", "电话", "薪资"};

        // 表格模型
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 使表格不可编辑
            }
        };

        // 填充数据
        refreshTableData(employees);

        // 创建表格
        employeeTable = new JTable(tableModel);
        employeeTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        employeeTable.setRowHeight(30);
        employeeTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));

        // 设置右键菜单
        setupRightClickMenu();

        return new JScrollPane(employeeTable);
    }

    private void setupRightClickMenu() {
        JPopupMenu popupMenu = new JPopupMenu();

        // 修改菜单项
        JMenuItem editItem = new JMenuItem("修改");
        editItem.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow >= 0) {
                showEditEmployeeDialog(employees.get(selectedRow));
            }
        });

        // 删除菜单项
        JMenuItem deleteItem = new JMenuItem("删除");
        deleteItem.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow >= 0) {
                deleteEmployee(selectedRow);
            }
        });

        popupMenu.add(editItem);
        popupMenu.add(deleteItem);

        // 添加鼠标监听器
        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = employeeTable.rowAtPoint(e.getPoint());
                    if (row >= 0 && row < employeeTable.getRowCount()) {
                        employeeTable.setRowSelectionInterval(row, row);
                        popupMenu.show(employeeTable, e.getX(), e.getY());
                    }
                }
            }
        });
    }

    private void refreshTableData(List<Employee> employeeList) {
        tableModel.setRowCount(0); // 清空表格

        for (Employee emp : employeeList) {
            Object[] rowData = {
                    emp.getId(),
                    emp.getName(),
                    emp.getGender(),
                    emp.getAge(),
                    emp.getDepartment(),
                    emp.getPhone(),
                    emp.getSalary()
            };
            tableModel.addRow(rowData);
        }
    }

    private void searchEmployees() {
        String keyword = searchField.getText().trim().toLowerCase();

        if (keyword.isEmpty()) {
            refreshTableData(employees);
            return;
        }

        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getId().toLowerCase().contains(keyword) ||
                    emp.getName().toLowerCase().contains(keyword) ||
                    emp.getDepartment().toLowerCase().contains(keyword) ||
                    emp.getPhone().toLowerCase().contains(keyword)) {
                result.add(emp);
            }
        }

        refreshTableData(result);
    }

    private void showAddEmployeeDialog() {
        JDialog dialog = new JDialog(this, "添加新员工", true);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(8, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 员工ID
        JPanel idPanel = new JPanel(new BorderLayout());
        JLabel idLabel = new JLabel("员工ID:");
        JTextField idField = new JTextField();
        idPanel.add(idLabel, BorderLayout.WEST);
        idPanel.add(idField, BorderLayout.CENTER);

        // 姓名
        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("姓名:");
        JTextField nameField = new JTextField();
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameField, BorderLayout.CENTER);

        // 性别
        JPanel genderPanel = new JPanel(new BorderLayout());
        JLabel genderLabel = new JLabel("性别:");
        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"男", "女"});
        genderPanel.add(genderLabel, BorderLayout.WEST);
        genderPanel.add(genderCombo, BorderLayout.CENTER);

        // 年龄
        JPanel agePanel = new JPanel(new BorderLayout());
        JLabel ageLabel = new JLabel("年龄:");
        JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(25, 18, 65, 1));
        agePanel.add(ageLabel, BorderLayout.WEST);
        agePanel.add(ageSpinner, BorderLayout.CENTER);

        // 部门
        JPanel deptPanel = new JPanel(new BorderLayout());
        JLabel deptLabel = new JLabel("部门:");
        JTextField deptField = new JTextField();
        deptPanel.add(deptLabel, BorderLayout.WEST);
        deptPanel.add(deptField, BorderLayout.CENTER);

        // 电话
        JPanel phonePanel = new JPanel(new BorderLayout());
        JLabel phoneLabel = new JLabel("电话:");
        JTextField phoneField = new JTextField();
        phonePanel.add(phoneLabel, BorderLayout.WEST);
        phonePanel.add(phoneField, BorderLayout.CENTER);

        // 薪资
        JPanel salaryPanel = new JPanel(new BorderLayout());
        JLabel salaryLabel = new JLabel("薪资:");
        JTextField salaryField = new JTextField();
        salaryPanel.add(salaryLabel, BorderLayout.WEST);
        salaryPanel.add(salaryField, BorderLayout.CENTER);

        // 确认按钮
        JButton confirmButton = new JButton("确认添加");
        styleButton(confirmButton, new Color(0, 150, 0));
        confirmButton.setForeground(Color.BLACK);
        confirmButton.addActionListener(e -> {
            Employee newEmployee = new Employee(
                    idField.getText(),
                    nameField.getText(),
                    (String) genderCombo.getSelectedItem(),
                    (Integer) ageSpinner.getValue(),
                    deptField.getText(),
                    phoneField.getText(),
                    salaryField.getText()
            );

            employees.add(newEmployee);
            refreshTableData(employees);
            dialog.dispose();
            JOptionPane.showMessageDialog(this, "员工添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(idPanel);
        panel.add(namePanel);
        panel.add(genderPanel);
        panel.add(agePanel);
        panel.add(deptPanel);
        panel.add(phonePanel);
        panel.add(salaryPanel);
        panel.add(confirmButton);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void showEditEmployeeDialog(Employee employee) {
        JDialog dialog = new JDialog(this, "修改员工信息", true);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(8, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 员工ID (不可编辑)
        JPanel idPanel = new JPanel(new BorderLayout());
        JLabel idLabel = new JLabel("员工ID:");
        JTextField idField = new JTextField(employee.getId());
        idField.setEditable(false);
        idPanel.add(idLabel, BorderLayout.WEST);
        idPanel.add(idField, BorderLayout.CENTER);

        // 姓名
        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("姓名:");
        JTextField nameField = new JTextField(employee.getName());
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameField, BorderLayout.CENTER);

        // 性别
        JPanel genderPanel = new JPanel(new BorderLayout());
        JLabel genderLabel = new JLabel("性别:");
        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"男", "女"});
        genderCombo.setSelectedItem(employee.getGender());
        genderPanel.add(genderLabel, BorderLayout.WEST);
        genderPanel.add(genderCombo, BorderLayout.CENTER);

        // 年龄
        JPanel agePanel = new JPanel(new BorderLayout());
        JLabel ageLabel = new JLabel("年龄:");
        JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(employee.getAge(), 18, 65, 1));
        agePanel.add(ageLabel, BorderLayout.WEST);
        agePanel.add(ageSpinner, BorderLayout.CENTER);

        // 部门
        JPanel deptPanel = new JPanel(new BorderLayout());
        JLabel deptLabel = new JLabel("部门:");
        JTextField deptField = new JTextField(employee.getDepartment());
        deptPanel.add(deptLabel, BorderLayout.WEST);
        deptPanel.add(deptField, BorderLayout.CENTER);

        // 电话
        JPanel phonePanel = new JPanel(new BorderLayout());
        JLabel phoneLabel = new JLabel("电话:");
        JTextField phoneField = new JTextField(employee.getPhone());
        phonePanel.add(phoneLabel, BorderLayout.WEST);
        phonePanel.add(phoneField, BorderLayout.CENTER);

        // 薪资
        JPanel salaryPanel = new JPanel(new BorderLayout());
        JLabel salaryLabel = new JLabel("薪资:");
        JTextField salaryField = new JTextField(employee.getSalary());
        salaryPanel.add(salaryLabel, BorderLayout.WEST);
        salaryPanel.add(salaryField, BorderLayout.CENTER);

        // 确认按钮
        JButton confirmButton = new JButton("确认修改");
        styleButton(confirmButton, new Color(70, 130, 180));
        confirmButton.addActionListener(e -> {
            employee.setName(nameField.getText());
            employee.setGender((String) genderCombo.getSelectedItem());
            employee.setAge((Integer) ageSpinner.getValue());
            employee.setDepartment(deptField.getText());
            employee.setPhone(phoneField.getText());
            employee.setSalary(salaryField.getText());

            refreshTableData(employees);
            dialog.dispose();
            JOptionPane.showMessageDialog(this, "员工信息修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(idPanel);
        panel.add(namePanel);
        panel.add(genderPanel);
        panel.add(agePanel);
        panel.add(deptPanel);
        panel.add(phonePanel);
        panel.add(salaryPanel);
        panel.add(confirmButton);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void deleteEmployee(int index) {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "确定要删除员工 " + employees.get(index).getName() + " 吗?",
                "确认删除",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            employees.remove(index);
            refreshTableData(employees);
            JOptionPane.showMessageDialog(this, "员工删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("微软雅黑", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                MainApplication app = new MainApplication();
                app.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}


/**
 * Graphical user interface for managing the employee roster in the music shop.
 * Provides comprehensive employee information display and management capabilities.
 * 
 * Key features:
 * - Dynamic employee list display
 * - Role-based filtering
 * - Work schedule visualization
 * - Detailed employee information view
 * - Real-time employee count tracking
 * 
 * Design Patterns:
 * - MVC Pattern: Separates employee data from display logic
 * - Observer Pattern: Updates display when employee data changes
 * - Filter Pattern: Role and schedule-based filtering
 * 
 * @see Employee
 * @see EmployeeData
 * @see Role
 */
package GUI;

import Model.Employee;
import Model.EmployeeData;
import Enums.Role;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The main class for the Employee Roster GUI application.
 * Extends JFrame to provide a graphical user interface.
 */
public class EmployeeRosterGUI extends JFrame {
    /**
     * Data model containing all employee information.
     */
    private EmployeeData employeeData;
    
    /**
     * Table model for displaying employee list.
     */
    private DefaultTableModel tableModel;
    
    /**
     * GUI Components.
     */
    private JTable employeeTable;
    private JComboBox<Role> roleFilter;
    private JComboBox<String> dayFilter;
    private JLabel totalEmployeesLabel;
    private JTextArea employeeDetailsArea;

    /**
     * Constructs a new EmployeeRosterGUI.
     * Initializes the employee data model and sets up the GUI components.
     */
    public EmployeeRosterGUI() {
        employeeData = new EmployeeData();
        initializeGUI();
    }

    /**
     * Initializes all GUI components and layouts.
     * Sets up the main window, filters, table, and details panel.
     */
    private void initializeGUI() {
        setTitle("Employee Roster");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(1000, 600));

        // Create the main panels
        JPanel topPanel = createTopPanel();
        JPanel centerPanel = createCenterPanel();
        JPanel rightPanel = createRightPanel();

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        // Initialize with all employees
        updateEmployeeTable(employeeData.getAllEmployees());
        updateTotalEmployeesLabel();

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Creates the top panel containing filter controls.
     * Includes role and day filters for employee list.
     * 
     * @return JPanel containing filter components
     */
    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Role filter
        panel.add(new JLabel("Filter by Role:"));
        roleFilter = new JComboBox<>(Role.values());
        roleFilter.insertItemAt(null, 0);
        roleFilter.setSelectedIndex(0);
        roleFilter.addActionListener(e -> filterEmployees());
        panel.add(roleFilter);

        // Day filter
        panel.add(new JLabel("Filter by Day:"));
        String[] days = {"All Days", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        dayFilter = new JComboBox<>(days);
        dayFilter.addActionListener(e -> filterEmployees());
        panel.add(dayFilter);

        // Total employees label
        totalEmployeesLabel = new JLabel();
        panel.add(totalEmployeesLabel);

        return panel;
    }

    /**
     * Creates the center panel containing the employee table.
     * Displays employee list with sortable columns.
     * 
     * @return JPanel containing table component
     */
    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

        // Create table model with columns
        String[] columns = {"ID", "Name", "Role", "Schedule", "Work Days", "Full Time"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Create and configure the table
        employeeTable = new JTable(tableModel);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                displayEmployeeDetails();
            }
        });

        // Set column widths
        employeeTable.getColumnModel().getColumn(0).setPreferredWidth(60);  // ID
        employeeTable.getColumnModel().getColumn(1).setPreferredWidth(150); // Name
        employeeTable.getColumnModel().getColumn(2).setPreferredWidth(100); // Role
        employeeTable.getColumnModel().getColumn(3).setPreferredWidth(150); // Schedule
        employeeTable.getColumnModel().getColumn(4).setPreferredWidth(200); // Work Days
        employeeTable.getColumnModel().getColumn(5).setPreferredWidth(80);  // Full Time

        // Center align all columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < employeeTable.getColumnCount(); i++) {
            employeeTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Creates the right panel showing detailed employee information.
     * Displays comprehensive information about the selected employee.
     * 
     * @return JPanel containing employee details
     */
    private JPanel createRightPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        panel.setPreferredSize(new Dimension(300, getHeight()));

        // Create employee details area
        employeeDetailsArea = new JTextArea();
        employeeDetailsArea.setEditable(false);
        employeeDetailsArea.setWrapStyleWord(true);
        employeeDetailsArea.setLineWrap(true);
        employeeDetailsArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        employeeDetailsArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Add title and scroll pane
        JPanel detailsPanel = new JPanel(new BorderLayout());
        detailsPanel.add(new JLabel("Employee Details", SwingConstants.CENTER), BorderLayout.NORTH);
        detailsPanel.add(new JScrollPane(employeeDetailsArea), BorderLayout.CENTER);

        panel.add(detailsPanel, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Updates the employee table with the given list of employees.
     * Refreshes the table with the specified list of employees.
     * 
     * @param employees List of employees to display
     */
    private void updateEmployeeTable(List<Employee> employees) {
        tableModel.setRowCount(0);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (Employee emp : employees) {
            String schedule = emp.getStartTime().format(timeFormatter) + " - " + 
                            emp.getEndTime().format(timeFormatter);
            String workDays = String.join(", ", emp.getWorkDays());

            Object[] rowData = {
                emp.getEmployeeId(),
                emp.getName(),
                emp.getRole(),
                schedule,
                workDays,
                emp.isFullTime() ? "Yes" : "No"
            };
            tableModel.addRow(rowData);
        }

        updateTotalEmployeesLabel();
    }

    /**
     * Filters the employee list based on selected criteria.
     * Applies role and day filters to the employee table.
     */
    private void filterEmployees() {
        List<Employee> filteredEmployees = employeeData.getAllEmployees();
        
        // Apply role filter
        Role selectedRole = (Role) roleFilter.getSelectedItem();
        if (selectedRole != null) {
            filteredEmployees = employeeData.getEmployeesByRole(selectedRole);
        }

        // Apply day filter
        String selectedDay = (String) dayFilter.getSelectedItem();
        if (!"All Days".equals(selectedDay)) {
            filteredEmployees = filteredEmployees.stream()
                .filter(emp -> emp.getWorkDays().contains(selectedDay))
                .toList();
        }

        updateEmployeeTable(filteredEmployees);
        updateTotalEmployeesLabel();
    }

    /**
     * Updates the total employees count label.
     * Shows the current number of displayed employees.
     */
    private void updateTotalEmployeesLabel() {
        int count = tableModel.getRowCount();
        totalEmployeesLabel.setText(String.format("Total Employees: %d", count));
    }

    /**
     * Displays detailed information about the selected employee.
     * Shows comprehensive employee data in the details panel.
     */
    private void displayEmployeeDetails() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow >= 0) {
            String employeeId = (String) tableModel.getValueAt(selectedRow, 0);
            Employee selected = null;
            
            // Find the selected employee
            for (Employee emp : employeeData.getAllEmployees()) {
                if (emp.getEmployeeId().equals(employeeId)) {
                    selected = emp;
                    break;
                }
            }

            if (selected != null) {
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                String details = String.format("""
                    Employee Details:
                    ----------------
                    ID: %s
                    Name: %s
                    Role: %s
                    
                    Schedule:
                    Start Time: %s
                    End Time: %s
                    Work Days: %s
                    
                    Employment Status:
                    Full Time: %s
                    Hourly Rate: $%.2f
                    Weekly Hours: %.1f
                    Weekly Salary: $%.2f
                    """,
                    selected.getEmployeeId(),
                    selected.getName(),
                    selected.getRole(),
                    selected.getStartTime().format(timeFormatter),
                    selected.getEndTime().format(timeFormatter),
                    String.join(", ", selected.getWorkDays()),
                    selected.isFullTime() ? "Yes" : "No",
                    selected.getHourlyRate(),
                    selected.calculateWeeklyHours(),
                    selected.calculateWeeklySalary()
                );
                employeeDetailsArea.setText(details);
            }
        }
    }

    /**
     * Main method to launch the Employee Roster GUI.
     * Creates and displays the roster window.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeRosterGUI().setVisible(true);
        });
    }
}

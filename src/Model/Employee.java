/**
 * Represents an employee in the music shop.
 * Manages comprehensive employee information including schedule and role.
 * 
 * Key features:
 * - Stores detailed employee information
 * - Manages work schedules and shifts
 * - Supports different employee roles
 * - Handles both full-time and part-time status
 * - Calculates working hours and salary
 * 
 * Design Pattern: Value Object Pattern
 * - Immutable employee ID
 * - Encapsulated employee data
 * 
 * @see Role
 */
package Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import Enums.Role;

public class Employee {
    /** Unique identifier for the employee. Cannot be changed after creation. */
    private final String employeeId;
    
    /** Employee's full name */
    private String name;
    
    /** Employee's role in the shop */
    private Role role;
    
    /** Daily shift start time */
    private LocalTime startTime;
    
    /** Daily shift end time */
    private LocalTime endTime;
    
    /** List of days the employee works */
    private List<String> workDays;
    
    /** Employee's hourly pay rate */
    private double hourlyRate;
    
    /** Indicates if employee is full-time (true) or part-time (false) */
    private boolean isFullTime;

    /**
     * Constructs a new Employee with specified details.
     * Creates a defensive copy of workDays list to maintain encapsulation.
     * 
     * @param employeeId Unique identifier (immutable)
     * @param name Employee's name
     * @param role Employee's role
     * @param startTime Shift start time
     * @param endTime Shift end time
     * @param workDays List of working days
     * @param hourlyRate Pay rate per hour
     * @param isFullTime Full-time status
     */
    public Employee(String employeeId, String name, Role role, LocalTime startTime, 
                   LocalTime endTime, List<String> workDays, double hourlyRate, boolean isFullTime) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workDays = new ArrayList<>(workDays);  // Defensive copy
        this.hourlyRate = hourlyRate;
        this.isFullTime = isFullTime;
    }

    /**
     * Gets the employee's unique identifier.
     * This ID is immutable and cannot be changed after creation.
     * 
     * @return Employee's unique ID
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets the employee's name.
     * 
     * @return Employee's current name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the employee's current role.
     * 
     * @return Employee's role in the shop
     * @see Role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Gets the employee's shift start time.
     * 
     * @return Daily shift start time
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Gets the employee's shift end time.
     * 
     * @return Daily shift end time
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Gets the list of days the employee works.
     * Returns a defensive copy to maintain encapsulation.
     * 
     * @return Copy of employee's working days list
     */
    public List<String> getWorkDays() {
        return new ArrayList<>(workDays);
    }

    /**
     * Gets the employee's hourly pay rate.
     * 
     * @return Current hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Checks if the employee is full-time.
     * 
     * @return true if full-time, false if part-time
     */
    public boolean isFullTime() {
        return isFullTime;
    }

    /**
     * Updates the employee's name.
     * 
     * @param name New name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Updates the employee's role.
     * 
     * @param role New role to assign
     * @see Role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Updates the employee's shift start time.
     * 
     * @param startTime New shift start time
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Updates the employee's shift end time.
     * 
     * @param endTime New shift end time
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * Updates the employee's working days.
     * Creates a defensive copy of the provided list.
     * 
     * @param workDays New list of working days
     */
    public void setWorkDays(List<String> workDays) {
        this.workDays = new ArrayList<>(workDays);
    }

    /**
     * Updates the employee's hourly pay rate.
     * 
     * @param hourlyRate New hourly rate
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Updates the employee's full-time status.
     * 
     * @param fullTime New full-time status
     */
    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    /**
     * Calculates total weekly working hours.
     * Considers shift duration and number of working days.
     * 
     * @return Total hours worked per week
     */
    public double calculateWeeklyHours() {
        double hoursPerDay = endTime.getHour() - startTime.getHour() + 
                           (endTime.getMinute() - startTime.getMinute()) / 60.0;
        return hoursPerDay * workDays.size();
    }

    /**
     * Calculates weekly salary based on hours and rate.
     * 
     * @return Total weekly salary
     */
    public double calculateWeeklySalary() {
        return calculateWeeklyHours() * hourlyRate;
    }

    /**
     * Creates a detailed string representation of the employee.
     * Includes all relevant employee information formatted for display.
     * 
     * @return Formatted string with employee details
     */
    @Override
    public String toString() {
        return String.format("Employee ID: %s%nName: %s%nRole: %s%nSchedule: %s - %s%nWork Days: %s%nHourly Rate: $%.2f%nFull Time: %s",
                employeeId, name, role, startTime, endTime, String.join(", ", workDays), hourlyRate, isFullTime ? "Yes" : "No");
    }
}

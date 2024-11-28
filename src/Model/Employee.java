package Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import Enums.Role;

public class Employee {
    private final String employeeId;
    private String name;
    private Role role;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<String> workDays;
    private double hourlyRate;
    private boolean isFullTime;

    public Employee(String employeeId, String name, Role role, LocalTime startTime, 
                   LocalTime endTime, List<String> workDays, double hourlyRate, boolean isFullTime) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workDays = new ArrayList<>(workDays);
        this.hourlyRate = hourlyRate;
        this.isFullTime = isFullTime;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public List<String> getWorkDays() {
        return new ArrayList<>(workDays);  // Return a copy to prevent external modification
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    // Setters (except for employeeId which is final)
    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setWorkDays(List<String> workDays) {
        this.workDays = new ArrayList<>(workDays);
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    // Calculate weekly hours
    public double calculateWeeklyHours() {
        double hoursPerDay = endTime.getHour() - startTime.getHour() + 
                           (endTime.getMinute() - startTime.getMinute()) / 60.0;
        return hoursPerDay * workDays.size();
    }

    // Calculate weekly salary
    public double calculateWeeklySalary() {
        return calculateWeeklyHours() * hourlyRate;
    }

    @Override
    public String toString() {
        return String.format("Employee ID: %s%nName: %s%nRole: %s%nSchedule: %s - %s%nWork Days: %s%nHourly Rate: $%.2f%nFull Time: %s",
                employeeId, name, role, startTime, endTime, String.join(", ", workDays), hourlyRate, isFullTime ? "Yes" : "No");
    }
}

package com.model;

public class Employee
{
    private String employeeName;
    private int employeeId;
    private Project project;

    public Employee(String employeeName, int employeeId )
    {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public String setEmployeeName(String employeeName)
    {
        return this.employeeName = employeeName;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public int setEmployeeId( int employeeId)
    {
        return this.employeeId = employeeId;
    }
}

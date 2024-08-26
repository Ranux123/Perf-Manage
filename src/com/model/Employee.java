package com.model;

public class Employee
{
    private String employeeName;
    private String employeeId;
    private Project project;

    public Employee( String employeeName, String employeeId )
    {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public Employee( String employeeName, String employeeId, Project project )
    {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.project = project;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public String setEmployeeName(String employeeName)
    {
        return this.employeeName = employeeName;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public String setEmployeeId( String employeeId)
    {
        return this.employeeId = employeeId;
    }

    public Project getProject()
    {
        return project;
    }

    public void setProject( Project project )
    {
        this.project = project;
    }
}

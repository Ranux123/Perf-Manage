package com.service;

import java.util.Scanner;

public class EmployeeService
{
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m"; //GREEN - CLI
    public static final String CYAN = "\u001B[36m"; //CYAN - CLI
    public static final String ORANGE = "\u001B[33m"; // ORANGE - CLI
    public static final String PURPLE = "\u001B[35m"; //PURPLE - CLI
    public static final String PINK = "\u001B[38;2;255;192;203m"; //PINK = CLI

    private int totalVacancies = 40;
    private int totalVacanciesObject = 40;
    private String[][] employees = new String [totalVacancies][2];
    private String[] employeesObject = new String [totalVacanciesObject];
    private int noOfEmployees = 0;
    private int noOfEmployeesObject = 0;

    Scanner sc = new Scanner(System.in);

    public void checkAvailableVacancies()
    {
        int availableVacancies = totalVacancies - noOfEmployees;
        System.out.println(CYAN + "Available Seats: " + availableVacancies + RESET);
    }

    public void registerEmployee()
    {
        String employeeId = "";
        if (noOfEmployees < totalVacancies)
        {
            while (true)
            {
                System.out.println(ORANGE + "Enter the employee ID: " + RESET);
                employeeId = sc.nextLine();

                if (!(employeeId.length() == 8 && employeeId.startsWith("w")))
                {
                    System.out.println(CYAN + "Please enter a valid employee ID." + RESET);
                }
                else
                {
                    break;
                }
            }

            for (int i = 0; i < noOfEmployees; i++)
            {
                if (employees[i][0].equals(employeeId))
                {
                    System.out.println(CYAN + "Entered employee ID already exists. Please enter a another" + RESET);
                    return;
                }
            }
            System.out.println("Enter the employee name of the ID "  + employeeId + " : ");
            String employeeName = sc.nextLine();
            employees[noOfEmployees][0] = employeeId;
            employees[noOfEmployees][1] = employeeName;
            noOfEmployees++;
            System.out.println(CYAN + "Employee registered successfully!" + RESET);
        }
        else
        {
            System.out.println(CYAN + "No vacancies left. " + RESET);
        }
    }

    public void deleteEmployee()
    {

    }

    public void findEmployee()
    {

    }

    public void storeEmployeesInAFile()
    {

    }

    public void loadEmployeesFromTheFile()
    {

    }

    public void viewTheEmployees()
    {

    }

    public void addEmployeeAndScores()
    {

    }

    public void generateSummaryReport()
    {

    }

    public void generateCompleteReport()
    {

    }
}

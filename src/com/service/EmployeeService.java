package com.service;

import com.model.Employee;
import com.model.Project;
import com.utils.EmployeeUtils;

import java.io.File;
import java.io.FileWriter;
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
  private String[][] employees = new String[totalVacancies][2];
  private Employee[] employeesObject = new Employee[totalVacanciesObject];
  private int noOfEmployees = 0;
  private int noOfEmployeesObject = 0;

  Scanner sc = new Scanner( System.in );

  /**
   * This method is used to check the available vacancies in the system.
   */
  public void checkAvailableVacancies()
  {
    int availableVacancies = totalVacancies - noOfEmployees;
    System.out.println( CYAN + "Available Seats: " + availableVacancies + RESET );
  }

  /**
   * This method is used to register an employee with the ID.
   */
  public void registerEmployee()
  {
    String employeeId = "";
    if( noOfEmployees < totalVacancies )
    {
      while( true )
      {
        System.out.println( ORANGE + "Enter the employee ID: " + RESET );
        employeeId = sc.nextLine();

        if( !( employeeId.length() == 8 && employeeId.startsWith( "w" ) ) )
        {
          System.out.println( CYAN + "Please enter a valid employee ID of 8 characters which starts with w (w#######)" + RESET );
        }
        else
        {
          break;
        }
      }

      for( int i = 0; i < noOfEmployees; i++ )
      {
        if( employees[i][0].equals( employeeId ) )
        {
          System.out.println( CYAN + "Entered employee ID already exists. Please enter a another" + RESET );
          return;
        }
      }
      System.out.println( ORANGE + "Enter the employee name of the ID " + employeeId + " : " + RESET );
      String employeeName = sc.nextLine();
      employees[noOfEmployees][0] = employeeId;
      employees[noOfEmployees][1] = employeeName;
      noOfEmployees++;
      System.out.println( CYAN + "Employee registered successfully!" + RESET );
    }
    else
    {
      System.out.println( CYAN + "No vacancies left. " + RESET );
    }
  }

  /**
   * This method is used to delete an employee from the system.
   */
  public void deleteEmployee()
  {
    while( true )
    {
      System.out.println( ORANGE + "Enter the employee ID to delete: " + RESET );
      String employeeId = sc.nextLine();
      boolean employeeFound = false;

      for( int i = 0; i < noOfEmployees; i++ )
      {
        if( employees[i][0].equals( employeeId ) )
        {
          employees[i][0] = employees[noOfEmployees - 1][0];
          employees[i][1] = employees[noOfEmployees - 1][1];
          noOfEmployees--;
          System.out.println( CYAN + "Employee deleted Successfully!" + RESET );
          employeeFound = true;
          break;
        }
      }
      if( !employeeFound )
      {
        System.out.println( CYAN + "Employee not found. Please enter a valid employee ID." + RESET );
        continue;
      }
      break;
    }
  }

  /**
   * This method is used to find an employee by ID.
   */
  public void findEmployee()
  {
    while( true )
    {
      System.out.println( ORANGE + "Enter the employee ID to find: " + RESET );
      String employeeId = sc.nextLine();
      boolean employeeFound = false;

      for( int i = 0; i < noOfEmployees; i++ )
      {
        if( employees[i][0].equals( employeeId ) )
        {
          System.out.println( CYAN + "Employee ID: " + employees[i][0] + RESET );
          System.out.println( CYAN + "Employee Name: " + employees[i][1] + RESET );
          employeeFound = true;
          break;
        }
      }
      if( !employeeFound )
      {
        System.out.println( CYAN + "Employee not found. Please enter a valid employee ID." + RESET );
        continue;
      }
      break;
    }
  }

  /**
   * This method is used to store the employees in a file.
   */
  public void storeEmployeesInAFile()
  {
    try( FileWriter file = new FileWriter( "employee.txt" ) )
    {
      for( int i = 0; i < noOfEmployees; i++ )
      {
        file.write( employees[i][0] + "," + employees[i][1] + "\n" );
      }
      System.out.println( CYAN + "Employees stored in the file successfully!" + RESET );
    }
    catch( Exception e )
    {
      System.out.println( CYAN + "An error occurred while storing the employees in the file." + RESET );
    }
  }

  /**
   * This method is used to load the employees from the file.
   */
  public void loadEmployeesFromTheFile()
  {
    System.out.println( ORANGE + "Enter an accurate file name to load employee data: " );
    String fileName = sc.nextLine();

    File file = new File( fileName );
    try
    {
      Scanner fileScanner = new Scanner( file );
      while( fileScanner.hasNextLine() )
      {
        String line = fileScanner.nextLine();
        String[] employeeData = line.split( "," );
        if( employeeData.length != 2 )
        {
          System.out.println( CYAN + "Invalid employee data format in the file. Skipped" + RESET );
          continue;
        }
        String employeeId = employeeData[0];
        String employeeName = employeeData[1];

        if( employeeId.length() != 8 || !employeeId.startsWith( "w" ) )
        {
          System.out.println( CYAN + "Invalid employee ID in the file. Skipped" + RESET );
          continue;
        }

        boolean employeeExists = false;
        for( int i = 0; i < noOfEmployees; i++ )
        {
          if( employeeId.equals( employees[i][0] ) )
          {
            System.out.println( CYAN + "Employee ID - " + employeeId + " already exists in the system. Skipped." + RESET );
            employeeExists = true;
            break;
          }

        }
        if( !employeeExists )
        {
          employees[noOfEmployees][0] = employeeData[0];
          employees[noOfEmployees][1] = employeeData[1];
          noOfEmployees++;
        }

      }
      System.out.println( CYAN + "Employees loaded from the file successfully!" + RESET );
    }
    catch( Exception e )
    {
      System.out.println( CYAN + "An error occurred while loading the employees from the file." + e.getMessage() + RESET );
    }
  }

  /**
   * This method is used to view the employees.
   */
  public void viewTheEmployees()
  {
    if( noOfEmployees == 0 )
    {
      System.out.println( CYAN + "No employees to display" + RESET );
      return;
    }

    boolean swapped;
    do
    {
      swapped = false;
      for( int i = 0; i < noOfEmployees - 1; i++ )
      {
        if( employees[i][1] != null && employees[i + 1][1] != null )
        {
          if( employees[i][1].compareToIgnoreCase( employees[i + 1][1] ) > 0 )
          {
            String[] tempholder = employees[i];
            employees[i] = employees[i + 1];
            employees[i + 1] = tempholder;
            swapped = true;
          }
        }
      }
    } while( swapped );

    System.out.println( PURPLE + "-+-+-+- List of all the employees registered -+-+-+-" + PURPLE );
    for( int i = 0; i < noOfEmployees; i++ )
    {
      if( employees[i][0] != null && employees[i][1] != null )
      {
        System.out.println( CYAN + "EmployeeID : " + employees[i][0] + " Employee Name : " + employees[i][1] + RESET );
      }
    }
  }

  /**
   * This method is used to add an employee and their project scores.
   */
  public void addEmployeeAndScores()
  {
    String employeeId;
    if( noOfEmployeesObject == totalVacanciesObject )
    {
      System.out.println( CYAN + "No vacancies left." + RESET );
      return;
    }
    while( noOfEmployeesObject < totalVacanciesObject )
    {
      while( true )
      {
        System.out.println( ORANGE + "Enter the employee ID: " + RESET );
        employeeId = sc.nextLine();
        if( !( employeeId.length() == 8 && employeeId.startsWith( "w" ) ) )
        {
          System.out.println( CYAN + "Please enter a valid employee ID." + RESET );
          continue;
        }

        boolean employeeExists = false;
        for( int i = 0; i < noOfEmployeesObject; i++ )
        {
          if( employeesObject[i].equals( employeeId ) )
          {
            employeeExists = true;
            break;
          }
        }

        if( employeeExists )
        {
          System.out.println( CYAN + "Employee ID already exists. Please enter another." + RESET );
        }
        else
        {
          break;
        }
      }

      System.out.println( ORANGE + "Enter the employee name of the ID " + employeeId + " : " + RESET );
      String employeeName = sc.nextLine();

      Employee employee = new Employee( employeeName, employeeId );
      int score1 = EmployeeUtils.getProjectScore( sc, 1, employeeId );
      int score2 = EmployeeUtils.getProjectScore( sc, 2, employeeId );
      int score3 = EmployeeUtils.getProjectScore( sc, 3, employeeId );

      Project project = new Project( score1, score2, score3 );
      employee.setProject( project );

      employeesObject[noOfEmployeesObject] = employee;
      noOfEmployeesObject++;

      break;
    }
  }

  /**
   * This method is used to generate the summary report.
   */
  public void generateSummaryReport()
  {
    System.out.println(PURPLE + "-+-+-+-+- Summary Report -+-+-+-+-" + RESET);
    System.out.println(PURPLE + "Total Employee Registration: " + RESET + PINK + noOfEmployeesObject + RESET);

    int passedEmployees = 0;
    int failedEmployees = 0;
    for (int i = 0; i < totalVacanciesObject; i++)
    {
      Employee employee = employeesObject[i];
      if (employee != null && employee.getProject() != null)
      {
        Project project = employee.getProject();
        if (project.getScore1() >= 40 && project.getScore2() >= 40 && project.getScore3() >= 40)
        {
          passedEmployees++;
        }
        else
        {
          failedEmployees++;
        }
      }
    }
    System.out.println(PURPLE + "Total Employees Passed: " + RESET + PINK + passedEmployees + RESET);
    System.out.println(PURPLE + "Total Employees Failed: " + RESET + PINK + failedEmployees + RESET);
    System.out.println(PURPLE + "-+-+-+-+-+-+-+-+ -+-+-+-+-+-+-+-+" + RESET);
  }

  /**
   * This method is used to generate the complete report.
   */
  public void generateCompleteReport()
  {
    System.out.println( PURPLE + "\t\t-+-+-+-+-+-+-+-+-+-+-+-+-+-+- Complete Report -+-+-+-+-+-+-+-+-+-+-+-+-+-+-" + RESET );
    System.out.println( PURPLE + "ID\t\t\tName\t\tProject 1\tProject 2\tProject 3\tTotal\t\tGrade -> Average" + RESET );

    EmployeeUtils.bubbleSortAverageScore( employeesObject );

    ProjectService projectService = new ProjectService();

    for( int i = 0; i < noOfEmployeesObject; i++ )
    {
      Employee employee = employeesObject[i];
      if( employee != null && employee.getProject() != null )
      {
        Project project = employee.getProject();
        int totalScore = projectService.calculateTotalScore( project.getScore1(), project.getScore2(), project.getScore3() );
        String grade = projectService.calculateGradeScore( project.getScore1(), project.getScore2(), project.getScore3() );
        System.out.println( PINK +  employee.getEmployeeId() + "\t" +
                                    employee.getEmployeeName() + "\t\t" +
                                    project.getScore1() + "\t\t\t" +
                                    project.getScore2() + "\t\t\t" +
                                    project.getScore3() + "\t\t\t" +
                                    totalScore + "\t\t\t" +
                                    grade + RESET );
      }
    }
  }
}

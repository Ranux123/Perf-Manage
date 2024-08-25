package com.utils;

import com.model.Employee;
import com.service.ProjectService;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.service.EmployeeService.*;

public class EmployeeUtils
{
  public static int getProjectScore(Scanner sc, int projectNumber, String employeeId) {
    int mark;
    while (true) {
      try {
        System.out.print(ORANGE + "Enter Score for Project " + projectNumber + " of the employee " + employeeId + ": " + RESET);
        mark = sc.nextInt();
      } catch ( InputMismatchException e) {
        System.out.println(CYAN + "Please enter an integer as the score." + RESET);
        sc.next();
        continue;
      }

      if (0 <= mark && mark <= 100) {
        break;
      } else {
        System.out.println(CYAN + "Please enter a score between 0-100." + RESET);
      }
    }
    return mark;
  }

  public static void bubbleSortAverageScore( Employee[] employeesObject)
  {
    ProjectService projectService = new ProjectService();
    for (int i = 0; i < employeesObject.length - 1; i++ )
    {
      for (int j = 0; j < employeesObject.length - i - 1; j++)
      {
        if (employeesObject[j] != null && employeesObject[j + 1] != null)
        {
          double averageScore1 = projectService.calculateAverageScore(employeesObject[j].getProject().getScore1() , employeesObject[j].getProject().getScore2(), employeesObject[j].getProject().getScore3());
          double averageScore2 = projectService.calculateAverageScore(employeesObject[j+1].getProject().getScore1() , employeesObject[j+1].getProject().getScore2(), employeesObject[j+1].getProject().getScore3());
          if (averageScore2 < averageScore1)
          {
            Employee temp = employeesObject[j];
            employeesObject[j] = employeesObject[j+1];
            employeesObject[j+1] = temp;
          }
        }
      }
    }
  }
}

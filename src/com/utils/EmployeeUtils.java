package com.utils;

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
}

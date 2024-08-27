package test.utils;

import com.model.Employee;
import com.model.Project;
import com.utils.EmployeeUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeUtilsTest
{
  @Test
  public void bubbleSortAverageScore_sortsCorrect()
  {
    Employee[] employees = new Employee[3];
    employees[0] = new Employee("Ranuth", "w2083750", new Project(50, 70, 100));
    employees[1] = new Employee("Mishal", "w2083751", new Project(50, 70, 100));
    employees[2] = new Employee("Yasith", "w2083752", new Project(50, 70, 100));

    EmployeeUtils.bubbleSortAverageScore( employees );

    assertTrue( employees[0].getEmployeeName().equals( "Ranuth" ) );
    assertTrue( employees[1].getEmployeeName().equals( "Mishal" ) );
    assertTrue( employees[2].getEmployeeName().equals( "Yasith" ) );
    assertTrue( employees[0].getEmployeeId().equals( "w2083750" ) );
    assertTrue( employees[1].getEmployeeId().equals( "w2083751" ) );
    assertTrue( employees[2].getEmployeeId().equals( "w2083752" ) );
  }
}

import com.service.EmployeeService;

import java.util.InputMismatchException;
import java.util.Scanner;


public class EmployeeManagementSystem
{
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m"; //GREEN - CLI
    public static final String CYAN = "\u001B[36m"; //CYAN - CLI
    public static final String ORANGE = "\u001B[33m"; // ORANGE - CLI
    public static final String PURPLE = "\u001B[35m"; //PURPLE - CLI
    public static final String PINK = "\u001B[38;2;255;192;203m"; //PINK = CLI

    public static void main( String[] args )
    {
        Scanner sc = new Scanner( System.in );
        EmployeeService employeeService = new EmployeeService();
        while( true )
        {
            System.out.println( GREEN + "1.  Check the availability of the vacancies." + RESET );
            System.out.println( GREEN + "2.  Register an employee with the ID." + RESET );
            System.out.println( GREEN + "3.  Delete an employee" + RESET );
            System.out.println( GREEN + "4.  Find an employee by ID." + RESET );
            System.out.println( GREEN + "5.  Store employee information into an external file." + RESET );
            System.out.println( GREEN + "6.  Load employee details from an external file." + RESET );
            System.out.println( GREEN + "7.  View a list of registered employees." + RESET );
            System.out.println( GREEN + "8.  Add an employee and their Marks . Summary Report . Complete Report" + RESET );
            System.out.println( GREEN + "9.  Exit the Programme." + RESET );
            System.out.println();
            System.out.print( ORANGE + "Enter a option in order to proceed: " + RESET );
            int opt = 0;
            try
            {   //Checking whether the input is matching with the data type we want to take.
                opt = sc.nextInt();
            }
            catch( InputMismatchException e )
            {    //If  there is an input mismatch then ask the user to input an option again
                System.out.println( CYAN + "Please enter a valid input from 1-8." + RESET );
            }
            sc.nextLine();
            switch( opt )
            {
                case 1: //Available Seats Feature.
                    employeeService.checkAvailableVacancies();
                    break;
                case 2: //Register Students Feature.

                    employeeService.registerEmployee();
                    break;
                case 3: //Delete a Student from the system.
                    employeeService.deleteEmployee();
                    break;
                case 4: //Find a student by Student ID.
                    employeeService.findEmployee();
                    break;
                case 5: //Store the Students in a File.
                    employeeService.storeEmployeesInAFile();
                    break;
                case 6: //Load Students from the File to the System.
                    employeeService.loadEmployeesFromTheFile();
                    break;
                case 7: //View the registered Students List sorted by Name.
                    employeeService.viewTheEmployees();
                    break;
                case 8: //Handling the Task 2 & Task 3 features as sub-options of option 8 as a, b, c
                    System.out.print( ORANGE + "Enter a sub-option (a -> Add Students and Scores), (b -> Summary Report), (c -> Complete Report): " + RESET );
                    String opt2 = sc.nextLine().toLowerCase();
                    switch( opt2 )
                    {
                        case "a":
                            employeeService.addEmployeeAndScores();
                            break;
                        case "b":
                            employeeService.generateSummaryReport();
                            break;
                        case "c":
                            employeeService.generateCompleteReport();
                            break;
                        default:
                            System.out.println( CYAN + "Invalid sub-option." + RESET );
                            break;
                    }
                    break;
                case 9: // This will perform the force quitting the program.
                    System.exit( 0 );
                default: // If the user doesn't enter a choice which we don't present (1-9). Then a message will prompt and ask user to input a valid choice input.
                    System.out.println( GREEN + "Invalid choice. Please enter a choice between 1-9." + RESET );
            }
        }
    }
}
package Assignment_code;
import java.util.InputMismatchException;


/**
 * Name: Stephen Curran
 * Student Number: L00107244
 * Date 05/11/2015
 * Assignment Stage 2
 */

import java.util.Scanner;

public class Menu
{
	
  //creates option variable
  private int option;
  //Display method
  protected final void Display()
  {
	  //prints out add option
	  System.out.println("\t1. add");
	  //prints out list option
	  System.out.println("\t2. List");
	  //prints out veiw option
	  System.out.println("\t3. Veiw");
	  //prints out edit option
	  System.out.println("\t4 Edit");
	  //prints out delete option
	  System.out.println("\t5 Delete");
	  //prints out Quit option
	  System.out.println("\t6 Run Garbage Collection");
	  
	  System.out.println("\t7 Quit");
	
  }
  //read method
  protected final void readOption()
  {
	  @SuppressWarnings("resource")
	Scanner keyIn = new Scanner(System.in);
	  //allows user to enter option
      	try
      	{
      		  System.out.println("\n\nEnter Option: [1|2|3|4|5|6|7] ");
      		  option=keyIn.nextInt();
      	}
        catch(InputMismatchException iME)
        {
				System.out.println("you have entered a charcter pleaase enter a digit");
			
        }
        catch(Exception e)
      	{
				System.out.println("An Error Occurred.");
	    }
  }
      	
	  
	  
  
  // return option
  protected final int getOption()
  {
	  return option;
  }
}

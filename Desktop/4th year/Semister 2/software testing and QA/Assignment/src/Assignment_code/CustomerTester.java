package Assignment_code;

import java.util.Scanner;

import java.util.Date;
public class CustomerTester
{
	private static final long MegaBytes = 1024 * 1024;
	private static final int exitoption = 7;
  public static void main(String[] args)
  {
	  //calls in scanner 
	
	@SuppressWarnings({ "unused", "resource" })
	Scanner keyBoard = new Scanner(System.in);
	   //calls in customer file handler class
	   CustomerFileHandeler cfh = new CustomerFileHandeler();
	   @SuppressWarnings("unused")
	long freeMemory;
	   @SuppressWarnings("unused")
	long totalMemory;
	   long usedMemory;
	  //calls in menu class
	  Menu menu = new Menu();
	  //do while loop
	  do
	  {
		  //displays the menu
		  menu.Display();
		  //reads option from the user
		  menu.readOption();
		  
		  switch(menu.getOption())
		  {
		  //case 1 is to add a user
		  case 1: cfh.add();
		  break;
		//case 2 is to  list users
		  case 2: cfh.List();
		       
		  break;
		//case 3 is to veiw a user
		  case 3:cfh.printID(); 
			     cfh.veiw();
		  break;
		//case 4 is to edit a user
		  case 4:cfh.printID(); 
			     cfh.Edit();
		  break;
		//case 5 is to delete a user
		  case 5:cfh.printID(); 
			     cfh.Delete();
		  break;
		//case 6 run garbage collection
		  case 6:  Runtime run = Runtime.getRuntime();
		  freeMemory = run.freeMemory();
          totalMemory = run.totalMemory();
          usedMemory = run.totalMemory() - run.freeMemory();
          System.out.println("The amount of memory used before garbage collection was: " + String.valueOf(bytesToMegabytes(usedMemory)) +" megabytes");
		  run.gc();
	      usedMemory = run.totalMemory() - run.freeMemory();
	      System.out.println("The amount of memory used after garbage collection was: " + String.valueOf(bytesToMegabytes(usedMemory))+" megabytes");
		  break;
		  //Quit
		  case 7: System.out.println("Goodbye!");
		  break;
		//default
		  default: System.out.println("Invalied option entered");
			  
		  }
	  }
	  //while loop
	   while(menu.getOption() != exitoption);
	  //writes recrds to file
	  cfh.writeARecordToFile();
	  Date date = new Date();

      // display time and date using toString()
      System.out.println("Customers written to file on: "+date.toString());
      
     
	   
  }
  public static long bytesToMegabytes(long bytes)
  { 
	  return bytes / MegaBytes;
  }
}

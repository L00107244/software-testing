package Assignment_code;
/*
 * Stephen Curran
 * L00107244
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerFileHandeler 
{
	//creates array list of customer
   private ArrayList <Customer> customers;
   //calls in the scanner
   private Scanner keyBoard = new Scanner(System.in);
   private static final int SetToZero = 0;

   //default constructor 
   protected CustomerFileHandeler()
   {
	   //sets customers to array list
	   customers = new ArrayList<Customer>();
   }
   //add method
   protected final void add()
   {
	   try{
		   Customer Cust = new Customer();
		 
		   //call read method here
		   Cust.read();
		   // call it a differnt object
		   customers.add(Cust);
		
	  }
	  catch(Exception e)
	  {
		  System.out.print("Error");
	  }
	  
   }
   
   //write record to file method
   protected final void writeARecordToFile()
   {
	   try{
		   
	   FileOutputStream fileStream = new FileOutputStream("Customer.txt");
	   ObjectOutputStream outStream = new ObjectOutputStream(fileStream);
	   outStream.writeObject(customers);
	   outStream.close();
	   
	   }
	   catch(FileNotFoundException fnfe)
	   {
		   System.out.println("Cannot create file to store Customer");
	   }
	   catch(Exception e)
	   {
		   System.out.println(e.getMessage());
	   }
	 }

	@SuppressWarnings("unchecked") 
	public void readRecordsFromFile(){
		try{
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream("Customer.txt");
	
			ObjectInputStream is = new ObjectInputStream(fileStream);
		
			//videos = (ArrayList<Video>)is.readObject();

			// COULD use code below to ensure it is an ArrayList
			// BUT no need-we are confident file contains an ArrayList
			 Object o = is.readObject(); 	// READ an object from the file
			 if(o instanceof ArrayList)  	// IF object is an ArrayList
				 customers=(ArrayList<Customer>)o;//    ASSIGN object to videos
		
			is.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
   //list method

   protected final void List()
   {
	  //creates for loop to print out customers
	 for(Customer custF: customers)
		 System.out.println(custF);
   }
   protected void printID()
   {
	   for(Customer custV: customers)
	   {
		   System.out.println("Custemer ids:"+custV.getID());
	   }
   }
   //Veiw method
   protected final void veiw()
   {
	   
	   try{
		   System.out.println("Enter the id of the customer you are searching for:");
		   int custIdToGet = keyBoard.nextInt();
		 //for loop to print out a certin customer
		   for(Customer custF: customers)
		   {
			  
				   if(custF.getID() == custIdToGet)
				   {
					   System.out.println(custF);
				   }
		   }
		   
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
   //delete method
   protected final void Delete()
   {
	 try
	 {
	   System.out.println("Enter ID of customer to delete: ");
	   int CustomerToDelete = keyBoard.nextInt();
	   //for loop to loop threw customers 
	   for(Customer CustF: customers)
	   {
		   if(CustF.getID() == CustomerToDelete)
		   {
		     System.out.println(CustF);
		     //deletes a record from a file
		     customers.remove(CustF);
		     
		     break;
		   }
	   }
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
   //Edit method
   protected final void Edit()
   {
	 try
	 {
	   System.out.println(" Enter ID of customer to edit");
	   int CustomerToEdit = keyBoard.nextInt();
	   //for loop to loop threw customers
	   for(Customer CustF: customers)
	   {
		   if(CustF.getID() == CustomerToEdit)
		   {
			   System.out.println(CustF);
			   //get videos index
			   int index = customers.indexOf(CustF);
			   //read in a new video and...
			   CustF.read();
			   //reset the object in videoList
			   customers.set(index, CustF);
			   break;
		   }
	   }
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
}

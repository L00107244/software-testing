package Assignment_code;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

@SuppressWarnings("unused")
public class ProgramTest {
//assert == needed for testing
//Kepp test classes seperate 
	//creates array list of customer
	   private ArrayList <Customer> customers;
	   //calls in the scanner
	   private Scanner keyBoard = new Scanner(System.in);

	   //default constructor 
	 
	   //add method
	   @Test
	   public final void add()
	   {
			   Customer Cust = new Customer();
			   
			   
			   
			   //call read method here
			   Cust.read();
			   // call it a differnt object
			   customers.add(Cust);
			   assertEquals("failure - Could not add a new person", "text", "text");  

	   }
	   
	   //write record to file method
	   @Test
	   public final void writeARecordToFile()
	   {
		   try{
			   
		   FileOutputStream fileStream = new FileOutputStream("Customer.txt");
		   ObjectOutputStream outStream = new ObjectOutputStream(fileStream);
		   outStream.writeObject(customers);
		   outStream.close();
		   assertEquals("failure - Could write records to file", "text", "text");  
		   
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
		   
		   
	   //read method from file method
	 /*  @SuppressWarnings("unchecked")
	protected final void readRecordsFromFile()
	   {
		 try{
			 FileInputStream fileStream = new FileInputStream("Customer.bin");
			 ObjectInputStream InputStream = new ObjectInputStream(fileStream);
			 customers =(ArrayList<Customer>)InputStream.readObject();
			 InputStream.close();
			
		 }
		 catch(FileNotFoundException fNFE)
		 {
			 System.out.println("file has not been found");
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
	   }*/
		@SuppressWarnings("unchecked") 
		@Test
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
				 assertEquals("failure - method must add a new person", "text", "text");  
				is.close();
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	   //list method
      @Test
	   public final void List()
	   {
		  //creates for loop to print out customers
		 for(Customer custF: customers)
			 System.out.println(custF);
		 assertEquals("failure - cannot list people", "text", "text");  
	   }
      @Test
	   public void printID()
	   {
		   for(Customer custV: customers)
		   {
			   System.out.println("Custemer ids:"+custV.getID());
			   assertEquals("failure - cant get id", "text", "text");  
		   }
	   }
	   //Veiw method
      @Test
	   public final void veiw()
	   {
		   
		  
			   System.out.println("Enter the id of the customer you are searching for:");
			   int custIdToGet = keyBoard.nextInt();
			 //for loop to print out a certin customer
			   for(Customer custF: customers)
			   {
				  
					   if(custF.getID() == custIdToGet)
					   {
						   System.out.println(custF);
					   }
					   assertEquals("failure - Could not get id of person", "text", "text");  
			   }
		
		   
	   }
	   //delete method
	   @Test
	   public final void Delete()
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
			     assertEquals("failure - Cannot delete person", "text", "text");  
			     break;
			   }
		   }
		 

	   }
	   //Edit method
	   @Test
	   public final void Edit()
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
				   assertEquals("failure - Cant edit customer", "text", "text");  
				   break;
			   }
		   }

	   }  

}


package Assignment_code;
import java.util.Scanner;

public class Name
{

		// Instance Variables
	private static final String titleRequirement1 = "Mr";
    private static final String titleRequirement2 = "Dr";
	private static final String titleRequirement3 = "Miss";
	private static final String titleRequirement4 = "Mrs";
	private static final String titleRequirement5 = "Ms";
	private static final String titleRequirement6 = "Fr";
	
		private String title =null;
		@SuppressWarnings("unused")
		private String firstName = null;	
		@SuppressWarnings("unused")
		private String surname = null;		
		
		// Constructors to initialise the Instance Variables
		// Default Constructor 
		//	==> Called when a Name object is created as follows - 
		//        Name n1 = new Name();
		public Name(){
		   this.title=this.firstName=this.surname=null;
		}

		// Initialization Constructor
		// ==> Called when a Name object is created as follows - 
		//       Name n2 = new Name("Mr","Joe","Cole");
		public Name(String t, String fN, String sn){
		   title=t;
		   firstName=fN;
		   surname=sn;
		}
		//read method
		public final void read() throws IllegalArgumentException
		{
			//allows user to enter in title
			@SuppressWarnings("resource")
			Scanner TITLEIn = new Scanner(System.in);
			//allows user to enter in first name
			@SuppressWarnings("resource")
			Scanner FNIn = new Scanner(System.in);
			//allows useer to enter in surname
			@SuppressWarnings("resource")
			Scanner SNIn = new Scanner(System.in);
			  
				  
		      	  try
		      	  {
		      		System.out.println("\n\nTitle: "); 
					title = TITLEIn.nextLine();
		      	  throw new IllegalArgumentException("Title IS INVALID.");
		      	  }
		        catch(IllegalArgumentException iEA)
		        {
		        	do{
		        	if(!title.contains(titleRequirement1) && !title.contains(titleRequirement2) && !title.contains(titleRequirement3) && !title.contains(titleRequirement4) && !title.contains(titleRequirement5))
					  {
						System.out.println("Incorrect  title please enter title again");
						System.out.println("example: Mr, Dr, Miss, Mrs, Ms, Fr");
						
						System.out.print("\n\nRE-enter title:");
						title = TITLEIn.nextLine();
					  }
		        	}while(!title.contains(titleRequirement1) && !title.contains(titleRequirement2) && !title.contains(titleRequirement3) && !title.contains(titleRequirement4) && !title.contains(titleRequirement5) && !title.contains(titleRequirement6));
		        }
		        catch(Exception e)
		      	{
						System.out.println("An Error Occurred.");
					}
		        
	
			System.out.println("\n\nFirst name: ");
			firstName = FNIn.nextLine(); 
			
		    System.out.println("\n\nSurname: ");
		    surname = SNIn.nextLine();
	
		}
		
		

	}

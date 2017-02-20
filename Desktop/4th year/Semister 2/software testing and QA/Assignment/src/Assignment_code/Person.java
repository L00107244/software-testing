package Assignment_code;

public class Person 
{
		protected Name name =null;			// COMPOSITION - Person HAS-A name
		protected String phoneNumber=null;

		
		protected Person(){
		   this.name=new Name();
		   this.phoneNumber=null;
		}

		// Initialisation Constructor
		// Called when object would have been created like this (not possible cos Abstract!)
		//    ==> Person pObj = new Person("Mr", "Joe", "Doe", "087 1234567");
		protected Person(String t, String fN, String sn, String phoneNumber){
			this.name=new Name(t, fN, sn);	// Calls name initialisation constructor
			this.phoneNumber=phoneNumber;
		}

		// toString() method
		// ==> Calls Name's toString() to display name and
		//		then displays phoneNumber
		public String toString(){
			return name + "," + phoneNumber;
		}

		// equals() method
		// ==> Called when comparing an object with another object, 
		//     e.g. - if(p1.equals(p2))				
		// ==> Calls Name's equals() to compare name to personIn's name, and
		//		compares phoneNumber to personIn's phoneNumber
		protected final boolean equals(Person personIn){
			if(name.equals(personIn.name) &&
			   phoneNumber.equals(personIn.phoneNumber))
				return true;
			else
			   return false;
		}
				
		// set() and get() methods
		protected final void setName(Name nameIn){
			name = nameIn;
		}
		protected Name getName(){
			return name;
		}
					
		protected final void setPhoneNumber(String phoneNumberIn){
			phoneNumber = phoneNumberIn;
		}
		protected final String getPhoneNumber(){
			return phoneNumber;
		}
	}

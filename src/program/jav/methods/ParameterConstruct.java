package program.jav.methods;

public class ParameterConstruct{  
    int id;  
    String name;  
    
   public ParameterConstruct(){   //default-no parameters
    	System.out.println("inside");
    	
        }  
    
    //creating a parameterized constructor  
    public ParameterConstruct(int i,String n){   // two parameters
	    id = i;  
	    name = n;  
    }  
    
    //method to display the values  
    public void display()
    {
    	System.out.println(id+" "+name);
    }  
    
   
    public static void main(String args[]){  
    
    //creating objects and passing values 
    	 
    ParameterConstruct s1 = new ParameterConstruct(111,"Karan");  
    ParameterConstruct s2 = new ParameterConstruct(222,"Aryan");  
    
    
    //calling method to display the values of object  
    s1.display();  
    s2.display();  
   }  
}  
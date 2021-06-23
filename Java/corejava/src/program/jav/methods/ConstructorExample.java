package program.jav.methods;

public class ConstructorExample{  
	
	int id;   // class variables
	String name;  
		
	public ConstructorExample()  // default constructor
	{
		id=10;
		name = "hello";
		System.out.println("i m inside the default constructor");
	}
	
	//method to display the value of id and name  
	void display()  //default modifier
	{
		System.out.println(id+" "+name);
	}  
	  
public static void main(String args[]){  
	//creating objects  
	ConstructorExample s1;  //Instance variables
	s1 =new ConstructorExample();
	
	ConstructorExample s2=new ConstructorExample();  // object of class
	
	//displaying values of the object  
	s1.display();  
	s2.display();  
    }  
}  
package program.jav.methods;

public class ConstructOverload{  
    
	long id;  
    String name;  
    int age=10;  
    
    //creating two arg constructor  
    ConstructOverload(long i,String n){  
    id = i;  
    name = n;  
    }     
    
    ConstructOverload(boolean h,int n){  
    //id = i;  
    //name = n;    
    }  
    
    //creating three arg constructor  
    ConstructOverload(int i, String n, int a){  
    id = i;  
    name = n;  
    age=a;  
    } 
    
    void display()
    {
    	System.out.println(id+" "+name+" "+age);
    }  
   
    public static void main(String args[]){  
    
    ConstructOverload s1 = new ConstructOverload(111,"Karan");  
    ConstructOverload s2 = new ConstructOverload(222,"Aryan",25);  
    
    s1.display();  
    s2.display();  
   }  
}  
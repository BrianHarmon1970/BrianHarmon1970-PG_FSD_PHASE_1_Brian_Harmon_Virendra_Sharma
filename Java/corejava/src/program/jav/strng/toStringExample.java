package program.jav.strng;

// Since java compiler internally calls toString() method, overriding this method 
// will return the specified values. 
// now remove the toString() method and run the program you will get the hashcode values

class toStringExample{  
	 int rollno;  
	 String name;  
	 String city;  
	  
	 toStringExample(int rollno, String name, String city){  
	 this.rollno=rollno;  
	 this.name=name;  
	 this.city=city;  
	 }  
	   
	public String toString(){           //overriding the toString() method  
	  return rollno+" "+name+" "+city;  
	 } 
	 
	 public static void main(String args[]){  
		 toStringExample s1=new toStringExample(101,"Raj","lucknow");  
		 toStringExample s2=new toStringExample(102,"Vijay","ghaziabad");  
	     
	   System.out.println(s1);//compiler writes here s1.toString()  
	   System.out.println(s2);//compiler writes here s2.toString()  
	 }  
	 
	
	}  

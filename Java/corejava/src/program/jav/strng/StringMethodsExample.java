package program.jav.strng;

public class StringMethodsExample{  
	public static void main(String args[]){  
		
	String s1="javatprogram";  
	String s2="javatprogram";  
	String s3="JAVATPROGRAM";  
	String s4="python";  
	String s5="JAVATPOINT HELLO stRIng";  
	
	
	System.out.println(s1.equals(s2));//true because content and case is same  
	System.out.println(s1.equals(s3));//false because case is not same  
	System.out.println(s1.equals(s4));//false because content is not same 
	
	System.out.println("string length is: "+s4.length());   //is the length of python   
	System.out.println("string length is: "+s2.length());   //is the length of javatprogram string  
		
	String name="JAVATPROGRAM";  
	String ch=name.substring(0,8); //returns the char value at the 4th index  
	System.out.println(ch);  
	
	String s1lower=s5.toLowerCase();  
	System.out.println(s1lower);            // converts to lowercase
	
	String s1upper=s5.toUpperCase();  
	System.out.println(s1upper);            // converts to uppercase
	
	
	
	}
}  

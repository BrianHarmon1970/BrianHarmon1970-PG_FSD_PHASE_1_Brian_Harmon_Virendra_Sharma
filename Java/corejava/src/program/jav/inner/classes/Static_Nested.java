package program.jav.inner.classes;

public class Static_Nested { 
	   private static void outerMethod() { 
	     System.out.println("inside outerMethod"); 
	   } 
	     
	   // A static inner class 
	   static class Inner { 
	     public static void main(String[] args) { 
	        System.out.println("inside inner class Method"); 
	        outerMethod(); 
	     } 
	   } 	  
	}

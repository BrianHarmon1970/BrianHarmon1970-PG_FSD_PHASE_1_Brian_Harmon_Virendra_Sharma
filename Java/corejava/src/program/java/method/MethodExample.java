
package program.java.method;
import java.util.* ;
//import java.LinkedHashMap ;


public class MethodExample 
{
	int  h = 9 ; // class variable
	
	public static void main ( String[] args ) 
	{
		int a=11 ;
		int b = 6 ;
		int c = minFunction( a, b) ;
		System.out.println("Minimum Value = "+c) ;
		System.out.println("Add value = ") ;
		
		ConstructorExample s2 = new ConstructorExample() ;
		s2.display();
		
	}

	/** returns the minimum of two numbers */
	public static int minFunction( int n1, int n2 ) 
	{
		int min  ; // local variable
		
		if ( n1 > n2 )
			min = n2 ;
		else min = n1 ;
		
		return min ;
	}
	public static int add ( int n1 , int n2 ) 
	{
		return ( n1 + n2  ) ; 
	}
	double circleARea( int radius )
	{
		return (3.14 * (float)radius * (float)radius) ;
	}
	int rectangleArea( int length, int width ) 
	{
		return ( length * width ) ;
	}
}

class ConstructorExample
{
	int id ; 
	String name ;
	
	public ConstructorExample() // default constructor
	{
		id = 10 ;
		name = "hello" ;
		System.out.println("inside default constructor") ;
		
	}
	void display() 
	{
		System.out.println(  id+"  " +name ) ;
	}

}
class ParameterConstruct
{
	int id ;
	String name ;
	public ParameterConstruct() {
		System.out.println( "in constructor " ) ;
	}
	public ParameterConstruct( int i , String n ) 
	{
		id = i ;
		name = n ;
	}
	public void display()
	{
		System.out.println( id+" "+name) ;
	}
	
	public static void main(String args[]) 
	{
		ParameterConstruct s  = new ParameterConstruct() ;
		
		ParameterConstruct s1 = new ParameterConstruct( 111,"Karen") ;
		ParameterConstruct s2 = new ParameterConstruct( 222, "Aryan" ) ;
		
		s.display( ) ;
		s1.display() ;
		s2.display() ;
	}
}



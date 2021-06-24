package program.java.exception;
import java.util.Scanner ;
import java.io.IOException;

public class ExceptionAssignment {
	public static void main( String[] args ) 
	{
		java.util.Scanner scanner = new Scanner( System.in ) ;
		System.out.print( "Length: " ) ;
		int l = scanner.nextInt();
		System.out.print( "Breadth: "); 
		int b = scanner.nextInt();
		try
		{
			display( l, b ) ;
		}
		catch( IOException e ) 
		{
			System.out.println( "Receieved IOException during calculation" ) ;
		}
	}
	int Calculate( int a, int b ) 
	{
		return ( a + b ) ;
	}
	int areaFunc( int l, int b ) 
	{
		return ( l*b ) ;
	}
	static void display(  int l, int b ) throws IOException 
	{
		if ( l > b ) 
		{
			throw new IOException() ;
		}
		
		System.out.println( " the area is : " + (l*b) ) ;
	}

}

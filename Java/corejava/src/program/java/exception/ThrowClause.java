package program.java.exception;
import java.util.Scanner;

public class ThrowClause {
	//Trhow exception if number 1 is greate than 900
	static int add ( int num1, int num2 ) {
	if( num1 > 900  )
	{
			throw new ArithmeticException("Num1 is greaterh than 900, hence exception thrown") ;
	}else {
		System.out.println("Both parameters are correct") ;
		
	}
	return num1+num2 ;
}
public static void main (String args[]) {
	int result = 0 ;
	Scanner scanner = new Scanner(System.in ) ;
	
	System.out.println("Enter number 1 : " ) ;
	int num1 = scanner.nextInt();
	
	System.out.println("Enter number 2 : " ) ;
	int num2 = scanner.nextInt();
	
	try {
		result = add( num1, num2 ) ;
	}
	catch(ArithmeticException ae )
	{
		System.out.println(ae.getMessage()) ;
	}
	System.out.println( "result is : " + result ) ;
}}

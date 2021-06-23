package program.java.exception;
import java.util.Scanner;

class SalaryException extends Exception
{
	SalaryException( String msg ) 
	{ 
		super(msg) ;
	}
}
public class CustomException {
	
	static void validateSalary( int salary ) throws SalaryException
	{
		if ( salary < 2000 )
			throw new SalaryException( "you need to work hard" ) ;
		if ( salary < 5000 ) 
			throw new SalaryException( "your salary is somehow good" ) ;
		if ( salary < 9000 ) 
			throw new SalaryException( "your salary is very good" ) ;
	}
	public static void main( String[] args ) 
	{
		Scanner scanner  = new Scanner( System.in ) ;
		
		System.out.println( "Enter your salary : " ) ;
		int salary = scanner.nextInt();
		
		try 
		{
			validateSalary( salary ) ;
			System.out.println( "no exception thrown" ) ; 
		}
		catch ( Exception e ) 
		{
			System.out.println( e.getMessage()) ;
		}
		
	}

}
		
/*
Assignment 1: (Custom Exception)
You need to check the salary of the person and based on that need to return the output from the program.
if salary < 2000  then return custom exception message as "you need to work hard"
if salary is between 2000 and 5000 then return custom exception message as "you salary is somehow good"
if salary is between 5100 and 9000 then return custom exception message as "salary is very good"
Desogn the custom exception class in this*/
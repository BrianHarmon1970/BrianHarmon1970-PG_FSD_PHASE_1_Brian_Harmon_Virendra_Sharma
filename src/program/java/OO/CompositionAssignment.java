package program.java.OO;
import java.util.ArrayList;

class Employee
{
	String 	name ;
	int 	 age ;
	double  salary ;
	
	Employee( String n, int a, double s )
	{
		name = n ;
		age = a ;
		salary = s ;
	}
}
class HR
{
	ArrayList<Employee> employees ;
	HR() 
	{
		employees = new ArrayList<Employee>() ;
	}
	public void RegisterEmployee( String name, int age, double salary ) 
	{
		Employee e = new Employee( name, age, salary ) ;
		employees.add( e ) ;
	}
}

public class CompositionAssignment 
{
	public static void main( String[] args ) 
	{
		HR hr = new HR() ;
		hr.RegisterEmployee("Brian Harmon", 101, 5000.00 ) ;
		hr.RegisterEmployee("Amanda Cash", 34, 10000.00 ) ;
	}
}

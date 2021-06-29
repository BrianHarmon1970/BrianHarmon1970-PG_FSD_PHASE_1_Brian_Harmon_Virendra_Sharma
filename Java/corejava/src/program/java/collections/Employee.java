package program.java.collections;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.AbstractCollection;
import java.util.Iterator; 
import java.util.Collection ;

public class Employee
{
	int a, b;   //---> class variables
	String employee_name ;
	public Employee()
	{   //---> no- argument contructor
	   a = 10;
	   b = 20;
	}
	public Employee( String name ) 
	{
		employee_name = name ;	
	}
	public Employee(int j , int k)
	{
	   a = j;  //---> a = 4 
	   b = k;  //---> b = 5
	}
	public void salary()   //---> normal method
	{
	  System.out.println(a + "  " + b );
	}
	public static void main( String[] args)
	{
		Employee  ob  =  new Employee();   //---> object of the class 'Employee' ---> no -arg
		Employee  ob1  =  new Employee(4,5);  //---> parametezed constructor being called
		ob.salary() ; //--> calling salary function
		
		ArrayList<Employee> AL = new ArrayList<Employee>() ;
		LinkedHashSet<Employee> LHS = new LinkedHashSet<Employee>() ;
		TreeSet<Employee>  TS = new TreeSet<Employee>() ;
		
		System.out.println( "<=== ArrayList ===>") ;
		Load(  (Collection)AL  ) ;
		Print( (Iterable)AL ) ;
		
		System.out.println( "<=== LinkedHashSet ===>") ;
		Load(  (Collection)LHS  ) ;
		Print( (Iterable)LHS ) ;
		
		System.out.println( "<=== TreeSet ===>") ;
		Load(  (Collection)LHS  ) ;
		Print( (Iterable)LHS ) ;
	}
	static void Load( Collection c ) 
	{
		c.add( new Employee("name1")) ;
		c.add( new Employee("Kee")) ;
		c.add( new Employee("Asharaf")) ;
		c.add( new Employee("Rinaldo")) ; 
		c.add( new Employee("Chandani")) ;
		c.add( new Employee("Ashraf")) ;
		c.add( new Employee("Rakesh")) ;
		c.add( new Employee("Prashant")) ;
		c.add( new Employee("Nur")) ;
		c.add( new Employee("Fiyaz")) ;
		c.add( new Employee("Nur")) ;
		c.add( new Employee("Kee")) ;
		
	}
	static void Print( Iterable c ) 
	{
		Iterator iter = c.iterator() ;
		while( iter.hasNext())
		{
			System.out.println(iter.next()) ;
		}
	}
}

 /*Insertion order: 
 Noel
 Kee
 Asharaf
 Rinaldo 
 Chandani
 Ashraf
 Rakesh
 Prashant
 Nur
 Fiyaz
 Nur
 Kee
 */
//LinkedHashset ----> where insertion order  equlas to output order
//TreeSet ---> will print the elements in asecnding order + remove duplicates


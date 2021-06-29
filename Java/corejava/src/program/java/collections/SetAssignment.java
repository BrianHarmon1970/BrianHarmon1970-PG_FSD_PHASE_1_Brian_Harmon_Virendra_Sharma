package program.java.collections;
//import java.util.HashSet;
import java.util.LinkedHashSet ;
import java.util.TreeSet ;
import java.util.Scanner ;

public class SetAssignment 
{
	public static void main( String[] args ) 
	{
		System.out.println("=====================Hello====================") ;
		Scanner scanner = new Scanner( System.in ) ;
		
		LinkedHashSet<Object> genericLhs = new LinkedHashSet<Object>() ;
	
		System.out.print("Integer: "); genericLhs.add( scanner.nextInt()) ;
		System.out.print("Integer: "); genericLhs.add( scanner.nextInt()) ;
		System.out.print("Float: ") ; genericLhs.add(  scanner.nextFloat()) ;
		System.out.print("Float: ") ; genericLhs.add(  scanner.nextFloat()) ;
		System.out.print("Char: ") ; genericLhs.add(  scanner.next().charAt(0)) ;
		System.out.print("Char: ") ; genericLhs.add(  scanner.next().charAt(0)) ;
		System.out.print("Boolean: ") ; genericLhs.add(  scanner.nextBoolean()) ;
		System.out.println( " Linked Hash Set: " + genericLhs ) ;

		
		LinkedHashSet<Integer> integerLhs = new LinkedHashSet<Integer>() ;
		for ( int i = 0 ; i < 8 ; ++i )
		{
			System.out.print( "("+(i+1)+" of 8"+") Integer: "); 
			integerLhs.add( scanner.nextInt()) ;
		}
		System.out.println( " Linked Hash Set: " + integerLhs ) ;
		
		scanner.close();

		TreeSet<String> ts = new TreeSet<String>() ;
		
		ts.add("C++") ;
		ts.add("Java") ;
		ts.add("Python") ;
		ts.add("Fortran") ;
		ts.add("Cobol") ;
		ts.add("Basic") ;
		System.out.println( " TreeSet: " + ts ) ;
		ts.remove( "Cobol") ;
		ts.remove("Basic") ;
		System.out.println( " TreeSet: " + ts ) ;
		ts.add( "Pascal" ) ;
		ts.add( "C" ) ;
		ts.add( "PL/SQL" ) ;
		System.out.println( " TreeSet: " + ts ) ;
		ts.removeAll(ts) ;
		System.out.println( " TreeSet: " + ts ) ;
	}
}

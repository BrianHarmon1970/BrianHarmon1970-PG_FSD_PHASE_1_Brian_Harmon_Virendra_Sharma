
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

class HashSetExample
{
	public static void main( String args[]) 
	{
		TreeSet<String> hs = new TreeSet<String>() ;
		hs.add("d") ;
		hs.add("c") ;
		hs.add("b") ;
		hs.add("a") ;
		hs.add("c") ;
		hs.add("i") ;
		hs.add("l") ;
		
		
		HashSet<String> tt = new HashSet<String>() ;
		tt.add("Hello") ;
		tt.add("Bye") ;
		tt.add("Bus") ;
		tt.add("Blue") ;
		tt.add("Blie") ;
		tt.add("Hello") ;
		tt.add("Blue") ;
		
		LinkedHashSet<String> country = new LinkedHashSet<String> () ;
		country.add("India") ;
		country.add("Australia") ;
		country.add("US") ;
		country.add("Canada") ;
		country.add("Nepal") ;
		country.add("England") ;
		country.add("Bermuda") ;
		
		System.out.println("Treeset is " + hs ) ;
		System.out.println("HashSet is "+tt ) ;
		System.out.println("LinkedHashset is "+ country) ;
		
		System.out.println("Size of Hashset is " + hs.size()) ;
		
		System.out.println("Does hashset contain this 'u' element"+ hs.contains("u")) ;
		System.out.println( "is hashset empty " + hs.isEmpty() ) ;
		System.out.println( "remove the element " + hs.remove("I")) ;
		System.out.println( "hashset is "+ hs ) ;
		
		hs.clear();
		System.out.println( "hashset is "+ hs ) ;
		System.out.println( "class is " + hs.getClass()) ;
		
		System.out.println("is hashset empty "+ hs.isEmpty()) ;
		
		
	}
}

class ArrayListExample
{
	public static void main( String args[]) 
	{
		ArrayList<String> al = new ArrayList<String>() ;
		
		al.add("Hey") ;
		al.add("Hello") ;
		System.out.println("Arraylist is "+ "a1" ) ;
		System.out.println("New size of Arraylist is "+al.size()) ;
		
		System.out.println("") ;
		al.add(1, "How are you" ) ;
		System.out.println("Initial size of Arrylist is "+ al.size()) ;
		
	}
}

class LinkedListDemo
{
	public static void main(String args[]) 
	{
		LinkedList<String> ll = new LinkedList<String>() ;
		
		System.out.println("<==============================================>") ;
		ll.add("Januaary") ;
		ll.add("February") ;
		ll.add("March") ;
		ll.add("April") ;
		
		Iterator<String> iter1 = ll.iterator() ;
		while ( iter1.hasNext())
		{
			System.out.println( "list is " + iter1.next()) ;
		}
		System.out.println("<==============================================>") ;
		ll.add("May") ;
		ll.add("June") ;
		ll.add("July") ;
		ll.add("August") ;
		iter1 = ll.iterator();
		while ( iter1.hasNext())
		{
			System.out.println( "list is " + iter1.next()) ;
		}
		
		System.out.println("<==============================================>") ;
		ll.add("September") ;
		ll.add("October" ) ;
		
		//Iterator<String> iter2 = ll.iterator() ;
		iter1 = ll.iterator();
		while ( iter1.hasNext())
		{
			System.out.println( "list is " + iter1.next()) ;
		}
		System.out.println("<==============================================>") ;
		
		ll.add("November") ;
		ll.add("December") ;
		//Iterator<String> iter3 = ll.iterator() ;
		iter1 = ll.iterator() ;
		while ( iter1.hasNext())
		{
			System.out.println( "list is " + iter1.next()) ;
		}
		System.out.println("<==============================================>") ;
	}
}
/*
class LinkedHashMapDemo
{
	public static void main( String args[] ) 
	{
		Map<Integer, String> LinkedHashMap<Integer, String> = new LinkedHashMap<Integer, String>() ;
		
		linkedHashMap.put(1, new STring("Samsung")) ;
		linkedHashmape.put(2, new String("Mi")) ;
		linkeHashMap.put(3, new STring("Toshiba")) ;
		linkedHashMap.put(4, new String("HCL")) ;
		linkedHashMap.put(5, new STring ("Wipro")) ;
		
		
		System.out.println("Contents of LinkedHashMap : "  + linkedHashMap) ;
		System.out.prinln("nValues of map after iterating over it : " ) ;
		
		for ( integer key : linkeHashMap.keySet()) 
		{
				Syste.out.println( key + ":/t" + linkedHasMap.get(key)) ;
		}
		
		
		
		System.out.println("\nThe size of the LinkedHashMap is : " + linkedHashMap.size()) ;
		Syste.out.println("nIs linkedHashMap empty? : " + linkedHashMap.isEmpty())) ;
		System.out.println()"\nLInkedHasMap contains contains 2 as key? " " + linkedHashMap.containsKey(2)) ;"
				+ "System.out.println(("LinkedHashMap contains HCL as value? " " + linekdHashMap.containsValue("HCL") ;
		System.out.printlin(("\nRemove entry for key 3 " " + linkedHasMap.remove(3)) ;"
				+ "System.out.println("Content of LindeHashMap after removig key 2 : " + linkedHasMap ) ;"
					
					linkedHasMap.clear() ;
				System.out.printlin("\nConten of LInedHashMap after clearing : " + linkedHashMap) ;
		}
	}
}*/
package program.java.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetExample
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

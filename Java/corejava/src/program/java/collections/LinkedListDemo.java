package program.java.collections;

import java.util.Iterator;
import java.util.LinkedList;

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
		
		Iterator<String> iter = ll.iterator() ;
		while ( iter.hasNext())
		{
			System.out.println( "list is " + iter.next()) ;
		}
		System.out.println("<==============================================>") ;
		ll.add("May") ;
		ll.add("June") ;
		ll.add("July") ;
		ll.add("August") ;
		iter = ll.iterator();
		while ( iter.hasNext())
		{
			System.out.println( "list is " + iter.next()) ;
		}
		
		System.out.println("<==============================================>") ;
		ll.add("September") ;
		ll.add("October" ) ;
		
		//Iterator<String> iter2 = ll.iterator() ;
		iter = ll.iterator();
		while ( iter.hasNext())
		{
			System.out.println( "list is " + iter.next()) ;
		}
		System.out.println("<==============================================>") ;
		
		ll.add("November") ;
		ll.add("December") ;
		//Iterator<String> iter3 = ll.iterator() ;
		iter = ll.iterator() ;
		while ( iter.hasNext())
		{
			System.out.println( "list is " + iter.next()) ;
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
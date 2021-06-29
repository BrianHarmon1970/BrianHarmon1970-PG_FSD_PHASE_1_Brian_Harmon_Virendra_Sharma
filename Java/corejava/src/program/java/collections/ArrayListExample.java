package program.java.collections;

import java.util.ArrayList;

class ArrayListExample
{
	public static void main( String args[]) 
	{
		ArrayList<String> al = new ArrayList<String>() ;
		
		al.add("Hey") ;
		al.add("Hello") ;
		System.out.println("Arraylist is "+ "a1" ) ;
		System.out.println("Initial size of Arraylist is "+al.size()) ;
		
		//System.out.println("") ;
		al.add(1, "How are you" ) ;
		al.add("I'm fine, thank you.") ;
		System.out.println("New size of Arrylist is "+ al.size()) ;
		
		System.out.println("<=== Array List ===>") ;
		for ( int i = 0 ; i < al.size() ; ++i ) 
		{
			System.out.println( al.get(i) ) ;
		}
		
	}
}
package program.java.strings;

public class Strings 
{
	public static void main( String args[]) 
	{
		String t= "Delhi";   //sp(1)
		String o = "Mumbai"; //sp(1)
		String k= "delhi";   //sp(1)
		String y= new String ("Mumbai");   //heap(1)
		String l= new String ("delhi");   //heap(1)
		String p = new String("Hello");  //sp(1) + heap(1)
		
		if ( o.equals( l )) { System.out.println( "o equals l" ) ;		}
		if ( y.equals( p )) { System.out.println( "y equals p" ) ;		}
		if ( t.equals( o )) { System.out.println( "t equals o" ) ;		}
		if ( k.equals( y )){ System.out.println( "k equals y" ) ;		}
		if ( p.equals( y )){ System.out.println( "p equals y" ) ;		}
			
		/*equals
		(1) o with l
		(2) y with p
		(3) t with o
		(4) k with y
		(5) p with y*/
	}

}

package program.java.exception;

public class MultipleCatchBlock {
	public static void main( String[] args )
	{
	
		try {
			int a[]= new int[5] ;
			//a[5]=30/0 ;
			a[6] = 9 ;
		}
		catch( ArithmeticException e )
		{
			System.out.println("Arithmetic Exception occurs") ;
		}
			
		catch(ArrayIndexOutOfBoundsException e ) 
		{
			System.out.println("ArrayIndexOutofBounds Exception occurs") ;
		}
		catch(Exception e)
		{
			System.out.println("parent Exception occurs") ;
		}
		finally {
			System.out.println("rest of the code") ;
		}
			
	}

}

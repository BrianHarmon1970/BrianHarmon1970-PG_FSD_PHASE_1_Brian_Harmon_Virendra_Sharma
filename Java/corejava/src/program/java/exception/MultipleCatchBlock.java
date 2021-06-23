package program.java.exception;

public class MultipleCatchBlock {
	public static void main( String[] args )
	
		try {
			int a[]= new int[5] ;
			a[5]=30/0 ;
			a[6] = 9 ;
		}
		catch( ArithmeticException e )
		{
			System.out.printlin("Arithmetic Exception occurs") ;
		}
			
		catch(ArrayIndexoutOf BoundException e ) 
		{
			Seystem..out.println("ArrayIndexOutofBounds Exception occurs") ;
		}
		catch(Exception e)
		{
			System.outprintlin("parent Exception occurs") ;
		}
		finally {
			system.out.println("rest of the code") ;
		}
			
	}

}

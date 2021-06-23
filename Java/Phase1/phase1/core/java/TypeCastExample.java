package phase1.core.jav;

public class TypeCastExample {

	public static void main(String[] args) 
	{
		//--- Typecast INT<->LONG -------
		int i = 100 ;
		long l = 700000000 ; // automatic type conversion from in t to long
		System.out.println("long value "+ l) ;
		
		int o = (int) l ; //explicit typecast from long to int
		System.out.println("int value "+ o);
		
		char t = (char) i ;
		System.out.println("char value " + t ) ;
		// -- typecase double-float
		double d = 19056546753.0067644444 ;
		float r = (float) d ; // explicti typecast
		System.out.println("float value "+ r ) ;
		System.out.println("double value " + d ) ;
		
		// ---- typecast double-long 
		double d2 = 10009096765509.046543 ;
		long l2 = (long)d2 ; //explict type cast
		int i2 = (int)l2 ; //explict type cast
		
		System.out.println("Double value "+d2);
		System.out.println("Long value "+l2) ;
		System.out.println("Int value "+i2) ;
		
		//--- typecast between long and floate
		float f = l ; // automatic type conversion
		System.out.println("float value "+ f ) ;
		
		//---- Typecast between byte, int and double
		byte b ;
		int ii = 257 ;
		double dd = 323.142 ;
		
		System.out.println("Conversion of int to byte.") ;
		b = (byte) ii ; //i%257
		System.out.println("ii = "+ b +" b = " + b ) ;
		
		System.out.println( "Conversion of double to byte") ;
		b = (byte) dd ;
		System.out.println( "dd= " +dd +" b= " + b ) ;
	}

}

class TestA 
{
	private int y = 10 ; // private variable
	long k = 1000 ; // default variable
	public void methodPublic() 
	{
			methodPrivate() ;
	}
	protected void methodProtected()
	{
		methodPrivate() ;
	}
	void methodDefault()
	{	
		methodPrivate() ;
	}
	private void methodPrivate()
	{
		System.out.println("Class TestA:methodPrivate().") ;
		System.out.println("Value of private value y = "+y) ;
		System.out.println("Value of long K = " + k ) ;
	}
}


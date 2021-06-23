package program.java.accessmodifer.child;
import phase1.core.jav.TestB;


public class TestC extends TestB
{
	void defaultMethod() 
	{
		System.out.println("inside the dafault method of class TestC") ;
	}
	public static void main( String[] args) 
	{
		new TestB().methodPublic() ;
	}
}

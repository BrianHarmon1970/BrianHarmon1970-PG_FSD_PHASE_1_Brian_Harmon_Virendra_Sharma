package program.java.accessmodifier.child;
import program.java.accessmodifier.TestB;


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

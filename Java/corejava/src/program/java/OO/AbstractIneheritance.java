package program.java.OO;

/*
(Parent) MNC ---> 2 abstract methods + 1 constructor + 1 normal method
Infosys (child of MNC) ----> make it abstract also  but give the implementation of single abstarct method
Hello (child of Infosys) ----> here implement all the abstarct methods + 1 create noraml method also
main class ---> call all the methods of all classes using the dynamic polymorphism

*/
abstract class MNC
{
	MNC(){ }
	abstract public void absMethod1() ;
	abstract public void absMethod2() ;
	public void normalMethod1() 
	{
		System.out.println("Inside normalMethod1() - MNC" ) ;
	}
	public void normalMethod2() 
	{
		System.out.println("Inside normalMethod2() - MNC " ) ;
	}
}

abstract class Infosys extends MNC
{
	public void absMethod1() 
	{
		System.out.println("Inside absMethod1() - in Infosys ") ;
	}
	abstract public void absMethod2()  ; 
}

class Hello extends Infosys
{
	
	//public void absMethod1( ) 
	//{
	//	System.out.println("Inside absMethod1() - in Hello ") ;
	//}
	public void absMethod2() 
	{
		System.out.println("Inside absMethod2() - in Hello " ) ;
		
	} 
	public void normalMethod3() 
	{
		System.out.println("Inside normalMethod3() - in Hello " ) ; 
	} 
}

public class AbstractIneheritance
{
	public static void main( String[] args ) 
	{
		Hello h = new Hello() ;
		h.absMethod1();
		h.absMethod2();
		h.normalMethod1();
		h.normalMethod2();
		h.normalMethod3();
	}
}
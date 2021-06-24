package program.java.OO;

abstract class Pen
{
	abstract void write() ;
	abstract void refill() ;
}

class Quill extends Pen
{
	void write() {}
	void refill() {}
	void ChangeNib() {}
}

interface BasicAnimal
{
	void eat() ;
	void sleep() ;
}

class Monkey
{
	public void jump() 
	{
		System.out.println("Monkey: jump()") ;
	}
	public void bite() 
	{
		System.out.println("Monkey: bite()") ;
	}
}

class Human extends Monkey implements BasicAnimal 
{
	public void eat() 
	{
		
	}
	public void sleep() 
	{
		
	}
	@Override
	public void jump()
	{
		System.out.println("Human: jump()") ;
	}
	@Override
	public void bite()
	{
		System.out.println("Human: bite()") ;
	}
}

abstract class Telephone
{
	abstract void Lift() ;
	abstract void Disconnect() ;
}

class SmartPhone extends Telephone
{
	public void Lift() 
	{
		System.out.println("SmartPhone: Lift()") ;
	}
	public void Disconnect() 
	{
		System.out.println("SmartPhone: Disconnect()") ;
	}
}	

interface TVRemote
{
	void BasicMenu() ;
}
interface SmartRemote extends TVRemote
{
	void SmartMenu() ;
}

class TV implements TVRemote
{
	public void BasicMenu() 
	{
		System.out.println("TVRemote: BasicMenu()") ;
	}
}

abstract class Marks
{
	abstract int getPercentage() ;
}

class StudentA extends Marks
{
	int Mrks[] = {0,1,2,3} ;
	
	StudentA( int a, int b, int c, int d ) 
	{
		Mrks[0] = a ;
		Mrks[1] = b ;
		Mrks[2] = c ;
		Mrks[3] = d ;
	}
	public int getPercentage() 
	{
		return ( ((Mrks[0] + Mrks[1] + Mrks[2]+Mrks[3] )) / 4 )  ;
	}
}
class StudentB extends Marks
{
	int Mrks[] = {0,1,2} ;
	StudentB( int a, int b, int c ) 
	{
		Mrks[0] = a ;
		Mrks[1] = b ;
		Mrks[2] = c ;
	}
	public int getPercentage()
	{
		return ( ((Mrks[0] + Mrks[1] + Mrks[2] )) / 3 )  ;
	}
}

public class AbstractClass 
{
	public static void main( String [] args )
	{
		Human h = new Human() ;
		Monkey monkey_ref = h ;
		monkey_ref.jump() ;
		monkey_ref.bite() ;
		
		SmartPhone smart_phone = new SmartPhone() ;
		smart_phone.Lift();
		smart_phone.Disconnect();
		
		StudentA a = new StudentA( 100, 50, 75, 80 ) ;
		StudentB b = new StudentB( 90, 80, 70) ;
		
		System.out.println( "Student A: "+ a.getPercentage()) ;
		System.out.println( "Student B: "+ b.getPercentage()) ;
	}
	
	
}

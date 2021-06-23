package program.jav.inheritance;

 abstract class AbstractDemo {
	
	String name = "abc";
	
	AbstractDemo(){
		System.out.println("inside the abstract class..");
	}
	
	public void myMethod() {
		System.out.println("Hello");
	}

	abstract public void anotherMethod();

}


public class BasicAbstractExample extends AbstractDemo {

	BasicAbstractExample() {
		System.out.println(" Inside child class...");
	}

	public void anotherMethod() {
		System.out.println("Abstract method");
	}

	public static void main(String[] args) {
		
		// AbstractDemo abs = new AbstractDemo();

		
		
		AbstractDemo obj = new BasicAbstractExample();
		
		obj.anotherMethod();
		obj.myMethod();
	}

}

package program.jav.methods;

public class CallByValueMethod {
	
	int val=150;

	int operation(int val) {
		val =val*10/100;
		return(val);
	}

	public static void main(String args[]) {
		CallByValueMethod d = new CallByValueMethod();
		System.out.println("Before operation value of data is "+d.val);
		int f= d.operation(100);
		System.out.println("After operation value of data is "+f);
		}
}

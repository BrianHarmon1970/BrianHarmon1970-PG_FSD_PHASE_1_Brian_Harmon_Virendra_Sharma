package program.java.regx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regx {
	public static void main( String args[])
	{
		System.out.println(Pattern.matches("[A-Z]+\\d{3}[a-zA-Z]*", "B123Rian")) ; 
	}
	/*(1) validate the given email id (that shoud have pattern with @ and .com    
	(a)  firstname@prolim.com
	(b)  viren@gmail.com
	(c)  test123prepare@co.edu.com*/
}

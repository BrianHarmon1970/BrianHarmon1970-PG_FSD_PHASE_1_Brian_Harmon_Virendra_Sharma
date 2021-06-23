package program.java.regx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regx {
	public static void main( String args[])
	{
		// Password Match
		System.out.println(Pattern.matches( "[A-Z]+\\d{3}[a-zA-Z]*", "B123Rian" )) ;
				
		String emailpattern_alphanum  = "(([a-zA-Z]*|[0-9]*|(-|_)*)*)" ;
		String emailpattern_dot_alphanum = "(."+emailpattern_alphanum+")*" ;
		String emailpattern = emailpattern_alphanum+"@"+emailpattern_dot_alphanum ;
		
		String email_one = "brian_123harmon@gmail.net" ;
		String email_two = "first-name@prolim.gov" ;
		String email_three = "viren@gmail.com" ;
		String email_four = "test123prepare@co.edu.com" ;
				
		System.out.println( "Pattern: " + emailpattern ) ;
		System.out.println(email_one +" ["+ Pattern.matches( emailpattern, email_one)+"]" ) ;
		System.out.println(email_two +" ["+ Pattern.matches( emailpattern, email_two)+"]" ) ;
		System.out.println(email_three +" ["+ Pattern.matches( emailpattern, email_three)+"]" ) ;
		System.out.println(email_four +" ["+ Pattern.matches( emailpattern, email_four)+"]" ) ;
		
		String phonepattern = "((\\+[0-9]{2,3})|1?)((-?\\d{3}-?)|(\\(\\d{3}\\)))\\d{3}-?\\d{4}" ;
		
		String phone_one = "18064201285" ;
		String phone_two = "806-420-1285" ;
		String phone_three = "+90(806)420-1285" ;
		String phone_four = "1(806)420-1286" ;
		
		
		System.out.println( "Pattern: " + phonepattern ) ;
		
		System.out.println(phone_one +" ["+ Pattern.matches( phonepattern, phone_one)+"]" ) ;
		System.out.println(phone_two +" ["+ Pattern.matches( phonepattern, phone_two)+"]" ) ;
		System.out.println(phone_three +" ["+ Pattern.matches( phonepattern, phone_three)+"]" ) ;
		System.out.println(phone_four +" ["+ Pattern.matches( phonepattern, phone_four)+"]" ) ;
		
		
		
	}
	/*(1) validate the given email id (that shoud have pattern with @ and .com    
	(a)  firstname@prolim.com
	(b)  viren@gmail.com
	(c)  test123prepare@co.edu.com*/
}

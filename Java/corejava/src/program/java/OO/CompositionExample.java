package program.java.OO;
import java.util.List ;
import java.util.ArrayList ;

class Book
{

	String title ;
	String author ;
	
	// Constructors
	Book() {
		title = "" ; 
		author = "" ;
	}
	Book( String Title, String Author )
	{
		title = Title ;
		author = Author ;
	}
}
// Library class
class Library
{
	List<Book> books ;
	// refrence to the list of book.
	Library( List<Book> books )
	{
		this.books = books ;
	}
	
	// Getting total number of books
	public List<Book> getTotalBooksInLibrary()
	{
		return books ;
	}
}

public class CompositionExample {
	public static void main (String[] args )
	{
		Book b1 = new Book("EffectiveJ Java","Joshua Bloch" ) ;
		Book b2 = new Book("Thinking in Java", "Bruce Eckels" ) ;
		Book b3 = new Book( "Jave: The Complete Reference","Herbert Schildt") ;
		Book b4 = new Book( "Head First", "O'Reilly" ) ;
		Book b5 = new Book( "thinking in C++", "Yashwant Kanetkar") ;

		
		List<Book> book = new ArrayList<Book>() ;
		book.add(b1) ;
		book.add(b2);
		book.add(b3);
		book.add(b4) ;
		book.add(b5) ;
		
		Library library  = new Library( book ) ;
		List<Book> books = library.getTotalBooksInLibrary() ;
		for ( Book bk : books ) 
		{
			System.out.println("title : "+ bk.title + " and Author : "+ bk.author) ;
		}
	}
}
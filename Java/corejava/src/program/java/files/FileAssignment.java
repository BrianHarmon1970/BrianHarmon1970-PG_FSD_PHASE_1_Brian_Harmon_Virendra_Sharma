package program.java.files;
import java.io.File.*;
import java.io.FileWriter;
import java.io.FileReader; 
import java.io.IOException;
import java.util.Scanner;

public class FileAssignment {

	public static void main ( String[] arggs ) 
	{
		
		Scanner scanner  = new Scanner( System.in ) ;
		//File file = new File("E://demo.txt") ;
		
		try
		{
			// create file
			//File.createNewFile() ;
			
			// input string about me and write to file
			FileWriter output = new FileWriter(" E:\\Users\\demo.txt") ;
		
			System.out.println("Enter some data about yourself : " ) ;
			String sdata = scanner.nextLine() ;
			
			output.write( sdata ) ;
			// open file read and display data and show all data about file
			/// delete file
			//FileReader input = new FileReader("E:\\demo.txt") ;
			//char buffer[ ] = new char[ 120 ] ;
			//input.read( buffer ) ;
			//System.out.println( buffer ) ;
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

package program.java.files;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader; 
import java.io.IOException;
import java.util.Scanner;

public class FileAssignment {

	public static void main ( String[] arggs ) 
	{
		String filename = "e:\\Project\\demo.txt" ;
		
		Scanner scanner  = new Scanner( System.in ) ;
		File file = new File( filename ) ;
		FileWriter output ;
		try
		{
			// create file
		
			file.createNewFile() ;
			
			
			FileReader input = new FileReader( filename ) ;
			char buffer[ ] = new char[ 120 ] ;
			input.read( buffer ) ;
			System.out.println( buffer ) ;
			
			// input string about me and write to file
			output = new FileWriter( filename )  ;
		
			System.out.println("Enter some data about yourself : " ) ;
			String sdata = scanner.nextLine() ;
			output.write( sdata ) ;
			output.close();
			// open file read and display data and show all data about file
			/// delete 
			
			ShowDetails( file ) ;
			//Path path = FileSystems.getDefault().getPath("c:/test", "somefile.txt");
			//BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class) ;
			file.delete() ;
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally
		{
			scanner.close();
			//output.close();
		}
	}
	static void ShowDetails( File f ) 
	{
		System.out.println( "Absolute file path: "+ f.getAbsolutePath() ) ;
		System.out.println( "Name: "+ f.getName()) ;
		System.out.println( "Parent: "+ f.getParent()) ;
		System.out.println( "Size: "+ f.length()) ;
		System.out.println( "Modified: "+ f.lastModified()) ;
	}
}

package program.java.files;
import java.io.BufferedOutputStream; 
import java.io.DataInputStream ;
import java.io.FileOutputStream ;



public class FileOutputStreamProgram 
{
	public static void main( String[] args ) 
	{
		
		try
		{
		
		// Setp 1: attach keyboard to DataInputSTream
		DataInputStream dis = new DataInputStream(System.in) ;
		
		// Step 2: attach file to FileOutputStream
		FileOutputStream fout = new FileOutputStream("E://Users//black//datafile.txt", true) ;
		
		
		// Step 3: attach FileOutputStream to BufferedOutputSTream
		BufferedOutputStream bout = new BufferedOutputStream( fout, 1024 ) ;
		System.out.println("Enter text {@ at the end):") ;
		char ch ;
			//read characters form dis into ch. then write them int9o bout.
			//repeat this as long as the read character is not @
			while((ch=(char)dis.read()) != '@')
			{
				bout.write(ch); 
			}
			//clsoe the file
			bout.close();
		}catch ( Exception e ) 
		{
			e.getStackTrace() ;
		}
	}
}

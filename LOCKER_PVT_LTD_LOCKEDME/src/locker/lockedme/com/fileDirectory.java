package locker.lockedme.com;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList ;

public class fileDirectory extends ArrayList<File>
{
	ArrayList<File> directory_list = new ArrayList<File>() ;
	public void LoadDirectoryList( ) 
	{
		  // try-catch block to handle exceptions
        try {
  
            // Create a file object
            File f = new File(".");
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
              	if ( files[i].isDirectory()  == false )  
            	{
            		directory_list.add( files[i] ) ;
            	}
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
	}
	int getIndex( String filename )
	{
		for ( int  i = 0 ; i < directory_list.size() ; ++i ) 
		{
			File f = directory_list.get( i ) ;
			if( f.getName().toUpperCase().equals( filename.toUpperCase() )) ;
			{
				return i ;
			}
		}
		return -1 ;
	}
	boolean findFile( String filename )
	{
		if( getIndex( filename) > -1 )
		{
			return true ;
		} else return false ;
		
	}
	File getFile( String filename )
	{
		int index = getIndex( filename ) ;
		if ( index > -1 )
			return directory_list.get( index ) ;
		return null ;			
	}
	void newFile( String filename ) 
	{
		File f = new File( filename ) ;
		try { f.createNewFile() ;	}
		catch( IOException e ) 	{ System.out.println( "IOException: "+ e.getMessage()) ; }
	}
}

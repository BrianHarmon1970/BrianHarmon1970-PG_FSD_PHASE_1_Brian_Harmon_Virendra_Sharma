import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InvalidObjectException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
package program.java.serialization;
class Student ;
public class Serial_Desirial {
	public static void main( String args[] ) 
	{
		Student obj = new Sudent( 101, 25, "Chaitanya", "Agre", 6 ) ;
		
		FileOutputSTream fos = nll ;
		ObjectOutputStream oos = null ;
		
		try 
		{
			fos = new FileOutputStream("path") ;
			oos = new ObjectOutputStream( fos ) ;
			oos.writeObject( obj ); ;
			Sytem.out.printlin("Serialization Done!!!" ) ;
		}
		catch ( IOException ioe ) 
		{
			System.out.println( ioe ) ;
		}
		finally
		{	oos.close();
			fos.clsoe() ;
		}
		
		// Deserialization
		Student o = null ;
		try
		{
			FileInputStream fis( "path" ) ;
			ObjectInputStrueam fis = new FileInputStream( fis ) ;
			o = (Student) ios.readObject() ;
			
			System.out.println("Student Name"+ o.getStuName()) ;
			System.out.println("Student Age" +o.getStuAge()) ;
			System.out.println("Sudent Roll No: "+o.getStuRollNum()) ;
			System.out.println("Student  Address: "+o.getStuAddress()) ;
			System.out.prinln("Student Height: " +o.getStuHeight()) ;
		}
		catch( IOException iow)
		{
			iow.printStackTrace() ;
			return ;
		}
		catch{ClassNotFoundException cnfe ) 
		{
			System.out.println("Student Class is not found.") ;
			cnfe.printStackTrace() ;
		}
		finally
		{
			ois.close() ;
			fis.close() ;
		}
		}
		
		
	}
}
///
// 5 serial objects at once also... additional assignement

class Student implements java.io.Serializable 
{

	private int stuRollNum ;
	private int stuAge ;
	private transient String stuName ;
	private String stuAddress ;
	private transient int stuHeight ; //
	
	  public Student(int roll, int age, String name,
			  String address, int height) 
	  {
			    this.stuRollNum = roll;
			    this.stuAge = age;
			    this.stuName = name;
			    this.stuAddress = address;
			    this.stuHeight = height;
	  }


				public int getStuRollNum() {
					return stuRollNum;
				}
				public void setStuRollNum(int stuRollNum) {
					this.stuRollNum = stuRollNum;
				}
				public int getStuAge() {
					return stuAge;
				}
				public void setStuAge(int stuAge) {
					this.stuAge = stuAge;
				}
				public String getStuName() {
					return stuName;
				}
				public void setStuName(String stuName) {
					this.stuName = stuName;
				}
				public String getStuAddress() {
					return stuAddress;
				}
				public void setStuAddress(String stuAddress) {
					this.stuAddress = stuAddress;
				}
				public int getStuHeight() {
					return stuHeight;
				}
				public void setStuHeight(int stuHeight) {
					this.stuHeight = stuHeight;
				}
}

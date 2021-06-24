package program.java.serialization;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.InvalidObjectException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


//class Student ;
public class Serialization {
	
	static String file_path = "E:/Project/Java/" ;
	static String file_name = "serialdata.txt" ;
	
	public static void main( String args[] ) 
	{
		Student obj = new Student( 101, 25, "Chaitanya", "Agre", 6 ) ;
		
		FileOutputStream fos = null ;
		ObjectOutputStream oos = null ;
		
		try 
		{
			fos = new FileOutputStream( file_path + file_name ) ;
			oos = new ObjectOutputStream( fos ) ;
			oos.writeObject( obj ); ;
			System.out.println("Serialization Done!!!" ) ;
			fos.close() ;
			oos.close();
		}
		catch ( IOException ioe ) 
		{
			System.out.println( ioe ) ;
		}
	
		// Deserialization
		Student o = null ;
		FileInputStream fis ;
		
		try
		{
			fis = new FileInputStream( file_path + file_name ) ;
			ObjectInputStream ois = new ObjectInputStream( fis ) ;
			o = (Student) ois.readObject() ;
			
			System.out.println("Student Name"+ o.getStuName()) ;
			System.out.println("Student Age" +o.getStuAge()) ;
			System.out.println("Sudent Roll No: "+o.getStuRollNum()) ;
			System.out.println("Student  Address: "+o.getStuAddress()) ;
			System.out.println("Student Height: " +o.getStuHeight()) ;
			fis.close() ;
			ois.close();
		}
		catch( IOException iow)
		{
			iow.printStackTrace() ;
			return ;
		}
		catch(ClassNotFoundException cnfe ) 
		{
			System.out.println("Student Class is not found.") ;
			cnfe.printStackTrace() ;
		}
		finally
		{
		//	oos.close() ;
		//	fis.close() ;
		}
	}
}
// 5 serial objects at once also... additional assignement

class Student implements Serializable 
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



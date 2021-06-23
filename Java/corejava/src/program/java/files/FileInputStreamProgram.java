package program.java.files;


import java.io.*; 
//Java program demonstrating FileInputStream  
public class FileInputStreamProgram 
{ 
  public static void main(String args[]) throws IOException 
  { 

      //attach the file to FileInputStream 
      FileInputStream fin= new FileInputStream("E://Users//black//datafile.txt"); 

      //illustrating getChannel() method 
      System.out.println(fin.getChannel()); 

      //illustrating getFD() method 
      //Returns the FileDescriptor object that represents the connection to the actual file
      //in the file system being used by this
      System.out.println(fin.getFD()); 

      //illustrating available method 
      //Returns an estimate of the number of remaining bytes that can be read (or skipped over)
      //from this input stream
      System.out.println("Number of remaining bytes:"+fin.available()); 

      //illustrating skip method 
      /*Original File content: 
      * This is my first line 
      * This is my second line*/
      fin.skip(7); 
      System.out.println("FileContents :"); 
      //read characters from FileInputStream and write them 
      int ch; 
      while((ch=fin.read())!=-1) 
          System.out.print((char)ch); 
        
      //close the file 
      fin.close(); 
  } 
} 
/* June 30 due PGD_FSD_BRIANHARMON
 * PG_FSD_PHASE_1_<yourname>_Virendra_Sharma
 
//Take user Option from the below mentioned Menu
Scanner input = new Scanner(System.in);
System.out.println("****************************************************************");
System.out.println("*********************  LOCKED ME. COM  ********************");
System.out.println("****************************************************************");
System.out.println();

System.out.println(" 1. New User - Register");
System.out.println(" 2. Already User - Login");
System.out.println();

System.out.println("Enter Your Choice:");
num = input.nextInt();   
 
   switch(num){    
   case 1: System.out.println("Register"); 
           obj.userInput_Reg(); 
           break;  
   case 2: System.out.println("Login");  
           h = obj.readFromFile_Login();
           if(h.equals("LOGIN"))
           {
               obj.Account_Details
from Virendra to All Participants:
}
           break;    
   default: System.out.println("Please select 1 or 2 option");  
   }*/
package program.java.arrays;

public class ArrayAdd_2D {
	
	public static void main( String args[]) 
	{
	       //int[][] arr = { { 1, 2 }, { 3, 4 } };
	       int[][] arrA = {{ 7,4},{2,9}} ;
	       int[][] arrB = {{ 1,5},{3,8}} ;
	       int[][] arrC = new int[2][2] ;
		   for (int i = 0; i < 2; i++) {                // for row
		       for (int j = 0; j < 2; j++) {            // for column
  
		             arrC[i][j] = arrA[i][j] + arrB[i][j] ;
		             System.out.print(arrC[i][j] + " ");
		        } 
		        System.out.println(); 
		  } 
	} 
		
}

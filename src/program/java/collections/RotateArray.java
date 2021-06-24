package program.java.collections;
import java.util.Stack;

public class RotateArray {
	public static void main( String[] args ) 
	{
		int [] arr = { 1, 2, 3, 4, 5 } ; 
		
		int n = 2 ;
		 
		System.out.println("Orignial array: " ) ;
		for ( int i = 0 ; i < arr.length; i++ ) 
		{
			System.out.print(arr[i] + " " ) ;
			
		}
		// rotate the array by n time to right
		for( int i = 0 ; i < n ; i ++ ) 
		{
			int j, last ; 
			//stores the las element of array 
			last = arr[arr.length - 1] ;
			
			for ( j= arr.length-1 ; j > 0; j-- ) 
			{
				//shift element of array by one 
				arr[j] = arr[j-1] ;
			}
			
			// last element of arry will be added to the start of array
			arr[0] = last ;
		}
		System.out.println();
		//Display resulting array
		System.out.println("Array after right rotation: " ) ;
		for ( int i = 0 ; i < arr.length ; ++i ) 
		{
			
			System.out.print( arr[i] + " " ); 
		}
		/// left rotATION
		
		int [] arr2 = { 1, 2, 3, 4, 5 } ; 
		
		int n2 = 2 ;
		 
		System.out.println("Orignial array: " ) ;
		for ( int i = 0 ; i < arr2.length; i++ ) 
		{
			System.out.print(arr2[i] + " " ) ;
			
		}
		// rotate the array by n time to right
		for( int i = 0 ; i < n2 ; i ++ ) 
		{
			int j, first , last ; 
			//stores the las element of array 
			//last = arr[arr2.length - 1] ;
			first = arr[ 0 ] ;
			
			//for ( j= arr2.length-1 ; j > 0; j-- ) 
			//{
				//shift element of array by one 
			//	arr2[j] = arr2[j-1] ;
			//}
			for ( j= 0 ; j < arr2.length-1 ; j++ ) 
			{
				arr2[j] = arr2[j+1] ;
			}
			
			// last element of arry will be added to the start of array
			arr2[ arr.length-1] = first ;
		}
		System.out.println();
		//Display resulting array
		System.out.println("Array after right rotation: " ) ;
		for ( int i = 0 ; i < arr2.length ; ++i ) 
		{
			
			System.out.print( arr2[i] + " " ); 
		}
		doStackOperations() ;
	}

	//public arrayRotate( Array[] a, int roations ) ;
	public void swap( int arr[], int i, int j )
	{
		int temp = arr[i] ;
		arr[i] = arr[j] ;
		arr[j] = temp ;
	}
	public int partition( int arr[], int l, int  r )
	{
		int x = arr[4], i = l ;
		//ro ( int j = l ; j <=)
		return 0 ;
	}
	public static void doStackOperations()
	{
		Stack<Integer> s = new Stack<Integer>() ;
		System.out.println("\n <==== Stack Operations ====>" ) ;
		s.push(100) ; System.out.println( "Push 100" ) ;
		s.push(200) ; System.out.println( "Push 200" ) ;
		s.push(300) ; System.out.println( "Push 300" ) ;
		System.out.println( "TOS: "+s.peek()) ;
		System.out.println( "Popped: " + s.pop() +" TOS: "+ s.peek()) ;
		
	}
}
class SinglyLinkedList {    
    //Represent a node of the singly linked list    
    class Node{    
        int data;    
        Node next;    
            
        public Node(int data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    

public Node head = null;    
    public Node tail = null;    
        
    //addNode() will add a new node to the list    
    public void addNode(int data) {    
        //Create a new node    
        Node newNode = new Node(data);    
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            //newNode will be added after tail such that tail's next will point to newNode    
            tail.next = newNode;    
            //newNode will become new tail of the list    
            tail = newNode;    
        }    
    }    
}
/*public void searchFileInDirectory (String fileName, String directoryPath) throws Exception { 
          File fileDir = new File(directoryPath);
          if (fileDir.isDirectory() == true) {
            List listFile = Arrays.asList(fileDir.list());
            if (listFile.contains(fileName)) {
                System.out.println("file was found");
            }
            else {
                throw new FileNotFoundException("file was not found");
            }
          }
          else {
            throw new IOException("directory does not exist/directory was not found");
          }
      }


*/
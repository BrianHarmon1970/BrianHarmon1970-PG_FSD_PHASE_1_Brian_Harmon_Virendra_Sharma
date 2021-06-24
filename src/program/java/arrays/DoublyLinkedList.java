package program.java.arrays;

class DoubleLinkedList 
{
	
	Node head ;
	Node tail ;

	//public class SinglyLinkedList {    
	    //Represent a node of the singly linked list    
    class Node
    {    
        int data;    
        Node next;  
        Node previous ;
            
        public Node(int data) 
        {    
            this.data = data;    
            this.next = null;
            this.previous = null ;
        }
    }
	
	public void addNode( int data)
	{
		//crat a new node
		Node newNode = new Node( data ) ;
		if (head == null )
		{
			//both had and tail will point to newnode
			head = tail = newNode ;
			// heads previous will poin to null
			head.previous = null ;
			//tails nex will pint to null, as it is the last node of th list
			tail.next = null ;
		}
		else 
		{
			//newNode will be added oafter tail such that tail's next will point to newNode
			tail.next = newNode ;
			//newNodes previous will poirn to tail
			newNode.previous = tail ;
			//newNOde will become new tail
			tail = newNode ;
			// as it is last node, tail's nex will  point tn null
			tail.next = null ;
		}
	}
		
		//dispaly wil print out nodes of the list
	public void display() 
	{
		//Node current will point to head
		Node current = head ;
		if( head == null ) 
		{
			System.out.println("List is empty") ;
			return ;
		}
		System.out.println("NOdes of doubly linked list: " ) ;
		while(current != null ) 
		{
			//Prints each node by incrementing the pointer.
					
					System.out.print(current.data + " " ) ;
			current = current.next ;
		}
	}
}
	    
public class DoublyLinkedList
{
	public static void main( String[] args ) 
	{
		DoubleLinkedList dList = new DoubleLinkedList() ;
		//Add nodes to the list
		dList.addNode(1) ;
		dList.addNode(2) ;
		dList.addNode(3) ;
		dList.addNode(4) ;
		dList.addNode(5) ;
		
		//Displays the noes presen in the listt
		dList.display() ;
	}
}
/*
		from Virendra to All Participants:
		public class SinglyLinkedList {    
		    //Represent a node of the singly linked list    
		    class Node{    
		        int data;    
		        Node next;    
		            
		        public Node(int data) {    
		            this.data = data;    
		            this.next = null;    
		        }    
		    }    
		from Virendra to All Participants:
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
		public void searchFileInDirectory (String fileName, String directoryPath) throws Exception { 
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
		//https://coda.io/@michalis/scrum-project-template
		//link to add the new sprint :  https://coda.io/@michalis/scrum-project-template/sprints-overview-4
		//link to product backlog :  https://coda.io/@michalis/scrum-project-template/backlog-1
		//add a task :  https://coda.io/@michalis/scrum-project-template   ( add go to "Plan the tasks" column
		//link to add a story :   https://coda.io/@michalis/scrum-project-template/backlog-1
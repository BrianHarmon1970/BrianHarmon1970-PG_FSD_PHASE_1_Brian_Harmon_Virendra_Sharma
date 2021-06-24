package ds.java.programs;
import java.util.Arrays ;

/*
from Virendra to All Participants:
https://www.codesdope.com/practice/java-classes-and-objects/
from Virendra to All Participants:
https://www.javatpoint.com/directload.jsp?val=10
from Virendra to All Participants:
https://www.vskills.in/practice/java-oop-questions
*/

public class LinearSearch {
	public static void main( String[] args ) 
	{
		int arr[] = {5,13,90,10,12,11,2,15 } ;
		int search_val = 12 ;
		
		System.out.println("======= Linear Search ========" ) ;
		for ( int i = 0 ; i < arr.length ; ++i )
		{
			if ( arr[i] == search_val )
			{
				System.out.println(  "Element found at ndx = " + i ) ;
				break ;
			}
		} 
		
		System.out.println("======= Binary Search ========" ) ;
		
		int arr2[] = {2,5,8,12,16,23,58,56,72,91 } ;
	
		search_val = 23 ;
		int left = 0, right, mid ;
		right = arr2.length-1 ;
		
		mid = ( left + right ) / 2 ;
		
		while( mid < right )
		{
			mid = (left + right )/ 2 ;
			if ( arr2[ mid-1 ] == search_val )
			{
				System.out.println( "element found at " + mid  ) ;
				break ;
			}
			else if ( search_val < arr2[mid] ) 
				 right = mid ;
			else if ( search_val > arr2[mid] )
				left = mid ;
		}
		
		System.out.println("======= Exponential Search ========" ) ;
		//int arr4[] = {2,5,8,12,16,23,58,56,72,91 } ;
		//search_val = 23 ;
		System.out.println( "element found at : " + exponentialSearch(arr2, arr2.length, search_val )) ;
		
		
		System.out.println("======= Bubble Sort  ========" ) ;
		int unsorted[] = { 1, 5 , 50, 30, 10, 12, 90 } ;
		BubbleSort( unsorted , unsorted.length ) ;
		int [] arr3 = {9,12,3,21,44,5,1,10,25} ;
		InsertionSort(arr3) ;
		for ( int i = 0 ; i < arr3.length ; i++ ) 
		{
			System.out.println(arr3[i]) ;
		}
				
		System.out.println("======= Selection Sort ========" ) ;
		int unsorted1[] = {9,6,4,1,2,4,5}  ;
		SelectionSort( unsorted1 ) ;
		System.out.println("Thge sorted elementes are: " ) ;
		for ( int i : unsorted1 )
		{
			System.out.println(i) ; 
		}
		
		System.out.println("======= Insertion Sort ========" ) ;
		int unsorted3[] = {	10, 20, 5, 8, 16, 43, 32, 90, 88, 23 , 4, 4, 5 }  ;
		InsertionSort( unsorted3 ) ;
		System.out.println("The (insertionsort) sorted elementes are: " ) ;
		for ( int i : unsorted3 )
		{
			System.out.println(i) ; 
		}
				
		System.out.println("======= Quick Sort ========" ) ;
		int unsorted2[] = { 10, 7, 8, 9, 1, 5, 90, 45, 88, 55, 11, 43, 23, 4, 2, 99 } ;
		QuickSort( unsorted2 ) ;
		System.out.println("Thge (quicksort)sorted elementes are: " ) ;
		for ( int i : unsorted2 )
		{
			System.out.println(i) ; 
		}
	}

	static int exponentialSearch( int[] arr,int length, int value) 
	{
		if ( arr[0]==value)
		{
			return 0 ;
		}
		int i = 1 ;
		while( i < length && arr[i] <= value ) 
			i = i*2 ;
	
		return Arrays.binarySearch( arr, i/2, Math.min( i, length ), value) ;
	}

	static void BubbleSort( int[] arr , int l)
	{
		int temp = 0 ;
		for ( int i = 0 ; i < l ; ++i )
		{
			for ( int j=1 ; j < l ; j++ ) 
			{
				if ( arr[j-1]>arr[j]) 
				{
						temp = arr[ j-1 ] ;
						arr[ j-1 ] = arr[j];
						arr[j]= temp ;
				}
			}
		}
	}
	static void InsertionSort( int[] arr ) 
	{
		int len = arr.length;
		for ( int j = 1 ; j< len ; j++ ) 
		{
			int key = arr[j] ;
			int i = j-1 ;
			while ((i>=1) && (arr[i]>key))
			{
				arr[i+1]= arr[i];
				i-- ;
			}
			arr[i+1]=key ;
		}
	}
	static void SelectionSort( int [] arr ) 
	{
		for ( int i = 0 ; i < arr.length ; i++ )
		{
			
			int index = i ; 
			for ( int j =i  ; j < arr.length ; ++j)
			{
				if ( arr[j]<arr[index]) 
				{
					index = j ;
				}
			}
			int smallNumber = arr[index];
			arr[index]= arr[i];
			arr[i]  =  smallNumber ;
		}
	}
	static void QuickSort( int array[] ) 
	{
		//partition( array, 0, array.length-1 ) ; 
		sort( array, 0 , array.length-1 )  ;
	}
	static int partition( int arr[], int low, int high ) 
	{
		int pivot = arr[high] ;
		int i = (low-1) ;
		for (int j = low ; j<high; j++) 
		{
			if ( arr[j] <= pivot )
			{
				i++ ;
				
				// swap arr[i] adn arr[ j ] 
				int temp = arr[i] ;
				arr[i] = arr[j] ;
				arr[j] = temp ;
			}
		}
		
		int temp = arr[i+1] ;
		arr[i+1] = arr[high] ;
		arr[high] = temp ;
		
		return i+1 ;
	}
	static void sort( int arr[], int low, int high )
	{
		if ( low < high ) 
		{
			int pi = partition( arr, low, high ) ;
			sort( arr, low, pi-1) ;
			sort( arr, pi+1, high ) ;
		}
	}
}
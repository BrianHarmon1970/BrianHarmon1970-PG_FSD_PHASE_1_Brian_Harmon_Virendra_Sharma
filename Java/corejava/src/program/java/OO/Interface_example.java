package program.java.OO;

interface Polygon
{
	void Draw(  ) ;
	int GetNumberOfSides() ;
}

class Shape
{
	public int sides ;
	
	public int GetNumberOfSides(  ) 
	{
		return sides ;
	}
}

class Rectangle extends Shape implements Polygon
{
	Rectangle()
	{
		sides = 4 ;
	}
	public void Draw() 
	{
		System.out.println("Draw: (Rectangle) "+ GetNumberOfSides() + " Sides" ) ;
	}
}

class Triangle extends Shape implements Polygon
{
	Triangle()
	{
		sides = 3 ;
	}
	public void Draw() 
	{
		System.out.println("Draw: (Triangle) "+ GetNumberOfSides() + " Sides" ) ;
	}
}

class Hexagon  extends Shape implements Polygon
{
	Hexagon()
	{
		sides = 6 ;
	}
	public void Draw() 
	{
		System.out.println("Draw: (Hexagon) "+ GetNumberOfSides() + " Sides" ) ;
	}
}

public class Interface_example 
{
	public static void main( String[] args ) 
	{
		Rectangle r = new Rectangle( ) ;
		Triangle t = new Triangle() ;
		Hexagon h = new Hexagon() ;
		
		r.Draw();
		t.Draw();
		h.Draw();
	}

}

/* MapPoint.java */
import java.awt.Point;
import java.util.Objects;


/**
 * Overrides the Point class to make it hashable.
 * @author Eric Peyton
 * @version 1.0
 */
public class MapPoint extends Point {

	/**
	 * Constructor for MapPoint.
	 * @param p Point
	 */
	public MapPoint(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for MapPoint.
	 * @param x int
	 * @param y int
	 */
	public MapPoint(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
	
	/**
	 * Method equals.
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof MapPoint) {
			final MapPoint other = (MapPoint) obj;
			if(x == other.getX() && y == other.getY()) {
				return true;
			}
		}
		return false;
	}
	
	

}

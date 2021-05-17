package ktp_lab3;

/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (obj == null) {
    		return false;
    	}
    	if (obj == this) {
    		return true;
    	}
    	if (getClass() == obj.getClass()) {
    		Location t = (Location)obj;
    		return t.xCoord == this.xCoord && t.yCoord == this.yCoord;
    	}
    	return false;
    }
    
    @Override
    public int hashCode() {
    	return (this.xCoord*31 + (this.xCoord+1)*17)*31 + (this.yCoord*31 - (this.yCoord-2)*17)*17;
    }
}

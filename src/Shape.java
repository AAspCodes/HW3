import java.awt.Graphics;
/**
 * 
 * @author  Anthony Asp & Michael Cho
 *
 */
public interface Shape {
	/**
	 * Draws the current state of the recursive image
	 * 
	 * @param g
	 *            the Graphics context on which to draw
	 */
	void draw(Graphics g);
	
	/**
	 * Adds a level of recursive shapes
	 * 
	 * @return boolean
	 * 			Whether or not a level was added
	 */
	public boolean addLevel();
	
	/**
	 * Reverses the recursive drawing of the shape and removes level
	 * 
	 * @return boolean
	 * 			Whether or not a level was removed
	 */
	public boolean removeLevel();
	
	/**
	 * Recursive algorithm to count the number of shapes
	 * 
	 * @return numOfShapes 
	 * 				The number of shapes below this shape and this shape
	 */
	public int countShapes();
	
	/**
	 * Updates values for the slider
	 * 
	 * @param value
	 * 			The new slider value
	 */
	public void update(int value);
}

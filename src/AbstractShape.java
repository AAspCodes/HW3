import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 */

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public abstract class AbstractShape implements Shape {

	protected AbstractShape[] children; // the array of children shapes
	protected int level, width, height, drawStartX, drawStartY; // level, width and height of the graphics frame, origin starting at (0,0) 
	protected final int maxLevel; 		// max level determined by each shape class
	protected Color color;				// the color the shape will be drawn in
	protected double sliderVal = 1.0;   // slider value that skews the shapes
	public static int count;			// the number of shapes in the display


	/**
	 * AbstractShape child constructor shared by the shape subclasses
	 * 
	 * @param drawStartX
	 *            x-coordinate origin
	 * @param drawStartY
	 * 			  y-coordinate origin
	 * @param width
	 *            width of the graphics space
	 * @param height
	 * 			  height of the graphics space
	 * @param maxlevel
	 *            maximum level of recursion
	 * @param level
	 *            current level of recursion
	 * @param color
	 * 			  color of the shape
	 * 
	 */
	protected AbstractShape(int drawStartX, int drawStartY, int width, int height, int maxLevel, int level,
			Color color) {
		this.drawStartX = drawStartX;
		this.drawStartY = drawStartY;
		this.width = width;
		this.height = height;
		this.maxLevel = maxLevel;
		this.level = level;
		this.color = color;
	}


	/**
	 * AbstractShape constructor shared by the shape subclasses
	 * 
	 * @param maxlevel
	 *            maximum level of recursion
	 * @param level
	 *            current level of recursion
	 * @param color
	 *            color of the shape
	 * 
	 */
	protected AbstractShape(int maxLevel, int level, Color color) {
		this.maxLevel = maxLevel;
		this.level = level;
		this.color = color;
	}

	/**
	 * Draws the current state of the recursive image
	 * 
	 * @param g
	 *            the Graphics context on which to draw
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		if (children == null) {
			drawBaseShape(g);
		} else {
			for (AbstractShape child : children) {
				child.draw(g);
			}
		}
	}
	/**
	 * Draw the base shape
	 */
	protected abstract void drawBaseShape(Graphics g);

	/**
	 * Adds a level of recursive shapes
	 * 
	 * @return boolean
	 * 			Whether or not a level was added
	 */
	@Override
	public boolean addLevel() {
		if (level == maxLevel) {
			return false;
		} else if (children != null) {
			for (Shape child : children) {
				if (!child.addLevel()) {
					return false;
				}
			}
		} else {
			createChildren();
		}
		count = countShapes();
		return true;
		
	}

	/**
	 * Reverses the recursive drawing of the shape and removes level
	 * 
	 * @return boolean
	 * 			Whether or not a level was removed
	 */
	@Override
	public boolean removeLevel() {

		if (children == null) { 
			return false;
		} else if (children[0].children == null) {
			children = null;
		} else {
			for (AbstractShape child : children) {
				child.removeLevel();
			}
		}
		count = countShapes();
		return true;

	}

	/**
	 * Recursive algorithm to count the number of shapes
	 * 
	 * @return numOfShapes 
	 * 				The number of shapes below this shape and this shape
	 */
	@Override
	public int countShapes() {
		if (children != null) {
			int numOfShapes = 0;
			for (AbstractShape child : children) {
				numOfShapes += child.countShapes();
			}
			return numOfShapes;
		} else {
			return 1;
		}
	}
	
	/**
	 * Send shape count to FractalDisplay
	 * 
	 * @return count
	 * 			The number of shapes
	 */
	public static int getCount() {
		return count;
	}
	

	/**
	 * Updates values for the slider
	 * 
	 * @param value
	 * 			The new slider value
	 */
	@Override
	public void update(int value) {
		sliderVal = value / 50.0;
		int depth = findDepth();
		children = null;
		createChildrenAtDepth(depth);
	}

	/**
	 * @param depth
	 * 			how deep to make the tree
	 */
	private void createChildrenAtDepth(int depth) {
		if (depth > 1) {
			createChildren();
			depth--;
			for (AbstractShape child : children) {
				child.createChildrenAtDepth(depth);
			}
		}
	}

	/**
	 * @return int depth
	 * 				the depth of the tree
	 */
	private int findDepth() {
		if (children == null) {
			return 1;
		} else {
			return 1 + children[0].findDepth();
		}
	}

	/**
	 * Create a new set of children.
	 */
	protected abstract void createChildren();

}

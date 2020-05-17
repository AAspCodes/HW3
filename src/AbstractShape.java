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
	protected final int maxLevel; // maxlevel determined by each shape

	protected Color color;
	protected double sliderVal = 1.0; // slider value that skews the shapes
	public static int count;

	/**
	 * AbstractShape child constructor shared by the shape subclasses
	 * 
	 * @param maxlevel
	 *            maximum level of recursion
	 * @param level
	 *            current level of recursion
	 * @param width
	 *            width of the graphics space
	 * @param height
	 * 			  height of the graphics space
	 * @param drawStartX
	 *            x-coordinate origin
	 * @param drawStartY
	 * 			  y-coordinate origin
	 * @param color
	 * 			  color of the shape
	 * 
	 */
	protected AbstractShape(int maxLevel, int level, int width, int height,int drawStartX, int drawStartY, Color color) {
		this.maxLevel = maxLevel;
		this.level = level;
		this.width = width;
		this.height = height;
		this.drawStartX = drawStartX;
		this.drawStartY = drawStartY;
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

	abstract public void drawBaseShape(Graphics g);

	/**
	 * Adds a level of recursive shapes
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
	 */
	public static int getCount() {
		return count;
	}
	

	/**
	 * Updates values for the slider
	 */
	@Override
	public void update(int value) {
		sliderVal = value / 50.0;
		int depth = findDepth();
		children = null;
		createChildrenAtDepth(depth);
	}

	private void createChildrenAtDepth(int depth) {
		if (depth > 1) {
			createChildren();
			depth--;
			for (AbstractShape child : children) {
				child.createChildrenAtDepth(depth);
			}
		}
	}

	private int findDepth() {
		if (children == null) {
			return 1;
		} else {
			return 1 + children[0].findDepth();
		}
	}

	private void createChildrenAtDepth(int depth) {
		if (depth > 1) {
			createChildren();
			depth--;
			for (AbstractShape child: children) {
				child.createChildrenAtDepth(depth);
			}
		}
	}
	
	private int findDepth() {
		if (children == null) {
			return 1;
		} else {
			return 1 + children[0].findDepth();
		}
	}
	/**
	 * 
	 */

	abstract public void createChildren();

}

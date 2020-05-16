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
	protected AbstractShape[] children;
	protected int level, width,height, drawStartX, drawStartY;
	protected final int maxLevel;
	protected Color color;

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
	 * @param Graphics g: java.awt.Graphics
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
	 * 
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
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean removeLevel() {

		if (children == null) {
			return false;
		} else if (children[0].children == null) {
			children = null;
		} else{
			for (AbstractShape child : children) {
				child.removeLevel();
			}
		}
		
		return true;

	}

	/**
	 * 
	 */
	@Override
	public int countShapes() {
		if (children != null) {
			int numOfShapes = 0;
			for (AbstractShape child: children) {
				numOfShapes += child.countShapes();
			}
			return numOfShapes;
		} else {
			return 1;
		}
	}

	/**
	 * 
	 */
	@Override
	public void update(int value) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	abstract public void createChildren();

}

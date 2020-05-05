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
	protected int level;
	protected int maxLevel;
	protected Color color;
	
	
	
	protected AbstractShape(int maxLevel, Color color) {
		this.children = new AbstractShape[maxLevel];
		this.level = 1;
		this.maxLevel = maxLevel;
		this.color = color;
	}
	/**
	 * @param Graphics g: java.awt.Graphics
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		getBaseShape(g);
		
	}
	abstract protected void getBaseShape(Graphics g);
	/**
	 * 
	 */
	@Override
	public boolean addLevel() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean removeLevel() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 */
	@Override
	public int countShapes() {
		// TODO Auto-generated method stub
		return 0;
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

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class HShape extends AbstractShape {
	private int width, height, drawStartX, drawStartY;

	public HShape(int width, int height) {
		super(7, 1, Color.RED);
		this.width = width;
		this.height = height;
		createChildren();
	}

	public HShape(int drawStartX, int drawStartY, int width, int height, int level) {
		super(7, level, Color.RED);
		this.drawStartX = drawStartX;
		this.drawStartY = drawStartY;
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 */
	@Override
	public void createChildren() {
		this.children = new AbstractShape[maxLevel];
		int childWidth, childHeight;
		childWidth = width / 3;
		childHeight = height / 3;

		children[0] = new HShape(drawStartX, drawStartY, childWidth, childHeight, level + 1);
		children[1] = new HShape(drawStartX, childHeight + drawStartY, childWidth, childHeight, level + 1);
		children[2] = new HShape(drawStartX, childHeight * 2 + drawStartY, childWidth, childHeight, level + 1);
		children[3] = new HShape(childWidth + drawStartX, childHeight + drawStartY, childWidth, childHeight, level + 1);
		children[4] = new HShape(childWidth * 2 + drawStartX, drawStartY, childWidth, childHeight, level + 1);
		children[5] = new HShape(childWidth * 2 + drawStartX, childHeight + drawStartY, childWidth, childHeight,
				level + 1);
		children[6] = new HShape(childWidth * 2 + drawStartX, childHeight * 2 + drawStartY, childWidth, childHeight,
				level + 1);
	}

	public void drawBaseShape(Graphics g) {
		g.setColor(color);
		g.fillRect(drawStartX, drawStartY, width, height);
	}

}

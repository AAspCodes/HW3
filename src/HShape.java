import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class HShape extends AbstractShape {

	protected static final int maxLevel = 5;
	protected static final Color color = Color.red;

	/**
	 * This constructor is used when creating the root HShape object.
	 * 
	 * @param width
	 * @param height
	 */
	public HShape(int width, int height) {
		this(0,0,width,height,1);
	}

	/**
	 * This constructor is used for creating children.
	 * 
	 * @param drawStartX
	 * @param drawStartY
	 * @param width
	 * @param height
	 * @param level
	 */
	public HShape(int drawStartX, int drawStartY, int width, int height, int level) {
		super(drawStartX, drawStartY, width, height, maxLevel, level, color);
	}

	/**
	 * 
	 */
	@Override
	protected void createChildren() {
		this.children = new AbstractShape[7];

		int newLevel = level + 1;
		int childWidth = (int) Math.round(width / 3.0);
		int childHeight = (int) Math.round(height / 3.0);
		int childNumber = 0;

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (col == 1 && row != 1) {
					continue;
				}
				// make child
				children[childNumber] = new HShape(childWidth * col + drawStartX, childHeight * row + drawStartY,
						childWidth, childHeight, newLevel);
				childNumber++;
			}
		}
	}

	protected void drawBaseShape(Graphics g) {
		g.fillRect(drawStartX, drawStartY, width / 3, height);
		g.fillRect(drawStartX + width / 3, drawStartY + height / 3, width / 3, height / 3);
		g.fillRect(drawStartX + width / 3 * 2, drawStartY, width / 3, height);
	}

}

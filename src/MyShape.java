import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class MyShape extends AbstractShape {
	protected static final int maxLevel = 7;
	protected static final Color color = Color.BLUE;

	protected MyShape(int width, int height) {
		this(0, 0, width, height, 1);
	}

	protected MyShape(int drawStartX, int drawStartY, int width, int height, int level) {
		super(drawStartX, drawStartY, width, height, maxLevel, level, color);
	}

	/**
	 * 
	 */
	@Override
	public void createChildren() {
		this.children = new AbstractShape[8];
		// nearly identical to the HShape...
		int newLevel = level + 1;
		int childWidth = (int) Math.round(width / 3.0);
		int childHeight = (int) Math.round(height / 3.0);
		int childNumber = 0;

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (col == 1 && row == 1) {
					continue;
				}
				// make child
				children[childNumber] = new MyShape(childWidth * col + drawStartX, childHeight * row + drawStartY,
						childWidth, childHeight, newLevel);
				childNumber++;
			}
		}

	}

	@Override
	public void drawBaseShape(Graphics g) {
		g.fillRect(drawStartX, drawStartY, width, height);

	}
}

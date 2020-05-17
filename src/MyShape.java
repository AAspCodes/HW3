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
		// height and width -1 to prevent the line from being draw outside the box;
		super(maxLevel, 1, width, height, 0, 0, color);
	}
	
	/**
	 * This constructor is used for creating children.
	 * 
	 * @param drawStartX
	 * @param drawStartY
	 * @param width
	 * @param height
	 * @param level
	 * 
	 */
	protected MyShape(int drawStartX, int drawStartY, int width, int height, int level) {
		super(maxLevel, level, width, height, drawStartX, drawStartY, color);
	}

	/**
	 * Creates a new set of children.
	 */
	@Override
	public void createChildren() {
		this.children = new AbstractShape[8];
		// nearly identical to the HShape...
		int newLevel = level + 1;
		int childWidth = (int) (width / 3.0);
		int childHeight = (int) (height / 3.0);
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

	/**
	 * Draws the initial shape
	 */
	@Override
	public void drawBaseShape(Graphics g) {
		g.fillRect(drawStartX, drawStartY, width, height);

	}
}

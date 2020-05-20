import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class MyShape extends AbstractShape {
	protected static final int maxLevel = 7;

	protected static Color color = Color.BLUE;
	Random rand = new Random();


	/**
	 * Construct a new MyShape.
	 * This constructor is for the initial root shape.
	 * 
	 * @param width
	 * 		The width of the display.
	 * @param height
	 * 		The height of the display.
	 */

	protected MyShape(int width, int height) {
		this(0, 0, width, height, 1);
		super.color = color;
	}

	/**
	 * Construct a new MyShape.
	 * This constructor is used for creating children.
	 * 
	 * @param drawStartX
	 *            x-coordinate origin
	 * @param drawStartY
	 * 			  y-coordinate origin
	 * @param width
	 *            width of the graphics space
	 * @param height
	 * 			  height of the graphics space
	 * @param level
	 *            The depth of this shape in relation to the root.
	 * 
	 */
	protected MyShape(int drawStartX, int drawStartY, int width, int height, int level) {

		super(drawStartX, drawStartY, width, height, maxLevel, level);
		switch(rand.nextInt(7)) {
			case 0:
				color = Color.RED;
				break;
			case 1:
				color = Color.BLUE;
				break;
			case 2:
				color = Color.GREEN;
				break;
			case 3:
				color = Color.CYAN;
				break;
			case 4:
				color = Color.ORANGE;
				break;
			case 5:
				color = Color.YELLOW;
				break;
			case 6:
				color = Color.BLACK;
				break;
			default:
				break;
		}

	}

	/**
	 * Create a new set of children.
	 */
	@Override
	protected void createChildren() {
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

	/**
	 * Draw the base shape
	 */
	@Override
	protected void drawBaseShape(Graphics g) {
		g.fillRect(drawStartX, drawStartY, width, height);

	}
}

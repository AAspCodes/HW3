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
		super(drawStartX, drawStartY, width, height, maxLevel, level, color);
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

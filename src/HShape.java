import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class HShape extends AbstractShape {

	protected static final int maxLevel = 5;
	protected static Color color = Color.red;
	Random rand =  new Random();

	/**
	 * This constructor is used when creating the root HShape object.
	 * 
	 * @param width
	 * @param height
	 */
	public HShape(int width, int height) {
		super(maxLevel,
			1,  // level
			  width,
			  height,
			  0, // drawStartX
			  0, // drawStartY
			  color);
		
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
	public HShape(int drawStartX, int drawStartY, int width, int height, int level) {
<<<<<<< Updated upstream
		super(maxLevel, level, width, height, drawStartX, drawStartY, color);
=======
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
		
>>>>>>> Stashed changes
	}

	/**
	 * Creates a new set of children.
	 */
	@Override
	public void createChildren() {
		this.children = new AbstractShape[7];

		int newLevel = level + 1;
		int childWidth = (int) (width / 3.0);
		int childHeight = (int) (height / 3.0);
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
	
	/**
	 * Draws the initial shape
	 */
	public void drawBaseShape(Graphics g) {
		g.fillRect(drawStartX, drawStartY, width / 3, height);
		g.fillRect(drawStartX + width / 3, drawStartY + height / 3, width / 3, height / 3);
		g.fillRect(drawStartX + width / 3 * 2, drawStartY, width / 3, height);
	}

}

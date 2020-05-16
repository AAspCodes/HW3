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
	 * @param drawStartX
	 * @param drawStartY
	 * @param width
	 * @param height
	 * @param level
	 */
	public HShape(int drawStartX, int drawStartY, int width, int height, int level) {
		super(maxLevel, level, width, height, drawStartX, drawStartY, color);
	}



	/**
	 * 
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

	public void drawBaseShape(Graphics g) {
		g.fillRect(drawStartX, drawStartY, width/3, height);
		g.fillRect(drawStartX + width/3, drawStartY + height / 3, width/3, height/3);
		g.fillRect(drawStartX + width/3 * 2, drawStartY, width/3, height);
	}

}

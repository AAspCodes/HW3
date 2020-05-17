import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class SierpinksiTriangle extends AbstractShape {
	protected static final int maxLevel = 10;
	protected static final Color color = Color.GREEN;
	private int[] xPoints = new int[4];
	private int[] yPoints = new int[4];

	protected SierpinksiTriangle(int width, int height) {
		// height -1 to prevents the line from being drawn outside the box;
		// it seems the display box has a height of 800 but only displays [0,799]
		// I'm not concerned with loosing the last pixel of the right side, so width was not adjusted.
		
		this(
			new int[] { 0, width / 2, width, 0 }, 			// xPoints
			new int[] { height-1, 0, height-1, height-1 },  // yPoints
			1.0,											// slider val
			1												// starting level
			);


	}

	protected SierpinksiTriangle(int[] xPoints, int[] yPoints, double sliderVal, int level) {
		super(maxLevel, level, color);
		this.xPoints = xPoints;
		this.yPoints = yPoints;
		this.sliderVal = sliderVal;
	}

	@Override
	public void createChildren() {
		this.children = new AbstractShape[3];
		int newLevel = level + 1;

		int[] sharedX = new int[] { 
				(int) ((xPoints[1] - xPoints[0]) / 2.0 * sliderVal) + xPoints[0],
				(int) ((xPoints[2] - xPoints[1]) / 2.0 * sliderVal) + xPoints[1],
				(int) (xPoints[0] + ((xPoints[2] - xPoints[0]) / 2.0 * sliderVal)) };

		int[] sharedY = new int[] { 
				(int) (yPoints[0] - ((yPoints[0] - yPoints[1]) / 2.0 * sliderVal)),
				(int) (yPoints[1] + ((yPoints[2] - yPoints[1]) / 2.0 * sliderVal)),
				(int) (yPoints[0] - ((yPoints[0] - yPoints[2]) / 2.0 * sliderVal)) };

		children[0] = new SierpinksiTriangle(new int[] { xPoints[0], sharedX[0], sharedX[2], xPoints[3] },
											 new int[] { yPoints[0], sharedY[0], sharedY[2], yPoints[3] },
											 sliderVal, newLevel);

		children[1] = new SierpinksiTriangle(new int[] { sharedX[0], xPoints[1], sharedX[1], sharedX[0] },
											 new int[] { sharedY[0], yPoints[1], sharedY[1], sharedY[0] },
											 sliderVal, newLevel);

		children[2] = new SierpinksiTriangle(new int[] { sharedX[2], sharedX[1], xPoints[2], sharedX[2] },
											 new int[] { sharedY[2], sharedY[1], yPoints[2], sharedY[2] },
											 sliderVal, newLevel);

	}

	@Override
	public void drawBaseShape(Graphics g) {
		g.drawPolyline(xPoints, yPoints, 4);
	}

}

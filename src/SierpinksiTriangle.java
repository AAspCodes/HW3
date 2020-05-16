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
		// height and width -1 to prevent the line from being drawn outside the box;
		// it seems the display box has a height of 800 but only displays [0,799]
		super(maxLevel, 1, width - 1, height - 1, 0, 0, color);
		int bottomY = drawStartY + this.height;
		xPoints = new int[] { drawStartX, (drawStartX + (this.width / 2)), drawStartX + this.width, drawStartX };
		yPoints = new int[] { bottomY, drawStartY, bottomY, bottomY };

	}

	protected SierpinksiTriangle(int[] xPoints, int[] yPoints,double sliderVal, int level) {
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
				(int)((xPoints[1] - xPoints[0]) / 2.0 * sliderVal)+ xPoints[0],
				(int)(xPoints[1] + xPoints[1] / 2.0 * sliderVal),
				(int)(xPoints[2]/ 2 * sliderVal)	
				};
		int[] sharedY = new int[] {

				(int) (yPoints[0] - ((yPoints[0] - yPoints[1]) / 2.0 * sliderVal)) ,
				(int) (yPoints[1] + ((yPoints[2] - yPoints[1]) / 2.0 * sliderVal)),
				yPoints[0]
				};
		
		
		
		
		children[0] = new SierpinksiTriangle(new int[] {xPoints[0],sharedX[0], sharedX[2], xPoints[3]},
											new int[] {yPoints[0], sharedY[0], sharedY[2], yPoints[3]},
											sliderVal,
											newLevel);
		
	
		children[1] = new SierpinksiTriangle(new int[] {sharedX[0], xPoints[1], sharedX[1], sharedX[0]},
											 new int[] {sharedY[0], yPoints[1], sharedY[1], sharedY[0]},
											 sliderVal,
											 newLevel);
		
		children[2] = new SierpinksiTriangle(new int[] {sharedX[2], sharedX[1], xPoints[2], sharedX[2]},
											 new int[] {sharedY[2], sharedY[1], yPoints[2], sharedY[2]},
											 sliderVal,
											 newLevel);
		
		
//		children[0] = new SierpinksiTriangle(drawStartX, drawStartY + newHeight, newWidth, newHeight, newLevel);
//		children[1] = new SierpinksiTriangle(drawStartX + width / 4, drawStartY, newWidth, newHeight, newLevel);
//		children[2] = new SierpinksiTriangle(drawStartX + newWidth, drawStartY + newHeight, newWidth, newHeight,
//				newLevel);

	}

	@Override
	public void drawBaseShape(Graphics g) {
		g.drawPolyline(xPoints, yPoints, 4);
	}

}

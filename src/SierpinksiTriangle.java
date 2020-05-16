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

	protected SierpinksiTriangle(int width, int height) {
		// height and width -1 to prevent the line from being drawn outside the box;
		// it seems the display box has a height of 800 but only displays [0,799]
		super(maxLevel, 1, width - 1, height - 1, 0, 0, color);

	}

	protected SierpinksiTriangle(int drawStartX, int drawStartY, int width, int height, int level) {
		super(maxLevel, level, width, height, drawStartX, drawStartY, color);

	}

	@Override
	public void createChildren() {
		this.children = new AbstractShape[3];
		int newLevel = level + 1;
		int newWidth = width / 2;
		int newHeight = height / 2;
		children[0] = new SierpinksiTriangle(drawStartX, drawStartY + newHeight, newWidth, newHeight, newLevel);
		children[1] = new SierpinksiTriangle(drawStartX + width / 4, drawStartY, newWidth, newHeight, newLevel);
		children[2] = new SierpinksiTriangle(drawStartX + newWidth, drawStartY + newHeight, newWidth, newHeight,
				newLevel);

	}

	@Override
	public void drawBaseShape(Graphics g) {
		int bottomY = drawStartY + height;
		int[] xPoints = new int[] { drawStartX, (drawStartX + (width / 2)), drawStartX + width, drawStartX };
		int[] yPoints = new int[] { bottomY, drawStartY, bottomY, bottomY };
		g.drawPolyline(xPoints, yPoints, 4);
	}

}

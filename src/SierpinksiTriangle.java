import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class SierpinksiTriangle extends AbstractShape {
	private int width, height, drawStartX, drawStartY;

	public SierpinksiTriangle(int WIDTH, int HEIGHT) {
		super(10, 1, Color.GREEN);
		this.width = WIDTH;
		this.height = HEIGHT;
		createChildren();
	}

	public SierpinksiTriangle(int drawStartX, int drawStartY, int width, int height, int level) {
		super(10, level, Color.GREEN);
		this.drawStartX = drawStartX;
		this.drawStartY = drawStartY;
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 */
	@Override
	public void createChildren() {
		this.children = new AbstractShape[maxLevel];
		
		children[0] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
		children[1] = new SierpinksiTriangle(drawStartX + (width / 4), drawStartY, width / 2, height / 2, level + 1);
		children[2] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
		children[3] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
		children[4] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
		children[5] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
		children[6] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
		children[7] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
		children[8] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
		children[9] = new SierpinksiTriangle(drawStartX, drawStartY, width, height, level + 1);
	}


	@Override
	public void drawBaseShape(Graphics g) {
		g.setColor(color);
		
		int[] xPoints = {drawStartX + ((width/4) * 2), drawStartX, drawStartX + width, drawStartX + ((width/4) * 2)};
		int[] yPoints = {drawStartY, drawStartY + height, drawStartY + height, drawStartY};
			
		g.drawPolyline(xPoints, yPoints, 4);

	}

}

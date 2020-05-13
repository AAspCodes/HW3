import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class HShape extends AbstractShape {
	private int width, height, drawStartX, drawStartY;

	public HShape(int width, int height) {
		super(7, 1, Color.RED);
		this.width = width;
		this.height = height;
		createChildren();
	}

	public HShape(int drawStartX, int drawStartY, int width, int height, int level) {
		super(7, level, Color.RED);
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
		// TODO Auto-generated method stub

	}

	public void drawBaseShape(Graphics g) {
		g.setColor(color);
		g.fillRect(drawStartX, drawStartY, width, height);
	}

}

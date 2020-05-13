import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class HShape extends AbstractShape {

	/**
	 * 
	 */
	public HShape() {
		// TODO Auto-generated constructor stub
		super(7, 1, Color.RED);
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

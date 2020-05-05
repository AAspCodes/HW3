import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * @author Anthony Asp & Michael Cho
 *
 */
public class SierpinksiTriangle extends AbstractShape {
	
	
	/**
	 * 
	 */
	protected SierpinksiTriangle() {
		super(3, Color.GREEN);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	@Override
	public void createChildren() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void getBaseShape(Graphics g) {
//		g.drawPolygon(new int[] {0,800}, new int[] {400,0}, new int[] {800,800}, new int[] {0,800});
		g.drawPolyline(new int[] {10, 400,790,10}, new int[] {790,10,790,790}, 4);
	}

}

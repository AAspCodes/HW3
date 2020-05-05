import java.awt.Graphics;
/**
 * 
 * @author  Anthony Asp & Michael Cho
 *
 */
public interface Shape {
	void draw(Graphics g);
	public boolean addLevel();
	public boolean removeLevel();
	public int countShapes();
	public void update(int value);
}

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball{
	int x;
	int y;
	int radius;
	int speedX = 3;
	int speedY = 1;
	
	private Graphics2D g;
	public Ball(int x, int y, int radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void paint(Graphics g){
		Graphics2D ball = (Graphics2D) g;
		ball.fillOval(x, y, radius, radius);
	}
}

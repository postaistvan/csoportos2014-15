package grafRajzolas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private int[][] edges;
	private int[] colors;
	private int n;
	private Point[] position;
	
	private final int R = 8;
	private final int DIST = 5;
	
	public Panel(int[][] matrix, int[] colors) {
		n = matrix.length;
		//n = 50;
		this.edges = new int[n][n];
		this.colors = new int[n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				this.edges[i][j] = matrix[i][j];
		
		for(int i = 0; i < n; i++)
			this.colors[i] = colors[i];
		
		position = new Point[n];
		
		Random r = new Random();
		int x, y;
		boolean reGenerate = false;
		
		for(int i = 0; i < n; i++){
			//System.out.println(i);
			do{
				reGenerate = false;
				x = r.nextInt(Rajzolas.ScreenW);
				y = r.nextInt(Rajzolas.ScreenH);
				for(int j = 0; j < i; j++){
					if(x > position[j].getX() - DIST && x < position[j].getX() + DIST){
						//System.out.println("x..."+x+" "+y);

						reGenerate = true;
						break;
					}
					if(y > position[j].getY() - DIST && y < position[j].getY() + DIST){
						//System.out.println("y..."+x+" "+y);
						reGenerate = true;
						break;
					}
				}
			}while(reGenerate);
			
			position[i] = new Point(x, y);
		}
	}
	
	public void kiir1(){
		for(int i = 0; i < n; i++)
			System.out.println(i + ": " + position[i].getX() + ", " + position[i].getY());
	}
	
	public void paint(Graphics g) {
		
		for(int i = 0; i < n; i++){
			if(colors[i] == 0){
				g.setColor(new Color(255, 0, 0));
			}else{
				g.setColor(new Color(0, 0, 255));
			}
			g.fillOval(position[i].getX(), position[i].getY(), R, R);
		}
		
		g.setColor(new Color(0, 0, 0));
		int x1, y1, x2, y2;
		int offset = R/2;
		for(int i = 0; i < n; i++)
			for(int j = i+1; j < n; j++)
				if(edges[i][j] == 1){
					x1 = position[i].getX() + offset;
					y1 = position[i].getY() + offset;
					x2 = position[j].getX() + offset;
					y2 = position[j].getY() + offset;
					g.drawLine(x1, y1, x2, y2);
				}
		
    }
}

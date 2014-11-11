package grafRajzolas;

import javax.swing.JFrame;

public class Rajzolas extends JFrame{
	private static final long serialVersionUID = 1L;
	protected static final int ScreenW = 400;
	protected static final int ScreenH = 400;
	private Panel p;
	
	private static final int[][] matrix = {
			{0, 1, 1, 1, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 0, 1, 1},
			{1, 1, 1, 0, 1},
			{1, 1, 1, 1, 0}
	};
	
	private static final int[] szinek = {0, 0, 1, 1, 0};
	
	public Rajzolas(int[][] edges, int[] colors) {
		setBounds(10, 10, ScreenW + 50, ScreenH + 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p = new Panel(edges, colors);
		add(p);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Rajzolas(matrix, szinek);
	}

}

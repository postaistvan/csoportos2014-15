package csoportos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class draw extends JFrame{

	int n;
	JButton[][] btn;
	
	public draw(int nn, int[][] v){
		this.n=nn;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("SejtAutomata");
		GraphicsConfiguration gc = this.getGraphicsConfiguration();  			
		Rectangle b = gc.getBounds();
		Dimension size = this.getPreferredSize();  
		this.setLocation((int) ((b.width / 3) - (size.getWidth() / 2)),  
	                    (int) ((b.height /5) - (size.getHeight() / 2)));   
		this.setSize(500,500);
		this.setVisible(true);
		this.setResizable(false);
		
		Container contentArea = getContentPane (); 
		JPanel panel=new JPanel();
		
		panel.setBackground(Color.black);
		panel.setLayout(new GridLayout(n,n,0,0));
		
		btn=new JButton[n][n];
		
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				btn[i][j]=new JButton();
				if (v[i][j]==0)
					btn[i][j].setBackground(Color.red);
				else
					btn[i][j].setBackground(Color.blue);
				panel.add(btn[i][j]);
			}
		}
		
		contentArea.add(BorderLayout.CENTER, panel);
		setContentPane (contentArea); 
	}
}

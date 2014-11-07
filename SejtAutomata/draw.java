package SejtAutomata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class draw extends JFrame{

	private static final long serialVersionUID = 1L;
	
	int n;
	JButton[][] btn;
	JButton next;
	int[][] v;
	Szabaly_Osszertek szo;
	
	public draw(int nn, int[][] vv){
		this.n=nn;
		this.v=vv;
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
		
		JPanel p = new JPanel();
		next= new JButton("Next");
		p.add(next);
		
		szo = new Szabaly_Osszertek(n,v,12,4);
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub					
				v=szo.getNext(v);
				szinez();
				//szo.writeTotal();
				//System.out.println(szo.toString());
			}
		});
		
		contentArea.add(BorderLayout.CENTER, panel);
		contentArea.add(BorderLayout.SOUTH, p);
		setContentPane (contentArea); 
	}
	
	private void szinez(){
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				if (v[i][j]==0)
					btn[i][j].setBackground(Color.red);
				else
					btn[i][j].setBackground(Color.blue);
			}
		}
	}
}

package csoportos;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=30;
		int[][] v=new int[n][n];
		Random p=new Random(1);
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				if (p.nextDouble()>0.4)
					v[i][j]=1;
				else
					v[i][j]=0;
			}
		}
		new draw(n,v);
	}

}

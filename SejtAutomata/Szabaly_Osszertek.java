package SejtAutomata;

public class Szabaly_Osszertek {

	private int n; 			//sejtautomata merete
	private int [][] m; 	//sejtautomata ertekei
	private float [][] total; //osszertekek vizsgalatahoz
	private int benefit; 	//nyereseg
	private int cost; 		//koltseg
	private float [][] payoff;//eredmeny matrix
	
	public Szabaly_Osszertek(int n1, int[][] m1, int benefit1, int cost1){
		n = n1;
		m = new int[n][n];
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				m[i][j] = m1[i][j];
		benefit = benefit1;
		cost = cost1;
		payoff = new float[2][2];
		payoff[0][0] = (benefit-cost)/2;	//PayOff matrix feltoltese
		payoff[0][1] = benefit;
		payoff[1][0] = 0;
		payoff[1][1] = benefit/2;
		total = new float[n][n];	// összértékek számolásához
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = " Sejtautomata\n";
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++)
				str += m[i][j] + " ";
			str += "\n";
		}
		str += "\n PayOff Matrix \n";
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++)
				str += payoff[i][j] + "  ";
			str += "\n";
		}
		str += "\n";
		return str;
	}
	
	public int[][] getNext(int[][] v){
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++){
				m[i][j] = v[i][j];
				total[i][j]=0;
			}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (m[i][j]==1) {
					osszertek(i, j, 1); //1 - a payoff matrix 2. sorat vegye figyelembe
				}
				else {
					osszertek(i, j, 0); //0 - a payoff matrix 1. sorat vegye figyelembe
				}
			}
		}
		szabalyAlkalmazasa();
		return m;
	}
	
	private void szabalyAlkalmazasa(){
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				float max = 0;
				int x = 0;
				int y = 0;
				if (i-1>=0)
					if (max < total[i-1][j]){
						max = total[i-1][j];
						x = i-1;
						y = j;
					}
				if (j-1>=0)
					if (max < total[i][j-1]){
						max = total[i][j-1];
						x = i;
						y = j-1;
					}
				if (i+1<n)
					if (max < total[i+1][j]){
						max = total[i+1][j];
						x = i+1;
						y = j;
					}
				if (j+1<n)
					if (max < total[i][j+1]){
						max = total[i][j+1];
						x = i;
						y = j+1;
					}
				if (max > total[i][j])
					m[i][j] = m[x][y];
			}
		}
	}
	
	private void osszertek(int i,int j,int x){
		if (i-1>=0)
			if (m[i-1][j]==1)
				total[i][j] += payoff[x][1];
			else
				total[i][j] += payoff[x][0];
		if (j-1>=0)
			if (m[i][j-1]==1)
				total[i][j] += payoff[x][1];
			else
				total[i][j] += payoff[x][0];
		if (i+1<n)
				if (m[i+1][j]==1)
				total[i][j] += payoff[x][1];
			else
				total[i][j] += payoff[x][0];
		if (j+1<n)
				if (m[i][j+1]==1)
				total[i][j] += payoff[x][1];
			else
				total[i][j] += payoff[x][0];
	}
	
	public void writeTotal(){
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) 
				System.out.print(total[i][j]+ "  ");
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = { {0,1,0}, {1,0,1}, {1,1,0} }; // Példa
		
		Szabaly_Osszertek szo = new Szabaly_Osszertek(3,matrix,12,4); 	// Szabály meghívása 3x3-as MATRIX-ra
																		// benefit = 12, cost = 4		
		System.out.println(szo.toString());
		
		szo.getNext();
		
		szo.writeTotal();
		
		System.out.println(szo.toString());
		
	}
	*/

}


import java.util.Random;

public class ErdosRenyi {
public int Node;
public double P;
	
public ErdosRenyi(int Node, double P){
	this.Node = Node;
	this.P=P;
	
}

public static int[][] getErdosrenyi(int Node, double P) {
	int[][] matrix = new int[Node][Node];
    for (int i = 0; i < Node; i++)
        for (int j = 0; j < Node; j++){
        	if(Math.random() <=P)
        		matrix[i][j]=1;
        }
    return matrix;
}

public void show() {
	int[][] matrix;
	matrix = getErdosrenyi(Node,P);
	int Node=30;
    for (int i = 0; i < Node; i++) {
        for (int j = 0; j < Node; j++) 
            System.out.print(matrix[i][j]);
        System.out.println();
    }
}
public static void main(String[] args) {
	int node = Integer.parseInt(args[0]);
	double p = Double.parseDouble(args[1]);
	ErdosRenyi m = new ErdosRenyi(node,p);
	m.getErdosrenyi(node, p);
	
}
}

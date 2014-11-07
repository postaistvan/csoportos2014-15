package Generatorok;

import java.util.Random;

public class ErdosRenyi {
public int Node;
public double P;
public int D;
	
public ErdosRenyi(int Node, double P,int D){
	this.Node = Node;
	this.P=P;
	this.D=D;
	
}

public int[][] getErdosrenyi() {
	int[][] matrix = new int[Node][Node];
    for (int i = 0; i < Node; i++)
        for (int j = 0; j < Node; j++){
        	if(Math.random() <=P)
        		matrix[i][j]=1;
        }
    return matrix;
}

public int[] getErdosRDefektalas(int Meret,int D){
	Random rr = new Random();
	int tomb[] = new int[Meret];
	int x;
	int mm=Meret;
	x = (int) Math.round((mm*D)/100);
	//System.out.println(x+" " +y);
	for(int i=0;i<mm;i++)
		if(i<x) 
			tomb[i]=0;
		else
			tomb[i]=1;
	
 for (int i = 0; i < mm-1; i++)
 {
	// System.out.println(rr.nextInt(mm));
	// System.out.println(i+(int)(Math.random())*mm);
	// int r = i+(int) (Math.random() * (Meret));
	 int r = rr.nextInt(mm-1);
	 int tmp = tomb[i];   
	 tomb[i] = tomb[r];
	 tomb[r] = tmp;
	    }
 return tomb;
 }
/*
public static void main(String[] args) {
	int node = Integer.parseInt(args[0]);
	double p = Double.parseDouble(args[1]);
	int D = Integer.parseInt(args[2]);
	ErdosRenyi m = new ErdosRenyi(node,p,D);
	m.getErdosrenyi(node, p);
	m.getErdosRDefektalas(node, D);
	
}
*/
}

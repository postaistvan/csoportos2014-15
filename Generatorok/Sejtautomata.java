package Generatorok;

import java.util.Random;


public class Sejtautomata {
public int Meret;
public int p;


public Sejtautomata(int Meret, int p) {
	// TODO Auto-generated constructor stub
	this.Meret= Meret;
	this.p=p;
}


public int[][] getSejtaotomata(){
	Random rr = new Random();
	int tomb[] = new int[Meret*Meret];
	int[][] matrix = new int[Meret][Meret];
	int x,j = 0;
	int mm=Meret*Meret;
	x = (int) Math.round((mm*p)/100); 
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
 int i =0;
 for (int d = 0; d < mm; d++)
 {
	
	 if(j==(Meret))
	 {	i++;j=0;
	 	matrix[i][j]=tomb[d];
	 }
	 else
		 matrix[i][j]=tomb[d];
	 j++;
	 
 }
 for ( i = 0; i < Meret; i++) {
     for (int j1 = 0; j1 < Meret; j1++) 
        System.out.print(matrix[i][j1]);
     	System.out.println();
 }
	return matrix;
	
	
}
/*
public static void main(String[] args){
	int Meret = Integer.parseInt(args[0]);
	int p = Integer.parseInt(args[1]);
	Sejtautomata sejt = new Sejtautomata(Meret, p);
	sejt.getSejtaotomata(Meret, p);
}
*/
}

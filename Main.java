import Generatorok.ErdosRenyi;
import Generatorok.Sejtautomata;
import GrafRajzolas.Rajzolas;
import SejtAutomata.draw;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=50;
		int[][] v=new Sejtautomata(n, 8).getSejtaotomata();
		
		new draw(n,v);
		
		double p = 1.0;
		int D = 50;
		ErdosRenyi m = new ErdosRenyi(n,p,D);
		v=m.getErdosrenyi();
		int[] def=m.getErdosRDefektalas(n, D);
		
		new Rajzolas(v,def);
	}

}

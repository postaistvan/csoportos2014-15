package statisztikak;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

public class TestingStatistics {

	public TestingStatistics() {
	      List<Integer> scores = new ArrayList<Integer>();
	      List<Integer> scores2 = new ArrayList<Integer>();

	      Random random = new Random();
	      int maxDataPoints = 20;
	      int maxScore = 20;
	      for (int i = 0; i < maxDataPoints ; i++) {
	          scores.add(random.nextInt(maxScore));
	          scores2.add(random.nextInt(maxScore));
	      }

	      // meghívása: csak át kell adni paraméterként a két tömböt
	      Statistics mainPanel = new Statistics(scores, scores2);

	      JFrame frame = new JFrame("Statisztikak");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().add(mainPanel);
	      frame.pack();
	      frame.setLocationByPlatform(true);
	      frame.setVisible(true);
	}

	public static void main(String[] args) {
		new TestingStatistics();
	}

}

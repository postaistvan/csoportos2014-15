package statisztikak;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

@SuppressWarnings("serial")
public class Statistics extends JPanel {
   private static final int MAX_SCORE = 20;
   private static final int PREF_W = 600;
   private static final int PREF_H = 200;
   private static final int BORDER_GAP = 10;
   private static final Color GRAPH_COLOR = Color.blue;
   private static final Color GRAPH_POINT_COLOR = new Color(0, 0, 255, 200);
   private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
   private static final Color GRAPH_COLOR2 = Color.red;
   private static final Color GRAPH_POINT_COLOR2 = new Color(255, 0, 0, 200);
   private static final Stroke GRAPH_STROKE2 = new BasicStroke(2f);
   private static final int GRAPH_POINT_WIDTH = 9;
   private static final int Y_HATCH_CNT = 5;
   private List<Integer> scores, scores2;

   public Statistics(List<Integer> scores, List<Integer> scores2) {
      this.scores = scores;
      this.scores2 = scores2;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (scores.size() - 1);
      double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (MAX_SCORE - 1);

      List<Point> graphPoints = new ArrayList<Point>();
      for (int i = 0; i < scores.size(); i++) {
         int x1 = (int) (i * xScale + BORDER_GAP);
         int y1 = (int) ((MAX_SCORE - scores.get(i)) * yScale + BORDER_GAP);
         graphPoints.add(new Point(x1, y1));
      }

      List<Point> graphPoints2 = new ArrayList<Point>();
      for (int i = 0; i < scores2.size(); i++) {
         int x1 = (int) (i * xScale + BORDER_GAP);
         int y1 = (int) ((MAX_SCORE - scores2.get(i)) * yScale + BORDER_GAP);
         graphPoints2.add(new Point(x1, y1));
      }

      
      // create x and y axes 
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

      // create hatch marks for y axis. 
      for (int i = 0; i < Y_HATCH_CNT; i++) {
         int x0 = BORDER_GAP;
         int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
         int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
         int y1 = y0;
         g2.drawLine(x0, y0, x1, y1);
      }

      // and for x axis
      for (int i = 0; i < scores.size() - 1; i++) {
         int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (scores.size() - 1) + BORDER_GAP;
         int x1 = x0;
         int y0 = getHeight() - BORDER_GAP;
         int y1 = y0 - GRAPH_POINT_WIDTH;
         g2.drawLine(x0, y0, x1, y1);
      }

      Stroke oldStroke = g2.getStroke();
      g2.setColor(GRAPH_COLOR);
      g2.setStroke(GRAPH_STROKE);
      for (int i = 0; i < graphPoints.size() - 1; i++) {
         int x1 = graphPoints.get(i).x;
         int y1 = graphPoints.get(i).y - BORDER_GAP;
         int x2 = graphPoints.get(i + 1).x;
         int y2 = graphPoints.get(i + 1).y - BORDER_GAP;
         g2.drawLine(x1, y1, x2, y2);         
      }

      g2.setStroke(oldStroke);      
      g2.setColor(GRAPH_POINT_COLOR);
      for (int i = 0; i < graphPoints.size(); i++) {
         int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
         int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2 - BORDER_GAP;
         int ovalW = GRAPH_POINT_WIDTH;
         int ovalH = GRAPH_POINT_WIDTH;
         g2.fillOval(x, y, ovalW, ovalH);
      }
      
      Stroke oldStroke2 = g2.getStroke();
      g2.setColor(GRAPH_COLOR2);
      g2.setStroke(GRAPH_STROKE2);
      for (int i = 0; i < graphPoints2.size() - 1; i++) {
         int x1 = graphPoints2.get(i).x;
         int y1 = graphPoints2.get(i).y - BORDER_GAP;
         int x2 = graphPoints2.get(i + 1).x;
         int y2 = graphPoints2.get(i + 1).y - BORDER_GAP;
         g2.drawLine(x1, y1, x2, y2);         
      }

      g2.setStroke(oldStroke2);      
      g2.setColor(GRAPH_POINT_COLOR2);
      for (int i = 0; i < graphPoints2.size(); i++) {
         int x = graphPoints2.get(i).x - GRAPH_POINT_WIDTH / 2;
         int y = graphPoints2.get(i).y - GRAPH_POINT_WIDTH / 2 - BORDER_GAP;
         int ovalW = GRAPH_POINT_WIDTH;
         int ovalH = GRAPH_POINT_WIDTH;
         g2.fillOval(x, y, ovalW, ovalH);
      }

   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}
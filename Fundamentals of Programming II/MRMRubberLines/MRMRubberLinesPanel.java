package MRMRubberLines;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MRMRubberLinesPanel extends JPanel{
	private Point point1 = null, point2 = null;
	private ArrayList<Point> list;
	
	public MRMRubberLinesPanel(){
		LineListener listener = new LineListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		list = new ArrayList<Point>();
		
		setBackground(Color.black);
		setPreferredSize(new Dimension(400,200));
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.setColor(Color.yellow);
		
		Point p1, p2;
		for(int i = 0; i < list.size(); i += 2) {
			p1 = list.get(i);
			p2 = list.get(i+1);
			page.drawLine(p1.x, p1.y, p2.x,p2.y);			
		}
		
		if(point1 != null && point2 != null)
			page.drawLine(point1.x,  point1.y,  point2.x, point2.y);
		
	}
	
	private class LineListener implements MouseListener, MouseMotionListener{
		public void mousePressed(MouseEvent event) {
			point1 = event.getPoint();
		}
		public void mouseDragged(MouseEvent event) {
			point2 = event.getPoint();
			repaint();
		}
		public void mouseReleased(MouseEvent event) {
				list.add(point1);
				list.add(point2);
		}
		
		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseMoved(MouseEvent event) {}
	}
	
}

package MRMRubberLines;
//******************************************************************************************
//MRM2DDiagonal.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
import javax.swing.JFrame;

public class MRMRubberLines {

	public static void main(String[] args) {
		JFrame frame = new JFrame("RubberLines");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new MRMRubberLinesPanel());
		
		frame.pack();
		frame.setVisible(true);

	}

}

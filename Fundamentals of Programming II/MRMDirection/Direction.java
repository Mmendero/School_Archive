package MRMDirection;

//*****************************************************************************************************************************

// Author: Antimo Di Roberto

// Section: 05

// U8-C - Modified version the Direction program(Lewis)

//*****************************************************************************************************************************
import javax.swing.JFrame;

public class Direction
{
   public static void main(String[] args)
   
   {
      JFrame frame = new JFrame("Direction");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new DirectionPanel());

      frame.pack();
      frame.setVisible(true);
   }
}

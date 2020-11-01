package MRMQuoteOptionsPanel;

//******************************************************************************************
//MRMQuoteOptionsPanel.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

import javax.swing.JFrame;

public class MRMQuoteOptions
{
//-----------------------------------------------------------------
//  Creates and presents the program frame.
//-----------------------------------------------------------------
public static void main(String[] args)
{
  JFrame frame = new JFrame("Quote Options");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  MRMQuoteOptionsPanel panel = new MRMQuoteOptionsPanel();
  frame.getContentPane().add(panel);
  frame.setLocationByPlatform(true);
  frame.setSize(300, 300);
  frame.pack();
  frame.setVisible(true);
}
}
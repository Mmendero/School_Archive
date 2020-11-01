package MRMQuoteOptionsPanel;
//******************************************************************************************
//MRMQuoteOptionsPanel.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MRMQuoteOptionsPanel extends JPanel
{
private JLabel quote;
private JRadioButton comedy, philosophy, carpentry;
private String comedyQuote, philosophyQuote, carpentryQuote;

//-----------------------------------------------------------------
//  Sets up a panel with a label and a set of radio buttons
//  that control its text.
//-----------------------------------------------------------------
	public MRMQuoteOptionsPanel()
	{
	  comedyQuote = "Take my wife, please.";
	  philosophyQuote = "I think, therefore I am.";
	  carpentryQuote = "Measure twice. Cut once.";
	
	  quote = new JLabel(comedyQuote);
	  quote.setFont(new Font("Georgia", Font.BOLD, 50));
	
	  comedy = new JRadioButton("Comedy", true);
	  philosophy = new JRadioButton("Philosophy");
	  carpentry = new JRadioButton("Carpentry");
	
	  ButtonGroup group = new ButtonGroup();
      group.add(comedy);
      group.add(philosophy);
      group.add(carpentry);
	
	  QuoteListener listener = new QuoteListener();
	  comedy.addActionListener(listener);
	  philosophy.addActionListener(listener);
	  carpentry.addActionListener(listener);
	
	  add(comedy);
	  add(philosophy);
	  add(carpentry);
	  add(quote);
	  
	  setBackground(Color.gray);
	  setPreferredSize(new Dimension(500, 500));
	}
	
	
	private class QuoteListener implements ActionListener
	{
	   //--------------------------------------------------------------
	   //  Sets the text of the label depending on which radio
	   //  button was pressed.
	   //--------------------------------------------------------------
	   public void actionPerformed(ActionEvent event)
	   {
	      Object source = event.getSource();
	
	      if (source == comedy)
	         quote.setText(comedyQuote);
	      else
	         if (source == philosophy)
	            quote.setText(philosophyQuote);
	         else
	            quote.setText(carpentryQuote);
	   }
	}
}
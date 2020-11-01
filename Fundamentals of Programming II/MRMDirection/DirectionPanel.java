package MRMDirection;
//*****************************************************************************************************************************

// Author: Matthew Mendero

// Section: 05

// U8-C - Modified version the Direction program(Lewis)

//*****************************************************************************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DirectionPanel extends JPanel
{
   private final int WIDTH = 300, HEIGHT = 200;
   private final int JUMP = 10;  // increment for image movement

   private final int IMAGE_SIZE = 31;

   private ImageIcon up, down, right, left, currentImage;
   private int x, y;
   //-----------------------------------------------------------------
   //  Constructor: Sets up this panel and loads the images.
   //-----------------------------------------------------------------
   public DirectionPanel()
   {
      addKeyListener(new DirectionListener());

      x = WIDTH / 2;
      y = HEIGHT / 2;

      up = new ImageIcon("arrowUp.gif");
      down = new ImageIcon("arrowDown.gif");
      left = new ImageIcon("arrowLeft.gif");
      right = new ImageIcon("arrowRight.gif");

      currentImage = right;

      setBackground(Color.yellow);
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      setFocusable(true);
   }
   //-----------------------------------------------------------------
   //  Draws the image in the current location.
   //-----------------------------------------------------------------
   public void paintComponent(Graphics page)
   {
      super.paintComponent(page);
      currentImage.paintIcon(this, page, x, y);
   }

   //*****************************************************************
   //  Represents the listener for keyboard activity.
   //*****************************************************************
   private class DirectionListener implements KeyListener
   {
      //--------------------------------------------------------------
      //  Responds to the user pressing arrow keys by adjusting the
      //  image and image location accordingly.
      //--------------------------------------------------------------
      public void keyPressed(KeyEvent event)
      {
         switch (event.getKeyCode())
         {
            case KeyEvent.VK_UP:
               currentImage = up;
               if(y < JUMP)
                  y=0;
               else              
                  y -= JUMP;
               break;
               
            case KeyEvent.VK_DOWN:
               currentImage = down;
               if(y + IMAGE_SIZE > HEIGHT)
                  y = HEIGHT - IMAGE_SIZE;
               else
                  y += JUMP;
               break;
               
            case KeyEvent.VK_LEFT:
               currentImage = left;
               if(x < JUMP)
                  x = 0;
               else
                  x -= JUMP;
               break;
               
            case KeyEvent.VK_RIGHT:
               currentImage = right;
               if(x + IMAGE_SIZE > WIDTH)
                  x = WIDTH-IMAGE_SIZE;
               else             
                  x += JUMP;
               break;
         }

         repaint();
      }

      //--------------------------------------------------------------
      //  Provide empty definitions for unused event methods.
      //--------------------------------------------------------------
      public void keyTyped(KeyEvent event) {}
      public void keyReleased(KeyEvent event) {}
   }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 14.10.2024
 * @author 
 */

public class ErsteGUI2 extends JFrame {
  // start attributes
  private JLabel lRafaelsRechnerWertFaktor1 = new JLabel();
  private JNumberField jNumberField1 = new JNumberField();
  private JNumberField jNumberField2 = new JNumberField();
  private JLabel lHierfaktoreingeben1 = new JLabel();
  private JLabel lHierWerteingeben1 = new JLabel();
  private JButton bLosRechne1 = new JButton();
  private JLabel lDasErgebnisist1 = new JLabel();
  private JLabel l___________1 = new JLabel();
  // end attributes
  
  public ErsteGUI2() { 
    // Frame-Init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300;
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("ErsteGUI2");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    cp.setBackground(Color.BLUE);
    // end components
    
    setVisible(true);
  } // end of public ErsteGUI2
  
  // start methods
  
  public static void main(String[] args) {
    new ErsteGUI2();
  } // end of main
  
  // end methods
} // end of class ErsteGUI2


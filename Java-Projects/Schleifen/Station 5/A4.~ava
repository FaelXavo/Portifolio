import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 15.01.2025
 * @author 
 */

public class A4 extends JFrame {
  // start attributes
  private JPanel jPanel1 = new JPanel(null, true);
    private JTextField tfdNummer = new JTextField();
    private JLabel lblNummer = new JLabel();
    private JLabel lblAntwort = new JLabel();
    private JButton btnStart = new JButton();
  // end attributes
  
  public A4() { 
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
    setTitle("A4");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jPanel1.setBounds(-2, -3, 292, 268);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    tfdNummer.setBounds(23, 41, 150, 20);
    jPanel1.add(tfdNummer);
    lblNummer.setBounds(19, 16, 156, 20);
    lblNummer.setText("Geben Sie ein Nummer ein:");
    jPanel1.add(lblNummer);
    lblAntwort.setBounds(191, 42, 70, 20);
    lblAntwort.setText("");
    jPanel1.add(lblAntwort);
    btnStart.setBounds(111, 90, 75, 25);
    btnStart.setText("Start");
    btnStart.setMargin(new Insets(2, 2, 2, 2));
    btnStart.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnStart_ActionPerformed(evt);
      }
    });
    jPanel1.add(btnStart);
    // end components
    
    setVisible(true);
  } // end of public A4
  
  // start methods
  
  public static void main(String[] args) {
    new A4();
  } // end of main
  
  public void btnStart_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    String zahl = tfdNummer.getText();
    int sizeOfZahl = zahl.length();
       int errorZeigen = 0;
       for(int i = 0; i < sizeOfZahl; i++) {
         for (int j = 0; j < i; j++) { 
           if (zahl.charAt(i) == zahl.charAt(j)) 
           {
              errorZeigen++;
           }
         }
       }
       if (errorZeigen > 0) {
         lblAntwort.setText("Nein");
       } else {
         lblAntwort.setText("Ja");
       }       
  } // end of btnStart_ActionPerformed

  // end methods
} // end of class A4


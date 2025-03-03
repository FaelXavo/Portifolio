import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 10/11/2024
 * @author  Rafael Xavier
 */

public class bruttolohn extends JFrame {
  // start attributes
  private JPanel jPanel1 = new JPanel(null, true);
    private JNumberField nfdStunden = new JNumberField();
    private JNumberField nfdLohn = new JNumberField();
    private JButton btnGO = new JButton();
    private JLabel lblMonatlicheErgebnisse = new JLabel();
    private JLabel lblJaehrlicheErgebnisse = new JLabel();
    private JLabel lblMonatenResults = new JLabel();
    private JLabel lblJahResults = new JLabel();
    private JLabel lblStundenpromonat = new JLabel();
    private JLabel lblLohn = new JLabel();
  // end attributes
  
  public bruttolohn() { 
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
    setTitle("bruttolohn");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jPanel1.setBounds(1, -3, 284, 268);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    nfdStunden.setBounds(158, 12, 75, 20);
    nfdStunden.setText("");
    jPanel1.add(nfdStunden);
    nfdLohn.setBounds(157, 42, 75, 20);
    nfdLohn.setText("");
    jPanel1.add(nfdLohn);
    btnGO.setBounds(108, 90, 75, 25);
    btnGO.setText("berechnen");
    btnGO.setMargin(new Insets(2, 2, 2, 2));
    btnGO.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnGO_ActionPerformed(evt);
      }
    });
    jPanel1.add(btnGO);
    lblMonatlicheErgebnisse.setBounds(10, 130, 110, 20);
    lblMonatlicheErgebnisse.setText("monatliche");
    jPanel1.add(lblMonatlicheErgebnisse);
    lblJaehrlicheErgebnisse.setBounds(11, 159, 110, 20);
    lblJaehrlicheErgebnisse.setText("jährliche");
    jPanel1.add(lblJaehrlicheErgebnisse);
    lblMonatenResults.setBounds(135, 130, 110, 20);
    lblMonatenResults.setText("");
    jPanel1.add(lblMonatenResults);
    lblJahResults.setBounds(130, 161, 110, 20);
    lblJahResults.setText("");
    jPanel1.add(lblJahResults);
    lblStundenpromonat.setBounds(29, 13, 112, 20);
    lblStundenpromonat.setText("Stunden pro monat");
    jPanel1.add(lblStundenpromonat);
    lblLohn.setBounds(26, 41, 110, 20);
    lblLohn.setText("Lohn");
    jPanel1.add(lblLohn);
    // end components
    
    setVisible(true);
  } // end of public bruttolohn
  
  // start methods
  
  public static void main(String[] args) {
    new bruttolohn();
  } // end of main
  
  public void btnGO_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    double stunden = nfdStunden.getDouble();
    double lohn = nfdLohn.getDouble();
    
    if (stunden > 0 && lohn > 0){
      //Hier berechnen wir wie viel geld bekkomt durchschnitliche der User am ende der Monaten
     double monatsnumber = (lohn * stunden);
     String monat = "" + monatsnumber;
      //Jetzt multiplizieren wir den Lohn mit 12, damit wir den gesamt Jahreslohn entdecken
     String jahr = "" + (monatsnumber * 12);
     lblMonatenResults.setText(monat);
     lblJahResults.setText(jahr);    
    }

    
  } // end of btnGO_ActionPerformed

  // end methods
} // end of class bruttolohn


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Description
 *
 * @version 1.0 from 10/11/2024
 * @author 
 */

public class volkshochschule extends JFrame {
  // start attributes
  private JPanel jPanel1 = new JPanel(null, true);
    private JLabel lblGesamtenstunden = new JLabel();
    private JNumberField nfdStunden = new JNumberField();
    private JLabel lblPreis = new JLabel();
    private JLabel lblResult = new JLabel();
    private JButton btnBerechnen = new JButton();
    private JLabel lPreisfuerschueler = new JLabel();
    private JLabel lblResult2 = new JLabel();
  // end attributes
  
  public volkshochschule() { 
    // Frame-Init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 294;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("volkshochschule");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jPanel1.setBounds(-1, -5, 292, 260);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    lblGesamtenstunden.setBounds(21, 14, 112, 20);
    lblGesamtenstunden.setText("Gesamten Stunden");
    jPanel1.add(lblGesamtenstunden);
    nfdStunden.setBounds(164, 15, 75, 20);
    nfdStunden.setText("");
    jPanel1.add(nfdStunden);
    lblPreis.setBounds(24, 154, 110, 20);
    lblPreis.setText("Preis: ");
    jPanel1.add(lblPreis);
    lblResult.setBounds(156, 154, 110, 20);
    lblResult.setText("");
    jPanel1.add(lblResult);
    btnBerechnen.setBounds(94, 81, 75, 25);
    btnBerechnen.setText("Berechnen");
    btnBerechnen.setMargin(new Insets(2, 2, 2, 2));
    btnBerechnen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnBerechnen_ActionPerformed(evt);
      }
    });
    jPanel1.add(btnBerechnen);
    lPreisfuerschueler.setBounds(22, 191, 110, 20);
    lPreisfuerschueler.setText("Preis f�r sch�ler");
    jPanel1.add(lPreisfuerschueler);
    lblResult2.setBounds(156, 190, 110, 20);
    lblResult2.setText("");
    jPanel1.add(lblResult2);
    // end components
    
    setVisible(true);
  } // end of public volkshochschule
  
  // start methods
  
  public static void main(String[] args) {
    new volkshochschule();
  } // end of main
  
  public void btnBerechnen_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    double gesamtstd = nfdStunden.getDouble();
    double preis = gesamtstd * 9;
    
    lblResult.setText(""+ preis);
    lblResult2.setText(""+ (preis - (preis/100 * 40)));
  } // end of btnBerechnen_ActionPerformed

  // end methods
} // end of class volkshochschule


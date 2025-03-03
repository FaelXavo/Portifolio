import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JLabel;

/**
  *
  * description
  *
  * @version 1.0 from 09.10.2024
  * @author 
  */

public class ersteGUI extends JFrame {
  // Anfang Attribute
  // start attributes
  private JLabel Titel = new JLabel();
  private JNumberField jNumberField1 = new JNumberField();
  private JNumberField jNumberField2 = new JNumberField();
  private JLabel lHierfaktoreingeben1 = new JLabel();
  private JLabel lHierWerteingeben1 = new JLabel();
  private JButton bLosRechne1 = new JButton();
  private JLabel lDasErgebnisist1 = new JLabel();
  private JLabel l = new JLabel();
  
  private JPanel jPanel1 = new JPanel(null, true);
  // end attributes
  // Ende Attribute

  public ersteGUI (String title) {
    super (title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300;
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    setTitle("GUI_Tutorial");
    cp.setBackground(new Color(0x0080FF));
    // Anfang Komponenten
    jPanel1.setBounds(0, 0, 244, 228);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    Titel.setBounds(8, 16, 196, 24);
    Titel.setText("Rafael's Rechner: Wert * Faktoren");
    jPanel1.add(Titel);
    jNumberField1.setBounds(24, 48, 80, 24);
    jPanel1.add(jNumberField1);
    jNumberField2.setBounds(160, 48, 80, 24);
    jPanel1.add(jNumberField2);
    lHierfaktoreingeben1.setBounds(152, 80, 120, 24);
    lHierfaktoreingeben1.setText("Hier faktor eingeben");
    jPanel1.add(lHierfaktoreingeben1);
    lHierWerteingeben1.setBounds(8, 80, 113, 24);
    lHierWerteingeben1.setText("Hier Wert eingeben");
    jPanel1.add(lHierWerteingeben1);
    bLosRechne1.setBounds(80, 120, 96, 24);
    bLosRechne1.setText("Los Rechne!");
    bLosRechne1.setMargin(new Insets(2, 2, 2, 2));
    bLosRechne1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLosRechne1_ActionPerformed(evt);
      }
    });
    jPanel1.add(bLosRechne1);
    lDasErgebnisist1.setBounds(32, 160, 104, 24);
    lDasErgebnisist1.setText("Das Ergebnis ist");
    jPanel1.add(lDasErgebnisist1);
    l.setBounds(141, 163, 94, 20);
    l.setText("...");
    jPanel1.add(l);
    Titel.setBounds(56, 16, 182, 24);
    // Ende Komponenten
    
    setResizable(false);
    setVisible(true);
  }
    // start components
    
    // end components
  // start methods

  // Anfang Methoden
  
  public void bLosRechne1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    l.setText("" + jNumberField1.getInt()*jNumberField2.getInt());
  } // end of bLosRechne1_ActionPerformed

  // Ende Methoden

  public static void main(String[] args) {
    new ersteGUI("ersteGUI");
  }
  // end methods
}

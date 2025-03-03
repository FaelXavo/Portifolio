import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 *
 * Description
 *
 * @version 1.0 from 11.11.2024
 * @author Rafael Xavier
 */

public class A3CHaender extends JFrame {
  // start attributes
  private JPanel jPanel1 = new JPanel(null, true);
    private JLabel lblNettopreisdesProduktes = new JLabel();
   private JLabel lblTitle = new JLabel();
   private JNumberField nfdNetto = new JNumberField();
   private JLabel lblErmaessigungssatz = new JLabel();
   private JNumberField nfdErmaessigungssatz = new JNumberField();
   private JLabel lblMehrsteuer = new JLabel();
   private JLabel lblFinalMehrsteuer = new JLabel();
   private JLabel lblGesamtpreis = new JLabel();
   private JLabel lblFinalPreis = new JLabel();
   private JButton btnBerechnen = new JButton();
  // end attributes
  
  public A3CHaender() { 
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
    setTitle("computer_haendler");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    jPanel1.setBounds(0, 0, 244, 228);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    nfdNetto.setBounds(174, 56, 75, 20);
    nfdNetto.setText("");
    jPanel1.add(nfdNetto);
    lblErmaessigungssatz.setBounds(9, 80, 110, 20);
    lblErmaessigungssatz.setText("Erm‰ﬂigungssatz: ");
    jPanel1.add(lblErmaessigungssatz);
    nfdErmaessigungssatz.setBounds(174, 80, 75, 20);
    nfdErmaessigungssatz.setText("");
    jPanel1.add(nfdErmaessigungssatz);
    lblMehrsteuer.setBounds(9, 104, 110, 20);
    lblMehrsteuer.setText("Mehrsteuer (19%): ");
    jPanel1.add(lblMehrsteuer);
    lblFinalMehrsteuer.setBounds(174, 104, 110, 20);
    lblFinalMehrsteuer.setText("");
    jPanel1.add(lblFinalMehrsteuer);
    btnBerechnen.setBounds(105, 194, 75, 25);
    btnBerechnen.setText("Berechnen");
    btnBerechnen.setMargin(new Insets(2, 2, 2, 2));
    btnBerechnen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnBerechnen_ActionPerformed(evt);
      }
    });
    jPanel1.add(btnBerechnen);
    lblGesamtpreis.setBounds(8, 127, 110, 20);
    lblGesamtpreis.setText("Gesamtpreis:");
    jPanel1.add(lblGesamtpreis);
    lblFinalPreis.setBounds(172, 128, 110, 20);
    lblFinalPreis.setText("");
    jPanel1.add(lblFinalPreis);
    lblTitle.setBounds(39, 15, 204, 20);
    lblTitle.setText("Computer Haendler Preiskalkulator");
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    jPanel1.add(lblTitle);
    lblNettopreisdesProduktes.setBounds(9, 56, 149, 20);
    lblNettopreisdesProduktes.setText("Nettopreis des Produktes");
    jPanel1.add(lblNettopreisdesProduktes);
    // end components
    
    setVisible(true);
  } // end of public A3CHaender
  
  // start methods
  
  public static void main(String[] args) {
    new A3CHaender();
  } // end of main
  
  public void btnBerechnen_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    double nettoPreis = nfdNetto.getDouble();
    double ermaessigungssatz = nfdErmaessigungssatz.getDouble();
    double nettoMitErmaessigungssatz = nettoPreis - (nettoPreis / 100 * ermaessigungssatz); 
    double mehrstuer = nettoMitErmaessigungssatz / 100 * 19;
    
    lblFinalMehrsteuer.setText("" + mehrstuer);
    lblFinalPreis.setText("" + (nettoMitErmaessigungssatz + mehrstuer));
  } // end of btnBerechnen_ActionPerformed

  // end methods
} // end of class A3CHaender


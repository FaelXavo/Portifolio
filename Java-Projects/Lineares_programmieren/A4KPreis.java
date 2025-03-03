import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;

/**
 *
 * Description
 *
 * @version 1.0 from 11.11.2024
 * @author 
 */

public class A4KPreis extends JFrame {
  // start attributes
  private JPanel jPanel1 = new JPanel(null, true);
    private JLabel lblTitel = new JLabel();
    private JLabel lblKabellaenge = new JLabel();
    private JLabel lblMeterpreis = new JLabel();
    private JLabel lblGesamtpreis20Verschnitt1 = new JLabel();
    private JLabel lblFinalpreis = new JLabel();
    private JNumberField nfdKabellaenge = new JNumberField();
    private JNumberField nfdMeterpreis = new JNumberField();
    private JButton btnBerechenn = new JButton();
  // end attributes
  
  public A4KPreis() { 
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
    setTitle("A4KPreis");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jPanel1.setBounds(-6, -5, 292, 268);
    jPanel1.setOpaque(false);
    cp.add(jPanel1);
    lblTitel.setBounds(84, 15, 122, 20);
    lblTitel.setText("Kabelpreiskalkulator");
    lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
    jPanel1.add(lblTitel);
    lblKabellaenge.setBounds(22, 53, 110, 20);
    lblKabellaenge.setText("Kabellänge: ");
    jPanel1.add(lblKabellaenge);
    lblMeterpreis.setBounds(20, 81, 110, 20);
    lblMeterpreis.setText("Meterpreis");
    jPanel1.add(lblMeterpreis);
    lblGesamtpreis20Verschnitt1.setBounds(57, 141, 195, 20);
    lblGesamtpreis20Verschnitt1.setText("Gesamtpreis + 20% Verschnitt: ");
    jPanel1.add(lblGesamtpreis20Verschnitt1);
    lblFinalpreis.setBounds(120, 166, 110, 20);
    lblFinalpreis.setText("");
    lblFinalpreis.setFont(new Font("Dialog", Font.BOLD, 15));
    jPanel1.add(lblFinalpreis);
    nfdKabellaenge.setBounds(156, 54, 75, 20);
    nfdKabellaenge.setText("");
    jPanel1.add(nfdKabellaenge);
    nfdMeterpreis.setBounds(156, 80, 75, 20);
    nfdMeterpreis.setText("");
    jPanel1.add(nfdMeterpreis);
    btnBerechenn.setBounds(96, 109, 75, 25);
    btnBerechenn.setText("Berechenn");
    btnBerechenn.setMargin(new Insets(2, 2, 2, 2));
    btnBerechenn.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnBerechenn_ActionPerformed(evt);
      }
    });
    jPanel1.add(btnBerechenn);
    // end components
    
    setVisible(true);
  } // end of public A4KPreis
  
  // start methods
  
  public static void main(String[] args) {
    new A4KPreis();
  } // end of main
  
  public void btnBerechenn_ActionPerformed(ActionEvent evt) {
    // TODO add your code here
    double kabellaenge = nfdKabellaenge.getDouble();
    double meterpreis = nfdMeterpreis.getDouble();
    
    double nettopreis = kabellaenge * meterpreis;
    double finalpreis = nettopreis + (nettopreis/100*20);
    
    DecimalFormat df = new DecimalFormat("0.##");
    lblFinalpreis.setText(""+ df.format(finalpreis));
  } // end of btnBerechenn_ActionPerformed

  // end methods
} // end of class A4KPreis


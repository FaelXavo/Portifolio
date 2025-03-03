import java.text.DecimalFormat;

class REISKORN{
    public static void main(String[] args) {
      final int REIS = 2;
      double letztenFeld = (Math.pow(REIS, 63));
      double gesamtSchachbrett = letztenFeld;
      DecimalFormat df = new DecimalFormat("###,###,###.###");
    
      for (int i = 62; i >= 0; i--) {
        gesamtSchachbrett += Math.pow(REIS, i);
      }
    
      double tonnenReis = (gesamtSchachbrett/40000000); // /40 reiskornern = 1 gramme, /tonnen = 1000kg. formatierung = reiskronern /(40 * 1000 * 1000)
    
      String stra = df.format(letztenFeld);
      String strb = df.format(gesamtSchachbrett);
      String strc = df.format(tonnenReis);
       
      System.out.println("Die Reiskornanzahl auf dem letzten Feld betraegt.: " + letztenFeld);
      System.out.println("Die Reiskorngesamtzahl betraegt..................: " + gesamtSchachbrett);
      System.out.println("Die Reiskorngesamtgewicht betraegt:..............: " + tonnenReis);
       
      System.out.println("------------------------------------------------------------------------------");
    
      System.out.println("Die Reiskornanzahl auf dem letzten Feld betraegt.: " + stra);
      System.out.println("Die Reiskorngesamtzahl betraegt..................: " + strb);
      System.out.println("Die Reiskorngesamtgewicht betraegt:..............: " + strc + " Tonnen");
            
    }
  }

/*
 *  Dieses Datei hat die Mathematische Funktionen, die bein ein andere Datei verw�ndet wird
 *
 *  @Rafael Xavier
 **/

public class RundeFormen{
  /*
   * Diese Methode berechnet die Fl�che eines Kreises mit ein r parameter (A = r� * p)
   * @parameter r geht f�r den Radius, der in der Rechnung verw�ndet wird.
   * @return die Kreisfl�che
   *
   **/
    static double kreisFlaeche(double r){
        return (Math.pow(r,2) * Math.PI);
      }

  /*
   * Diese Methode berechnet die Oberfl�che einer Kugel mit ein r parameter (A = 4 * r� * p)
   * @parameter r geht f�r den Radius, der in der Rechnung verw�ndet wird.
   * @return die Oberfl�che einer Kugel 
   *
   **/    
    static double kugelOberflaesche (double r){
        return (4 * Math.pow(r,2) * Math.PI);
      }

  /*
   * Diese Methode berechnet das Volumen einer Kugel mit ein r parameter (V = 4/3 * r� * p)
   * @parameter r geht f�r den Radius, der in der Rechnung verw�ndet wird.
   * @return das Volumen einer Kugel 
   *
   **/      
    static double kugelVolumen (double r){
        return (4/3 * Math.pow(r,3) * Math.PI);
    }
}

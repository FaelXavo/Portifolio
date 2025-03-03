/**
 * Mathematische Funktionnen schreiben
 * Hier sind einige Mathematische funktionen, die später in anderen Programmen verwendetet werden können
 * @Rafael Xavier de Queiroga 
 */
 
class MyMath{
/**
 * Power Methode
 * @params Diese Methode bekommt eine Basis und Exponent und  
 * @return Ergebniss von basis^exponent
 */
  public static double pow (double zahl, double potenz){
    double ergebniss = 1;
    for (int i = 1; i <= potenz; i++) {
      ergebniss *= zahl;
    }
    return ergebniss;
    }
/**
 * Fakultät Methode
 * @params Diese Methode bekommt eine Zahl. 
 * @return der Fakultät der Zahl (x!)
 */  
  public static int fak (int zahl){
      int ergebniss = 1;
      for (int i = 1; i <= zahl; i++) {
        ergebniss *= i;      
      }
    return ergebniss;
    }
/**
 * Square root Methode
 * @params Diese Methode bekommt eine Zahl 
 * @return Die Methode gibt die Quadratwurzel der Zahl zurück 
 */  
  public static double root(double x){
     double y = x;
     double n = 2;
     for (int i = 1 ; i<20; i++)
         y = ((n-1)*pow(y,n)+x) / (n*pow(y,n-1));
     return y;
    }
/**
 * Pythagoras Methode
 * @params Diese Methode bekommt die seiten A und B eines Dreiecks 
 * @return Der ergebniss C der Pythagoras formel a² + b² = c²  
 */  
  public static double pythagoras(double a, double b) {
    return MyMath.root((a*a)+(b*b));
  }
/**
 * Sinus Methode
 * @param Diese Methode bekommt eine Zahl x 
 * @return Der sinus von x
 */  
  public static double sin(double x){
    double sin = x;
    int thermen = 10;
    for (int i = 0; i < thermen; i++) {
        //Taylor formel
        double therm = pow(-1, i) * pow(x, 2 * i + 1) / fak(2 * i + 1);
        sin += therm;
    }
    return sin;
  }
}                    

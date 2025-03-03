import java.lang.String;
class A1_replace{
    public static void grrr(String s){
        String beispiel = s;
        final String ende_string = beispiel.replaceAll("r", "rrr");
        System.out.println(ende_string);
    }
    public static void main(String[] args) {
      grrr("rafarel");
    }
  }
  

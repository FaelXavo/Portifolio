import java.util.Scanner;
class Xavier_Rafael_OG41_RechteckRechnung{
      public static void main(String[] args) {
      Scanner scann = new Scanner(System.in);
      System.out.println("Welche Seitengröße hat das Quadrat? (Wenn ein Komma vorhanden ist, verwenden Sie ein .)");
      float SideSize = scann.nextFloat();
      float Umfang = SideSize * 4;
      float Flaecheninhalt = SideSize * SideSize;
      System.out.println("Ein Quadrat mit einer Seitenlänge von " + SideSize + " hat einen Umfang von " + Umfang +" und eine Fläche von " + Flaecheninhalt);
      }
  }

public class Principal{

  public static void main (String args[ ]){
    Fenetre f = new Fenetre('B');
    f.afficher();
    f.retailler(10,10);
    f.afficher();

    Jolie f2 = new Jolie('J');
    f2.afficher();
    f2.retailler(5,7);
    f2.afficher();
    f.afficher();
  }

}

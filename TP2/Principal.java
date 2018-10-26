public class Principal{
  public static void main(String args[]){
    int arg1, arg2;
    for (int i=0;i < args.length; i++){
      System.out.println(args[i]);
    }
    try {
      arg1=java.lang.Integer.parseInt(args[0]);
      arg2=java.lang.Integer.parseInt(args[1]);
    }
    catch ( NumberFormatException e) {
      System.out.println("Erreur : Il ne s'agit pas d'un entier !");
      arg1=250;
      arg2=250;
    }
    System.out.println(arg1);
    System.out.println(arg2);
    Fenetre maFen = new Fenetre(arg1,arg2);
  }
}

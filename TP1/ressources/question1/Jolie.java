public class Jolie extends Fenetre{

  public Jolie(char car){
    super(car);
  }

  public void afficher () {
    int i,j;
    for (i=0;i<largeur+2;i++)
       System.out.print("*");
    System.out.println();
    for (i=0;i<hauteur;i++) {
       System.out.print("*");
       for (j=0;j<largeur;j++)
          System.out.print(texte[i][j]);
       System.out.println("*");
    }
    for (i=0;i<largeur+2;i++)
       System.out.print("*");
    System.out.println();
  }

}

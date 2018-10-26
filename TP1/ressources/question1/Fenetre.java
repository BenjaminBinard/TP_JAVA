    public class Fenetre { // variables propres a l'objet fenetre

		protected int hauteurmaxi, largeurmaxi;
      protected int largeur ,hauteur;
      protected char texte[][];


   // constructeur de l'objet fenetre
       public Fenetre (char car_remplissage) {
         int i,j;
			hauteurmaxi = 3;
			largeurmaxi = 20;
         texte = new char[hauteurmaxi][largeurmaxi];
         for (i=0;i<hauteurmaxi;i++)
            for (j=0;j<largeurmaxi;j++)
               texte[i][j]=car_remplissage;
         largeur=largeurmaxi;
         hauteur=hauteurmaxi;
      }

   //Methode d'affichage d'une fenetre
       public void afficher () {
         int i,j;
         for (i=0;i<largeur+2;i++)
            System.out.print("_");
         System.out.println();
         for (i=0;i<hauteur;i++) {
            System.out.print("|");
            for (j=0;j<largeur;j++)
               System.out.print(texte[i][j]);
            System.out.println("|");
         }
         for (i=0;i<largeur+2;i++)
            System.out.print("-");
         System.out.println();
      }

   //Methode de modification de la taille d'une fenetre
       public void retailler (int hauteur,int largeur) {
         if ((hauteur<=hauteurmaxi)&& (hauteur>0))
            this.hauteur=hauteur;
         if ((largeur<=largeurmaxi)&& (largeur>0))
            this.largeur=largeur;
      }

   }

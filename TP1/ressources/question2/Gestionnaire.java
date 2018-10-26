   public class Gestionnaire {

   //Variables necessaires a cet objet
      private Fenetre tab_fen[];
      private int nbre_fenetres;
      private char remplissage;


   //Constructeur de classe
      public Gestionnaire() {
         this.nbre_fenetres = 0;
         this.remplissage = '0';
         this.tab_fen = new Fenetre[10];
      }

   //Methode demandant a l'utilisateur un caractere compris entre 2 valeurs
      public char car_cmde(char valmin,char valmax) throws java.io.IOException {
         char valeur;
         do {
            valeur = (char)System.in.read();
         } while ((valeur < valmin) || (valeur > valmax));
         return (valeur);
      }

   //Methode demandant a l'utilisateur un chiffre >=0 et < a valmaxi
      public int num_cmde(int valmaxi) throws java.io.IOException {
         int valeur;
         do {
			valeur = System.in.read() - (int)'0';
			} while ( ( valeur < 0 ) || (valeur > valmaxi));
         return (valeur);
      }

   //Methode d'affichage de toutes les fenetres existantes
      public void affichage () {
         int i;
         if (nbre_fenetres > 0)
            for (i=0;i<nbre_fenetres;i++)
               tab_fen[i].afficher();
      }

   //Methode de creation d'une fenetre supplementaire
      public void creation () {
         if (nbre_fenetres < 9){
            tab_fen[nbre_fenetres]=new Fenetre(remplissage);
            nbre_fenetres++;
            remplissage++;
         }
         else System.out.println("Vous avez cree le maximum de fenetres permis");
      }

   // Methode pour modifier la taille d'une fentre :
   // choisir la fenetre, puis reajuster sa taille
      public void modif (int nbremaxi) throws java.io.IOException {
         char commande;
         int fen;
         System.out.print("Choisir la fenetre a modifier : ( 0 < fenetre < ");
         System.out.print(nbremaxi-1);
         System.out.println (") ?");
         fen = num_cmde (nbremaxi-1);
         System.out.println("Reajustement de taille de fenetre");
         System.out.println(" A => 2 lignes de 5 caracteres");
         System.out.println(" B => 3 lignes de 10 caracteres");
         System.out.println(" C => 3 lignes de 20 caracteres");
         System.out.print("Votre choix ?");
         commande = car_cmde('A','C');
         switch (commande) {
            case 'A' : tab_fen[fen].retailler(2,5);
               break;
            case 'B' : tab_fen[fen].retailler(3,10);
               break;
            case 'C' : tab_fen[fen].retailler(3,20);
               break;
         }
      }

   //Methode activer : boucle principale du gestionnaire de fenetres
      public void activer () throws java.io.IOException {
         char commande;
         boolean fini;
         fini = false;
         while (! fini ) {
            System.out.println("Gestionnaire de fenetres");
            System.out.print("Nombre de fenetres creees :");
            System.out.println(nbre_fenetres);
            System.out.println(" A => Afficher toutes les fenetres creees");
            System.out.println(" C => Creer une nouvelle fenetre");
            System.out.println(" M => Modifier la taille d'une fenetre");
            System.out.println(" Q => Quitter le programme");
            System.out.print("Votre choix ?");
            commande = car_cmde('A','Z');
            switch (commande) {
               case 'A' : affichage();
                  break;
               case 'C' : creation();
                  break;
               case 'M' : modif(nbre_fenetres);
                  break;
               case 'Q' : fini=true;
                  break;
               default :
                  break;
            }
         }
      }
   }

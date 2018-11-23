import java.io.*;
import java.net.*;

/**
 * Classe ClientSimple
 * Cette classe permet de créer un client pour communiquer avec un serveur TCP
 * @see ServeurSimple
 * @version 1.0
 */
public class ClientSimple {

   private InetAddress hote;
   private int port;
   private Socket socket;

/**
 * Constructeur par défaut
 * Les paramétres sont initialisés "en dur"
 */
   public ClientSimple(String hote, String port) {
      //initialisations
      this.port = atoi(port);
      this.hote = null;
      this.socket = null;
      int i;
      //recuperation de l'adresse IP du serveur (votre machine)
      try {
         this.hote = InetAddress.getByName(hote);
      }
      catch (UnknownHostException e) {}

      try {
         socket = new Socket(this.hote, this.port);
         System.out.println("Connecté au serveur: " + socket.getInetAddress() + ":" + socket.getPort());
         //l'objet input contient le texte tapé sur la console
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         //l'objet output est ce qui transmis sur la socket
         PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
         String message;
      	//acquisition via le clavier d'un message et envoi au serveur
         while(true) {
            message = input.readLine();
            output.println(message);
            if (message.length() >= 4) {
              if(message.charAt(0)=='S' & message.charAt(1)=='T' & message.charAt(2)=='O' & message.charAt(3)=='P'){ // Ou bien utiliser "equals"
                output.println(message + "Arret en cours ...\n");
                System.out.println("Arret !\n");
                System.exit(1);
                socket.close();
              }
            }
         }
      }
      catch(IOException e) {}
      try {
       //fermeture de la socket
         socket.close();
      }
      catch(IOException e) {}

   }

   public int atoi(String texte){
     int i;
     int resultat;
     resultat = 1000*(texte.charAt(0)-48) + 100*(texte.charAt(1)-48) + 10*(texte.charAt(2)-48) + (texte.charAt(3)-48);
     System.out.println(resultat);
     return resultat;
   }

   public static void main( String [] args ) {
    if(args[0]!=null && args[1]!=null){
      System.out.println(args[0]+":"+args[1]);
      new ClientSimple(args[0],args[1]);
    }else{
      System.out.println("Il manque des arguments !\n");
      System.exit(1);
    }

   }

}

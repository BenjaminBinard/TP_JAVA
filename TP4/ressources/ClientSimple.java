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
   private FenetreClient maFen;

/**
 * Constructeur par défaut
 * Les paramétres sont initialisés "en dur"
 */
   public ClientSimple(String hote, String port) {
      //initialisations
      maFen = new FenetreClient(600,200);
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
         this.maFen.connecte("Connecté au serveur: " + socket.getInetAddress() + ":" + socket.getPort());
         //l'objet input contient le texte tapé sur la console
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         //l'objet output est ce qui transmis sur la socket
         PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
      	 //acquisition via la fenetre
         while(true){
           //System.out.println("dans if" + maFen.getMessage());
           if(maFen.getEnvoi()==true) {
             output.println(maFen.getMessage());
             maFen.setEnvoi(false);
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
     //ClientSimple monClient = new ClientSimple("localhost","8888");
     ClientSimple monClient = new ClientSimple("172.17.3.23","8888"); // Chez Momo
   }

}

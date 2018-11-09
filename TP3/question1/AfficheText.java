import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AfficheText extends Thread{

  private String texte;

  public AfficheText(String texte){
    super();
    this.texte=texte;
  }

  public void run(){
    for (int c=0;c<texte.length();c++){
      System.out.print(texte.charAt(c));
    }
    System.out.println();
  }

}

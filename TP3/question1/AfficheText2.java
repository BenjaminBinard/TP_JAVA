import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AfficheText2 implements Runnable{

  private String texte;
  private Thread ma_tache;

  public AfficheText2(String text){
    ma_tache=new Thread(this);
    this.texte=text;
  }

  public void start(){
    ma_tache.start();
  }

  public void run(){
    try{
      ma_tache.sleep(1000);
    }catch(InterruptedException exception){}
    for (int c=0;c<texte.length();c++){
      System.out.print(texte.charAt(c));
    }
    System.out.println();
  }

}

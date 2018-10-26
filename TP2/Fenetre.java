import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener{

  private JButton bouton;
  private JButton bouton1;
  private JButton bouton2;
  private JLabel texte;

  public Fenetre(int tailleX, int tailleY){
    super();
    this.setSize(tailleX,tailleY);
    this.setVisible(true);
    this.setTitle("Binar0S present");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.placementInterne();
  }

  public void placementInterne(){
    this.bouton = new JButton ("OK");
    this.bouton1 = new JButton ("Bouton 1");
    this.bouton2 = new JButton ("Bouton 2");
    this.texte = new JLabel ("Bonjour !");
    Container c = this.getContentPane();
    c.add(this.bouton, BorderLayout.WEST);
    c.add(this.bouton1, BorderLayout.NORTH);
    c.add(this.bouton2, BorderLayout.EAST);
    c.add(this.texte, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.bouton1) {
      System.out.println("c’est le bouton 1");
    }
    if (e.getSource() == this.bouton2) {
      System.out.println ("c’est le bouton 2");
    }
  }
}

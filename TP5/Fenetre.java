import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener{
  private JList list;
  private JButton but_dep;
  private JButton but_ret;
  private JButton but_maj;
  private JButton but_esc;

  public Fenetre(int tailleX, int tailleY){
    super();
    this.setSize(tailleX,tailleY);
    this.setVisible(true);
    this.setTitle("Gestion BDD - TP4");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.creerInterface();
  }

  public void creerInterface() {
    JLabel titre = new JLabel("Articles - quantité");
    getContentPane().add(titre, BorderLayout.NORTH);
    this.list = new JList();
    getContentPane().add(list, BorderLayout.CENTER);
    JPanel p = new JPanel();
    this.but_dep = new JButton("Dépot");
    p.add(but_dep);
    but_dep.addActionListener(this);
    this.but_ret = new JButton("Retrait");
    p.add(but_ret);
    but_ret.addActionListener(this);
    this.but_maj = new JButton("Mise à jour");
    p.add(but_maj);
    but_maj.addActionListener(this);
    this.but_esc = new JButton("Quitter");
    p.add(but_esc);
    but_esc.addActionListener(this);
    getContentPane().add(p, BorderLayout.SOUTH);
    this.pack();
  }
}

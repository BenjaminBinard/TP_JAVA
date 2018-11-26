import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Fenetre extends JFrame implements ActionListener{

  private JList list;
  private JButton but_dep;
  private JButton but_ret;
  private JButton but_esc;
  private GestionBDD maGestion;
  private int indexCour;
  private ArrayList<ElementBDD> listRaw;

  public Fenetre(int tailleX, int tailleY){
    super();
    this.creerInterface();
    this.setSize(tailleX,tailleY);
    this.setVisible(true);
    this.setTitle("Gestion BDD - TP4");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.maGestion = new GestionBDD();
    this.majList();
  }

  public void majList(){
    this.maGestion.listerArticles();
    this.listRaw = this.maGestion.getList();
    this.list.setListData(this.listRaw.toArray());
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
    this.but_esc = new JButton("Quitter");
    p.add(but_esc);
    but_esc.addActionListener(this);
    getContentPane().add(p, BorderLayout.SOUTH);
    this.pack();
  }

  public void actionPerformed(ActionEvent e) {
    String[] splitArray = null; //tableau de chaînes
    String str = this.list.getSelectedValue().toString();
    splitArray = str.split(" : ");
    this.indexCour = this.list.getSelectedIndex();
    if (e.getSource() == this.but_dep) {
      this.maGestion.deposerArticle(splitArray[0]);
      this.majList();
      this.list.setSelectedIndex(this.indexCour);
    }
    if (e.getSource() == this.but_ret) {
      this.maGestion.retirerArticle(splitArray[0]);
      this.majList();
      this.list.setSelectedIndex(this.indexCour);
    }
    if (e.getSource() == this.but_esc) {
      System.exit(0);
    }
  }

}

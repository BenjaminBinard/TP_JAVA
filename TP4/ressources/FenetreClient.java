import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreClient extends JFrame implements ActionListener{

  private JButton bouton;
  private JTextField texte;
  private JTextArea textArea;
  private String message;
  private Boolean envoi;

  public FenetreClient(int tailleX, int tailleY){
    super();
    this.setSize(tailleX,tailleY);
    this.setVisible(true);
    this.setTitle("Client - TP4");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.placementInterne();
  }

  public void placementInterne(){
    this.envoi=false;
    this.bouton = new JButton ("OK - Modifier");
    this.texte = new JTextField("mon message");
    this.textArea = new JTextArea(5,20);
    this.textArea.setEditable(false);
    Container c = this.getContentPane();
    c.add(this.bouton, BorderLayout.WEST);
    c.add(this.texte, BorderLayout.CENTER);
    c.add(this.textArea, BorderLayout.SOUTH);
    this.bouton.addActionListener(this);
  }

  public void connecte(String message){
    this.textArea.append(message+"\n");
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.bouton) {
      this.message = this.texte.getText();
      System.out.println(this.message);
      this.envoi=true;
    }
  }

  public Boolean getEnvoi(){
    return this.envoi;
  }

  public String getMessage(){
    return this.message;
  }

  public void setEnvoi(Boolean nouvBool){
    this.envoi=nouvBool;
  }

}

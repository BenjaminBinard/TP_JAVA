import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreServeur extends JFrame{

  private JTextArea textArea;

  public FenetreServeur(int tailleX, int tailleY){
    super();
    this.setSize(tailleX,tailleY);
    this.setVisible(true);
    this.setTitle("Serveur - TP4");
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.placementInterne();
  }

  public void placementInterne(){
    this.textArea = new JTextArea(5, 20);
    //JScrollPane scrollPane = new JScrollPane(textArea);
    textArea.setEditable(false);

    Container c = this.getContentPane();
    c.add(this.textArea, BorderLayout.CENTER);
  }

  public void test(){
    System.out.println("TEST");
  }

  public void maj(String message){
    this.textArea.append(message+"\n");

    //Make sure the new text is visible, even if there
    //was a selection in the text area.
    this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
  }
}

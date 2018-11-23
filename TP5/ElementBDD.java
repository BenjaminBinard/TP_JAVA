import java.io.*;
import java.net.*;

public class ElementBDD{

  private String nom;
  private int quantite;

  public ElementBDD(String nom, int quantite){
    this.nom = nom;
    this.quantite = quantite;
  }

  public String getNom(){
    return this.nom;
  }

  public void setNom(String nom){
    this.nom = nom;
  }

  public int getQuantite(){
    return this.quantite;
  }

  public void setQuantite(int quantite){
    this.quantite = quantite;
  }
  
}

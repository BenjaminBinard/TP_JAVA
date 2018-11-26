import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class GestionBDD{
  private ArrayList<ElementBDD> list;
  private String driverBDD;
  private String userBDD;
  private String mdpBDD;
  private String urlBDD;

  public GestionBDD(){
    this.list = new ArrayList<ElementBDD>();
    this.driverBDD = "com.mysql.jdbc.Driver";
    this.userBDD = "tpjava";
    this.mdpBDD = "tpjava";
    this.urlBDD = "jdbc:mysql://localhost/tpjava?autoReconnect=true&useSSL=false"; // Le nom de la bdd est en bout de cette chaine
  }

  public void imprimerElements(ArrayList<ElementBDD> list){
    int i=0;
    for(i=0;i<list.size();i++){
      System.out.println("Il y a "+list.get(i).getQuantite()+" "+list.get(i).getNom()+" disponibles.");
    }
  }

  public void listerArticles() {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      Class.forName(this.driverBDD);
      con = DriverManager.getConnection(this.urlBDD,this.userBDD, this.mdpBDD);
      st = con.createStatement();
      rs = st.executeQuery("SELECT id, nom, quantite FROM articles");
      // remise à 0 de la liste - utile pour les mises à jour
      list.clear();
      // Stocker les enregistrements dans la liste
      while(rs.next()) {
        int id = rs.getInt(1);
        String nom = new String(rs.getString(2));
        int quantite = rs.getInt(3);
        list.add(new ElementBDD(nom, quantite)); // ajout
      }
      //imprimerElements(this.list);
    }
    catch (Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
    finally {
    try {
      if(rs != null) rs.close();
      if(st != null) st.close();
      if(con != null) con.close();
    }
    catch (SQLException e) {
      }
    }
  }

  public void retirerArticle(String nomArticle) {
    mettreAjourQuantite(nomArticle,-1);
  }
  public void deposerArticle(String nomArticle) {
    mettreAjourQuantite(nomArticle,1);
  }

  public void mettreAjourQuantite(String nomArticle,int value) {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      Class.forName(this.driverBDD);
      con = DriverManager.getConnection(this.urlBDD,this.userBDD, this.mdpBDD);
      st = con.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE,
      ResultSet.CONCUR_UPDATABLE);
      rs = st.executeQuery("SELECT id, nom, quantite FROM articles");
      // modifier la quantité pour l'article nomArticle
      while(rs.next()) {
        int id = rs.getInt(1);
        String nom = rs.getString(2);
        int quantite = rs.getInt(3);
        if ( nom.equals(nomArticle) ) {
          if ( (quantite == 0) && (value == -1) ) {
            break;
          }
          rs.updateInt(3, (quantite+value));
          rs.updateRow();
          break;
        }
      }
    } catch (Exception e) {
    System.err.println("Exception: " + e.getMessage());
    }
    finally {
      try {
        if (rs != null) rs.close();
        if (st != null) st.close();
        if (con != null) con.close();
      }
      catch (SQLException e) {
      }
    }
  }

  public ArrayList<ElementBDD> getList(){
    return this.list;
  }

}

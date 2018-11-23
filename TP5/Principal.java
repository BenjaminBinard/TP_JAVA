import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal{
  public static void main(String args[]){
    GestionBDD maGestion = new GestionBDD();
    maGestion.deposerArticle("J'aime cela");
    maGestion.listerArticles();
  }
}

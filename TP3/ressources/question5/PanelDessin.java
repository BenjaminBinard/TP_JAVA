   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.event.*;

   public class PanelDessin extends JPanel implements Runnable, ChangeListener {

      private int x,y;
      private int dim;
      private boolean anim;
      private JSlider slider;
      private int vitesse;
      private String nom;
      private Thread ma_tache;

      public PanelDessin(String nom) {
         super();
         ma_tache=new Thread(this);
         this.nom = nom;
         this.dim = 80; // taille de la balle
         this.x = 100;
         this.y = dim;
         this.anim = false;
         this.vitesse = 10;
         this.slider = new JSlider(JSlider.HORIZONTAL, 0, 100, vitesse);
         this.setBorder(BorderFactory.createLineBorder(Color.black));
         this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
         JLabel sliderLabel = new JLabel("Vitesse de la balle", JLabel.CENTER);
         sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
         this.add(sliderLabel);
         this.add(slider);
         this.slider.addChangeListener(this);
      }

      public void bougeBalle() {
         if (anim) {
            y+=vitesse;
            if (y + dim > this.getHeight()) this.anim = false;
            this.repaint();
            System.out.println(nom + " : " + y);
         }

      }

      public void startAnim() {
         anim = true;
         while (y < this.getHeight() - dim - vitesse)
            bougeBalle();
         anim = false;
      }

      public void stopAnim(){
         anim = false;
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.setColor(Color.BLUE);
         g.fillOval(x,y,dim,dim);
      }

      public void start(){
        ma_tache.start();
      }

      public void run(){
        anim = true;
        while (y < this.getHeight() - dim - vitesse){
          try{
            ma_tache.sleep(40);
          }catch(InterruptedException exception){}
            bougeBalle();
        }
        anim = false;
      }

      public void stateChanged(ChangeEvent e) {
        int fps = slider.getValue();
        System.out.println("Vitesse = " + fps);
        this.vitesse=fps;
      }

   }

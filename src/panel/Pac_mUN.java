package panel;

import javax.swing.JFrame;


public class Pac_mUN extends JFrame{

   public Pac_mUN() {
        add(new movimiento());
    }
    public static void main(String[] args) {
        Pac_mUN frame=new Pac_mUN();
        frame.setTitle("TestPaintComponent");
        frame.setSize(466,560);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }                  
        
}

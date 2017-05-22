package panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class movimiento extends JPanel implements ActionListener, KeyListener{
    private Timer timer;
    private int dx,dy,secuencia,x,y,direccion;
    
    public movimiento(){               
       addKeyListener(new TAdapter());
       setFocusable(true);
       this.timer=new Timer(25,this);
       this.timer.start();
       
       //Movimiento en pantalla de pac-mUN
       this.dx=0;
       this.dy=0;
       //Es para cambiar la direccion de la imagen
       this.direccion=2;
       this.secuencia=0;
       
    }                    

    
    
        
        
    @Override
    public void paintComponent(Graphics p){
            super.paintComponent(p);
            Image pac = loadImage("pac.png");
            Image pac1 = loadImage("pacInv.png");
            
            //El pacman siempre abre y cierra la boca, no solo al presionar la tecla
           
            //if(){
                
            //}
            x+=dx;
            y+=dy;
                        
                       
            //Derecha
            if(direccion==0){p.drawImage(pac,0+x ,0+y , 40+x ,40+y , 280 , 0+(secuencia*40), 320, 40+(secuencia*40),this);}                 
            //Izquierda
            if(direccion==1){p.drawImage(pac,0+x ,0+y , 40+x ,40+y , 320 , 40+(secuencia*40), 280, 0+(secuencia*40),this);}                 
            //Abajo                                                           
            if(direccion==2){p.drawImage(pac1,0+x ,0+y , 40+x ,40+y ,  0+(secuencia*40), 280, 40+(secuencia*40), 320,this);}                 
            //if(direccion==2){p.drawImage(pac,0+x ,0+y , 35+x ,40+y , 315 ,  0+(secuencia*40), 280, 40+(secuencia*40),this);}                 
            //Arriba
            if(direccion==3){p.drawImage(pac1,0+x ,0+y , 40+x ,40+y ,40+(secuencia*40), 320, 0+(secuencia*40), 280,  this);}                 
    }
  
    
    public Image loadImage(String imageName){
        ImageIcon ii=new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
        secuencia++;
        if(this.secuencia==4){this.secuencia=0;}
    }
    
    
    public class TAdapter extends KeyAdapter {
        
        @Override
        public void keyReleased(KeyEvent e){
           
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            
            int key = e.getKeyCode();  
            
            
            //Los dy y dx en 0 es porque no puede hacer desplazamientos en diagonal 
            //Solo debe estar un delta activo
            
             if(key==KeyEvent.VK_RIGHT){
                dx=2;
                dy=0;
                direccion=0;
            }
            
            if(key== KeyEvent.VK_LEFT){
                dx=-2;                
                dy=0;
                direccion=1;
            }

            if(key==KeyEvent.VK_DOWN){
                dy=2;
                dx=0;
                direccion=2;
            }
    
            if(key== KeyEvent.VK_UP){
                dy=-2;
                dx=0;
                direccion=3;
            }
           
            
            
     }
        
} 
}

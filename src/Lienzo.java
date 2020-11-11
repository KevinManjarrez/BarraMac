import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
public class Lienzo extends Canvas implements MouseListener, MouseMotionListener {
    
    Imagen c1 = new Imagen("icono1.png",50,25,this);
    Imagen c2 = new Imagen("icono1.png",150,25,this);
    Imagen c3 = new Imagen("icono1.png",250,25,this);
    Imagen c4 = new Imagen("icono1.png",350,25,this);
    int x=50;
    int y=25;
    ArrayList<Imagen> imagenes = new ArrayList<Imagen>();
    int iconoSeleccionado =-1;
    boolean mostrarIconosCargados = false;
    //Usado para indicar que ICONOS se pintarán.
    
    BarraMac puntero;
    /*boolean mostrarFB=true;
    boolean mostrarIT=true;
    boolean mostrarWA=true;
    boolean mostrarAmazon=true;*/
    //Imagen punteroIcono = null; //Se genera un objeto puntero que puede referenciar a cualquier icono.
    
    
    
    
    public Lienzo(BarraMac p){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        puntero = p;
      
    }
    
    public void cargarImagenes(){
        try{
        puntero.nombreIconos = puntero.nombreIconos.replaceAll(" ", "");
        String[] nombreArchivos = puntero.nombreIconos.split(",");
        int distanciaX = 50;
        imagenes  = new ArrayList<Imagen>();
            for (int i = 0; i < nombreArchivos.length; i++) {
                imagenes.add(new Imagen(nombreArchivos[i],distanciaX,25,this));
                distanciaX+=100;
            }
            mostrarIconosCargados=true; 
        }catch(Exception e){
            showMessageDialog(this, "El nombre de la imagene es incorrecto.");
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D)g;
        
        
        g2.setColor(new Color(255,255,255,140));
        g2.fillRoundRect(10,10,470,120,45,45);
        
        /*if(mostrarFB){
        g2.drawImage(c1.imagen, c1.x, c1.y,this);
        }
        
        if(mostrarIT){
        g2.drawImage(c2.imagen, c2.x, c2.y,this);
        }
        
        if(mostrarWA){
        g2.drawImage(c3.imagen, c3.x, c3.y,this);
        }
        
        if(mostrarAmazon){
        g2.drawImage(c4.imagen, c4.x, c4.y,this);
        }*/
        
        
    
        if(mostrarIconosCargados){
             for (int i = 0; i < imagenes.size(); i++) {
                Imagen temp = imagenes.get(i);
                g2.drawImage(temp.imagen,temp.x,temp.y, this);
            }//for.
        }else{
            g2.drawImage(c1.imagen, c1.x, c1.y,this);
            g2.drawImage(c2.imagen, c2.x, c2.y,this);
            g2.drawImage(c3.imagen, c3.x, c3.y,this);
            g2.drawImage(c4.imagen, c4.x, c4.y,this);
        }//else.
    }//paint.
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*iconoSeleccionado=0;
        
        
        if(c1.estaEnArea(e.getX(),e.getY())==true){
        //JOptionPane.showMessageDialog(this, "Diste clic a Facebook");
        //punteroIcono = c1;//PunteroIcono y C1 son el MISMO. Ya qu está dirigidos en el mismo segmento de memoria.
        iconoSeleccionado=0;
        }
        if(c2.estaEnArea(e.getX(),e.getY())==true){
        //JOptionPane.showMessageDialog(this, "Diste clic a iTunes");
        //punteroIcono = c2;
        iconoSeleccionado=1;
        }
        if(c3.estaEnArea(e.getX(),e.getY())==true){
        //JOptionPane.showMessageDialog(this, "Diste clic a whatsapp");
        //punteroIcono = c3;
        iconoSeleccionado=2;
        }
        if(c4.estaEnArea(e.getX(),e.getY())==true){
        //JOptionPane.showMessageDialog(this, "Diste clic a amazon");
        //punteroIcono = c4;
        iconoSeleccionado=3;
        }*/
             for (int i = 0; i < imagenes.size(); i++) {
                Imagen temp = imagenes.get(i);
                if(temp.estaEnArea(e.getX(), e.getY())==true){
                    iconoSeleccionado = i;
                }
            }//for.
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //punteroIcono = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
   public void mouseDragged(MouseEvent e) {
       /*if(punteroIcono!=null){
       punteroIcono.mover(e.getX(),e.getY());
       if(punteroIcono==c1){
       
       if(punteroIcono.colision(c2)){
       mostrarIT=false;
       }
       //Si puntero esta movimiento a facebook
       if(punteroIcono.colision(c3)){
       mostrarWA=false;
       }
       
       if(punteroIcono.colision(c4)){
       mostrarAmazon=false;
       }
       }
       
       
       if(punteroIcono==c2){
       
       if(punteroIcono.colision(c1)){
       mostrarFB=false;
       }
       
       }
       repaint();
       }*/
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        /*       c1.y=25;
        c2.y=25;
        c3.y=25;
        c4.y=25;
        
        if(c1.estaEnArea(e.getX(), e.getY())==true){
        c1.y=20;
        }
        
        if(c2.estaEnArea(e.getX(), e.getY())==true){
        c2.y=20;
        }
        
        if(c3.estaEnArea(e.getX(), e.getY())==true){
        c3.y=20;
        }
        
        if(c4.estaEnArea(e.getX(), e.getY())==true){
        c4.y=20;
        }*/
        for (int i = 0; i < imagenes.size(); i++) {
                Imagen temp = imagenes.get(i);
                if(temp.estaEnArea(e.getX(), e.getY())==true){
                    temp.y = 20;
                }else{
                    temp.y = 25;
                }
            }//for.
        repaint();
    }
    
}

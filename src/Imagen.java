import java.awt.Image;
import javax.swing.ImageIcon;
public class Imagen {
    int x,y;
    Image imagen;
    int ancho,alto;
    public Imagen(String nombreImagen, int posX, int posY, Lienzo puntero){
        x = posX;
        y = posY;
        imagen = new ImageIcon(puntero.getClass().getResource("/"+nombreImagen)).getImage();
        ancho = imagen.getWidth(puntero);
        alto = imagen.getHeight(puntero);
        
    }
    public boolean estaEnArea(int posXRaton, int posYRaton){
        int x2 = x + ancho;
        int y2 = y + alto;
        if(posXRaton>=x&&posXRaton<=x2){
            if(posYRaton>=y&&posYRaton<=y2){
                return true;
            }
        }
        
        return false;
    }
    
    public void mover(int posXRaton, int posYRaton){
        x=posXRaton - ancho/2;
        y=posYRaton - alto/2;
    } 
    
    public boolean colision (Imagen objetoA){
        /*
            1 = x2, y
            2 = x, y2
            3 = x, y
            4 = x2, y2
        
        */
        int X2ObjetoA = objetoA.x + objetoA.ancho;
        int Y2ObjetoA = objetoA.y + objetoA.alto;
        if(estaEnArea(X2ObjetoA, objetoA.y)){
            return true;
        }
        
        if(estaEnArea(objetoA.x, Y2ObjetoA)){
            return true;
        }
        
        if(estaEnArea(objetoA.x, objetoA.y)){
            return true;
        }
        
        if(estaEnArea(X2ObjetoA, Y2ObjetoA)){
            return true;
        }
        return false;
    }
    
    
}

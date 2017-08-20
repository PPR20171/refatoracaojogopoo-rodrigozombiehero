import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * classe Municao herda de ator é o projétil de arma de fogo
 */
public class Municao extends Actor
{
    GreenfootImage image;
    private int direcao; 
    
    public void addedToWorld(World world){
       image= new GreenfootImage("bala.png");
       image.scale((int)(image.getWidth()/18),(int)(image.getHeight()/8));
       setImage(image);
        
       List lista = getWorldOfType(ScrollWorld.class).getObjects(Protagonista.class);
       Protagonista prot =( Protagonista) lista.get(0);
         
       direcao+=(50*prot.getDirecao());
    }
    
    
    /**
     * act método que é responsável por deslocar a direção do projétil de acordo com o
     * lado do protagonista
     */
    public void act() 
    {
         
         
         setLocation(getX()+direcao,getY());
         
         if(this.isAtEdge()){
            getWorld().removeObject(this);
         }
        
    }    
}

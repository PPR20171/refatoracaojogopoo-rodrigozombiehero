import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Espada herda da classe Armas, representa a espada utilizada pelo protagonista.
 */
public class Espada extends Armas
{
    private boolean cortar=false;
    
    /**
     * método responsável por adicionar a espada ao cenário
     */
    public void addedToWorld(World world){
        GreenfootImage image = new GreenfootImage("atores/armas/espada.png");
        setImage(image);
    }
    
    /**
     * construtor da classe.
     */
    public Espada(){        
        super("Espada",5);    
    }
    
    /**
     * método responsável por configurar o atributo cortar.
     */
    public void setCortar(boolean cortar){
        this.cortar=cortar;
    }
    
    /**
     * método responsável por retornar o atributo cortar.
     */
    public boolean getCortar(){
        return this.cortar;
    }    
}

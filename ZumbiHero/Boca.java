import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boca classe herda de Armas, representa a arma do zumbi_1.
 */
public class Boca extends Armas
{
    private boolean morder=false;
    
    /**
     * método responsável por adicionar a boca ao cenário.
     */
    public void addedToWorld(World wolrd){
        GreenfootImage image = new GreenfootImage(20,10);
        image.setColor(Color.RED);
        image.fillRect(0,0,20,10);
        setImage(image);
    }
    
    /**
     * construtor de classe
     */
    public Boca(){
        super("boca",2);
    }
    
    /**
     * método responsável por configurar o atributo morder.
     */
    public void setMorder(boolean morder){
        this.morder=morder;
    }
    
    /**
     * método responsável por retornar o atributo morder.
     */
    public boolean getMorder(){
        return this.morder;
    }
       
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * PorreteDoShrekZumbi herda da classe Armas, representa a arma do ShrekZumbi.
 */
public class PorreteDoShrekZumbi extends Armas
{
    private boolean bater=false;
    
    /**
     * construtor da classe.
     */
    public PorreteDoShrekZumbi(){
        super("Porrete",20,"porretada.mp3");
    }
 
    /**
     * método responsável por configurar o atributo bater (com o porrete).
     */
    public void setBater(boolean bater){
        this.bater=bater;
    }
    
    /**
     * método responsável por retornar o atributo bater (com o porrete).
     */
    public boolean getBater(){
        return this.bater;
    }    
}

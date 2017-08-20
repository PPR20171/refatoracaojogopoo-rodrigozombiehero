import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BracoDoAndroidZumbi herda da classe Armas, representa a arma do AndroidZumbi.
 */
public class BracoDoAndroidZumbi extends Armas
{
    private boolean bater;
    /**
     * construtor da classe.
     */
    public BracoDoAndroidZumbi(){
        super("BracoDoAndroid",30,"socoDoAndroid.mp3");
        this.bater=false;
    }
    
    /**
     * método responsável por configurar o atributo bater.
     */
    public void setBater(boolean bater){
        this.bater=bater;
    }
    
    /**
     * método responsável por retornar o atributo bater.
     */
    public boolean getBater(){
        return this.bater;
    }
}

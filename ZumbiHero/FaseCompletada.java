import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * FaseCompletada herda de Actor, representa 
 */
public class FaseCompletada extends Actor{
    private Sprites sprite; 
    private boolean completou=false;
    /**
     * método responsável por adicionar a seta indicativa de final de fase no fim de cada cenário .
     */
    public void addedToWorld(World world){        
        for(int i=0;i<6;i++){
            sprite.inserir(new GreenfootImage("faseCompleta/"+(i+1)+".png"));
        }        
        setImage("faseCompleta/1.png");    
    }
    
    /**
     * construtor de classe.
     */
    public FaseCompletada(){
        sprite=new Sprites();
    }
    
    /**
     * método responsável pela verificação se o protagonista chegou no final da fase.
     */
    public void act(){      
        imprimirSprite(getSprite());
        List lista = getNeighbours(30,true,Protagonista.class); 
         if(lista.size()>0){
             Protagonista prot=(Protagonista)lista.get(0);
             setCompletou(true);
        }        
    }    
    
    /**
     * método responsável por retornar imagens do final de fase.
     */
    public GreenfootImage getSprite(){
        return sprite.imprimir();
    }
    
    /**
     * método responsável por colocar a imagem da seta final do cenário na tela.
     */
    public void imprimirSprite(GreenfootImage imagem){
        setImage(imagem);
    }
    
    /**
     * método responsável para configurar o atributo completou.
     */
    public void setCompletou(boolean comp){
        this.completou=comp;
    }
    
    /**
     * método responsável pelo retorno do atribulo completou.
     */
    public boolean getCompletou(){
        return this.completou;
    }
}

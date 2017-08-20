import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * FaiscaDeTiro herda da classe Actor, representa a pequena chama que sai do cano da arma quando o disparo é realizado.
 */
public class FaiscaDeTiro extends Actor
{
    private int direcao;
    
    /**
     * método responsável por adicionar ao cenário a faisca.
     */
    public void addedToWorld(World world){
        
        if(getDirecao()<0)setImage("atores/armas/8.png");
        if(getDirecao()>0)setImage("atores/armas/3.png");
    } 
    
    /**
     * método responsável pela interação da faísca no cenário
     */ 
    public void act(){
        removeFaisca();      
    }    
    
    
    /**
     * método responsável por remover a faisca do cenário após o disparo efetuado.
     */
    public void removeFaisca(){
        List lista=getWorldOfType(ScrollWorld.class).getObjects(FaiscaDeTiro.class);
        if(lista.size()>0){
            FaiscaDeTiro faisca=(FaiscaDeTiro)lista.get(0); 
            getWorldOfType(ScrollWorld.class).removeObject(faisca);
        }
    }
    
    /**
     * método responsável em saber a direção que a faísca vai ser gerada em relação ao protagonista
     */
    private int getDirecao(){
        List lista = getWorldOfType(ScrollWorld.class).getObjects(Protagonista.class);
        if(lista.size()>0){
            Protagonista prot = (Protagonista)lista.get(0);
            return prot.getDirecao();
        }       
        return 0;
    }
}
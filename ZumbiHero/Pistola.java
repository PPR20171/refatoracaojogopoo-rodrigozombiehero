import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Pistola herda da classe ArmasDeFogo, representa a arma de fogo que tem menor dano.
 */
public class Pistola extends ArmasDeFogo{
    GreenfootImage image;

    /**
     * método responsável por adicionar ao cenário a pistola.
     */
    public void addedToWorld(World MyWorld){
        image = new GreenfootImage("atores/armas/a/6.png");
        setImage(image);
    }
    
    /**
     * construtor da classe.
     */
    public Pistola(){
        super("Pistola",10,12,3,3,"tiroPistola.mp3");
       
    }
    
    /**
     * método responsável pelo funcionamento da pistola.
     */
    public void act(){
         incrementaTempoTiro();
         getSom().ativar();
    }
    
    /**
     * método sobrescrito da Classe ArmasDeFogo, responsável pela ação de disparo da arma de fogo e pela animação com relação ao cenário.
     * Retorno 1 indica disparo foi realizado; retorno -1 indica que nao foi disparado, porém tem ainda tem munição na arma; retorno 0 indicar que não foi 
     * feito por falta de munição.
     */
    public int disparo(){
     
        if (getTempoTiro() >= getTempoRecarga()) {
            zeraTempoTiro();
            if(getDisparos()>0){                
                   List lista = getWorldOfType(ScrollWorld.class).getObjects(Protagonista.class);
                   Protagonista prot = (Protagonista) lista.get(0);
                   getWorldOfType(ScrollWorld.class).addObject(new Municao(),prot.getX()+(47*prot.getDirecao()),prot.getY()-28,true);
                   getWorldOfType(ScrollWorld.class).addObject(new FaiscaDeTiro(),prot.getX()+(44*prot.getDirecao()),prot.getY()-29,true);
                   getSom().stop();
                   getSom().play();
                   this.disparar();
                   return 1;                   
            }            
        }else{
            return -1;
        }
        return 0;     
    }   
}

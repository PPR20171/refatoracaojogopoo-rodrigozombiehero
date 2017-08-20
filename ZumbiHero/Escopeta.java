import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Escopeta herda da classe ArmasDeFogo, representa a arma de fogo que tem maior dano.
 */

public class Escopeta extends ArmasDeFogo
{
    /**
     * método responsável por adicionar ao cenário a pistola.
     */
    public void addedToWorld(World world){
        GreenfootImage image = new GreenfootImage("atores/armas/a/1.png");
        setImage(image);
    }
    
    /**
     * método responsável pelo funcionamento da escopeta.
     */
    public void act(){
        incrementaTempoTiro();
        getSom().ativar();
    }
    
    /**
     * construtor da classe.
     */
    public Escopeta(){
        super("Escopeta",20,4,5,7,"tiroEspingardaCortado.mp3");
  
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
                   getWorldOfType(ScrollWorld.class).addObject(new Municao(),prot.getX()+(52*prot.getDirecao()),prot.getY()-22,true);
                   Integer direcao=0;
                   if(prot.getDirecao()>0)direcao=51*getDirecao();
                   if(prot.getDirecao()<0)direcao=45*getDirecao();
                   getWorldOfType(ScrollWorld.class).addObject(new FaiscaDeTiro(),prot.getX()+direcao,prot.getY()-21,true);
                   direcao=null;
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

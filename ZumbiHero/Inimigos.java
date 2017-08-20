import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * classe Inimigos herda de Personagem é a classe responsável pela implementação dos
 * personagens inimigos, os zumbis.
 */
public abstract class Inimigos extends Personagem
{
    
    /**
    * Construtor de Inimigos chama o construtor de Personagens
    */   
    Inimigos(String nome){
        super(nome);
    }   
 
    /**
    * método responsável por diminuir a vida do inimigo.
    */
    public void decrementarVida(int num){
           if(isVivo()){
              BarraLoading[] barra=getVida();
              barra[0].decrementar(num);
              if(isVivo()){
                 recriarBarra();
              }
        
           }
       
    }
 
    /**
     * método responsável por fazer o inimigos andar pelo cenário.
     */
    public void andar(GreenfootImage imagem,int direcao){
        setImage(imagem);
        List lista = getNeighbours(30,true,Inimigos.class);
        if(lista.size()>0){     
           for(int i=0;i<lista.size();i++){
              Inimigos inimigo=(Inimigos)lista.get(i); 
              if(inimigo.isVivo()){
                 if(getX()<inimigo.getX()){
                    if(direcao>0){
                       direcao=0;
                    }
                 }else{
                    if(direcao<0){
                        direcao=0;
                    }
                 }
              }
           }
        }  
    
     
        setLocation(getX()+direcao,getY());
        setAtacar(false);
    }
  
    /**
     * método responsável por criar novamente a barra de vida do inimigo.
     */
    public void recriarBarra(){   
       BarraLoading[] barra=getVida();
       getWorldOfType(ScrollWorld.class).addObject(barra[1],getX(),getY(),true);
       getWorldOfType(ScrollWorld.class).addObject(barra[0],getX(),getY(),true);
    }
  
    /**
     * método responsável por remover do cenário barra de vida do inimigo.
     */
    public void apagarBarraDeVida(){
       BarraLoading[] barra=getVida();   
       removerPersonagem(barra[0]);
       removerPersonagem(barra[1]);
    }
 
    /**
     * método responsável por verificar se o inimigoo está colidindo com o protagonista,
     * retornando um booleando.
     */
    public boolean detectarColisao(int raio){
        if(isVivo()){
            List lista = getNeighbours(raio,true,Protagonista.class);
            for(int i=0;i<lista.size();i++){
               if(lista.get(i) instanceof Protagonista){
                  return true;
               }
            }
        }
    return false;
    }
    /**
    * método responsável por verificar se o inimigo está perseguindo o protagonista, retornando
    * um booleano.
    */ 
    public boolean perseguirProtagonista(int raio){
        if(isVivo()){  
            List lista = getObjectsInRange(raio,Protagonista.class);
            Protagonista protagonista;
            if(lista.size()>0){
                return true;
            }
        }
        return false;
    }

    /**
     * método responsável por verificar se o inimigo está sofrendo lesão, retornando um booleano.
     */
    public boolean sofrerLesao(){
        if(isVivo()){   
            List listaDisparo = getNeighbours(50,true,Municao.class);
            Municao disparo;
            if(listaDisparo.size()>0){
                for(int i=0;i<listaDisparo.size();i++){     
                    if(listaDisparo.size()>0){
                        disparo=(Municao)listaDisparo.get(i);
                        getWorldOfType(ScrollWorld.class).removeObject(disparo);
                        return true;
                    }     
                }
            }   
            List listaDeArmas = getNeighbours(50,true,Protagonista.class);
            Protagonista protagonista; 
            if(listaDeArmas.size()>0){
                protagonista =(Protagonista)listaDeArmas.get(0);
                if(protagonista.getArma() instanceof Espada){
                    Espada espada=(Espada)protagonista.getArma();
                    if(espada.getCortar()){
                        espada.setCortar(false);
                        return true;
                    }        
                }
            }
        }
        return false;
    }

    /**
     * método responsável por fazer o inimigo morrer e remover o inimigo do cenário.
     */
    public void morrer(GreenfootImage image){
        setImage(image); 
        apagarPersonagem(3);
        if(!isVisivel()){
            List lista =getWorldOfType(ScrollWorld.class).getObjects(Protagonista.class);
            Protagonista prot;
            if(lista.size()>0){
                prot=(Protagonista)lista.get(0);
                prot.obterRecompensa(getNome());
            }
            removerPersonagem(this);
        }
    }

    /**
     * método sobrescrito da classe Personagem.Funciona da mesma forma: -1 para esquerda e 1 para
     * direita
     */
    public int getDirecao(){
        List lista = getWorldOfType(ScrollWorld.class).getObjects(Protagonista.class); 
        Protagonista prot;
        if(lista.size()>0 && this.isVivo()){
            prot =(Protagonista) lista.get(0);
            if(getX()>prot.getX()){
                setDirecao(-1);
            }else{
                setDirecao(1);
            }
        }
        return super.getDirecao();
    } 

    /**
     * método responsável por detectar a colisão entre inimigos. Retornando um booleano.
     */
    public boolean colisaoComPersonagemDestaClasse(){
        List lista = getNeighbours(30,true,Inimigos.class);
        if(lista.size()>0){
            return true;
        }
        return false;
    }
 
}

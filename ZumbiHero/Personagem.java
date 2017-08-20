import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Map;
/**
 * Personagem herda de Actor, classe abstrata que representa todos os personagens do jogo
 */
public abstract class Personagem extends Actor
{
    private String nome; //nome do personagem
    private int transparencia=255,direcao; //transparencia do personagem, direcao que ele anda
    private BarraLoading[] vida=new BarraLoading[2];//vetor de duas posições responsável pela barra de vida
    private boolean atacar=false;

    /**
    * construtor de Personagem que dá nome ao personagem.
    */
    public Personagem(String nome){
       this.nome=nome;
    }
 
    /**
    * método responsável pela interação do personagem junto ao cenário que o faz
    * se mover para esquerda ou direita, pressionando as teclas "a" e "d" respectivamente
    * para o protagonista(os inimigos se movem automaticamente).
    */
    public void andar(GreenfootImage images,int direcao){ 
        if(isVivo()){
           setImage(images);       
           setLocation(getX()+direcao,getY());
           setAtacar(false);
        }
    }
    /**
    * método responsável por parar a movimentação dos personagens.
    */
    public void fiqueParado(GreenfootImage images){
        if(isVivo()){
           setImage(images);
           setAtacar(false); 
        }
    }
  
    /**
    * método responsável pela morte dos personagens e assim que morre, os personagens 
    * são apagados dos cenários.
    */
    public void morrer(GreenfootImage image){
        setImage(image); 
        if(this instanceof Inimigos){
           apagarPersonagem(3);
        }
    }
   
     /**
     * método que configura o nome dos personagens. 
     */
     public void setNome(String nome){
         this.nome=nome;
     }
   
     /**
      * método que retorna(String) o nome dos personagens
      */
     public String getNome(){
         return this.nome;
     }
 
     /**
     * método abstrato responsável por diminuir a vida do personagem.
     */
     public abstract void decrementarVida(int num);
 
     /**
     * método responsável por criar a barra de vida do personagem(de dois tipos, uma 
     * branca e outra vermelha), na mesma posição, tamanho e comprimento. 
     */
     public void setVida(BarraLoading vida,int positionX,int positionY){
         this.vida[0]=vida;
         this.vida[1]=new BarraLoading(Color.WHITE,this.vida[0].getComprimento(),this.vida[0].getAltura(),this.vida[0].getWidth(),this.vida[0].getHeight()); 
         getWorldOfType(ScrollWorld.class).addObject(this.vida[1],positionX,positionY,false);
         getWorldOfType(ScrollWorld.class).addObject(this.vida[0],positionX,positionY,false);  
     }
    
     /**
      * método que retorna(vetor Barraloading) a barra de vida dos personagens.
      */
     public BarraLoading[] getVida(){
          return this.vida;
     }
     
     /**
     * método responsável por fazer a interação dos personagens com o movimento de ataque.
     */   
     public void atacar(GreenfootImage image){
            setImage(image);
           setAtacar(true);
    }
  
    /**
    * método responsável por diminuir a transparência do personagem de 255 até 0.
    */
    public void apagarPersonagem(int num){
        transparencia-=num;
        if((transparencia-num)>=0){
            getImage().setTransparency(transparencia);
        }else{
            getImage().setTransparency(0);
        } 
    }
     
    /**
    * método responsável por verificar se o personagem ainda está visível. Retorna
    * um booleano.
    */   
    public boolean isVisivel(){       
        if(getImage().getTransparency()>0){
            return true;
        }
        return false;
    }
     
    /**
    * método responsável por remover o personagem do cenário se ele estiver.
    * Recebe como parâmetro um ator do tipo Actor
    */   
    public void removerPersonagem(Actor ator){       
        if(ator!=null){
            getWorldOfType(ScrollWorld.class).removeObject(ator);
        }           
    }
 
    /**
    * método responsável por verificar se o personagem está morto ou não. Retorna um
    * booleano.
    */
    public boolean isMorto(){       
        if(getVida()!=null){
            BarraLoading[] barra=getVida(); 
            if(barra[0].getTamanho()<=0){
                return true;
            }       
        }
        return false;
    }
    
    /**
    * método responsável por verificar se o personagem está vivo ou não. Retorna um
    * booleano.
    */
    public boolean isVivo(){
       
        if(getVida()!=null){
           BarraLoading[] barra=getVida(); 
           if(barra[0].getTamanho()>0){
               return true;
           }
        }
        return false;
    }
    
     /**
     * método responsável por realizar o ataque.
     */    
     public void setAtacar(boolean ataque){
        this.atacar=ataque;
     }
    
     /**
     * método responsáel por retornar(booleano)se o personagem está atacando
     */
     public boolean getAtacar(){
         return atacar;
     }
    
     /**
     * método responsável por configurar a atual direção dos personagens. Para dizer qual
     * direção está é: -1 esquerdo; 1 para direita.
     */
     public void setDirecao(int direcao){
        this.direcao=direcao;
     }
    
     /**
     * método responsável por retornar(int)a direção do personagem. 1 para direita e -1
     * para a esquerda.
     */
     public int getDirecao(){
        return direcao;
     }
    
  
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Zumbi_1 herda da classe Inimigos, representa o zumbi menor e mais fraco.
 */
public class Zumbi_1 extends Inimigos
{
    private Sprites imgIdleRight;
    private Sprites imgIdleLeft;
    private Sprites imgRunRight;
    private Sprites imgRunLeft;
    private Sprites imgWalkingRight;
    private Sprites imgWalkingLeft ;
    private Sprites imgAttackRight;
    private Sprites imgAttackLeft;
    private Sprites imgDead ;
    
    private Boca boca=null;
    
    /**
     * método responsável por adicionar o zumbi_1 ao cenário.
     */
    public void addedToWorld(World world){        
        for(int i=0;i<4;i++){
            imgIdleRight.inserir(new GreenfootImage("atores/zumbis/zumbi_1/idle/right/"+(i+1)+".png"));
            imgIdleLeft.inserir(new GreenfootImage("atores/zumbis/zumbi_1/idle/left/"+(i+1)+".png"));
        }
        for(int i=0;i<10;i++){
            imgRunRight.inserir(new GreenfootImage("atores/zumbis/zumbi_1/run/right/"+(i+1)+".png"));
            imgRunLeft.inserir(new GreenfootImage("atores/zumbis/zumbi_1/run/left/"+(i+1)+".png"));   
        }        
        for(int i=0;i<6;i++){
            imgWalkingRight.inserir(new GreenfootImage("atores/zumbis/zumbi_1/walking/right/"+(i+1)+".png"));
            imgWalkingLeft.inserir(new GreenfootImage("atores/zumbis/zumbi_1/walking/left/"+(i+1)+".png"));
        }        
        for(int i=0;i<8;i++){
            imgDead.inserir(new GreenfootImage("atores/zumbis/zumbi_1/dead/right/"+(i+1)+".png"));
        }        
        for(int i=0;i<6;i++){
            imgAttackRight.inserir(new GreenfootImage("atores/zumbis/zumbi_1/attack/right/"+(i+1)+".png"));
            imgAttackLeft.inserir(new GreenfootImage("atores/zumbis/zumbi_1/attack/left/"+(i+1)+".png"));
        }
     
        setImage(new GreenfootImage("atores/zumbis/zumbi_1/idle/right/1.png"));
        setVida(new BarraLoading(Color.RED,40,4,40,4),getX(),getY());
        apagarBarraDeVida();
    }

    /**
     * construtor da classe.
     */
    public Zumbi_1(){
       super("Zumbi_1");
        
       boca = new Boca();
       
       this.imgIdleRight= new Sprites();
       this.imgIdleLeft= new Sprites();
       this.imgRunRight= new Sprites();
       this.imgRunLeft= new Sprites();
       this.imgWalkingRight= new Sprites();
       this.imgWalkingLeft = new Sprites();
       this.imgAttackRight= new Sprites();
       this.imgAttackLeft= new Sprites();
       this.imgDead = new Sprites();
    }
    
   /**
   * método responsável por chamar as ações do zumbi enquanto estiver vivo.
   */
   public void act(){    
      if(isVivo()){
            boolean colidiu=detectarColisao(40);           
            this.boca.setMorder(false);
            if(getDirecao()>0 && colidiu){
                 atacar((getImgAttackRight())); 
                 this.boca.setMorder(true);
            }else if( getDirecao()<0 && colidiu){
                 atacar(getImgAttackLeft());
                 this.boca.setMorder(true);
            }            
            if(!colidiu){                
                if(getDirecao()>0 && perseguirProtagonista(1000)){
                 andar(getImgWalkingRight(),8*getDirecao());                
                }else if(getDirecao()<0 && perseguirProtagonista(1000)){
                  andar(getImgWalkingLeft(),8*getDirecao());                 
                }else{
                    fiqueParado(getImgIdleRight());
                }            
            }
            apagarBarraDeVida();
            if(sofrerLesao()){
                List lista = getWorldOfType(ScrollWorld.class).getObjects(Protagonista.class);
                Protagonista prot = (Protagonista) lista.get(0);
                decrementarVida(prot.getArma().getIntensidade());
            }       
      }      
      if(isMorto()){
          imgDead.setLoop(false);
          morrer(getImgDead());  
      }      
   }
     
   /**
   * método responsável por retorna a imagem do ataque do zumbi_1 para o lado direito.
   */
   public GreenfootImage getImgAttackRight(){
       setDirecao(1);  
       return this.imgAttackRight.imprimir();
   }
   
   /**
   * método responsável por retorna a imagem do ataque do zumbi_1 para o lado esquerdo.
   */
   public GreenfootImage getImgAttackLeft(){
       setDirecao(-1);
       return this.imgAttackLeft.imprimir();
   }
     
   /**
   * método responsável por retorna a imagem do zumbi_1 andando para o lado direito.
   */
   public GreenfootImage getImgWalkingRight(){
        setDirecao(1);  
        return this.imgWalkingRight.imprimir();
   }
     
   /**
   * método responsável por retorna a imagem do zumbi_1 andando para o lado esquerdo.
   */
   public GreenfootImage getImgWalkingLeft(){
       setDirecao(-1);
       return this.imgWalkingLeft.imprimir();
   }
     
   /**
   * método responsável por retorna a imagem do zumbi_1 parado para direita.
   */
   public GreenfootImage getImgIdleRight(){
       setDirecao(1);
       return this.imgIdleRight.imprimir();
   }
   
   /**
   * método responsável por retorna a imagem do zumbi_1 parado para esquerda.
   */
   public GreenfootImage getImgIdleLeft(){
       setDirecao(-1);
       return this.imgIdleLeft.imprimir();
   }
     
   /**
   * método responsável por retorna a imagem do zumbi_1 morto.
   */
   public GreenfootImage getImgDead(){
       setDirecao(1);
       return this.imgDead.imprimir();
   }
   
   /**
   * método responsável por retorna a imagem da boca(arma de ataque) do zumbi_1.
   */  
   public Boca getBoca(){
     return boca;     
   }
}

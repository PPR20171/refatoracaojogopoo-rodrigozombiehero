import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 *
 * ShrekZumbi herda da classe Inimigos, representa o zumbi intermediário.
 */
public class ShrekZumbi extends Inimigos {
    
    private Sprites andandoPraDireita;  
    private Sprites andandoPraEsquerda;
    private Sprites attackPraDireita;
    private Sprites attackPraEsquerda;
    private Sprites morrendoPraEsquerda, morrendoPraDireita;    
    private GreenfootImage zumbiParado;
    private PorreteDoShrekZumbi porrete;  
    
    /**
     * método responsável por adicionar o ShrekZumbi ao cenário.
     */
    public void addedToWorld(World world){        
        for(int i=0;i<4;i++){
            andandoPraDireita.inserir(new GreenfootImage("atores/shrekZumbi/walking/right/"+(i+1)+".png"));
            andandoPraEsquerda.inserir(new GreenfootImage("atores/shrekZumbi/walking/left/"+(i+1)+".png"));
            attackPraDireita.inserir(new GreenfootImage("atores/shrekZumbi/attack/right/"+(i+1)+".png"));
            attackPraEsquerda.inserir(new GreenfootImage("atores/shrekZumbi/attack/left/"+(i+1)+".png"));
        }        
        for(int i=0;i<5;i++){
            morrendoPraEsquerda.inserir(new GreenfootImage("atores/shrekZumbi/dead/left/"+(i+1)+".png"));
            morrendoPraDireita.inserir(new GreenfootImage("atores/shrekZumbi/dead/right/"+(i+1)+".png"));
        }
        zumbiParado=new GreenfootImage("atores/shrekZumbi/walking/right/2.png");    
        setVida(new BarraLoading(Color.RED,40,4,40,4),getX(),getY());
        apagarBarraDeVida();        
    }
    
    /**
     * construtor da classe.
     */
    public ShrekZumbi(){
        super("ShrekZumbi");
        andandoPraDireita=new Sprites();
        andandoPraEsquerda=new Sprites();
        attackPraDireita=new Sprites();
        attackPraEsquerda=new Sprites();
        morrendoPraEsquerda=new Sprites();
        morrendoPraDireita=new Sprites();        
        porrete=new PorreteDoShrekZumbi();        
    }
    
    /**
    * método responsável por chamar as ações do zumbi enquanto estiver vivo.
    */
    public void act(){  
       if(isVivo()){          
            boolean colidiu=detectarColisao(70);
            if(getDirecao()>0 && colidiu){
                 atacar(getAttackPraDireita());               
            }else if( getDirecao()<0 && colidiu){
                 atacar(getAttackPraEsquerda());              
            }            
            if(!colidiu){                
                if(getDirecao()>0 && perseguirProtagonista(1000)){
                    andar(getAndandoPraDireita(),15*getDirecao());           
                }else if(getDirecao()<0 && perseguirProtagonista(1000)){
                    andar(getAndandoPraEsquerda(),15*getDirecao());             
                }else{
                    setImage(zumbiParado);
                }            
            }
            apagarBarraDeVida();
            if(sofrerLesao()){
                List lista = getWorldOfType(ScrollWorld.class).getObjects(Protagonista.class);
                Protagonista prot=(Protagonista)lista.get(0); 
                decrementarVida((int)(prot.getArma().getIntensidade()/2));
            } 
            if(getPorrete().getBater()){
                getPorrete().getSom().stop();
                getPorrete().getSom().play();
            }    
       }      
       if(isMorto()){
            if(getDirecao()>0){
                morrendoPraDireita.setLoop(false);
                morrer(getMorrendoPraDireita());
            }else{
                morrendoPraEsquerda.setLoop(false);
                morrer(getMorrendoPraEsquerda());
            }
       }   
    }   
    
    
   /**
   * método responsável por retorna a imagem do Shrek zumbi andando para o lado direito.
   */
   public GreenfootImage getAndandoPraDireita(){
        getPorrete().setBater(false);
        setDirecao(1);
        return andandoPraDireita.imprimir();
   }
    
   /**
   * método responsável por retorna a imagem do Shrek zumbi andando para o lado esquerdo.
   */
   public GreenfootImage getAndandoPraEsquerda(){        
        getPorrete().setBater(false);
        setDirecao(-1);
        return andandoPraEsquerda.imprimir();
    }
   
   /**
   * método responsável por retorna a imagem do ataque do Shrek zumbi para o lado esquerdo.
   */
   public GreenfootImage getAttackPraEsquerda(){
        if(attackPraEsquerda.getContador()==3){
            getPorrete().setBater(true);
        }else{
             getPorrete().setBater(false);
        }
        setDirecao(-1);
        return attackPraEsquerda.imprimir();
    }
    
   /**
   * método responsável por retorna a imagem do ataque do Shrek zumbi para o lado direito.
   */
   public GreenfootImage getAttackPraDireita(){
        if(attackPraDireita.getContador()==3){
            getPorrete().setBater(true);
        }else{
            getPorrete().setBater(false);
        }
        setDirecao(1);
        return attackPraDireita.imprimir();
    }
    
   /**
   * método responsável por retorna a imagem do Shrek zumbi morrendo para o lado direito.
   */
   public GreenfootImage getMorrendoPraDireita(){
        return morrendoPraDireita.imprimir();
   } 
   
   /**
   * método responsável por retorna a imagem do Shrek zumbi morrendo para o lado esquerdo.
   */
   public GreenfootImage getMorrendoPraEsquerda(){
        return morrendoPraEsquerda.imprimir();
    }
   
   /**
   * método responsável por retorna a imagem do porrete(arma de ataque) do Shrek zumbi.
   */  
   public PorreteDoShrekZumbi getPorrete(){
        return porrete;
   }
   
}


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * AndroidZumbi herda da classe Inimigos, representa o zumbi mais forte.
 */
public class AndroidZumbi extends Inimigos
{

    Sprites androidAttackLeft=null;
    Sprites androidAttackRight=null;
    Sprites androidMorrendoLadoEsquerdo=null;
    Sprites androidMorrendoLadoDireito=null;
    BracoDoAndroidZumbi braco=null;
    
    /**
     * método responsável por adicionar o android zumbi ao cenário.
     */
     public void addedToWorld(World world){
         for(int i=0;i<6;i++){
             androidAttackRight.inserir(new GreenfootImage("atores/adroidZumbi/attack/right/"+(i+1)+".png"));
             androidAttackLeft.inserir(new GreenfootImage("atores/adroidZumbi/attack/left/"+(i+1)+".png"));
         }
         for(int i=0;i<7;i++){
             androidMorrendoLadoEsquerdo.inserir(new GreenfootImage("atores/adroidZumbi/dead/left/"+(i+1)+".png"));
             androidMorrendoLadoDireito.inserir(new GreenfootImage("atores/adroidZumbi/dead/right/"+(i+1)+".png"));
         }
         setVida(new BarraLoading(Color.RED,40,4,40,4),getX(),getY());
         apagarBarraDeVida();
     }
    
    /**
     * construtor da classe.
     */
    public AndroidZumbi(){
        super("AndroidZumbi");
        androidAttackLeft=new Sprites();
        androidAttackRight=new Sprites();
        androidMorrendoLadoEsquerdo=new Sprites();
        androidMorrendoLadoDireito= new Sprites();
        braco = new BracoDoAndroidZumbi();
    }
    
    /**
    * método responsável por chamar as ações do zumbi enquanto estiver vivo.
    */
    public void act(){        
        if(isVivo()){
            boolean colidiu=detectarColisao(60);
            if(getDirecao()>0 && colidiu){
                 atacar(getAndroidAttackright());
            }else if( getDirecao()<0 && colidiu){
                 atacar(getAndroidAttackLeft());             
            }
            if(!colidiu){   
                if(getDirecao()>0 && perseguirProtagonista(1000)){
                    andar(getAndroidAttackright(),8*getDirecao());
                    braco.setBater(false);
                }else if(getDirecao()<0 && perseguirProtagonista(1000)){
                    andar(getAndroidAttackLeft(),8*getDirecao()); 
                    braco.setBater(false);
                }else{
                    fiqueParado(getAndroidAttackLeft());
                    braco.setBater(false);
                }            
            }
            apagarBarraDeVida();
            if(sofrerLesao()){
                List lista = getWorldOfType(ScrollWorld.class).getObjects(Protagonista.class);
                Protagonista prot = (Protagonista) lista.get(0);
                decrementarVida((int)(prot.getArma().getIntensidade()/4));
            } 
            if(braco.getBater()){
                braco.getSom().stop();
                braco.getSom().play();
            }
        }
        if(isMorto()){
            if(getDirecao()>0){
                androidMorrendoLadoDireito.setLoop(false);
                morrer(getAndroidMorrendoLadoDireito());  
            }else{
                androidMorrendoLadoEsquerdo.setLoop(false);
                morrer(getAndroidMorrendoLadoEsquerdo());  
            }
        }     
    }   
    
    /**
     * método responsável por retorna a imagem do ataque do android zumbi para o lado esquerdo.
     */
    public GreenfootImage getAndroidAttackLeft(){
   
        setDirecao(-1);
        if(androidAttackLeft.getContador()==5){
             getBraco().setBater(true);
        }else{
             getBraco().setBater(false);
        }
        return androidAttackLeft.imprimir();
    }
    /**
     * método responsável por retorna a imagem do ataque do androido zumbi para o lado direito.
     */
    public GreenfootImage getAndroidAttackright(){
        setDirecao(1);
        if(androidAttackRight.getContador()==5){
             getBraco().setBater(true);
        }else{
             getBraco().setBater(false);
        } 
        return androidAttackRight.imprimir();
    }
    /**
     * método responsável por retorna a imagem do androido zumbi morrendo para o lado direito.
     */
    public GreenfootImage getAndroidMorrendoLadoDireito(){
        return androidMorrendoLadoDireito.imprimir();
    }
    
    /**
    * método responsável por retorna a imagem do androido zumbi morrendo para o lado esquerdo.
    */
    public GreenfootImage getAndroidMorrendoLadoEsquerdo(){
        return androidMorrendoLadoEsquerdo.imprimir();
    }
    
    /**
    * método responsável por retorna a imagem do braço(arma de ataque) do androido zumbi.
    */
    public BracoDoAndroidZumbi getBraco(){
        return this.braco;
     }
}
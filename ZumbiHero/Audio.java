import greenfoot.GreenfootSound;
import greenfoot.Greenfoot;
/**
 * Audio herda da classe GreenfootSound, responsável por executar os áudios do jogo e controla o volume.
 */
public class Audio extends  GreenfootSound {
    private Volume volume; 
    boolean iniciarAltura =true;
    
    /**
     * construtor da classe.
     */
    public Audio(String caminho){
        super(caminho);
        volume=new Volume();        
    }
    
    /**
     * método responsável por retornar o atribudo volume da classe Volume.
     */
    public int altura(){
        return volume.getVolume();
    }
    
    /**
     * método sobrescrito responsável por configurar o volume do áudio.
     */
    public void setVolume(){
        super.setVolume(altura());
    }
    
    /**
     * método responsável por tocar o áudio.
     */
    public void ativar(){
         volume.ativar();
        if(iniciarAltura){
            setVolume();
            iniciarAltura=false;
        }         
        if(Greenfoot.isKeyDown("p")){
             this.pause();   
        }        
        if(Greenfoot.isKeyDown("o")){
            this.stop();
        }        
        if(Greenfoot.isKeyDown("i")){
            this.play();
        }        
        if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")){
            setVolume();
        }       
    } 
}
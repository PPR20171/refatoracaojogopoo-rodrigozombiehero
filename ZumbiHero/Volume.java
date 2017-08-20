import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Volume classe responsável por ajustar o volume dos sons do jogo.
 */
public class Volume
{
    private int volume;
    static final private int alturaMin=0,alturaMax=100;
    private BarraLoading barra;
    private Arquivo arquivoDeVolume;
    
    /**
     * construtor da classe.
     */
    public Volume(){
        arquivoDeVolume = new Arquivo("arquivos/arquivoDeVolume.txt");
        volume=0;
    }
    
    /**
     * método responsável por o ajuste de volume do jogo, pressinando as teclas UP e DOWN respectivamente.
     */
    public void ativar() 
    {
        if(Greenfoot.isKeyDown("down")){
            diminuir();
        }
        
        if(Greenfoot.isKeyDown("up")){
            aumentar();
        }
    }    
    
    /**
     * método responsável por aumentar o volume dos sons do jogo.
     */
    public void aumentar(){
        this.volume=getVolume();
        if((this.volume+1)<=alturaMax){
            this.volume++;
            arquivoDeVolume.removeDados();
            arquivoDeVolume.salvar(Integer.toString(this.volume));
        }      
    }
    
    /**
     * método responsável por diminuir o volume dos sons do jogo.
     */
    public void diminuir(){
        this.volume=getVolume();
        if((this.volume-1)>= alturaMin){
            this.volume--;
            arquivoDeVolume.removeDados();
            arquivoDeVolume.salvar(Integer.toString(this.volume));
        }
      
    }
    
    /**
     * método responsável por retornar o atributo volume (de sons do jogo).
     */
    public int getVolume(){
        String vol="0";
        if(arquivoDeVolume.getDados()!=null){
             vol = arquivoDeVolume.getDados();
        }        
        if(!vol.equals(" ")){               
          try{  
              this.volume = Integer.parseInt(vol);
          }catch(NumberFormatException e){
              e.printStackTrace();
              arquivoDeVolume.removeDados();
              this.volume=50;
          }          
        }else{
            this.volume=50;
        }
        return this.volume;
    }    
}
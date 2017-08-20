import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Write a description of class Cenario_4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cenario_4 extends ScrollWorld
{
    FaseCompletada faseCompleta=new FaseCompletada();
    ResourceBundle arquivoProp;
    Arquivo arquivo = new Arquivo("arquivos/idioma.txt");
    Protagonista protagonista = new Protagonista("Rodrigo");
    /**
     * Constructor for objects of class Cenario_4.
     * 
     */
    public Cenario_4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1,900,1); 
        setAtorPrincipal(protagonista,50,350);
        this.atorPrincipal.setLocation(50,350);
        addObject(faseCompleta,700,350);
        String paraArquivo = arquivo.ler();
        
        try{
           if(paraArquivo.equals("br")){
             Locale localBr = new Locale("pt","BR");
             arquivoProp = ResourceBundle.getBundle("linguagem/Bundle_pt_BR",localBr);
           } else{
             Locale localUs = new Locale("en","US");
             arquivoProp = ResourceBundle.getBundle("linguagem/Bundle_en_US",localUs);
           }
       }catch(NullPointerException e){
           Locale localBr = new Locale("pt","BR");
           arquivoProp = ResourceBundle.getBundle("linguagem/Bundle_pt_BR",localBr);
           
       }
     
    }
    
    
    public void act(){
        faseCompleta.getImage().setTransparency(0);
        
            if(protagonista.isVivo()){
             
           showText(arquivoProp.getString("pontuacao")+" "+Integer.toString(protagonista.getPontos()),420,20);
    
           if(protagonista.getArma() instanceof ArmasDeFogo){
               ArmasDeFogo arma = (ArmasDeFogo) protagonista.getArma();
               PacoteDeMunicao pacote =(PacoteDeMunicao) protagonista.getPacoteDeMunicao().get(arma.getNome());
               showText(Integer.toString(arma.getDisparos())+" / "+Integer.toString(pacote.getQtdDisponivel()),300,40);
           }else{
               showText(" ",300,40);
       
           }
       
        }
        
           
        if(faseCompleta.getCompletou()){ 
            showText(arquivoProp.getString("faseConcluida"),getWidth()/2,getHeight()/2);
            Greenfoot.delay(30);
            Greenfoot.setWorld(new TelaInicial());
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Write a description of class Cenario_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cenario_3 extends ScrollWorld
{
    private Protagonista protagonista;
    private int cronometro;
    private FaseCompletada faseCompleta;
    Audio som; 
    GreenfootImage background;
    ResourceBundle arquivoProp;
    Arquivo arquivo = new Arquivo("arquivos/idioma.txt");
    /**
     * Constructor for objects of class Cenario_3.
     * 
     */
    public Cenario_3()
    {
        super(900,600,1,9000,3900);
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
        BarraLoading barraDeFundo = new BarraLoading(new Color(249,249,249),250,10,250,10);
        faseCompleta = new FaseCompletada();
        GreenfootImage background = new GreenfootImage("cenarios/cenario3.png");
        background.scale(getSWidth(),getHeight());
        setBackground(background);
        addObject(new AndroidZumbi(),1,480,true);
        addObject(new AndroidZumbi(),3000,480,true);
        addObject(new Zumbi_1(),1,510,true);
        addObject(new Zumbi_1(),100,510,true);
        addObject(new Zumbi_1(),200,510,true);
        addObject(new Zumbi_1(),300,510,true);
        addObject(new Zumbi_1(),400,510,true);
        addObject(new Zumbi_1(),500,510,true);
        addObject(new Zumbi_1(),600,510,true);
        addObject(new Zumbi_1(),700,510,true);
        addObject(new Zumbi_1(),800,510,true);
        addObject(new Zumbi_1(),900,510,true);
        addObject(new Zumbi_1(),1000,510,true);
        addObject(new Zumbi_1(),1100,510,true);        
        addObject(new ShrekZumbi(),50,440,true);        
        addObject(new Zumbi_1(),2800,510,true);
        addObject(new Zumbi_1(),2700,510,true);
        addObject(new Zumbi_1(),2600,510,true);
        addObject(new Zumbi_1(),2500,510,true);        
        addObject(new ShrekZumbi(),3500,440,true);        
        addObject(new Escopeta(),3900,500,true);
        addObject(new Pistola(),3800,500,true);
        addObject(new Escopeta(),1500,500,true);
        addObject(new Pistola(),18000,500,true);
        addObject(new Escopeta(),500,500,true);
        addObject(new Pistola(),600,500,true);         
         
         
         
        
        protagonista= new Protagonista("protagonista");
        addObject(barraDeFundo,130,20,false);
        addObject(new Zumbi_1(),2000,500,true);
        
        setAtorPrincipal(protagonista,4000,500);
        this.atorPrincipal.setLocation(4000,500);
        setScrollImagemDeFundo(background);
        Greenfoot.setSpeed(32);
        cronometro=0;
        addObject(faseCompleta,2,500,true);
         
        som=new Audio("DarkMusic.mp3");
    }
    
     public void act(){
         if(!som.isPlaying()){
            som.play();
        }
        som.ativar(); 
         
       
        if(protagonista.isMorto()){
            showText(arquivoProp.getString("fimJogo"),getWidth()/2,getHeight()/2);
            
            if(cronometro==30){
                som.stop();
                Greenfoot.setWorld(new TelaInicial());
            }
            cronometro++;
        }
        
   
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
        
      
        
        this.scrollObjetos();
        this.sImageDeFundo();
        
       
        
        if(faseCompleta.getCompletou()){
               Greenfoot.setWorld(new Cenario_4());
        }
     }
}

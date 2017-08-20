import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ResourceBundle;
import java.util.Locale;
/**
 * Cenario_2 classe que herda de ScrollWorld responsável pelo cenário 2
 */
public class Cenario_2 extends ScrollWorld
{
    private Protagonista protagonista;
    private int cronometro; 
    private FaseCompletada faseCompleta;
    Audio som;
    ResourceBundle arquivoProp;
    Arquivo arquivo = new Arquivo("arquivos/idioma.txt");
    Arquivo arquivoDeBloqueio = new Arquivo("arquivos/arquivo_De_Bloqueio.txt");
    /**
     * Construtor de Cenario_2 cria tamanho do cenário junto com todos os personagens e objetos
     */
    public Cenario_2()
    {
        super(900,600,1,9000,4000);
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
        
        GreenfootImage background = new GreenfootImage("cenarios/cenario_2.png");
        background.scale(getSWidth(),getHeight());
        setBackground(background);
        faseCompleta = new FaseCompletada();
        BarraLoading barraDeFundo = new BarraLoading(new Color(249,249,249),250,10,250,10);
        protagonista = new Protagonista("Rodrigo");
        
        addObject(barraDeFundo,130,20,false);
        
        addObject(new Zumbi_1(),800,480,true);
        addObject(new Zumbi_1(),1000,480,true);
        addObject(new Zumbi_1(),1100,480,true);
        addObject(new Zumbi_1(),1200,480,true);
        addObject(new Zumbi_1(),1300,480,true);
        addObject(new Zumbi_1(),1400,480,true);
        addObject(new Zumbi_1(),1500,480,true);
        addObject(new Zumbi_1(),1600,480,true);
        addObject(new Zumbi_1(),1700,480,true);
        addObject(new Zumbi_1(),1800,480,true);
        addObject(new Zumbi_1(),1900,480,true);
        addObject(new Zumbi_1(),2000,480,true);
        
        addObject(new ShrekZumbi(),2100,420,true);
        
        addObject(new Zumbi_1(),3300,480,true);
        addObject(new Zumbi_1(),3400,480,true);
        addObject(new Zumbi_1(),3500,480,true);
        addObject(new Zumbi_1(),3600,480,true);
        
        addObject(new ShrekZumbi(),3100,420,true);
        
        addObject(new Pistola(),1500,440,true);
        addObject(new Escopeta(),1900,440,true);
        addObject(new Escopeta(),2300,440,true);
        addObject(new Pistola(),2800,440,true);
     
        setAtorPrincipal(protagonista,150,480);
        this.atorPrincipal.setLocation(150,480);
        setScrollImagemDeFundo(background);
        cronometro =0;
        Greenfoot.setSpeed(32);
        addObject(faseCompleta,4500,460,true);
        
        som=new Audio("climaDeTensao.mp3");
    }
    
    /**
     * act método que é responsável interação do protagonista com o cenário
     */
    public void act(){
        this.scrollObjetos();
        this.sImageDeFundo();
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
        
       
        if(faseCompleta.getCompletou()){
               arquivoDeBloqueio.salvar("3");  
               showText(arquivoProp.getString("faseConcluida"),getWidth()/2,getHeight()/2);
               Greenfoot.delay(30);
               som.stop();
               Greenfoot.setWorld(new TelaInicial());
        }
    }
}

import java.util.Locale;
import java.util.ResourceBundle;
import greenfoot.*; 
import java.io.FileNotFoundException; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.util.List;

/**
 * Cenario_1 classe que herda de ScrollWorld responsável pelo cenário 1
 */
public class Cenario_1 extends ScrollWorld{    
    private Protagonista protagonista;
    private int cronometro;
    private FaseCompletada faseCompleta;
    Audio som;
    ResourceBundle arquivoProp;
    Arquivo arquivo = new Arquivo("arquivos/idioma.txt");
    Arquivo arquivoDeBloqueio = new Arquivo("arquivos/arquivo_De_Bloqueio.txt");
    /**
     * Construtor de Cenario_1 cria tamanho do cenário junto com todos os personagens e objetos
     */

    public Cenario_1()
    {
        super(900,600,1,9700,4300);
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
        
        
        GreenfootImage background = new GreenfootImage("cenarios/cenario_1.png");
        background.scale(getSWidth(),getHeight());
        setBackground(background);
        faseCompleta =new FaseCompletada();
        BarraLoading barraDeFundo = new BarraLoading(new Color(249,249,249),250,10,250,10);
        addObject(barraDeFundo,130,20,false);
        protagonista = new Protagonista("Rodrigo");
       
        addObject(new Zumbi_1(),1,420,true);
        addObject(new Zumbi_1(),100,420,true);
        addObject(new Zumbi_1(),50,420,true);
        addObject(new Zumbi_1(),1600,420,true);
        addObject(new Zumbi_1(),1700,420,true);
        addObject(new Zumbi_1(),1900,420,true);
        addObject(new Zumbi_1(),2100,420,true);
        addObject(new Zumbi_1(),2200,420,true);
        addObject(new Zumbi_1(),2300,420,true);
        addObject(new Zumbi_1(),2400,420,true);
        addObject(new Zumbi_1(),2500,420,true);
        addObject(new Zumbi_1(),2600,420,true);
        addObject(new Zumbi_1(),2700,420,true);
        addObject(new Zumbi_1(),2800,420,true);
        addObject(new Zumbi_1(),2900,420,true);
        addObject(new Zumbi_1(),3100,420,true);
        addObject(new Zumbi_1(),3200,420,true);
        addObject(new Zumbi_1(),3300,420,true);
        addObject(new Zumbi_1(),3400,420,true);
        addObject(new Zumbi_1(),3500,420,true);
        
       
        addObject(new Escopeta(),2300,440,true);
        addObject(new Pistola(),2800,440,true);

        setAtorPrincipal(protagonista,1300,410);
        this.atorPrincipal.setLocation(1300,410);
        setScrollImagemDeFundo(background);
        Greenfoot.setSpeed(32);
        cronometro=0;
        addObject(faseCompleta,4830,430,true);

        som=new Audio("perseguicao.mp3");
    }

    /**
     * act método que é responsável interação do protagonista com o cenário
     */
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
            arquivoDeBloqueio.salvar("2"); 
            showText(arquivoProp.getString("faseConcluida"),getWidth()/2,getHeight()/2);
            Greenfoot.delay(30);
            som.stop();
            Greenfoot.setWorld(new TelaInicial());
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Classe responsável pela tela inicial do jogo.
 * onde será iniciado o menu.
 */
public class TelaInicial extends World
{
    GreenfootImage img_cenario;
    Audio som;
    Next cenario1,cenario2,cenario3;
    Arquivo arquivoDeBloqueio;
    /**
     * Construtor da tela inicial responsável por inciar os sons,
     * background e o menu. 
     */
    public TelaInicial(){
        super(900, 600, 1); 
        som = new Audio("somTerror.mp3");
        som.setVolume(50);
        
        arquivoDeBloqueio=new Arquivo("arquivos/arquivo_De_Bloqueio.txt");
        
        GreenfootImage background = new GreenfootImage("tela_de_fundo.png"); 
        background.scale(getWidth(),getHeight());
        setBackground(background);
        
        
        img_cenario=new GreenfootImage("cenarios/img_cenario1.png");
        //img_cenario.scale(img_cenario.getWidth()/8,img_cenario.getHeight()/8);
        cenario1 = new Next(img_cenario,new Cenario_1());
        addObject(cenario1,200,500);
        
        img_cenario=new GreenfootImage("cenarios/img_cenario2.png");
        cenario2 = new Next(img_cenario,new Cenario_2());
        //img_cenario.scale((int)(img_cenario.getWidth()/8),(int)(img_cenario.getHeight()/13));
        addObject(cenario2,400,500);
        
        img_cenario=new GreenfootImage("cenarios/img_cenario_3.png");
        cenario3 = new Next(img_cenario,new Cenario_3());
        //img_cenario.scale((int)(img_cenario.getWidth()/2),(int)(img_cenario.getHeight()/1.8));
        addObject(cenario3,600,500);
        
        try{
            if(Integer.parseInt(arquivoDeBloqueio.ler())<2){
                 addObject(new BloqueioDeFase(),400,500);
                 addObject(new BloqueioDeFase(),600,500);
            }else if(Integer.parseInt(arquivoDeBloqueio.ler())<3){
                 addObject(new BloqueioDeFase(),600,500);
            }
        }catch(Exception e){
           try{
               new NumberFormatException();
           }catch(NumberFormatException erro1){
               erro1.printStackTrace();
           }
           
           try{
               new NullPointerException();
           }catch(NullPointerException erro2){
               erro2.printStackTrace();
           }
           arquivoDeBloqueio.salvar("1");
           addObject(new BloqueioDeFase(),400,500);
           addObject(new BloqueioDeFase(),600,500);
           
        }
       
        
        menuIdioma();
    }

    /**
     * Método é responsável por iniciar o som
     * de fundo e pará-lo quando a primeira fase é iniciada.
     */
    public void act(){
        if(!som.isPlaying()){
            som.play();
        }

        if(Greenfoot.mousePressed(cenario1)||Greenfoot.mousePressed(cenario2)||Greenfoot.mousePressed(cenario3)){
            som.stop();
        }
        som.ativar();
    }

    public void menuIdioma(){
        Menu menu = new Menu(" ");
        BotaoIngles botaoIngles = new BotaoIngles(menu);
        BotaoBr botaoBr = new BotaoBr(menu);

        addObject(menu, getWidth()/2,getHeight()/2);
        addObject(botaoIngles,100,500);
        addObject(botaoBr,400,500);

        botaoIngles.setBotaoBr(botaoBr);
        botaoBr.setBotaoIngles(botaoIngles);
    }
}

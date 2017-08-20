import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Write a description of class BotaoIngles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoIngles extends Botoes

{

    private Menu menu;
    private BotaoBr botaoBr;
    private World world;
    /**
     * Act - do whatever the BotaoIngles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BotaoIngles(Menu menu){
        criaBotao("English");
        this.menu = menu;
    }

    public void setBotaoBr(BotaoBr botaoBr){
        this.botaoBr = botaoBr;
    }

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(menu);
            getWorld().removeObject(botaoBr);

            Locale localEN = new Locale("en","US");
            ResourceBundle arquivoLinguagem =  ResourceBundle.getBundle("linguagem/Bundle_en_US",localEN);

            String textoTutorial= "\n"+"\t\t\t\t\t\tTutorial: "+"\n\nMoviment: "+arquivoLinguagem.getString("movimentacao1")+"\n"+arquivoLinguagem.getString("movimentacao2")+"\nAtack: "+arquivoLinguagem.getString("atacar")+"\n\nLife: "+arquivoLinguagem.getString("vida")+"\n\nReload: "+arquivoLinguagem.getString("recarregar")+"\n\nObjective: "+arquivoLinguagem.getString("objetivo"); 
            //obejetos que serao necessarios

            Menu menuPrincipal = new Menu(" "); 
            Jogar jogar = new Jogar(menuPrincipal,arquivoLinguagem.getString("jogar"));
            Sobre sobre = new Sobre("About: "+"\n\n"+arquivoLinguagem.getString("sobre1")+"\n\n"+arquivoLinguagem.getString("sobre2")+"\n\n"+arquivoLinguagem.getString("sobre3")+"\n\n"+arquivoLinguagem.getString("sobre4")+"\n\n"+arquivoLinguagem.getString("sobre5"),arquivoLinguagem.getString("tituloSobre"));
            Tutorial tutorial = new Tutorial(textoTutorial,arquivoLinguagem.getString("tituloTutorial"));
            Sair sair = new Sair(arquivoLinguagem.getString("sair"));

            //sets para fechar os botoes em Jogar
            jogar.setSair(sair);
            jogar.setSobre(sobre);
            jogar.setTutorial(tutorial);

            //criando o menu principal com os botões em portugues
            world=getWorldOfType(TelaInicial.class);
            world.addObject(menuPrincipal, world.getWidth()/2,world.getHeight()/2);
            world.addObject(sobre,100,500);
            world.addObject(jogar,sobre.getX()+200,500);
            world.addObject(tutorial,jogar.getX()+200,500);
            world.addObject(sair,tutorial.getX()+200,500);

            //salvando no arquivo a inguagem selecionada
            Arquivo arquivo = new Arquivo("arquivos/idioma.txt");
            arquivo.removeDados();
            arquivo.salvar("en");
            getWorld().removeObject(this);

        }
    }
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Write a description of class BotaoBr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoBr extends Botoes

{
    
    private Menu menu;
    private BotaoIngles botaoIngles;
    private World world;
    /**
     * Act - do whatever the BotaoBr wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BotaoBr(Menu menu){
        criaBotao("Português-BR");
        this.menu= menu;
    }
    
    public void setBotaoIngles(BotaoIngles botaoIngles){
        this.botaoIngles = botaoIngles;
    }

    public void act() 
    {
       
            if(Greenfoot.mouseClicked(this)){
                getWorld().removeObject(menu);
                getWorld().removeObject(botaoIngles);
            
                //Carregando arquivos da linguagem BR
                Locale localBR = new Locale("pt","BR");
                ResourceBundle arquivoLinguagem =  ResourceBundle.getBundle("linguagem/Bundle_pt_BR",localBR);
                
                
                String textoTutorial= "\n"+"\t\t\t\t\t\tTutorial: "+"\n\nMovimentacao: "+arquivoLinguagem.getString("movimentacao1")+"\n"+arquivoLinguagem.getString("movimentacao2")+"\n\nAtacar: "+arquivoLinguagem.getString("atacar")+"\n\nVida: "+arquivoLinguagem.getString("vida")+"\n\nRecarregar: "+arquivoLinguagem.getString("recarregar")+"\n\nObjetivo: "+arquivoLinguagem.getString("objetivo"); 
                //obejetos que serao necessarios
                
                Menu menuPrincipal = new Menu(" "); 
                Jogar jogar = new Jogar(menuPrincipal,arquivoLinguagem.getString("jogar"));
                Sobre sobre = new Sobre("Sobre: "+"\n\n"+arquivoLinguagem.getString("sobre1")+"\n\n\n"+arquivoLinguagem.getString("sobre2")+"\n\n\n"+arquivoLinguagem.getString("sobre3")+"\n\n\n"+arquivoLinguagem.getString("sobre4")+"\n\n\n"+arquivoLinguagem.getString("sobre5"),arquivoLinguagem.getString("tituloSobre"));
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
                arquivo.salvar("br");
                getWorld().removeObject(this);

        }
    }
}
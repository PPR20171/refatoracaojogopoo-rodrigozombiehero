
package jogorodrigozumbihero.menu;
import java.util.List;
import java.util.ArrayList;


public class Menu {
    
    private final List<BotaoGenerico> botaoList;
    
    public Menu(){
        botaoList = new ArrayList<>();
    }
    
    public void addBotao(BotaoGenerico botao){
        this.botaoList.add(botao);
    }
    
    
    
}

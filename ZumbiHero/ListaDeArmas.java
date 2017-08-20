import greenfoot.GreenfootImage;
/**
 * ListaDeArmas representa a listagem de armas no jogo
 */
public class ListaDeArmas{
    private Armas dados;
    private ListaDeArmas prox;
    
    /**
     * construtor da classe.
     */
    public ListaDeArmas(Armas arma){
        this.dados=arma;
        this.prox=null;
    
    }
    
    /**
     * método responsável por configurar o atributo dados(qualquer tipo de arma que pode receber).
     */
    public void setDados(Armas arma){
        this.dados=arma;
    }
    
    /**
     * método responsável por configurar o atributo prox(ponteiro para próxima arma).
     */
    public void setProx(ListaDeArmas prox){
        this.prox=prox;
    }
    
    /**
     * método responsável por retornar o atributo dados(qualquer tipo de arma que pode receber).
     */
    public Armas getDados(){
        return this.dados;
    }
    
    /**
     * método responsável por retornar o atributo prox(ponteiro para próxima arma).
     */
    public ListaDeArmas getProx(){
        return this.prox;
    }

   
}

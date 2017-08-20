import greenfoot.GreenfootImage;
/**
 * ListaDeImagem representa a listagem de imagens do jogo.
 */
public class ListaDeImagem{
    private GreenfootImage dados;
    private ListaDeImagem prox;
    
    /**
     * construtor da classe.
     */
    public ListaDeImagem(GreenfootImage imagem){
        this.dados=imagem;
        this.prox=null;        
    }    
    
    /**
     * método responsável por configurar o atributo dados(qualquer tipo de imagem que pode receber).
     */
    public void setDados(GreenfootImage imagem){
        this.dados=imagem;
    }
    
    /**
     * método responsável por configurar o atributo prox(ponteiro para próxima imagem).
     */
    public void setProx(ListaDeImagem prox){
        this.prox=prox;
    }
    /**
     * método responsável por retornar o atributo dados(qualquer tipo de imagem que pode receber).
     */
    public GreenfootImage getDados(){
        return this.dados;
    }
    
    /**
     * método responsável por retornar o atributo prox(qualquer tipo de imagem que pode receber).
     */
    public ListaDeImagem getProx(){
        return this.prox;
    }
    
   
}

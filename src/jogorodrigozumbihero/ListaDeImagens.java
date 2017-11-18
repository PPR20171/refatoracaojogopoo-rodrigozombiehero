
package jogorodrigozumbihero;

import jogorodrigozumbihero.interfaces.Imagem;


public class ListaDeImagens {
    
    private Imagem dados;
    private ListaDeImagens prox;
    
    /**
     * construtor da classe.
         * @param imagem
     */
    public ListaDeImagens(Imagem imagem){
        this.dados=imagem;
        this.prox=null;        
    }    
    
    /**
     * método responsável por configurar o atributo dados(qualquer tipo de imagem que pode receber).
         * @param imagem
     */
    public void setDados(Imagem imagem){
        this.dados=imagem;
    }
    
    /**
     * método responsável por configurar o atributo prox(ponteiro para próxima imagem).
         * @param prox
     */
    public void setProx(ListaDeImagens prox){
        this.prox=prox;
    }
    /**
     * método responsável por retornar o atributo dados(qualquer tipo de imagem que pode receber).
         * @return 
     */
    public Imagem getDados(){
        return this.dados;
    }
    
    /**
     * método responsável por retornar o atributo prox(qualquer tipo de imagem que pode receber).
         * @return 
     */
    public ListaDeImagens getProx(){
        return this.prox;
    }

}

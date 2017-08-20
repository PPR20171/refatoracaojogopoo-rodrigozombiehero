/**
 * TabelaDeRecompensa classe que representa a pontuação de recompensa para o protagonista com relação ao tipo de inimigo morto.
 */
public class TabelaDeRecompensa  
{
    private int valor; 
    
    /**
     * construtor de classe.
     */
    public TabelaDeRecompensa(int valor)
    {
        this.valor = valor;
    }
    
    /**
     * método responsável por retornar o atributo valor(valor da pontuação do inimigo morto).
     */
    public int getValor(){
        return this.valor;
    }   
}

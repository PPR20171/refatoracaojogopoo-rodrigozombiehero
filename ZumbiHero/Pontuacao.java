import java.util.List;
/**
 * Pontuacao classe que implementa a pontuação do jogo.
 */
public class Pontuacao  {
    private int pontos;
    Arquivo arquivo;
    
    /**
     * construtor da classe.
     */
    public Pontuacao(){
        pontos=0;
        arquivo = new Arquivo("arquivos/dadosDePontuacao.txt");
    }
    
    /**
     * método responsável por aumentar a pontuação no jogo quando o usuário marca um ponto.
     */
    public void incrementaPontos(int novaPontuacao){
        this.pontos=getPontos()+ novaPontuacao;
        arquivo.removeDados();
        arquivo.salvar(Integer.toString(this.pontos));
    }
    
    /**
     * método que retorna a pontuação no jogo.
     */
    public int getPontos(){
        String dados="0";
        if(arquivo.getDados()!=null){
            dados=arquivo.getDados();
        }
        this.pontos=0;
        if(!dados.equals(" ")){
               try{
                  this.pontos=Integer.parseInt(dados);  
               }catch(NumberFormatException e){
                   e.printStackTrace();
               }
        }
        return this.pontos;
    }   
}
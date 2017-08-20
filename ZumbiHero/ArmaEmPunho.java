import greenfoot.GreenfootImage;
/**
 * Arma em punho representa as armas disponiveis para o protagonista.
 */
public class ArmaEmPunho
{
    private ListaDeArmas inicio;
    private ListaDeArmas fim;
    private ListaDeArmas exibirArma;
    private Armas arma;
    private int qtd,contador;
    
    /**
     * construtor de classe.
     */
    public ArmaEmPunho(){
        this.inicio=null;
        this.fim=null;
        this.qtd=0;
        this.contador=0;
        this.arma=null;
    }
    
    /**
     * método responsável para verificar se a lista de armas está vazia.
     */
    private boolean listaVazia(){
       return qtd==0;
    }
    
    /**
     * método responsável por adicionar um tipo de arma na lista de armas.
     */
    public void inserir(Armas arma){
        
        ListaDeArmas novo=new ListaDeArmas(arma);
        if(listaVazia()){
            this.inicio=novo;
            this.fim=novo;
            this.exibirArma=novo;
            this.arma=arma;
        }else{
            this.fim.setProx(novo);
            this.fim = novo;
        }
        this.qtd++;
    }
    
   
    /**
     * método responsável pelo retorno do tipo de arma escolhida, espada, pistola ou escopeta.
     */
    public Armas trocar(){
        ListaDeArmas lista = exibirArma; 
        if(this.listaVazia()){
            return null;
        }else{          
            if(this.contador<qtd){
                this.exibirArma = lista.getProx();
                this.contador++;
            }            
            if(this.contador==qtd){
                this.exibirArma=this.inicio;
                this.contador=0;
            }           
        }
        arma=lista.getDados();
        return lista.getDados();
    }
    
    /**
     * método responsável por retornar o atributo qtd (quantidade).
     */
    public int getQtd(){
        return this.qtd;
    }
    
    /**
     * método responsável por retornar o atributo arma.
     */
    public Armas getArma(){
        return arma;
    }
}
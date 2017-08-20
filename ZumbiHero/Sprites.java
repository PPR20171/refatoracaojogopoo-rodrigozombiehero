import greenfoot.GreenfootImage;
/**
 * Sprites classe que implementa a interface OperacaoListaDeImagem, responsável por receber as imagens dos sprites
 */
public class Sprites implements OperacaoListaDeImagem {
    private ListaDeImagem inicio;
    private ListaDeImagem fim;
    private ListaDeImagem exibirSprite;
    private GreenfootImage imagem;
    private int qtd,contador;
    private boolean loop=true;
    
    /**
     * construtor da classe.
     */
    public Sprites(){
        this.inicio=null;
        this.fim=null;
        this.qtd=0;
        this.contador=0;
        this.imagem=null;
    }
    
    /**
     * método sobrescrito que verifica se a lista está vazia.
     */
    public boolean listaVazia(){
       return qtd==0;
    }
    
    
    /**
     * método sobrescrito que insere as imagens no Sprites
     */public void inserir(GreenfootImage imagem){
        ListaDeImagem novo=new ListaDeImagem(imagem);
        if(listaVazia()){
            this.inicio=novo;
            this.fim=novo;
            exibirSprite=novo;
        }else{
            this.fim.setProx(novo);
            this.fim = novo;
        }
        this.qtd++;
    }    
    
    /**
     * método sobrescrito que retorna a próxima imagem da lista no Sprite.
     */
    public GreenfootImage imprimir(){
        ListaDeImagem lista = exibirSprite; 
        if(this.listaVazia()){
            return null;
        }else{          
            if(this.contador<qtd){
                this.exibirSprite = lista.getProx();
                this.contador++;
            }            
            if(this.contador==qtd){
                this.exibirSprite=this.inicio;
                this.contador=0;
            }            
            if(loop){
               return lista.getDados();    
            }else{
                return this.fim.getDados();
            }            
        }
    }
    
     /**
     * método sobrescrito que retorna qual o tamanho da lista de Sprite.
     */
    public int tamanhoDaLista(){
        return this.qtd;
    }
    
    public int getContador(){
        return this.contador;
    }
    
    public void setLoop(boolean bool){
        loop=bool;
    }
   
}

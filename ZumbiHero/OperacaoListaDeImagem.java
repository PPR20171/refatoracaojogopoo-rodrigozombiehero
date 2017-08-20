import greenfoot.GreenfootImage;
/**
 * Interfaxe OperacaoListaDeImagem para ser imprementada na classe Sprites
 */
interface OperacaoListaDeImagem  
{
    
    /**
     * método que verifica se a lista está vazia.
     */
    public boolean listaVazia();
   
    /**
     * método que insere as imagens no Sprites
     */
    public void inserir(GreenfootImage imagem);
    
    /**
     * método que retorna a próxima imagem da lista no Sprite.
     */
    public GreenfootImage imprimir();
    
    /**
     * método que retorna qual o tamanho da lista de Sprite.
     */
    public int tamanhoDaLista();
  
}

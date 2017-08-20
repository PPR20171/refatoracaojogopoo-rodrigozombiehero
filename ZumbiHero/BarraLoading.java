import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Barraloading classe que herda de Actor responsável pela barra de vida dos personagens
 */
public class BarraLoading extends Actor
{
    private GreenfootImage barra;
    private int comprimento,altura,width,height;
    private Color cor;
    private int tamanho;
    /**
     * addedToWorld método responsável por adicionar a barra transparente nos cenários
     */
    public void addedToWorld(World MyMundo){
            barra=new GreenfootImage(width,height);
            barra.setColor(cor);
            barra.fillRect(0,0,tamanho,altura);
            setImage(this.barra);
    }
    
    /**
     * construtor barraLoading onde cria a barra de vida dos personagens junto com a 
     * barra tranparente.
     */
    public BarraLoading(Color cor,int tamanho,int altura,int width,int height){
        this.cor=cor;
        comprimento=tamanho;
        this.tamanho=tamanho;
        this.altura=altura;
        this.width=width;
        this.height=height;
    }
    /**
    * incrementar método responsável aumantar o tamanho da barra
    */
    public void incrementar(int tam){
        if(tamanho<=comprimento){
            tamanho+=tam;
        }
    }
    
    /**
    * incrementar método responsável diminuir o tamanho da barra
    */
    public void decrementar(int tam){
        if(tamanho>0){
            tamanho-=tam;    
        }
    }
    
    public int getTamanho(){
        return tamanho;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getAltura(){
        return altura;
    }
    
    public int getComprimento(){
        return comprimento;
    }
   
}

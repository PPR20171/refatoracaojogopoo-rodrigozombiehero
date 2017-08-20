import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Armas herda de Actor, representas as armas do jogo.
 */
public abstract class Armas extends Actor
{
   private String nome;
   private int intensidade;
   private Audio som;
  
   /**
    * construtor da classe.
    */
   public Armas(String nome,int intensidadeDaArma){
      this.nome=nome;
      intensidade = intensidadeDaArma;
   }
   
   /**
    * construtor da classe.
    */
   public Armas(String nome,int intensidadeDaArma,String caminho){
      this.nome=nome;
      intensidade = intensidadeDaArma;
      som=new Audio(caminho);
   }
  
   /**
    * método responsável por configurar a intensidade de dano de arma.
    */
   public Integer getIntensidade(){
       return intensidade;
   }
   
   /**
    * método responsável pelo retorno do nome da arma.
    */
   public String getNome(){
       return nome;
   } 
   
   /**
    * método que retorna o som do ataque da arma.
    */
   public Audio getSom(){
       return this.som;
   }
}

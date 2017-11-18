package jogorodrigozumbihero;

import jogorodrigozumbihero.proxys.AudioProxy;


public class Armas {
    
   private final String nome;
   private final int intensidade;
   private AudioProxy som;
  
   /**
    * construtor da classe.
     * @param nome
     * @param intensidadeDaArma
    */
   public Armas(String nome,int intensidadeDaArma){
      this.nome=nome;
      intensidade = intensidadeDaArma;
   }
   
   /**
    * construtor da classe.
     * @param nome
     * @param intensidadeDaArma
     * @param caminho
    */
   public Armas(String nome,int intensidadeDaArma,String caminho){
      this.nome=nome;
      intensidade = intensidadeDaArma;
      som = new AudioProxy(caminho);
   }
  
   /**
    * método responsável por configurar a intensidade de dano de arma.
     * @return 
    */
   public Integer getIntensidade(){
       return intensidade;
   }
   
   /**
    * método responsável pelo retorno do nome da arma.
     * @return 
    */
   public String getNome(){
       return nome;
   } 
   
   /**
    * método que retorna o som do ataque da arma.
     * @return 
    */
   public AudioProxy getSom(){
       return this.som;
   }
    
}

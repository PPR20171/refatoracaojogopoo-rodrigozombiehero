import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ArmasDeFogo herda de Armas, representa todas as armas de fogo
 */
public abstract class ArmasDeFogo extends Armas
{
    private int limMaxDisparos,disparos,direcao;
    private int tempoTiro;
    private int tempoRecarga;
   
   /**
    * construtor de classe.
    */
    public ArmasDeFogo(String nome,int intensidadeDoDano,int limMaxDisparos,int tempoTiro,int tempoRecarga, String urlDoSom){
       super(nome,intensidadeDoDano,urlDoSom);
       this.limMaxDisparos=limMaxDisparos;
       this.tempoTiro=tempoTiro;
       this.tempoRecarga=tempoRecarga;
       disparos=limMaxDisparos;       
   }
 
   /**
    * método responsável por retornar a quantidade da munição por recarga da arma. Quantidade máxima se estiver vazia e o restante se ainda tiver alguma
    * na arma.
    */
   public int recarregar(int qtd){       
       if(qtd>0 && ((disparos+qtd) <=limMaxDisparos)){
           this.disparos+=qtd;
           qtd=0;
       }else if((qtd+disparos)>limMaxDisparos){
          int aux=limMaxDisparos-disparos;
          qtd=(qtd-aux);
          disparos+=Math.abs((aux));          
       }       
       return qtd;
   }
   
   /**
    * método abstrato responsável pelo disparo.
    */
   public abstract int disparo();
   
   /**
    * método responsável por verificar se a arma ainda tem munição. Retornando 1 ainda tem munição, retornando 0 não tem munição.
    */
   public int disparar(){
       if(disparos >0){
           disparos--;
           return 1;
       }
       return 0;
   }
   
   /**
    * método responsável pelo retorno do atributo disparos.
    */
   public int getDisparos(){
       return this.disparos;
   }
   
   /**
    * método responsável pela quantidade de munições que uma arma tem no momento.
    */
   public int qtdBalaNoPente(){
       return this.limMaxDisparos-disparos;
   }
   
   /**
    * método responsável pelo retorno do atributo limMaxDisparos.
    */
   public int getLimMaxDisparos(){
       return this.limMaxDisparos;
   }
   
   /**
    * método responsável pelo retorno do atributo tempoRecarga.
    */
   public int getTempoRecarga(){
       return this.tempoRecarga;
   }
   
   /**
    * método responsável pelo retorno do atributo tempoTiro.
    */
   public int getTempoTiro(){
       return this.tempoTiro;
   }
   
    /**
    * método responsável pelo incremento do tempo de um tiro ao outro.
    */
    public void incrementaTempoTiro(){
       tempoTiro++;
    }
    
    /**
     * método responsável pelo tempo de espera entre um tiro e outro.
     */
    public void zeraTempoTiro(){
        tempoTiro = 0;
    }
    
    /**
    * método responsável pela configuração da direcao que a arma aponta.
    */
    public void setDirecao(int direcao){
        this.direcao=direcao;
    }
    
    /**
    * método responsável pelo retorno da direcao que a arma aponta.
    */
    public int getDirecao(){
        return direcao;
    }
    
}

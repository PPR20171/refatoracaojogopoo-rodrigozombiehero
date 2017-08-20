import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Protagonista herda da classe Personagem, representa o personagem que o usuário irá controlar
 */
public class Protagonista extends Personagem{
   private Pontuacao pontos;
   private Map<String,PacoteDeMunicao> pacoteDeMunicao;
   private Map<String,TabelaDeRecompensa>valoresDeRecompensa;
   private ArmaEmPunho arma;

   private Sprites paradoPraDireitaComEscopeta ;
   private Sprites paradoPraEsquerdaComEscopeta ;
   private Sprites paradoPraDireitaComPistola;
   private Sprites paradoPraEsquerdaComPistola;
   private Sprites paradoPraEsquerdaComEspada;
   private Sprites paradoPraDireitaComEspada;
   
   private Sprites correndoPraDireitaComEscopeta ;
   private Sprites correndoPraEsquerdaComEscopeta ;
   private Sprites correndoPraDireitaComPistola;
   private Sprites correndoPraEsquerdaComPistola;
   private Sprites correndoPraEsquerdaComEspada;
   private Sprites correndoPraDireitaComEspada;   
   private Sprites ataquePraDireitaComEspada;
   private Sprites ataquePraEsquerdaComEspada;   
   private Sprites morrendoPraDireita;
   private Sprites morrendoPraEsquerda;

   /**
    * método responsável por adicionar o protagonista ao cenário
    */
   public void addedToWorld(World world){
        paradoPraDireitaComEscopeta.inserir(new GreenfootImage("atores/protagonistas/escopeta/right/2.png"));
        paradoPraEsquerdaComEscopeta.inserir(new GreenfootImage("atores/protagonistas/escopeta/left/2.png"));
        paradoPraDireitaComPistola.inserir(new GreenfootImage("atores/protagonistas/pistola/right/2.png"));
        paradoPraEsquerdaComPistola.inserir(new GreenfootImage("atores/protagonistas/pistola/left/2.png"));
        paradoPraEsquerdaComEspada.inserir(new GreenfootImage("atores/protagonistas/espada/left/2.png"));
        paradoPraDireitaComEspada.inserir(new GreenfootImage("atores/protagonistas/espada/right/2.png"));
        for(int i=0;i<4;i++){
           correndoPraDireitaComEscopeta.inserir(new GreenfootImage("atores/protagonistas/escopeta/right/"+(i+1)+".png"));
            correndoPraEsquerdaComEscopeta.inserir(new GreenfootImage("atores/protagonistas/escopeta/left/"+(i+1)+".png"));
            correndoPraDireitaComPistola.inserir(new GreenfootImage("atores/protagonistas/pistola/right/"+(i+1)+".png"));
            correndoPraEsquerdaComPistola.inserir(new GreenfootImage("atores/protagonistas/pistola/left/"+(i+1)+".png"));
            correndoPraEsquerdaComEspada.inserir(new GreenfootImage("atores/protagonistas/espada/left/"+(i+1)+".png"));
            correndoPraDireitaComEspada.inserir(new GreenfootImage("atores/protagonistas/espada/right/"+(i+1)+".png"));
         
        }     
        for(int i=0;i<3;i++){
            morrendoPraDireita.inserir(new GreenfootImage("atores/protagonistas/morrendo/right/"+(i+1)+".png"));
            morrendoPraEsquerda.inserir(new GreenfootImage("atores/protagonistas/morrendo/left/"+(i+1)+".png"));
        }     
        for(int i=0;i<2;i++){
            ataquePraDireitaComEspada.inserir(new GreenfootImage("atores/protagonistas/espada/attack/right/"+(i+1)+".png"));
            ataquePraEsquerdaComEspada.inserir(new GreenfootImage("atores/protagonistas/espada/attack/left/"+(i+1)+".png"));
        }     
        setImage(new GreenfootImage("atores/protagonistas/escopeta/right/2.png"));
        setVida(new BarraLoading(Color.RED,250,10,250,10),130,20);
        Espada espada = new Espada();
        Pistola pistola = new Pistola();
        Escopeta escopeta = new Escopeta();    
        addArma(espada); 
        addArma(pistola);
        addArma(escopeta);
        pacoteDeMunicao.put(pistola.getNome(),new PacoteDeMunicao(30));
        pacoteDeMunicao.put(escopeta.getNome(),new PacoteDeMunicao(10));     
        Zumbi_1 z1 = new Zumbi_1();
        AndroidZumbi android = new AndroidZumbi();
        ShrekZumbi shrek = new ShrekZumbi();
        valoresDeRecompensa.put(z1.getNome(),new TabelaDeRecompensa(10));
        valoresDeRecompensa.put(android.getNome(),new TabelaDeRecompensa(30));
        valoresDeRecompensa.put(shrek.getNome(),new TabelaDeRecompensa(20));   
   }  
   
   /**
    * construtor da classe
    */
   public Protagonista(String nome){
        super(nome);
       pacoteDeMunicao= new HashMap();
       setDirecao(1);
       pontos = new Pontuacao();
       correndoPraDireitaComEscopeta =new Sprites();
       correndoPraEsquerdaComEscopeta=new Sprites();
       correndoPraDireitaComPistola=new Sprites();
       correndoPraEsquerdaComPistola=new Sprites();
       correndoPraEsquerdaComEspada=new Sprites();
       correndoPraDireitaComEspada=new Sprites();
       ataquePraDireitaComEspada=new Sprites();
       ataquePraEsquerdaComEspada=new Sprites();
       
       paradoPraDireitaComEscopeta=new Sprites();
       paradoPraEsquerdaComEscopeta=new Sprites() ;
       paradoPraDireitaComPistola=new Sprites();
       paradoPraEsquerdaComPistola=new Sprites();
       paradoPraEsquerdaComEspada=new Sprites();
       paradoPraDireitaComEspada=new Sprites();
       
       morrendoPraDireita = new Sprites();
       morrendoPraEsquerda=new Sprites();
       
       arma= new ArmaEmPunho();
       valoresDeRecompensa=new HashMap();
       
     
    }
  
    /**
    * método responsável por chamar as ações do protagonista via teclado enquanto estiver vivo.
    */
   public void act(){

        if(isVivo()){
    
            if(Greenfoot.isKeyDown("j") && Greenfoot.isKeyDown("d")&& getArma() instanceof Espada){
               golpeDeEspada(getAtaquePraDireitaComEspada());
            }else if(Greenfoot.isKeyDown("j")&& Greenfoot.isKeyDown("a")&& getArma() instanceof Espada){
                golpeDeEspada(getAtaquePraEsquerdaComEspada());
            }else if(Greenfoot.isKeyDown("d") && getArma() instanceof Escopeta){
                andar(getCorrendoPraDireitaComEscopeta(),25); 
            }else if(Greenfoot.isKeyDown("a") && getArma() instanceof Escopeta){
                andar(getCorrendoPraEsquerdaComEscopeta(),-25);    
            }else if(Greenfoot.isKeyDown("d") && getArma() instanceof Pistola){
                andar(getCorrendoPraDireitaComPistola(),25);    
            }else if(Greenfoot.isKeyDown("a") && getArma() instanceof Pistola){
                andar(getCorrendoPraEsquerdaComPistola(),-25);       
            }else if(Greenfoot.isKeyDown("d")&& getArma() instanceof Espada){
                andar(getCorrendoPraDireitaComEspada(),25);  
                Espada espada=(Espada)getArma();
                espada.setCortar(false);      
            }else if(Greenfoot.isKeyDown("a")&& getArma() instanceof Espada){
                andar(getCorrendoPraEsquerdaComEspada(),-25);
                Espada espada=(Espada)getArma();
                espada.setCortar(false);    
            }else{        
                if(arma.getArma() instanceof Escopeta && getDirecao()<0){
                    fiqueParado(getParadoPraEsquerdaComEscopeta());
                }       
                if(arma.getArma() instanceof Escopeta && getDirecao()>0){
                    fiqueParado(getParadoPraDireitaComEscopeta());
                }       
                if(arma.getArma() instanceof Pistola && getDirecao()<0){
                    fiqueParado(getParadoPraEsquerdaComPistola());
                }       
                if(arma.getArma() instanceof Pistola && getDirecao()>0){
                    fiqueParado(getParadoPraDireitaComPistola());
                }       
                if(arma.getArma() instanceof Espada && getDirecao()<0){
                    fiqueParado(getParadoPraEsquerdaComEspada());
                }       
                if(arma.getArma() instanceof Espada && getDirecao()>0){
                    fiqueParado(getParadoPraDireitaComEspada());
                }       
            }    
            if(Greenfoot.isKeyDown("k")){
                trocarDeArma();
            }    
            if(Greenfoot.isKeyDown("j")&& getArma() instanceof ArmasDeFogo){
                atirar();
            }    
            if(Greenfoot.isKeyDown("r")){
                recarregarArma();
            }    
            sofrerLesao();
        }
    
        if(isMorto()){
            if(getDirecao()>0){
                morrendoPraDireita.setLoop(false);
                morrer(getMorrendoPraDireita());
            }else{
                morrendoPraEsquerda.setLoop(false);
                morrer(getMorrendoPraEsquerda());
            } 
            getWorld().showText(" ",300,40);       
        }
    
        pegarMunicao();  
   }
  
   /**
    * método responsável por fazer o protagonista atirar com arma de fogo
    */
   public void atirar(){
       if(getArma() instanceof ArmasDeFogo){
            ArmasDeFogo armaAtual=(ArmasDeFogo)getArma();
            armaAtual.setDirecao(this.getDirecao());
            int disparo = armaAtual.disparo();
            if(disparo==0){
                recarregarArma();
            }            
       }
   }
  
   /**
    * método responsável por fazer o protagonista recarregar a arma de fogo
    */
   public void recarregarArma(){
       
       if(getArma() instanceof ArmasDeFogo){
           ArmasDeFogo arma = (ArmasDeFogo) getArma();
           PacoteDeMunicao pacote = (PacoteDeMunicao) pacoteDeMunicao.get(arma.getNome());
           arma.recarregar(pacote.fazerRetirada(arma.qtdBalaNoPente()));
       }
       
       
   }
   
   /**
    * método sobrescrito responsável fazer a interação de movimentação do protagonista em relação ao cenário
    */
   public void andar(GreenfootImage imagem,int direcao){
       setImage(imagem);
       if(detectarColisao(30)>0 && getDirecao()>0)direcao=0;
       if(detectarColisao(30)<0 && getDirecao()<0)direcao=0;
       super.andar(imagem,direcao);
    }
   
    /**
     * método responsável por adicionar arma ao protagonista.
     */
   public void addArma(Armas arma){
           this.arma.inserir(arma);
           if(this.arma.getQtd()==1){
                  getWorldOfType(ScrollWorld.class).addObject(getArma(),300,20,false);
           }
       
           
   }
  
   /**
    * método sobrescrito responsável diminuir a vida do protagonista assim que sofre um dano.
    */
   public void decrementarVida(int num){
        BarraLoading[] barra=getVida();
        int x = barra[0].getX(),y = barra[0].getY();
        getWorldOfType(ScrollWorld.class).removeObject(barra[0]);
        barra[0].decrementar(num);
        getWorldOfType(ScrollWorld.class).addObject(barra[0],x,y,false);
        
   }
    
   /**
    * método responsável por configurar o atributo pontos.
    */
   public void setPontos(int pontuacao){
       this.pontos.incrementaPontos(pontuacao);
   }
   
   /**
    * método responsável por retornar o atributo pontos.
    */
   public int getPontos(){
       return this.pontos.getPontos();
   }
   
   /**
    * método responsável verificar se o protagonista está colidindo com os inimigos. Retorno 1 quando o protagonista está virado para direita, retorno -1 
    * quando o protagonista está virado pra esquerda.
    */public int detectarColisao(int raio){     
       if(isVivo()){         
           List lista = getNeighbours(raio,true,Inimigos.class);
           Inimigos inimigo;
           if(lista.size()>0){
               for(int i=0;i<lista.size();i++){
                   inimigo = (Inimigos) lista.get(i);
                   if(inimigo.isVivo()){
                       if(inimigo.getX()>getY()){
                           return 1;     
                        }else{
                            return -1;
                        }
                    }             
                }        
            }           
        }    
        return 0;
   }
   
   /**
   * método responsável por retorna a imagem do Shrek zumbi morrendo para o lado direito com a escopeta.
   */
   public GreenfootImage getCorrendoPraDireitaComEscopeta(){
      setDirecao(1); 
      return correndoPraDireitaComEscopeta.imprimir();
   }
   
   /**
   * método responsável por retorna a imagem do Shrek zumbi morrendo para o lado esquerdo com a escopeta.
   */
   public GreenfootImage getCorrendoPraEsquerdaComEscopeta(){
     setDirecao(-1);  
     return correndoPraEsquerdaComEscopeta.imprimir();
    }
   
   /**
   * método responsável por retorna a imagem do Shrek zumbi morrendo para o lado direito com a pistola.
   */
   public GreenfootImage getCorrendoPraDireitaComPistola(){
        setDirecao(1);
        return correndoPraDireitaComPistola.imprimir();
   }
   
   /**
   * método responsável por retorna a imagem do Shrek zumbi morrendo para o lado esquerda com a esquerda.
   */
   public GreenfootImage getCorrendoPraEsquerdaComPistola(){
        setDirecao(-1);
        return correndoPraEsquerdaComPistola.imprimir();
   }
   
   /**
   * método responsável por retorna a imagem do Shrek zumbi morrendo para o lado esquerda com a espada.
   */
   public GreenfootImage getCorrendoPraEsquerdaComEspada(){
       setDirecao(-1);
       return correndoPraEsquerdaComEspada.imprimir();
   }
   
   /**
   * método responsável por retorna a imagem do Shrek zumbi morrendo para o lado direita com a esquerda.
   */
   public GreenfootImage getCorrendoPraDireitaComEspada(){
       setDirecao(1);
       return correndoPraDireitaComEspada.imprimir();
   }
   
   /**
    * método responsável pelo protagonista trocar de arma.
    */
   public void trocarDeArma(){
       getWorldOfType(ScrollWorld.class).removeObject(getArma());
       getWorldOfType(ScrollWorld.class).addObject(arma.trocar(),300,20,false);
   } 
   
   /**
    * método responsável por retornar a imagem do protagonista parado para direita com a escopeta.
    */
   public GreenfootImage getParadoPraDireitaComEscopeta(){
       setDirecao(1);
       return paradoPraDireitaComEscopeta.imprimir();
   }
   
   /**
    * método responsável por retornar a imagem do protagonista parado para esquerda com a escopeta.
    */
   public GreenfootImage getParadoPraEsquerdaComEscopeta(){
       setDirecao(-1);
       return paradoPraEsquerdaComEscopeta.imprimir();
   }
   
   /**
    * método responsável por retornar a imagem do protagonista parado para direita com a pistola.
    */
   public GreenfootImage getParadoPraDireitaComPistola(){
       setDirecao(1);
       return paradoPraDireitaComPistola.imprimir();
    }
   
    /**
    * método responsável por retornar a imagem do protagonista parado para esquerda com a pistola.
    */
   public GreenfootImage getParadoPraEsquerdaComPistola(){
      setDirecao(-1);
      return paradoPraEsquerdaComPistola.imprimir();
   }
  
   /**
    * método responsável por retornar a imagem do protagonista parado para esquerda com a espada.
    */
   public GreenfootImage getParadoPraEsquerdaComEspada(){
      setDirecao(-1);
      return paradoPraEsquerdaComEspada.imprimir();
   }
  
   /**
    * método responsável por retornar a imagem do protagonista parado para direita com a espada.
    */
   public GreenfootImage getParadoPraDireitaComEspada(){
      setDirecao(1);
      return paradoPraDireitaComEspada.imprimir();
   }
  
   /**
    * método responsável por retornar a imagem do protagonista atacando para direita com a espada.
    */
   public GreenfootImage  getAtaquePraDireitaComEspada(){
      setDirecao(1);
      if(ataquePraDireitaComEspada.getContador()==1){
          Espada espada;
          if(getArma() instanceof Espada){
              espada =(Espada)getArma(); 
              espada.setCortar(true);
          }else{
              espada =(Espada)getArma(); 
              espada.setCortar(false);
          }
      }
      return  ataquePraDireitaComEspada.imprimir();
   }
  
   /**
   * método responsável por retornar a imagem do protagonista atacando para esquerda com a espada.
   */
   public GreenfootImage  getAtaquePraEsquerdaComEspada(){
      setDirecao(-1);
      if(ataquePraEsquerdaComEspada.getContador()==1){
          Espada espada;
          if(getArma() instanceof Espada){
              espada =(Espada)getArma(); 
              espada.setCortar(true);
          }else{
              espada =(Espada)getArma();  
              espada.setCortar(false);
          }
      }
      return  ataquePraEsquerdaComEspada.imprimir();
   }
  
  /**
  * método responsável por retornar a imagem do protagonista morrendo para direita.
  */
   public GreenfootImage getMorrendoPraDireita(){
     setDirecao(1);
     return morrendoPraDireita.imprimir();
  }
  
  /**
  * método responsável por retornar a imagem do protagonista morrendo para esquerda.
  */
  public GreenfootImage getMorrendoPraEsquerda(){
      setDirecao(-1);
      return morrendoPraEsquerda.imprimir();
  }
  
  /**
  * método responsável por retornar o atributo arma.
  */
  public Armas getArma(){
       return arma.getArma();
  }
  
  /**
  * método responsável por retornar o atributo valoresDeRecompensa.
  */
  public Map getValoresDeRecompensa(){
    return this.valoresDeRecompensa;
  }
  
  /**
   * método responsável por gerar a recompensa quando o protagonista mata um inimigo, cada tipo de inimigo gera uma pontuação diferente.
   */
  public void obterRecompensa(String nome){
      TabelaDeRecompensa linha =(TabelaDeRecompensa) this.valoresDeRecompensa.get(nome);//casting para tabela de recompensa
      setPontos(linha.getValor());
  }
  
  /**
   * método responsável dano sofrido pelo protagonista quando for atingido pelo ataque do inimigo.
   */
  public void sofrerLesao(){
      List lista = getIntersectingObjects(Inimigos.class);
      if(lista.size()>0){
           for(int i=0;i<lista.size();i++){
             if(lista.get(i) instanceof Zumbi_1){
                 Zumbi_1 zumbi= (Zumbi_1)lista.get(i); 
                 if(zumbi.getAtacar()&& zumbi.isVivo()){
                     if(zumbi.getBoca().getMorder()){
                          decrementarVida(zumbi.getBoca().getIntensidade());
                     }
                 }
                 
             } 
             
             if(lista.get(i) instanceof AndroidZumbi){
                 AndroidZumbi android = (AndroidZumbi) lista.get(i); 
                 if(android.getAtacar()&& android.isVivo()){
                     if(android.getBraco().getBater()){
                          decrementarVida(android.getBraco().getIntensidade());
                     }
                   
                 }
             }
             
             if(lista.get(i) instanceof ShrekZumbi){
                 ShrekZumbi shrek = (ShrekZumbi)lista.get(i);
                 if(shrek.getAtacar()&& shrek.isVivo()){
                     if(shrek.getPorrete().getBater()){
                         decrementarVida(shrek.getPorrete().getIntensidade());
                     }
                 }
             }
           }
      }
  } 
  
  /**
  * método responsável por retornar o atributo pacoteDeMunicao.
  */
  public Map getPacoteDeMunicao(){
      return this.pacoteDeMunicao;
  }
  
  /**
   * metodo responsável pelo ataque de espada pelo protagonista. 
   */
  public void golpeDeEspada(GreenfootImage image){
       setImage(image);
  }
  
  /**
   * método responsável pelo contato das munições encontradas no cenário com o protagonista, aumenta a quantidade da munição da arma de fogo 
   */
  public void pegarMunicao(){
      List pegueMunicao=getNeighbours(50,false,ArmasDeFogo.class);      
      if(pegueMunicao.size()>0){
          for(int i=0;i<pegueMunicao.size();i++){          
          if(pegueMunicao.get(i) instanceof Pistola){
              Pistola pistola = (Pistola) pegueMunicao.get(i);
              PacoteDeMunicao enchePacote =(PacoteDeMunicao)this.pacoteDeMunicao.get(pistola.getNome()); 
              enchePacote.setQtdDisponivel(pistola.getLimMaxDisparos());
              removerPersonagem(pistola);
          }          
          if(pegueMunicao.get(i) instanceof Escopeta){
              Escopeta escopeta = (Escopeta) pegueMunicao.get(i);
              PacoteDeMunicao enchePacote =(PacoteDeMunicao)this.pacoteDeMunicao.get(escopeta.getNome()); 
              enchePacote.setQtdDisponivel(escopeta.getLimMaxDisparos());
              removerPersonagem(escopeta);
          }
        }
      } 
  }  
}

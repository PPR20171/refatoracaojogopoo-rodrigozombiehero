import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * ScrollWorld é uma classe que herda de World e que é responśavel por
 * fazer a rolatem horizontal.
 */
public abstract class ScrollWorld extends World{
    private List<Actor> atorGenerico = new ArrayList<Actor>(); //lista todos os objetos de ator de rolagem generico
    private GreenfootImage imagemDeFundo = null;
    private int sX ,sY; //montantes rolados horizontal e verticalmente
    private int sDirection; // indica as direções de rolagem
    private int sWidth,sHeight; //dimenções totais da área de rolagem
    private int limMinActorX, limMaxActorX, limMinActorY,limMaxActorY; //limita o protagonista com o scrollWorld
    protected Actor atorPrincipal = null; //permite que o ator fique visível no mundo 
    private int scrollStop;
    /**
     * Construtor da classe ScrollWorld recebe como parâmetros
     * int largura(largura da tela que o usuário vê), int altura(altura da tela que o usuário vê), 
     * int tamCelula(representa o tamanho do pixel),int sLargura(largura total da tela do jogo),
     * int sAltura(altura total da tela do jogo).
     */
    public ScrollWorld(int largura, int altura,int tamCelula,int sLargura,int sAltura,int stop){         
        super(largura,altura,tamCelula,false);
        sDirection =0;
        sWidth = sLargura;
        sHeight =sAltura;
        scrollStop=stop;
    }
    
    /**
     * Segundo construtor de classe que recebe os mesmo parâmetros do primeiro com uma
     * pequena diferença, ele instancia os parametros da própria classe
     */
    public ScrollWorld(int largura,int altura,int tamCelula, int sLargura,int stop){
        this(largura,altura,tamCelula,sLargura,altura,stop);
    }
    
   /**
    * setAtorPrincipal método responsável por adicionar o protagonista na tela do jogo.
    * utilizando instância da classe Protagonista como parametro e inteiros X e Y como 
    * coordenada.
    */
    public void setAtorPrincipal(Protagonista ator,int x,int y){
        if(ator == null){
            return;
        }
        super.addObject(ator,getWidth(),getHeight());
        atorPrincipal=ator;
        limMinActorX=getWidth()/3;
        limMaxActorX=getWidth()/2;
        limMinActorY=getHeight()/2-y/2;
        limMaxActorY=getHeight()/2+y/2;
    }
    
    /**
     * setScrollImagemDeFundo método responsável por fazer a rolagem da imagem de fundo do
     * cenário e altera o tamanho da imagem de fundo.
     */
    public void setScrollImagemDeFundo(GreenfootImage sImagemDeFundo){
        if(atorPrincipal==null){//implementar disparo de exception
            return;
        }
        this.imagemDeFundo=new GreenfootImage(sImagemDeFundo);
        this.imagemDeFundo.scale(this.sWidth,this.sHeight);
        this.sImageDeFundo();
    }
    /**
     * sImageDeFundo método utilizado junto com setScrollImagemDeFundo que é responsável 
     * pelo calculo para rolagem para rolagem da imagem de fundo.
     */
    public void sImageDeFundo(){
        if(this.imagemDeFundo==null){
           return;
        } 
        getBackground().drawImage(this.imagemDeFundo,-sX*2,-this.sY);
    }
    
    public int getSX(){
        return this.sX;
    } 
    
    public int getSY(){
        return this.sY;
    }
    
    public int getSWidth(){
        return this.sWidth;
    }
    
    public int getSHeight(){
        return this.sHeight;
    }
    
   /**
    * addObject método que adiciona os personagens nos cenários.
    */
    public void addObject(Actor obj, int x, int y, boolean scroll){
        super.addObject(obj,x,y);
        if(scroll){
            atorGenerico.add(obj);
        }
    }
    
    /**
    * addObject método que retira os personagens nos cenários.
    */
    public void removeObject(Actor obj){
        if(obj==null){//implementar disparo de exception
            return;
        }
        
        if(obj.equals(this.atorPrincipal)){
            this.atorPrincipal=null;
        }else{
            this.atorGenerico.remove(obj);
            
        }
        super.removeObject(obj);
    }
    /**
     * removeObjetos método responsável por remover todos os objetos do cenário
     */
    public void removeObjetos(List<Actor>objs){
        for(Actor obj:objs){
            this.removeObject(obj);
        }
    }
    /**
     * scrollObjetos método responsável por fazer rolagem de todos os objetos e personagens
     * que não seja o protagonista, junto ao cenário.
     */
    public void scrollObjetos(){
        if(this.atorPrincipal==null){
            return;
        }
        int x=0,y=0;
        if(this.atorPrincipal.getX() < limMinActorX && sX > 0){
            x=limMinActorX-atorPrincipal.getX();
           
        }
        
        if(this.atorPrincipal.getX() > limMaxActorX && sX<=scrollStop){
            x=limMaxActorX-atorPrincipal.getX();
          
        }
        
         if(this.atorPrincipal.getY() < limMinActorY){
            y=limMinActorY-atorPrincipal.getY();
        }

         if(this.atorPrincipal.getY() > limMaxActorY){
            y=limMaxActorY-atorPrincipal.getY();
        }
        
        int xS = x, yS = y;
        sX-=x; sY-=y;
        this.atorPrincipal.setLocation(atorPrincipal.getX()+x,atorPrincipal.getY()+y);
        x=0 ; y=0;
      
         xS+=x; yS+=y;
         sX-=x ;sY-=y;
        
        this.atorPrincipal.setLocation(atorPrincipal.getX()+x,this.atorPrincipal.getY()+y);
        
       
            for(int i=0 ;i<this.atorGenerico.size();i++){      
                      Actor ator=(Actor)this.atorGenerico.get(i);  
                  try{
                      ator.setLocation(ator.getX()+xS,ator.getY()+yS);
                  }catch(IllegalStateException e){
                      e.printStackTrace();
                      System.err.println("Falha numa tentativa de localizar a coordenada de um ator!!!");
                      this.atorGenerico.remove(i);
                  }
           }
        
          
        x=0;y=0;
        if(atorPrincipal.getX() < 0){
            x=0-atorPrincipal.getX();
        }
        
        if(atorPrincipal.getX() > getWidth()-1){
            x=(getWidth()-1)-atorPrincipal.getX();
        }
        
        if(this.atorPrincipal.getY()<0){
            y=0-atorPrincipal.getY();
        }
        
        if(this.atorPrincipal.getY() > getHeight()-1){
            y=(getHeight()-1)-this.atorPrincipal.getY();
        }
        
        if(x==0 && y==0){
            return;
        }
        
        this.atorPrincipal.setLocation(this.atorPrincipal.getX()+x,this.atorPrincipal.getY()+y);
        
    }
    

}
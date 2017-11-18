
package jogorodrigozumbihero;
public class Pistola extends ArmaDeFogo{

    
   public Pistola(String nome, int intensidadeDaArma) {
        super(nome,intensidadeDaArma,12,7,10,"somtiro.mp3");
   }
    
    
    @Override
    public int disparo(){
     /*
        if (getTempoTiro() >= getTempoRecarga()) {
            zeraTempoTiro();
            if(getDisparos()>0){          
                
                   List lista = getMundo().getObjeto(Personagem.class);
                   Personagem prot = (Personagem) lista.get(0);
                   //getWorldOfType(ScrollWorld.class).addObject(new Municao(),prot.getX()+(47*prot.getDirecao()),prot.getY()-28,true);
                   //getWorldOfType(ScrollWorld.class).addObject(new FaiscaDeTiro(),prot.getX()+(44*prot.getDirecao()),prot.getY()-29,true);
                   
                   getSom().parar();
                   getSom().tocar();
                   this.disparar();
                   return 1;                   
            }            
        }else{
            return -1;
        }*/
        return 0;     
    }   
    
     
 }
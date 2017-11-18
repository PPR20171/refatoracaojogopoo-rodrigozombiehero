
package jogorodrigozumbihero;


public class Protagonista extends Personagem implements Atacar{
    private Armas armas;
    
    public Protagonista(String nome){
        super(nome);
    }
    
    @Override
    public void ataque(Armas arma){
        armas = arma; 
        if(this.armas instanceof Pistola){
            Pistola pistola = (Pistola) this.armas;
            pistola.disparar();
        }else if(this.armas instanceof Escopeta){
            Escopeta escopeta = (Escopeta) this.armas;
            escopeta.disparar();
        }else if(this.armas instanceof Espada){
            Espada espada = (Espada) this.armas;
            espada.cortar();
        }
        
        
    }

}

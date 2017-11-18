
package jogorodrigozumbihero;


public class ShrekZumbi extends Personagem implements Atacar{
    private Armas armas;
    public ShrekZumbi(String nome) {
        super(nome);
    }
    
    @Override
    public void ataque(Armas arma){
        this.armas = arma;
      
    }
    
}


package jogorodrigozumbihero;


public class RoboZumbi extends Personagem implements Atacar{
    private Armas armas;

    public RoboZumbi(String nome) {
        super(nome);
    }
    
    
    @Override
    public void ataque(Armas arma)
    {
        this.armas = arma;
    }
    
}

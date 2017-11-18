
package jogorodrigozumbihero.interfaces;
import java.util.List;
import jogorodrigozumbihero.adaptador.WorldAdapter;
import jogorodrigozumbihero.interfaces.Imagem;
public interface Ator {
    
    void adcionarAoMundo(WorldAdapter mundo);
    Imagem getImagem();
    void setLocalizacao(int x, int y);
    void setImagem(String filename);
    void setImagem(Imagem imagem);
    void mover(int distancia);
    boolean intersectar(Ator outro);
    int getX();
    int getY();
    Mundo getMundo();
    List<Ator> getVizinhos(int distancia, boolean diagonal, Ator ator);
    boolean isTouching();
}

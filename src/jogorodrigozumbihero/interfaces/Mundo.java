package jogorodrigozumbihero.interfaces;
import jogorodrigozumbihero.proxys.AtorProxy;
import jogorodrigozumbihero.Personagem;

public interface Mundo {
    
    void adcionarObjeto(AtorProxy objeto,int x ,int y);
    void adcionarPersonagem(Personagem personagem, int x ,int y);
    Imagem getImagemFundo();
    void setImagemFundo(Imagem imagem);
    int getTamanhoDaCelula();
    int getAltura();
    int getLargura();
    void removeObjeto(AtorProxy obj);
    void iniciado();
    void parado();
    
}

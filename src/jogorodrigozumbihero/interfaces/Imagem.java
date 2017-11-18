package jogorodrigozumbihero.interfaces;
import jogorodrigozumbihero.adaptador.ImagemAdapter;
import jogorodrigozumbihero.adaptador.CorAdapter;

public interface Imagem {
    
    void apagar();

    void desenhar(ImagemAdapter imagem, int x, int y);

    void desenharRetangulo(int x, int y, int tamanho, int largura);

    void desenharString(String string, int x, int y);

    CorAdapter getCor();

    int getAltura();

    int getLargura();

    int getTransparencia();

    void escala(int largura, int altura);

    void setCor(CorAdapter cor);

    void setTransparencia(int t);
    
}


package jogorodrigozumbihero.proxys;

import jogorodrigozumbihero.adaptador.CorAdapter;
import jogorodrigozumbihero.adaptador.ImagemAdapter;
import jogorodrigozumbihero.interfaces.Imagem;


public class ImagemProxy implements Imagem {
    
    private Imagem imagem;
    
    public ImagemProxy(ImagemAdapter imagem){
        //this.imagem = new ImagemAdapter(imagem);
    }
 
    public ImagemProxy(int largura, int altura){
        //this.imagem =  new ImagemAdapter(largura, altura);
    }
 
    public ImagemProxy(String filename){
         //this.imagem = new ImagemAdapter(filename);
    } 
    
    @Override
    public void apagar(){
        this.imagem.apagar();
    }

    @Override
    public void desenhar(ImagemAdapter imagem, int x, int y){
        this.imagem.desenhar(imagem, x, y);
    }

    @Override
    public void desenharRetangulo(int x, int y, int tamanho, int largura){
        this.imagem.desenharRetangulo(x, y, tamanho, largura);
    }

    @Override
    public void desenharString(String string, int x, int y){
        this.imagem.desenharString(string, x, y);
    }

    @Override
    public CorAdapter getCor(){
        return this.imagem.getCor();
    }

    @Override
    public int getAltura(){
        return this.imagem.getAltura();
    }

    @Override
    public int getLargura(){
        return this.imagem.getLargura();
    }

    @Override
    public int getTransparencia(){
        return this.imagem.getTransparencia();
    }

    @Override
    public void escala(int largura, int altura){
        this.imagem.escala(largura, altura);
    }

    @Override
    public void setCor(CorAdapter cor){
        this.imagem.setCor(cor);
    }

    @Override
    public void setTransparencia(int t){
        this.imagem.setTransparencia(t);
    }
    
}

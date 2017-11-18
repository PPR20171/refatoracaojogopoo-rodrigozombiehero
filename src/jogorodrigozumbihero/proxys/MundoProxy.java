
package jogorodrigozumbihero.proxys;

import jogorodrigozumbihero.Personagem;
import jogorodrigozumbihero.adaptador.WorldAdapter;
import jogorodrigozumbihero.interfaces.Imagem;
import jogorodrigozumbihero.interfaces.Mundo;


public class MundoProxy implements Mundo{
    private Mundo mundo;
    public MundoProxy(int largura, int altura, int celula){
        //this.mundo = new WorldAdapter(largura,altura,celula);
    }
    
    @Override
    public void adcionarObjeto(AtorProxy objeto,int x ,int y){
        this.mundo.adcionarObjeto(objeto, x, y);
    }
    @Override
    public void adcionarPersonagem(Personagem personagem, int x ,int y){
        this.mundo.adcionarPersonagem(personagem, x, y);
    }
    @Override
    public Imagem getImagemFundo(){
        return this.mundo.getImagemFundo();
    }
    @Override
    public void setImagemFundo(Imagem imagem){
        this.mundo.setImagemFundo(imagem);
    }
    @Override
    public int getTamanhoDaCelula(){
        return this.mundo.getTamanhoDaCelula();
    }
    @Override
    public int getAltura(){
        return this.mundo.getAltura();
    }
    @Override
    public int getLargura(){
        return this.mundo.getLargura();
    }
    @Override
    public void removeObjeto(AtorProxy obj){
        this.mundo.removeObjeto(obj);
    }
    @Override
    public void iniciado(){
        this.mundo.iniciado();
    }
    @Override
    public void parado(){
        this.mundo.parado();
    }
}

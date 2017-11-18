package jogorodrigozumbihero.proxys;
import java.util.List;
import jogorodrigozumbihero.interfaces.Ator;
import jogorodrigozumbihero.adaptador.AtorAdapter;
import jogorodrigozumbihero.adaptador.WorldAdapter;
import jogorodrigozumbihero.interfaces.Imagem;
import jogorodrigozumbihero.interfaces.Mundo;

public class AtorProxy implements Ator{
    
    private Ator ator;
    
    public AtorProxy(){
         //ator =  new AtorAdapter();   
    }
    
    public Ator getObjeto(){
        return ator;
    }
    
    @Override
    public void adcionarAoMundo(WorldAdapter mundo){
        ator.adcionarAoMundo(mundo);
    }
    @Override
    public Imagem getImagem(){
        return ator.getImagem();
    }
    @Override
    public void setLocalizacao(int x, int y){
        ator.setLocalizacao(x, y);
    }
    
    @Override
    public void setImagem(String filename){
        ator.setImagem(filename);
    }
    @Override
    public void setImagem(Imagem imagem){
        ator.setImagem(imagem);
    }
    @Override
    public void mover(int distancia){
        ator.mover(distancia);
    }
    @Override
    public boolean intersectar(Ator outro){
        return ator.intersectar(outro);
    }
    
    @Override
    public int getX(){
        return ator.getX();
    }
    @Override
    public int getY(){
        return ator.getY();
    }
    @Override
    public Mundo getMundo(){
        return ator.getMundo();
    }
    
    @Override
    public List<Ator> getVizinhos(int distancia, boolean diagonal, Ator ator){
        return this.ator.getVizinhos(distancia, diagonal, ator);
    }
    @Override
    public boolean isTouching(){
        return ator.isTouching();
    }
 }

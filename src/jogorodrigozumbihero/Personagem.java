
package jogorodrigozumbihero;

import jogorodrigozumbihero.interfaces.ExibirAcao;
import jogorodrigozumbihero.proxys.AtorProxy;
import java.util.List;
import java.util.ArrayList;

public class Personagem extends AtorProxy implements ExibirAcao{
    
    private String nome;
    private byte direcao;
    private int transparencia;
    private short velocidade;
    private BarraDeVida vida;  
    private final List<Sprite> sprites;  
            
    public Personagem(String nome){
        this.nome = nome;
        sprites = new ArrayList<>();
    }
    
    public void addSprites(Sprite sprites, Acao acao){
         if(null != acao)switch (acao) {
            case ANDAR:
                this.sprites.add(0, sprites);
                break;
            case ATACAR:
                this.sprites.add(1, sprites);
                break;
            case CORRER:
                this.sprites.add(2, sprites);
                break;
            case CAIR:
                this.sprites.add(3, sprites);
                break;
            case LESIONADO:
                this.sprites.add(4, sprites);
                break;
            case ATIRAR:
                this.sprites.add(5, sprites);
                break;
            case MORRER:
                this.sprites.add(6, sprites);
                break;
            default:
                break;
        }
    
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the direcao
     */
    public byte getDirecao() {
        return direcao;
    }

    /**
     * @param direcao the direcao to set
     */
    public void setDirecao(byte direcao) {
        this.direcao = direcao;
    }

    /**
     * @return the transparencia
     */
    public int getTransparencia() {
        return transparencia;
    }

    /**
     * @param transparencia the transparencia to set
     */
    public void setTransparencia(int transparencia) {
        this.transparencia = transparencia;
    }
    
    /**
     * @return the velocidade
     */
    public short getVelocidade() {
        return velocidade;
    }

    /**
     * @param velocidade the velocidade to set
     */
    public void setVelocidade(short velocidade) {
        this.velocidade = velocidade;
    }
    
    @Override
    public void acao(Acao acao){
        
        if(null != acao)switch (acao) {
            case ANDAR:
                this.sprites.get(0).imprimir();
                break;
            case ATACAR:
                this.sprites.get(1).imprimir();
                break;
            case CORRER:
                this.sprites.get(2).imprimir();
                break;
            case CAIR:
                this.sprites.get(3).imprimir();
                break;
            case LESIONADO:
                this.sprites.get(4).imprimir();
                break;
            case ATIRAR:
                this.sprites.get(5).imprimir();
                break;
            case MORRER:
                this.sprites.get(6).imprimir();
                this.sprites.get(6).setLoop(false);
                break;
            default:
                break;
        }
    }
    
}

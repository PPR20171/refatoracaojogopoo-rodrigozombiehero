/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagem;

import personagem.MoverPersonagem;


public class Personagem {
    
    private String nome;
    private byte direcao;
    private int transparencia;
    private short velocidade;
    private MoverPersonagem movendoPersonagem;
    
    public Personagem(String nome){
        this.nome = nome;
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
    
    public MoverPersonagem acao(){
        return movendoPersonagem;
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
}

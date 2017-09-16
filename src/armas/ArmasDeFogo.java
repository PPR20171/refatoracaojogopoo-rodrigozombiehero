package armas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuário
 */
public interface ArmasDeFogo {
    public void atirar();
    public void recarregar();
    public int getDano();
    public int getMunicaoTotal();
    public int getMunicaoPente();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagem;

import personagem.Sprite;
import rodrigoHero.personagem.MoverPersonagem;

public class Andar implements MoverPersonagem{
    
    
    private static Andar instancia = null;
    private Sprite sprite;
    
    private Andar(){}
    
    public static Andar getInstancia(){
        if(instancia == null){
           instancia = new Andar(); 
        }
        return instancia;
    }
    
    @Override
    public Sprite mover (){
        if(sprite==null){
            sprite = new Sprite();
        }
        return sprite;
    }
    
}

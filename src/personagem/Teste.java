/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personagem;

import personagem.Protagonista;
import java.util.Scanner;

/**
 *
 * @author roni
 */
public class Teste {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Protagonista  prot = new Protagonista("Rodrigo");
        while(true){
            
            prot.setDirecao((byte)1);
            prot.setTransparencia(255);
          
            System.out.println(prot.acao().mover());
            System.out.println("\n"+prot.getDirecao());
            System.out.println("\n"+prot.getNome());
            
            System.out.println("Continuar");
            int num = scan.nextInt();
            
            if(num == 0){
                break;
            }
            
        }
    }
  
    
}

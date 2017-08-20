import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    public static final float tam_fonte = 20.0f;
    public static final int largura = 900;
    public static final int altura = 600;
    GreenfootImage[] image = new GreenfootImage[2];    
    public Menu(String mensagem){
        geraTela(mensagem);
    }

    private void geraTela(String mensagem){
        image[0] = new GreenfootImage("images/tela_de_fundo.png");
        image[1]= new GreenfootImage(largura,altura);
        
        image[1].setColor(Color.BLACK);
        image[1].fillRect(0,0,largura,altura);
        //image[1].setColor(new Color(255,255,255,125));
        //image[1].fillRect(5,5,largura-10,altura-10);

         //Font font = image.getFont();
         
         Font font = new Font("Arial Black",true,false,24);
         font = font.deriveFont(tam_fonte);
         image[0].setFont(font);
         image[0].setColor(new Color(255,204,0));
         image[0].drawString(mensagem, 60, 100);
         
         image[1].setFont(font);
         image[1].setColor(new Color(255,204,0));
         image[1].drawString(mensagem, 60, 100);
         
         setImage(image[0]);
    }

    /**
     * Constructor for objects of class Menu.
     * 
     */

    public void act(){
       
    }
}

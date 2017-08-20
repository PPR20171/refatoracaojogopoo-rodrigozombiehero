import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Botoes extends Actor
{

    private static final float tam_fonte = 16.0f;
    private static final int largura = 150;
    private static final int altura = 70;

    public void criaBotao(String textoBotao){
        GreenfootImage image = new GreenfootImage(largura,altura);

        image.setColor(new Color(0,0,0,160));
        image.fillRect(0,0,largura,altura);
        image.setColor(new Color(255,255,255,100));
        image.fillRect(5,5,largura-10,altura-10);

        Font font = image.getFont();
        font = font.deriveFont(tam_fonte);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(textoBotao,20, 40);
        setImage(image);
    }
}

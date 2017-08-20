
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sobre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sobre extends Botoes

{
    private String texto;
    private World world;
    public Sobre(String texto,String titulo){
        criaBotao(titulo);
        this.texto = texto;
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            world=getWorldOfType(TelaInicial.class);
            world.addObject(new MenuClickClose(texto),world.getWidth()/2,world.getHeight()/2); 
        }
    }
    
}

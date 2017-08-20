import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogar extends Botoes

{
    
    private Menu menu;
    private Sobre sobre;
    private Tutorial tutorial;
    private Sair sair;
    
    public Jogar(Menu menu, String texto){
        criaBotao(texto);
        this.menu= menu;
    }
    
    public void setSobre(Sobre sobre){
        this.sobre = sobre;
    }
    
        public void setTutorial(Tutorial tutorial){
        this.tutorial = tutorial;
    }
    
        public void setSair(Sair sair){
        this.sair = sair;
    }

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(menu);
            getWorld().removeObject(tutorial);
            getWorld().removeObject(sobre);
            getWorld().removeObject(sair);
            getWorld().removeObject(this);
        }
    }
}

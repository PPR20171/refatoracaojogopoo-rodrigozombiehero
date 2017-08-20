import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuClickClose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuClickClose extends Menu
{
    /**
     * Act - do whatever the MenuClickClose wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public MenuClickClose(String texto){
        super(texto);
        setImage(image[1]);
    }
    public void act() 
    {
     if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(this);
        }
    }    
}

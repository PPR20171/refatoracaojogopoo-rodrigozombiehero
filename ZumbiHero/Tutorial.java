import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends Botoes

{
    
    private String texto;
    private World world;
    /**
     * Act - do whatever the BotaoBr wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tutorial(String texto, String titulo){
        criaBotao(titulo);
        this.texto=texto;
    }

    public void act() 
    {
       if(Greenfoot.mouseClicked(this)){
            world=getWorldOfType(TelaInicial.class);
            world.addObject(new MenuClickClose(texto),world.getWidth()/2,world.getHeight()/2); 
        }
    }
}  

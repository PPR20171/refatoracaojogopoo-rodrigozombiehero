import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe Next é a classe responsável pelo botão próximo.
 */
public class Next extends Actor
{
    
    GreenfootImage image;
    World world;
    public void addedToWorld(World TelaInicial){
        setImage(image);
    }
    
    public Next(GreenfootImage image,World world){
       this.image=image;
       this.world=world;
    }
    
    /**
     * act método responsável por chamar a classe world quando é clicado no botão próximo.
     */
    public void act() 
    {
        // Add your action code here.
        
        if(Greenfoot.mousePressed(this)){
           isClicked(); 
        }
    }    
    
    public void isClicked(){
         Greenfoot.setWorld(world);
   }
   
   
}

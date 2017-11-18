
package jogorodrigozumbihero.proxys;

import jogorodrigozumbihero.adaptador.AudioAdapter;
import jogorodrigozumbihero.interfaces.Audio;


public class AudioProxy implements Audio{
    
    private Audio audio; 
            
    public AudioProxy(String filename){
        //audio = new AudioAdapter(filename);
    } 
    
    @Override
    public int getVolume(){
        return audio.getVolume();
    }
    @Override
    public boolean estaTocando(){
        return audio.estaTocando();
    }
    @Override
    public void pause(){
        audio.pause();
    }
    @Override
    public void tocar(){
        audio.tocar();
    }
    @Override
    public void  setVolume(int nivel){
        audio.setVolume(nivel);
    }
    @Override
    public void parar(){
        audio.parar();
    }
}

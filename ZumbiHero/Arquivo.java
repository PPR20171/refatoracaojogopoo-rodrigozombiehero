import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**
 * Arquivo é uma classe responsável por guardar informaçoes de: pontuação, áudio e bloqueio das fases.
 */
public class Arquivo{
    private File arquivo; 
    private String dados=" ";
    
    /**
     * construtor da classe.
     */
    public Arquivo(String caminho){
        this.arquivo=new File(caminho);
    }
    
    /**
     * método responsável por salvar os dados no arquivo.
     */
    public void salvar(String dados){
        try{           
           if(!arquivo.exists()){
               File file = new File("arquivos");
               file.mkdir();
               arquivo.createNewFile();
           }           
           OutputStream os = new FileOutputStream(arquivo);
           OutputStreamWriter ow= new OutputStreamWriter(os);
           BufferedWriter bw = new BufferedWriter(ow);
           bw.write(dados);
           bw.close();           
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * método responsável por ler dados do arquivo.
     */
    public String ler(){       
            try{       
           if(arquivo.exists()){
               InputStream is = new FileInputStream(arquivo);
               InputStreamReader ir= new InputStreamReader(is);
               BufferedReader br = new BufferedReader(ir);
               this.dados = br.readLine();              
               br.close();               
           }else{
               arquivo.createNewFile();
             
           }           
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return this.dados;
     }
     
    /**
     * método responsável por apagar os dados do arquivo. 
     */
    public void removeDados(){
        this.dados=" ";
        arquivo.delete();
    }
    
    /**
     * método responsável por retornar o atribudo dados.
     */
    public String getDados(){
            
          return ler();
    }   
}
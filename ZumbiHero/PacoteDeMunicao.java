/**
 * Write a description of class pacoteDeMunicao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacoteDeMunicao  
{
    private int qtdMax;
    private int qtdDisponivel;
    
    public PacoteDeMunicao(int qtdMax){
        this.qtdMax =qtdMax;
        qtdDisponivel=qtdMax;
    }  
    
    public int getQtdDisponivel(){
        return qtdDisponivel;
    }
    
    public int fazerRetirada(int qtd){
        
        if((this.qtdDisponivel-qtd) > 0){
            this.qtdDisponivel-=qtd;
            return qtd;
        }
        qtd = this.qtdDisponivel;
        this.qtdDisponivel=0;
        return qtd;
        
    }
    
    public void setQtdDisponivel(int qtd){
        
        //pega as munições do mundo e adiciona ao pacote 
        if((this.qtdDisponivel+qtd)<=qtdMax){
            this.qtdDisponivel+=qtd;
        }else{
            //pega a quantidaade de munição necessaria e deixa o resto
            int aux = qtdMax-this.qtdDisponivel;
            this.qtdDisponivel+=aux;
        }
        
      }
 }

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author unifrsilva
 */
public class Leucocitos extends Celulas {
    private int velocidade = 2;
    private Date nascimento;
    Random random = new Random();
    
    Leucocitos(){}
    Leucocitos(int x, int y, int cor){
        super(x,y,cor);
        this.velocidade = velocidade;
        this.nascimento = nascimento;
    }
    
    public void mover(){
        /*if(random.nextInt(4)==1){
            setX(getX()+velocidade);
        }
        if(random.nextInt(5)==2){
            setY(getY()+velocidade);
        }
        if(random.nextInt(5)==3){
            setX(getX()-velocidade);
        }
        if(random.nextInt(5)==4){
            setY(getY()-velocidade);
        }*/
        int w,s,a,d;
        switch(random.nextInt(9)){     
            case 1:
                d = getX();
                setX(d + velocidade);
                break;
                
            case 2:
                a = getX();
                setX(a - velocidade);
                break;
                
            case 3:
                w = getY();
                setY(w + velocidade);
                break;
                
            case 4:
                s = getY();
                setY(s - velocidade);
                break;
            case 5:
                s = getY();
                a = getX();
                setY(s - velocidade);
                setX(a - velocidade);
                break;
                
            case 6:
                s = getY();
                d = getX();
                setY(s - velocidade);
                setX(d + velocidade);
                break;
            
            case 7:
                w = getY();
                a = getX();
                setY(w + velocidade);
                setX(a - velocidade);
                break;
                
            case 8:
                w = getY();
                d = getX();
                setY(w - velocidade);
                setX(d + velocidade);
                break;
                
            default:
                
        }
    }
    
    public int getVelocidade(){
        return velocidade;
    }
}

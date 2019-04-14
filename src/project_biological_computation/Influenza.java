/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;
import java.util.Random;
/**
 *
 * @author unifrsilva
 */

public class Influenza extends Virus {
    //Boolean celula;
    //Boolean estaNaCelula(){
        
    //}
    
    Random random = new Random();
    private boolean estaNaCelula = false;
    public Influenza(){}
    
    
    public Influenza(int x, int y, int cor){
        super(x,y,cor);
    }
    
    
    public void mover(){
        int d;
        int w;
        int a;
        int s;
        
        //Direita
        if(random.nextInt(5) == 1){
            d = getX();            
            setX(d + 2);
        }
        //Cima
        if(random.nextInt(5) == 2){
            w = getY();
            setY(w + 2);
        }
        //Esquerda
        if(random.nextInt(5) == 3){
            a = getX();
            setX(a - 2);
        }
        if(random.nextInt(5) == 4){
            s = getY();
            setY(s - 2);
        }
    }   
    
    
    public void setEstaNaCelula(boolean estaNaCelula){
        this.estaNaCelula = estaNaCelula;
    }
    
    
}
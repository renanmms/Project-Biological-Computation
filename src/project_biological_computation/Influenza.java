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
    
    
    Random random = new Random();
    /**
     * Construtor de Influenza
     */
    public Influenza(){}
    
    /**
     * Construtor de Influenza que vai receber a posição e a cor do vírus.
     * @param x
     * @param y
     * @param cor 
     */
    public Influenza(int x, int y, int cor){
        super(x,y,cor);
    }
    
    /**
     * Método implementado através da interface mover, que fará o vírus Influenza se mover.
     */
    public void mover(){
        int d;
        int w;
        int a;
        int s;
        
        
        if(random.nextInt(5) == 1){
            d = getX();            
            setX(d + 2);
        }
        
        if(random.nextInt(5) == 2){
            w = getY();
            setY(w + 2);
        }
       
        if(random.nextInt(5) == 3){
            a = getX();
            setX(a - 2);
        }
        if(random.nextInt(5) == 4){
            s = getY();
            setY(s - 2);
        }
    }   
    
    
    
    
    
}
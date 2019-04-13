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
    private boolean celula;
    public Influenza(){}
    public Influenza(int x, int y, int cor){
        super(x,y,cor);
    }
    
    @Override
    public void mover(){
        int d;
        int w;
        int a;
        int s;
        if(random.nextInt(5)==1){
            d = getX();
            setX(0);
            setX(d + getVelocidade());
            
        }
        if(random.nextInt(5)==2){
            w = getY();
            setY(0);
            setY(w + getVelocidade());
        }
        if(random.nextInt(5)==3){
            a = getX();
            setX(0);
            setX(a - getVelocidade());
        }
        if(random.nextInt(5)==4){
            s = getY();
            setY(0);
            setY(s - getVelocidade());
        }
    }
    
    
}
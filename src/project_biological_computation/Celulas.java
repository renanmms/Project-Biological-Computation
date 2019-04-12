/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;

/**
 *
 * @author unifrsilva
 */
public abstract class Celulas {
    private int x,y,cor;
    Celulas(){}
    Celulas(int cor){
        this.cor = cor;
    }
    Celulas(int x, int y, int cor){
        this.x = x;
        this.y = y;
        this.cor = cor;
    }
    
    public int getCor(){
       return cor;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
}

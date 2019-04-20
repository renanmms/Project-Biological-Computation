/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;

/**
 *
 * @author unifrsilva
 * Classe Abstrata Virus onde é implementa a interface IMoveable que vai fazer com que o vírus se mova.
 * 
 */
public abstract class Virus implements IMoveable{
   private int x,y,velocidade = 2,cor;
   /**
    * Construtor de Virus.
    */
   Virus(){}
   /**
    * Construtor de Virus que recebera posição e cor do virus.
    * @param x
    * @param y
    * @param cor 
    */
   Virus(int x, int y, int cor){
       this.x = x;
       this.y = y;
       this.cor = cor;
   }
   /**
    * Construtor de Virus que receberá posição, cor e velocidade do virus.
    * @param x
    * @param y
    * @param cor
    * @param velocidade 
    */
   Virus(int x, int y,int cor, int velocidade){
       this.x = x;
       this.y = y;
       this.cor = cor;
       this.velocidade = velocidade;
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
   
   public int getVelocidade(){
       return velocidade;
   }
}

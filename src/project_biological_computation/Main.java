/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author unifrsilva
 */
public class Main{
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args)
    {  
        Date tempo = new Date();
        Cabeca c1 = new Cabeca();
        
        int segundos = 0;
       
        for(int i = 0; i < 1000;i++){
            try{ 
                segundos++;
                Thread.sleep(300);        
            }catch(InterruptedException e1){
                e1.printStackTrace();
            }
            
            for(int j = 0;j < 40;j++){
                System.out.println();
            }
            
            System.out.println("\u001B[37m " + "Tempo: " + String.valueOf(segundos) + "\u001B[0m");
            c1.qtdVL();
            
            c1.desenhaCabeca(System.currentTimeMillis());
            
            
        }
    }
}

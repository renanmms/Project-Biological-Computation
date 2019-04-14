/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;
import java.util.ArrayList;


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
        
        Cabeca c1 = new Cabeca();
        
        int segundos = 0;
        
        for(int i = 0; i < 1000;i++){
            try{ 
                segundos++;
                Thread.sleep(1000);        
            }catch(InterruptedException e1){
                e1.printStackTrace();
            }
            
            for(int j = 0;j < 40;j++){
                System.out.println();
            }
            System.out.println("======================================================================");
            System.out.println("\u001B[37m " + "Tempo: " + " " + String.valueOf(segundos) + "\u001B[0m");
            c1.qtdVL();
            c1.desenhaCabeca();
            
        }
    }
}

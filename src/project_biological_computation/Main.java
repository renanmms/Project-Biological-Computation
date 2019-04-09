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
public class Main implements Cores{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Cabeca c1 = new Cabeca();
        //c1.desenhaCabelo();
        
        int mapa[][] = new int[30][60];
        mapa[25][25] = 41;
        
       for(int i = 0 ;i<30;i++){
            for(int j = 0; j<60;j++){
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        } 
        
    
    }
}

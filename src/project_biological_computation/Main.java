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
        
        /*
        i1 = 5
        j1 = 10
        i2 = 10
        j1 = 15
        */
        //preenche olho direito
        for(int i = 4; i<8;i++){//<--VERIFICAR RESULTADOS
            for(int j = 4; j<10 ; j++){//<--VERIFICAR RESULTADOS
                mapa[i][j] = 47;
            }
        }
        //preenche olho esquerdo
        for(int i = 4; i < 8;i++ ){
            for(int j = 32; j<38;j++){
                mapa[i][j] = 47;
            }
        }
        //i=y
        //j=x
        //preenche boca
        for(int i = 26;i>22;i--){
            for(int j = 26;j>12;j--){
                mapa[i][j] = 41; 
            }
        }
        
        //preenche nariz
        for(int i = 15;i<20;i++){
            
        }
        
        
        
       for(int i = 0 ;i<30;i++){
            for(int j = 0; j<60;j++){
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        } 
    }
}

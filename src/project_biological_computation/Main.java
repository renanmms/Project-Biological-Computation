/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
        Timer temporizador = new Timer();
        TimerTask t;
        temporizador.schedule(t,1000);
        //c1.desenhaCabelo();
        
        //int mapa[][] = new int[30][60];
        
        /*
        i1 = 5
        j1 = 10
        i2 = 10
        j1 = 15
        */
        
        //i=y
        //j=x
           
        Thread.sleep();
       c1.desenhaCabeca();
       
       //c1.imprimeMapa();
    }
}

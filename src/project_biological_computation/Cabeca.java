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
public class Cabeca {
    int[][] mapa = new int[30][60];
    CelulasNasais nariz;
    CelulasOculares olhos;
    CelulasBoca boca;
    
    //Para testes
    public void imprimeMapa(){
        for(int i = 0;i<30;i++){
            for(int j = 0; j<60;j++){
                System.out.print(mapa[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    
    
    private void preencherBoca(){
        boca = new CelulasBoca(41);
        for(int i = 20; i<25;i++){//<--VERIFICAR RESULTADOS
            for(int j = 0; j<5 ; j++){//<--VERIFICAR RESULTADOS
                System.out.print("\u001B["+boca.cor+"m");
            }
        }
    }
    
    private void preencherNariz(){
        nariz = new CelulasNasais(44);
        //for(int i = 0; i<;)
        nariz.preenche_mapa_Nariz(25,25,30,35,nariz.cor);
    }
    
    private void preencherBorda(){
    
    }
    
    private void preencherMapa(){
        
    }
    
    public void desenhaCabelo(){
        
    }
}

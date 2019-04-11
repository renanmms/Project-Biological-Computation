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
    CelulasNasais nariz = new CelulasNasais(47);;
    CelulasOculares olhos = new CelulasOculares(44);
    CelulasBoca boca = new CelulasBoca(41);;
    
    //Para testes
    public void imprimeMapa(){
        preencherMapa();
        for(int i = 0;i < 30; i++){
            for(int j = 0; j<60;j++){
                System.out.print(mapa[i][j]+" ");
            }
            System.out.println();
        }
    }
     
    private void preencherBoca(){
        
        for(int i = 26;i>22;i--){
            for(int j = 26;j>12;j--){
                mapa[i][j] = 41; 
            }
        }
    }
    
    private void preencherNariz(){
        //preenche linha abaixo do nariz
        for(int k = 12 ;k < 28; k++){
            mapa[19][k] = 43;
        }
        for(int k = 12 ;k < 28; k++){
            mapa[20][k] = 43;
        }
        for(int i = 15 ;i < 20; i++){
            for(int j = 20; j <25;j++){
                mapa[i][j] = 43;
            }
        }
        
    }
    
    private void preencherOlhos(){
        //preenche olho direito
        for(int i = 4; i < 8; i++){
            for(int j = 4; j < 10 ; j++){
                mapa[i][j] = 44;
            }
        }
        //preenche olho esquerdo
        for(int i = 4; i < 8; i++){
            for(int j = 32; j < 38;j++){
                mapa[i][j] = 44;
            }
        }
    }
    
    private void preencherBorda(){
        //preenche borda esquerda e direita
        for(int b = 0; b < 30; b++){
            mapa[b][0] = 47;
            mapa[b][59] = 47; 
        }
    
        for(int cabelo = 0; cabelo < 60; cabelo++){
            //preenche borda superior e inferior
            mapa[0][cabelo] = 47;
            mapa[29][cabelo] = 47;
        }
    }
    
    private void preencherMapa(){
        preencherBorda();
        preencherOlhos();
        preencherBoca();
        preencherNariz();
    }
    
    public void desenhaCabeca(){
        for(int i = 0; i < 30; i++){
            for(int j = 0;j < 60; j++){
                System.out.println("\u001B["+mapa[i][j]+"m");
            }
        }
    }
}

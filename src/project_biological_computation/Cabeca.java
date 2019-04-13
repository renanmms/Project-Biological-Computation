/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author unifrsilva
 */
public class Cabeca {
    int[][] mapa = new int[30][60];
    Random aleatorio = new Random();
    CelulasNasais nariz = new CelulasNasais(47);;
    CelulasOculares olhos = new CelulasOculares(44);
    CelulasBoca boca = new CelulasBoca(41);
    ArrayList <Leucocitos> leucocitos = new ArrayList<>();
    ArrayList <Influenza> virus = new ArrayList<>();
    
    public void cria(){
        for(int i  = 0 ; i<5; i ++){
            
        }
            
        for(int j = 0; j <11;  j++){
            leucocitos.add(new Leucocitos());
        }
    }
    
    
    public void qtdVL(){
        System.out.println("\u001B[37m"+"Influenza: " + virus.size() + "  " + "Leucocitos: " + leucocitos.size()+"\u001B[0m");
    }
    
    //Cria os virus na posição x e y e gera posições aleatorioas
    public void preencher(){
        for(int i = 0; i < 11;i++){
            try{
                mapa[virus.get(i).getY()][virus.get(i).getX()] = virus.get(i).getCor(); 
            }catch(IndexOutOfBoundsException e1){   
                virus.add( new Influenza(aleatorio.nextInt(59), aleatorio.nextInt(29),45));
            } 
        }
        
        for(int i = 0; i < 6;i++){
            try{
                mapa[leucocitos.get(i).getY()][leucocitos.get(i).getX()] = leucocitos.get(i).getCor();
            }catch(IndexOutOfBoundsException e1){
                leucocitos.add( new Leucocitos(aleatorio.nextInt(59), aleatorio.nextInt(29),46));
            }
        }
    }
    
    public void atualiza(){
        preencher();
        
        for(int i = 0; i < virus.size(); i++){
            virus.get(i).mover();
        }
        
        for(int j = 0; j < leucocitos.size();j++){
            leucocitos.get(j).mover();
        }
    }
    //Cria os leucocitos na posição x e y e gera posições aleatórias
   
    
    //leucocitos.add( new Leucocitos());
    
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
    
    
    //private void preencherVirus()
    private void preencherBoca(){
        for(int i = 24;i>22;i--){
            for(int j = 40;j>15;j--){
                mapa[i][j] = boca.getCor(); 
            }
        }
    }
    
    private void preencherNariz(){
        //preenche linhas abaixo do nariz
        for(int k = 20 ;k < 38; k++){
            mapa[14][k] = nariz.getCor();
        }
        
        for(int k = 20 ;k < 38; k++){
            mapa[15][k] = nariz.getCor();
        }
        
        for(int i = 10 ;i < 15; i++){
            for(int j = 27; j < 32;j++){
                mapa[i][j] = nariz.getCor();
            }
        } 
    }
    
    private void preencherOlhos(){
        //preenche olho direito
        for(int i = 4; i < 8; i++){
            for(int j = 12; j < 18 ; j++){
                mapa[i][j] = olhos.getCor();
            }
        }
        
        //preenche olho esquerdo
        for(int i = 4; i < 8; i++){
            for(int j = 42; j < 48;j++){
                mapa[i][j] = olhos.getCor();
            }
        }
    }
    
    private void preencherBorda(){
        //preenche borda esquerda e direita
        for(int b = 0; b < 30; b++){
            mapa[b][0] = 47;
            mapa[b][59] = 47; 
        }
        
        //preenche borda superior e inferior
        for(int cabelo = 0; cabelo < 60; cabelo++){
            mapa[0][cabelo] = 43;
            mapa[29][cabelo] = 47;
        }
        //barba
        for(int i = 18; i<40;i++){
            for(int j = 0; j<3;j++){
                mapa[j][18] = 43;
                mapa[j][39] = 43;
                mapa[18][i] = 43;
            }
        }
    }
    
    private void preencherMapa(){
        atualiza();
        preencherBorda();
        preencherOlhos();
        preencherBoca();
        preencherNariz();
        
        //criaLeucocitos();
        //criaVirus();
    }
    
    
    //DESENHA
    
    
  
    public void desenhaCabeca(){
        
        preencherMapa();
        
        for(int i = 0; i < 30; i++){
            for(int j = 0;j < 60; j++){
                System.out.print("\u001B["+mapa[i][j]+"m"+" ");
            }
            System.out.println();
        }
    }
    
    
}

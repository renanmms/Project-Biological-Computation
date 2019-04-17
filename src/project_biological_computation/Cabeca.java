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
    int qtd_leucocito = 10;
    int qtd_virus = 5;
   
    Random aleatorio = new Random();
    ArrayList <CelulasBoca> celulas_boca = new ArrayList<>();
    ArrayList <CelulasNasais> celulas_nariz = new ArrayList<>();
    ArrayList <CelulasOculares> celulas_olhos = new ArrayList<>();
    ArrayList <Leucocitos> leucocitos = new ArrayList<>();
    ArrayList <Influenza> virus = new ArrayList<>();//<-- VERIFICAR DEPOIS
   
    public void qtdVL(){
        System.out.println("\u001B[35m"+"\u001B[45m" + " " + "\u001B[0m" + "\u001B[35m" + " Influenza: " + "\u001B[0m" + "\u001B[35m" + (virus.size()) + "\u001B[0m" + "  " + "\u001B[46m"+ " " + "\u001B[0m" + "\u001B[35m"+ " Leucocitos: " + (leucocitos.size())+"\u001B[0m");
    }
    
    ///comentarios
    public void atualiza(int segundos){

        zeraMatriz();
        preencherBorda();
        preencherOlhos();
        preencherBoca();
        preencherNariz();  
        
        for(int i = 0; i < qtd_virus ; i++){
            try{
                mapa[virus.get(i).getY()][virus.get(i).getX()] = virus.get(i).getCor(); 
            }catch(IndexOutOfBoundsException e1){   
                virus.add( new Influenza(aleatorio.nextInt(59), aleatorio.nextInt(29),45));
                mapa[virus.get(i).getY()][virus.get(i).getX()] = virus.get(i).getCor();
            }
            if(virus.get(i).getX() <= 59 && virus.get(i).getX() >= 0 || virus.get(i).getY() >= 0 && virus.get(i).getY() <= 29){
                virus.get(i).mover();
               
            }
            if(virus.get(i).getX() >= 59){
                virus.get(i).setX(0);
            }

            if(virus.get(i).getX() <= 0){
                virus.get(i).setX(59);
            }

            if(virus.get(i).getY() >= 29){
                virus.get(i).setY(0);
            }

            if(virus.get(i).getY() <= 0){
                virus.get(i).setY(29);
            }
            if(colisaoNariz(virus.get(i).getX(),virus.get(i).getY()) || colisaoOlhos(virus.get(i).getX(), virus.get(i).getY()) || colisaoBoca(virus.get(i).getX(),virus.get(i).getY())){
                virus.add(new Influenza(aleatorio.nextInt(59), aleatorio.nextInt(29),45));
                qtd_virus++;
            }
            
            
        }
        
        for(int i = 0; i < qtd_leucocito ; i++){
            try{
                mapa[leucocitos.get(i).getY()][leucocitos.get(i).getX()] = leucocitos.get(i).getCor();
            }catch(IndexOutOfBoundsException e1){
                leucocitos.add( new Leucocitos(aleatorio.nextInt(59), aleatorio.nextInt(29),46));
                mapa[leucocitos.get(i).getY()][leucocitos.get(i).getX()] = leucocitos.get(i).getCor();
            }
            if(leucocitos.get(i).getX() >= 0 && leucocitos.get(i).getX() <= 59 || leucocitos.get(i).getY() >= 30 && leucocitos.get(i).getY() <= 0){
                leucocitos.get(i).mover();
            }
            if(leucocitos.get(i).getX() >= 59){
                leucocitos.get(i).setX(0);
            }

            if(leucocitos.get(i).getX() <= 0){
                leucocitos.get(i).setX(59);
            }
            if(leucocitos.get(i).getY() <= 0){
                leucocitos.get(i).setY(29);
            }
            //leucocitos.get(i).getTempoVida(){}
            if(leucocitos.get(i).getY() >= 29){
                leucocitos.get(i).setY(0);
            }
            
            if(qtd_leucocito < 11){
                leucocitos.add( new Leucocitos(aleatorio.nextInt(59), aleatorio.nextInt(29),46));
                qtd_leucocito++;
            }
            //if(leucocitos.get(i).limiteVida(segundos, leucocitos.get(i).getTempo())){
             //   leucocitos.remove(i);
             //   qtd_leucocito--;
             //   //conta_leucocitos_mortos++;
           // }
            
            for(int j = 0 ; j < qtd_virus; j++){
                try{
                    if(leucocitos.get(i).getX() == virus.get(j).getX() && leucocitos.get(i).getY() == virus.get(j).getY()){
                        virus.remove(j);
                        leucocitos.add( new Leucocitos(aleatorio.nextInt(59),aleatorio.nextInt(29),46));
                        qtd_virus--;
                        qtd_leucocito++;
                    } 
                }catch(IndexOutOfBoundsException e1){
                    leucocitos.add( new Leucocitos(aleatorio.nextInt(59), aleatorio.nextInt(29),46));
                    qtd_leucocito++;
                }   
            }
           
        }      
    }
    
    
    
 
    //Para testes
    public void imprimeMapa(){
        //preencherMapa();
        for(int i = 0; i < 30 ; i++){
            for(int j = 0; j < 60;j++){
                System.out.print(mapa[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    private boolean colisaoBoca(int x, int y){
        if(x >= 18 && x < 40 && y >= 22 && y <= 24 ){
            return true;
        }else{
            return false;
        }
    }
    //Cria o primeiro leucocito e o primeiro virus influenza
    
    private void preencherBoca(){    
        for(int i = 0 ; i< 20;i++){
            celulas_boca.add( new CelulasBoca(41));
            for(int j = 18 ; j < 40;j++){
                mapa[24][j] = celulas_boca.get(i).getCor();
                mapa[23][18] = celulas_boca.get(i).getCor();
                mapa[22][18] = celulas_boca.get(i).getCor();
                mapa[23][39] = celulas_boca.get(i).getCor();
                mapa[22][39] = celulas_boca.get(i).getCor();
            }
        }
    }
    
    private boolean colisaoNariz(int x, int y){
        if(x >= 20 && x < 38 && y >= 14 && y <= 15){
            return true;
        }else{
            return false;
        }
    }
    
    private void preencherNariz(){
       for(int i = 0 ; i < 18; i ++){
           celulas_nariz.add(new CelulasNasais(47));
           for(int j = 20; j < 38;j++){
               mapa[14][j] = celulas_nariz.get(i).getCor();
               mapa[15][j] = celulas_nariz.get(i).getCor();
           }
       }
       
       for( int i = 0; i < 18; i++){
           for(int j = 24; j < 34; j++){
               mapa[13][j] = celulas_nariz.get(i).getCor();
               mapa[12][j] = celulas_nariz.get(i).getCor();
           }
       }
    }
    
    private boolean colisaoOlhos(int x, int y){
        if((x >= 12 && x < 18 || x >= 40 && x < 46) && y == 4){
            return true;
        }else{
            return false;
        }
    }
    
    private void preencherOlhos(){
        for( int i = 0 ; i < 4; i++){
            celulas_olhos.add( new CelulasOculares(44));
            for( int j = 12; j < 18; j++){
                mapa[4][j] = celulas_olhos.get(i).getCor();
            }
        }
        
        for( int j = 40; j  < 46; j++){
            for(int i = 0; i<4;i++){
                mapa[4][j] = celulas_olhos.get(i).getCor();
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
        for(int i = 18; i < 40; i++){
            for(int j = 0; j < 3; j++){
                mapa[j][18] = 43;
                mapa[j][39] = 43;
                mapa[18][i] = 43; 
            } 
        }
    }
    
    
    
    //DESENHA
    public void desenhaCabeca(int segundos){
        atualiza(segundos);
        for(int i = 0; i < 30; i++){
            for(int j = 0;j < 60; j++){
                System.out.print("\u001B[" + mapa[i][j] + "m" + " ");
            }
            System.out.println();
        }
    }
    
    private void zeraMatriz(){
        for(int i = 0; i<30; i++){
            for(int j = 0; j<60; j++){
                mapa[i][j] = 0;
            }
        }
    }
}

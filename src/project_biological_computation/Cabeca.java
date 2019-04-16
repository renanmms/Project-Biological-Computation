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
    int qtd_leucocito = 6;
    int qtd_virus = 11;
    //int[][] mapaOriginal = mapa;
    Random aleatorio = new Random();
    ArrayList <CelulasBoca> celulas_boca = new ArrayList<>();
    ArrayList <CelulasNasais> celulas_nariz = new ArrayList<>();
    ArrayList <CelulasOculares> celulas_olhos = new ArrayList<>();
    ArrayList <Leucocitos> leucocitos = new ArrayList<>();
    ArrayList <Influenza> virus = new ArrayList<>();//<-- VERIFICAR DEPOIS

    public void qtdVL(){
        System.out.println("\u001B[37m"+"Influenza: " + (qtd_virus-1) + "  " + "Leucocitos: " + (qtd_leucocito-1)+"\u001B[0m");
    }
    
    //Cria os virus na posição x e y aleatoria.
    //public void atualiza(int segundos)
    public void atualiza(int segundos){
        int conta_virus_mortos = 0;
        //preenche
        for(int i = 0; i < 30; i++){
            for(int j = 0; j< 60; j++){            
                mapa[i][j]  = 0;
            }   
        }
        
        preencherBorda();
        preencherOlhos();
        preencherBoca();
        preencherNariz();  
        
        for(int i = 0; i < qtd_virus ; i++){
            try{
                mapa[virus.get(i).getY()][virus.get(i).getX()] = virus.get(i).getCor(); 
            }catch(IndexOutOfBoundsException e1){   
                virus.add( new Influenza(aleatorio.nextInt(59), aleatorio.nextInt(29),45));
            }
            if(virus.get(i).getX() < 60 && virus.get(i).getX() > 0 || virus.get(i).getY() > 0 && virus.get(i).getY() < 30){
                virus.get(i).mover();
               
            }
            if(virus.get(i).getX() > 59){
                virus.get(i).setX(0);
            }

            if(virus.get(i).getX() < 0){
                virus.get(i).setX(59);
            }

            if(virus.get(i).getY() > 30){
                virus.get(i).setY(0);
            }

            if(virus.get(i).getY() < 0){
                virus.get(i).setY(29);
            }
            if(colisaoNariz(virus.get(i).getX(),virus.get(i).getY()) || colisaoOlhos(virus.get(i).getX(),virus.get(i).getY()) || colisaoNariz(virus.get(i).getX(),virus.get(i).getY())){
                virus.add(new Influenza(aleatorio.nextInt(59), aleatorio.nextInt(29),45));
                qtd_virus++;
            }
            
            //Verifica colisão com celulas saúdaveis
            
        }
        
        for(int i = 0; i < qtd_leucocito ; i++){
            try{
                mapa[leucocitos.get(i).getY()][leucocitos.get(i).getX()] = leucocitos.get(i).getCor();
            }catch(IndexOutOfBoundsException e1){
                leucocitos.add( new Leucocitos(aleatorio.nextInt(59), aleatorio.nextInt(29),46));
            }
            if(leucocitos.get(i).getX() > 0 && leucocitos.get(i).getX() < 60 || leucocitos.get(i).getY() > 30 && leucocitos.get(i).getY() < 0){
                leucocitos.get(i).mover();
            }
            if(leucocitos.get(i).getX() > 59){
                leucocitos.get(i).setX(0);
            }

            if(leucocitos.get(i).getX() < 0){
                leucocitos.get(i).setX(59);
            }
            if(leucocitos.get(i).getY() < 0){
                leucocitos.get(i).setY(29);
            }
            //leucocitos.get(i).getTempoVida(){}
            if(leucocitos.get(i).getY() > 29){
                leucocitos.get(i).setY(0);
            }
            
            if(qtd_leucocito < 11){
                leucocitos.add( new Leucocitos(aleatorio.nextInt(59), aleatorio.nextInt(29),46));
                qtd_leucocito = qtd_leucocito + 1;
            }
            if(segundos % leucocitos.get(i).getTempoVida() == 0){
                leucocitos.remove(i);
                qtd_leucocito--;
            }
            //Verifica colisão com virus e clona leucocito em uma posição aleatoria
            for(int j = 0 ; j < qtd_virus - conta_virus_mortos; j++){
                /*
                if(leucocitos.get(i).getX() == virus.get(j).getX() && leucocitos.get(i).getY() == virus.get(j).getY()){
                    virus.remove(j);
                    leucocitos.add( new Leucocitos(aleatorio.nextInt(59),aleatorio.nextInt(29),46));
                    qtd_leucocito = qtd_leucocito + 1;
                    conta_virus_mortos = conta_virus_mortos + 1;
                }*/
                //Verificar o que há de errado na multiplicação dos leucocitos (crescendo desenfreadamente)
                if((leucocitos.get(i).getX() == virus.get(j).getX() && leucocitos.get(i).getY() == virus.get(j).getY()) ){
                    virus.remove(j);
                    leucocitos.add( new Leucocitos(aleatorio.nextInt(59),aleatorio.nextInt(29),46));
                    qtd_leucocito = qtd_leucocito + 1;
                    conta_virus_mortos = conta_virus_mortos + 1;
                    //qtd_virus = qtd_virus - conta_virus_mortos;
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
    private void preencherBoca(){
        /*
        for(int i = 0 ; i < 24; i++){
        
            celulas_boca.add( new CelulasBoca(41));}
        
        
        
        for(int i = 24; i > 22 ;i--){
            for(int j = 40;j > 15;j--){
                mapa[i][j] = boca.getCor(); 
            }
        }*/
        
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
        //instancia celulas de nariz
        //for(int j = 0; j<)
        //preenche linhas abaixo do nariz
       /* for(int k = 20 ; k < 38 ; k++){
            mapa[14][k] = nariz.getCor();
        }
        
        for(int k = 20 ; k < 38 ; k++){
            mapa[15][k] = nariz.getCor();
        }
        
        for(int i = 10 ; i < 15 ; i++){
            for(int j = 27; j < 32;j++){
                mapa[i][j] = nariz.getCor();
            }
        }*/
       
       
       
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
        if(x >= 12 && x < 18 && y == 4){
            return true;
        }else{
            return false;
        }
    }
    
    private void preencherOlhos(){
        //preenche olho direito
        /*for(int i = 4; i < 8; i++){
            for(int j = 12; j < 18 ; j++){
                mapa[i][j] = olhos.getCor();
            }
        }
        
        //preenche olho esquerdo
        for(int i = 4; i < 8; i++){
            for(int j = 42; j < 48 ; j++){
                mapa[i][j] = olhos.getCor();
            }
        }*/
        
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
    
    //private void multiplicaLeucocitos(int xVirus, int yVirus, int i){
       // if(leucocitos.get(i).getX() == )
        
    //}
    
    //private void multiplicaVirus(){
    
    //}
    //public void preencherMapa(){
        
        //preencherBorda();
       // preencherOlhos();
       // preencherBoca();
        //preencherNariz();   
      //  atualiza();
    //}
    
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

    //Getters & Setters
    public int[][] getMapa(){
        return mapa;
    }
    
    public void setMapa(int [][] mapa){
        this.mapa = mapa;
    }
}

/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author unifrsilva
 */
public class Cabeca {
    int[][] mapa = new int[30][60];
    int qtd_leucocito = 10;
    int qtd_virus = 5;
    Date data = new Date();
    
    Random aleatorio = new Random();
    ArrayList <CelulasBoca> celulas_boca = new ArrayList<>();
    ArrayList <CelulasNasais> celulas_nariz = new ArrayList<>();
    ArrayList <CelulasOculares> celulas_olhos = new ArrayList<>();
    ArrayList <Leucocitos> leucocitos = new ArrayList<>();
    ArrayList <Influenza> virus = new ArrayList<>();//<-- VERIFICAR DEPOIS
   
    /**
     * Metodo que a imprime Quantidade de Virus e Leucocitos.
     */
    public void qtdVL(){
        System.out.println("\u001B[35m"+"\u001B[45m" + " " + "\u001B[0m" + "\u001B[35m" + " Influenza: " + "\u001B[0m" + "\u001B[35m" + (virus.size()) + "\u001B[0m" + "  " + "\u001B[46m"+ " " + "\u001B[0m" + "\u001B[35m"+ " Leucocitos: " + (leucocitos.size())+"\u001B[0m");
    }
    
   /**
    * Atualiza o programa periodicamente.
    * 
    */
    public void atualiza(long time){

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
            if(virus.get(i).getX() > 59){
                virus.get(i).setX(0);
            }

            if(virus.get(i).getX() < 0){
                virus.get(i).setX(59);
            }

            if(virus.get(i).getY() > 29){
                virus.get(i).setY(0);
            }

            if(virus.get(i).getY() < 0){
                virus.get(i).setY(29);
            }
            if(colisaoNariz(virus.get(i).getX(),virus.get(i).getY()) || colisaoOlhos(virus.get(i).getX(), virus.get(i).getY()) || colisaoBoca(virus.get(i).getX(),virus.get(i).getY())){
                virus.remove(i);
                virus.add( new Influenza(aleatorio.nextInt(59), aleatorio.nextInt(29),45));
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
            if(leucocitos.get(i).getX() > 59){
                leucocitos.get(i).setX(0);
            }

            if(leucocitos.get(i).getX() < 0){
                leucocitos.get(i).setX(59);
            }
            if(leucocitos.get(i).getY() < 0){
                leucocitos.get(i).setY(29);
            }
            
            if(leucocitos.get(i).getY() > 29){
                leucocitos.get(i).setY(0);
            }
            
            if(qtd_leucocito < 11){
                leucocitos.add( new Leucocitos(aleatorio.nextInt(59), aleatorio.nextInt(29),46));
                qtd_leucocito++;
            }
            
            
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
            
            //if(checaTempo(leucocitos.get(i))){
              //  leucocitos.remove(i);
                //qtd_leucocito--;
            //}
            
            //if(leucocitos.get(i).getTempo() == leucocitos.get(i).getTempo() ){
              //  leucocitos.remove(i);
               // qtd_leucocito--;
           // }
            
            
        }        
    }
    
    public boolean checaTempo(Leucocitos l){
        Date data = new Date();
        if(l.getTempo() - System.currentTimeMillis() >= 7000){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Método colisaoBoca que vai verificar se o virus entrou em contato com a boca.
     */
    private boolean colisaoBoca(int x, int y){
        if(x >= 18 && x < 40 && y >= 22 && y <= 24 ){
            return true;
        }else{
            return false;
        }
    }
   
    /**
     * Método preencherBoca vai preencher a matriz mapa.
     */
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
    
    /**
     * 
     * Método colisaoNariz vai verificar se o virus entrou em contato com as células do nariz.
     */
    private boolean colisaoNariz(int x, int y){
        if(x >= 20 && x < 38 && y >= 14 && y <= 15){
            return true;
        }else{
            return false;
        }
    }
    
    
    /**
     * 
     * Método privado preenherNariz vai preencher matriz mapa com 47 para ser usado na hora de desenhar a cabeça.
     */
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
    
    /**
     * 
     * colisaoOlhos vai verificar colisão com os olhos
     */
    private boolean colisaoOlhos(int x, int y){
        if((x >= 12 && x < 18 || x >= 40 && x < 46) && y == 4){
            return true;
        }else{
            return false;
        }
    }
    
    /**preencherOlhos vai preencher a matriz mapa com 44 para ser desenhada na cabeça.*/
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
    /**
     * preencherBorda vai preencher as bordas da cabeça.
     */
    private void preencherBorda(){
        
        for(int b = 0; b < 30; b++){
            mapa[b][0] = 47;
            mapa[b][59] = 47; 
        }
        
        
        for(int cabelo = 0; cabelo < 60; cabelo++){
            mapa[0][cabelo] = 43;
            mapa[29][cabelo] = 47;
        }
        
        
        for(int i = 18; i < 40; i++){
            for(int j = 0; j < 3; j++){
                mapa[j][18] = 43;
                mapa[j][39] = 43;
                mapa[18][i] = 43; 
            } 
        }
    }
    
    
    
    /**
     * desenhaCabeca vai desenhar a cabeça lendo os números correspondentes as cores designadas nas células, virus, e leucocitos.
     */
    public void desenhaCabeca(long time){
        atualiza(time);
        for(int i = 0; i < 30; i++){
            for(int j = 0;j < 60; j++){
                System.out.print("\u001B[" + mapa[i][j] + "m" + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * zeraMatriz vai zerar a matriz para ser repreenchida novamente.
     */
    private void zeraMatriz(){
        for(int i = 0; i<30; i++){
            for(int j = 0; j<60; j++){
                mapa[i][j] = 0;
            }
        }
    }
}

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_biological_computation;
import java.util.Date;

/**
 *
 * @author unifrsilva
 */
public class Leucocitos extends Celulas {
    private int velocidade;
    private Date nascimento;
    
    Leucocitos(int x, int y, int cor){
        super(x,y,cor);
        this.velocidade = velocidade;
        this.nascimento = nascimento;
    }
    
    public void mover(){
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade1_marcio;

/**
 *
 * @author HawK_
 */
public class Atividade1_Marcio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafos g = new Grafos(5);
        g.addAresta("A", "A");
        g.addAresta("A", "B");
        g.addAresta("A", "C");
        g.addAresta("A","D");
        g.addAresta("C", "E");        
        g.addAresta("D", "C");        
                       
        g.exibirSucessores();
        
        boolean resp = g.verificarVizinhos("A", "E");
        if(resp==true){
            System.out.println("Sao vizinhos");
        }else{
            System.out.println("Não são vizinhos");
        }
    }
    
}

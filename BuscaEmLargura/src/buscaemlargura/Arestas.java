/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaemlargura;

import java.util.LinkedList;

/**
 *
 * @author HawK_
 */
public class Arestas {
    private final LinkedList<Arestas> vet;
    private String indice;
     
    public Arestas(String v){
        vet = new LinkedList<Arestas>();
        indice = v;
    }
    
    public String getInfo(){
        return indice;
    }
    
    public void addSucessor(Arestas a){
        vet.add(a);
    }
    
    public void exibirArestas(){
        for(int i=0;i<vet.size();i++){
            System.out.println(vet.get(i)+" / ");
        }
    }
    
    public String[] getSucessores() {
        String m[] = new String[vet.size()];
        for(int i=0;i<vet.size();i++){
            m[i] = vet.get(i).getInfo();
        }
        return m;
    }
    
    public String toString() {
        return "Índice= " + indice;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaemlargura;

import java.util.ArrayList;

/**
 *
 * @author HawK_
 */
public class Grafos {
    int V;
    private ArrayList<Arestas> lista;
    
    public Grafos(int v){
        this.V=v;
        lista = new ArrayList<Arestas>(v);       
    }
    
    public void addAresta(String indice, String destino){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getInfo().equals(indice)){                
                lista.get(i).addSucessor(new Arestas(destino));
                return;
            }
        }
        Arestas a = new Arestas(indice);
        lista.add(a);
        a.addSucessor(new Arestas(destino));        
    }
    
    public void exibirSucessores(){
        for(int i=0;i<lista.size();i++){
            System.out.println("O sucessores do vertice "+ lista.get(i).getInfo());
            lista.get(i).exibirArestas();
            System.out.println();
        }
    }
    public boolean verificarVizinhos(String indice, String destino){
        for(int i=0;i<lista.size();i++){            
            if(lista.get(i).getInfo().equals(indice)){
                String vet[] = lista.get(i).getSucessores();
                for(int j=0;j<vet.length;j++){
                    if(vet[j].equals(destino)){
                        return true;
                    }
                }
                
            }
        }
        return false;
    }
}

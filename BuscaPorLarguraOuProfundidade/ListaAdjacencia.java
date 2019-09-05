/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadegrafo2;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HawK_
 */
public class ListaAdjacencia implements Grafo{
    List<Arestas>[] listadj;
    int numVertices;

    public ListaAdjacencia(int numVertices) {
        listadj = new LinkedList[numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            listadj[i] = new LinkedList<>();
        }
    }
    
    @Override
    public void addAresta(int origem, int destino) throws Exception{
        listadj[origem].add(new Arestas(origem, destino));
    }
    @Override
    public boolean exiteAresta(int origem, int destino){
        for(Arestas a: listadj[origem]){
            if(a.getDestino() == destino){
                return true;
            }
        }
        return false;
    }
    @Override
    public int numeroVertices(){
        return numVertices;
    }
    @Override
    public int numeroDeArestas(){
        int cont=0;
        for(int i=0;i<listadj.length;i++){
            cont+=listadj[i].size();
        }
        return cont;
    }
    @Override
    public List<Integer> listDeAdjacentes(int vertice) throws Exception {
        List<Integer> listDeAdjacentes = new LinkedList<>();
        for (Arestas a : listadj[vertice]) {
            listDeAdjacentes.add(a.getDestino());
        }
        
        Collections.sort(listDeAdjacentes);
        return listDeAdjacentes;
    }
    @Override
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception {
        Set<Integer> conjuntoDeAdjacentes = new HashSet<>();
        for (Arestas a : listadj[vertice]) {
            conjuntoDeAdjacentes.add(a.getDestino());
        }
        return conjuntoDeAdjacentes;
    }
    @Override
    public void exibirArestas(){
        for(int i=0;i<listadj.length;i++){
            try{
                System.out.println("Vertice "+i+" : "+listDeAdjacentes(i).toString());
            }catch(Exception ex){
                Logger.getLogger(ListaAdjacencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadegrafo2;

import java.util.List;
import java.util.Set;

/**
 *
 * @author HawK_
 */
public interface Grafo {
    
    public void addAresta(int origem, int destino) throws Exception;
    
    public boolean exiteAresta(int origem, int destino);
    
    public int numeroVertices();
    
    public int numeroDeArestas();
    
    public List<Integer> listDeAdjacentes(int vertice) throws Exception;
    
    public Set<Integer> conjuntoDeAdjacentes(int vertice) throws Exception;
    
    public void exibirArestas();
}

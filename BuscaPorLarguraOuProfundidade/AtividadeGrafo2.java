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
public class AtividadeGrafo2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        ListaAdjacencia l = new ListaAdjacencia(6);        
        l.addAresta(0, 1);
        l.addAresta(0, 4);
        l.addAresta(1, 0);
        l.addAresta(1, 2);
        l.addAresta(1, 4);
        l.addAresta(2, 1);        
        l.addAresta(2, 3);
        l.addAresta(3, 2);
        l.addAresta(3, 4);
        l.addAresta(4, 0);
        l.addAresta(4, 1);
        l.addAresta(4, 3);
        l.addAresta(5, 3);
        
        l.exibirArestas();       
        
        
        System.out.println("numero de vertices: "+l.numeroVertices());
        System.out.println("numero de arestas: "+l.numeroDeArestas());
        
        BuscaLargura b;
        b = new BuscaLargura(l, 0);
        System.out.println("");
        b.resultado();
        System.out.println("");
        b = new BuscaLargura(l, 1);
        System.out.println("");
        b.resultado();
        System.out.println("");
        b = new BuscaLargura(l, 3);
        System.out.println("");
        b.resultado();
        
        BuscarProfundidade p = new BuscarProfundidade();
        System.out.println("");
        p.dfs(l);
    }
    
}

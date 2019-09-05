/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadegrafo2;

import java.util.Set;

/**
 *
 * @author HawK_
 */
public interface Profundidade {
    public Set<Arestas> arestasDeArvore(Grafo g);
    public Set<Arestas> arestasDeRetorno(Grafo g);
    public Set<Arestas> arestasDeCruzamento(Grafo g);
    public Set<Arestas> arestasDeAvanco(Grafo g);
    public int tempoDescoberta(int origem);
    public int tempoFinalizacao(int destino);
    public boolean existeCiclo(Grafo g);
}

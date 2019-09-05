/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadegrafo2;

/**
 *
 * @author HawK_
 */
public class BuscaLargura implements Largura{
    private int cor[];//0 = branco  1 = cinza  2 = preto
    private int pai[];
    private int d[];
    private int verticeInicial, numVertices;
    Fila Q;
    
    public BuscaLargura(Grafo g, int s) throws Exception{
        verticeInicial =s;
        numVertices = g.numeroVertices();
        pai = new int[numVertices];
        cor = new int[numVertices];
        d = new int[numVertices];
        Q = new Fila(numVertices);
        int i;
        for(i=0;i<numVertices;i++){
            pai[i]=-1;
            cor[i]=0;
            d[i]=-1;
        }        
        cor[s]=1;
        d[s]=0;
        pai[s]=-1;
        Q.enFileira(s);
        int u;
        while(!Q.vazia()){
            u = Q.desenFileira();
            for(int v : g.listDeAdjacentes(u)){
                if(cor[v]==0){
                    cor[v]=1;
                    d[v]= d[u]+1;
                    pai[v]=u;
                    Q.enFileira(v);
                }
            }
            cor[u]=2;
        }        
    }
    public void resultado() {
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertice: " + i + " pai: " + pai[i] + " d: " + d[i] + " cor: " + cor[i]);
        }
    }
    
    @Override
    public Integer predecessor(int vertice) {
        return pai[vertice];
    }

    @Override
    public Integer distanciaParaOrige(int vertice) {
        return d[vertice];
    }

    public int getCor(int vertice) {
        return cor[vertice];
    }

    public int getPai(int vertice) {
        return pai[vertice];
    }

    public int getDistancia(int vertice) {
        return d[vertice];
    }
}

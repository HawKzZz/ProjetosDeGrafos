/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadegrafo2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HawK_
 */
public class BuscarProfundidade implements Profundidade{
    private boolean buscaRealizada = false;
    private int[] cor;
    private int[] tempoDescoberta;
    private int[] tempoFinalizacao;
    private int numVertices;
    private Set<Arestas> arestasDeArvore;
    private Set<Arestas> arestasDeAvanco;
    private Set<Arestas> arestasDeCruzamento;
    private Set<Arestas> arestasDeRetorno;
    private Grafo g;
    private int tempo = 0;
    
    public void dfs(Grafo g) throws Exception{
        this.g=g;
        this.numVertices = g.numeroVertices();
        this.cor= new int[numVertices];
        this.tempoDescoberta = new int[numVertices];
        this.tempoFinalizacao = new int[numVertices];
        
        arestasDeArvore = new HashSet<>();
        arestasDeAvanco = new HashSet<>();
        arestasDeCruzamento = new HashSet<>();
        arestasDeRetorno = new HashSet<>();
        int i;
        
        for(i=0;i<cor.length;i++){
            cor[i]=0;
        }
        this.tempo=0;
        for(i=0;i<numVertices;i++){
            if(cor[i]==0){
                visit(i);
            }
        }
        this.buscaRealizada=true;
        escreveBusca();
    }

    private void visit(int u) throws Exception{
        cor[u]=1;
        tempo++;
        List<Integer>adj = g.listDeAdjacentes(u);
        for(int v : adj){
            if(cor[v]==1){
                arestasDeRetorno.add(new Arestas(u,v));
            }
            if(cor[v]==2){
                if(tempoDescoberta[u]< tempoDescoberta(v)){
                    arestasDeAvanco.add(new Arestas(u,v));
                }else{
                    arestasDeCruzamento.add(new Arestas(u,v));
                }
            }
            if(cor[v]==0){
                arestasDeArvore.add(new Arestas(u,v));
                visit(v);
            }
        }
        cor[u]=2;
        tempo++;
        tempoFinalizacao[u]=tempo;        
    }
    
    @Override
    public Set<Arestas> arestasDeArvore(Grafo g){
        if(!this.buscaRealizada){
            try{
                dfs(g);
            }catch(Exception ex){
                Logger.getLogger(BuscarProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeArvore;
    }
    
    @Override
    public Set<Arestas> arestasDeRetorno(Grafo g){
        if(!this.buscaRealizada){
            try{
                dfs(g);
            }catch(Exception ex){
                Logger.getLogger(BuscarProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeRetorno;
    }
    
    @Override
    public Set<Arestas> arestasDeCruzamento(Grafo g){
        if(!this.buscaRealizada){
            try{
                dfs(g);
            }catch(Exception ex){
                Logger.getLogger(BuscarProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeCruzamento;
    }
    
    @Override
    public Set<Arestas> arestasDeAvanco(Grafo g){
        if(!this.buscaRealizada){
            try{
                dfs(g);
            }catch(Exception ex){
                Logger.getLogger(BuscarProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeAvanco;
    }
    
    @Override
    public int tempoDescoberta(int origem){
        return tempoDescoberta[origem];
    }
    
    @Override
    public int tempoFinalizacao(int destino){
        return tempoFinalizacao[destino];
    }
    
    @Override
    public boolean existeCiclo(Grafo g){
        if(arestasDeRetorno.size() > 0){
            return true;
        }
        return false;
    }
    
    public void escreveArestas(Set<Arestas> arestas){
        for(Arestas a : arestas){
            System.out.println(a.getOrigem()+"\t"+a.getDestino());
        }
    }
    
    private void escreveBusca() {
        System.out.println("Vértice | Cor | D | F");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + "\t   " + cor[i] + "\t" + tempoDescoberta[i] + " / " + tempoFinalizacao[i]);
        }
    }
    
    
}

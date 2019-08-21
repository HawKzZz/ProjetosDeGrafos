/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade1_marcio;

import java.util.HashMap;

/**
 *
 * @author HawK_
 */
public class GrafosMatriz {

    private HashMap<String, Integer> list;
    private int m[][];

    public GrafosMatriz(int n) {
        list = new HashMap<String, Integer>();
        m = new int[n][n];
    }

    public void addAresta(String indice, String destino) {
        if (list.isEmpty() || !list.containsKey(indice)) {
            list.put(indice, list.size());
        }
        if (!list.containsKey(destino)) {
            list.put(destino, list.size());
        }
        m[list.get(indice)][list.get(destino)] = 1;
    }

    public void showMatriz() {
        for (int i = 0; i < m.length; i++) {
            System.out.println();
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j]);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaemlargura;

/**
 *
 * @author HawK_
 */
public class Fila {
    int tamanho=0;
    int l=0;
    
    int fila[];
    
    public Fila(int tam){
        this.fila = new int[tam];
    }
    
    public void emFileira(int v){
        int i;
        if(tamanho > 0){
            i = l-1;
            while(v<fila[i] &&  i>0){
                i--;
            }
             for (int j = l; j > i; j--) {
                fila[j] = fila[j - 1];
            }
            fila[i + 1] = v;
            l++;
            tamanho++;
        }else{
            fila[l] = v;
            l++;
            tamanho++;
        }
    }
    
    public int desenFileira(){
        if(tamanho>0){
            int c = fila[0];
            for (int i = 0; i < l - 1; i++) {
                fila[i] = fila[i + 1];
            }
            l--;
            tamanho--;            
            return c;
        } else {
            System.out.println("Fila vazia");
            return -1;
        }        
    }
    
    public void mostra() {
        System.out.println("");
        for (int i = 0; i < this.l; i++) {

            System.out.print(fila[i]);

            if (i + 1 < l) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }

    public boolean vazia() {
        return !(tamanho > 0);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.numero.checarMaiorNumero;

/**
 *
 * @author Cássio Gabriel
 */
public class MaiorNumero {

    public int checaMaiorNumero(String numeros) {
        String[] split = numeros.split(" "); //Criar um vetor com números, aonde o separador é o espaço
        int[] listaNumeros = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            listaNumeros[i] = Integer.parseInt(split[i]);
        }
        int max = listaNumeros[0];
        for (int i = 1; i < listaNumeros.length; i++) {
            if (listaNumeros[i] > max) {
                max = listaNumeros[i];
            }
        }
        return max;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.numero.checarMaiorNumero;

import javax.swing.JOptionPane;

/**
 *
 * @author Cássio Gabriel
 */
public class TestaMaiorNumero {

    public static void main(String[] args) {
        String numeros;
        numeros = JOptionPane.showInputDialog("Informe os números, separando-os com espaço: ");
        MaiorNumero maiorNumero = new MaiorNumero();
        int maior = maiorNumero.checaMaiorNumero(numeros);
        JOptionPane.showMessageDialog(null, "Maior número é: " + maior);

        /////////////////////////////////////////////////Outra maneira de fazer//////////////////////////////////////////////////////////////

//		JOptionPane.showMessageDialog(null, "Maior número é " + new MaiorNumero().checaMaiorNumero(JOptionPane.showInputDialog("Informe os números, separando-os com espaço: ")));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.numero.checarCaractere;

import javax.swing.JOptionPane;

/**
 *
 * @author Cássio Gabriel
 */
public class TestaChecaCaractere {

    public static void main(String[] args) {
        System.out.println(new ChecaCaracatere().ehInteiro(JOptionPane.showInputDialog("Digite:")));
    }
}

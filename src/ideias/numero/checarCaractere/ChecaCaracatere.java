/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.numero.checarCaractere;

/**
 *
 * @author Cássio Gabriel
 */
public class ChecaCaracatere {

    public boolean ehInteiro(String s) {
        // cria um array de char
        char[] c = s.toCharArray();
        boolean d = true;
        System.out.println(c.length);
        for (int i = 0; i < c.length; i++) {
            if (!Character.isDigit(c[i])) { // verifica se o char não é um dígito
                d = false;
                break;
            }
        }
        return d;
    }
}

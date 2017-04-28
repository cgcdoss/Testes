/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.cpf;

import javax.swing.JOptionPane;

/**
 *
 * @author Cássio Gabriel
 */
public class ExecutaTesteCpf {

    public static void main(String[] args) {
        String ler = JOptionPane.showInputDialog(null, "Digite seu CPF");

        String CPF;

        CPF = ler;

// usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
        if (ValidaCpf.isCPF(CPF) == true) {
            System.out.printf("CPF válido! %s\n", ValidaCpf.imprimeCPF(CPF));
        } else {
            System.out.printf("Erro, CPF invalido !!!\n");
        }
    }

}

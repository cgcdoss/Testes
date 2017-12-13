/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.encapsulamento;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cássio Gabriel
 */
public class ExecutaEncapsulamento {

    public static void main(String[] args) {
        TesteEncapsulamento te = new TesteEncapsulamento();

        for (Field declaredField : te.getClass().getDeclaredFields()) {
            System.out.println(declaredField);
        }

        TesteEncapsulamento idade = (TesteEncapsulamento) createNewInstance(TesteEncapsulamento.class);

        if (idade == null) {
            System.err.println("Ops, não foi possível criar o objeto cliente");
        } else {
            System.out.println("Objeto cliente criado = " + idade.toString());
        }

    }

    private static Object createNewInstance(Class clazz) {
        Constructor<?> ctor;
        try {
            ctor = clazz.getConstructors()[0];
            Object object = ctor.newInstance();
            return object;
        } catch (SecurityException
                | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}

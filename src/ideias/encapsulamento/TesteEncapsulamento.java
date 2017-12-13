/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.encapsulamento;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

/**
 *
 * @author Cássio Gabriel
 */
public class TesteEncapsulamento {

    Idade idade = new Idade();
    
    public String diaDoMes(Calendar c) {
        System.out.println(idade.getClass().getName().getBytes());
        return new Util().dateDiffIdade(c, c).getAAMMDD();
    }

    public class Idade {

        private final NumberFormat tempo = new DecimalFormat("000000");
        int dias;
        int meses;
        int anos;

        public String getAAMMDD() {
            int idade = getAnos() * 10000 + getMeses() * 100 + getDias();
            return tempo.format(idade);
        }

        public int getDias() {
            return dias;
        }

        public void setDias(int dias) {
            this.dias = dias;
        }

        public int getMeses() {
            return meses;
        }

        public void setMeses(int meses) {
            this.meses = meses;
        }

        public int getAnos() {
            return anos;
        }

        public void setAnos(int anos) {
            this.anos = anos;
        }

    }

    public class Util {
        public Idade dateDiffIdade(Calendar dataTermino, Calendar dataInicio) {
            Calendar data1 = (Calendar) dataTermino.clone();
            data1.set(Calendar.HOUR_OF_DAY, 0);
            data1.set(Calendar.MINUTE, 0);
            data1.set(Calendar.SECOND, 0);
            data1.set(Calendar.MILLISECOND, 0);
            Calendar data2 = (Calendar) dataInicio.clone();
            data2.set(Calendar.HOUR_OF_DAY, 0);
            data2.set(Calendar.MINUTE, 0);
            data2.set(Calendar.SECOND, 0);
            data2.set(Calendar.MILLISECOND, 0);

            Idade idade = new Idade();
            Calendar data = (Calendar) data2.clone();

            for (data.add(Calendar.DAY_OF_MONTH, 1); !data.after(data1); data.add(Calendar.DAY_OF_MONTH, 1)) {
                idade.setDias(idade.getDias() + 1);
                boolean ultimoDiaMes = false;
                if (data.getActualMaximum(Calendar.DAY_OF_MONTH) == data.get(Calendar.DAY_OF_MONTH)) {
                    if (data2.get(Calendar.DAY_OF_MONTH) > data.get(Calendar.DAY_OF_MONTH)) {
                        ultimoDiaMes = true;
                    }
                }
                if (data2.get(Calendar.DAY_OF_MONTH) == data.get(Calendar.DAY_OF_MONTH) || ultimoDiaMes) {
                    idade.setMeses(idade.getMeses() + 1);
                    idade.setDias(0);
                    if (idade.getMeses() > 11) {
                        idade.setAnos(idade.getAnos() + 1);
                        idade.setMeses(0);
                    }
                }

            }
            return idade;
        }
    }
}

package examen.ejercicio1;

import javax.swing.JOptionPane;

/**
 *
 * @author galle
 */
public class ExamenEjercicio1 {

    //Codificado por: sAfOrAs
    //LIstar los numeros según el numero de digitos indicado
    //Considero solo hasta numeros menores a 100000 (5 digitos), 
    //por el hecho de k buscar numeros primos a partir de 6 digitos, el proceso se hace muy lento.

    public static boolean p = false;

    public static void main(String arg[]) {
        int digitos = introduccionNumeroDigito();
        int nDigitos = 0;
        if (digitos <= 0) {
            System.out.println("Ingrese como parámetro, un numero de digitos correcto (mayor que 0): ");
        }
        for (int i = 1; i <= 99999; i++) {
            int contador = metodo2(i);
            nDigitos = contador;

            if (nDigitos == digitos) {
                if (i < 4) {
                    p = true;
                } else {
                    if (i % 2 == 0) {
                        p = false;
                    } else {
                        int contador2 = 0;
                        int i2 = 1;
                        int k = (i - 1) / 2;
                        if (k % 2 == 0) {
                            k--;
                        }

                        contador2 = metodo1(i2, k, i, contador2);

                        if (contador2 == 1) {
                            p = true;
                        }
                    }
                }

                if (p == true) {
                    System.out.println(i);
                }
            }
        }
    }

    public static int metodo2(int i) {
        int aux = i;
        int contador = 0;
        while (aux != 0) {
            aux = aux / 10;
            contador++;
        }
        return contador;
    }

    public static int metodo1(int i2, int k, int i, int contador2) {
        while (i2 <= k) {
            if (i % i2 == 0) {
                contador2++;
            }
            i2 += 2;
            if (contador2 == 2) {
                i2 = k + 1;
            }
        }
        return contador2;
    }

    public static int introduccionNumeroDigito() {
        int numero;
        do {
            numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de digitos a mostrar"));
        } while (numero > 5 | numero < 1);
        return numero;
    }

}

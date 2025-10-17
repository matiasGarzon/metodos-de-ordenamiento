
package metodosordenamientoss;

import java.util.Random;
import java.util.Scanner;

public class Vector {

    private Scanner teclado = new Scanner(System.in);
    private Random random = new Random();
    private int[] vector;
    private int size;
    private double[][] resultados = new double[9][4];
    public double[][] resultados() {
        return resultados;
    }
    public Vector(int tamano) {
        vector = new int[tamano];
        size = 0;
    }
    public void ascendentes(){
        ordenamientoBurbujaAscendente(resultados);
        insercionBinaria(resultados);
        burbujaMejoradaAscendente();
    }
    public void descendentes(){
        ordenamientoBurbujaDescendete(resultados);
        insercionBinaria(resultados);
        burbujaMejoradaDescendente();
    }

    public Vector() {
        vector = new int[0];
        size = 0;
    }

    public void cargarVector(String mensaje) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println(mensaje);
            vector[i] = teclado.nextInt();
            size++;
        }
    }

    public double[][] ordenamientoBurbujaAscendente(double[][] resultados) {
        double oE = 0;
        double intercambios = 0;
        double comparaciones = 0;
        oE++; // asignacion: i = 0
        oE++; // asignacion j = 0
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size - 1; i++) {
            oE += 2; // comparacion y resta: i < size - 1
            oE += 2; // i++, asignacion y suma
            comparaciones++; //i < size - 1

            for (int j = 0; j < size - i - 1; j++) {
                oE += 3; // comparacion y  2 restas: j < size - i - 1
                oE += 2; //j++, asignacion y suma
                comparaciones++; //i < size - 1
                comparaciones++; //j < size - i - 1
                oE += 4; // 2 accesos a vector, comparacion y suma: vector[j] > vector[j + 1]
                comparaciones++; // comparacion de los vectores
                if (vector[j] > vector[j + 1]) {
                    intercambiar(j, j + 1);
                    oE = oE + 8; // operaciones elementales del metodo interxambiar
                    intercambios++;
                }
                oE += 3; // comparacion y  2 restas: j < size - i - 1
                comparaciones++; //j < size - i - 1
                oE += 2; // suma y aignacion: j++  
            }
            oE += 2; // comparacion y resta: i < size - 1
            oE += 2; // suma y aignacion: i++
        }
        oE += 2; // comparacion y resta: i < size - 1 (ultima vuelta)
        oE += 2; // i++, asignacion y suma (ultima vuelta)
        comparaciones++; //i < size - 1 (ultima vuelta)
        oE += 3; // comparacion y  2 restas: j < size - i - 1 (ultima vuelta)
        oE += 2; //j++, asignacion y suma (ultima vuelta)
        comparaciones++; //i < size - 1 (ultima vuelta)
        comparaciones++; //j < size - i - 1 (ultima vuelta)

        long endTime = System.currentTimeMillis(); // Tiempo de finalización
        long duracion = endTime - startTime; // Duración en milisegundos
        
        long duracionS= duracion/1000;
        

        resultados[0][0]= (double) duracionS;
        resultados[0][1] = oE;
        resultados[0][2] = comparaciones;
        resultados[0][3] = intercambios;
        return resultados;
    }
    
         public double[][] ordenamientoBurbujaDescendete(double[][] resultados) {
        double oE = 0;
        double intercambios = 0;
        double comparaciones = 0;
        oE++; // asignacion: i = 0
        oE++; // asignacion j = 0
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size - 1; i++) {
            oE += 2; // comparacion y resta: i < size - 1
            oE += 2; // i++, asignacion y suma
            comparaciones++; //i < size - 1

            for (int j = 0; j < size - i - 1; j++) {
                oE += 3; // comparacion y  2 restas: j < size - i - 1
                oE += 2; //j++, asignacion y suma
                comparaciones++; //i < size - 1
                comparaciones++; //j < size - i - 1
                oE += 4; // 2 accesos a vector, comparacion y suma: vector[j] > vector[j + 1]
                comparaciones++; // comparacion de los vectores
                if (vector[j] < vector[j + 1]) {
                    intercambiar(j, j + 1);
                    oE = oE + 8; // operaciones elementales del metodo interxambiar
                    intercambios++;
                }
                oE += 3; // comparacion y  2 restas: j < size - i - 1
                comparaciones++; //j < size - i - 1
                oE += 2; // suma y aignacion: j++  
            }
            oE += 2; // comparacion y resta: i < size - 1
            oE += 2; // suma y aignacion: i++
        }
        oE += 2; // comparacion y resta: i < size - 1 (ultima vuelta)
        oE += 2; // i++, asignacion y suma (ultima vuelta)
        comparaciones++; //i < size - 1 (ultima vuelta)
        oE += 3; // comparacion y  2 restas: j < size - i - 1 (ultima vuelta)
        oE += 2; //j++, asignacion y suma (ultima vuelta)
        comparaciones++; //i < size - 1 (ultima vuelta)
        comparaciones++; //j < size - i - 1 (ultima vuelta)

        long endTime = System.currentTimeMillis(); // Tiempo de finalización
        long duracion = endTime - startTime; // Duración en milisegundos
        
        long duracionS= duracion/1000;
        

        resultados[0][0]= (double) duracionS;
        resultados[0][1] = oE;
        resultados[0][2] = comparaciones;
        resultados[0][3] = intercambios;
        return resultados;
    }

    public double[][] insercionBinaria(double[][] resultados) {
        double oE = 0;
        double intercambios = 0;
        double comparaciones = 0;
        long startTime = System.currentTimeMillis();

        oE++; // asignacion: i = 1

        for (int i = 1; i < size; i++) {
            oE += 2; // comparacion  i < size y suma
            oE += 2; // i++, asignacion y suma
            comparaciones++; //i < size - 1
            int aux = vector[i];
            oE += 2; // asignacion y acceso a vector
            int primero = 0;
            oE++; // asignacion
            int ultimo = i - 1;
            oE += 2; //asignacion y resta

            while (primero <= ultimo) {
                oE++; //comparacion
                comparaciones++; //comparacion
                int c = (primero + ultimo) / 2;
                oE += 3; // asignacion. suma y division

                oE += 2; // comparacion y acceso
                comparaciones++;
                if (aux < vector[c]) {
                    ultimo = c - 1;
                    oE += 2; // asignacion y resta
                } else {
                    primero = c + 1;
                    oE += 2; // asignacion y suma
                }
            }
            oE++; //comparacion (ultima vuelta while)
            comparaciones++; //comparacion (ultima vuelta while)

            oE += 2; // asignacion y resta j=1-1
            for (int j = i - 1; j >= primero; j--) {
                oE += 3; // comparacion y resta y asignacion
                comparaciones++;
                vector[j + 1] = vector[j];
                oE += 4; // acceso, suma, asignacion y acceso
                intercambios++;
            }
            vector[primero] = aux;
            oE += 2; // acceso y asignacion
            intercambios++;
        }
        oE += 2; // comparacion  i < size y suma (ultima vuelta for)
        oE += 2; // i++, asignacion y suma (ultima vuelta for)
        comparaciones++; //i < size - 1 (ultima vuelta for)

        long endTime = System.currentTimeMillis(); // Tiempo de finalización
        long duracion = endTime - startTime; // Duración en milisegundos

        long duracionS = duracion / 1000;

        resultados[1][0] = (double) duracionS;
        resultados[1][1] = oE;
        resultados[1][2] = comparaciones;
        resultados[1][3] = intercambios;
        return resultados;

    }

    public void burbujaMejoradaAscendente() {
        boolean huboIntercambio;
        int n = size - 1;
        do {
            huboIntercambio = false;
            for (int i = 0; i < n; i++) {
                if (vector[i] > vector[i + 1]) {
                    intercambiar(i, i + 1);
                    huboIntercambio = true;
                }
            }
            n--;
        } while (huboIntercambio);
    }

    public void burbujaMejoradaDescendente() {
        boolean huboIntercambio;
        int n = size - 1;
        do {
            huboIntercambio = false;
            for (int i = 0; i < n; i++) {
                if (vector[i] < vector[i + 1]) {
                    intercambiar(i, i + 1);
                    huboIntercambio = true;
                }
            }
            n--;
        } while (huboIntercambio);

    }

    public void imprimirVector() {
        for (int i = 0; i < size; i++) {
            System.out.println("vector[" + (i + 1) + "] = " + vector[i]);
        }
    }

    public void cargaRandom(int min, int max) {
        size = 0;
        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(max - min + 1) + min;
            size++;
        }
    }

    public int length() {
        return vector.length; // Devuelve la capacidad del array 
    }

    /*public int getElemento(int x){
        return vector[x]; // Devuelve el elemento del indice que se solicita
    }*/
    public int size() {
        return this.size; // Devuelve la cantidad real de elementos que tiene el array.
    }

    public void add(int x) {
        if (size == vector.length) {
            // aumento la capacidad
            int nuevaCapacidad = vector.length + 1;
            int[] aux = new int[nuevaCapacidad];
            System.arraycopy(vector, 0, aux, 0, vector.length);
            vector = aux;
        }
        vector[size] = x;
        size++;
    }

    public void invertir() {
        int aux; //Variable auxiliar
        for (int i = 0; i < size / 2; i++) {
            //Se intercambia el elemento i con el elemento n-i-1
            aux = vector[size - i - 1];
            vector[size - i - 1] = vector[i];
            vector[i] = aux;
        }
    }

    public Vector clonar() {
        Vector clon = new Vector();

        for (int i = 0; i < size; i++) {
            clon.add(vector[i]);
        }

        return clon;
    }

    private void intercambiar(int i, int j) {
        // Al llamar este metodo se deben sumar 7 operaciones elementales
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }

    public int getElement(int i) {
        return vector[i];
    }

    public int[][] getMatriz(int[][] resultados) {
        return resultados;
    }
}

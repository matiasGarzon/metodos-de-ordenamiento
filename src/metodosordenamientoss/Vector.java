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

    public double[][] ascendentes(double[][] resultados) {
        resultados = ordenamientoBurbujaAscendente(resultados);
        resultados = insercionBinaria(resultados);
        //resultados=burbujaMejoradaAscendente();
        return resultados;
    }

    public double[][] descendentes(double[][] resultados) {
        resultados = ordenamientoBurbujaDescendete(resultados);
        resultados = insercionBinaria(resultados);
        //resultados = burbujaMejoradaDescendente();
        return resultados;
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
        long startTime = System.nanoTime();

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

        long endTime = System.nanoTime(); // Tiempo de finalización
        long duracion = endTime - startTime; // Duración en milisegundos

        resultados[0][0] = (double) duracion;
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
        long startTime = System.nanoTime();

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

        long endTime = System.nanoTime(); // Tiempo de finalización
        long duracion = endTime - startTime; // Duración en milisegundos

        resultados[0][0] = (double) duracion;
        resultados[0][1] = oE;
        resultados[0][2] = comparaciones;
        resultados[0][3] = intercambios;
        return resultados;
    }

    public double[][] insercionBinaria(double[][] resultados) {
        double oE = 0;
        double intercambios = 0;
        double comparaciones = 0;
        long startTime = System.nanoTime();

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

        long endTime = System.nanoTime(); // Tiempo de finalización
        long duracion = endTime - startTime; // Duración en milisegundos

        resultados[1][0] = (double) duracion;
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

    public double[][] ordenamientoAscendenteShell(double[][] resultados) {
        int salto, aux, i, contador;
        boolean cambios;

        double oE = 0;
        double intercambios = 0;
        double comparaciones = 0;

        long startTime = System.currentTimeMillis();

        // for (salto = vector.length / 2; salto != 0; salto /= 2)
        // init: salto = vector.length / 2
        //   - acceso a length + división + asignación
        oE += 3;
        for (salto = vector.length / 2;  salto != 0;  salto /= 2) {
            // condición del for: salto != 0
            comparaciones++; // salto != 0
            oE += 1; // comparación

            // cambios = true;
            oE += 1; // asignación
            cambios = true;

            // while (cambios)
            // 1ª evaluación del while
            comparaciones++; // cambios ?
            oE += 1; // comparación
            while (cambios) {
                // cambios = false;
                oE += 1; // asignación
                cambios = false;

                // contador = 0;
                oE += 1; // asignación
                contador = 0;

                // for (i = salto; i < vector.length; i++)
                // init: i = salto
                oE += 1; // asignación
                for (i = salto; i < vector.length;  i++) {
                    // condición del for: i < vector.length
                    comparaciones++; // i < length
                    oE += 1; // comparación

                    // if (vector[i - salto] > vector[i])
                    //   2 accesos a vector + 1 resta + 1 comparación
                    oE += 4;
                    comparaciones++; // comparación vector[i - salto] > vector[i]
                    if (vector[i - salto] > vector[i]) {
                        // aux = vector[i];
                        // vector[i] = vector[i - salto];
                        // vector[i - salto] = aux;
                        // Tomamos swap ~ 8 operaciones elementales (como en tu burbuja)
                        oE += 8;
                        intercambios++;

                        aux = vector[i];
                        vector[i] = vector[i - salto];
                        vector[i - salto] = aux;

                        // cambios = true;
                        oE += 1; // asignación
                        cambios = true;
                    }

                    // i++ (incremento del for): suma + asignación
                    oE += 2;
                }
                // última evaluación de la condición del for (falsa)
                comparaciones++; // i < length (última)
                oE += 1; // comparación

                // vuelve a evaluar el while en la próxima iteración
                comparaciones++; // cambios ?
                oE += 1; // comparación
            }

            // update del for: salto /= 2 (división + asignación)
            oE += 2;
        }
        // última evaluación de la condición del for (salto != 0) que resulta falsa
        comparaciones++; // salto != 0 (última)
        oE += 1; // comparación

        long endTime = System.currentTimeMillis();
        long duracion = endTime - startTime;
        long duracionS = duracion / 1000;

        // guardo en fila 2 (como ya hacías)
        resultados[2][0] = (double) duracionS;
        resultados[2][1] = oE;
        resultados[2][2] = comparaciones;
        resultados[2][3] = intercambios;

        return resultados;
    }

    public double[][] ordenamientoDescendenteShell(double[][] resultados) {
        int salto, aux, i, contador;
        boolean cambios;

        double oE = 0;
        double intercambios = 0;
        double comparaciones = 0;

        long startTime = System.currentTimeMillis();

        // for (salto = vector.length / 2; salto != 0; salto /= 2)
        // init: salto = vector.length / 2  -> acceso a length + división + asignación
        oE += 3;
        for (salto = vector.length / 2; salto != 0; salto /= 2) {
            // condición del for: salto != 0
            comparaciones++;  // salto != 0
            oE += 1;          // comparación

            // cambios = true;
            oE += 1;          // asignación
            cambios = true;

            // 1ª evaluación del while (cambios)
            comparaciones++;  // cambios ?
            oE += 1;          // comparación
            while (cambios) {
                // cambios = false;
                oE += 1;      // asignación
                cambios = false;

                // contador = 0;
                oE += 1;      // asignación
                contador = 0;

                // for (i = salto; i < vector.length; i++)
                // init: i = salto
                oE += 1;      // asignación
                for (i = salto;  i < vector.length;  i++) {
                    // condición del for: i < vector.length
                    comparaciones++; // i < length
                    oE += 1;         // comparación

                    // DESCENDENTE: if (vector[i - salto] < vector[i])  (antes era >)
                    // 2 accesos a vector + 1 resta + 1 comparación
                    oE += 4;
                    comparaciones++; // comparación vector[i - salto] < vector[i]
                    if (vector[i - salto] < vector[i]) {
                        // swap (mismo costo que usás en burbuja)
                        oE += 8;
                        intercambios++;

                        aux = vector[i];
                        vector[i] = vector[i - salto];
                        vector[i - salto] = aux;

                        // cambios = true;
                        oE += 1; // asignación
                        cambios = true;
                    }

                    // i++ -> suma + asignación
                    oE += 2;
                }
                // última evaluación de la condición del for (falsa)
                comparaciones++; // i < length (última)
                oE += 1;         // comparación

                // reevaluación del while
                comparaciones++; // cambios ?
                oE += 1;         // comparación
            }

            // update del for: salto /= 2  (división + asignación)
            oE += 2;
        }
        // última evaluación de la condición del for (salto != 0) que resulta falsa
        comparaciones++; // salto != 0 (última)
        oE += 1;         // comparación

        long endTime = System.currentTimeMillis();
        long duracion = endTime - startTime;
        long duracionS = duracion / 1000;

        // ⚠ Ajustá el índice de fila si tu matriz de resultados usa otro lugar
        resultados[4][0] = (double) duracionS;
        resultados[4][1] = oE;
        resultados[4][2] = comparaciones;
        resultados[4][3] = intercambios;

        return resultados;
    }

    public double[][] burbujaMejoradaAscendente(double[][] resultados) {
        boolean huboIntercambio;
        int n = size - 1;
        double oE = 0;
        double intercambios = 0;
        double comparaciones = 0;

        // n = size - 1  -> resta + asignación
        oE += 2;

        long startTime = System.currentTimeMillis();

        // do { ... } while (huboIntercambio);
        // Primera entrada al do-while no requiere comparación previa
        do {
            // huboIntercambio = false;
            huboIntercambio = false;
            oE += 1; // asignación

            // for (int i = 0; i < n; i++)
            // init i=0
            int i = 0;
            oE += 1; // asignación i=0

            // evaluación de condición inicial i < n
            comparaciones += 1;
            oE += 1; // comparación

            for (; i < n; i++) {
                // if (vector[i] > vector[i+1])
                // 2 accesos a vector + 1 suma + 1 comparación
                oE += 4;
                comparaciones += 1; // comparación de elementos

                if (vector[i] > vector[i + 1]) {
                    // swap mediante método intercambiar(i, i+1)
                    intercambiar(i, i + 1);
                    oE += 8;      // costo del swap (consistente con tu criterio)
                    intercambios += 1;

                    // huboIntercambio = true;
                    huboIntercambio = true;
                    oE += 1; // asignación
                }

                // i++  -> suma + asignación
                oE += 2;

                // próxima evaluación de la condición del for (i < n)
                comparaciones += 1;
                oE += 1; // comparación
            }

            // n--  -> resta + asignación
            n--;
            oE += 2;

            // condición del while (huboIntercambio)
            comparaciones += 1;
            oE += 1; // comparación
        } while (huboIntercambio);

        long endTime = System.currentTimeMillis();
        long duracion = endTime - startTime;
        long duracionS = duracion / 1000;

        resultados[3][0] = (double) duracionS;
        resultados[3][1] = oE;
        resultados[3][2] = comparaciones;
        resultados[3][3] = intercambios;

        return resultados;
    }

    public double[][] burbujaMejoradaDescendente(double[][] resultados) {
        boolean huboIntercambio;
        int n = size - 1;
        double oE = 0;
        double intercambios = 0;
        double comparaciones = 0;

        // n = size - 1  -> resta + asignación
        oE += 2;

        long startTime = System.currentTimeMillis();

        do {
            // huboIntercambio = false;
            huboIntercambio = false;
            oE += 1; // asignación

            // for (int i = 0; i < n; i++)
            int i = 0;
            oE += 1; // asignación i=0

            // evaluación de condición inicial i < n
            comparaciones += 1;
            oE += 1; // comparación

            for (; i < n; i++) {
                // DESCENDENTE: if (vector[i] < vector[i + 1])
                // 2 accesos + 1 suma + 1 comparación
                oE += 4;
                comparaciones += 1; // comparación de elementos

                if (vector[i] < vector[i + 1]) {
                    intercambiar(i, i + 1);
                    oE += 8;      // costo del swap (consistente)
                    intercambios += 1;

                    // huboIntercambio = true;
                    huboIntercambio = true;
                    oE += 1; // asignación
                }

                // i++  -> suma + asignación
                oE += 2;

                // próxima evaluación de la condición del for (i < n)
                comparaciones += 1;
                oE += 1; // comparación
            }

            // n--  -> resta + asignación
            n--;
            oE += 2;

            // condición del while (huboIntercambio)
            comparaciones += 1;
            oE += 1; // comparación
        } while (huboIntercambio);

        long endTime = System.currentTimeMillis();
        long duracion = endTime - startTime;
        long duracionS = duracion / 1000;

        resultados[5][0] = (double) duracionS; // <-- ajustá si querés otra fila
        resultados[5][1] = oE;
        resultados[5][2] = comparaciones;
        resultados[5][3] = intercambios;

        return resultados;
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

}

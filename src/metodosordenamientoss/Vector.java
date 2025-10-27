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
        resultados = clonar().ordenamientoBurbujaAscendente(resultados);
        resultados = clonar().insercionBinariaAscendente(resultados);
        resultados = clonar().ordenamientoAscendenteShell(resultados);
        resultados = clonar().burbujaMejoradaAscendente(resultados);
        resultados = clonar().quickSortAscendente(resultados);
        resultados = clonar().seleccionAscendente(resultados);
        resultados = clonar().burbujaOptimizadaAscendente(resultados);
        resultados = clonar().mergeSortAscendente(resultados);
        return resultados;
    }

    public double[][] descendentes(double[][] resultados) {
        resultados = clonar().ordenamientoBurbujaDescendete(resultados);
        resultados = clonar().insercionBinariaDescendente(resultados);
        resultados = clonar().ordenamientoDescendenteShell(resultados);
        resultados = clonar().burbujaMejoradaDescendente(resultados);
        resultados = clonar().quickSortDescendente(resultados);
        resultados = clonar().seleccionDescendente(resultados);
        resultados = clonar().burbujaOptimizadaDescendente(resultados);
        resultados = clonar().mergeSortDescendente(resultados);
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

        long startTime = System.nanoTime();

        for (int i = 0; i < size - 1; i++) {
            boolean huboIntercambio = false; // para optimizar si ya está ordenado

            for (int j = 0; j < size - i - 1; j++) {
                comparaciones++; // comparación de datos (vector[j] > vector[j+1])
                oE += 4; // 2 accesos + 1 comparación + 1 suma aproximado

                if (vector[j] > vector[j + 1]) {
                    intercambiar(j, j + 1);
                    oE += 8; // operaciones elementales del método intercambiar
                    intercambios++;
                    huboIntercambio = true;
                }
            }

            // si no hubo ningún intercambio, el vector ya está ordenado
            if (!huboIntercambio) {
                break;
            }
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

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

        long startTime = System.nanoTime();

        for (int i = 0; i < size - 1; i++) {
            boolean huboIntercambio = false; // para optimizar si ya está ordenado

            for (int j = 0; j < size - i - 1; j++) {
                comparaciones++; // comparación de datos (vector[j] > vector[j+1])
                oE += 4; // 2 accesos + 1 comparación + 1 suma aproximado

                if (vector[j] < vector[j + 1]) {
                    intercambiar(j, j + 1);
                    oE += 8; // operaciones elementales del método intercambiar
                    intercambios++;
                    huboIntercambio = true;
                }
            }

            // si no hubo ningún intercambio, el vector ya está ordenado
            if (!huboIntercambio) {
                break;
            }
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0][0] = (double) duracion;
        resultados[0][1] = oE;
        resultados[0][2] = comparaciones;
        resultados[0][3] = intercambios;
        return resultados;
    }

    public double[][] insercionBinariaAscendente(double[][] resultados) {
        double oE = 0;             // opcional: estimación simple
        double movimientos = 0;    // SOLO movimientos reales (corrimientos + inserción si cambia de lugar)
        double comparaciones = 0;  // SOLO comparaciones de datos (aux < vector[c])

        long startTime = System.nanoTime();

        for (int i = 1; i < size; i++) {
            int aux = vector[i];

            // --- búsqueda binaria en [0, i-1] para hallar posición de inserción ---
            int primero = 0;
            int ultimo = i - 1;
            while (primero <= ultimo) {
                int c = (primero + ultimo) / 2;

                comparaciones++;   // comparación de datos
                oE += 3;           // (aprox) acceso + comparación + aritmética

                if (aux < vector[c]) {
                    ultimo = c - 1;
                } else {
                    primero = c + 1;
                }
            }

            // --- corrimientos hacia la derecha: j = i-1 .. primero ---
            for (int j = i - 1; j >= primero; j--) {
                vector[j + 1] = vector[j];
                movimientos++;     // movimiento real (corrimiento)
                oE += 1;           // asignación
            }

            // --- inserción solo si cambia de posición ---
            if (primero != i) {
                vector[primero] = aux;
                movimientos++;     // inserción real
                oE += 1;           // asignación
            }
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[1][0] = (double) duracion;       // tiempo (ns)
        resultados[1][1] = (double) oE;             // operaciones elementales (estimado)
        resultados[1][2] = (double) comparaciones;  // comparaciones de datos
        resultados[1][3] = (double) movimientos;    // movimientos reales
        return resultados;
    }

    public double[][] insercionBinariaDescendente(double[][] resultados) {
        double oE = 0;             // opcional: estimación simple
        double movimientos = 0;    // SOLO movimientos reales (corrimientos + inserción si cambia de lugar)
        double comparaciones = 0;  // SOLO comparaciones de datos (aux < vector[c])

        long startTime = System.nanoTime();

        for (int i = 1; i < size; i++) {
            int aux = vector[i];

            // --- búsqueda binaria en [0, i-1] para hallar posición de inserción ---
            int primero = 0;
            int ultimo = i - 1;
            while (primero <= ultimo) {
                int c = (primero + ultimo) / 2;

                comparaciones++;   // comparación de datos
                oE += 3;           // (aprox) acceso + comparación + aritmética

                if (aux > vector[c]) {
                    ultimo = c - 1;
                } else {
                    primero = c + 1;
                }
            }

            // --- corrimientos hacia la derecha: j = i-1 .. primero ---
            for (int j = i - 1; j >= primero; j--) {
                vector[j + 1] = vector[j];
                movimientos++;     // movimiento real (corrimiento)
                oE += 1;           // asignación
            }

            // --- inserción solo si cambia de posición ---
            if (primero != i) {
                vector[primero] = aux;
                movimientos++;     // inserción real
                oE += 1;           // asignación
            }
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[1][0] = (double) duracion;       // tiempo (ns)
        resultados[1][1] = (double) oE;             // operaciones elementales (estimado)
        resultados[1][2] = (double) comparaciones;  // comparaciones de datos
        resultados[1][3] = (double) movimientos;    // movimientos reales
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
        double comparaciones = 0;
        double movimientos = 0;   // corrimientos + inserción
        double oE = 0;

        long start = System.nanoTime();

        int n = vector.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = vector[i];
                int j = i;
                // while (j-gap >= 0 && vector[j-gap] > temp)
                while (j >= gap) {
                    comparaciones++;      // comparación de datos: vector[j-gap] > temp
                    oE += 3;              // acceso + comparación + aritmética (est.)
                    if (vector[j - gap] > temp) {
                        vector[j] = vector[j - gap];
                        j -= gap;
                        movimientos++;     // corrimiento
                        oE += 1;          // asignación
                    } else {
                        break;
                    }
                }
                if (j != i) {             // inserción real
                    vector[j] = temp;
                    movimientos++;
                    oE += 1;
                }
            }
        }

        long end = System.nanoTime();

        resultados[2][0] = (double) (end - start);
        resultados[2][1] = oE;
        resultados[2][2] = comparaciones;  // SOLO datos
        resultados[2][3] = movimientos;    // movimientos reales
        return resultados;
    }
    public double[][] ordenamientoDescendenteShell(double[][] resultados) {
            double comparaciones = 0;
        double movimientos = 0;   // corrimientos + inserción
        double oE = 0;

        long start = System.nanoTime();

        int n = vector.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = vector[i];
                int j = i;
                // while (j-gap >= 0 && vector[j-gap] > temp)
                while (j >= gap) {
                    comparaciones++;      // comparación de datos: vector[j-gap] > temp
                    oE += 3;              // acceso + comparación + aritmética (est.)
                    if (vector[j - gap] < temp) {
                        vector[j] = vector[j - gap];
                        j -= gap;
                        movimientos++;     // corrimiento
                        oE += 1;          // asignación
                    } else {
                        break;
                    }
                }
                if (j != i) {             // inserción real
                    vector[j] = temp;
                    movimientos++;
                    oE += 1;
                }
            }
        }

        long end = System.nanoTime();

        resultados[2][0] = (double) (end - start);
        resultados[2][1] = oE;
        resultados[2][2] = comparaciones;  // SOLO datos
        resultados[2][3] = movimientos;    // movimientos reales
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

        long startTime = System.nanoTime();

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

        long endTime = System.nanoTime(); // Tiempo de finalización
        long duracion = endTime - startTime; // Duración en milisegundos

        resultados[3][0] = (double) duracion;
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

        long startTime = System.nanoTime();

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

        long endTime = System.nanoTime(); // Tiempo de finalización
        long duracion = endTime - startTime; // Duración en milisegundos

        resultados[3][0] = (double) duracion; // <-- ajustá si querés otra fila
        resultados[3][1] = oE;
        resultados[3][2] = comparaciones;
        resultados[3][3] = intercambios;

        return resultados;
    }

    public double[][] quickSortAscendente(double[][] resultados) {
        double oE = 0;
        double comparaciones = 0;
        double intercambios = 0;

        long startTime = System.nanoTime();

        // contadores como arreglo para pasarlos por referencia
        double[] cnt = new double[]{0.0, 0.0, 0.0}; // [0]=oE, [1]=comparaciones, [2]=intercambios
        ordRapAsc(vector, 0, size - 1, cnt);

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        oE = cnt[0];
        comparaciones = cnt[1];
        intercambios = cnt[2];

        resultados[4][0] = (double) duracion;    // tiempo (ns)
        resultados[4][1] = oE;
        resultados[4][2] = comparaciones;
        resultados[4][3] = intercambios;
        return resultados;
    }

    
    private void ordRapAsc(int[] lista, int inf, int sup, double[] cnt) {
        // 5-6: if (inf >= sup) return;
        cnt[1] += 1; // comparación
        cnt[0] += 1; // oE: comparación
        if (inf >= sup) {
            return;
        }

        // 1: elem_div = lista[sup];
        int elem_div = lista[sup];
        cnt[0] += 2; // acceso + asignación

        // 2: i = inf - 1;
        int i = inf - 1;
        cnt[0] += 2; // resta + asignación
        // 3: j = sup;
        int j = sup;
        cnt[0] += 1; // asignación
        // 4: cont = 1;
        boolean cont = true;
        cnt[0] += 1; // asignación

        // 7: while (cont)
        cnt[1] += 1; // evaluación inicial del while
        cnt[0] += 1; // comparación
        while (cont) {

            // 8: while (lista[++i] < elem_div);
            // do { ++i } while (i < sup && lista[i] < elem_div)
            do {
                i++;
                cnt[0] += 2; // suma + asignación
                // guardia i < sup para no leer fuera
                cnt[1] += 1;
                cnt[0] += 1; // comparación
                if (!(i < sup)) {
                    break;
                }

                // lista[i] < elem_div
                cnt[0] += 1; // acceso a lista[i]
                cnt[1] += 1; // comparación con pivote
                cnt[0] += 1; // comparación
            } while (lista[i] < elem_div);

            // 9: while (lista[--j] > elem_div);
            // do { --j } while (j >= inf && lista[j] > elem_div)
            do {
                j--;
                cnt[0] += 2; // resta + asignación
                // guardia j >= inf
                cnt[1] += 1;
                cnt[0] += 1; // comparación
                if (!(j >= inf)) {
                    break;
                }

                // lista[j] > elem_div
                cnt[0] += 1; // acceso a lista[j]
                cnt[1] += 1; // comparación con pivote
                cnt[0] += 1; // comparación
            } while (lista[j] > elem_div);

            // 10: if (i < j)
            cnt[1] += 1;
            cnt[0] += 1; // comparación
            if (i < j) {
                // 11-13: swap(lista[i], lista[j])
                swapQS(lista, i, j, cnt);
            } else {
                // 15: cont = 0;
                cont = false;
                cnt[0] += 1; // asignación
            }

            // re-evaluación del while(cont)
            cnt[1] += 1;
            cnt[0] += 1; // comparación
        }

        // 16-18: colocar pivote en su lugar final => swap(lista[i], lista[sup])
        swapQS(lista, i, sup, cnt);

        // 19-20: llamadas recursivas
        ordRapAsc(lista, inf, i - 1, cnt);
        ordRapAsc(lista, i + 1, sup, cnt);
    }

    private void swapQS(int[] a, int x, int y, double[] cnt) {
        // costo de swap consistente con tus métodos: oE += 8; intercambios++;
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
        cnt[0] += 8;  // operaciones elementales del intercambio
        cnt[2] += 1;  // intercambios
    }

    public double[][] quickSortDescendente(double[][] resultados) {
        double oE = 0;
        double comparaciones = 0;
        double intercambios = 0;

        long startTime = System.nanoTime();

        // contadores “por referencia”
        double[] cnt = new double[]{0.0, 0.0, 0.0}; // [0]=oE, [1]=comparaciones, [2]=intercambios
        ordRapDesc(vector, 0, size - 1, cnt);

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        oE = cnt[0];
        comparaciones = cnt[1];
        intercambios = cnt[2];

        resultados[4][0] = (double) duracion;  // tiempo (ns)
        resultados[4][1] = oE;
        resultados[4][2] = comparaciones;
        resultados[4][3] = intercambios;
        return resultados;
    }

// Quicksort descendente (pivote = lista[sup]) con conteo de operaciones
    private void ordRapDesc(int[] lista, int inf, int sup, double[] cnt) {
        // if (inf >= sup) return;
        cnt[1] += 1;
        cnt[0] += 1; // comparación
        if (inf >= sup) {
            return;
        }

        // elem_div = lista[sup]
        int elem_div = lista[sup];
        cnt[0] += 2; // acceso + asignación
        // i = inf - 1; j = sup; cont = true;
        int i = inf - 1;
        cnt[0] += 2; // resta + asignación
        int j = sup;
        cnt[0] += 1; // asignación
        boolean cont = true;
        cnt[0] += 1; // asignación

        // while (cont)
        cnt[1] += 1;
        cnt[0] += 1; // eval inicial
        while (cont) {

            // DESC: while (lista[++i] > elem_div);
            do {
                i++;
                cnt[0] += 2; // suma + asignación
                cnt[1] += 1;
                cnt[0] += 1; // i < sup
                if (!(i < sup)) {
                    break;
                }

                cnt[0] += 1;    // acceso lista[i]
                cnt[1] += 1;    // lista[i] > pivote ?
                cnt[0] += 1;    // comparación
            } while (lista[i] > elem_div);

            // DESC: while (lista[--j] < elem_div);
            do {
                j--;
                cnt[0] += 2; // resta + asignación
                cnt[1] += 1;
                cnt[0] += 1; // j >= inf
                if (!(j >= inf)) {
                    break;
                }

                cnt[0] += 1;    // acceso lista[j]
                cnt[1] += 1;    // lista[j] < pivote ?
                cnt[0] += 1;    // comparación
            } while (lista[j] < elem_div);

            // if (i < j) swap(i,j) else cont=false
            cnt[1] += 1;
            cnt[0] += 1; // comparación
            if (i < j) {
                swapQS(lista, i, j, cnt);
            } else {
                cont = false;
                cnt[0] += 1; // asignación
            }

            // re-evaluación del while(cont)
            cnt[1] += 1;
            cnt[0] += 1; // comparación
        }

        // colocar pivote en su lugar final: swap(lista[i], lista[sup])
        swapQS(lista, i, sup, cnt);

        // recursión
        ordRapDesc(lista, inf, i - 1, cnt);
        ordRapDesc(lista, i + 1, sup, cnt);
    }

// swap con costo estándar (igual que en tus otros métodos)
   /* private void swapQS(int[] a, int x, int y, double[] cnt) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
        cnt[0] += 8;  // oE del intercambio
        cnt[2] += 1;  // intercambios
    }*/
    
    public double[][] seleccionAscendente(double[][] resultados) {
        double oE = 0;
        double comparaciones = 0;
        double intercambios = 0;

        long startTime = System.nanoTime();

        // for (i = 0; i < size - 1; i++)
        oE += 2; // asignación i=0, comparación i<size-1 inicial
        for (int i = 0; i < size - 1; i++) {
            oE += 2; // comparación i<size-1 + suma i++
            comparaciones++; // i<size-1

            int pos_men = i;
            oE += 1; // asignación

            // buscar el menor desde i+1 hasta size-1
            oE += 2; // asignación j=i+1
            for (int j = i + 1; j < size; j++) {
                oE += 2; // comparación j<size + suma j++
                comparaciones++; // j<size

                // if (vector[j] < vector[pos_men])
                oE += 3; // 2 accesos a vector + comparación
                comparaciones++;
                if (vector[j] < vector[pos_men]) {
                    pos_men = j;
                    oE += 1; // asignación
                }
            }
            // última evaluación del for interno (falsa)
            oE += 1;
            comparaciones++;

            // swap de vector[i] y vector[pos_men] (si corresponde)
            if (pos_men != i) {
                oE += 1; // comparación pos_men != i
                comparaciones++;

                int temp = vector[i];
                vector[i] = vector[pos_men];
                vector[pos_men] = temp;
                oE += 8; // operaciones elementales del intercambio
                intercambios++;
            } else {
                oE += 1; // comparación pos_men == i (falsa)
                comparaciones++;
            }
        }

        // última evaluación del for externo (falsa)
        oE += 1;
        comparaciones++;

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[5][0] = (double) duracion;     // tiempo
        resultados[5][1] = oE;                    // operaciones elementales
        resultados[5][2] = comparaciones;         // comparaciones
        resultados[5][3] = intercambios;          // intercambios

        return resultados;
    }
    
    public double[][] seleccionDescendente(double[][] resultados) {
        double oE = 0;
        double comparaciones = 0;
        double intercambios = 0;

        long startTime = System.nanoTime();

        // for (i = 0; i < size - 1; i++)
        oE += 2; // asignación i=0, comparación inicial i < size-1
        for (int i = 0; i < size - 1; i++) {
            oE += 2;          // comparación i < size-1 + suma de i++
            comparaciones++;  // i < size-1

            int pos_may = i;  // posición del mayor (para descendente)
            oE += 1;          // asignación

            // buscar el mayor desde i+1 hasta size-1
            oE += 2;          // asignación j = i + 1
            for (int j = i + 1; j < size; j++) {
                oE += 2;          // comparación j < size + suma j++
                comparaciones++;  // j < size

                // if (vector[j] > vector[pos_may])  // DESCENDENTE
                oE += 3;          // 2 accesos a vector + 1 comparación
                comparaciones++;  // comparación de elementos
                if (vector[j] > vector[pos_may]) {
                    pos_may = j;
                    oE += 1;      // asignación
                }
            }
            // última evaluación falsa del for interno
            oE += 1;
            comparaciones++;

            // intercambio vector[i] <-> vector[pos_may] si corresponde
            oE += 1;         // comparación pos_may != i
            comparaciones++; // se cuenta la comparación
            if (pos_may != i) {
                int temp = vector[i];
                vector[i] = vector[pos_may];
                vector[pos_may] = temp;
                oE += 8;     // costo del swap (consistente con tus otros métodos)
                intercambios++;
            }
        }

        // última evaluación falsa del for externo
        oE += 1;
        comparaciones++;

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[5][0] = (double) duracion;   // tiempo (ns)
        resultados[5][1] = oE;                  // operaciones elementales
        resultados[5][2] = comparaciones;       // comparaciones
        resultados[5][3] = intercambios;        // intercambios

        return resultados;
    }
// Burbuja Optimizado (bandera) — Ascendente (menor → mayor)

    public double[][] burbujaOptimizadaAscendente(double[][] resultados) {
        double oE = 0;
        double comparaciones = 0;
        double intercambios = 0;

        boolean bandera = false; // BANDERA ← F
        oE += 1;                 // asignación

        long startTime = System.nanoTime();

        // mientras BANDERA = F hacer  → while (!bandera)
        comparaciones += 1;
        oE += 1; // primera evaluación del while
        while (!bandera) {
            // BANDERA ← V
            bandera = true;
            oE += 1; // asignación

            // Desde k ← 0 hasta N-2 hacer
            int k = 0;
            oE += 1;                 // asignación k=0
            comparaciones += 1;
            oE += 1;        // k < size-1 (1ª evaluación)
            for (; k < size - 1; k++) {
                // Si x[k] > x[k+1] (ascendente)
                oE += 4;                        // 2 accesos + 1 suma + 1 comparación
                comparaciones += 1;
                if (vector[k] > vector[k + 1]) {
                    // intercambiar(x[k], x[k+1])
                    int tmp = vector[k];
                    vector[k] = vector[k + 1];
                    vector[k + 1] = tmp;
                    oE += 8;                    // costo estándar del swap
                    intercambios += 1;

                    // BANDERA ← F  (hubo intercambio)
                    bandera = false;
                    oE += 1;   // asignación
                }

                // k++ → suma + asignación
                oE += 2;
                // Re-evaluación condición del for
                comparaciones += 1;
                oE += 1;
            }

            // Última evaluación falsa del for (k < size-1)
            // (ya sumada justo arriba al salir del for)
            // Re-evaluación del while (!bandera)
            comparaciones += 1;
            oE += 1;
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[6][0] = (double) duracion;   // tiempo (ns)
        resultados[6][1] = oE;                  // operaciones elementales
        resultados[6][2] = comparaciones;       // comparaciones
        resultados[6][3] = intercambios;        // intercambios
        return resultados;
    }
// Burbuja Optimizado (bandera) — Descendente (mayor → menor)

    public double[][] burbujaOptimizadaDescendente(double[][] resultados) {
        double oE = 0;
        double comparaciones = 0;
        double intercambios = 0;

        boolean bandera = false; // BANDERA ← F
        oE += 1;                 // asignación

        long startTime = System.nanoTime();

        // mientras BANDERA = F hacer  → while (!bandera)
        comparaciones += 1;
        oE += 1; // primera evaluación del while
        while (!bandera) {
            // BANDERA ← V
            bandera = true;
            oE += 1; // asignación

            // Desde k ← 0 hasta N-2 hacer
            int k = 0;
            oE += 1;                 // asignación k=0
            comparaciones += 1;
            oE += 1;        // k < size-1 (1ª evaluación)
            for (; k < size - 1; k++) {
                // DESCENDENTE: Si x[k] < x[k+1]
                oE += 4;                        // 2 accesos + 1 suma + 1 comparación
                comparaciones += 1;
                if (vector[k] < vector[k + 1]) {
                    // intercambiar(x[k], x[k+1])
                    int tmp = vector[k];
                    vector[k] = vector[k + 1];
                    vector[k + 1] = tmp;
                    oE += 8;                    // costo estándar del swap
                    intercambios += 1;

                    // BANDERA ← F  (hubo intercambio)
                    bandera = false;
                    oE += 1;   // asignación
                }

                // k++ → suma + asignación
                oE += 2;
                // Re-evaluación condición del for
                comparaciones += 1;
                oE += 1;
            }

            // Re-evaluación del while (!bandera)
            comparaciones += 1;
            oE += 1;
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[6][0] = (double) duracion;   // tiempo (ns)
        resultados[6][1] = oE;                  // operaciones elementales
        resultados[6][2] = comparaciones;       // comparaciones
        resultados[6][3] = intercambios;        // intercambios
        return resultados;
    }
    
    public double[][] mergeSortAscendente(double[][] resultados) {
    double[] cnt = new double[]{0.0, 0.0, 0.0}; // [0]=oE, [1]=comparaciones, [2]=intercambios
    long startTime = System.nanoTime();

    mergeSortAsc(vector, 0, size - 1, cnt);

    long endTime = System.nanoTime();
    long duracion = endTime - startTime;

    resultados[7][0] = (double) duracion;
    resultados[7][1] = cnt[0]; // oE
    resultados[7][2] = cnt[1]; // comparaciones
    resultados[7][3] = cnt[2]; // intercambios
    return resultados;
}

private void mergeSortAsc(int[] arr, int izq, int der, double[] cnt) {
    cnt[1] += 1; cnt[0] += 1; // comparación izq < der
    if (izq < der) {
        int medio = (izq + der) / 2;
        cnt[0] += 3; // suma, división y asignación

        mergeSortAsc(arr, izq, medio, cnt);
        mergeSortAsc(arr, medio + 1, der, cnt);

        mergeAsc(arr, izq, medio, der, cnt);
    }
}

// Mezcla ascendente (menor a mayor)
private void mergeAsc(int[] arr, int izq, int medio, int der, double[] cnt) {
    int n1 = medio - izq + 1;
    int n2 = der - medio;
    cnt[0] += 3; // restas y asignaciones

    int[] L = new int[n1];
    int[] R = new int[n2];
    cnt[0] += 2; // asignaciones

    // Copiar los datos a arreglos temporales
    for (int i = 0; i < n1; i++) {
        L[i] = arr[izq + i];
        cnt[0] += 4; // acceso, suma, acceso y asignación
        cnt[2]++; // movimiento (intercambio lógico)
    }
    for (int j = 0; j < n2; j++) {
        R[j] = arr[medio + 1 + j];
        cnt[0] += 5; // acceso, suma, suma, acceso y asignación
        cnt[2]++;
    }

    int i = 0, j = 0, k = izq;
    cnt[0] += 3; // asignaciones

    // Fusionar las dos mitades
    while (i < n1 && j < n2) {
        cnt[1] += 2; cnt[0] += 2; // dos comparaciones (i<n1, j<n2)
        cnt[0] += 2; // accesos a L[i], R[j]
        cnt[1] += 1; // comparación L[i] <= R[j]
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            cnt[0] += 2; // asignación y acceso
            i++;
            cnt[0] += 2; // suma + asignación
        } else {
            arr[k] = R[j];
            cnt[0] += 2;
            j++;
            cnt[0] += 2;
        }
        k++;
        cnt[0] += 2;
        cnt[2]++; // intercambio lógico
    }

    // Copiar los elementos restantes de L[]
    while (i < n1) {
        cnt[1] += 1; cnt[0] += 1; // comparación
        arr[k] = L[i];
        cnt[0] += 2; // asignación + acceso
        i++; k++;
        cnt[0] += 4;
        cnt[2]++;
    }

    // Copiar los elementos restantes de R[]
    while (j < n2) {
        cnt[1] += 1; cnt[0] += 1; // comparación
        arr[k] = R[j];
        cnt[0] += 2;
        j++; k++;
        cnt[0] += 4;
        cnt[2]++;
    }
}

public double[][] mergeSortDescendente(double[][] resultados) {
    double[] cnt = new double[]{0.0, 0.0, 0.0}; // [0]=oE, [1]=comparaciones, [2]=intercambios
    long startTime = System.nanoTime();

    mergeSortDesc(vector, 0, size - 1, cnt);

    long endTime = System.nanoTime();
    long duracion = endTime - startTime;

    resultados[7][0] = (double) duracion;
    resultados[7][1] = cnt[0];
    resultados[7][2] = cnt[1];
    resultados[7][3] = cnt[2];
    return resultados;
}

private void mergeSortDesc(int[] arr, int izq, int der, double[] cnt) {
    cnt[1] += 1; cnt[0] += 1; // comparación izq < der
    if (izq < der) {
        int medio = (izq + der) / 2;
        cnt[0] += 3; // suma, división y asignación

        mergeSortDesc(arr, izq, medio, cnt);
        mergeSortDesc(arr, medio + 1, der, cnt);

        mergeDesc(arr, izq, medio, der, cnt);
    }
}

// Mezcla descendente (mayor a menor)
private void mergeDesc(int[] arr, int izq, int medio, int der, double[] cnt) {
    int n1 = medio - izq + 1;
    int n2 = der - medio;
    cnt[0] += 3;

    int[] L = new int[n1];
    int[] R = new int[n2];
    cnt[0] += 2;

    for (int i = 0; i < n1; i++) {
        L[i] = arr[izq + i];
        cnt[0] += 4;
        cnt[2]++;
    }
    for (int j = 0; j < n2; j++) {
        R[j] = arr[medio + 1 + j];
        cnt[0] += 5;
        cnt[2]++;
    }

    int i = 0, j = 0, k = izq;
    cnt[0] += 3;

    // DESCENDENTE: comparar al revés
    while (i < n1 && j < n2) {
        cnt[1] += 2; cnt[0] += 2;
        cnt[0] += 2; cnt[1] += 1; // comparación L[i] >= R[j]
        if (L[i] >= R[j]) {
            arr[k] = L[i];
            cnt[0] += 2;
            i++; cnt[0] += 2;
        } else {
            arr[k] = R[j];
            cnt[0] += 2;
            j++; cnt[0] += 2;
        }
        k++; cnt[0] += 2;
        cnt[2]++;
    }

    while (i < n1) {
        cnt[1] += 1; cnt[0] += 1;
        arr[k] = L[i];
        cnt[0] += 2;
        i++; k++;
        cnt[0] += 4;
        cnt[2]++;
    }

    while (j < n2) {
        cnt[1] += 1; cnt[0] += 1;
        arr[k] = R[j];
        cnt[0] += 2;
        j++; k++;
        cnt[0] += 4;
        cnt[2]++;
    }
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

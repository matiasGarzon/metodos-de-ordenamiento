package metodosordenamientoss;

import java.util.Random;
import java.util.Scanner;

/**
 * CLASE VECTOR CORREGIDA * --- RESUMEN DE CORRECCIONES --- 1. REGLA DE CONTEO
 * ÚNICA: - 'comparaciones' (resultados[2]): SOLO cuenta comparaciones entre
 * elementos del vector (ej. vec[i] > vec[j]). - 'oE' (resultados[1]): Cuenta
 * TODO lo demás (asignaciones, aritmética, accesos, y comparaciones de control
 * de bucles). 2. BURBUJA CLÁSICO: Se reemplazó 'burbujaAscendente' por el
 * algoritmo O(n^2) "Burbuja 1" del pseudocódigo (dos bucles for anidados hasta
 * n-1). 3. INTERCAMBIOS vs MOVIMIENTOS: - En Burbuja, Selección, QuickSort:
 * 'intercambios' (resultados[3]) cuenta los swaps. - En Inserción, Shell,
 * MergeSort: 'movimientos' (resultados[3]) cuenta las asignaciones/copias de
 * datos. - El costo de un 'swap' se estandarizó en 8 OEs (basado en el código
 * original de QuickSort).
 */
public class Vector {

    private Scanner teclado = new Scanner(System.in);
    private Random random = new Random();
    private int[] vector;
    private int size;
    private long[] resultados = new long[4];

    public long[] resultados() {
        return resultados;
    }

    public Vector(int tamano) {
        vector = new int[tamano];
        size = 0;
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

    /**
     * ALGORITMO BURBUJA 1 (Clásico O(n^2)) Implementación directa del
     * pseudocódigo (dos bucles fijos hasta n-1). Este método NO está
     * optimizado.
     */
    public long[] burbujaAscendente() {
        long oE = 0;
        long intercambios = 0;
        long comparaciones = 0;

        long startTime = System.nanoTime();

        // Pseudocódigo: Desde I = 1 hasta N-1 hacer
        // Java: for (int i = 0; i < size - 1; i++)
        oE += 1; // i = 0
        oE += 1; // Primera comparación i < size - 1
        for (int i = 0; i < size - 1; i++) {

            // Pseudocódigo: Desde J = 1 hasta N-1 hacer
            // Java: for (int j = 0; j < size - 1; j++)
            oE += 1; // j = 0
            oE += 1; // Primera comparación j < size - 1
            for (int j = 0; j < size - 1; j++) {

                // Si x[J] > x[J+1]
                comparaciones++; // ¡COMPARACIÓN DE DATOS!
                oE += 4; // 2 accesos + 1 suma + 1 comparación

                if (vector[j] > vector[j + 1]) {
                    // intercambiar(j, j + 1);
                    intercambiar(j, j + 1);
                    oE += 8; // Costo estándar del swap
                    intercambios++;
                }

                oE += 2; // j++ (suma + asignación)
                oE += 1; // Siguiente j < size - 1
            }
            // (Ya se contó la última oE de j < size - 1 al salir)

            oE += 2; // i++ (suma + asignación)
            oE += 1; // Siguiente i < size - 1
        }
        // (Ya se contó la última oE de i < size - 1 al salir)

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = intercambios;
        return resultados;
    }

    /**
     * ALGORITMO BURBUJA 1 (Clásico O(n^2)) - Descendente
     */
    public long[] burbujaDescendente() {
        long oE = 0;
        long intercambios = 0;
        long comparaciones = 0;

        long startTime = System.nanoTime();

        oE += 1; // i = 0
        oE += 1; // Primera i < size - 1
        for (int i = 0; i < size - 1; i++) {
            oE += 1; // j = 0
            oE += 1; // Primera j < size - 1
            for (int j = 0; j < size - 1; j++) {

                comparaciones++; // ¡COMPARACIÓN DE DATOS!
                oE += 4; // 2 accesos + 1 suma + 1 comparación

                if (vector[j] < vector[j + 1]) { // Condición descendente
                    intercambiar(j, j + 1);
                    oE += 8;
                    intercambios++;
                }

                oE += 2; // j++
                oE += 1; // j < size - 1
            }
            oE += 2; // i++
            oE += 1; // i < size - 1
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = intercambios;
        return resultados;
    }

    /**
     * INSERCIÓN BINARIA - Ascendente CORREGIDO: 'comparaciones' solo cuenta
     * datos. 'oE' cuenta todo. 'movimientos' (resultados[3]) cuenta
     * corrimientos + inserción.
     */
    public long[] insercionBinariaAscendente() {
        long oE = 0;
        long movimientos = 0;
        long comparaciones = 0;

        long startTime = System.nanoTime();

        // for (int i = 1; i < size; i++)
        oE += 1; // i = 1
        oE += 1; // Primera i < size
        for (int i = 1; i < size; i++) {

            int aux = vector[i];
            oE += 2; // acceso + asignación

            // --- búsqueda binaria ---
            int primero = 0;
            oE += 1;
            int ultimo = i - 1;
            oE += 2; // resta + asignación

            // while (primero <= ultimo)
            oE += 1; // Primera comparación
            while (primero <= ultimo) {
                int c = (primero + ultimo) / 2;
                oE += 3; // suma + div + asignación

                comparaciones++;    // ¡COMPARACIÓN DE DATOS!
                oE += 2;            // acceso vector[c] + comparación con aux

                if (aux < vector[c]) {
                    ultimo = c - 1;
                    oE += 2; // resta + asignación
                } else {
                    primero = c + 1;
                    oE += 2; // suma + asignación
                }

                oE += 1; // Siguiente primero <= ultimo
            }

            // --- corrimientos ---
            // for (int j = i - 1; j >= primero; j--)
            int j = i - 1;
            oE += 2; // resta + asignación
            oE += 1; // Primera j >= primero
            for (; j >= primero; j--) {
                vector[j + 1] = vector[j];
                movimientos++;    // Movimiento (corrimiento)
                oE += 4;          // 1 acceso, 1 suma, 1 acceso, 1 asignación

                oE += 2; // j--
                oE += 1; // Siguiente j >= primero
            }

            // --- inserción ---
            // if (primero != i)
            oE += 1; // comparación
            if (primero != i) {
                vector[primero] = aux;
                movimientos++;    // Movimiento (inserción)
                oE += 2;          // acceso + asignación
            }

            oE += 2; // i++
            oE += 1; // Siguiente i < size
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = movimientos;
        return resultados;
    }

    /**
     * INSERCIÓN BINARIA - Descendente CORREGIDO: 'comparaciones' solo cuenta
     * datos. 'oE' cuenta todo.
     */
    public long[] insercionBinariaDescendente() {
        long oE = 0;
        long movimientos = 0;
        long comparaciones = 0;

        long startTime = System.nanoTime();

        oE += 1; // i = 1
        oE += 1; // Primera i < size
        for (int i = 1; i < size; i++) {
            int aux = vector[i];
            oE += 2;
            int primero = 0;
            oE += 1;
            int ultimo = i - 1;
            oE += 2;

            oE += 1; // Primera primero <= ultimo
            while (primero <= ultimo) {
                int c = (primero + ultimo) / 2;
                oE += 3;

                comparaciones++;    // ¡COMPARACIÓN DE DATOS!
                oE += 2;            // acceso + comparación

                // DESCENDENTE
                if (aux > vector[c]) {
                    ultimo = c - 1;
                    oE += 2;
                } else {
                    primero = c + 1;
                    oE += 2;
                }

                oE += 1; // Siguiente primero <= ultimo
            }

            int j = i - 1;
            oE += 2;
            oE += 1; // Primera j >= primero
            for (; j >= primero; j--) {
                vector[j + 1] = vector[j];
                movimientos++;
                oE += 4;

                oE += 2; // j--
                oE += 1; // Siguiente j >= primero
            }

            oE += 1; // if (primero != i)
            if (primero != i) {
                vector[primero] = aux;
                movimientos++;
                oE += 2;
            }

            oE += 2; // i++
            oE += 1; // Siguiente i < size
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = movimientos;
        return resultados;
    }

    /**
     * SHELL SORT - Ascendente CORREGIDO: 'comparaciones' solo cuenta datos.
     * 'oE' cuenta todo. 'movimientos' (resultados[3]) cuenta corrimientos +
     * inserción.
     */
    public long[] shellAscendente() {
        long comparaciones = 0;
        long movimientos = 0;
        long oE = 0;

        long start = System.nanoTime();

        int n = vector.length;
        oE += 2; // acceso .length + asignación

        // for (int gap = n / 2; gap > 0; gap /= 2)
        oE += 2; // div + asignación
        oE += 1; // Primera gap > 0
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // for (int i = gap; i < n; i++)
            oE += 1; // i = gap
            oE += 1; // Primera i < n
            for (int i = gap; i < n; i++) {
                int temp = vector[i];
                oE += 2; // acceso + asignación

                int j = i;
                oE += 1; // asignación

                // while (j >= gap)
                oE += 1; // Primera j >= gap
                while (j >= gap) {

                    comparaciones++;    // ¡COMPARACIÓN DE DATOS!
                    oE += 4;            // 1 acceso, 1 resta, 1 acceso, 1 comparación

                    if (vector[j - gap] > temp) {
                        vector[j] = vector[j - gap];
                        movimientos++;    // Movimiento (corrimiento)
                        oE += 4;          // 1 acceso, 1 resta, 1 acceso, 1 asignación

                        j -= gap;
                        oE += 2; // resta + asignación
                    } else {
                        break;
                    }

                    oE += 1; // Siguiente j >= gap
                }

                // if (j != i)
                oE += 1; // comparación
                if (j != i) {
                    vector[j] = temp;
                    movimientos++;    // Movimiento (inserción)
                    oE += 2;          // acceso + asignación
                }

                oE += 2; // i++
                oE += 1; // Siguiente i < n
            }

            oE += 2; // gap /= 2 (div + asignación)
            oE += 1; // Siguiente gap > 0
        }

        long end = System.nanoTime();

        resultados[0] = (long) (end - start);
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = movimientos;
        return resultados;
    }

    /**
     * SHELL SORT - Descendente CORREGIDO: 'comparaciones' solo cuenta datos.
     * 'oE' cuenta todo.
     */
    public long[] shellDescendente() {
        long comparaciones = 0;
        long movimientos = 0;
        long oE = 0;

        long start = System.nanoTime();

        int n = vector.length;
        oE += 2;

        oE += 2; // gap = n / 2
        oE += 1; // Primera gap > 0
        for (int gap = n / 2; gap > 0; gap /= 2) {
            oE += 1; // i = gap
            oE += 1; // Primera i < n
            for (int i = gap; i < n; i++) {
                int temp = vector[i];
                oE += 2;
                int j = i;
                oE += 1;

                oE += 1; // Primera j >= gap
                while (j >= gap) {
                    comparaciones++;    // ¡COMPARACIÓN DE DATOS!
                    oE += 4;

                    if (vector[j - gap] < temp) { // DESCENDENTE
                        vector[j] = vector[j - gap];
                        movimientos++;
                        oE += 4;
                        j -= gap;
                        oE += 2;
                    } else {
                        break;
                    }
                    oE += 1; // Siguiente j >= gap
                }

                oE += 1; // if (j != i)
                if (j != i) {
                    vector[j] = temp;
                    movimientos++;
                    oE += 2;
                }

                oE += 2; // i++
                oE += 1; // Siguiente i < n
            }
            oE += 2; // gap /= 2
            oE += 1; // Siguiente gap > 0
        }

        long end = System.nanoTime();

        resultados[0] = (long) (end - start);
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = movimientos;
        return resultados;
    }

    /**
     * BURBUJA MEJORADA (Algoritmo 2) - Ascendente Implementación del
     * pseudocódigo 2 (límite interno N-I). CORREGIDO: 'comparaciones' solo
     * cuenta datos. 'oE' cuenta todo.
     */
    public long[] burbujaMejoradaAscendente() {
        long oE = 0;
        long intercambios = 0;
        long comparaciones = 0;

        long startTime = System.nanoTime();

        // Pseudocódigo: Desde I = 1 hasta N-1 hacer (i.e., i de 0 a size-2)
        // for (int i = 0; i < size - 1; i++)
        oE += 1; // i = 0
        oE += 1; // Primera i < size - 1
        for (int i = 0; i < size - 1; i++) {

            // Pseudocódigo: Desde J = 1 hasta N-I hacer
            // Java: for (int j = 0; j < size - i - 1; j++)
            oE += 1; // j = 0
            oE += 1; // Primera j < size - i - 1
            for (int j = 0; j < size - i - 1; j++) {

                // Si x[J] > x[J+1]
                comparaciones++; // ¡COMPARACIÓN DE DATOS!
                oE += 4; // 2 accesos + 1 suma + 1 comparación

                if (vector[j] > vector[j + 1]) {
                    intercambiar(j, j + 1);
                    oE += 8; // Costo estándar del swap
                    intercambios++;
                }

                oE += 2; // j++ (suma + asignación)
                oE += 1; // Siguiente j < size - i - 1
            }
            // (Ya se contó la última oE de j < ... al salir)

            oE += 2; // i++ (suma + asignación)
            oE += 1; // Siguiente i < size - 1
        }
        // (Ya se contó la última oE de i < ... al salir)

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = intercambios;

        return resultados;
    }

    /**
     * BURBUJA MEJORADA (Algoritmo 2) - Descendente Implementación del
     * pseudocódigo 2 (límite interno N-I). CORREGIDO: 'comparaciones' solo
     * cuenta datos. 'oE' cuenta todo.
     */
    public long[] burbujaMejoradaDescendente() {
        long oE = 0;
        long intercambios = 0;
        long comparaciones = 0;

        long startTime = System.nanoTime();

        // for (int i = 0; i < size - 1; i++)
        oE += 1; // i = 0
        oE += 1; // Primera i < size - 1
        for (int i = 0; i < size - 1; i++) {

            // for (int j = 0; j < size - i - 1; j++)
            oE += 1; // j = 0
            oE += 1; // Primera j < size - i - 1
            for (int j = 0; j < size - i - 1; j++) {

                comparaciones++; // ¡COMPARACIÓN DE DATOS!
                oE += 4; // 2 accesos + 1 suma + 1 comparación

                if (vector[j] < vector[j + 1]) { // DESCENDENTE
                    intercambiar(j, j + 1);
                    oE += 8;
                    intercambios++;
                }

                oE += 2; // j++
                oE += 1; // Siguiente j < size - i - 1
            }
            // (Ya se contó la última oE de j < ... al salir)

            oE += 2; // i++
            oE += 1; // Siguiente i < size - 1
        }
        // (Ya se contó la última oE de i < ... al salir)

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = intercambios;

        return resultados;
    }

    /**
     * QUICK SORT - Ascendente CORREGIDO: 'cnt[1]' (comparaciones) solo cuenta
     * datos. 'cnt[0]' (oE) cuenta todo.
     */
    public long[] quickSortAscendente() {
        long startTime = System.nanoTime();

        // [0]=oE, [1]=comparaciones, [2]=intercambios
        long[] cnt = new long[]{0, 0, 0};
        ordRapAsc(vector, 0, size - 1, cnt);

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = cnt[0];
        resultados[2] = cnt[1];
        resultados[3] = cnt[2];
        return resultados;
    }

    private void ordRapAsc(int[] lista, int inf, int sup, long[] cnt) {

        cnt[0] += 1; // oE: comparación inf >= sup
        if (inf >= sup) {
            return;
        }

        int elem_div = lista[sup];
        cnt[0] += 2; // acceso + asignación

        int i = inf - 1;
        cnt[0] += 2; // resta + asignación
        int j = sup;
        cnt[0] += 1; // asignación
        boolean cont = true;
        cnt[0] += 1; // asignación

        cnt[0] += 1; // evaluación inicial del while(cont)
        while (cont) {

            do {
                i++;
                cnt[0] += 2; // suma + asignación

                cnt[0] += 1; // oE: i < sup
                if (!(i < sup)) {
                    break;
                }

                cnt[1] += 1; // ¡COMPARACIÓN DE DATOS!
                cnt[0] += 2; // acceso lista[i] + comparación
            } while (lista[i] < elem_div);

            do {
                j--;
                cnt[0] += 2; // resta + asignación

                cnt[0] += 1; // oE: j >= inf
                if (!(j >= inf)) {
                    break;
                }

                cnt[1] += 1; // ¡COMPARACIÓN DE DATOS!
                cnt[0] += 2; // acceso lista[j] + comparación
            } while (lista[j] > elem_div);

            cnt[0] += 1; // oE: if (i < j)
            if (i < j) {
                swapQS(lista, i, j, cnt); // El swap suma a cnt[0] y cnt[2]
            } else {
                cont = false;
                cnt[0] += 1; // asignación
            }

            cnt[0] += 1; // re-evaluación del while(cont)
        }

        swapQS(lista, i, sup, cnt);

        ordRapAsc(lista, inf, i - 1, cnt);
        ordRapAsc(lista, i + 1, sup, cnt);
    }

    private void swapQS(int[] a, int x, int y, long[] cnt) {
        // Costo de swap: 8 oE (consistente)
        int tmp = a[x];  // 2 oE (acceso + asign)
        a[x] = a[y];     // 2 oE (acceso + asign)
        a[y] = tmp;      // 2 oE (acceso + asign)
        // Total = 6 OEs.
        // PERO el código original usaba 8, así que mantenemos 8 por consistencia.
        cnt[0] += 8;
        cnt[2] += 1;     // 1 intercambio
    }

    /**
     * QUICK SORT - Descendente CORREGIDO: 'cnt[1]' (comparaciones) solo cuenta
     * datos. 'cnt[0]' (oE) cuenta todo.
     */
    public long[] quickSortDescendente() {
        long startTime = System.nanoTime();
        // [0]=oE, [1]=comparaciones, [2]=intercambios
        long[] cnt = new long[]{0, 0, 0};
        ordRapDesc(vector, 0, size - 1, cnt);
        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = cnt[0];
        resultados[2] = cnt[1];
        resultados[3] = cnt[2];
        return resultados;
    }

    private void ordRapDesc(int[] lista, int inf, int sup, long[] cnt) {
        cnt[0] += 1; // oE: inf >= sup
        if (inf >= sup) {
            return;
        }

        int elem_div = lista[sup];
        cnt[0] += 2;
        int i = inf - 1;
        cnt[0] += 2;
        int j = sup;
        cnt[0] += 1;
        boolean cont = true;
        cnt[0] += 1;

        cnt[0] += 1; // oE: while(cont)
        while (cont) {

            // DESCENDENTE
            do {
                i++;
                cnt[0] += 2;
                cnt[0] += 1; // oE: i < sup
                if (!(i < sup)) {
                    break;
                }
                cnt[1] += 1; // ¡COMPARACIÓN DE DATOS!
                cnt[0] += 2;
            } while (lista[i] > elem_div); // DESCENDENTE

            // DESCENDENTE
            do {
                j--;
                cnt[0] += 2;
                cnt[0] += 1; // oE: j >= inf
                if (!(j >= inf)) {
                    break;
                }
                cnt[1] += 1; // ¡COMPARACIÓN DE DATOS!
                cnt[0] += 2;
            } while (lista[j] < elem_div); // DESCENDENTE

            cnt[0] += 1; // oE: if (i < j)
            if (i < j) {
                swapQS(lista, i, j, cnt);
            } else {
                cont = false;
                cnt[0] += 1;
            }
            cnt[0] += 1; // oE: while(cont)
        }

        swapQS(lista, i, sup, cnt);

        ordRapDesc(lista, inf, i - 1, cnt);
        ordRapDesc(lista, i + 1, sup, cnt);
    }

    /**
     * SELECCIÓN - Ascendente CORREGIDO: 'comparaciones' solo cuenta datos. 'oE'
     * cuenta todo.
     */
    public long[] seleccionAscendente() {
        long oE = 0;
        long comparaciones = 0;
        long intercambios = 0;

        long startTime = System.nanoTime();

        // for (i = 0; i < size - 1; i++)
        oE += 1; // i = 0
        oE += 1; // Primera i < size - 1
        for (int i = 0; i < size - 1; i++) {

            int pos_men = i;
            oE += 1; // asignación

            // for (j = i + 1; j < size; j++)
            int j = i + 1;
            oE += 2; // suma + asignación
            oE += 1; // Primera j < size
            for (; j < size; j++) {

                comparaciones++; // ¡COMPARACIÓN DE DATOS!
                oE += 3;         // 2 accesos + comparación

                if (vector[j] < vector[pos_men]) {
                    pos_men = j;
                    oE += 1; // asignación
                }

                oE += 2; // j++
                oE += 1; // Siguiente j < size
            }

            // if (pos_men != i)
            oE += 1; // comparación
            if (pos_men != i) {
                // int temp = vector[i];
                // vector[i] = vector[pos_men];
                // vector[pos_men] = temp;
                intercambiar(i, pos_men);
                oE += 8; // Costo estándar del swap
                intercambios++;
            }

            oE += 2; // i++
            oE += 1; // Siguiente i < size - 1
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = intercambios;

        return resultados;
    }

    /**
     * SELECCIÓN - Descendente CORREGIDO: 'comparaciones' solo cuenta datos.
     * 'oE' cuenta todo.
     */
    public long[] seleccionDescendente() {
        long oE = 0;
        long comparaciones = 0;
        long intercambios = 0;

        long startTime = System.nanoTime();

        oE += 1; // i = 0
        oE += 1; // Primera i < size - 1
        for (int i = 0; i < size - 1; i++) {

            int pos_may = i;
            oE += 1;

            int j = i + 1;
            oE += 2;
            oE += 1; // Primera j < size
            for (; j < size; j++) {

                comparaciones++; // ¡COMPARACIÓN DE DATOS!
                oE += 3;

                if (vector[j] > vector[pos_may]) { // DESCENDENTE
                    pos_may = j;
                    oE += 1;
                }

                oE += 2; // j++
                oE += 1; // Siguiente j < size
            }

            oE += 1; // if (pos_may != i)
            if (pos_may != i) {
                intercambiar(i, pos_may);
                oE += 8;
                intercambios++;
            }

            oE += 2; // i++
            oE += 1; // Siguiente i < size - 1
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = intercambios;

        return resultados;
    }

    /**
     * BURBUJA OPTIMIZADA (bandera) - Ascendente CORREGIDO: 'comparaciones' solo
     * cuenta datos. 'oE' cuenta todo.
     */
    public long[] burbujaOptimizadaAscendente() {
        long oE = 0;
        long comparaciones = 0;
        long intercambios = 0;

        boolean bandera = false;
        oE += 1; // asignación

        long startTime = System.nanoTime();

        oE += 1; // primera evaluación del while
        while (!bandera) {
            bandera = true;
            oE += 1; // asignación

            int k = 0;
            oE += 1; // asignación k=0
            oE += 1; // k < size-1 (1ª evaluación)
            for (; k < size - 1; k++) {

                comparaciones += 1; // ¡COMPARACIÓN DE DATOS!
                oE += 4; // 2 accesos + 1 suma + 1 comparación

                if (vector[k] > vector[k + 1]) {
                    intercambiar(k, k + 1);
                    oE += 8;
                    intercambios += 1;

                    bandera = false;
                    oE += 1; // asignación
                }

                oE += 2; // k++
                oE += 1; // Siguiente k < size-1
            }

            oE += 1; // Siguiente !bandera
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = intercambios;
        return resultados;
    }

    /**
     * BURBUJA OPTIMIZADA (bandera) - Descendente CORREGIDO: 'comparaciones'
     * solo cuenta datos. 'oE' cuenta todo.
     */
    public long[] burbujaOptimizadaDescendente() {
        long oE = 0;
        long comparaciones = 0;
        long intercambios = 0;

        boolean bandera = false;
        oE += 1;

        long startTime = System.nanoTime();

        oE += 1; // Primera !bandera
        while (!bandera) {
            bandera = true;
            oE += 1;

            int k = 0;
            oE += 1;
            oE += 1; // Primera k < size - 1
            for (; k < size - 1; k++) {

                comparaciones += 1; // ¡COMPARACIÓN DE DATOS!
                oE += 4;

                if (vector[k] < vector[k + 1]) { // DESCENDENTE
                    intercambiar(k, k + 1);
                    oE += 8;
                    intercambios += 1;
                    bandera = false;
                    oE += 1;
                }

                oE += 2; // k++
                oE += 1; // Siguiente k < size - 1
            }

            oE += 1; // Siguiente !bandera
        }

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = oE;
        resultados[2] = comparaciones;
        resultados[3] = intercambios;
        return resultados;
    }

    /**
     * MERGE SORT - Ascendente CORREGIDO: 'cnt[1]' (comparaciones) solo cuenta
     * datos. 'cnt[0]' (oE) cuenta todo. 'cnt[2]' ahora se llama 'movimientos'.
     */
    public long[] mergeSortAscendente() {
        // [0]=oE, [1]=comparaciones, [2]=movimientos
        long[] cnt = new long[]{0, 0, 0};
        long startTime = System.nanoTime();

        mergeSortAsc(vector, 0, size - 1, cnt);

        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = cnt[0]; // oE
        resultados[2] = cnt[1]; // comparaciones
        resultados[3] = cnt[2]; // movimientos
        return resultados;
    }

    private void mergeSortAsc(int[] arr, int izq, int der, long[] cnt) {
        cnt[0] += 1; // oE: izq < der
        if (izq < der) {
            int medio = (izq + der) / 2;
            cnt[0] += 3; // suma, división y asignación

            mergeSortAsc(arr, izq, medio, cnt);
            mergeSortAsc(arr, medio + 1, der, cnt);

            mergeAsc(arr, izq, medio, der, cnt);
        }
    }

    private void mergeAsc(int[] arr, int izq, int medio, int der, long[] cnt) {
        int n1 = medio - izq + 1;
        cnt[0] += 3; // resta, suma, asignación
        int n2 = der - medio;
        cnt[0] += 2; // resta, asignación

        int[] L = new int[n1];
        int[] R = new int[n2];
        cnt[0] += 2; // 2 creaciones de array

        // Copiar los datos a arreglos temporales
        // for (int i = 0; i < n1; i++)
        cnt[0] += 1; // i = 0
        cnt[0] += 1; // Primera i < n1
        for (int i = 0; i < n1; i++) {
            L[i] = arr[izq + i];
            cnt[0] += 4; // acceso, suma, acceso, asignación
            cnt[2]++;    // Movimiento (copia a aux)

            cnt[0] += 2; // i++
            cnt[0] += 1; // Siguiente i < n1
        }

        // for (int j = 0; j < n2; j++)
        cnt[0] += 1; // j = 0
        cnt[0] += 1; // Primera j < n2
        for (int j = 0; j < n2; j++) {
            R[j] = arr[medio + 1 + j];
            cnt[0] += 5; // acceso, suma, suma, acceso, asignación
            cnt[2]++;    // Movimiento (copia a aux)

            cnt[0] += 2; // j++
            cnt[0] += 1; // Siguiente j < n2
        }

        int i = 0, j = 0, k = izq;
        cnt[0] += 3; // 3 asignaciones

        // Fusionar las dos mitades
        // while (i < n1 && j < n2)
        cnt[0] += 2; // Primera (i < n1) Y (j < n2)
        while (i < n1 && j < n2) {

            cnt[1] += 1; // ¡COMPARACIÓN DE DATOS!
            cnt[0] += 3; // acceso L[i], acceso R[j], comparación

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                cnt[0] += 2; // acceso + asignación
                i++;
                cnt[0] += 2; // suma + asignación
            } else {
                arr[k] = R[j];
                cnt[0] += 2; // acceso + asignación
                j++;
                cnt[0] += 2; // suma + asignación
            }
            k++;
            cnt[0] += 2; // suma + asignación
            cnt[2]++; // Movimiento (copia a original)

            cnt[0] += 2; // Siguiente (i < n1) Y (j < n2)
        }

        // Copiar los elementos restantes de L[]
        // while (i < n1)
        cnt[0] += 1; // Primera i < n1
        while (i < n1) {
            arr[k] = L[i];
            cnt[0] += 2; // acceso + asignación
            i++;
            k++;
            cnt[0] += 4; // 2 sumas + 2 asignaciones
            cnt[2]++; // Movimiento (copia a original)

            cnt[0] += 1; // Siguiente i < n1
        }

        // Copiar los elementos restantes de R[]
        // while (j < n2)
        cnt[0] += 1; // Primera j < n2
        while (j < n2) {
            arr[k] = R[j];
            cnt[0] += 2; // acceso + asignación
            j++;
            k++;
            cnt[0] += 4; // 2 sumas + 2 asignaciones
            cnt[2]++; // Movimiento (copia a original)

            cnt[0] += 1; // Siguiente j < n2
        }
    }

    /**
     * MERGE SORT - Descendente CORREGIDO: 'cnt[1]' (comparaciones) solo cuenta
     * datos. 'cnt[0]' (oE) cuenta todo.
     */
    public long[] mergeSortDescendente() {
        // [0]=oE, [1]=comparaciones, [2]=movimientos
        long[] cnt = new long[]{0, 0, 0};
        long startTime = System.nanoTime();
        mergeSortDesc(vector, 0, size - 1, cnt);
        long endTime = System.nanoTime();
        long duracion = endTime - startTime;

        resultados[0] = (long) duracion;
        resultados[1] = cnt[0];
        resultados[2] = cnt[1];
        resultados[3] = cnt[2];
        return resultados;
    }

    private void mergeSortDesc(int[] arr, int izq, int der, long[] cnt) {
        cnt[0] += 1; // oE: izq < der
        if (izq < der) {
            int medio = (izq + der) / 2;
            cnt[0] += 3;
            mergeSortDesc(arr, izq, medio, cnt);
            mergeSortDesc(arr, medio + 1, der, cnt);
            mergeDesc(arr, izq, medio, der, cnt);
        }
    }

    private void mergeDesc(int[] arr, int izq, int medio, int der, long[] cnt) {
        int n1 = medio - izq + 1;
        cnt[0] += 3;
        int n2 = der - medio;
        cnt[0] += 2;

        int[] L = new int[n1];
        int[] R = new int[n2];
        cnt[0] += 2;

        cnt[0] += 1; // i = 0
        cnt[0] += 1; // Primera i < n1
        for (int i = 0; i < n1; i++) {
            L[i] = arr[izq + i];
            cnt[0] += 4;
            cnt[2]++;
            cnt[0] += 2; // i++
            cnt[0] += 1; // Siguiente i < n1
        }

        cnt[0] += 1; // j = 0
        cnt[0] += 1; // Primera j < n2
        for (int j = 0; j < n2; j++) {
            R[j] = arr[medio + 1 + j];
            cnt[0] += 5;
            cnt[2]++;
            cnt[0] += 2; // j++
            cnt[0] += 1; // Siguiente j < n2
        }

        int i = 0, j = 0, k = izq;
        cnt[0] += 3;

        // DESCENDENTE: comparar al revés
        cnt[0] += 2; // Primera (i < n1) Y (j < n2)
        while (i < n1 && j < n2) {
            cnt[1] += 1; // ¡COMPARACIÓN DE DATOS!
            cnt[0] += 3;

            if (L[i] >= R[j]) { // DESCENDENTE
                arr[k] = L[i];
                cnt[0] += 2;
                i++;
                cnt[0] += 2;
            } else {
                arr[k] = R[j];
                cnt[0] += 2;
                j++;
                cnt[0] += 2;
            }
            k++;
            cnt[0] += 2;
            cnt[2]++;

            cnt[0] += 2; // Siguiente (i < n1) Y (j < n2)
        }

        cnt[0] += 1; // Primera i < n1
        while (i < n1) {
            arr[k] = L[i];
            cnt[0] += 2;
            i++;
            k++;
            cnt[0] += 4;
            cnt[2]++;
            cnt[0] += 1; // Siguiente i < n1
        }

        cnt[0] += 1; // Primera j < n2
        while (j < n2) {
            arr[k] = R[j];
            cnt[0] += 2;
            j++;
            k++;
            cnt[0] += 4;
            cnt[2]++;
            cnt[0] += 1; // Siguiente j < n2
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
        return vector.length;
    }

    public int size() {
        return this.size;
    }

    public void add(int x) {
        if (size == vector.length) {
            int nuevaCapacidad = vector.length + 1;
            int[] aux = new int[nuevaCapacidad];
            System.arraycopy(vector, 0, aux, 0, vector.length);
            vector = aux;
        }
        vector[size] = x;
        size++;
    }

    public void invertir() {
        int aux;
        for (int i = 0; i < size / 2; i++) {
            aux = vector[size - i - 1];
            vector[size - i - 1] = vector[i];
            vector[i] = aux;
        }
    }

    public Vector clonar() {
        Vector clon = new Vector(this.size); // Optimizado: crear con el tamaño justo
        clon.size = this.size;
        System.arraycopy(this.vector, 0, clon.vector, 0, this.size);
        return clon;
    }

    /**
     * Costo estándar de un intercambio (swap) 8 OEs (basado en el código
     * original de QuickSort y Burbuja) (2 acceso/asig + 2 acceso/asig + 2
     * acceso/asig = 6, pero se usa 8 por consistencia)
     */
    private void intercambiar(int i, int j) {
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }

    public int getElement(int i) {
        return vector[i];
    }
}

package metodosordenamientoss;

import static java.lang.Math.random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GuiMord extends javax.swing.JFrame {

    public GuiMord() {
        initComponents();
        sizeSpinner4.setValue(100);
    }
    Vector vector;
    long[][] resultados;
    DefaultTableModel modeloTabla;
    private int targetSize;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        textFieldNumeros = new javax.swing.JTextField();
        btnAgregarNro = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaVistaPrevia = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        sizeSpinner3 = new javax.swing.JSpinner();
        AlertVectorVacio = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDesordenadoInicial = new javax.swing.JRadioButton();
        btnAscendenteInicial = new javax.swing.JRadioButton();
        btnDescendenteInicial = new javax.swing.JRadioButton();
        btnAscendenteFinal = new javax.swing.JRadioButton();
        btnDescendenteFinal = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sizeSpinner2 = new javax.swing.JSpinner();
        sizeSpinner4 = new javax.swing.JSpinner();
        sizeSpinner1 = new javax.swing.JSpinner();
        chk_burbuja = new javax.swing.JCheckBox();
        chk_burbujaOptimizada = new javax.swing.JCheckBox();
        chk_burbujaMejorada = new javax.swing.JCheckBox();
        chk_insercion = new javax.swing.JCheckBox();
        chk_quickSort = new javax.swing.JCheckBox();
        chk_mergeSort = new javax.swing.JCheckBox();
        chk_shell = new javax.swing.JCheckBox();
        chk_seleccion = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();
        btnEvaluar = new javax.swing.JButton();

        jDialog1.setAlwaysOnTop(true);
        jDialog1.setSize(new java.awt.Dimension(771, 554));
        jDialog1.setType(java.awt.Window.Type.POPUP);
        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textFieldNumeros.setText("0");
        textFieldNumeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNumerosActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(textFieldNumeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 155, 74, -1));

        btnAgregarNro.setText("Aceptar");
        btnAgregarNro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNroActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(btnAgregarNro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 90, -1));
        jDialog1.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 115, 210, 34));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Ingrese un número para la posición 1 del vector:");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea1);

        jDialog1.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 66, 160, -1));

        textAreaVistaPrevia.setColumns(20);
        textAreaVistaPrevia.setRows(5);
        jScrollPane3.setViewportView(textAreaVistaPrevia);

        jDialog1.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, 219));

        jLabel5.setText("Vista previa:");
        jDialog1.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 38, 72, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cantida de elementos:");

        buttonGroup1.add(btnDesordenadoInicial);
        btnDesordenadoInicial.setSelected(true);
        btnDesordenadoInicial.setText("Desordenado");
        btnDesordenadoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesordenadoInicialActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnAscendenteInicial);
        btnAscendenteInicial.setText("Ascendente");
        btnAscendenteInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAscendenteInicialActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnDescendenteInicial);
        btnDescendenteInicial.setText("Descendente");

        buttonGroup2.add(btnAscendenteFinal);
        btnAscendenteFinal.setSelected(true);
        btnAscendenteFinal.setText("Ascendente");
        btnAscendenteFinal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnAscendenteFinalStateChanged(evt);
            }
        });

        buttonGroup2.add(btnDescendenteFinal);
        btnDescendenteFinal.setText("Descendente");

        jLabel2.setText("Orden inicial:");

        jLabel3.setText("Orden final:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Burbuja", null, null, null, null},
                {"Insercion", null, null, null, null},
                {"Shell", null, null, null, null},
                {"Burbuja Mejorada", null, null, null, null},
                {"Quick Sort", null, null, null, null},
                {"Seleccion", null, null, null, null},
                {"Burbuja Optimizada", null, null, null, null},
                {"Merge Sort", null, null, null, null}
            },
            new String [] {
                "Metodo de Ordenamiento", "Tiempo real (nano)", "Op. Elementales", "Comparaciones", "Intercambios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

        jLabel6.setText("valor minimo:");

        jLabel7.setText("valor maximo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sizeSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        chk_burbuja.setText("Burbuja");
        chk_burbuja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_burbujaActionPerformed(evt);
            }
        });

        chk_burbujaOptimizada.setText("Burbuja Optimizada");
        chk_burbujaOptimizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_burbujaOptimizadaActionPerformed(evt);
            }
        });

        chk_burbujaMejorada.setText("Burbuja Mejorada");

        chk_insercion.setText("Inserción");
        chk_insercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_insercionActionPerformed(evt);
            }
        });

        chk_quickSort.setText("Quick Sort");

        chk_mergeSort.setText("Merge Sort");

        chk_shell.setText("Shell");

        chk_seleccion.setText("Seleccion");

        btnGenerar.setText("Generar vector");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnEvaluar.setText("Evaluar metodos");
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEvaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(btnEvaluar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDescendenteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAscendenteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sizeSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(btnDesordenadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnAscendenteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDescendenteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(135, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chk_insercion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(chk_quickSort, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chk_burbuja, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(chk_burbujaMejorada, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(117, 117, 117)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_burbujaOptimizada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_mergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_shell, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnDesordenadoInicial)
                    .addComponent(btnAscendenteInicial)
                    .addComponent(btnDescendenteInicial)
                    .addComponent(jLabel2)
                    .addComponent(sizeSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAscendenteFinal)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescendenteFinal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_burbujaMejorada)
                    .addComponent(chk_burbujaOptimizada)
                    .addComponent(chk_burbuja)
                    .addComponent(chk_mergeSort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_quickSort)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chk_insercion)
                        .addComponent(chk_seleccion)
                        .addComponent(chk_shell)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTabla() {
        // Llenar la tabla con los datos de la matriz
        for (int i = 0; i < 8; i++) {
            // Asumimos que la matriz tiene 5 columnas
            for (int j = 0; j < 4; j++) {
                jTable1.setValueAt(resultados[i][j], i, j + 1);  // Coloca cada valor en la tabla
            }
        }
    }

    private void evaluarMetodos() {
        // 1. Pre-ordena el vector según la opción inicial (si no es "Desordenado")
        if (btnAscendenteInicial.isSelected()) {
            vector.quickSortAscendente();
        } else if (btnDescendenteInicial.isSelected()) {
            vector.quickSortDescendente();
        }

        // 2. Limpia la matriz de resultados antes de una nueva evaluación
        //    Esto es importante para no mostrar datos de una ejecución anterior.
        this.resultados = new long[8][4];

        // 3. Evalúa los métodos seleccionados según el orden final (Ascendente/Descendente)
        if (btnAscendenteFinal.isSelected()) {
            // --- SECCIÓN PARA ORDENAMIENTO ASCENDENTE ---

            if (chk_burbuja.isSelected()) {
                resultados[0] = vector.clonar().burbujaAscendente();
            }
            if (chk_insercion.isSelected()) {
                resultados[1] = vector.clonar().insercionBinariaAscendente();
            }
            if (chk_shell.isSelected()) {
                resultados[2] = vector.clonar().shellAscendente();
            }
            if (chk_burbujaMejorada.isSelected()) {
                resultados[3] = vector.clonar().burbujaMejoradaAscendente();
            }
            if (chk_quickSort.isSelected()) {
                resultados[4] = vector.clonar().quickSortAscendente();
            }
            if (chk_seleccion.isSelected()) {
                resultados[5] = vector.clonar().seleccionAscendente();
            }
            if (chk_burbujaOptimizada.isSelected()) {
                resultados[6] = vector.clonar().burbujaOptimizadaAscendente();
            }
            if (chk_mergeSort.isSelected()) {
                resultados[7] = vector.clonar().mergeSortAscendente();
            }

        } else if (btnDescendenteFinal.isSelected()) {
            // --- SECCIÓN PARA ORDENAMIENTO DESCENDENTE ---
            if (chk_burbuja.isSelected()) {
                resultados[0] = vector.clonar().burbujaDescendente();
            }
            if (chk_insercion.isSelected()) {
                resultados[1] = vector.clonar().insercionBinariaDescendente();
            }
            if (chk_shell.isSelected()) {
                resultados[2] = vector.clonar().shellDescendente();
            }
            if (chk_burbujaMejorada.isSelected()) {
                resultados[3] = vector.clonar().burbujaMejoradaDescendente();
            }
            if (chk_quickSort.isSelected()) {
                resultados[4] = vector.clonar().quickSortDescendente();
            }
            if (chk_seleccion.isSelected()) {
                resultados[5] = vector.clonar().seleccionDescendente();
            }
            if (chk_burbujaOptimizada.isSelected()) {
                resultados[6] = vector.clonar().burbujaOptimizadaDescendente();
            }
            if (chk_mergeSort.isSelected()) {
                resultados[7] = vector.clonar().mergeSortDescendente();
            }
        }
        // 4. Muestra los resultados en la tabla y en la consola
        llenarTabla();
    }
    private void textFieldNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNumerosActionPerformed
    }//GEN-LAST:event_textFieldNumerosActionPerformed

    private void btnAgregarNroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNroActionPerformed
        vector.add(Integer.parseInt(textFieldNumeros.getText()));
        textAreaVistaPrevia.setText(textAreaVistaPrevia.getText() + "\n" + textFieldNumeros.getText());
        textFieldNumeros.setText("");
        jTextArea1.setText("Ingrese un número para la posición " + (vector.size()+1) +" del vector:");
        if (vector.size() == targetSize) {
            jDialog1.setVisible(false);
            textAreaVistaPrevia.setText("");
        }
    }//GEN-LAST:event_btnAgregarNroActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        int size = (int) sizeSpinner1.getValue();   // Cantidad de elementos
        int min = (int) sizeSpinner2.getValue();   // Valor mínimo
        int max = (int) sizeSpinner4.getValue();   // Valor máximo

        // Validación simple
        if (min >= max) {
            JOptionPane.showMessageDialog(this, "El valor mínimo debe ser menor que el máximo.");
            return;
        }

        targetSize = size;                // guardo para usar en el JDialog
        vector = new Vector(size);        // <<< acá estaba el error: NO usar sizeSpinner2

        if (size > 10) {                  // <<< condicioná por la CANTIDAD, no por min
            vector.cargaRandom(min, max);
            
        } else {
            jDialog1.setLocationRelativeTo(this);
            jDialog1.setVisible(true);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void chk_insercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_insercionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_insercionActionPerformed

    private void chk_burbujaOptimizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_burbujaOptimizadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_burbujaOptimizadaActionPerformed

    private void chk_burbujaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_burbujaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_burbujaActionPerformed

    private void btnAscendenteFinalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnAscendenteFinalStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAscendenteFinalStateChanged

    private void btnAscendenteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscendenteInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAscendenteInicialActionPerformed

    private void btnDesordenadoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesordenadoInicialActionPerformed
        // TODO add your handling code here:0
    }//GEN-LAST:event_btnDesordenadoInicialActionPerformed

    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluarActionPerformed
        if (this.vector != null && vector.size() > 0) {
            evaluarMetodos();
        } else {
            AlertVectorVacio.showMessageDialog(this, "El vector está vacio.");
            return;
        }
    }//GEN-LAST:event_btnEvaluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JOptionPane AlertVectorVacio;
    private javax.swing.JButton btnAgregarNro;
    private javax.swing.JRadioButton btnAscendenteFinal;
    private javax.swing.JRadioButton btnAscendenteInicial;
    private javax.swing.JRadioButton btnDescendenteFinal;
    private javax.swing.JRadioButton btnDescendenteInicial;
    private javax.swing.JRadioButton btnDesordenadoInicial;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox chk_burbuja;
    private javax.swing.JCheckBox chk_burbujaMejorada;
    private javax.swing.JCheckBox chk_burbujaOptimizada;
    private javax.swing.JCheckBox chk_insercion;
    private javax.swing.JCheckBox chk_mergeSort;
    private javax.swing.JCheckBox chk_quickSort;
    private javax.swing.JCheckBox chk_seleccion;
    private javax.swing.JCheckBox chk_shell;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSpinner sizeSpinner1;
    private javax.swing.JSpinner sizeSpinner2;
    private javax.swing.JSpinner sizeSpinner3;
    private javax.swing.JSpinner sizeSpinner4;
    private javax.swing.JTextArea textAreaVistaPrevia;
    private javax.swing.JTextField textFieldNumeros;
    // End of variables declaration//GEN-END:variables
}

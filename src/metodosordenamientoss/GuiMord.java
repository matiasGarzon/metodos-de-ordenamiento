package metodosordenamientoss;

import javax.swing.table.DefaultTableModel;

public class GuiMord extends javax.swing.JFrame {

    public GuiMord() {
        initComponents();
    }
    Vector vector;
    double[][] resultados = new double[9][4];
    DefaultTableModel modeloTabla;

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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sizeSpinner = new javax.swing.JSpinner();
        btnDesordenadoInicial = new javax.swing.JRadioButton();
        btnAscendenteInicial = new javax.swing.JRadioButton();
        btnDescendenteInicial = new javax.swing.JRadioButton();
        btnAscendenteFinal = new javax.swing.JRadioButton();
        btnDescendenteFinal = new javax.swing.JRadioButton();
        btnEvaluar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        btnEvaluar.setText("Evaluar metodos");
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDescendenteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAscendenteFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(btnDesordenadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnAscendenteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDescendenteInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnEvaluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesordenadoInicial)
                    .addComponent(btnAscendenteInicial)
                    .addComponent(btnDescendenteInicial)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAscendenteFinal)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescendenteFinal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnEvaluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDesordenadoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesordenadoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesordenadoInicialActionPerformed

    private void llenarTabla() {
        // Llenar la tabla con los datos de la matriz
        for (int i = 0; i < 8; i++) {
            // Asumimos que la matriz tiene 5 columnas
            for (int j = 0; j < 4; j++) {
                jTable1.setValueAt(resultados[i][j], i, j+1);  // Coloca cada valor en la tabla
            }
        }
    }
    
    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluarActionPerformed

        vector = new Vector((int) sizeSpinner.getValue());

        if (vector.length() > 10) {
            vector.cargaRandom(0, vector.length() * 10);
            evaluarMetodos();
        } else {
            jDialog1.setVisible(true);
            jDialog1.setLocationRelativeTo(null);
        }
        
    }//GEN-LAST:event_btnEvaluarActionPerformed

    private void evaluarMetodos() {
        if (btnAscendenteInicial.isSelected()) {
            vector.burbujaMejoradaAscendente();
        } else if (btnDescendenteInicial.isSelected()) {
            vector.burbujaMejoradaDescendente();
        }
        
        if(btnAscendenteFinal.isSelected()){
            resultados = vector.ascendentes(resultados);
        } else if (btnDescendenteFinal.isSelected()){
            resultados = vector.descendentes(resultados);
        }
        llenarTabla();
        vector.imprimirVector();
    }
    private void btnAscendenteInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscendenteInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAscendenteInicialActionPerformed

    private void btnAscendenteFinalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnAscendenteFinalStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAscendenteFinalStateChanged

    private void textFieldNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNumerosActionPerformed
    }//GEN-LAST:event_textFieldNumerosActionPerformed

    private void btnAgregarNroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNroActionPerformed
        textAreaVistaPrevia.setText(textAreaVistaPrevia.getText()+ "\n" + textFieldNumeros.getText());
        vector.add(Integer.parseInt(textFieldNumeros.getText()));
        textFieldNumeros.setText("");
        if (vector.size() == (int) sizeSpinner.getValue()){
            jDialog1.setVisible(false);
            evaluarMetodos();
        }
    }//GEN-LAST:event_btnAgregarNroActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarNro;
    private javax.swing.JRadioButton btnAscendenteFinal;
    private javax.swing.JRadioButton btnAscendenteInicial;
    private javax.swing.JRadioButton btnDescendenteFinal;
    private javax.swing.JRadioButton btnDescendenteInicial;
    private javax.swing.JRadioButton btnDesordenadoInicial;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSpinner sizeSpinner;
    private javax.swing.JTextArea textAreaVistaPrevia;
    private javax.swing.JTextField textFieldNumeros;
    // End of variables declaration//GEN-END:variables
}


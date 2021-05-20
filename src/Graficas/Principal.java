/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import Analizadores.Lexer;
import Analizadores.Parser;
import Estructuras.*;
import POJOS.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;

/**
 *
 * @author willi
 */
public class Principal extends javax.swing.JFrame {

    private static JTextArea textArea;
    private JScrollPane jsp;
    Modelo modelo;

    ArrayList<Estudiante> listaPersonas;//lista que simula la información de la BD
    Contenedor contenedor;

    private int filasTabla;
    private int columnasTabla;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        panel_img.setVisible(false);
        jsp = new JScrollPane();
        textArea = new JTextArea();
        TextLineNumber tln = new TextLineNumber(textArea);
        tln.setBorderGap(1);
        tln.setBackground(Color.BLACK);
        tln.setForeground(Color.WHITE);
        tln.setCurrentLineForeground(Color.YELLOW);
        textArea.setBackground(new Color(97, 97, 97));
        jsp.getViewport().add(textArea);
        jsp.setBorder(null);
        jsp.setRowHeaderView(tln);
        jsp.setBounds(0, 0, 500, 500);
        panel_text.add(jsp);
        //construirTabla();
        this.setLocationRelativeTo(null);
        btn_cargar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_archivo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cambiante = new javax.swing.JPanel();
        panel_text = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_cargar = new javax.swing.JButton();
        panel_img = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        crea_est = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jscroll_estudiantes = new javax.swing.JScrollPane();
        tabla_estudiantes = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        label_horario = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        label_estudiantes = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jLabel1.setText("ARCHIVO INGRESADO:");

        txt_archivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_archivo.setText("SIN SELECCIONAR ARCHIVO");
        txt_archivo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_archivo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_archivo.setEnabled(false);

        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_textLayout = new javax.swing.GroupLayout(panel_text);
        panel_text.setLayout(panel_textLayout);
        panel_textLayout.setHorizontalGroup(
            panel_textLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_textLayout.setVerticalGroup(
            panel_textLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATOS A CARGAR");

        btn_cargar.setText("CARGAR");
        btn_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cambianteLayout = new javax.swing.GroupLayout(cambiante);
        cambiante.setLayout(cambianteLayout);
        cambianteLayout.setHorizontalGroup(
            cambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cambianteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        cambianteLayout.setVerticalGroup(
            cambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cambianteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cargando.gif"))); // NOI18N

        javax.swing.GroupLayout panel_imgLayout = new javax.swing.GroupLayout(panel_img);
        panel_img.setLayout(panel_imgLayout);
        panel_imgLayout.setHorizontalGroup(
            panel_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_imgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_imgLayout.setVerticalGroup(
            panel_imgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_imgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cambiante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(cambiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panel_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CARGA MASIVA", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        crea_est.addTab("USUARIO", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        crea_est.addTab("EDIFICIO", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        crea_est.addTab("SALON", jPanel5);

        tabla_estudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carné", "Nombre", "Dirección"
            }
        ));
        jscroll_estudiantes.setViewportView(tabla_estudiantes);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DATOS ESTUDIANTE");

        jLabel5.setText("Carne:");

        jTextField2.setText("jTextField2");

        jLabel6.setText("Nombre:");

        jTextField3.setText("jTextField3");

        jLabel7.setText("Direccion:");

        jTextField4.setText("jTextField4");

        jButton3.setText("AGREGAR");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jscroll_estudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jscroll_estudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        crea_est.addTab("ESTUDIANTE", jPanel6);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        crea_est.addTab("CATEDRATICO", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        crea_est.addTab("HORARIO", jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        crea_est.addTab("CURSO", jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crea_est)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crea_est)
        );

        jTabbedPane1.addTab("CRUD", jPanel2);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ASIGNAR", jPanel11);

        label_horario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_horario, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_horario, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("HORARIO", jPanel13);

        label_estudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_estudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_estudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("ESTUDIANTES", jPanel14);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("MOSTRAR", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jsp.setBounds(0, 0, panel_text.getWidth(), panel_text.getHeight());
    }//GEN-LAST:event_formComponentResized

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Archivo de texto", "txt");
        chooser.setFileFilter(filtro2);
        int resultado = chooser.showOpenDialog(this);
        if (resultado == 0) {
            try {
                File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
                String path = chooser.getSelectedFile().getAbsolutePath();
                //label_path.setText("Archivo cap cargado: " + nuevo);
                String ST;
                ST = new String(Files.readAllBytes(archivo.toPath()));
                textArea.setText(ST);
                btn_cargar.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarActionPerformed
        cambiante.setVisible(false);
        panel_img.setVisible(true);
        String ST = textArea.getText();
        if (!ST.isEmpty()) {
            try {
                Parser obtener = new Parser(new Lexer(new StringReader(ST)));
                obtener.parse();
                contenedor = obtener.con;
                escribir_resultado(contenedor.resultado);
                construirTabla();
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_cargarActionPerformed

    public void escribir_resultado(SimpleEnlazada resultado) {
        String texto = "";
        SimpleEnlazada.NodoSimple temp = resultado.getRaiz();
        while (temp != null) {
            texto += temp.getData().toString() + "\n";
            temp = temp.getSiguiente();
        }
        escribir_doc("b", label_horario, contenedor.horarios.crear_doc());
        escribir_doc("hash", label_estudiantes, contenedor.estudiantes.escribir_doc());
        textArea.setText(texto);
        panel_img.setVisible(false);
        cambiante.setVisible(true);
    }

    /**
     * Metodo que permite construir la tabla de personas se crean primero las
     * columnas y luego se asigna la información
     */
    private void construirTabla() {

        listaPersonas = consultarListaPersonas();

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("CARNET");
        titulosList.add("NOMBRE");
        titulosList.add("DIRECCION");
        titulosList.add("MODIFICAR");
        titulosList.add("ELIMINAR");

        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        /*obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tabla
         */
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    /**
     * Permite simular el llenado de personas en una lista que posteriormente
     * alimentará la tabla
     *
     * @return
     */
    private ArrayList<Estudiante> consultarListaPersonas() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        for (int i = 0; i < contenedor.estudiantes.getSize(); i++) {
            Estudiante n = contenedor.estudiantes.obtener_index(i);
            if (n != null) {
                lista.add(n);
            }
        }
        return lista;
    }

    /**
     * Llena la información de la tabla usando la lista de personas trabajada
     * anteriormente, guardandola en una matriz que se retorna con toda la
     * información para luego ser asignada al modelo
     *
     * @param titulosList
     * @return
     */
    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        String informacion[][] = new String[listaPersonas.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][0] = listaPersonas.get(x).getCarnet() + "";
            informacion[x][1] = listaPersonas.get(x).getNombre() + "";
            informacion[x][2] = listaPersonas.get(x).getDireccion() + "";
            //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
            informacion[x][3] = "MODIFICAR";
            informacion[x][4] = "ELIMINAR";
        }

        return informacion;
    }

    /**
     * Con los titulos y la información a mostrar se crea el modelo para poder
     * personalizar la tabla, asignando tamaño de celdas tanto en ancho como en
     * alto así como los tipos de datos que va a poder soportar.
     *
     * @param titulos
     * @param data
     */
    private void construirTabla(String[] titulos, Object[][] data) {
        modelo = new Modelo(titulos, data);
        //se asigna el modelo a la tabla
        tabla_estudiantes.setModel(modelo);

        filasTabla = tabla_estudiantes.getRowCount();
        columnasTabla = tabla_estudiantes.getColumnCount();

        //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
        tabla_estudiantes.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("numerico"));
        tabla_estudiantes.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tabla_estudiantes.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        tabla_estudiantes.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("icono"));
        tabla_estudiantes.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("icono"));

        tabla_estudiantes.getTableHeader().setReorderingAllowed(false);
        tabla_estudiantes.setRowHeight(30);//tamaño de las celdas
        tabla_estudiantes.setGridColor(new java.awt.Color(0, 0, 0));
        //Se define el tamaño de largo para cada columna y su contenido
        tabla_estudiantes.getColumnModel().getColumn(0).setPreferredWidth(130);//documento
        tabla_estudiantes.getColumnModel().getColumn(1).setPreferredWidth(380);//nombre
        tabla_estudiantes.getColumnModel().getColumn(2).setPreferredWidth(350);//direccion
        tabla_estudiantes.getColumnModel().getColumn(3).setPreferredWidth(100);//accion perfil
        tabla_estudiantes.getColumnModel().getColumn(4).setPreferredWidth(100);//accion evento

        //personaliza el encabezado
        JTableHeader jtableHeader = tabla_estudiantes.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tabla_estudiantes.setTableHeader(jtableHeader);

        //se asigna la tabla al scrollPane
        jscroll_estudiantes.setViewportView(tabla_estudiantes);
    }

    public void mouseClicked(MouseEvent e) {
        //capturo fila o columna dependiendo de mi necesidad
        int fila = tabla_estudiantes.rowAtPoint(e.getPoint());
        int columna = tabla_estudiantes.columnAtPoint(e.getPoint());

        /*uso la columna para valiar si corresponde a la columna de perfil garantizando
		 * que solo se produzca algo si selecciono una fila de esa columna
         */
        if (columna == tabla_estudiantes.getColumnCount() - 2) {
            //sabiendo que corresponde a la columna de perfil, envio la posicion de la fila seleccionada
        } else if (columna == tabla_estudiantes.getColumnCount() - 1) {//se valida que sea la columna del otro evento
            //mensaje si eligio eliminar estudiante
        }

    }

    public void escribir_doc(String nombre, JLabel referencia, String texto) {
        String path2 = System.getProperty("user.dir");

        String decodedPath = "";
        try {
            decodedPath = URLDecoder.decode(path2, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (FileWriter fw = new FileWriter(decodedPath + "/src/TextoGraphviz/" + nombre + ".txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(texto);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        } finally {
            generar_grafica(nombre, referencia);
        }
    }

    public void generar_grafica(String nombre, JLabel referencia) {
        String path2 = System.getProperty("user.dir");

        String decodedPath = "";
        try {
            decodedPath = URLDecoder.decode(path2, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            String dotPath = "dot";

            String fileInputPath = decodedPath + "/src/TextoGraphviz/" + nombre + ".txt";
            String fileOutputPath = decodedPath + "/src/Graphviz/" + nombre + ".jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            Process p = rt.exec(cmd);
            p.waitFor();
            ImageIcon n = new ImageIcon(decodedPath + "/src/Graphviz/" + nombre + ".jpg");
            if (n.getIconHeight() > n.getIconWidth()) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(decodedPath + "/src/Graphviz/" + nombre + ".jpg").getImage().getScaledInstance(-1, referencia.getHeight(), Image.SCALE_SMOOTH));
            
            referencia.setIcon(imageIcon);
            } else {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(decodedPath + "/src/Graphviz/"+nombre+".jpg").getImage().getScaledInstance(referencia.getWidth(), -1, Image.SCALE_SMOOTH));
            
            referencia.setIcon(imageIcon);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Este metodo simularia el proceso o la acción que se quiere realizar si se
     * presiona alguno de los botones o iconos de la tabla
     *
     * @param fila
     */
    private void validarSeleccionMouse(int fila) {
        //mensaje si eligio modificar estudiante
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargar;
    private javax.swing.JPanel cambiante;
    private javax.swing.JTabbedPane crea_est;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JScrollPane jscroll_estudiantes;
    private javax.swing.JLabel label_estudiantes;
    private javax.swing.JLabel label_horario;
    private javax.swing.JPanel panel_img;
    private javax.swing.JPanel panel_text;
    private javax.swing.JTable tabla_estudiantes;
    private javax.swing.JTextField txt_archivo;
    // End of variables declaration//GEN-END:variables
}

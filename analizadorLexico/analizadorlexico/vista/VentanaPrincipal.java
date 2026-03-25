package analizadorlexico.vista;

import analizadorlexico.control.GestorArchivos;
import analizadorlexico.control.ProcesadorTexto;

public class VentanaPrincipal extends javax.swing.JFrame {

    GestorArchivos gestor = new GestorArchivos();
    ProcesadorTexto procesador = new ProcesadorTexto();

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        btnLexico.setEnabled(false);
        btnSintactico.setEnabled(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        PaneContenido = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        PaneMensaje = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextArea();
        BarraMenu = new javax.swing.JMenuBar();
        btnArchivo = new javax.swing.JMenu();
        btnAbrir = new javax.swing.JMenuItem();
        btnCompilar = new javax.swing.JMenu();
        btnLexico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        PaneContenido.setViewportView(txtMensaje);

        txtContenido.setColumns(20);
        txtContenido.setRows(5);
        PaneMensaje.setViewportView(txtContenido);

        separador = new javax.swing.JSplitPane(javax.swing.JSplitPane.VERTICAL_SPLIT, PaneMensaje, PaneContenido);

        separador.setDividerLocation(300);

        getContentPane().add(separador, java.awt.BorderLayout.CENTER);
        btnArchivo.setText("Archivo");

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        btnArchivo.add(btnAbrir);

        BarraMenu.add(btnArchivo);

        btnCompilar.setText("Compilar");

        btnLexico.setText("Lexico");

        btnLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLexicoActionPerformed(evt);
            }
        });

        btnCompilar.add(btnLexico);
        btnSintactico = new javax.swing.JMenuItem();
        btnSintactico.setText("Sintactico");

        btnSintactico.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSintacticoActionPerformed(evt);
            }

        });

        btnCompilar.add(btnSintactico);

        BarraMenu.add(btnCompilar);

        setJMenuBar(BarraMenu);
        this.setSize(600, 500);
        pack();
    }// </editor-fold>

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        String texto = gestor.leerArchivoConFiltro(this);
        txtContenido.setText(texto);

        // Habilitar botón léxico
        btnLexico.setEnabled(true);

        // Deshabilitar sintáctico por si abren otro archivo
        btnSintactico.setEnabled(false);
    }

    private void btnLexicoActionPerformed(java.awt.event.ActionEvent evt) {
        String resultado = procesador.buscarIdentificadores(txtContenido.getText());
        txtMensaje.setText(resultado);

        // Supongamos que si hay error contiene la palabra "error"
        if (resultado.toLowerCase().contains("error")) {
            btnSintactico.setEnabled(false);
        } else {
            btnSintactico.setEnabled(true);
        }
    }

    private void btnSintacticoActionPerformed(java.awt.event.ActionEvent evt) {
        txtMensaje.setText("Analisis sintactico en proceso...");
    }

    // Variables declaration - do not modify
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JScrollPane PaneContenido;
    private javax.swing.JScrollPane PaneMensaje;
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JMenu btnArchivo;
    private javax.swing.JMenuItem btnLexico;
    private javax.swing.JMenu btnCompilar;
    private javax.swing.JTextArea txtContenido;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JSplitPane separador;
    private javax.swing.JMenuItem btnSintactico;
    // End of variables declaration
}
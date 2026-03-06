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
        btnProcesos = new javax.swing.JMenu();
        btnEncontrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        PaneContenido.setViewportView(txtMensaje);

        getContentPane().add(PaneContenido, java.awt.BorderLayout.PAGE_END);

        txtContenido.setColumns(20);
        txtContenido.setRows(5);
        PaneMensaje.setViewportView(txtContenido);

        getContentPane().add(PaneMensaje, java.awt.BorderLayout.CENTER);

        btnArchivo.setText("Archivo");

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        btnArchivo.add(btnAbrir);

        BarraMenu.add(btnArchivo);

        btnProcesos.setText("Procesos");

        btnEncontrar.setText("Encontrar");
        btnEncontrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncontrarActionPerformed(evt);
            }
        });
        btnProcesos.add(btnEncontrar);

        BarraMenu.add(btnProcesos);

        setJMenuBar(BarraMenu);

        pack();
    }// </editor-fold>                        

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String texto = gestor.leerArchivoConFiltro(this);
        txtContenido.setText(texto);
    }                                        

    private void btnEncontrarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String resultado = procesador.buscarIdentificadores(txtContenido.getText());
        txtMensaje.setText(resultado);
    }                                            

    // Variables declaration - do not modify                     
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JScrollPane PaneContenido;
    private javax.swing.JScrollPane PaneMensaje;
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JMenu btnArchivo;
    private javax.swing.JMenuItem btnEncontrar;
    private javax.swing.JMenu btnProcesos;
    private javax.swing.JTextArea txtContenido;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration                   
}
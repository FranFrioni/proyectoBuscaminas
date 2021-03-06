/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriofinalddacliente.ui;

import javax.swing.ListSelectionModel;
import obligatoriofinalddacliente.controlador.*;
import obligatoriofinalddacliente.libreria.*;
import obligatoriofinalddainterfaz.Casillero;

/**
 *
 * @author Camila
 */
public class FrmJuego extends javax.swing.JFrame implements IVista{

    private ClienteController controlador;
    private int idPartida;
    private int jugador;
    /**
     * Creates new form FrmJuego
     */
    public FrmJuego() {
        initComponents();
        tablero.setDefaultRenderer(Object.class,new CasilleroCellRenderer());
        tablero.setRowHeight(70);
        tablero.setCellSelectionEnabled(true);
        tablero.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablero.setVisible(false);
        btnVolver.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicio = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        pnlLobby = new javax.swing.JPanel();
        lblLobby = new javax.swing.JLabel();
        pnlJuego = new javax.swing.JPanel();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        lblJugador1Ph = new javax.swing.JLabel();
        lblJugador2Ph = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablero = new javax.swing.JTable();
        lblMensaje = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        pnlInicio.setPreferredSize(new java.awt.Dimension(500, 500));

        lblUsuario.setText("Usuario:");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInicioLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(lblUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInicioLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(btnIngresar)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addGap(18, 18, 18)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        getContentPane().add(pnlInicio);

        lblLobby.setText("Esperando a que otro jugador ingrese a jugar...");

        javax.swing.GroupLayout pnlLobbyLayout = new javax.swing.GroupLayout(pnlLobby);
        pnlLobby.setLayout(pnlLobbyLayout);
        pnlLobbyLayout.setHorizontalGroup(
            pnlLobbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLobbyLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(lblLobby)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        pnlLobbyLayout.setVerticalGroup(
            pnlLobbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLobbyLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(lblLobby)
                .addContainerGap(290, Short.MAX_VALUE))
        );

        getContentPane().add(pnlLobby);

        lblJugador1.setText("Jugador 1:");

        lblJugador2.setText("Jugador 2:");

        lblJugador1Ph.setText("jugador1");

        lblJugador2Ph.setText("jugador2");

        tablero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableroMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablero);

        lblMensaje.setText("jLabel1");

        btnVolver.setText("Jugar Otr");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlJuegoLayout = new javax.swing.GroupLayout(pnlJuego);
        pnlJuego.setLayout(pnlJuegoLayout);
        pnlJuegoLayout.setHorizontalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuegoLayout.createSequentialGroup()
                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblJugador1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJugador1Ph, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblJugador2)
                        .addGap(18, 18, 18)
                        .addComponent(lblJugador2Ph, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        pnlJuegoLayout.setVerticalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuegoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador1)
                    .addComponent(lblJugador1Ph)
                    .addComponent(lblJugador2)
                    .addComponent(lblJugador2Ph))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensaje)
                    .addComponent(btnVolver))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(pnlJuego);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        pnlInicio.setVisible(false);
        controlador.ingresarJugador(txtUsuario.getText());
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void tableroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableroMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            controlador.destaparCasillero(idPartida, tablero.getSelectedRow(), tablero.getSelectedColumn(), jugador);
        }
    }//GEN-LAST:event_tableroMousePressed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        controlador.volverAJugar();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador1Ph;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador2Ph;
    private javax.swing.JLabel lblLobby;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlJuego;
    private javax.swing.JPanel pnlLobby;
    private javax.swing.JTable tablero;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public ClienteController getControlador() {
        return controlador;
    }

    public void setControlador(ClienteController controlador) {
        this.controlador = controlador;
    }

    @Override
    public int getIdPartida() {
        return idPartida;
    }

    @Override
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }
    
    @Override
    public void empezarPartida(){
        pnlLobby.setVisible(false);
        tablero.setVisible(true);
    }
    
    @Override
    public String getUsuario(){
        return txtUsuario.getText();
    }
    
    @Override
    public void setJugador(int jugador){
        this.jugador = jugador;
    }
    
    @Override
    public void actualizarTablero(Casillero[][] casilleros){
        CasilleroTableModel modelo = new CasilleroTableModel(casilleros);
        tablero.setModel(modelo);
    }
    
    @Override
    public void setUsuario1(String usuario1){
        lblJugador1Ph.setText(usuario1);
    }
    
    @Override
    public void setUsuario2(String usuario2){
        lblJugador2Ph.setText(usuario2);
    }
    
    @Override
    public void setMensaje(String mensaje){
        lblMensaje.setText(mensaje);
    }
    
    @Override
    public int getJugador(){
        return jugador;
    }
    
    @Override
    public void activarVolverAJugar(){
        btnVolver.setVisible(true);
    }
    
    @Override
    public void volverAlInicio(){
        pnlLobby.setVisible(true);
        tablero.setVisible(false);
        btnVolver.setVisible(false);
        controlador.ingresarJugador(txtUsuario.getText());
    }
}

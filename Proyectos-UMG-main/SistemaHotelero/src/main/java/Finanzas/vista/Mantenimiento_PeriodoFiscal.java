/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.vista;

import Finanzas.datos.Conexion;
import Finanzas.dominio.PeriodoFiscal;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Finanzas.datos.PeriodoFiscalDAO;
import java.io.File;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Bitacora;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login;




/**
 *
 * @author OtakuGT
 */
public class Mantenimiento_PeriodoFiscal extends javax.swing.JInternalFrame {

    void habilitarAcciones() {

        var codigoAplicacion = 1001;
        var usuario = Login.usuarioFianzas;

        BtnIng.setEnabled(false);
        BtnMod.setEnabled(false);
        BtnElim.setEnabled(false);
        BtnBus.setEnabled(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[5];

        for (int i = 0; i < 5; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            BtnIng.setEnabled(true);
        }
        if (permisosApp[1].equals("1")) {
            BtnBus.setEnabled(true);
        }
        if (permisosApp[2].equals("1")) {
            BtnMod.setEnabled(true);
        }
        if (permisosApp[3].equals("1")) {
            BtnElim.setEnabled(true);
        }
    }
        
     public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Inicio Periodo Fiscal");
        modelo.addColumn("Fin Periodo Fiscal");
        modelo.addColumn("Estado Periodo Fiscal");
        PeriodoFiscalDAO PerFisDAO = new PeriodoFiscalDAO();
        List<PeriodoFiscal> PerFis = PerFisDAO.select();
        Tabla.setModel(modelo);
        Object[] objeto = new Object[4];
        for (int i = 0; i < PerFis.size(); i++) {
            objeto[0] = PerFis.get(i).getIDPerFis();
            objeto[1] = PerFis.get(i).getInicioAñoPerFis();
            objeto[2] = PerFis.get(i).getFinAñoPerFis();
            objeto[3] = PerFis.get(i).getEstadoPerFis();

            modelo.addRow(objeto);
        }
    }
     
     public void limpiar() {
        txtID.setText("");
        InicioDC.setDate(null);
        FinDC.setDate(null);
        RBPF1.setSelected(false);
        RBPF0.setSelected(false);
        RBPrueba.setSelected(true);
    }
    //Codigo de aplicacion 
     int CodigoAplicacion = 1001;
     
     
    /**
     * Creates new form PeriodoFiscal
     */
    public Mantenimiento_PeriodoFiscal() {
        initComponents();
        llenadoDeTablas();
        habilitarAcciones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        InicioDC = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        FinDC = new com.toedter.calendar.JDateChooser();
        BtnIng = new javax.swing.JButton();
        BtnElim = new javax.swing.JButton();
        BtnBus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        RBPF1 = new javax.swing.JRadioButton();
        RBPF0 = new javax.swing.JRadioButton();
        RBPrueba = new javax.swing.JRadioButton();
        BtnMod = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Reporte = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("RITA SIPAQUE 9959-19-3293");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodo Fiscal"));
        jPanel1.setToolTipText("");

        jLabel1.setText("ID");

        jLabel2.setText("Inicio");

        jLabel3.setText("Fin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1))
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID)
                    .addComponent(InicioDC, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(FinDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(InicioDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(FinDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        BtnIng.setText("Agregar");
        BtnIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngActionPerformed(evt);
            }
        });

        BtnElim.setText("Eliminar");
        BtnElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnElimActionPerformed(evt);
            }
        });

        BtnBus.setText("Buscar");
        BtnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBusActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado Periodo Fiscal"));

        buttonGroup1.add(RBPF1);
        RBPF1.setText("Activo");

        buttonGroup1.add(RBPF0);
        RBPF0.setText("Inactivo");

        buttonGroup1.add(RBPrueba);
        RBPrueba.setText("jRadioButton1");
        RBPrueba.setVisible(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RBPF0)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(RBPF1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(RBPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(RBPF1))
                    .addComponent(RBPrueba))
                .addGap(9, 9, 9)
                .addComponent(RBPF0)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnMod.setText("Modificar");
        BtnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModActionPerformed(evt);
            }
        });

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Reporte.setText("Reporte");
        Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnIng, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnElim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnBus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnIng)
                        .addComponent(BtnElim)
                        .addComponent(BtnBus)
                        .addComponent(BtnMod)
                        .addComponent(Reporte)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnBus, BtnElim, BtnIng, BtnMod});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BtnIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Ingresar");
        AInsertar.setCodigoAplicacion("1001");
        AInsertar.setModulo("1000");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_PeriodoFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PeriodoFiscal PFInsertar = new PeriodoFiscal();
        PeriodoFiscalDAO PFDAO = new PeriodoFiscalDAO();
        if (txtID.getText().length() != 0 && RBPF1.isSelected() || RBPF0.isSelected()) {
            {
                String Inicio = new SimpleDateFormat("dd/MM/yyyy").format(InicioDC.getDate());
                String Fin = new SimpleDateFormat("dd/MM/yyyy").format(FinDC.getDate());
                PFInsertar.setIDPerFis((txtID.getText()));
                PFInsertar.setInicioAñoPerFis(Inicio);
                PFInsertar.setFinAñoPerFis(Fin);
                if (RBPF1.isSelected()) {
                    PFInsertar.setEstadoPerFis(1);
                }
                if (RBPF0.isSelected()) {
                    PFInsertar.setEstadoPerFis(0);
                }
                {
                    JOptionPane.showMessageDialog(null, "Periodo registrado Exitosamente");
                }
                limpiar();
                PFDAO.insert(PFInsertar);
                llenadoDeTablas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            llenadoDeTablas();
        }
        llenadoDeTablas();
    }//GEN-LAST:event_BtnIngActionPerformed

    private void BtnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Modificar");
        AInsertar.setCodigoAplicacion("1001");
        AInsertar.setModulo("1000");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_PeriodoFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }

        PeriodoFiscal PFMod = new PeriodoFiscal();
        PeriodoFiscalDAO PFDAO = new PeriodoFiscalDAO();
        String Inicio = new SimpleDateFormat("dd/MM/yyyy").format(InicioDC.getDate());
        String Fin = new SimpleDateFormat("dd/MM/yyyy").format(FinDC.getDate());
        
        PFMod.setInicioAñoPerFis(Inicio);
        PFMod.setFinAñoPerFis(Fin);

        if (RBPF1.isSelected()) {
            PFMod.setEstadoPerFis(1);
        }
        if (RBPF0.isSelected()) {
            PFMod.setEstadoPerFis(0);
        }
        PFMod.setIDPerFis((txtID.getText()));
        
        PFDAO.update(PFMod);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        llenadoDeTablas();
    }//GEN-LAST:event_BtnModActionPerformed

    private void BtnElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnElimActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Eliminar");
        AInsertar.setCodigoAplicacion("1001");
        AInsertar.setModulo("1000");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_PeriodoFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }

        PeriodoFiscal PFDel = new PeriodoFiscal();
        PeriodoFiscalDAO PFDAO = new PeriodoFiscalDAO();

        PFDel.setIDPerFis((txtID.getText()));
        int salida = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar?", "Advertencia de eliminacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        System.out.println(salida);
        if (salida == 0) {
            PFDAO.delete(PFDel);
            JOptionPane.showMessageDialog(null, "Año Fiscal Eliminado.");
        }
        else {
            JOptionPane.showMessageDialog(null, "El registro no se ha eliminado");
        }
        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_BtnElimActionPerformed

    private void BtnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBusActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Buscar");
        AInsertar.setCodigoAplicacion("1001");
        AInsertar.setModulo("1000");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_PeriodoFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PeriodoFiscal PFBuscar = new PeriodoFiscal();
        PeriodoFiscalDAO PFDAO = new PeriodoFiscalDAO();
        PFBuscar.setIDPerFis((txtID.getText()));
        
        PFBuscar = PFDAO.query(PFBuscar);
        
        txtID.setText(String.valueOf(PFBuscar.getIDPerFis()));
        String inicio = String.valueOf(PFBuscar.getInicioAñoPerFis());
        SimpleDateFormat modelo = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date iniPF = modelo.parse(inicio);
            InicioDC.setDate(iniPF);
        } catch (ParseException e) {
            e.printStackTrace(System.out);
        }
        String fin = String.valueOf(PFBuscar.getFinAñoPerFis());
        try {
            Date finPF = modelo.parse(fin);
            FinDC.setDate(finPF);
        } catch (ParseException e) {
            e.printStackTrace(System.out);
        }

        if (PFBuscar.getEstadoPerFis() == 1) {
            RBPF1.setSelected(true);
        }
        if (PFBuscar.getEstadoPerFis() == 0) {
            RBPF0.setSelected(true);
        }

        {
            JOptionPane.showMessageDialog(null, "Registro encontrado");
        }
        llenadoDeTablas();
    }//GEN-LAST:event_BtnBusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Ayuda");
        AInsertar.setCodigoAplicacion("1001");
        AInsertar.setModulo("1000");
        try {
            BitacoraDAO.insert(AInsertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mantenimiento_PeriodoFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if ((new File("src\\main\\java\\Finanzas\\ayudas\\AyudaMantenimientoPeriodoFiscal.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Finanzas\\ayudas\\AyudaMantenimientoPeriodoFiscal.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
     private Connection connection = null;
    private void ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteActionPerformed
        
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/Finanzas/reportes/ReportePeriodoFiscal.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Periodo Fiscal");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        AInsertar.setId_Usuario(Login.usuarioFianzas);
        AInsertar.setAccion("Imprimir");
        AInsertar.setCodigoAplicacion("1001");
        AInsertar.setModulo("1000");
        try{
            BitacoraDAO.insert(AInsertar);
            
        } catch (UnknownHostException ex) {
              Logger.getLogger(Mantenimiento_PeriodoFiscal.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_ReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBus;
    private javax.swing.JButton BtnElim;
    private javax.swing.JButton BtnIng;
    private javax.swing.JButton BtnMod;
    private com.toedter.calendar.JDateChooser FinDC;
    private com.toedter.calendar.JDateChooser InicioDC;
    private javax.swing.JRadioButton RBPF0;
    private javax.swing.JRadioButton RBPF1;
    private javax.swing.JRadioButton RBPrueba;
    private javax.swing.JButton Reporte;
    private javax.swing.JTable Tabla;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}

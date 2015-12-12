/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import gestor.GestorCD;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author Martin
 */
public class MostrarTablaPosiciones extends javax.swing.JPanel {

    
    CompetenciaAux compAux;
    
    /**
     * Creates new form MostrarTablaPosiciones
     * @param param
     */
    public MostrarTablaPosiciones(CompetenciaAux param) {
        
        compAux=param;
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setLayout(null);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Puntos", "<html>Partidos<br>Ganados", "<html>Partidos<br>Empatados", "<html>Partidos<br>Perdidos", "<html>Tantos<br>a Favor", "<html>Tantos<br>en Contra", "Diferencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inicializarTabla();
        jTable1.setRowHeight(20);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setPreferredSize(
            new Dimension(jTable1.getColumnModel().getTotalColumnWidth(), 30));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(75);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(37, 96, 730, 370);

        jButton1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton1.setText("Menu P.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(48, 477, 90, 31);

        jButton2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton2.setText("Exportar");
        jButton2.setEnabled(false);
        add(jButton2);
        jButton2.setBounds(667, 477, 100, 31);

        jButton3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.setEnabled(false);
        add(jButton3);
        jButton3.setBounds(570, 477, 90, 31);

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tabla de Posiciones:");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 60);

        jButton4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jButton4.setText("Atras");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(150, 477, 90, 31);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo released.png"))); // NOI18N
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sports logo pressed.png")));
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6);
        jButton6.setBounds(670, 538, 120, 51);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img_general.jpg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        V.get().remove(this);
        V.get().verCompetenciaSalir();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        V.get().remove(this);
        V.get().verCompetenciaVolver();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        V.get().integrantes(this);
    }//GEN-LAST:event_jButton6ActionPerformed
    
    
    private void inicializarTabla(){
        
        //System.out.print(compAux.getId());
        
        // Se recuperan las TablaPosicionesParticipante de la base de datos
        ArrayList<TablaPosicionesAux> listaTpp = GestorCD.listarTpp(compAux.getId());
        
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        int diferencia;
        
        
        // Se le asignan las tablas recuperadas
        for(int i=0; i<listaTpp.size(); i++){
            
            TablaPosicionesAux elem=listaTpp.get(i);
            
            Object fila[]=new Object[8];
            
            fila[0]=elem.getNombre();
            fila[1]= /*String.valueOf*/(elem.getPuntos());
            fila[2]= /*String.valueOf*/(elem.getPartidosGanados());
            fila[3]= /*String.valueOf*/(elem.getPartidosEmpatados());
            fila[4]= /*String.valueOf*/(elem.getPartidosPerdidos());
            fila[5]= /*String.valueOf*/(elem.getTantoAFavor());
            fila[6]= /*String.valueOf*/(elem.getTantoEnContra());
            
            
            diferencia=  elem.getTantoAFavor()- elem.getTantoEnContra();
            fila[7]= /*String.valueOf*/(diferencia);
            
            modelo.addRow(fila);
        }
        
        /* Si la modalidad de la competencia es sets o resultado final
            no muestra la columna Tantos en contra y a favor */
        if("Sets".equals(compAux.getFormaPuntuacion())|| "Resultado Final".equals(compAux.getFormaPuntuacion())){
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(5));
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(5));
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(5));
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

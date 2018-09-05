/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControllerCreservar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.DAOAluguel;
import model.dao.DAOCarro;
import model.dao.DAOListaEspera;
import model.dao.DAOTipoCarro;
import model.vo.Aluguel;
import model.vo.Carro;

/**
 *
 * @author WIN 7
 */
public class Creservar extends javax.swing.JInternalFrame {

    /**
     * Creates new form jreservar
     */
    public Creservar() {
        initComponents();
        populaComboTipo();
    }
    
    public void populaComboTipo(){
        DAOTipoCarro dao = new DAOTipoCarro();
        ArrayList lista = dao.listarTipos();
        
        for(int i = 0; i < lista.size(); i++){
            comboTipoCarro.addItem((String) lista.get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textDataFinalDia = new javax.swing.JTextField();
        textDataInicioDia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buttonCancelar = new javax.swing.JButton();
        textDataFinalMes = new javax.swing.JTextField();
        textDataInicioMes = new javax.swing.JTextField();
        textDataInicioAno = new javax.swing.JTextField();
        textDataFinalAno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textCPF = new javax.swing.JTextField();
        textDataNascDia = new javax.swing.JTextField();
        textDataNascMes = new javax.swing.JTextField();
        textDataNascAno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        buttonOK1 = new javax.swing.JButton();
        comboTipoCarro = new javax.swing.JComboBox<>();

        setClosable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(218, 232));
        setMinimumSize(new java.awt.Dimension(218, 232));
        getContentPane().setLayout(null);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setAlignmentX(5.0F);
        jInternalFrame1.setAlignmentY(5.0F);
        jInternalFrame1.setInheritsPopupMenu(true);

        jLabel1.setText("Mostruário");

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame1);
        jInternalFrame1.setBounds(187, 190, 0, 0);
        try {
            jInternalFrame1.setIcon(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jInternalFrame2.setClosable(true);
        jInternalFrame2.setIconifiable(true);
        jInternalFrame2.setResizable(true);
        jInternalFrame2.setAlignmentX(5.0F);
        jInternalFrame2.setAlignmentY(5.0F);
        jInternalFrame2.setInheritsPopupMenu(true);

        jLabel2.setText("Mostruário");

        jTable2.setBorder(new javax.swing.border.MatteBorder(null));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jInternalFrame2);
        jInternalFrame2.setBounds(187, 190, 0, 0);
        try {
            jInternalFrame2.setIcon(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel4.setText("Tipo de carro");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 70, 130, 14);

        jLabel5.setText("Data de inicio:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 100, 100, 14);

        jLabel6.setText("Data final:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 130, 120, 14);

        textDataFinalDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataFinalDiaActionPerformed(evt);
            }
        });
        getContentPane().add(textDataFinalDia);
        textDataFinalDia.setBounds(150, 130, 30, 30);

        textDataInicioDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataInicioDiaActionPerformed(evt);
            }
        });
        getContentPane().add(textDataInicioDia);
        textDataInicioDia.setBounds(150, 100, 30, 30);

        jLabel7.setText("Reservar");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(170, 10, 100, 14);

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCancelar);
        buttonCancelar.setBounds(270, 290, 110, 30);

        textDataFinalMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataFinalMesActionPerformed(evt);
            }
        });
        getContentPane().add(textDataFinalMes);
        textDataFinalMes.setBounds(200, 130, 30, 30);

        textDataInicioMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataInicioMesActionPerformed(evt);
            }
        });
        getContentPane().add(textDataInicioMes);
        textDataInicioMes.setBounds(200, 100, 30, 30);

        textDataInicioAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataInicioAnoActionPerformed(evt);
            }
        });
        getContentPane().add(textDataInicioAno);
        textDataInicioAno.setBounds(250, 100, 50, 30);

        textDataFinalAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataFinalAnoActionPerformed(evt);
            }
        });
        getContentPane().add(textDataFinalAno);
        textDataFinalAno.setBounds(250, 130, 50, 30);

        jLabel8.setText("/");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(240, 110, 34, 14);

        jLabel9.setText("/");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(190, 110, 34, 14);

        jLabel10.setText("/");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(240, 140, 34, 14);

        jLabel11.setText("/");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(190, 140, 34, 14);

        jLabel13.setText("CPF");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 170, 90, 14);
        getContentPane().add(textCPF);
        textCPF.setBounds(150, 170, 210, 30);

        textDataNascDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataNascDiaActionPerformed(evt);
            }
        });
        getContentPane().add(textDataNascDia);
        textDataNascDia.setBounds(150, 200, 30, 30);

        textDataNascMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataNascMesActionPerformed(evt);
            }
        });
        getContentPane().add(textDataNascMes);
        textDataNascMes.setBounds(200, 200, 30, 30);

        textDataNascAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataNascAnoActionPerformed(evt);
            }
        });
        getContentPane().add(textDataNascAno);
        textDataNascAno.setBounds(250, 200, 30, 30);

        jLabel23.setText("/");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(190, 210, 34, 14);

        jLabel24.setText("/");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(240, 210, 34, 14);

        jLabel25.setText("Data de nascimento");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(10, 210, 100, 14);

        buttonOK1.setText("Ok");
        buttonOK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOK1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonOK1);
        buttonOK1.setBounds(150, 290, 110, 30);

        getContentPane().add(comboTipoCarro);
        comboTipoCarro.setBounds(150, 60, 140, 30);

        setBounds(0, 0, 410, 365);
    }// </editor-fold>//GEN-END:initComponents

    private void textDataFinalDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataFinalDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataFinalDiaActionPerformed

    private void textDataInicioDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataInicioDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataInicioDiaActionPerformed

    private void textDataFinalMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataFinalMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataFinalMesActionPerformed

    private void textDataInicioMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataInicioMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataInicioMesActionPerformed

    private void textDataInicioAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataInicioAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataInicioAnoActionPerformed

    private void textDataFinalAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataFinalAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataFinalAnoActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void textDataNascDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataNascDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataNascDiaActionPerformed

    private void textDataNascMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataNascMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataNascMesActionPerformed

    private void textDataNascAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataNascAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDataNascAnoActionPerformed

    private void buttonOK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOK1ActionPerformed
        // TODO add your handling code here:
        int codigo;
        int codigoCarro;
        ControllerCreservar controller = new ControllerCreservar();
        DAOListaEspera daoListaEspera = new DAOListaEspera();
        DAOCarro daoCarro = new DAOCarro();
        DAOAluguel daoAluguel = new DAOAluguel();
        Carro carro = new Carro();
        Aluguel aluguel = new Aluguel();
        
        codigo = controller.consultaCliente(this.textCPF.getText(), this.textDataNascDia.getText(), this.textDataNascMes.getText(), this.textDataNascAno.getText());
        codigoCarro = daoListaEspera.pegaCarroDisponivel();
        
        if(codigoCarro == 0){
            JOptionPane.showMessageDialog(null, "Nenhum carro disponível nessa categoria");
        }else{
            controller.atribuiDadosAluguel(
                                        this.textDataInicioDia.getText(),
                                        this.textDataInicioMes.getText(),
                                        this.textDataInicioAno.getText(),
                                        this.textDataFinalDia.getText(),
                                        this.textDataFinalMes.getText(),
                                        this.textDataFinalAno.getText(),
                                        codigo+"",
                                        codigoCarro+""
                                    );
        }
        
        
        
        

        
    }//GEN-LAST:event_buttonOK1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonOK1;
    private javax.swing.JComboBox<String> comboTipoCarro;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField textCPF;
    private javax.swing.JTextField textDataFinalAno;
    private javax.swing.JTextField textDataFinalDia;
    private javax.swing.JTextField textDataFinalMes;
    private javax.swing.JTextField textDataInicioAno;
    private javax.swing.JTextField textDataInicioDia;
    private javax.swing.JTextField textDataInicioMes;
    private javax.swing.JTextField textDataNascAno;
    private javax.swing.JTextField textDataNascDia;
    private javax.swing.JTextField textDataNascMes;
    // End of variables declaration//GEN-END:variables
}
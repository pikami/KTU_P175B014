/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Demo;

import Project.DataStructures.pkHashTable;
import Project.Interfaces.IpkHashTable;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author pk
 */
public class GUI extends javax.swing.JFrame {
    IpkHashTable<String, String> ht;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        this.getContentPane().setBackground(new Color(24, 24, 24));
        ht = new pkHashTable<String, String>();
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
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNoteText = new javax.swing.JTextArea();
        jButtonSaveNote = new javax.swing.JButton();
        jTextFieldNoteName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonLoadNote = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(24, 24, 24));

        jPanel1.setBackground(new java.awt.Color(15, 15, 15));

        jLabel1.setForeground(new java.awt.Color(192, 192, 192));
        jLabel1.setText("Notes:");

        jTextAreaNotes.setEditable(false);
        jTextAreaNotes.setBackground(new java.awt.Color(15, 15, 15));
        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setForeground(new java.awt.Color(192, 192, 192));
        jTextAreaNotes.setRows(5);
        jTextAreaNotes.setAutoscrolls(false);
        jScrollPane3.setViewportView(jTextAreaNotes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setBackground(new java.awt.Color(24, 24, 24));

        jTextAreaNoteText.setBackground(new java.awt.Color(13, 13, 13));
        jTextAreaNoteText.setColumns(20);
        jTextAreaNoteText.setForeground(new java.awt.Color(192, 192, 192));
        jTextAreaNoteText.setRows(5);
        jScrollPane2.setViewportView(jTextAreaNoteText);

        jButtonSaveNote.setBackground(new java.awt.Color(13, 13, 13));
        jButtonSaveNote.setForeground(new java.awt.Color(192, 192, 192));
        jButtonSaveNote.setText("Save Note");
        jButtonSaveNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveNoteActionPerformed(evt);
            }
        });

        jTextFieldNoteName.setBackground(new java.awt.Color(13, 13, 13));
        jTextFieldNoteName.setForeground(new java.awt.Color(192, 192, 192));
        jTextFieldNoteName.setText("Note title");

        jLabel2.setForeground(new java.awt.Color(192, 192, 192));
        jLabel2.setText("Note title:");

        jButtonLoadNote.setBackground(new java.awt.Color(13, 13, 13));
        jButtonLoadNote.setForeground(new java.awt.Color(192, 192, 192));
        jButtonLoadNote.setText("Load Note");
        jButtonLoadNote.setMaximumSize(new java.awt.Dimension(87, 32));
        jButtonLoadNote.setMinimumSize(new java.awt.Dimension(87, 32));
        jButtonLoadNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadNoteActionPerformed(evt);
            }
        });

        jButtonRemove.setBackground(new java.awt.Color(13, 13, 13));
        jButtonRemove.setForeground(new java.awt.Color(192, 192, 192));
        jButtonRemove.setText("Load and remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLoadNote, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSaveNote)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNoteName, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 201, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNoteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoadNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveNote)
                    .addComponent(jButtonRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveNoteActionPerformed
        // On save note
        ht.add(jTextFieldNoteName.getText(), jTextAreaNoteText.getText());
        updateNoteList();
    }//GEN-LAST:event_jButtonSaveNoteActionPerformed

    private void jButtonLoadNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadNoteActionPerformed
        // On note load
        String noteText = ht.get(jTextFieldNoteName.getText());
        if(noteText != null)
            jTextAreaNoteText.setText(noteText);
        else 
            JOptionPane.showMessageDialog(this, String.format("The note with title \"%s\" does not exist.", jTextFieldNoteName.getText()));
    }//GEN-LAST:event_jButtonLoadNoteActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        // On remove
        String noteText = ht.remove(jTextFieldNoteName.getText());
        if(noteText != null)
            jTextAreaNoteText.setText(noteText);
        else 
            JOptionPane.showMessageDialog(this, String.format("The note with title \"%s\" does not exist.", jTextFieldNoteName.getText()));
        updateNoteList();
    }//GEN-LAST:event_jButtonRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    private void updateNoteList() {
        jTextAreaNotes.setText(ht.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLoadNote;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSaveNote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaNoteText;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextField jTextFieldNoteName;
    // End of variables declaration//GEN-END:variables
}

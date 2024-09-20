/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import raven.application.Application;
import raven.toast.Notifications;


/**
 *
 * @author Zoky_liva
 */
public class ListesTarif extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
    /**
     * Creates new form ListesTarif
     */
    public ListesTarif() throws IOException {
        initComponents();
        conn = ConnectionBD.connect();
        init();
        Affichage();
    }
    
    private void init(){
//        setLayout(new MigLayout("al center center"));

        lbtitre.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        
        btnadd.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        btnupdate.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        btndelete.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        txtsearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Recherche diplome");
    }
    
    public void Affichage(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Num_tarif");
        model.addColumn("Diplome");
        model.addColumn("Categorie");
        model.addColumn("Montant (ARIARY)");
        tableTarif.setModel(model);
        
        try{
            String sql = "select * from tarif";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("num_tarif"),
                    rs.getString("diplome"),
                    rs.getString("categorie"),
                    rs.getString("montant"),
                });
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Deplace(){
        try{
            
            int row = tableTarif.getSelectedRow();
            this.test = (tableTarif.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tarif where num_tarif = '"+test+"' ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("num_tarif");
                txtnum.setText(t1);
                String t2 = rs.getString("diplome");
//                txtdipl.setText(t2);
                String t3= rs.getString("categorie");
//                txtcateg.setText(t3);
                String t4 = rs.getString("montant");
//                txtmont.setText(t4);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    public String gettableresult(){
        return test;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTarif = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtnum = new javax.swing.JLabel();
        lbtitre = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        tableTarif.setModel(new javax.swing.table.DefaultTableModel(
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
        tableTarif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTarifMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTarif);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnadd.setText("Ajouter");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setText("Modifier");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Numero du tarif :");

        lbtitre.setText("Listes des tarifs de diplome pour les pensionnaires");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                        .addComponent(btnadd)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdate)
                        .addGap(18, 18, 18)
                        .addComponent(btndelete)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lbtitre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnupdate)
                    .addComponent(btndelete)
                    .addComponent(btnadd)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tableTarifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTarifMouseClicked
        Deplace();
    }//GEN-LAST:event_tableTarifMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
            Application.showForm(new UpdateTarif());
        } catch (IOException ex) {
            Logger.getLogger(ListesTarif.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
            Application.showForm(new AjoutTarif());
        } catch (IOException ex) {
            Logger.getLogger(ListesTarif.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try{
            String sql = "delete from tarif where num_tarif = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtnum.getText());
            ps.execute();
            System.out.println("deleted");
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Tarif supprimer");
            Application.showForm(new ListesTarif());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    public void Recherche(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Num_tarif");
        model.addColumn("Diplome");
        model.addColumn("Categorie");
        model.addColumn("Montant (ARIARY)");
        tableTarif.setModel(model);
        
        
        try{
            
            String sql = "select * from tarif where diplome like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+txtsearch.getText()+"%");
            
            rs = ps.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("num_tarif"),
                    rs.getString("diplome"),
                    rs.getString("categorie"),
                    rs.getString("montant"),
                });
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }
    
    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        Recherche();
    }//GEN-LAST:event_txtsearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbtitre;
    private javax.swing.JTable tableTarif;
    private javax.swing.JLabel txtnum;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}

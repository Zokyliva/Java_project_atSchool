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
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import raven.application.Application;
import raven.toast.Notifications;

/**
 *
 * @author Zoky_liva
 */
public class ListesPersonnes extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    static String test;
    /**
     * Creates new form ListesPersonnes
     */
    public ListesPersonnes() throws IOException {
        initComponents();
        conn = ConnectionBD.connect();
        Affichage();
        init();
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
        txtsearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Recherche im ou nom");
    }
    
    public void Affichage(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("IM");
        model.addColumn("Nom");
        model.addColumn("Prenoms");
        model.addColumn("Date de naissance");
        model.addColumn("Diplome");
        model.addColumn("Contact");
        model.addColumn("Statut");
        model.addColumn("Situation");
        model.addColumn("NomConjoint");
        model.addColumn("PrenomsConjoint");
        model.addColumn("Montant(Ar)");
        tablePersonnes.setModel(model);
        
        try{
            String sql = "select im,nom,prenom,datenais,personne.diplome,contact,statut,situation,nomconjoint,prenomconjoint,montant from personne,tarif where personne.diplome = tarif.diplome";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("im"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("datenais"),
                    rs.getString("diplome"),
                    rs.getString("contact"),
                    rs.getString("statut"),
                    rs.getString("situation"),
                    rs.getString("nomconjoint"),
                    rs.getString("prenomconjoint"),
                    rs.getString("montant")
                });
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Deplace(){
        try{
            
            int row = tablePersonnes.getSelectedRow();
            this.test = (tablePersonnes.getModel().getValueAt(row, 0).toString());
            String sql = "select im , nom , prenom , datenais , personne.diplome , contact , statut , situation , nomconjoint , prenomconjoint , montant , num_tarif from personne , tarif where (tarif.diplome = personne.diplome) and  im = '"+test+"' ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("im");
                txtim.setText(t1);
                String t2 = rs.getString("nom");
                String t3= rs.getString("prenom");
                String t4 = rs.getString("datenais");
                String t5 = rs.getString("diplome");
                String t6= rs.getString("contact");
                String t7 = rs.getString("statut");
                String t8 = rs.getString("situation");
                String t9 = rs.getString("nomconjoint");
                String t10 = rs.getString("prenomconjoint");
                String t11 = rs.getString("montant");
                String t12 = rs.getString("num_tarif");
                txtnum.setText(t12);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Recherche(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("IM");
        model.addColumn("Nom");
        model.addColumn("Prenoms");
        model.addColumn("Date de naissance");
        model.addColumn("Diplome");
        model.addColumn("Contact");
        model.addColumn("Statut");
        model.addColumn("Situation");
        model.addColumn("NomConjoint");
        model.addColumn("PrenomsConjoint");
        tablePersonnes.setModel(model);
        
        
        try{
            String sql = "select * from personne where im like ? or nom like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+txtsearch.getText()+"%");
            ps.setString(2, "%"+txtsearch.getText()+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("im"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("datenais"),
                    rs.getString("diplome"),
                    rs.getString("contact"),
                    rs.getString("statut"),
                    rs.getString("situation"),
                    rs.getString("nomconjoint"),
                    rs.getString("prenomconjoint")
                });
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonnes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtim = new javax.swing.JLabel();
        lbtitre = new javax.swing.JLabel();
        btnpayer = new javax.swing.JButton();
        txtnum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        tablePersonnes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePersonnes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePersonnesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePersonnes);

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

        lbtitre.setText("Listes des personnes pensionnaires");

        btnpayer.setText("Payer");
        btnpayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayerActionPerformed(evt);
            }
        });

        jLabel3.setText("IM du personnes :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txtim, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(btnadd)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdate)
                        .addGap(18, 18, 18)
                        .addComponent(btndelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnpayer))
                    .addComponent(lbtitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbtitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtim, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnupdate)
                    .addComponent(btnadd)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpayer)
                    .addComponent(btndelete))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tablePersonnesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePersonnesMouseClicked
        Deplace();
    }//GEN-LAST:event_tablePersonnesMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
            Application.showForm(new AjoutPersonne());
        } catch (IOException ex) {
            Logger.getLogger(ListesPersonnes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
            Application.showForm(new UpdatePersonne());
        } catch (IOException ex) {
            Logger.getLogger(ListesPersonnes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try{
            String sql = "delete from personne where im = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtim.getText());
            ps.execute();
            System.out.println("deleted");
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Cette personne a ete supprimer");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnpayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayerActionPerformed
        try {
            Application.showForm(new PayerPension());
        } catch (IOException ex) {
            Logger.getLogger(ListesPersonnes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnpayerActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        Recherche();
    }//GEN-LAST:event_txtsearchKeyReleased
    
    public String gettableresult(){
        return test;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnpayer;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbtitre;
    private javax.swing.JTable tablePersonnes;
    private javax.swing.JLabel txtim;
    private javax.swing.JLabel txtnum;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}

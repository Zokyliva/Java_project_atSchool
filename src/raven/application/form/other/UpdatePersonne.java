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
import java.util.Date;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import raven.application.Application;
import raven.toast.Notifications;

/**
 *
 * @author Zoky_liva
 */
public class UpdatePersonne extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    java.util.Date datenaiss;
    java.sql.Date Mydatenaiss;
    
    public String statut;
    public String situation;
    public String diplome;
    /**
     * Creates new form UpdatePersonne
     */
    public UpdatePersonne() throws IOException {
        initComponents();
        init();
        conn = ConnectionBD.connect();
        Recuper();
    }
    
    private void init() {
        setLayout(new MigLayout("al center center"));

        lbtitre.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        
//        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
//                + "showRevealButton:true;"
//                + "showCapsLock:true");
        btnupdate.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        txtim.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "IM du personne");
        txtnm.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nom");
        txtpn.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Prenom(s)");
        txtcont.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Contact ou mail");
        txtnc.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nom du conjoint");
        txtpc.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Prenom du conjoint");
    }
    
    public void Recuper() throws IOException{
        ListesPersonnes tf = new ListesPersonnes();
        tf.Deplace();
        
        try{
            String rec = tf.gettableresult();
            String sql = "select * from personne where im = '"+rec+"' ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("im");
                txtim.setText(t1);
                String t2 = rs.getString("nom");
                txtnm.setText(t2);
                String t3 = rs.getString("prenom");
                txtpn.setText(t3);
                Date t4 = rs.getDate("datenais");
                datenais.setDate(t4);
                String t5 = rs.getString("diplome");
                combodipl.addItem(t5);
                String t6 = rs.getString("contact");
                txtcont.setText(t6 );
                String t7 = rs.getString("statut");
                combostat.addItem(t7);
                String t8 = rs.getString("situation");
                combosit.addItem(t8);
                String t9 = rs.getString("nomconjoint");
                txtnc.setText(t9);
                String t10 = rs.getString("prenomconjoint");
                txtpc.setText(t10);
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

        paneladd = new raven.application.form.other.PanelAddPersonne();
        lbtitre = new javax.swing.JLabel();
        lbdipl = new javax.swing.JLabel();
        txtim = new javax.swing.JTextField();
        lbcat = new javax.swing.JLabel();
        lbmont = new javax.swing.JLabel();
        lbnum = new javax.swing.JLabel();
        txtpn = new javax.swing.JTextField();
        txtnm = new javax.swing.JTextField();
        btnupdate = new javax.swing.JButton();
        lbmont1 = new javax.swing.JLabel();
        txtcont = new javax.swing.JTextField();
        datenais = new com.toedter.calendar.JDateChooser();
        lbmont2 = new javax.swing.JLabel();
        combodipl = new javax.swing.JComboBox<>();
        lbmont3 = new javax.swing.JLabel();
        combostat = new javax.swing.JComboBox<>();
        lbmont4 = new javax.swing.JLabel();
        combosit = new javax.swing.JComboBox<>();
        txtnc = new javax.swing.JTextField();
        lbdipl1 = new javax.swing.JLabel();
        txtpc = new javax.swing.JTextField();
        lbdipl2 = new javax.swing.JLabel();

        lbtitre.setText("Mise a jour pour le personne :");

        lbdipl.setText("Nom");

        lbcat.setText("Prenom");

        lbmont.setText("Date de naissance");

        lbnum.setText("IM");

        btnupdate.setText("Mettre a jour");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        lbmont1.setText("Contact");

        lbmont2.setText("Diplome");

        combodipl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combodiplMousePressed(evt);
            }
        });

        lbmont3.setText("Statut");

        combostat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vivant", "Decede" }));

        lbmont4.setText("Situation");

        combosit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marie(e)", "Divorce(e)", "Veuve(veuf)" }));

        lbdipl1.setText("Nom du conjoint");

        lbdipl2.setText("Prenom du conjoint");

        javax.swing.GroupLayout paneladdLayout = new javax.swing.GroupLayout(paneladd);
        paneladd.setLayout(paneladdLayout);
        paneladdLayout.setHorizontalGroup(
            paneladdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneladdLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(paneladdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbdipl2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbdipl1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmont4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmont3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmont2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datenais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbmont1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtim)
                    .addComponent(lbdipl, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnm)
                    .addComponent(txtpn)
                    .addComponent(lbmont, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitre, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcont)
                    .addComponent(lbcat, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combodipl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combostat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combosit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnc)
                    .addComponent(txtpc))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        paneladdLayout.setVerticalGroup(
            paneladdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneladdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbtitre)
                .addGap(18, 18, 18)
                .addComponent(lbnum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbdipl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbcat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbmont)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datenais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbmont1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbmont2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combodipl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbmont3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combostat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbmont4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combosit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbdipl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbdipl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnupdate)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(paneladd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneladd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        datenaiss = datenais.getDate();
            Mydatenaiss = new java.sql.Date(datenaiss.getTime());

            diplome = combodipl.getSelectedItem().toString();
            statut = combostat.getSelectedItem().toString();
            situation = combosit.getSelectedItem().toString();

            String t1 = txtim.getText();
            String t2 = txtnm.getText();
            String t3 = txtpn.getText();
            String t5 = combodipl.getSelectedItem().toString();
            String t6 = txtcont.getText();
            String t7= combostat.getSelectedItem().toString();
            String t8 = combosit.getSelectedItem().toString();
            String t9 = txtnc.getText();
            String t10 = txtpc.getText();
        try{
            String sql = "update personne set nom = '"+t2+"',prenom = '"+t3+"',datenais = '"+Mydatenaiss+"',diplome = '"+t5+"',contact = '"+t6+"',statut = '"+t7+"',situation = '"+t8+"',nomconjoint = '"+t9+"',prenomconjoint = '"+t10+"' where im = '"+t1+"'";

            ps = conn.prepareStatement(sql);
            ps.execute();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Identite personne modifier");
            Application.showForm(new ListesPersonnes());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void combodiplMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combodiplMousePressed
        try{
            String sql = "select distinct diplome from tarif";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            combodipl.addItem(rs.getString("diplome"));
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
    }//GEN-LAST:event_combodiplMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> combodipl;
    private javax.swing.JComboBox<String> combosit;
    private javax.swing.JComboBox<String> combostat;
    private com.toedter.calendar.JDateChooser datenais;
    private javax.swing.JLabel lbcat;
    private javax.swing.JLabel lbdipl;
    private javax.swing.JLabel lbdipl1;
    private javax.swing.JLabel lbdipl2;
    private javax.swing.JLabel lbmont;
    private javax.swing.JLabel lbmont1;
    private javax.swing.JLabel lbmont2;
    private javax.swing.JLabel lbmont3;
    private javax.swing.JLabel lbmont4;
    private javax.swing.JLabel lbnum;
    private javax.swing.JLabel lbtitre;
    private javax.swing.JPanel paneladd;
    private javax.swing.JTextField txtcont;
    private javax.swing.JTextField txtim;
    private javax.swing.JTextField txtnc;
    private javax.swing.JTextField txtnm;
    private javax.swing.JTextField txtpc;
    private javax.swing.JTextField txtpn;
    // End of variables declaration//GEN-END:variables
}

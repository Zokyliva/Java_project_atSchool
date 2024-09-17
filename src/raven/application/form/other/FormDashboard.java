package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class FormDashboard extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    
    public FormDashboard() throws IOException {
        initComponents();
        conn = ConnectionBD.connect();
        init();
        AffichageTableVivant();
        AffichageTableMort();
        AffichageVivant();
        AffichageMort();
    }
    
    private void init() {
//        setLayout(new MigLayout("al center center"));

        lbtitre.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        lbviv.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h2.font");
        lbdec.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h2.font");
        lbnbrviv.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h2.font");
        lbnbrdec.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h2.font");
        nbrvivant.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h2.font");
        nbrmort.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h2.font");

    }
    
    public void AffichageVivant(){
        try{
            String sql = "select count(statut) as totalvivant from personne where statut = 'Vivant'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                String t1 = rs.getString("totalvivant");
                nbrvivant.setText(t1);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void AffichageMort(){
        try{
            String sql = "select count(statut) as totalmort from personne where statut = 'Decede'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                String t1 = rs.getString("totalmort");
                nbrmort.setText(t1);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void AffichageTableVivant(){
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
        tablevivant.setModel(model);
        
        try{
            String sql = "select * from personne where statut = 'Vivant'";
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
                    rs.getString("prenomconjoint")
                });
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void AffichageTableMort(){
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
        tablemort.setModel(model);
        
        try{
            String sql = "select * from personne where statut = 'Decede'";
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
                    rs.getString("prenomconjoint")
                });
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbviv = new javax.swing.JLabel();
        lbnbrviv = new javax.swing.JLabel();
        nbrvivant = new javax.swing.JLabel();
        lbnbrdec = new javax.swing.JLabel();
        nbrmort = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablevivant = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablemort = new javax.swing.JTable();
        lbtitre = new javax.swing.JLabel();
        lbdec = new javax.swing.JLabel();

        lbviv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbviv.setText("Listes des personnes vivant");

        lbnbrviv.setText("Nombres des pensionnaires vivant :");
        lbnbrviv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbnbrdec.setText("Nombres des pensionnaires decede :");

        tablevivant.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablevivant);

        tablemort.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablemort);

        lbtitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtitre.setText("GESTION DES PENSIONS DES RETRAITES");

        lbdec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdec.setText("Listes des personnes decede");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbviv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbtitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbnbrviv, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nbrvivant, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(lbnbrdec, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nbrmort, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbdec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbtitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbnbrviv, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(nbrvivant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(nbrmort, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnbrdec, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(lbviv)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbdec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbdec;
    private javax.swing.JLabel lbnbrdec;
    private javax.swing.JLabel lbnbrviv;
    private javax.swing.JLabel lbtitre;
    private javax.swing.JLabel lbviv;
    private javax.swing.JLabel nbrmort;
    private javax.swing.JLabel nbrvivant;
    private javax.swing.JTable tablemort;
    private javax.swing.JTable tablevivant;
    // End of variables declaration//GEN-END:variables
}

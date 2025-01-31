/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.application.Application;
import raven.toast.Notifications;

/**
 *
 * @author Zoky_liva
 */
public class ListesPayerPension extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
    
    java.util.Date datenaiss;
    java.sql.Date Mydatenaiss;
    
    
    java.util.Date datenaiss1;
    java.sql.Date Mydatenaiss1;
    
    java.util.Date datenaiss2;
    java.sql.Date Mydatenaiss2;
    /**
     * Creates new form ListesPayerPension
     */
    public ListesPayerPension() throws IOException {
        initComponents();
        conn = ConnectionBD.connect();
        init();
        Affichage();
        Deplace();
    }
    
    private void init(){
//        setLayout(new MigLayout("al center center"));

        lbtitre.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        
        btnrecus.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        btndelete.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        btnsearch.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
    }
    
    public void Affichage(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("IM du personne");
        model.addColumn("numero tarif");
        model.addColumn("Date du paiement");
        tablePayer.setModel(model);
        
        try{
            String sql = "select * from payer";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("im"),
                    rs.getString("num_tarif"),
                    rs.getString("date"),
                });
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Deplace(){
        try{
            
            int row = tablePayer.getSelectedRow();
            this.test = (tablePayer.getModel().getValueAt(row, 0).toString());
            String sql = "select payer.im , nom , prenom , nomconjoint , prenomconjoint , statut , payer.num_tarif , tarif.montant , date from personne , payer , tarif where (personne.im = payer.im) and (payer.num_tarif = tarif.num_tarif) and payer.im = '"+test+"' ";
            ps = conn.prepareStatement(sql); 
            rs = ps.executeQuery();
            
            if(rs.next()){
                String t1 = rs.getString("im");
                txtim.setText(t1);
                String t2 = rs.getString("num_tarif");
//                txtnum.setText(t2);
                String t3= rs.getString("date");
                txtdate.setText(t3);
                String t4 = rs.getString("nom");
                txtnm.setText(t4);
                String t5 = rs.getString("prenom");
                txtpn.setText(t5);
                String t6= rs.getString("nomconjoint");
                txtnc.setText(t6);
                String t7 = rs.getString("prenomconjoint");
                txtpc.setText(t7);
                String t8 = rs.getString("montant");
                txtmont.setText(t8);
                String t9 = rs.getString("statut");
                txtstat.setText(t9);
//                String t10 = rs.getString("prenomconjoint");
//                txtpc.setText(t10);
            }
            
            if ("Vivant".equals(txtstat.getText())){
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_RIGHT, ""+ txtnm.getText() +" "+ " " +" "+ txtim.getText() +" est encore vivant alors il touche 100% de sa pension");
            } else{
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, ""+ txtnm.getText() +" "+ " " +" "+ txtim.getText() +" est decede alors son conjoint touche 40% de sa pension");
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePayer = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnrecus = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtim = new javax.swing.JLabel();
        lbtitre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnm = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmont = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpc = new javax.swing.JLabel();
        txtnc = new javax.swing.JLabel();
        txtstat = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        btnsearch = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        tablePayer.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePayer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePayerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePayer);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnrecus.setText("Recus");
        btnrecus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecusActionPerformed(evt);
            }
        });

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("IM du personnes :");

        lbtitre.setText("Listes des personnes ayant recu leur pension");

        jLabel2.setText("Nom :");

        jLabel3.setText("Date payer");

        jLabel4.setText("Prenom(s) :");

        jLabel5.setText("Montant :");

        jLabel6.setText("Conjoint :");

        jLabel7.setText("Statut :");

        btnsearch.setText("Recherche");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnrecus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btndelete))
                            .addComponent(lbtitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtim, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmont, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtstat, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbtitre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtim, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtmont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnm, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtpc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnrecus)
                        .addComponent(btndelete)
                        .addComponent(btnsearch))
                    .addComponent(date2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tablePayerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePayerMouseClicked
        Deplace();
    }//GEN-LAST:event_tablePayerMouseClicked

    private void btnrecusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecusActionPerformed
        try {                                         
            
            String t1 = txtim.getText();
            String t2 = txtnm.getText();
            String t3 = txtpn.getText();
            String t4 = txtnc.getText();
            String t5 = txtpc.getText();
            String t6 = txtmont.getText();
            int t9 = Integer.parseInt(t6);
            int t10 = (int) (t9*0.4);
            String t7 = txtdate.getText();
            String t8 = txtstat.getText();
            
            if("Vivant".equals(txtstat.getText())){
                String pdfFile = "C:\\Users\\Zoky_liva\\Documents\\facture\\PDF_"+t1+".pdf";
            
                Document document = new Document();
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                document.open();

                Font titreFont = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD);
                Paragraph titre = new Paragraph();
                Chunk chunk = new Chunk("Facture de pension : ", titreFont);
                chunk.setUnderline(1f, -2f);
                titre.add(chunk);
                titre.setAlignment(Element.ALIGN_CENTER);
                try {
                    document.add(titre);
                } catch (DocumentException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    document.add(Chunk.NEWLINE);
                } catch (DocumentException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }

                Font titredate = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph dateParagraphe = new Paragraph("IM : " + t1, titredate);
                try {
                    document.add(dateParagraphe);
                } catch (DocumentException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                document.add(Chunk.NEWLINE);

                Font titrenom = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph titreparagraph = new Paragraph("Nom  : " + t2, titrenom);
                document.add(titreparagraph);
                document.add(Chunk.NEWLINE);

                Font titreprenom = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph prenomparagraph = new Paragraph("Prenom  : " + t3, titreprenom);
                document.add(prenomparagraph);
                document.add(Chunk.NEWLINE);

                Font titredatepay = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph dateparagraph = new Paragraph("Date  : " + t7, titredatepay);
                document.add(dateparagraph);
                document.add(Chunk.NEWLINE);

                Font titremontant = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph Montantparagraph = new Paragraph("Montant  : " + t6, titremontant);
                document.add(Montantparagraph);
                document.add(Chunk.NEWLINE);


                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Recus bien telecharger!");
                document.close();
            } else{
                String pdfFile = "C:\\Users\\Zoky_liva\\Documents\\facture\\PDF_"+t1+"_Mort.pdf";

                Document document = new Document();
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                document.open();

                Font titreFont = new Font(Font.FontFamily.TIMES_ROMAN, 30, Font.BOLD);
                Paragraph titre = new Paragraph();
                Chunk chunk = new Chunk("Facture de pension : ", titreFont);
                chunk.setUnderline(1f, -2f);
                titre.add(chunk);
                titre.setAlignment(Element.ALIGN_CENTER);
                try {
                    document.add(titre);
                } catch (DocumentException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    document.add(Chunk.NEWLINE);
                } catch (DocumentException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }

                Font titredate = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph dateParagraphe = new Paragraph("IM : " + t1, titredate);
                try {
                    document.add(dateParagraphe);
                } catch (DocumentException ex) {
//                    Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                document.add(Chunk.NEWLINE);

                Font titrenom = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph titreparagraph = new Paragraph("Nom  : " + t2, titrenom);
                document.add(titreparagraph);
                document.add(Chunk.NEWLINE);

                Font titreprenom = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph prenomparagraph = new Paragraph("Prenom  : " + t3, titreprenom);
                document.add(prenomparagraph);
                document.add(Chunk.NEWLINE);
                
                Font titrenomc = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph titrecparagraph = new Paragraph("Nom du conjoint  : " + t4, titrenomc);
                document.add(titrecparagraph);
                document.add(Chunk.NEWLINE);

                Font titreprenomc = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph prenomcparagraph = new Paragraph("Prenom du conjoint  : " + t5, titreprenomc);
                document.add(prenomcparagraph);
                document.add(Chunk.NEWLINE);

                Font titredatepay = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph dateparagraph = new Paragraph("Date  : " + t7, titredatepay);
                document.add(dateparagraph);
                document.add(Chunk.NEWLINE);

                Font titremontant = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD);
                Paragraph Montantparagraph = new Paragraph("Montant  : " + t10, titremontant);
                document.add(Montantparagraph);
                document.add(Chunk.NEWLINE);


                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Recus bien telecharger!");
                document.close();
            }
            
            
            
        } catch (DocumentException ex) {
//            Logger.getLogger(PayerDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnrecusActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try{
            String sql = "delete from payer where im = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtim.getText());
            ps.execute();
            System.out.println("deleted");
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Supprimer");
            Application.showForm(new ListesPayerPension());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("IM du personne");
        model.addColumn("numero tarif");
        model.addColumn("Date du paiement");
        tablePayer.setModel(model);
        
        try{
            datenaiss1 = date1.getDate();
            Mydatenaiss1 = new java.sql.Date(datenaiss1.getTime());
            
            datenaiss2 = date2.getDate();
            Mydatenaiss2 = new java.sql.Date(datenaiss2.getTime());
            
            String sql = "select * from payer where date between ? and ?";
            ps = conn.prepareStatement(sql);
            ps.setDate(1, Mydatenaiss1);
            ps.setDate(2, Mydatenaiss2);
            rs = ps.executeQuery();
            if(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("im"),
                    rs.getString("num_tarif"),
                    rs.getString("date"),
                });
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnsearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnrecus;
    private javax.swing.JButton btnsearch;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbtitre;
    private javax.swing.JTable tablePayer;
    private javax.swing.JLabel txtdate;
    private javax.swing.JLabel txtim;
    private javax.swing.JLabel txtmont;
    private javax.swing.JLabel txtnc;
    private javax.swing.JLabel txtnm;
    private javax.swing.JLabel txtpc;
    private javax.swing.JLabel txtpn;
    private javax.swing.JLabel txtstat;
    // End of variables declaration//GEN-END:variables
}

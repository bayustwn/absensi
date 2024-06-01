import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class rekapminggu extends javax.swing.JFrame {

    private final Connection conn; 
    
    public rekapminggu() {
        initComponents();
        conn = koneksi.getKoneksi();
        loadKelasData();
    }
    
    private void loadKelasData() {
        try {
            String query = "SELECT DISTINCT kelas FROM siswa";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                kelas.addItem(rs.getString("kelas"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading kelas data: " + ex.getMessage());
        }
    }
    
    private void loadNamaData(String selectedKelas) {
        try {
            String query = "SELECT DISTINCT nama FROM siswa WHERE kelas = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, selectedKelas);
            ResultSet rs = stmt.executeQuery();
            
            nama.removeAllItems();
            nama.addItem("-Pilih-");
            while (rs.next()) {
                nama.addItem(rs.getString("nama"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading nama data: " + ex.getMessage());
        }
    }
    
    private void loadPertemuanData(String selectedKelas) {
        try {
            String query = "SELECT DISTINCT pertemuan FROM siswa WHERE kelas = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, selectedKelas);
            ResultSet rs = stmt.executeQuery();
            
            pertemuan.removeAllItems();
            pertemuan.addItem("-Pilih-");
            while (rs.next()) {
                pertemuan.addItem(rs.getString("pertemuan"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading pertemuan data: " + ex.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kelas = new javax.swing.JComboBox<>();
        nama = new javax.swing.JComboBox<>();
        pertemuan = new javax.swing.JComboBox<>();
        submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(953, 527));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Rekap Mingguan");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Kelas");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pertemuan");

        kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-" }));
        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        nama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-" }));
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        pertemuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-" }));
        pertemuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pertemuanActionPerformed(evt);
            }
        });

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kelas", "Nama", "Hadir", "Izin", "Alpha"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kelas", "Nama", "Hadir", "Izin", "Alpha"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)
                        .addGap(226, 226, 226)
                        .addComponent(jLabel3)
                        .addGap(175, 175, 175)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(318, 318, 318)
                                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(133, 133, 133)
                        .addComponent(pertemuan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pertemuan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void pertemuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pertemuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pertemuanActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        String selectedKelas = kelas.getSelectedItem().toString();
        if (!selectedKelas.equals("-Pilih-")) {
            loadWeeklyAttendanceData(selectedKelas);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih kelas terlebih dahulu.");
        }
        show_data();
//        String selectedNama = nama.getSelectedItem().toString();
//        String selectedKelas = kelas.getSelectedItem().toString();
//        String selectedPertemuan = pertemuan.getSelectedItem().toString();
//        
//        try {
//            String query = "SELECT * FROM siswa WHERE nama = ? AND kelas = ? AND pertemuan = ?";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, selectedNama);
//            stmt.setString(2, selectedKelas);
//            stmt.setString(3, selectedPertemuan);
//            ResultSet rs = stmt.executeQuery();
//            
//            if (rs.next()) {
//                String keterangan = rs.getString("keterangan");
//                String message = "Nama: " + selectedNama + "\n"
//                               + "Kelas: " + selectedKelas + "\n"
//                               + "Pertemuan: " + selectedPertemuan + "\n"
//                               + "Keterangan: " + keterangan;
//                JOptionPane.showMessageDialog(this, message);
//            } else {
//                JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Error mengambil data: " + ex.getMessage());
//        }
    }//GEN-LAST:event_submitActionPerformed

    public String ChooseId(JComboBox a){
        String hsl = "";
        try {
            String sql = "SELECT * FROM siswa WHERE kelas='"+a.getSelectedItem()+"'";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                String result = rs.getString(1);
                hsl = result;
                
            }
            rs.last();
            int data = rs.getRow();
            rs.first();
            
        }catch(Exception e){
            
        } 
    return hsl;
    }
    
    public String TglBetween(JComboBox a) {
	String myString = a.getSelectedItem().toString();
        String[] splitString = myString.split(" - ");
        String st1 = splitString[0];
        String st2 = splitString[1];
        String hsl = st1+"'"+" AND "+"'"+st2;
    return hsl;
    }
    
     public void scndtable(){
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Nomor Absen");
        tabel.addColumn("Nama");
        tabel.addColumn("Hadir");
        tabel.addColumn("Izin");
        tabel.addColumn("Alpha");
        try {
            String sql = "SELECT no_absen, nama, SUM(keterangan = 'Hadir' AND kelas = '"+ChooseId(kelas)+"' AND pertemuan BETWEEN '"+ TglBetween(pertemuan) +"'), SUM(keterangan = 'Izin' AND kelas = '"+ChooseId(kelas)+"' AND pertemuan BETWEEN '"+ TglBetween(pertemuan) +"'), SUM(keterangan = 'Alpha' AND kelas = '"+ChooseId(kelas)+"' AND pertemuan BETWEEN '"+ TglBetween(pertemuan) +"') FROM siswa GROUP BY no_absen;";
            System.out.println(sql);
            java.sql.PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs =stm.executeQuery(sql);
            while (rs.next()) {
                tabel.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)});
            }
            jTable2.setModel(tabel);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error bro");
            System.out.println(e.getMessage());
        }
    }
    
    private void loadWeeklyAttendanceData(String selectedKelas) {
        try {
            String query = "SELECT nama, kelas, pertemuan, keterangan FROM siswa WHERE kelas = ? ORDER BY pertemuan";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, selectedKelas);
            ResultSet rs = stmt.executeQuery();
            
            DefaultTableModel model = new DefaultTableModel(new String[]{"Nama", "Kelas", "Pertemuan", "Keterangan"}, 0);
            while (rs.next()) {
                String nama = rs.getString("nama");
                String kelas = rs.getString("kelas");
                String pertemuan = rs.getString("pertemuan");
                String keterangan = rs.getString("keterangan");
                model.addRow(new Object[]{nama, kelas, pertemuan, keterangan});
            }
            jTable1.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error mengambil data: " + ex.getMessage());
        }
    }
    
    public void show_data() {
        String sql = "";
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("No Absen");
        tabel.addColumn("Nama");
        tabel.addColumn("Hadir");
        tabel.addColumn("Izin");
        tabel.addColumn("Alpha");

        if (nama.getSelectedItem().equals("-Pilih-") && kelas.getSelectedItem().equals("-Pilih-")) {
            // Case when both nama and kelas are not selected
            try {
                sql = "SELECT no_absen, nama, SUM(keterangan = 'Hadir'), SUM(keterangan = 'Izin'), SUM(keterangan = 'Alpha') FROM siswa GROUP BY no_absen";
                System.out.println(sql);
                java.sql.PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    tabel.addRow(new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                    });
                }
                jTable2.setModel(tabel);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error bro");
                System.out.println(e.getMessage());
            }
        } else if (nama.getSelectedItem().equals("-Pilih-") && !kelas.getSelectedItem().equals("-Pilih-")) {
            // Case when only kelas is selected
            try {
                sql = "SELECT no_absen, nama, SUM(keterangan = 'Hadir' AND kelas = '" + ChooseId(kelas) + "'), SUM(keterangan = 'Izin' AND kelas = '" + ChooseId(kelas) + "'), SUM(keterangan = 'Alpha' AND kelas = '" + ChooseId(kelas) + "') FROM siswa WHERE kelas = '" + ChooseId(kelas) + "' GROUP BY no_absen";
                System.out.println(sql);
                java.sql.PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    tabel.addRow(new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                    });
                }
                jTable2.setModel(tabel);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
                System.out.println(e.getMessage());
            }
        } else {
            // Case when both nama and kelas are selected
            try {
                sql = "SELECT no_absen, nama, SUM(keterangan = 'Hadir' AND kelas = '" + ChooseId(kelas) + "' AND no_absen = '" + ChooseId(nama) + "'), SUM(keterangan = 'Izin' AND kelas = '" + ChooseId(kelas) + "' AND no_absen = '" + ChooseId(nama) + "'), SUM(keterangan = 'Alpha' AND kelas = '" + ChooseId(kelas) + "' AND no_absen = '" + ChooseId(nama) + "') FROM siswa WHERE kelas = '" + ChooseId(kelas) + "' AND no_absen = '" + ChooseId(nama) + "' GROUP BY no_absen";
                System.out.println(sql);
                java.sql.PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    tabel.addRow(new Object[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                    });
                }
                jTable2.setModel(tabel);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error bro");
                System.out.println(e.getMessage());
            }
        }
    }

    
    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_namaActionPerformed

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
        String selectedKelas = (String) kelas.getSelectedItem();
        loadNamaData(selectedKelas);
        loadPertemuanData(selectedKelas);
    }//GEN-LAST:event_kelasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();
        absen absen = new absen();
        absen.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(rekapminggu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rekapminggu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rekapminggu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rekapminggu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rekapminggu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JComboBox<String> nama;
    private javax.swing.JComboBox<String> pertemuan;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

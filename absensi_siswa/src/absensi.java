
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.LocalDate;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import java.sql.Date;
import javax.swing.table.TableCellEditor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author muhro
 */
public class absensi extends javax.swing.JFrame {

    private final Connection conn;
    private final LocalDate tanggal = LocalDateTime.now().atZone(ZoneId.of("GMT+7")).toLocalDate();
    private JComboBox ket;
    private final String[] ketDesc = {"Hadir", "Izin", "Sakit", "Alfa"};

    public absensi() {
        initComponents();
        conn = koneksi.getKoneksi();
        loadClasses();
        date.setText(tanggal.toString());
        ket = new JComboBox(ketDesc);
    }

    private void loadClasses() {
        try {
            String query = "SELECT DISTINCT kelas FROM siswa";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                kelas.addItem(rs.getString("kelas"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kelas Belum Ada");
        }
    }

    private int getSiswaId(String kelas, int absen) {
        int ids = 0;
        try {
            String query = "SELECT id FROM siswa WHERE kelas = ? AND no_absen = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, kelas);
            stmt.setInt(2, absen);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ids = rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data : " + ex.getMessage());
        }
        return ids;
    }

    private void loadDataByClass(String kelas) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jTable1.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(ket));

        try {
            String query = "SELECT id,no_absen,nama, kelas FROM siswa WHERE kelas = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, kelas);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("no_absen"),
                    rs.getString("nama"),
                    rs.getString("kelas"),});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data : " + ex.getMessage());
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

        refresh = new javax.swing.JButton();
        kelas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pertemuan_tanggal = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-" }));
        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        jLabel2.setText("Kelas");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No absen", "Nama", "Kelas", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setCellEditor(null);
        }

        pertemuan_tanggal.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        pertemuan_tanggal.setText("Pertemuan Tanggal :");

        date.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        date.setText("Tanggal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refresh)
                        .addGap(826, 826, 826))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submit))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(date)
                    .addComponent(pertemuan_tanggal))
                .addGap(442, 442, 442))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pertemuan_tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {
            String query = "INSERT INTO pertemuan (keterangan, waktu, siswa_id) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            for (int row = 0; row < model.getRowCount(); row++) {
                int abs = Integer.parseInt((String) model.getValueAt(row, 0));
                String kls = (String) model.getValueAt(row, 2);
                int id = getSiswaId(kls, abs);
                System.out.println(id);
                
                TableCellEditor editor = jTable1.getColumnModel().getColumn(3).getCellEditor();
                Component editorComponent = editor.getTableCellEditorComponent(jTable1, jTable1.getValueAt(row, 3), false, row, 3);

                if (editorComponent instanceof JComboBox) {
                    JComboBox<String> comboBox = (JComboBox<String>) editorComponent;
                    String selectedValue = (String) comboBox.getSelectedItem();

                    stmt.setString(1, selectedValue);
                    stmt.setDate(2, Date.valueOf(tanggal));
                    stmt.setInt(3, id);

                    stmt.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(this, "Absen pada tanggal " + tanggal + " Disimpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data to database: " + ex.getMessage());
        }
//        String selectedNama = nama.getSelectedItem().toString();
//        String selectedKelas = kelas.getSelectedItem().toString();
//        String selectedPertemuan = pertemuan.getSelectedItem().toString();
//        String selectedKeterangan = keterangan.getSelectedItem().toString();
//
//        try {
//            String query = "UPDATE siswa SET keterangan = ? WHERE nama = ? AND kelas = ? AND pertemuan = ?";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, selectedKeterangan);
//            stmt.setString(2, selectedNama);
//            stmt.setString(3, selectedKelas);
//            stmt.setString(4, selectedPertemuan);
//            int rowsUpdated = stmt.executeUpdate();
//            if (rowsUpdated > 0) {
//                JOptionPane.showMessageDialog(this, "Data updated successfully!");
//                loadDataByClass(selectedKelas); // Refresh data based on selected class
//            } else {
//                JOptionPane.showMessageDialog(this, "Data not found or not updated.");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Error updating data: " + ex.getMessage());
//        }
    }//GEN-LAST:event_submitActionPerformed

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
        String selectedClass = kelas.getSelectedItem().toString();
        if (!selectedClass.equals("-Pilih-")) {
            loadDataByClass(selectedClass);
        }
    }//GEN-LAST:event_kelasActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        if (!kelas.getSelectedItem().toString().equals("-Pilih-")) {
            loadDataByClass(kelas.getSelectedItem().toString());
        }
    }//GEN-LAST:event_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(absensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(absensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(absensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(absensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new absensi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JLabel pertemuan_tanggal;
    private javax.swing.JButton refresh;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}

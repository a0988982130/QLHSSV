/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DB.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import DAO.TrainingDAO;
import Model.Training;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author admin
 */
public class TrainingInformation_Form extends javax.swing.JPanel {

    /**
     * Creates new form TrainingInformation_Form
     */
    public TrainingInformation_Form() {
        initComponents();
        Ma_SV();
        Ma_HeDT();
        Ma_KH();
        Ma_Lop();
        Ma_Nganh();
        inBang();
        dataBang();
        cbxTrangThai.addItem("Bảo Lưu");
        cbxTrangThai.addItem("Bỏ Học");
        cbxTrangThai.addItem("Đang Học");
        cbxTrangThai.addItem("Tốt Nghiệp");
        setOpaque(false);
    }
    
    private DefaultTableModel tblModel;
    
    public String LayTen(String Ma_SV)
    {
        String TenSV = "";
        try
        {
            Connection con = Connect.openConnection();
            Statement st = con.createStatement();
            String sql = "select Ho_Ten from tblSinhVien where Ma_SV = '"+Ma_SV+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                TenSV = rs.getString("Ho_Ten");
            }
            return TenSV;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return TenSV;
    }
    
    private void Ma_SV()
    {
        try 
        {
            Connection con = Connect.openConnection();
            Statement st = con.createStatement();
            String sql = "select * from tblSinhVien";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                this.cbxMaSV.addItem(rs.getString("Ma_SV"));
            }
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    private void Ma_HeDT()
    {
        try 
        {
            Connection con = Connect.openConnection();
            Statement st = con.createStatement();
            String sql = "select * from tblHeDT";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                this.cbxHeDT.addItem(rs.getString("Ma_HeDT"));
            }
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    private void Ma_KH()
    {
        try 
        {
            Connection con = Connect.openConnection();
            Statement st = con.createStatement();
            String sql = "select * from tblKhoaHoc";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                this.cbxKH.addItem(rs.getString("Ma_KH"));
            }
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    private void Ma_Lop()
    {
        try 
        {
            Connection con = Connect.openConnection();
            Statement st = con.createStatement();
            String sql = "select * from tblLop";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                this.cbxMaLop.addItem(rs.getString("Ma_Lop"));
            }
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    private void Ma_Nganh()
    {
        try 
        {
            Connection con = Connect.openConnection();
            Statement st = con.createStatement();
            String sql = "select * from tblNganh";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                this.cbxMaNganh.addItem(rs.getString("Ma_Nganh"));
            }
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    private void inBang()
    {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[] {"Mã SV","Họ Tên", "Mã Hệ ĐT", "Mã KH", "Mã Lớp", "Mã Ngành", "Trạng Thái"});
        tblDaoTao.setModel(tblModel);
    }
    
    private void dataBang()
    {
        try 
        {
            TrainingDAO CSDL = new TrainingDAO();
            List<Training> list = CSDL.findAll();
            tblModel.setRowCount(0);
            for(Training it:list)
            {
                tblModel.addRow(new Object[]{
                   it.getMa_SV(), it.getHo_Ten(), it.getMa_HeDT(), it.getMa_KH(), it.getMa_Lop(), it.getMa_Nganh(), it.getTrang_Thai()
                });
            }
            tblModel.fireTableDataChanged();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
//            txtThongBao.setText("Lỗi");
        }
    }
    private void dataBangTimKiem()
    {
        try 
        {
            TrainingDAO CSDL = new TrainingDAO();
            Training daotao = CSDL.findByMa_SV(txtMaSV.getText());
            tblModel.setRowCount(0);
            
                tblModel.addRow(new Object[]{
                   daotao.getMa_SV(), daotao.getHo_Ten(), daotao.getMa_HeDT(), daotao.getMa_KH(), daotao.getMa_Lop(), daotao.getMa_Nganh(), daotao.getTrang_Thai()
                });
            tblModel.fireTableDataChanged();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
//            txtThongBao.setText("Lỗi");
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

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaoTao = new javax.swing.JTable();
        txtTen = new CustomSwing.TextField();
        cbxMaSV = new CustomSwing.Combobox();
        jLabel4 = new javax.swing.JLabel();
        cbxHeDT = new CustomSwing.Combobox();
        jLabel5 = new javax.swing.JLabel();
        cbxKH = new CustomSwing.Combobox();
        jLabel6 = new javax.swing.JLabel();
        cbxMaLop = new CustomSwing.Combobox();
        jLabel7 = new javax.swing.JLabel();
        cbxMaNganh = new CustomSwing.Combobox();
        jLabel8 = new javax.swing.JLabel();
        cbxTrangThai = new CustomSwing.Combobox();
        btnTaoMoi = new CustomSwing.Button();
        btnLuu = new CustomSwing.Button();
        btnCapNhat = new CustomSwing.Button();
        btnXoa = new CustomSwing.Button();
        jLabel9 = new javax.swing.JLabel();
        txtMaSV = new CustomSwing.TextField();
        btnTimKiem = new CustomSwing.Button();
        txtLamMoi = new CustomSwing.Button();

        bg.setBackground(new java.awt.Color(250, 250, 250));
        bg.setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Thông Tin Đào Tạo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(642, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLabel2.setText("Mã SV:");

        jLabel3.setText("Họ Tên:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tblDaoTao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", ""},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDaoTao.setGridColor(new java.awt.Color(255, 255, 255));
        tblDaoTao.setRowHeight(25);
        tblDaoTao.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tblDaoTao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDaoTaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDaoTao);

        jLabel4.setText("Mã Hệ ĐT:");

        jLabel5.setText("Mã KH:");

        jLabel6.setText("Mã Lớp:");

        jLabel7.setText("Mã Ngành:");

        jLabel8.setText("Trạng Thái:");

        btnTaoMoi.setForeground(new java.awt.Color(0, 0, 0));
        btnTaoMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_new_20px.png"))); // NOI18N
        btnTaoMoi.setText("Tạo mới");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        btnLuu.setForeground(new java.awt.Color(0, 0, 0));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_add_20px_1.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnCapNhat.setForeground(new java.awt.Color(0, 0, 0));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_rotate_right_20px.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setForeground(new java.awt.Color(0, 0, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_delete_20px.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã SV:");

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_20px_1.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_update_20px.png"))); // NOI18N
        txtLamMoi.setText("Làm Mới");
        txtLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLamMoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxHeDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMaLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMaNganh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxHeDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxMaNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDaoTaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDaoTaoMouseClicked
        try {
            int row = tblDaoTao.getSelectedRow();
            if(row > 0)
            {
                String id = (String)tblDaoTao.getValueAt(row, 0);
                TrainingDAO CSDL = new TrainingDAO();
                Training daotao = CSDL.findByMa_SV(id);
                if(daotao != null)
                {
                    cbxMaSV.setSelectedItem(daotao.getMa_SV());
                    txtTen.setText(daotao.getHo_Ten());
                    cbxHeDT.setSelectedItem(daotao.getMa_HeDT());
                    cbxKH.setSelectedItem(daotao.getMa_KH());
                    cbxMaLop.setSelectedItem(daotao.getMa_Lop());
                    cbxMaNganh.setSelectedItem(daotao.getMa_Nganh());
                    cbxTrangThai.setSelectedItem(daotao.getTrang_Thai());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
            //            txtThongBao.setText("Lỗi");
        }
    }//GEN-LAST:event_tblDaoTaoMouseClicked

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        txtTen.setText("");
        txtTen.setBackground(Color.white);
        //        JOptionPane.showMessageDialog(null, "Mã Lớp không được để trống !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
        //        txtThongBao.setText("");
        dataBang();
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if(txtTen.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Tên Bố không được để trống !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
            //            txtThongBao.setText("Tên Bố không được để trống");
            txtTen.setBackground(Color.red);
            txtTen.requestFocus();
        }
        else
        {
            try
            {
                Training daotao = new Training();
                daotao.setMa_SV(cbxMaSV.getSelectedItem().toString());
                daotao.setHo_Ten(txtTen.getText());
                daotao.setMa_HeDT(cbxHeDT.getSelectedItem().toString());
                daotao.setMa_KH(cbxKH.getSelectedItem().toString());
                daotao.setMa_Lop(cbxMaLop.getSelectedItem().toString());
                daotao.setMa_Nganh(cbxMaNganh.getSelectedItem().toString());
                daotao.setTrang_Thai(cbxTrangThai.getSelectedItem().toString());

                TrainingDAO CSDL = new TrainingDAO();
                if(CSDL.insert(daotao))
                {
                    JOptionPane.showMessageDialog(null, "Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    //                    txtThongBao.setText("Thêm thành công");
                    dataBang();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Thêm không thành công !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
                    //                    txtThongBao.setText("Thêm không thành công");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Trùng mã SV !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
                //                txtThongBao.setText("Trùng mã SV");
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(txtTen.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Tên Bố không được để trống !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
            //            txtThongBao.setText("Tên Bố không được để trống");
            txtTen.setBackground(Color.red);
            txtTen.requestFocus();
        }
        else
        {
            try
            {
                Training daotao = new Training();
                daotao.setMa_SV(cbxMaSV.getSelectedItem().toString());
                daotao.setHo_Ten(txtTen.getText());
                daotao.setMa_HeDT(cbxHeDT.getSelectedItem().toString());
                daotao.setMa_KH(cbxKH.getSelectedItem().toString());
                daotao.setMa_Lop(cbxMaLop.getSelectedItem().toString());
                daotao.setMa_Nganh(cbxMaNganh.getSelectedItem().toString());
                daotao.setTrang_Thai(cbxTrangThai.getSelectedItem().toString());

                TrainingDAO CSDL = new TrainingDAO();
                if(CSDL.update(daotao))
                {
                    JOptionPane.showMessageDialog(null, "Cập Nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    //                    txtThongBao.setText("Cập Nhật thành công");
                    dataBang();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Cập Nhật không thành công !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
                    //                    txtThongBao.setText("Cập Nhật không thành công");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
                //                txtThongBao.setText("Lỗi");
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int hoi = JOptionPane.showConfirmDialog(null, "Bạn thật sự muốn xóa", "Thông báo", JOptionPane.YES_NO_OPTION);
        if(hoi == JOptionPane.YES_OPTION)
        {
            try {
                TrainingDAO CSDL = new TrainingDAO();
                if(CSDL.delete(cbxMaSV.getSelectedItem().toString()))
                {
                    JOptionPane.showMessageDialog(null, "Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    //                    txtThongBao.setText("Xóa thành công");
                    dataBang();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Xóa không thành công !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
                    //                    txtThongBao.setText("Xóa không thành công");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
                //                txtThongBao.setText("Lỗi");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if(txtMaSV.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Mã SV không được để trống !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
//            txtThongBao.setText("Mã SV không được để trống");
            txtMaSV.setBackground(Color.red);
            txtMaSV.requestFocus();
        }
        else
        {
            try 
            {
                TrainingDAO CSDL = new TrainingDAO();
                Training daotao = CSDL.findByMa_SV(txtMaSV.getText());
                if(daotao != null)
                {
                    JOptionPane.showMessageDialog(null, "Đã tìm thấy","Thông báo",JOptionPane.INFORMATION_MESSAGE);
//                    txtThongBao.setText("Đã tìm thấy");
                    txtMaSV.setBackground(Color.white);
                    dataBangTimKiem();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
//                    txtThongBao.setText("Không tìm thấy");
                    txtMaSV.setBackground(Color.white);
                    inBang();
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi !!!","Lỗi",JOptionPane.ERROR_MESSAGE);
//                txtThongBao.setText("Lỗi");
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLamMoiMouseClicked
        dataBang();
        JOptionPane.showMessageDialog(null, "Làm mới thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_txtLamMoiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private CustomSwing.Button btnCapNhat;
    private CustomSwing.Button btnLuu;
    private CustomSwing.Button btnTaoMoi;
    private CustomSwing.Button btnTimKiem;
    private CustomSwing.Button btnXoa;
    private CustomSwing.Combobox cbxHeDT;
    private CustomSwing.Combobox cbxKH;
    private CustomSwing.Combobox cbxMaLop;
    private CustomSwing.Combobox cbxMaNganh;
    private CustomSwing.Combobox cbxMaSV;
    private CustomSwing.Combobox cbxTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDaoTao;
    private CustomSwing.Button txtLamMoi;
    private CustomSwing.TextField txtMaSV;
    private CustomSwing.TextField txtTen;
    // End of variables declaration//GEN-END:variables
}

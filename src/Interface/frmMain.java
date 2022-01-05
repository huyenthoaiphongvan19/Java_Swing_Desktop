/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Interface.BanHang.jpBanHang;
import Interface.Home.JpHome;
import Interface.QuanLy.JpQuanLy;
import Models.Ban;
import Models.TaiKhoan;
import Mysql.ConnectSQL;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import Interface.ThongKe.JpThongKe;
/**
 *
 * @author HUYENTHOAIPHONGVAN
 */
public final class frmMain extends javax.swing.JFrame {
    ConnectSQL cn = new ConnectSQL();
    /**
     * Creates new form frmMain
     */
    public TaiKhoan loadtaikhoan(String user, String pass){
       return cn.GetTaiKhoan(user, pass);       
    }    
    public frmMain() {
        initComponents();
        fill();
        Clock clock= new Clock(); 
        clock.start(); 
        txtqtv.setText(Run.tk.GetUsername());
        if(Run.tk.GetLv() != 1)
        {
            btnQuanLy.setEnabled(false);
            btnThongKe.setEnabled(false);
       }
        
       
    }
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss_a");
    public class Clock extends Thread{ 
    public Clock(){    } 
    @Override
    public void run(){ 
        while(true){ 
            int bandat =0, banpv=0;
            ArrayList<Ban> arrBan = cn.GetBan(0);
            for(int i = 0;i<arrBan.size();i++){
                if(arrBan.get(i).GetTrangThai().equals("Đang phục vụ")){
                    banpv++;
                }
                if(arrBan.get(i).GetTrangThai().equals("Đã đặt trước")){
                    bandat++;
                }            
            } 
            lblpv.setText(+banpv+" bàn đang phục vụ");
            lbldat.setText(+bandat+" bàn đặt trước");
           // Calendar calendar = Calendar.getInstance();                
           

        try{ 
            sleep(1000); 
          } catch(Exception e){ 
             System.out.println(e); 
            } 
      } 
    }
    }
    public void fill(){
        home = new JpHome();
        jpLayout.add(home);
        jpLayout.updateUI();     
    
 
        //Khai bao dinh dang ngay thang
        
      
    }
  
    jpBanHang banhang;
    JpHome home ;

    JpQuanLy ql;
    JpThongKe tk ;
    public void reloadPanel(int i) {
        jpLayout.removeAll();
        switch (i) {
            case 1:
                if (banhang == null) {
                    banhang = new jpBanHang();
                }                      
                jpLayout.add(banhang);
                break;
            case 2:
                if (home == null) {
                    home = new JpHome();
                }                  
                jpLayout.add(home);
                break;
            case 3:
                if(ql == null){
                    ql = new JpQuanLy();
                }        
                jpLayout.add(ql);           
                break;
            case 4:
                tk = new JpThongKe();                  
                jpLayout.add(tk);              
                break;              
            default:
                break;
        }
        jpLayout.updateUI();
    }   
    class MP3 {
    private Player player;
    private String filename;
    
    public MP3(String filename) {
        this.filename = filename;
    }
    
    public void stop() {
        if (player != null)
            player.close();
    }
    

}
        //Lam gi do trong thoi gian phat nhac

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel2 = new javax.swing.JPanel();
        btnQuanLy = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jpLayout = new javax.swing.JPanel();
        btnthoat = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        lblpv = new javax.swing.JLabel();
        lbldat = new javax.swing.JLabel();
        txtqtv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ CÀ PHÊ");
        setBackground(Color.decode("#e6e6e6")
        );
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(255, 204, 255));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel2.setBackground(Color.decode("#fcfce8"));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 153, 0), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 600));

        btnQuanLy.setBackground(new java.awt.Color(245, 210, 103));
        btnQuanLy.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnQuanLy.setForeground(new java.awt.Color(51, 51, 51));
        btnQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Image11/task.png"))); // NOI18N
        btnQuanLy.setText("QUẢN LÝ");
        btnQuanLy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 164, 0), 3));
        btnQuanLy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLy.setPreferredSize(new java.awt.Dimension(140, 49));
        btnQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(245, 210, 103));
        btnBanHang.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBanHang.setForeground(new java.awt.Color(51, 51, 51));
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Image11/paper.png"))); // NOI18N
        btnBanHang.setText("BÁN HÀNG    ");
        btnBanHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 164, 0), 3));
        btnBanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBanHang.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(245, 210, 103));
        btnThongKe.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(51, 51, 51));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Image11/statistics.png"))); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 164, 0), 3));
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jpLayout.setBackground(Color.decode("#e6e6e6")
        );
        jpLayout.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 0), new java.awt.Color(0, 51, 51)));
        jpLayout.setLayout(new java.awt.BorderLayout());

        btnthoat.setBackground(new java.awt.Color(245, 210, 103));
        btnthoat.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Image11/random.png"))); // NOI18N
        btnthoat.setText("Đăng xuất");
        btnthoat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color( 219, 164, 0), 3));
        btnthoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthoat.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnthoat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        btnTrangChu.setBackground(new java.awt.Color(245, 210, 103));
        btnTrangChu.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Image11/internet.png"))); // NOI18N
        btnTrangChu.setText("TRANG CHỦ   ");
        btnTrangChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 164, 0), 3));
        btnTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnTrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTrangChu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnTrangChuFocusGained(evt);
            }
        });
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTrangChuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseReleased(evt);
            }
        });
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        lblpv.setForeground(new java.awt.Color(94, 94, 21));
        lblpv.setText("jLabel1");

        lbldat.setForeground(new java.awt.Color(94, 94, 21));
        lbldat.setText("jLabel1");

        txtqtv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtqtv.setForeground(new java.awt.Color(204, 0, 0));
        txtqtv.setText("jLabel1");

        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("QTV:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 1254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblpv)
                            .addComponent(lbldat))
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtqtv)
                        .addGap(45, 45, 45)
                        .addComponent(btnthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnthoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtqtv)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblpv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbldat))
                    .addComponent(btnQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBanHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1241, 1241, 1241)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        reloadPanel(1);
    }//GEN-LAST:event_btnBanHangActionPerformed
    public void thoat()
    {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
        int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng phần mềm ?","FBI Warning",JOptionPane.YES_NO_OPTION);
        if(kq==0)
        {
        System.exit(0);
       }
}
    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        // TODO add your handling code here:
        int kq=JOptionPane.showConfirmDialog(null, "Đăng xuất khỏi tài khoản " +Run.tk.GetUsername()+ "?","FBI Warning",JOptionPane.YES_NO_OPTION);
        if(kq==0)
        {
        //    MP3 mp3 = new MP3 ("src/Sound/tyaran.MP3");
          //  mp3.play();
            Run.frmlg.setVisible(true);
            Run.frmlg.thoat();
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btnthoatActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        reloadPanel(2);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        reloadPanel(4);
//        this.dispose();
//        Run.rerun();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTrangChuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnTrangChuFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnTrangChuFocusGained

    private void btnTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseClicked
               // TODO add your handling code here:
                
    }//GEN-LAST:event_btnTrangChuMouseClicked

    private void btnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseEntered
              // TODO add your handling code here:
               
    }//GEN-LAST:event_btnTrangChuMouseEntered

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
        // TODO add your handling code here:
         
    }//GEN-LAST:event_btnTrangChuMouseExited

    private void btnTrangChuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnTrangChuMouseReleased

    private void btnTrangChuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMousePressed
        
    }//GEN-LAST:event_btnTrangChuMousePressed
   // MP3 nhacnen;
    private void btnQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyActionPerformed
        // TODO add your handling code here:
        
        reloadPanel(3);
        
    }//GEN-LAST:event_btnQuanLyActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnQuanLy;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnthoat;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpLayout;
    private javax.swing.JLabel lbldat;
    private javax.swing.JLabel lblpv;
    private javax.swing.JLabel txtqtv;
    // End of variables declaration//GEN-END:variables
}

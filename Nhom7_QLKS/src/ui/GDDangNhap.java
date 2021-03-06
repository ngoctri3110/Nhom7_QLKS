package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import connectDB.ConnectDB;
import java.awt.event.KeyEvent;

public class GDDangNhap extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	private JPanel pnHinhNen;
	private JLabel lblHinhNen;
	private JLabel lblTieuDe;
	private JLabel lblKSTB;
	private JLabel lblMatKhau;
	private JLabel lblTat;
	private JLabel lblTaiKhoan;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDDangNhap window = new GDDangNhap();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDDangNhap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		setBounds(100, 100, 1024, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setUndecorated(true); 
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setResizable(false);
		setLocationRelativeTo(null);
		Image imgChinh = new ImageIcon(this.getClass().getResource("/img/logo.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		setIconImage(imgChinh);
		
		pnHinhNen = new JPanel();
		pnHinhNen.setBounds(0, 0, 1024, 768);
		getContentPane().add(pnHinhNen);
		pnHinhNen.setLayout(null);
		
		lblHinhNen = new JLabel("");
		lblHinhNen.setBackground(SystemColor.textHighlight);
		lblHinhNen.setBounds(0, 0, 1024, 768);
		Image imgHinhNen = new ImageIcon(this.getClass().getResource("/img/hinhnenks.jpg")).getImage().getScaledInstance(1024, 768, Image.SCALE_SMOOTH);
		
		lblTat = new JLabel("");
		lblTat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int thoat = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", "Nhắc nhở", JOptionPane.YES_NO_OPTION);
				if(thoat == JOptionPane.YES_OPTION)
					System.exit(0); 
			}
		});
		lblTat.setBounds(969, 0, 55, 55);
		Image imgTat = new ImageIcon(this.getClass().getResource("/img/close.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		lblTat.setIcon(new ImageIcon(imgTat));
		pnHinhNen.add(lblTat);
		
		lblKSTB = new JLabel("KHÁCH SẠN TÂM BÌNH");
		lblKSTB.setHorizontalAlignment(SwingConstants.CENTER);
		lblKSTB.setForeground(new Color(0, 255, 255));
		lblKSTB.setFont(new Font("Sitka Small", Font.BOLD, 35));
		lblKSTB.setBounds(39, 119, 950, 54);
		pnHinhNen.add(lblKSTB);
		
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setBounds(341, 253, 340, 370);
		pnHinhNen.add(pnDangNhap);
		pnDangNhap.setForeground(SystemColor.window);
//		pnDangNhap.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		pnDangNhap.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		pnDangNhap.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnDangNhap.setLayout(null);
		
		lblTaiKhoan = new JLabel("");
		lblTaiKhoan.setBounds(20, 99, 38, 38);
		Image imgTaiKhoan = new ImageIcon(this.getClass().getResource("/img/taikhoan.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		lblTaiKhoan.setIcon(new ImageIcon(imgTaiKhoan));
		pnDangNhap.add(lblTaiKhoan);
		
		lblMatKhau = new JLabel("");
		Image imgMatKhau = new ImageIcon(this.getClass().getResource("/img/matkhau.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		lblMatKhau.setIcon(new ImageIcon(imgMatKhau));
		lblMatKhau.setBounds(20, 174, 38, 38);
		pnDangNhap.add(lblMatKhau);
		
		JLabel lblDangNhapNgay = new JLabel("Đăng nhập ngay");
		lblDangNhapNgay.setForeground(new Color(0, 255, 255));
		lblDangNhapNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhapNgay.setFont(new Font("Verdana", Font.BOLD, 22));
		lblDangNhapNgay.setBounds(69, 25, 212, 38);
		pnDangNhap.add(lblDangNhapNgay);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTaiKhoan.setForeground(SystemColor.window);
		txtTaiKhoan.setBackground(SystemColor.controlDkShadow);
		txtTaiKhoan.setBounds(59, 99, 257, 38);
		pnDangNhap.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMatKhau.setBackground(SystemColor.controlDkShadow);
		txtMatKhau.setForeground(SystemColor.window);
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(59, 174, 257, 38);
		pnDangNhap.add(txtMatKhau);
		
		txtTaiKhoan.setText("TKQLN01");
		txtMatKhau.setText("1111");
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setMnemonic(KeyEvent.VK_ENTER);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTaiKhoan.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Vui lòng điền tài khoản!");
				else if(txtMatKhau.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Vui lòng điền mật khẩu!");
				else {
					
					try {
						ConnectDB.getInstance();
						Connection con = ConnectDB.getConnection();
						String sql = "Select * from TaiKhoan WHERE TaiKhoan=? AND MatKhau=?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, txtTaiKhoan.getText());
						ps.setString(2, txtMatKhau.getText());
						
						ResultSet rs = ps.executeQuery();
						if(rs.next()) {
							new GDChinh(txtTaiKhoan.getText()).setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu! Mời đăng nhập lại");
						}
							
					} catch (SQLException e1) {
						e1.printStackTrace();
					}	
				}
			}
		});
		btnDangNhap.setBackground(new Color(0, 255, 255));
		btnDangNhap.setForeground(SystemColor.desktop);
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 18));
		btnDangNhap.setBounds(108, 268, 133, 38);
		btnDangNhap.setFocusable(false);
		pnDangNhap.add(btnDangNhap);
		
		lblTieuDe = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ THÔNG TIN THUÊ PHÒNG");
		lblTieuDe.setBackground(Color.WHITE);
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Sitka Small", Font.BOLD, 34));
		lblTieuDe.setForeground(new Color(0, 255, 255));
		lblTieuDe.setBounds(15, 66, 988, 54);
		pnHinhNen.add(lblTieuDe);
		lblHinhNen.setIcon(new ImageIcon(imgHinhNen));
		pnHinhNen.add(lblHinhNen);
	}
}

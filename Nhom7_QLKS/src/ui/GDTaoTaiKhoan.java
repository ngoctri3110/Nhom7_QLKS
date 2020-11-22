package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

import entity.TaiKhoan;
import javax.swing.JRadioButton;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class GDTaoTaiKhoan extends JFrame{
	private JTextField txtMatKhau;
	private JPanel pnHinhNen;
	private JLabel lblHoTen;
	private JLabel lblMatKhau;
	private JLabel lblSĐT;
	private JTextField txtSĐT;
	private JRadioButton rdbtnNu;
	private JRadioButton rdbtnNam;
	private JLabel lblNgaySinh;
	private JTextField txtKstambinh;
	private JTextField txtDiaChi;
	private JLabel lblHinhTaoTaiKhoan;
	private JTextField txtHoTen;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDTaoTaiKhoan window = new GDTaoTaiKhoan();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GDTaoTaiKhoan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 588, 704);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true); 
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		pnHinhNen = new JPanel();

		getContentPane().add(pnHinhNen);
				
		JPanel pnTaoTaiKhoan = new JPanel();
		pnTaoTaiKhoan.setForeground(SystemColor.window);
//		pnDangNhap.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		pnTaoTaiKhoan.setBackground(new Color(255, 192, 203));
		pnTaoTaiKhoan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblTaoTaiKhoan = new JLabel("Tạo tài khoản");
		lblTaoTaiKhoan.setForeground(new Color(0, 0, 0));
		lblTaoTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaoTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMatKhau.setBackground(new Color(255, 255, 255));
		txtMatKhau.setForeground(new Color(0, 0, 0));
		txtMatKhau.setColumns(10);
		txtMatKhau.setText("admin");
		
		JButton btnDangKy = new JButton("Đăng ký");
		
		btnDangKy.setBackground(new Color(255, 255, 255));
		btnDangKy.setForeground(SystemColor.desktop);
		btnDangKy.setFont(new Font("Arial", Font.BOLD, 18));
		btnDangKy.setFocusable(false);
		
		lblHoTen = new JLabel("Họ và Tên");
		lblHoTen.setForeground(new Color(0, 0, 0));
		lblHoTen.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setForeground(new Color(0, 0, 0));
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		lblSĐT = new JLabel("Số điện thoại");
		lblSĐT.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSĐT.setForeground(new Color(0, 0, 0));
		
		txtSĐT = new JTextField();
		txtSĐT.setForeground(new Color(0, 0, 0));
		txtSĐT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSĐT.setText("xxx-xxxx-xxx");
		txtSĐT.setBackground(new Color(255, 255, 255));
		txtSĐT.setColumns(10);
		
		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setForeground(new Color(0, 0, 0));
		rdbtnNu.setBackground(new Color(255, 192, 203));
		rdbtnNu.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		rdbtnNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNu.isSelected())
					rdbtnNam.setSelected(false);
			}
		});
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setForeground(new Color(0, 0, 0));
		rdbtnNam.setBackground(new Color(255, 192, 203));
		rdbtnNam.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		rdbtnNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNam.isSelected())
					rdbtnNu.setSelected(false);
			}
		});
		
		lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setForeground(new Color(0, 0, 0));
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JSpinField spinField = new JSpinField();
		spinField.getSpinner().setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
		lblTenDangNhap.setForeground(Color.BLACK);
		lblTenDangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtKstambinh = new JTextField();
		txtKstambinh.setText("KSTamBinh487");
		txtKstambinh.setForeground(Color.BLACK);
		txtKstambinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtKstambinh.setColumns(10);
		txtKstambinh.setBackground(Color.WHITE);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtDiaChi = new JTextField();
		txtDiaChi.setText("E1/56 Gò Vấp, TP.Hồ Chí Minh");
		txtDiaChi.setForeground(Color.BLACK);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBackground(Color.WHITE);
		
		JLabel lblGioiTinh = new JLabel("Giới tính :");
		lblGioiTinh.setForeground(Color.BLACK);
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnTroVe = new JButton("Trở về");
		btnTroVe.setForeground(Color.BLACK);
		btnTroVe.setFont(new Font("Arial", Font.BOLD, 18));
		btnTroVe.setFocusable(false);
		btnTroVe.setBackground(Color.WHITE);
		
		btnTroVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		GroupLayout gl_pnHinhNen = new GroupLayout(pnHinhNen);
		gl_pnHinhNen.setHorizontalGroup(
			gl_pnHinhNen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnHinhNen.createSequentialGroup()
					.addComponent(pnTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_pnHinhNen.setVerticalGroup(
			gl_pnHinhNen.createParallelGroup(Alignment.LEADING)
				.addComponent(pnTaoTaiKhoan, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
		);
		
		Image imgTaoTaiKhoan = new ImageIcon(this.getClass().getResource("/img/taotaikhoan.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		lblHinhTaoTaiKhoan = new JLabel("");
		lblHinhTaoTaiKhoan.setBackground(new Color(255, 192, 203));
		lblHinhTaoTaiKhoan.setIcon(new ImageIcon(imgTaoTaiKhoan));
		
		JYearChooser yearChooser = new JYearChooser();
		
		JMonthChooser monthChooser = new JMonthChooser();
		
		txtHoTen = new JTextField();
		txtHoTen.setText("Nguyễn Văn Anh");
		txtHoTen.setForeground(Color.BLACK);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHoTen.setColumns(10);
		txtHoTen.setBackground(Color.WHITE);
		GroupLayout gl_pnTaoTaiKhoan = new GroupLayout(pnTaoTaiKhoan);
		gl_pnTaoTaiKhoan.setHorizontalGroup(
			gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(36)
					.addComponent(lblTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(23)
					.addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addGap(230))
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(23)
					.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
							.addComponent(spinField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(monthChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(yearChooser, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTenDangNhap, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtKstambinh, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addComponent(lblHinhTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(23)
					.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(rdbtnNu)
					.addGap(18)
					.addComponent(rdbtnNam))
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(23)
					.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(177)
					.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_pnTaoTaiKhoan.createSequentialGroup()
							.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSĐT, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSĐT, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_pnTaoTaiKhoan.setVerticalGroup(
			gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGap(11)
					.addComponent(lblTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSĐT, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSĐT, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
							.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
								.addComponent(spinField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(monthChooser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(yearChooser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addComponent(lblTenDangNhap, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtKstambinh, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblHinhTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
							.addGap(2)
							.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdbtnNu)
						.addComponent(rdbtnNam, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
		);
		pnTaoTaiKhoan.setLayout(gl_pnTaoTaiKhoan);
		pnHinhNen.setLayout(gl_pnHinhNen);
	}
}

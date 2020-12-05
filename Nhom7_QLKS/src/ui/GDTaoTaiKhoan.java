package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class GDTaoTaiKhoan extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3907854565196885940L;
	private JTextField txtMatKhau;
	private JPanel pnHinhNen;
	private JLabel lblHoTen;
	private JLabel lblMatKhau;
	private JLabel lblSĐT;
	private JTextField txtSĐT;
	private JTextField txtKstambinh;
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

	public GDTaoTaiKhoan() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 588, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true); 
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setResizable(false);
		setLocationRelativeTo(null);
		Image imgChinh = new ImageIcon(this.getClass().getResource("/img/logo.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		setIconImage(imgChinh);
		
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
		
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
		lblTenDangNhap.setForeground(Color.BLACK);
		lblTenDangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtKstambinh = new JTextField();
		txtKstambinh.setText("KSTamBinh487");
		txtKstambinh.setForeground(Color.BLACK);
		txtKstambinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtKstambinh.setColumns(10);
		txtKstambinh.setBackground(Color.WHITE);
		
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
				.addComponent(pnTaoTaiKhoan, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
		);
		gl_pnHinhNen.setVerticalGroup(
			gl_pnHinhNen.createParallelGroup(Alignment.LEADING)
				.addComponent(pnTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
		);
		
		Image imgTaoTaiKhoan = new ImageIcon(this.getClass().getResource("/img/taotaikhoan.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		lblHinhTaoTaiKhoan = new JLabel("");
		lblHinhTaoTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhTaoTaiKhoan.setBackground(new Color(255, 192, 203));
		lblHinhTaoTaiKhoan.setIcon(new ImageIcon(imgTaoTaiKhoan));
		
		txtHoTen = new JTextField();
		txtHoTen.setText("Nguyễn Văn Anh");
		txtHoTen.setForeground(Color.BLACK);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHoTen.setColumns(10);
		txtHoTen.setBackground(Color.WHITE);
		GroupLayout gl_pnTaoTaiKhoan = new GroupLayout(pnTaoTaiKhoan);
		gl_pnTaoTaiKhoan.setHorizontalGroup(
			gl_pnTaoTaiKhoan.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTaoTaiKhoan, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
						.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
									.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblTenDangNhap, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtKstambinh)
										.addComponent(txtHoTen, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
										.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtMatKhau))
									.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
									.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
											.addComponent(lblSĐT, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
											.addGap(41))
										.addGroup(Alignment.LEADING, gl_pnTaoTaiKhoan.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblHinhTaoTaiKhoan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtSĐT, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
											.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
									.addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
									.addGap(258)))))
					.addGap(16))
		);
		gl_pnTaoTaiKhoan.setVerticalGroup(
			gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSĐT, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSĐT, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_pnTaoTaiKhoan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
							.addGap(18)
							.addComponent(lblTenDangNhap, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtKstambinh, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(btnTroVe, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnTaoTaiKhoan.createSequentialGroup()
							.addGap(6)
							.addComponent(lblHinhTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(223))
		);
		pnTaoTaiKhoan.setLayout(gl_pnTaoTaiKhoan);
		pnHinhNen.setLayout(gl_pnHinhNen);
	}
}

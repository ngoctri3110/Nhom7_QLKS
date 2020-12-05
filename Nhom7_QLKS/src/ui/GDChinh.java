package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class GDChinh extends JFrame{

	private static final long serialVersionUID = -5390117682194365900L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDChinh chinh = new GDChinh(tenTK);
					chinh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GDChinh(String tenTK) {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Chương trình quản lý thông tin thuê phòng khách sạn Tâm Bình");
		setBounds(100, 100, 1380, 755);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		Image imgChinh = new ImageIcon(this.getClass().getResource("/img/logo.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		setIconImage(imgChinh);
		
		JLabel lblQLTP = new JLabel("");
		Image imgQLTP1 = new ImageIcon(this.getClass().getResource("/img/qltp.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblQLTP.setIcon(new ImageIcon(imgQLTP1));
		lblQLTP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblQuanLyThuePhong = new JLabel("Quản lý thuê phòng");
		lblQuanLyThuePhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuanLyThuePhong.setFont(new Font("Tahoma", Font.BOLD, 40));
				lblQuanLyThuePhong.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyThueTraPhong(tenTK).setVisible(true);
				dispose();
			}
		});
		lblQuanLyThuePhong.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblQuanLyThuePhong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
				lblQuanLyThuePhong.setForeground(Color.BLUE);
			}
		});
		lblQuanLyThuePhong.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblQLP = new JLabel("");
		Image imgQLP1 = new ImageIcon(this.getClass().getResource("/img/qlp.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblQLP.setIcon(new ImageIcon(imgQLP1));
		lblQLP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblQuanLyPhong = new JLabel("Quản lý phòng");
		lblQuanLyPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuanLyPhong.setFont(new Font("Tahoma", Font.BOLD, 40));
				lblQuanLyPhong.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyPhong(tenTK).setVisible(true);
				dispose();
			}
		});
		lblQuanLyPhong.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblQuanLyPhong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
				lblQuanLyPhong.setForeground(Color.BLUE);
			}
		});
		lblQuanLyPhong.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblHTP = new JLabel("");
		Image imgHuyThuePhong1 = new ImageIcon(this.getClass().getResource("/img/huythuephong.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblHTP.setIcon(new ImageIcon(imgHuyThuePhong1));
		lblHTP.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblHuyThuePhong = new JLabel("Hủy thuê phòng");
		lblHuyThuePhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblHuyThuePhong.setFont(new Font("Tahoma", Font.BOLD, 40));
				lblHuyThuePhong.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblHuyThuePhong.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblHuyThuePhong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
				lblHuyThuePhong.setForeground(Color.BLUE);
			}
		});
		lblHuyThuePhong.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblQLDV = new JLabel("");
		Image imgQLDV1 = new ImageIcon(this.getClass().getResource("/img/qldv.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblQLDV.setIcon(new ImageIcon(imgQLDV1));
		lblQLDV.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblQuanLyDichVu = new JLabel("Quản lý dịch vụ");
		lblQuanLyDichVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuanLyDichVu.setFont(new Font("Tahoma", Font.BOLD, 40));
				lblQuanLyDichVu.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDDichVu(tenTK).setVisible(true);
				dispose();
			}
		});
		lblQuanLyDichVu.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblQuanLyDichVu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
				lblQuanLyDichVu.setForeground(Color.BLUE);
			}
		});
		lblQuanLyDichVu.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblQLKH = new JLabel("");
		Image imgQLKH1 = new ImageIcon(this.getClass().getResource("/img/qlkh.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblQLKH.setIcon(new ImageIcon(imgQLKH1));
		lblQLKH.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblQuanLyKhachHang = new JLabel("Quản lý khách hàng");
		lblQuanLyKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuanLyKhachHang.setFont(new Font("Tahoma", Font.BOLD, 40));
				lblQuanLyKhachHang.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyKhachHang(tenTK).setVisible(true);
				dispose();
			}
		});
		lblQuanLyKhachHang.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblQuanLyKhachHang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
				lblQuanLyKhachHang.setForeground(Color.BLUE);
			}
		});
		lblQuanLyKhachHang.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblQLNV = new JLabel("");
		Image imgQLNV1 = new ImageIcon(this.getClass().getResource("/img/qlnv.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblQLNV.setIcon(new ImageIcon(imgQLNV1));
		lblQLNV.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblQuanLyNhanVien = new JLabel("Quản lý nhân viên");
		lblQuanLyNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuanLyNhanVien.setFont(new Font("Tahoma", Font.BOLD, 40));
				lblQuanLyNhanVien.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyNhanVien(tenTK).setVisible(true);
				dispose();
			}
		});
		lblQuanLyNhanVien.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblQuanLyNhanVien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
				lblQuanLyNhanVien.setForeground(Color.BLUE);
			}
		});
		lblQuanLyNhanVien.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblTK = new JLabel("");
		Image imgThongKe1 = new ImageIcon(this.getClass().getResource("/img/thongke.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		lblTK.setIcon(new ImageIcon(imgThongKe1));
		lblTK.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblThongKe = new JLabel("Thống kê");
		lblThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblThongKe.setFont(new Font("Tahoma", Font.BOLD, 40));
				lblThongKe.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDThongKe(tenTK).setVisible(true);
				dispose();
			}
		});
		lblThongKe.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblThongKe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
				lblThongKe.setForeground(Color.BLUE);
			}
		});
		lblThongKe.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblTenTaiKhoan = new JLabel("New label");
		lblTenTaiKhoan.setForeground(Color.RED);
		lblTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenTaiKhoan.setText(tenTK);
		
		JLabel lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int thoat;
				thoat = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?", "Nhắc nhở", JOptionPane.YES_NO_OPTION);
				if(thoat == JOptionPane.YES_OPTION) {
					new GDDangNhap().setVisible(true);
					dispose();
				}
			}
		});
		lblDangXuat.setForeground(Color.BLUE);
		lblDangXuat.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblDoiMatKhau = new JLabel("Đổi mật khẩu");
		lblDoiMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDDoiMatKhau().setVisible(true);
			}
		});
		lblDoiMatKhau.setForeground(Color.BLUE);
		lblDoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblQLDV, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblQuanLyDichVu, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
									.addGap(827))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblHTP, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblHuyThuePhong, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblQLP, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblQuanLyPhong, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblQLTP, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblQuanLyThuePhong, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)))
									.addGap(173)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblQLKH, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
													.addGap(6)
													.addComponent(lblQuanLyKhachHang, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblQLNV, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblQuanLyNhanVien, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
													.addGap(12)))
											.addGap(92))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblTK, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
											.addGap(6)
											.addComponent(lblThongKe, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
											.addGap(104))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 970, Short.MAX_VALUE)
							.addComponent(lblTenTaiKhoan)
							.addGap(16)
							.addComponent(lblDangXuat)
							.addGap(18)
							.addComponent(lblDoiMatKhau, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTenTaiKhoan)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDoiMatKhau, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDangXuat))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblQuanLyThuePhong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addComponent(lblQLTP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
						.addComponent(lblQLKH, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuanLyKhachHang, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblQuanLyPhong, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addComponent(lblQLP, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
						.addComponent(lblQuanLyNhanVien, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQLNV, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHuyThuePhong, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
								.addComponent(lblHTP, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
							.addGap(80)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQLDV, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuanLyDichVu, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addGap(95))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTK, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblThongKe, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		getContentPane().setLayout(groupLayout);
	}
}
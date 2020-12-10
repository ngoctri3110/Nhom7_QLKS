package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.TaiKhoanDao;
import entity.NhanVien;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GDQuanLyPhong extends JFrame{

	private static final long serialVersionUID = -1360180292521970427L;
	private TaiKhoanDao nv_dao;
	private JTable tablePhong;
	private JTable tableLoaiPhong;
	private JTextField txt;
	private JTextField txtTinhTrangPhong;
	private JTextField txtMoTa;
	private JTextField txtTenLoaiPhong;
	private JTextField txtSoGiuong;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtGiaLoaiPhong;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDQuanLyPhong window = new GDQuanLyPhong(tenTK);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDQuanLyPhong(String tenTK) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		nv_dao = new TaiKhoanDao();
		
		setBounds(100, 100, 1380, 755);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Chương trình quản lý thông tin thuê phòng khách sạn Tâm Bình");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		Image imgChinh = new ImageIcon(this.getClass().getResource("/img/logo.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		setIconImage(imgChinh);
		
		JMenuBar mnChucNang = new JMenuBar();
		mnChucNang.setFont(new Font("Segoe UI", Font.BOLD, 20));
		setJMenuBar(mnChucNang);
		
		JMenu mnQLTP = new JMenu("Quản lý thuê phòng");
		mnQLTP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyThueTraPhong(tenTK).setVisible(true);
				dispose();
			}
		});
		mnQLTP.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgQLTP = new ImageIcon(this.getClass().getResource("/img/qltp.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnQLTP.setIcon(new ImageIcon(imgQLTP));
		mnChucNang.add(mnQLTP);
		
		JMenu mnQLP = new JMenu("Quản lý phòng");
		mnQLP.setSelected(true);
		mnQLP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyPhong(tenTK).setVisible(true);
				dispose();
			}
		});
		mnQLP.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgQLP = new ImageIcon(this.getClass().getResource("/img/qlp.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnQLP.setIcon(new ImageIcon(imgQLP));
		mnChucNang.add(mnQLP);
		
		JMenu mnHTP = new JMenu("Hủy thuê phòng");
		mnHTP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDHuyThuePhong(tenTK).setVisible(true);
				dispose();
			}
		});
		mnHTP.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgHuyThuePhong = new ImageIcon(this.getClass().getResource("/img/huythuephong.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnHTP.setIcon(new ImageIcon(imgHuyThuePhong));
		mnChucNang.add(mnHTP);
		
		JMenu mnQLDV = new JMenu("Quản lý dịch vụ");
		mnQLDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDDichVu(tenTK).setVisible(true);
				dispose();
			}
		});
		mnQLDV.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgQLDV = new ImageIcon(this.getClass().getResource("/img/qldv.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnQLDV.setIcon(new ImageIcon(imgQLDV));
		mnChucNang.add(mnQLDV);
		
		JMenu mnQLKH = new JMenu("Quản lý khách hàng");
		mnQLKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyKhachHang(tenTK).setVisible(true);
				dispose();
			}
		});
		mnQLKH.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgQLKH = new ImageIcon(this.getClass().getResource("/img/qlkh.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnQLKH.setIcon(new ImageIcon(imgQLKH));
		mnChucNang.add(mnQLKH);
		
		JMenu mnQLNV = new JMenu("Quản lý nhân viên");
		mnQLNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyNhanVien(tenTK).setVisible(true);
				dispose();
			}
		});
		mnQLNV.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgQLNV = new ImageIcon(this.getClass().getResource("/img/qlnv.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnQLNV.setIcon(new ImageIcon(imgQLNV));
		mnChucNang.add(mnQLNV);
		
		JMenu mnThongKe = new JMenu("Thống kê");
		mnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDThongKe(tenTK).setVisible(true);
				dispose();
			}
		});
		mnThongKe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgThongKe = new ImageIcon(this.getClass().getResource("/img/thongke.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnThongKe.setIcon(new ImageIcon(imgThongKe));
		mnChucNang.add(mnThongKe);
		
		JLabel lblDangXuat = new JLabel("Đăng xuất");
		lblDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int thoat;
				thoat = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?", "Nhắc nhở", JOptionPane.YES_NO_OPTION);
				if(thoat == JOptionPane.YES_OPTION) {
					new GDDangNhap().setVisible(true);
					dispose();
				}
			}
		});
		JLabel lblNewLabel = new JLabel("  |   ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnChucNang.add(lblNewLabel);
		
		JLabel lblTenTaiKhoan = new JLabel("<dynamic>");
		lblTenTaiKhoan.setForeground(Color.RED);
		lblTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ArrayList<NhanVien> listNV = nv_dao.getTenNVTheoTaiKhoan(tenTK);
		for(NhanVien nv : listNV) {
			lblTenTaiKhoan.setText(nv.getTenNV() + "");
		}
		mnChucNang.add(lblTenTaiKhoan);
		
		JLabel lblNewLabel_1 = new JLabel("     ");
		mnChucNang.add(lblNewLabel_1);
		lblDangXuat.setForeground(Color.BLUE);
		lblDangXuat.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mnChucNang.add(lblDangXuat);
		
		JLabel lblNewLabel_1_1 = new JLabel("     ");
		mnChucNang.add(lblNewLabel_1_1);
		
		JLabel lblDoiMatKhau = new JLabel("Đổi mật khẩu");
		lblDoiMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDDoiMatKhau(tenTK).setVisible(true);
			}
		});
		lblDoiMatKhau.setForeground(Color.BLUE);
		lblDoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mnChucNang.add(lblDoiMatKhau);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnQLP = new JPanel();
		getContentPane().add(pnQLP, BorderLayout.CENTER);
		
		JPanel pnPhong = new JPanel();
		pnPhong.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		
		JPanel pnLoaiPhong = new JPanel();
		pnLoaiPhong.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		GroupLayout gl_pnQLP = new GroupLayout(pnQLP);
		gl_pnQLP.setHorizontalGroup(
			gl_pnQLP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnQLP.createSequentialGroup()
					.addComponent(pnPhong, GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnLoaiPhong, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
		);
		gl_pnQLP.setVerticalGroup(
			gl_pnQLP.createParallelGroup(Alignment.LEADING)
				.addComponent(pnLoaiPhong, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
				.addComponent(pnPhong, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
		);
		
		JPanel pnTieuDeLoaiPhong = new JPanel();
		pnTieuDeLoaiPhong.setBorder(new MatteBorder(0, 1, 1, 0, (Color) new Color(0, 0, 0)));
		
		JLabel lblTieuDeLoaiPhong = new JLabel("Loại phòng");
		lblTieuDeLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 30));
		pnTieuDeLoaiPhong.add(lblTieuDeLoaiPhong);
		
		JPanel pnChucNangLoaiPhong = new JPanel();
		pnChucNangLoaiPhong.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JLabel lblMaLoaiPhong_LoaiP = new JLabel("Mã loại phòng");
		lblMaLoaiPhong_LoaiP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox cboMaLoaiPhong = new JComboBox();
		
		JLabel lblTenLoaiPhong = new JLabel("Tên loại phòng");
		lblTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setColumns(10);
		
		JLabel lblSoGiuong = new JLabel("Số giường");
		lblSoGiuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtSoGiuong = new JTextField();
		txtSoGiuong.setColumns(10);
		
		JLabel lblSoLuongNgO = new JLabel("Số người ở");
		lblSoLuongNgO.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblDienTich = new JLabel("Diện tích");
		lblDienTich.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblGiaLP = new JLabel("Số người ở");
		lblGiaLP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtGiaLoaiPhong = new JTextField();
		txtGiaLoaiPhong.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSuaLoaiPhong = new JButton("Sửa");
		btnSuaLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnXoaTrangLoaiPhong = new JButton("Xóa trắng");
		btnXoaTrangLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_pnChucNangLoaiPhong = new GroupLayout(pnChucNangLoaiPhong);
		gl_pnChucNangLoaiPhong.setHorizontalGroup(
			gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChucNangLoaiPhong.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnChucNangLoaiPhong.createSequentialGroup()
							.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSoGiuong, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaLoaiPhong_LoaiP, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
								.addComponent(cboMaLoaiPhong, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtSoGiuong, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTenLoaiPhong)
								.addComponent(lblSoLuongNgO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTenLoaiPhong, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
						.addGroup(gl_pnChucNangLoaiPhong.createSequentialGroup()
							.addComponent(lblDienTich, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblGiaLP, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtGiaLoaiPhong, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_pnChucNangLoaiPhong.createSequentialGroup()
							.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSuaLoaiPhong, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnXoaTrangLoaiPhong, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
							.addGap(2)))
					.addContainerGap())
		);
		gl_pnChucNangLoaiPhong.setVerticalGroup(
			gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnChucNangLoaiPhong.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnChucNangLoaiPhong.createSequentialGroup()
							.addComponent(lblTenLoaiPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSoLuongNgO, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnChucNangLoaiPhong.createSequentialGroup()
								.addComponent(txtTenLoaiPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnChucNangLoaiPhong.createSequentialGroup()
								.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
									.addComponent(lblMaLoaiPhong_LoaiP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addComponent(cboMaLoaiPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
									.addComponent(txtSoGiuong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblSoGiuong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))))
					.addGap(18)
					.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDienTich, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGiaLP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGiaLoaiPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnChucNangLoaiPhong.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSuaLoaiPhong, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoaTrangLoaiPhong, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnChucNangLoaiPhong.setLayout(gl_pnChucNangLoaiPhong);
		
		JScrollPane scrollPaneLoaiPhong = new JScrollPane();
		
		tableLoaiPhong = new JTable();
		tableLoaiPhong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 lo\u1EA1i ph\u00F2ng", "T\u00EAn lo\u1EA1i ph\u00F2ng", "S\u1ED1 gi\u01B0\u1EDDng", "S\u1ED1 l\u01B0\u1EE3ng ng\u01B0\u1EDDi \u1EDF", "Di\u1EC7n t\u00EDch", "Gi\u00E1 lo\u1EA1i ph\u00F2ng"
			}
		));
		scrollPaneLoaiPhong.setViewportView(tableLoaiPhong);
		GroupLayout gl_pnLoaiPhong = new GroupLayout(pnLoaiPhong);
		gl_pnLoaiPhong.setHorizontalGroup(
			gl_pnLoaiPhong.createParallelGroup(Alignment.LEADING)
				.addComponent(pnTieuDeLoaiPhong, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
				.addComponent(scrollPaneLoaiPhong, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
				.addComponent(pnChucNangLoaiPhong, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
		);
		gl_pnLoaiPhong.setVerticalGroup(
			gl_pnLoaiPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLoaiPhong.createSequentialGroup()
					.addComponent(pnTieuDeLoaiPhong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneLoaiPhong, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnChucNangLoaiPhong, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pnLoaiPhong.setLayout(gl_pnLoaiPhong);
		
		JPanel pnTieuDePhong = new JPanel();
		pnTieuDePhong.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblTieuDePhong = new JLabel("Phòng");
		lblTieuDePhong.setFont(new Font("Tahoma", Font.BOLD, 30));
		pnTieuDePhong.add(lblTieuDePhong);
		
		JPanel pnChucNangPhong = new JPanel();
		pnChucNangPhong.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JButton btnLoc = new JButton("Kiểm tra phòng trống");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox cboMaPhong = new JComboBox();
		
		JLabel lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txt = new JTextField();
		txt.setColumns(10);
		
		JLabel lblMaLoaiPhong = new JLabel("Mã loại phòng");
		lblMaLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox cboMaLoaiPhong_Phong = new JComboBox();
		
		JLabel lblTinhTrangPhong = new JLabel("Tình trạng phòng");
		lblTinhTrangPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtTinhTrangPhong = new JTextField();
		txtTinhTrangPhong.setColumns(10);
		
		JLabel lblMoTa = new JLabel("Mô tả");
		lblMoTa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		GroupLayout gl_pnChucNangPhong = new GroupLayout(pnChucNangPhong);
		gl_pnChucNangPhong.setHorizontalGroup(
			gl_pnChucNangPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChucNangPhong.createSequentialGroup()
					.addGroup(gl_pnChucNangPhong.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnChucNangPhong.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_pnChucNangPhong.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnChucNangPhong.createSequentialGroup()
									.addComponent(lblMaPhong, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cboMaPhong, 0, 141, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(lblTenPhong, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txt, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
								.addGroup(gl_pnChucNangPhong.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnXoaTrang, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))))
						.addGroup(gl_pnChucNangPhong.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMaLoaiPhong, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboMaLoaiPhong_Phong, 0, 141, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblTinhTrangPhong, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtTinhTrangPhong, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
						.addGroup(gl_pnChucNangPhong.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMoTa, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMoTa, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pnChucNangPhong.setVerticalGroup(
			gl_pnChucNangPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChucNangPhong.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnChucNangPhong.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblMaPhong, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTenPhong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txt, Alignment.LEADING)
						.addComponent(cboMaPhong, Alignment.LEADING))
					.addGap(18)
					.addGroup(gl_pnChucNangPhong.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTinhTrangPhong, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnChucNangPhong.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_pnChucNangPhong.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cboMaLoaiPhong_Phong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaLoaiPhong)))
						.addComponent(txtTinhTrangPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_pnChucNangPhong.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMoTa, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMoTa, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnChucNangPhong.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnLoc, 0, 0, Short.MAX_VALUE)
						.addComponent(btnXoaTrang, 0, 0, Short.MAX_VALUE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE))
					.addGap(10))
		);
		pnChucNangPhong.setLayout(gl_pnChucNangPhong);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tablePhong = new JTable();
		tablePhong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 ph\u00F2ng", "M\u00E3 lo\u1EA1i ph\u00F2ng", "T\u00EAn ph\u00F2ng", "T\u00ECnh tr\u1EA1ng ph\u00F2ng", "M\u00F4 t\u1EA3"
			}
		));
		scrollPane.setViewportView(tablePhong);
		GroupLayout gl_pnPhong = new GroupLayout(pnPhong);
		gl_pnPhong.setHorizontalGroup(
			gl_pnPhong.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnTieuDePhong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
				.addComponent(pnChucNangPhong, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
		);
		gl_pnPhong.setVerticalGroup(
			gl_pnPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPhong.createSequentialGroup()
					.addComponent(pnTieuDePhong, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnChucNangPhong, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pnPhong.setLayout(gl_pnPhong);
		pnQLP.setLayout(gl_pnQLP);
		
		if(!(tenTK.equals("TKQLN01") || tenTK.equals("TKQLN06"))) {
			mnChucNang.remove(mnQLNV);
			mnChucNang.remove(mnThongKe);
		}
	}
}
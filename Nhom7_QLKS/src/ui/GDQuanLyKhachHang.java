package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public class GDQuanLyKhachHang extends JFrame{

	private static final long serialVersionUID = -6025494785132432266L;
	private JTable tableKhachHang;
	private JTextField txtCMND;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDQuanLyKhachHang window = new GDQuanLyKhachHang(tenTK);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GDQuanLyKhachHang(String tenTK) {
		setTitle("Chương trình quản lý thông tin thuê phòng khách sạn Tâm Bình");
		setBounds(100, 100, 1380, 755);
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
		mnQLKH.setSelected(true);
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
		
		JLabel lblTenTaiKhoan = new JLabel("New label");
		lblTenTaiKhoan.setForeground(Color.RED);
		lblTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenTaiKhoan.setText(tenTK);
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
				new GDDoiMatKhau().setVisible(true);
			}
		});
		lblDoiMatKhau.setForeground(Color.BLUE);
		lblDoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mnChucNang.add(lblDoiMatKhau);
		
		JPanel pnQLKH = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnQLKH, GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnQLKH, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
		);
		
		JPanel pnBang = new JPanel();
		
		JPanel pnNhapTTKH = new JPanel();
		pnNhapTTKH.setBorder(new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnThngTinKhch = new JButton("THÔNG TIN KHÁCH HÀNG");
		btnThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThngTinKhch.setFocusable(false);
		btnThngTinKhch.setEnabled(false);
		btnThngTinKhch.setBackground(Color.CYAN);
		
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBorder(new TitledBorder(null, "T\u00ECm th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_pnQLKH = new GroupLayout(pnQLKH);
		gl_pnQLKH.setHorizontalGroup(
			gl_pnQLKH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnQLKH.createSequentialGroup()
					.addGroup(gl_pnQLKH.createParallelGroup(Alignment.LEADING)
						.addComponent(pnNhapTTKH, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
						.addComponent(pnTimKiem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnBang, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE))
				.addComponent(btnThngTinKhch, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
		);
		gl_pnQLKH.setVerticalGroup(
			gl_pnQLKH.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnQLKH.createSequentialGroup()
					.addComponent(btnThngTinKhch, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnQLKH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnQLKH.createSequentialGroup()
							.addComponent(pnNhapTTKH, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnTimKiem, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
						.addComponent(pnBang, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)))
		);
		
		JLabel lblTimKiemCMND = new JLabel("CMND:");
		lblTimKiemCMND.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox<String> cboTimKiemCMND = new JComboBox<String>();
		
		JLabel lblTimTenKH = new JLabel("Tên khách hàng:");
		lblTimTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox<String> cboTimKiemTenKH = new JComboBox<String>();
		
		JLabel lblTimKiemQuocTich = new JLabel("Quốc tịch:");
		lblTimKiemQuocTich.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox<String> cboTimKiemQT = new JComboBox<String>();
		
		JLabel lblTimKiemGioiTinh = new JLabel("Giới tính:");
		lblTimKiemGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JRadioButton radTimKiemGTNam = new JRadioButton("Nam");
		radTimKiemGTNam.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JRadioButton radTimKiemGTNu = new JRadioButton("Nữ");
		radTimKiemGTNu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		radTimKiemGTNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radTimKiemGTNam.isSelected())
					radTimKiemGTNu.setSelected(false);
			}
		});
		radTimKiemGTNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radTimKiemGTNu.isSelected())
					radTimKiemGTNam.setSelected(false);
			}
		});
		
		GroupLayout gl_pnTimKiem = new GroupLayout(pnTimKiem);
		gl_pnTimKiem.setHorizontalGroup(
			gl_pnTimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTimKiem.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnTimKiem.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnTimKiem.createSequentialGroup()
							.addGroup(gl_pnTimKiem.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnTimKiem.createSequentialGroup()
									.addGroup(gl_pnTimKiem.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnTimKiem.createSequentialGroup()
											.addComponent(lblTimKiemCMND, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
											.addGap(3))
										.addComponent(lblTimTenKH, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(17))
								.addComponent(lblTimKiemQuocTich, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
							.addGroup(gl_pnTimKiem.createParallelGroup(Alignment.TRAILING)
								.addComponent(cboTimKiemCMND, 0, 196, Short.MAX_VALUE)
								.addComponent(cboTimKiemTenKH, 0, 196, Short.MAX_VALUE)
								.addComponent(cboTimKiemQT, 0, 196, Short.MAX_VALUE)))
						.addGroup(gl_pnTimKiem.createSequentialGroup()
							.addComponent(lblTimKiemGioiTinh, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(radTimKiemGTNam, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
							.addGap(34)
							.addComponent(radTimKiemGTNu, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addGap(31)))
					.addGap(34))
		);
		gl_pnTimKiem.setVerticalGroup(
			gl_pnTimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTimKiem.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_pnTimKiem.createParallelGroup(Alignment.LEADING)
						.addComponent(cboTimKiemCMND, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblTimKiemCMND, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_pnTimKiem.createParallelGroup(Alignment.LEADING)
						.addComponent(cboTimKiemTenKH, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblTimTenKH, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_pnTimKiem.createParallelGroup(Alignment.LEADING)
						.addComponent(cboTimKiemQT, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(lblTimKiemQuocTich, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(21)
					.addGroup(gl_pnTimKiem.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTimKiemGioiTinh, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(radTimKiemGTNam, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
						.addComponent(radTimKiemGTNu, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE))
					.addGap(59))
		);
		pnTimKiem.setLayout(gl_pnTimKiem);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JRadioButton radGTNam = new JRadioButton("Nam");
		radGTNam.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JRadioButton radGTNu = new JRadioButton("Nữ");
		radGTNu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		radGTNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radGTNu.isSelected())
					radGTNam.setSelected(false);
			}
		});
		radGTNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radGTNam.isSelected())
					radGTNu.setSelected(false);
			}
		});
		
		JLabel lblNgaySinh = new JLabel("Sinh nhật:");
		lblNgaySinh.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel lblQuocTich = new JLabel("Quốc tịch:");
		lblQuocTich.setHorizontalAlignment(SwingConstants.TRAILING);
		lblQuocTich.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox<String> cboQuocTich = new JComboBox<String>();
		cboQuocTich.addItem("Việt Nam");
		cboQuocTich.addItem("Mỹ");
		cboQuocTich.addItem("Nhật Bản");
		cboQuocTich.addItem("Hàn Quốc");
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setFocusable(false);
		btnThem.setBackground(SystemColor.info);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setFocusable(false);
		btnXoa.setBackground(SystemColor.info);
		
		JButton btnChnhSa = new JButton("Chỉnh sửa");
		btnChnhSa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnChnhSa.setFocusable(false);
		btnChnhSa.setBackground(SystemColor.info);
		
		GroupLayout gl_pnNhapTTKH = new GroupLayout(pnNhapTTKH);
		gl_pnNhapTTKH.setHorizontalGroup(
			gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnNhapTTKH.createSequentialGroup()
					.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnNhapTTKH.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCMND, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnNhapTTKH.createSequentialGroup()
							.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnNhapTTKH.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnChnhSa, GroupLayout.PREFERRED_SIZE, 135, Short.MAX_VALUE))
								.addGroup(gl_pnNhapTTKH.createSequentialGroup()
									.addGap(26)
									.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblQuocTich, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))))
							.addGap(17)))
					.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnNhapTTKH.createSequentialGroup()
							.addGap(0)
							.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnNhapTTKH.createSequentialGroup()
									.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtDiaChi, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
										.addGroup(gl_pnNhapTTKH.createSequentialGroup()
											.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
									.addGap(29))
								.addGroup(gl_pnNhapTTKH.createSequentialGroup()
									.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtCMND, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
										.addComponent(txtTenKH, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
									.addGap(29))
								.addGroup(gl_pnNhapTTKH.createSequentialGroup()
									.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.TRAILING)
										.addComponent(cboQuocTich, Alignment.LEADING, 0, 153, Short.MAX_VALUE)
										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
									.addGap(79))))
						.addGroup(gl_pnNhapTTKH.createSequentialGroup()
							.addGap(1)
							.addComponent(radGTNam, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(radGTNu, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_pnNhapTTKH.setVerticalGroup(
			gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnNhapTTKH.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtCMND)
						.addComponent(lblCMND, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtTenKH)
						.addComponent(lblTenKH, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
					.addGap(21)
					.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.BASELINE)
							.addComponent(radGTNu, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(radGTNam, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnNhapTTKH.createSequentialGroup()
							.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cboQuocTich)
								.addComponent(lblQuocTich, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtDiaChi)
								.addComponent(lblDiaChi, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
						.addGroup(gl_pnNhapTTKH.createSequentialGroup()
							.addGap(141)
							.addGroup(gl_pnNhapTTKH.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChnhSa, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(316, Short.MAX_VALUE))
		);
		pnNhapTTKH.setLayout(gl_pnNhapTTKH);
		pnBang.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnBang.add(scrollPane, BorderLayout.CENTER);
		
		tableKhachHang = new JTable();
		tableKhachHang.setModel(new DefaultTableModel(
			new Object[][] {
				{null, " ", " ", null, null, null},
			},
			new String[] {
				"CMND", "T\u00EAn kh\u00E1ch h\u00E0ng", "Gi\u1EDBi t\u00EDnh", "Sinh nh\u1EADt", "Qu\u1ED1c t\u1ECBch", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		scrollPane.setViewportView(tableKhachHang);
		pnQLKH.setLayout(gl_pnQLKH);
		getContentPane().setLayout(groupLayout);
	}
}
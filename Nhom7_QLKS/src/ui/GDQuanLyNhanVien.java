package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class GDQuanLyNhanVien extends JFrame{

	private static final long serialVersionUID = 4289775796109531296L;
	private JTextField txtTenNV;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTable tableThongTinNV;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDQuanLyNhanVien window = new GDQuanLyNhanVien(tenTK);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDQuanLyNhanVien(String tenTK) {
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
		mnQLNV.setSelected(true);
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
		
		JPanel pnThongTinKH = new JPanel();
		pnThongTinKH.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnThongTinKH, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnThongTinKH, GroupLayout.PREFERRED_SIZE, 668, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnTieuDe = new JButton("THÔNG TIN NHÂN VIÊN");
		btnTieuDe.setFocusable(false);
		btnTieuDe.setEnabled(false);
		btnTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTieuDe.setBackground(Color.CYAN);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		
		JLabel lblLoaiNV = new JLabel("Loại nhân viên:");
		lblLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JComboBox<String> cboLoaiNV = new JComboBox<String>();
		cboLoaiNV.addItem("Nhân viên lễ tân");
		cboLoaiNV.addItem("Nhân viên quản lý");
		
		JLabel lblSDT = new JLabel("Số điện thoại di động:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JRadioButton radGTNam = new JRadioButton("Nam");
		radGTNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton radGTNu = new JRadioButton("Nữ");
		radGTNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radGTNu.isSelected())
					radGTNam.setSelected(false);
			}
		});
		radGTNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		radGTNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radGTNam.isSelected())
					radGTNu.setSelected(false);
			}
		});
		
		JLabel lblNgaySinh = new JLabel("Sinh nhật:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		
		JPanel pnBang = new JPanel();
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(SystemColor.info);
		Image imgThem = new ImageIcon(this.getClass().getResource("/img/them.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		btnThem.setIcon(new ImageIcon(imgThem));
		btnThem.setFocusable(false);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel pnBangNV = new JPanel();
		pnBangNV.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		
		JButton btnXoa = new JButton("Xóa");
		Image imgXoa = new ImageIcon(this.getClass().getResource("/img/xoa.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		btnXoa.setIcon(new ImageIcon(imgXoa));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setFocusable(false);
		btnXoa.setBackground(SystemColor.info);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		Image imgCapNhat = new ImageIcon(this.getClass().getResource("/img/capnhat.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		btnCapNhat.setIcon(new ImageIcon(imgCapNhat));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setFocusable(false);
		btnCapNhat.setBackground(SystemColor.info);
		
		JButton btnTaoTaiKhoan = new JButton("Tạo tài khoản");
		btnTaoTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDTaoTaiKhoan().setVisible(true);
			}
		});
		btnTaoTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTaoTaiKhoan.setFocusable(false);
		btnTaoTaiKhoan.setBackground(SystemColor.info);
		
		JButton btnTimKiem = new JButton("");
		Image imgTimKiem = new ImageIcon(this.getClass().getResource("/img/timkiemthuephong.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		btnTimKiem.setIcon(new ImageIcon(imgTimKiem));
		
		JComboBox<String> cboTimKiem = new JComboBox<String>();
		cboTimKiem.addItem("Tìm kiếm theo tên nhân viên.....");
		cboTimKiem.setEditable(true);
		
		GroupLayout gl_pnThongTinKH = new GroupLayout(pnThongTinKH);
		gl_pnThongTinKH.setHorizontalGroup(
			gl_pnThongTinKH.createParallelGroup(Alignment.LEADING)
				.addComponent(btnTieuDe, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
				.addComponent(pnBang, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
				.addGroup(gl_pnThongTinKH.createSequentialGroup()
					.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnThongTinKH.createSequentialGroup()
							.addComponent(pnBangNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cboTimKiem, 0, 287, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTimKiem)
							.addGap(39))
						.addGroup(gl_pnThongTinKH.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnThongTinKH.createSequentialGroup()
									.addComponent(lblTenNV)
									.addGap(18)
									.addComponent(txtTenNV, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
								.addGroup(gl_pnThongTinKH.createSequentialGroup()
									.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(radGTNam, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(radGTNu)
									.addGap(18)
									.addComponent(lblNgaySinh, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))))
					.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnThongTinKH.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLoaiNV, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnThongTinKH.createSequentialGroup()
									.addComponent(cboLoaiNV, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblSDT, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtSDT, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
								.addComponent(txtDiaChi, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)))
						.addGroup(gl_pnThongTinKH.createSequentialGroup()
							.addGap(252)
							.addComponent(btnTaoTaiKhoan)
							.addGap(18)
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnThongTinKH.setVerticalGroup(
			gl_pnThongTinKH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThongTinKH.createSequentialGroup()
					.addComponent(btnTieuDe, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnThongTinKH.createSequentialGroup()
							.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtTenNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenNV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.BASELINE)
										.addComponent(radGTNam)
										.addComponent(radGTNu)))
								.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING)
									.addComponent(txtDiaChi, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
									.addComponent(lblNgaySinh, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
									.addComponent(lblDiaChi, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
									.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))))
						.addGroup(gl_pnThongTinKH.createSequentialGroup()
							.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLoaiNV, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboLoaiNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(15))
						.addGroup(gl_pnThongTinKH.createSequentialGroup()
							.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtSDT, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSDT, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)))
					.addGap(18)
					.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnBangNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThem)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTaoTaiKhoan, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnThongTinKH.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_pnThongTinKH.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cboTimKiem)
								.addComponent(btnTimKiem, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnBang, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
		);
		
		JLabel lblBangNhanVien = new JLabel("Bảng nhân viên");
		lblBangNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnBangNV.add(lblBangNhanVien);
		pnBang.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnBang.add(scrollPane, BorderLayout.CENTER);
		
		tableThongTinNV = new JTable();
		tableThongTinNV.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn", "Lo\u1EA1i nh\u00E2n vi\u00EAn", "S\u1ED1 di \u0111\u1ED9ng", "Gi\u1EDBi t\u00EDnh", "Sinh nh\u1EADt", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		scrollPane.setViewportView(tableThongTinNV);
		pnThongTinKH.setLayout(gl_pnThongTinKH);
		getContentPane().setLayout(groupLayout);
	}
}
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
	private JTable tablePhong;
	private JTextField txtSoPhong;
	private JTextField txtTinhTrangPhong;
	private JTextField txtMoTa;
	private JTextField txtSoGiuong;
	private JTextField txtSoNguoiO;
	private JTextField txtDienTich;
	private TaiKhoanDao nv_dao;
	
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
		
		JPanel pnBang = new JPanel();
		pnBang.setBackground(Color.WHITE);
		
		JPanel pnNhapThongTinPhong = new JPanel();
		pnNhapThongTinPhong.setBackground(Color.WHITE);
		pnNhapThongTinPhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		
		JPanel pnLocPhong = new JPanel();
		pnLocPhong.setBackground(Color.WHITE);
		pnLocPhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnBang, GroupLayout.PREFERRED_SIZE, 957, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnNhapThongTinPhong, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
						.addComponent(pnLocPhong, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(5))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnBang, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(pnNhapThongTinPhong, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnLocPhong, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JPanel pnTieuDeLocPhong = new JPanel();
		pnTieuDeLocPhong.setBackground(Color.WHITE);
		pnTieuDeLocPhong.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		
		JLabel lblLocSoPhong = new JLabel("Số phòng:");
		lblLocSoPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JComboBox<Integer> cboLocSoPhong = new JComboBox<Integer>();
		cboLocSoPhong.setBackground(new Color(240, 230, 140));
		
		JLabel lblLocLoaiPhong = new JLabel("Loại phòng:");
		lblLocLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JComboBox<String> cboLocLoaiPhong = new JComboBox<String>();
		cboLocLoaiPhong.setBackground(new Color(240, 230, 140));
		
		JLabel lblLocSoGiuong = new JLabel("Số giường:");
		lblLocSoGiuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JComboBox<Integer> cboLocSoGiuong = new JComboBox<Integer>();
		cboLocSoGiuong.setBackground(new Color(240, 230, 140));
		
		JLabel lblLocSoNguoiO = new JLabel("Số người ở:");
		lblLocSoNguoiO.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JComboBox<Integer> cboLocSoNguoiO = new JComboBox<Integer>();
		cboLocSoNguoiO.setBackground(new Color(240, 230, 140));
		
		JButton btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_pnLocPhong = new GroupLayout(pnLocPhong);
		gl_pnLocPhong.setHorizontalGroup(
			gl_pnLocPhong.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnTieuDeLocPhong, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
				.addGroup(gl_pnLocPhong.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLocPhong.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLocSoPhong)
						.addComponent(lblLocLoaiPhong, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnLocPhong.createParallelGroup(Alignment.LEADING)
						.addComponent(cboLocLoaiPhong, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cboLocSoPhong, 0, 254, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_pnLocPhong.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLocPhong.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLocSoNguoiO, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocSoGiuong, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnLocPhong.createParallelGroup(Alignment.LEADING)
						.addComponent(cboLocSoNguoiO, 0, 254, Short.MAX_VALUE)
						.addComponent(cboLocSoGiuong, 0, 254, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_pnLocPhong.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLoc, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnLocPhong.setVerticalGroup(
			gl_pnLocPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLocPhong.createSequentialGroup()
					.addComponent(pnTieuDeLocPhong, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnLocPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocSoPhong, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboLocSoPhong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnLocPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboLocLoaiPhong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLocLoaiPhong, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnLocPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocSoGiuong, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboLocSoGiuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnLocPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocSoNguoiO, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboLocSoNguoiO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pnTieuDeLocPhong.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLocPhong = new JLabel("Lọc phòng");
		lblLocPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnTieuDeLocPhong.add(lblLocPhong, BorderLayout.CENTER);
		pnLocPhong.setLayout(gl_pnLocPhong);
		
		JPanel pnTieuDeNhapTTP = new JPanel();
		pnTieuDeNhapTTP.setBackground(Color.WHITE);
		pnTieuDeNhapTTP.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(128, 128, 128)));
		pnTieuDeNhapTTP.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNhapThongTinPhong = new JLabel("Nhập thông tin phòng");
		pnTieuDeNhapTTP.add(lblNhapThongTinPhong);
		lblNhapThongTinPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel pnTrong = new JPanel();
		pnTrong.setBackground(Color.WHITE);
		pnTrong.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(128, 128, 128)));
		pnTrong.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtSoPhong = new JTextField();
		txtSoPhong.setEditable(false);
		txtSoPhong.setBackground(new Color(240, 230, 140));
		txtSoPhong.setColumns(10);
		
		JLabel lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblTinhTrangPhong = new JLabel("Tình trạng phòng:");
		lblTinhTrangPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtTinhTrangPhong = new JTextField();
		txtTinhTrangPhong.setBackground(new Color(240, 230, 140));
		txtTinhTrangPhong.setEditable(false);
		txtTinhTrangPhong.setText("Chưa thuê");
		txtTinhTrangPhong.setColumns(10);
		
		JLabel lblMT = new JLabel("Mô tả:");
		lblMT.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtMoTa = new JTextField();
		txtMoTa.setBackground(new Color(240, 230, 140));
		txtMoTa.setColumns(10);
		
		JLabel lblSoGiuong = new JLabel("Số giường:");
		lblSoGiuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblSoNguoiO = new JLabel("Số người ở:");
		lblSoNguoiO.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDienTich = new JLabel("Diện tích:");
		lblDienTich.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtSoGiuong = new JTextField();
		txtSoGiuong.setBackground(new Color(240, 230, 140));
		txtSoGiuong.setColumns(10);
		
		txtSoNguoiO = new JTextField();
		txtSoNguoiO.setBackground(new Color(240, 230, 140));
		txtSoNguoiO.setColumns(10);
		
		txtDienTich = new JTextField();
		txtDienTich.setBackground(new Color(240, 230, 140));
		txtDienTich.setColumns(10);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDienTich.setText("");
				txtMoTa.setText("");
				txtSoGiuong.setText("");
				txtSoNguoiO.setText("");
				txtSoPhong.setText("");
				txtTinhTrangPhong.setText("");
			}
		});
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox<String> cboLoaiPhong = new JComboBox<String>();
		cboLoaiPhong.setBackground(new Color(240, 230, 140));
		GroupLayout gl_pnNhapThongTinPhong = new GroupLayout(pnNhapThongTinPhong);
		gl_pnNhapThongTinPhong.setHorizontalGroup(
			gl_pnNhapThongTinPhong.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnTieuDeNhapTTP, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
				.addComponent(pnTrong, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
				.addGroup(gl_pnNhapThongTinPhong.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnNhapThongTinPhong.createSequentialGroup()
							.addComponent(lblMT, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMoTa, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
						.addGroup(gl_pnNhapThongTinPhong.createSequentialGroup()
							.addComponent(lblDienTich, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDienTich, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
						.addGroup(gl_pnNhapThongTinPhong.createSequentialGroup()
							.addComponent(lblSoNguoiO, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSoNguoiO, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
						.addGroup(gl_pnNhapThongTinPhong.createSequentialGroup()
							.addComponent(lblSoGiuong, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSoGiuong, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
						.addGroup(gl_pnNhapThongTinPhong.createSequentialGroup()
							.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTinhTrangPhong, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLoaiPhong, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoPhong))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.LEADING)
								.addComponent(cboLoaiPhong, 0, 219, Short.MAX_VALUE)
								.addComponent(txtTinhTrangPhong, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(txtSoPhong, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
						.addGroup(gl_pnNhapThongTinPhong.createSequentialGroup()
							.addComponent(btnKiemTra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnXoaTrang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(89)))
					.addGap(18))
		);
		gl_pnNhapThongTinPhong.setVerticalGroup(
			gl_pnNhapThongTinPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnNhapThongTinPhong.createSequentialGroup()
					.addComponent(pnTieuDeNhapTTP, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSoPhong)
						.addComponent(txtSoPhong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLoaiPhong, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboLoaiPhong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTinhTrangPhong, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTinhTrangPhong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSoGiuong, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSoGiuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSoNguoiO, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSoNguoiO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDienTich, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDienTich, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMT, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMoTa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnNhapThongTinPhong.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXoaTrang, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(btnKiemTra, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(pnTrong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		);
		pnNhapThongTinPhong.setLayout(gl_pnNhapThongTinPhong);
		pnBang.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnBang.add(scrollPane, BorderLayout.CENTER);
		
		tablePhong = new JTable();
		tablePhong.setBackground(Color.WHITE);
		tablePhong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tablePhong.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"S\u1ED1 ph\u00F2ng", "Lo\u1EA1i ph\u00F2ng", "T\u00ECnh tr\u1EA1ng", "S\u1ED1 gi\u01B0\u1EDDng", "S\u1ED1 ng\u01B0\u1EDDi \u1EDF", "Di\u1EC7n t\u00EDch", "M\u00F4 t\u1EA3", "Gi\u00E1 ph\u00F2ng"
			}
		));
		tablePhong.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablePhong.getColumnModel().getColumn(2).setPreferredWidth(122);
		tablePhong.getColumnModel().getColumn(3).setPreferredWidth(29);
		tablePhong.getColumnModel().getColumn(4).setPreferredWidth(63);
		tablePhong.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(tablePhong);
		getContentPane().setLayout(groupLayout);
		
		if(!(tenTK.equals("TKQLN01") || tenTK.equals("TKQLN06"))) {
			mnChucNang.remove(mnQLNV);
			mnChucNang.remove(mnThongKe);
		}
	}
}
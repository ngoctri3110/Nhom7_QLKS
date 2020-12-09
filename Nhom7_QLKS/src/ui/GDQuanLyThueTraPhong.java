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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.KhachHangDAO;
import dao.PhongDao;
import dao.TaiKhoanDao;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;

public class GDQuanLyThueTraPhong extends JFrame{

	private static final long serialVersionUID = -1360180292521970427L;
	private JTextField txtKH;
	private TaiKhoanDao nv_dao;
	private PhongDao phong_dao;
	private KhachHangDAO kh_dao;
	private JTextField txtNgayThue;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDQuanLyThueTraPhong window = new GDQuanLyThueTraPhong(tenTK);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDQuanLyThueTraPhong(String tenTK) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		nv_dao = new TaiKhoanDao();
		phong_dao = new PhongDao();
		kh_dao = new KhachHangDAO();
		
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().setEnabled(false);
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
		mnQLTP.setSelected(true);
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
		
		JLabel lblTenTaiKhoan = new JLabel("New label");
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
		
		JPanel pnThongTinThuePhong = new JPanel();
		pnThongTinThuePhong.setBackground(Color.WHITE);
		pnThongTinThuePhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel pnPhongDaChon = new JPanel();
		pnPhongDaChon.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnPhongDaChon.setBackground(Color.WHITE);
		pnPhongDaChon.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblPhongDaChon = new JLabel("Phòng đã chọn");
		lblPhongDaChon.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel pnTang1 = new JPanel();
		pnTang1.setBackground(Color.DARK_GRAY);
		
		JLabel lblChuThich = new JLabel("Chú thích");
		lblChuThich.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel pnChuThich = new JPanel();
		pnChuThich.setBackground(new Color(64, 224, 208));
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDChinh(tenTK).setVisible(true);
				dispose();
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.setFocusable(false);
		
		JButton btnHoanTat = new JButton("Thuê");
		btnHoanTat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHoanTat.setFocusable(false);
		
		JLabel lblSao = new JLabel("(*)");
		lblSao.setForeground(Color.RED);
		lblSao.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel pnTang2 = new JPanel();
		pnTang2.setBackground(Color.DARK_GRAY);
		
		JPanel pnTang3 = new JPanel();
		pnTang3.setBackground(Color.DARK_GRAY);
		pnTang3.setLayout(new BorderLayout(0, 0));
		
		JPanel pn101 = new JPanel();
		pn101.setBackground(Color.ORANGE);
		
		JPanel pn201 = new JPanel();
		pn201.setBackground(Color.ORANGE);
		
		JPanel pn301 = new JPanel();
		pn301.setBackground(Color.ORANGE);
		
		JPanel pn102 = new JPanel();
		pn102.setBackground(Color.ORANGE);
		
		JPanel pn202 = new JPanel();
		pn202.setBackground(Color.ORANGE);
		
		JPanel pn302 = new JPanel();
		pn302.setBackground(Color.ORANGE);
		
		JPanel pn103 = new JPanel();
		pn103.setBackground(Color.ORANGE);
		
		JPanel pn203 = new JPanel();
		pn203.setBackground(Color.ORANGE);
		
		JPanel pn303 = new JPanel();
		pn303.setBackground(Color.ORANGE);
		
		JPanel pn104 = new JPanel();
		pn104.setBackground(Color.ORANGE);
		
		JPanel pn204 = new JPanel();
		pn204.setBackground(Color.ORANGE);
		
		JPanel pn304 = new JPanel();
		pn304.setBackground(Color.ORANGE);
		
		JPanel pn105 = new JPanel();
		pn105.setBackground(Color.ORANGE);
		
		JPanel pn205 = new JPanel();
		pn205.setBackground(Color.ORANGE);
		
		JPanel pn305 = new JPanel();
		pn305.setBackground(Color.ORANGE);
		
		JPanel pn106 = new JPanel();
		pn106.setBackground(Color.ORANGE);
		
		JPanel pn206 = new JPanel();
		pn206.setBackground(Color.ORANGE);
		
		JPanel pn306 = new JPanel();
		pn306.setBackground(Color.ORANGE);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLamMoi.setFocusable(false);
		
		JButton btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTraPhong.setFocusable(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnChuThich, GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
								.addComponent(pnThongTinThuePhong, GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(pnTang3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(pnTang2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(pnTang1, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
									.addGap(30)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pn301, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
										.addComponent(pn101, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
										.addComponent(pn201, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(pn302, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
										.addComponent(pn202, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
										.addComponent(pn102, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pn103, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addComponent(pn203, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addComponent(pn303, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pn104, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addComponent(pn204, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addComponent(pn304, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pn305, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addComponent(pn105, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addComponent(pn205, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(pn106, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
										.addComponent(pn206, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
										.addComponent(pn306, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnTraPhong, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnHoanTat, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 854, Short.MAX_VALUE)
									.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addComponent(pnPhongDaChon, GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblChuThich, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addGap(1160))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPhongDaChon, GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
							.addGap(96))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnThongTinThuePhong, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(lblPhongDaChon)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnPhongDaChon, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pn102, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(pnTang1, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(pn101, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pn202, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(pnTang2, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(pn201, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(pn301, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addComponent(pnTang3, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
									.addGap(20)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSao, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblChuThich, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pn302, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
									.addGap(47))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pn103, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(pn203, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(pn303, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addGap(46))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pn104, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(pn204, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(pn304, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
							.addGap(46))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pn105, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pn106, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pn206, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(pn205, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pn305, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
								.addComponent(pn306, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
							.addGap(46)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnChuThich, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnHuy)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnHoanTat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnTraPhong, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnPhongDaChon.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnPhongDaChon.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtAreaPhongDaChon = new JTextArea();
		txtAreaPhongDaChon.setEditable(false);
		txtAreaPhongDaChon.setFont(new Font("Monospaced", Font.PLAIN, 50));
		scrollPane.setViewportView(txtAreaPhongDaChon);
		pn306.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong306 = new JLabel("306");
		lblSoPhong306.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong306.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn306.add(lblSoPhong306, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong306 = new JLabel("Loại phòng");
		lblLoaiPhong306.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong306.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn306.add(lblLoaiPhong306, BorderLayout.CENTER);
		
		JLabel lblSoNguoi306 = new JLabel("Số người");
		lblSoNguoi306.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi306.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn306.add(lblSoNguoi306, BorderLayout.SOUTH);
		pn305.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong305 = new JLabel("305");
		lblSoPhong305.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong305.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn305.add(lblSoPhong305, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong305 = new JLabel("Loại phòng");
		lblLoaiPhong305.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong305.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn305.add(lblLoaiPhong305, BorderLayout.CENTER);
		
		JLabel lblSoNguoi305 = new JLabel("Số người");
		lblSoNguoi305.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi305.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn305.add(lblSoNguoi305, BorderLayout.SOUTH);
		pn304.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong304 = new JLabel("304");
		lblSoPhong304.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong304.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn304.add(lblSoPhong304, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong304 = new JLabel("Loại phòng");
		lblLoaiPhong304.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong304.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn304.add(lblLoaiPhong304, BorderLayout.CENTER);
		
		JLabel lblSoNguoi304 = new JLabel("Số người");
		lblSoNguoi304.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi304.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn304.add(lblSoNguoi304, BorderLayout.SOUTH);
		pn303.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong303 = new JLabel("303");
		lblSoPhong303.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong303.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn303.add(lblSoPhong303, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong303 = new JLabel("Loại phòng");
		lblLoaiPhong303.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong303.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn303.add(lblLoaiPhong303, BorderLayout.CENTER);
		
		JLabel lblSoNguoi303 = new JLabel("Số người");
		lblSoNguoi303.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi303.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn303.add(lblSoNguoi303, BorderLayout.SOUTH);
		pn302.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong302 = new JLabel("302");
		lblSoPhong302.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong302.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn302.add(lblSoPhong302, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong302 = new JLabel("Loại phòng");
		lblLoaiPhong302.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong302.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn302.add(lblLoaiPhong302, BorderLayout.CENTER);
		
		JLabel lblSoNguoi302 = new JLabel("Số người");
		lblSoNguoi302.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi302.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn302.add(lblSoNguoi302, BorderLayout.SOUTH);
		pn301.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong301 = new JLabel("301");
		lblSoPhong301.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong301.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn301.add(lblSoPhong301, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong301 = new JLabel("Loại phòng");
		lblLoaiPhong301.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong301.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn301.add(lblLoaiPhong301, BorderLayout.CENTER);
		
		JLabel lblSoNguoi301 = new JLabel("Số người");
		lblSoNguoi301.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi301.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn301.add(lblSoNguoi301, BorderLayout.SOUTH);
		pn204.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong204 = new JLabel("204");
		lblSoPhong204.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong204.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn204.add(lblSoPhong204, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong204 = new JLabel("Loại phòng");
		lblLoaiPhong204.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong204.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn204.add(lblLoaiPhong204, BorderLayout.CENTER);
		
		JLabel lblSoNguoi204 = new JLabel("Số người");
		lblSoNguoi204.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi204.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn204.add(lblSoNguoi204, BorderLayout.SOUTH);
		pn203.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong203 = new JLabel("203");
		lblSoPhong203.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong203.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn203.add(lblSoPhong203, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong203 = new JLabel("Loại phòng");
		lblLoaiPhong203.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong203.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn203.add(lblLoaiPhong203, BorderLayout.CENTER);
		
		JLabel lblSoNguoi203 = new JLabel("Số người");
		lblSoNguoi203.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi203.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn203.add(lblSoNguoi203, BorderLayout.SOUTH);
		pn206.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong206 = new JLabel("206");
		lblSoPhong206.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong206.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn206.add(lblSoPhong206, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong206 = new JLabel("Loại phòng");
		lblLoaiPhong206.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong206.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn206.add(lblLoaiPhong206, BorderLayout.CENTER);
		
		JLabel lblSoNguoi206 = new JLabel("Số người");
		lblSoNguoi206.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi206.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn206.add(lblSoNguoi206, BorderLayout.SOUTH);
		pn205.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong205 = new JLabel("205");
		lblSoPhong205.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong205.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn205.add(lblSoPhong205, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong205 = new JLabel("Loại phòng");
		lblLoaiPhong205.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong205.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn205.add(lblLoaiPhong205, BorderLayout.CENTER);
		
		JLabel lblSoNguoi205 = new JLabel("Số người");
		lblSoNguoi205.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi205.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn205.add(lblSoNguoi205, BorderLayout.SOUTH);
		pn202.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong202 = new JLabel("202");
		lblSoPhong202.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong202.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn202.add(lblSoPhong202, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong202 = new JLabel("Loại phòng");
		lblLoaiPhong202.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong202.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn202.add(lblLoaiPhong202, BorderLayout.CENTER);
		
		JLabel lblSoNguoi202 = new JLabel("Số người");
		lblSoNguoi202.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi202.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn202.add(lblSoNguoi202, BorderLayout.SOUTH);
		pn201.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong201 = new JLabel("201");
		lblSoPhong201.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong201.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn201.add(lblSoPhong201, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong201 = new JLabel("Loại phòng");
		lblLoaiPhong201.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong201.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn201.add(lblLoaiPhong201, BorderLayout.CENTER);
		
		JLabel lblSoNguoi201 = new JLabel("Số người");
		lblSoNguoi201.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi201.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn201.add(lblSoNguoi201, BorderLayout.SOUTH);
		pn106.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong106 = new JLabel("106");
		lblSoPhong106.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong106.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn106.add(lblSoPhong106, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong106 = new JLabel("Loại phòng");
		lblLoaiPhong106.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong106.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn106.add(lblLoaiPhong106, BorderLayout.CENTER);
		
		JLabel lblSoNguoi106 = new JLabel("Số người");
		lblSoNguoi106.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi106.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn106.add(lblSoNguoi106, BorderLayout.SOUTH);
		pn105.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong105 = new JLabel("105");
		lblSoPhong105.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong105.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn105.add(lblSoPhong105, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong105 = new JLabel("Loại phòng");
		lblLoaiPhong105.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong105.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn105.add(lblLoaiPhong105, BorderLayout.CENTER);
		
		JLabel lblSoNguoi105 = new JLabel("Số người");
		lblSoNguoi105.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi105.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn105.add(lblSoNguoi105, BorderLayout.SOUTH);
		pn104.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong104 = new JLabel("104");
		lblSoPhong104.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong104.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn104.add(lblSoPhong104, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong104 = new JLabel("Loại phòng");
		lblLoaiPhong104.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong104.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn104.add(lblLoaiPhong104, BorderLayout.CENTER);
		
		JLabel lblSoNguoi104 = new JLabel("Số người");
		lblSoNguoi104.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi104.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn104.add(lblSoNguoi104, BorderLayout.SOUTH);
		pn103.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong103 = new JLabel("103");
		lblSoPhong103.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong103.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn103.add(lblSoPhong103, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong103 = new JLabel("Loại phòng");
		lblLoaiPhong103.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong103.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn103.add(lblLoaiPhong103, BorderLayout.CENTER);
		
		JLabel lblSoNguoi103 = new JLabel("Số người");
		lblSoNguoi103.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi103.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn103.add(lblSoNguoi103, BorderLayout.SOUTH);
		pn102.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong102 = new JLabel("102");
		lblSoPhong102.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong102.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn102.add(lblSoPhong102, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong102 = new JLabel("Loại phòng");
		lblLoaiPhong102.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong102.setFont(new Font("Tahoma", Font.BOLD, 16));
		pn102.add(lblLoaiPhong102, BorderLayout.CENTER);
		
		JLabel lblSoNguoi102 = new JLabel("Số người");
		lblSoNguoi102.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi102.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn102.add(lblSoNguoi102, BorderLayout.SOUTH);
		pn101.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong101 = new JLabel("101");
		lblSoPhong101.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoPhong101.setHorizontalAlignment(SwingConstants.CENTER);
		pn101.add(lblSoPhong101, BorderLayout.NORTH);
		
		JLabel lblLoaiPhong101 = new JLabel("Loại phòng");
		lblLoaiPhong101.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoaiPhong101.setHorizontalAlignment(SwingConstants.CENTER);
		pn101.add(lblLoaiPhong101, BorderLayout.CENTER);
		
		JLabel lblSoNguoi101 = new JLabel("Số giường");
		lblSoNguoi101.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoNguoi101.setFont(new Font("Dialog", Font.PLAIN, 18));
		pn101.add(lblSoNguoi101, BorderLayout.SOUTH);
		
		JPanel pnPhongTrong = new JPanel();
		pnPhongTrong.setBackground(Color.ORANGE);
		
		JLabel lblPhongTrong = new JLabel("Phòng trống");
		lblPhongTrong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel pnDangO = new JPanel();
		pnDangO.setBackground(Color.RED);
		
		JLabel lblDangO = new JLabel("Đang ở");
		lblDangO.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_pnChuThich = new GroupLayout(pnChuThich);
		gl_pnChuThich.setHorizontalGroup(
			gl_pnChuThich.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChuThich.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnPhongTrong, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPhongTrong)
					.addGap(91)
					.addComponent(pnDangO, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblDangO, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(871, Short.MAX_VALUE))
		);
		gl_pnChuThich.setVerticalGroup(
			gl_pnChuThich.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChuThich.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnChuThich.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pnChuThich.createSequentialGroup()
							.addGroup(gl_pnChuThich.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPhongTrong)
								.addComponent(pnPhongTrong, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_pnChuThich.createSequentialGroup()
							.addGroup(gl_pnChuThich.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDangO, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnDangO, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
							.addContainerGap())))
		);
		pnChuThich.setLayout(gl_pnChuThich);
		
		JLabel lblTang3 = new JLabel("TẦNG 3");
		lblTang3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTang3.setForeground(Color.WHITE);
		lblTang3.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnTang3.add(lblTang3, BorderLayout.CENTER);
		pnTang2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTang2 = new JLabel("TẦNG 2");
		lblTang2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTang2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTang2.setForeground(Color.WHITE);
		pnTang2.add(lblTang2);
		pnTang1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTang1 = new JLabel("TẦNG 1");
		lblTang1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTang1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTang1.setForeground(Color.WHITE);
		pnTang1.add(lblTang1);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setHorizontalAlignment(SwingConstants.LEFT);
		lblCMND.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JComboBox<String> cboCMND = new JComboBox<String>();
		
		JLabel lblNgayThue = new JLabel("Ngày thuê:");
		lblNgayThue.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNgayTraDuKien = new JLabel("Ngày trả dự kiến:");
		lblNgayTraDuKien.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JDateChooser dcNgayTraDuKien = new JDateChooser();
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtKH = new JTextField();
		txtKH.setEditable(false);
		txtKH.setColumns(10);
		
		txtNgayThue = new JTextField();
		txtNgayThue.setEditable(false);
		txtNgayThue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgayThue.setText(LocalDate.now() + "");
		txtNgayThue.setColumns(10);
		GroupLayout gl_pnThongTinThuePhong = new GroupLayout(pnThongTinThuePhong);
		gl_pnThongTinThuePhong.setHorizontalGroup(
			gl_pnThongTinThuePhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCMND, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cboCMND, 0, 206, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtKH, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNgayThue, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNgayThue, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNgayTraDuKien, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dcNgayTraDuKien, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnThongTinThuePhong.setVerticalGroup(
			gl_pnThongTinThuePhong.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
					.addGroup(gl_pnThongTinThuePhong.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
							.addContainerGap()
							.addComponent(dcNgayTraDuKien, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
						.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNgayTraDuKien, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
						.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnThongTinThuePhong.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTenKH, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
								.addComponent(lblNgayThue, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
								.addComponent(lblCMND, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
								.addComponent(cboCMND, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
								.addComponent(txtKH, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
								.addComponent(txtNgayThue, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))))
					.addContainerGap())
		);
		pnThongTinThuePhong.setLayout(gl_pnThongTinThuePhong);
		getContentPane().setLayout(groupLayout);
		
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDQuanLyThueTraPhong(tenTK).setVisible(true);
				dispose();
			}
		});
		
		pn101.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn101.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 101 ");
				pn101.removeMouseListener(pn101.getMouseListeners()[0]);
			}
		});
		
		pn102.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn102.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 102 ");
				pn102.removeMouseListener(this);
			}
		});
		
		pn103.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn103.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 103 ");
				pn103.removeMouseListener(this);
			}
		});
		
		pn104.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn104.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 104 ");
				pn104.removeMouseListener(this);
			}
		});
		
		pn105.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn105.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 105 ");
				pn105.removeMouseListener(this);
			}
		});
		
		pn106.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn106.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 106 ");
				pn106.removeMouseListener(this);
			}
		});
		
		pn201.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn201.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 201 ");
				pn201.removeMouseListener(this);
			}
		});
		
		pn202.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn202.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 202 ");
				pn202.removeMouseListener(this);
			}
		});
		
		pn203.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn203.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 203 ");
				pn203.removeMouseListener(this);
			}
		});
		
		pn204.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn204.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 204 ");
				pn204.removeMouseListener(this);
			}
		});
		
		pn205.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn205.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 205 ");
				pn205.removeMouseListener(this);
			}
		});
		
		pn206.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn206.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 206 ");
				pn206.removeMouseListener(this);
			}
		});
		
		pn301.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn301.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 301 ");
				pn301.removeMouseListener(this);
			}
		});
		
		pn302.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn302.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 302 ");
				pn302.removeMouseListener(this);
			}
		});
		
		pn303.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn303.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 303 ");
				pn303.removeMouseListener(this);
			}
		});
		
		pn304.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn304.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 304 ");
				pn304.removeMouseListener(this);
			}
		});
		
		pn305.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn305.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 305 ");
				pn305.removeMouseListener(this);
			}
		});
		
		pn306.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pn306.setBackground(Color.RED);
				txtAreaPhongDaChon.append(" 306 ");
				pn306.removeMouseListener(this);
			}
		});
		
		List<LoaiPhong> listLP101 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("101");
		for(LoaiPhong lp : listLP101) {
			lblLoaiPhong101.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi101.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP102 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("102");
		for(LoaiPhong lp : listLP102) {
			lblLoaiPhong102.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi102.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP103 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("103");
		for(LoaiPhong lp : listLP103) {
			lblLoaiPhong103.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi103.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP104 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("104");
		for(LoaiPhong lp : listLP104) {
			lblLoaiPhong104.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi104.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP105 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("105");
		for(LoaiPhong lp : listLP105) {
			lblLoaiPhong105.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi105.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP106 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("106");
		for(LoaiPhong lp : listLP106) {
			lblLoaiPhong106.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi106.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP201 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("201");
		for(LoaiPhong lp : listLP201) {
			lblLoaiPhong201.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi201.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP202 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("202");
		for(LoaiPhong lp : listLP202) {
			lblLoaiPhong202.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi202.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP203 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("203");
		for(LoaiPhong lp : listLP203) {
			lblLoaiPhong203.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi203.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP204 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("204");
		for(LoaiPhong lp : listLP204) {
			lblLoaiPhong204.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi204.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP205 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("205");
		for(LoaiPhong lp : listLP205) {
			lblLoaiPhong205.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi205.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP206 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("206");
		for(LoaiPhong lp : listLP206) {
			lblLoaiPhong206.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi206.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP301 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("301");
		for(LoaiPhong lp : listLP301) {
			lblLoaiPhong301.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi301.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP302 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("302");
		for(LoaiPhong lp : listLP302) {
			lblLoaiPhong302.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi302.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP303 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("303");
		for(LoaiPhong lp : listLP303) {
			lblLoaiPhong303.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi303.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP304 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("304");
		for(LoaiPhong lp : listLP304) {
			lblLoaiPhong304.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi304.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP305 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("305");
		for(LoaiPhong lp : listLP305) {
			lblLoaiPhong305.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi305.setText("Số giường: " + lp.getSoGiuong());
		}
		
		List<LoaiPhong> listLP306 = phong_dao.getLoaiPhongSoGiuongTheoTenPhong("306");
		for(LoaiPhong lp : listLP306) {
			lblLoaiPhong306.setText("" + lp.getTenLoaiPhong());
			lblSoNguoi306.setText("Số giường: " + lp.getSoGiuong());
		}
		if(!(tenTK.equals("TKQLN01") || tenTK.equals("TKQLN06"))) {
			mnChucNang.remove(mnQLNV);
			mnChucNang.remove(mnThongKe);
		}
		
		List<KhachHang> listCMND = kh_dao.getTatCaKH();
		for(KhachHang kh : listCMND) {
			cboCMND.addItem(kh.getCmnd());
		}
		
		List<KhachHang> listTenKH = kh_dao.getTenKHTheoCMND(cboCMND.getSelectedItem().toString());
		for(KhachHang kh1 : listTenKH) {
			txtKH.setText(kh1.getTenKH());
		}
		
		cboCMND.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<KhachHang> listTenKH = kh_dao.getTenKHTheoCMND(cboCMND.getSelectedItem().toString());
				for(KhachHang kh1 : listTenKH) {
					txtKH.setText(kh1.getTenKH());
				}
			}
		});
		
		List<Phong> listThuePhong = phong_dao.getTatCaPhong();
		for(Phong p : listThuePhong) {
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong101.getText())) {
				pn101.setBackground(Color.RED);
				pn101.removeMouseListener(pn101.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong102.getText())) {
				pn102.setBackground(Color.RED);
				pn102.removeMouseListener(pn102.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong103.getText())) {
				pn103.setBackground(Color.RED);
				pn103.removeMouseListener(pn103.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong104.getText())) {
				pn104.setBackground(Color.RED);
				pn104.removeMouseListener(pn104.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong105.getText())) {
				pn105.setBackground(Color.RED);
				pn105.removeMouseListener(pn105.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong106.getText())) {
				pn106.setBackground(Color.RED);
				pn106.removeMouseListener(pn106.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong201.getText())) {
				pn201.setBackground(Color.RED);
				pn201.removeMouseListener(pn201.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong202.getText())) {
				pn202.setBackground(Color.RED);
				pn202.removeMouseListener(pn202.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong203.getText())) {
				pn203.setBackground(Color.RED);
				pn203.removeMouseListener(pn203.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong204.getText())) {
				pn204.setBackground(Color.RED);
				pn204.removeMouseListener(pn204.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong205.getText())) {
				pn205.setBackground(Color.RED);
				pn205.removeMouseListener(pn205.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong206.getText())) {
				pn206.setBackground(Color.RED);
				pn206.removeMouseListener(pn206.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong301.getText())) {
				pn301.setBackground(Color.RED);
				pn301.removeMouseListener(pn301.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong302.getText())) {
				pn302.setBackground(Color.RED);
				pn302.removeMouseListener(pn302.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong303.getText())) {
				pn303.setBackground(Color.RED);
				pn303.removeMouseListener(pn303.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong304.getText())) {
				pn304.setBackground(Color.RED);
				pn304.removeMouseListener(pn304.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong305.getText())) {
				pn305.setBackground(Color.RED);
				pn305.removeMouseListener(pn305.getMouseListeners()[0]);
			}
			if(p.getTinhTrangPhong().equals("Đã thuê") && p.getTenPhong().equals(lblSoPhong306.getText())) {
				pn306.setBackground(Color.RED);
				pn306.removeMouseListener(pn306.getMouseListeners()[0]);
			}
		}
	}
}

package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.TaiKhoanDao;
import entity.NhanVien;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GDHuyThuePhong extends JFrame {

	private static final long serialVersionUID = -32901465910573934L;
	private JPanel contentPane;
	private JLabel lblCMND;
	private JComboBox<String> cboTenPhong;
	private JLabel lblTnPhng;
	private JLabel lblNgyThu;
	private JPanel pThongTin;
	private JTable table;
	private JTextField txtCMND;
	private JTextField txtSoPhong;
	private JTextField txtTenKH;
	private JTextField txtNgayThue;
	private JTextField txtNgayTraDuKien;
	private JTextField txtNgayTra;
	private TaiKhoanDao nv_dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDHuyThuePhong window = new GDHuyThuePhong(tenTK);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDHuyThuePhong(String tenTK) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		nv_dao = new TaiKhoanDao();
		
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		setTitle("Chương trình quản lý thông tin thuê phòng khách sạn Tâm Bình");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 735);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		setContentPane(contentPane);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
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
		mnHTP.setSelected(true);
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
		
		JPanel pTimKiem = new JPanel();
		pTimKiem.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm Ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pTimKiem.setBackground(Color.WHITE);
		
		JComboBox<String> cboCMND = new JComboBox<String>();
		cboCMND.setEditable(true);
		
		lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		cboTenPhong = new JComboBox<String>();
		cboTenPhong.setEditable(true);
		
		lblTnPhng = new JLabel("Tên Phòng:");
		lblTnPhng.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		lblNgyThu = new JLabel("Ngày Thuê:");
		lblNgyThu.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JDateChooser dateChooser = new JDateChooser();
		GroupLayout gl_pTimKiem = new GroupLayout(pTimKiem);
		gl_pTimKiem.setHorizontalGroup(
			gl_pTimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pTimKiem.createSequentialGroup()
					.addGap(4)
					.addComponent(lblCMND, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(cboCMND, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addGap(80)
					.addComponent(lblTnPhng, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addComponent(cboTenPhong, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(lblNgyThu, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_pTimKiem.setVerticalGroup(
			gl_pTimKiem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pTimKiem.createSequentialGroup()
					.addGroup(gl_pTimKiem.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pTimKiem.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblCMND, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNgyThu, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
							.addComponent(lblTnPhng, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
							.addComponent(cboCMND, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(cboTenPhong, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pTimKiem.setLayout(gl_pTimKiem);
		
		pThongTin = new JPanel();
		pThongTin.setBackground(Color.WHITE);
		pThongTin.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		
		JLabel lblCMND_1 = new JLabel("CMND:");
		lblCMND_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		txtCMND = new JTextField();
		txtCMND.setEditable(false);
		txtCMND.setColumns(10);
		
		JLabel lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		txtSoPhong = new JTextField();
		txtSoPhong.setEditable(false);
		txtSoPhong.setColumns(10);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		
		JLabel lblNgayThue = new JLabel("Ngày thuê:");
		lblNgayThue.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgayThue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		txtNgayThue = new JTextField();
		txtNgayThue.setEditable(false);
		txtNgayThue.setColumns(10);
		
		JLabel lblNgayTraDuKien = new JLabel("Ngày trả dự kiến:");
		lblNgayTraDuKien.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgayTraDuKien.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		txtNgayTraDuKien = new JTextField();
		txtNgayTraDuKien.setEditable(false);
		txtNgayTraDuKien.setColumns(10);
		
		JLabel lblNgayTra = new JLabel("Ngày trả:");
		lblNgayTra.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgayTra.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		txtNgayTra = new JTextField();
		txtNgayTra.setEditable(false);
		txtNgayTra.setColumns(10);
		
		JLabel lblPhuPhi = new JLabel("Phụ phí:");
		lblPhuPhi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhuPhi.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JComboBox<String> cboTenPhong_1 = new JComboBox<String>();
		cboTenPhong_1.setEditable(true);
		GroupLayout gl_pThongTin = new GroupLayout(pThongTin);
		gl_pThongTin.setHorizontalGroup(
			gl_pThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pThongTin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pThongTin.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPhuPhi, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pThongTin.createSequentialGroup()
								.addComponent(lblCMND_1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtCMND, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pThongTin.createSequentialGroup()
								.addComponent(lblSoPhong, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtSoPhong, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pThongTin.createSequentialGroup()
								.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pThongTin.createSequentialGroup()
							.addGap(129)
							.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pThongTin.createSequentialGroup()
									.addComponent(lblNgayTra, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtNgayTra, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pThongTin.createSequentialGroup()
									.addComponent(lblNgayTraDuKien, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtNgayTraDuKien, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pThongTin.createSequentialGroup()
									.addComponent(lblNgayThue, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtNgayThue, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))))
						.addGroup(gl_pThongTin.createSequentialGroup()
							.addGap(18)
							.addComponent(cboTenPhong_1, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pThongTin.setVerticalGroup(
			gl_pThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pThongTin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pThongTin.createSequentialGroup()
							.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtCMND)
								.addComponent(lblCMND_1, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSoPhong, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSoPhong, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pThongTin.createSequentialGroup()
							.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNgayThue, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayThue, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNgayTraDuKien, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgayTraDuKien, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNgayTra, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgayTra, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_pThongTin.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cboTenPhong_1)
						.addComponent(lblPhuPhi, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE))
					.addContainerGap())
		);
		pThongTin.setLayout(gl_pThongTin);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(new Color(64, 224, 208));
		
		JButton btnHuyThuePhong = new JButton("Hủy Thuê Phòng");
		btnHuyThuePhong.setFocusable(false);
		btnHuyThuePhong.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnHuyThuePhong.setBackground(Color.WHITE);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDChinh(tenTK).setVisible(true);
			}
		});
		btnHuy.setFocusable(false);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		GroupLayout gl_pnChucNang = new GroupLayout(pnChucNang);
		gl_pnChucNang.setAutoCreateGaps(true);
		gl_pnChucNang.setAutoCreateContainerGaps(true);
		gl_pnChucNang.setHorizontalGroup(
			gl_pnChucNang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChucNang.createSequentialGroup()
					.addGap(1132)
					.addComponent(btnHuyThuePhong, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_pnChucNang.setVerticalGroup(
			gl_pnChucNang.createParallelGroup(Alignment.LEADING)
				.addGap(0, 66, Short.MAX_VALUE)
				.addGroup(gl_pnChucNang.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnChucNang.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
						.addComponent(btnHuyThuePhong, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))
					.addGap(10))
		);
		pnChucNang.setLayout(gl_pnChucNang);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"CMND", "T\u00EAn kh\u00E1ch h\u00E0ng", "S\u1ED1 ph\u00F2ng", "Ng\u00E0y thu\u00EA", "Ng\u00E0y tr\u1EA3 d\u1EF1 ki\u1EBFn"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(180);
		table.getColumnModel().getColumn(1).setPreferredWidth(221);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1521, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(pTimKiem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1516, Short.MAX_VALUE)
								.addComponent(pnChucNang, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pThongTin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(pTimKiem, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(pThongTin, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnChucNang, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		gl_contentPane.setAutoCreateGaps(true);
		gl_contentPane.setAutoCreateContainerGaps(true);
		contentPane.setLayout(gl_contentPane);
	}
}

package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.TaiKhoanDao;
import entity.NhanVien;

import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class GDDichVu extends JFrame{

	private static final long serialVersionUID = -7803746082041510802L;
	private JTable tableDichVu;
	private JTable tablePDV;
	private TaiKhoanDao nv_dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDDichVu window = new GDDichVu(tenTK);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDDichVu(String tenTK) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		nv_dao = new TaiKhoanDao();
		
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().setEnabled(false);
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
		mnQLDV.setSelected(true);
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
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(new Color(240, 255, 240));
		
		JPanel pnDichVu = new JPanel();
		pnDichVu.setBorder(new TitledBorder(null, "Th\u00F4ng tin d\u1ECBch v\u1EE5 s\u1EB5n c\u00F3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel pnPhieuDichVu = new JPanel();
		pnPhieuDichVu.setBorder(new TitledBorder(null, "Phi\u1EBFu D\u1ECBch V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(pnDichVu, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnPhieuDichVu, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnChucNang, GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnChucNang, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnDichVu, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
						.addComponent(pnPhieuDichVu, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
					.addContainerGap())
		);
		pnPhieuDichVu.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPanePDV = new JScrollPane();
		pnPhieuDichVu.add(scrollPanePDV, BorderLayout.CENTER);
		
		tablePDV = new JTable();
		tablePDV.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 phi\u1EBFu d\u1ECBch v\u1EE5", "M\u00E3 d\u1ECBch v\u1EE5", "Gi\u00E1 d\u1ECBch v\u1EE5", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPanePDV.setViewportView(tablePDV);
		pnDichVu.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnDichVu.add(scrollPane, BorderLayout.CENTER);
		
		tableDichVu = new JTable();
		tableDichVu.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 d\u1ECBch v\u1EE5", "T\u00EAn d\u1ECBch v\u1EE5", "Lo\u1EA1i d\u1ECBch v\u1EE5", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		));
		scrollPane.setViewportView(tableDichVu);
		
		JLabel lblQuanLyDichVu = new JLabel("Quản lý dịch vụ");
		lblQuanLyDichVu.setForeground(new Color(205, 92, 92));
		lblQuanLyDichVu.setBackground(Color.WHITE);
		lblQuanLyDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLyDichVu.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblThemDV = new JLabel("Thêm dịch vụ");
		lblThemDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblThemDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		lblThemDV.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblThemDV.setFont(new Font("Tahoma", Font.BOLD, 20));
			}
		});
		lblThemDV.setForeground(new Color(0, 0, 255));
		lblThemDV.setBackground(new Color(255, 215, 0));
		lblThemDV.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblXoaDV = new JLabel("Xóa dịch vụ");
		lblXoaDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblXoaDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		lblXoaDV.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblXoaDV.setFont(new Font("Tahoma", Font.BOLD, 20));
			}
		});
		lblXoaDV.setForeground(new Color(0, 0, 255));
		lblXoaDV.setHorizontalAlignment(SwingConstants.CENTER);
		lblXoaDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblSuaDV = new JLabel("Sửa dịch vụ");
		lblSuaDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblSuaDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
		});
		lblSuaDV.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblSuaDV.setFont(new Font("Tahoma", Font.BOLD, 20));
			}
		});
		lblSuaDV.setForeground(new Color(0, 0, 255));
		lblSuaDV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuaDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblLoaiDV = new JLabel("Tìm kiếm loại dịch vụ :");
		lblLoaiDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox<String> cboTimKiemLoaiDV = new JComboBox<String>();
		cboTimKiemLoaiDV.setEditable(true);
		
		JLabel lblTenDV = new JLabel("Tìm kiếm tên dịch vụ :");
		lblTenDV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox<String> cboTimKiemTenDV = new JComboBox<String>();
		cboTimKiemTenDV.setEditable(true);
		GroupLayout gl_pnChucNang = new GroupLayout(pnChucNang);
		gl_pnChucNang.setHorizontalGroup(
			gl_pnChucNang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnChucNang.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnChucNang.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblQuanLyDichVu, GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_pnChucNang.createSequentialGroup()
							.addComponent(lblTenDV, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboTimKiemTenDV, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_pnChucNang.createSequentialGroup()
							.addComponent(lblLoaiDV, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboTimKiemLoaiDV, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
							.addComponent(lblThemDV, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblXoaDV, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSuaDV, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnChucNang.setVerticalGroup(
			gl_pnChucNang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnChucNang.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQuanLyDichVu)
					.addGroup(gl_pnChucNang.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnChucNang.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_pnChucNang.createParallelGroup(Alignment.LEADING)
								.addComponent(cboTimKiemTenDV, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenDV, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addGroup(gl_pnChucNang.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(cboTimKiemLoaiDV)
								.addComponent(lblLoaiDV, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_pnChucNang.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnChucNang.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSuaDV, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblXoaDV, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblThemDV, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addGap(25))))
		);
		pnChucNang.setLayout(gl_pnChucNang);
		getContentPane().setLayout(groupLayout);
		setTitle("Chương trình quản lý thông tin thuê phòng khách sạn Tâm Bình");
		setBounds(100, 100, 1380, 755);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		if(!(tenTK.equals("TKQLN01") || tenTK.equals("TKQLN06"))) {
			mnChucNang.remove(mnQLNV);
			mnChucNang.remove(mnThongKe);
		}
	}
}

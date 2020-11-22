package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

public class GDQuanLyThuePhong extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1360180292521970427L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDQuanLyThuePhong window = new GDQuanLyThuePhong(tenTK);
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
	public GDQuanLyThuePhong(String tenTK) {
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().setEnabled(false);
		setTitle("Chương trình quản lý thông tin thuê phòng khách sạn Tâm Bình");
		setBounds(100, 100, 1380, 755);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		JMenuBar mnChucNang = new JMenuBar();
		mnChucNang.setFont(new Font("Segoe UI", Font.BOLD, 20));
		setJMenuBar(mnChucNang);
		
		JMenu mnQLTP = new JMenu("Quản lý thuê phòng");
		mnQLTP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GDQuanLyThuePhong(tenTK).setVisible(true);
				dispose();
			}
		});
		mnQLTP.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgQLTP = new ImageIcon(this.getClass().getResource("/img/qltp.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnQLTP.setIcon(new ImageIcon(imgQLTP));
		mnQLTP.setSelected(true);
		mnChucNang.add(mnQLTP);
		
		JMenu mnQLTraPhong = new JMenu("Quản lý trả phòng");
		mnQLTraPhong.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgQLTraPhong = new ImageIcon(this.getClass().getResource("/img/qltraphong.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnQLTraPhong.setIcon(new ImageIcon(imgQLTraPhong));
		mnChucNang.add(mnQLTraPhong);
		
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
		lblTenTaiKhoan.setText(tenTK);
		mnChucNang.add(lblTenTaiKhoan);
		
		JLabel lblNewLabel_1 = new JLabel("     ");
		mnChucNang.add(lblNewLabel_1);
		lblDangXuat.setForeground(Color.BLUE);
		lblDangXuat.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		mnChucNang.add(lblDangXuat);
		
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
									.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnHoanTat, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
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
					.addComponent(pnPhongDaChon, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
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
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnHoanTat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnHuy))
						.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnPhongDaChon.setLayout(new BorderLayout(0, 0));
		
		DefaultListModel<String> listModelPhongDaChon = new DefaultListModel<String>();
		JList<String> listPhongDaChon = new JList<String>(listModelPhongDaChon);
		listPhongDaChon.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listPhongDaChon.setFont(new Font("Tahoma", Font.PLAIN, 60));
		listPhongDaChon.setEnabled(false);
		pnPhongDaChon.add(listPhongDaChon, BorderLayout.CENTER);
		
		
		
		JLabel lblSoPhong306 = new JLabel("306");
		lblSoPhong306.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong306.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn306.add(lblSoPhong306, BorderLayout.NORTH);
		pn305.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong305 = new JLabel("305");
		lblSoPhong305.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong305.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn305.add(lblSoPhong305, BorderLayout.NORTH);
		pn304.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong304 = new JLabel("304");
		lblSoPhong304.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong304.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn304.add(lblSoPhong304, BorderLayout.NORTH);
		pn303.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong303 = new JLabel("303");
		lblSoPhong303.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong303.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn303.add(lblSoPhong303, BorderLayout.NORTH);
		pn302.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong302 = new JLabel("302");
		lblSoPhong302.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong302.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn302.add(lblSoPhong302, BorderLayout.NORTH);
		pn301.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong301 = new JLabel("301");
		lblSoPhong301.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong301.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn301.add(lblSoPhong301, BorderLayout.NORTH);
		pn204.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong204 = new JLabel("204");
		lblSoPhong204.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong204.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn204.add(lblSoPhong204, BorderLayout.NORTH);
		pn203.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong203 = new JLabel("203");
		lblSoPhong203.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong203.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn203.add(lblSoPhong203, BorderLayout.NORTH);
		pn206.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong206 = new JLabel("206");
		lblSoPhong206.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong206.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn206.add(lblSoPhong206, BorderLayout.NORTH);
		pn205.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong205 = new JLabel("205");
		lblSoPhong205.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong205.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn205.add(lblSoPhong205, BorderLayout.NORTH);
		pn202.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong202 = new JLabel("202");
		lblSoPhong202.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong202.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn202.add(lblSoPhong202, BorderLayout.NORTH);
		pn201.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong201 = new JLabel("201");
		lblSoPhong201.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong201.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn201.add(lblSoPhong201, BorderLayout.NORTH);
		pn106.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong106 = new JLabel("106");
		lblSoPhong106.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong106.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn106.add(lblSoPhong106, BorderLayout.NORTH);
		pn105.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong105 = new JLabel("105");
		lblSoPhong105.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong105.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn105.add(lblSoPhong105, BorderLayout.NORTH);
		pn104.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong104 = new JLabel("104");
		lblSoPhong104.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong104.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn104.add(lblSoPhong104, BorderLayout.NORTH);
		pn103.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong103 = new JLabel("103");
		lblSoPhong103.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong103.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn103.add(lblSoPhong103, BorderLayout.NORTH);
		pn102.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong102 = new JLabel("102");
		lblSoPhong102.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoPhong102.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pn102.add(lblSoPhong102, BorderLayout.NORTH);
		pn101.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSoPhong101 = new JLabel("101");
		lblSoPhong101.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoPhong101.setHorizontalAlignment(SwingConstants.CENTER);
		pn101.add(lblSoPhong101, BorderLayout.NORTH);
		
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
		
		JDateChooser dcNgayThue = new JDateChooser();
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_pnThongTinThuePhong = new GroupLayout(pnThongTinThuePhong);
		gl_pnThongTinThuePhong.setHorizontalGroup(
			gl_pnThongTinThuePhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCMND, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cboCMND, 0, 203, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNgayThue, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dcNgayThue, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNgayTraDuKien, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dcNgayTraDuKien, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnThongTinThuePhong.setVerticalGroup(
			gl_pnThongTinThuePhong.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
					.addGroup(gl_pnThongTinThuePhong.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
							.addContainerGap()
							.addComponent(dcNgayTraDuKien, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
						.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNgayTraDuKien, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
						.addGroup(gl_pnThongTinThuePhong.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnThongTinThuePhong.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTenKH, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
								.addComponent(dcNgayThue, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
								.addComponent(lblNgayThue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCMND, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cboCMND, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))))
					.addContainerGap())
		);
		pnThongTinThuePhong.setLayout(gl_pnThongTinThuePhong);
		getContentPane().setLayout(groupLayout);
		
		pn101.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listModelPhongDaChon.addElement(" 101 ");
			}
		});
		
		pn102.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listModelPhongDaChon.addElement(" 102 ");
			}
		});
	}
}

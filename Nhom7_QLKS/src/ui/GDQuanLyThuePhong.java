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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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
					GDQuanLyThuePhong window = new GDQuanLyThuePhong();
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
	public GDQuanLyThuePhong() {
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
				new GDQuanLyThuePhong().setVisible(true);
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
				new GDQuanLyPhong().setVisible(true);
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
				new GDQuanLyNhanVien().setVisible(true);
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
				new GDQuanLyNhanVien().setVisible(true);
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
				new GDThongKe().setVisible(true);
				dispose();
			}
		});
		mnThongKe.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Image imgThongKe = new ImageIcon(this.getClass().getResource("/img/thongke.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		mnThongKe.setIcon(new ImageIcon(imgThongKe));
		mnChucNang.add(mnThongKe);
		
		JPanel pnThongTinThuePhong = new JPanel();
		pnThongTinThuePhong.setBackground(Color.WHITE);
		pnThongTinThuePhong.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JPanel pnPhongDaThue = new JPanel();
		pnPhongDaThue.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnPhongDaThue.setBackground(Color.WHITE);
		pnPhongDaThue.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblPhongDaThue = new JLabel("Phòng đã thuê");
		lblPhongDaThue.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel pnTang1 = new JPanel();
		pnTang1.setBackground(Color.DARK_GRAY);
		
		JLabel lblChuThich = new JLabel("Chú thích");
		lblChuThich.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel pnChuThich = new JPanel();
		pnChuThich.setBackground(new Color(64, 224, 208));
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.setFocusable(false);
		
		JButton btnHoanTat = new JButton("Hoàn tất");
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPhongDaThue, GroupLayout.DEFAULT_SIZE, 1333, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnChuThich, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
								.addComponent(pnThongTinThuePhong, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
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
										.addComponent(pn106, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
										.addComponent(pn206, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
										.addComponent(pn306, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnHoanTat, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addComponent(pnPhongDaThue, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblChuThich, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
							.addGap(1160))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnThongTinThuePhong, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(lblPhongDaThue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnPhongDaThue, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
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
										.addComponent(pn301, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
										.addComponent(pnTang3, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
									.addGap(20)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSao, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblChuThich, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(6))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pn302, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
									.addGap(47))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pn103, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(pn203, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(pn303, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(46))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pn104, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(pn204, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(pn304, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
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
								.addComponent(pn305, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(pn306, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
							.addGap(46)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnChuThich, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnHoanTat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHuy))
					.addContainerGap())
		);
		
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
		
	}
}

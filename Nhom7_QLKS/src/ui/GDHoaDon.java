package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class GDHoaDon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8517422376548394506L;
	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtSoCMND;
	private JTable tableDichVu;
	private JTextField txtTongTien;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDHoaDon window = new GDHoaDon(tenTK);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDHoaDon(String tenTK) {
		setTitle("Hóa đơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 740);
		contentPane = new JPanel();
		setUndecorated(true);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		Image imgChinh = new ImageIcon(this.getClass().getResource("/img/logo.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		setIconImage(imgChinh);
		
		JLabel lblKH = new JLabel("Tên khách hàng:");
		lblKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblSoCMND = new JLabel("Số CMND:");
		lblSoCMND.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ngày thuê:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel pnDSDV = new JPanel();
		pnDSDV.setBorder(new TitledBorder(null, "Danh s\u00E1ch d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblTongTien = new JLabel("Tổng tiền:");
		lblTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtTongTien = new JTextField();
		txtTongTien.setEnabled(false);
		txtTongTien.setText("");
		txtTongTien.setColumns(10);
		
		JPanel pnTieuDe = new JPanel();
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnDong = new JButton("Đóng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnTieuDe.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHoaDon = new JLabel("Hóa Đơn");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		pnTieuDe.add(lblHoaDon, BorderLayout.CENTER);
		lblHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnDSDV = new GroupLayout(pnDSDV);
		gl_pnDSDV.setHorizontalGroup(
			gl_pnDSDV.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
		);
		gl_pnDSDV.setVerticalGroup(
			gl_pnDSDV.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
		);
		
		tableDichVu = new JTable();
		tableDichVu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		tableDichVu.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 d\u1ECBch v\u1EE5", "T\u00EAn d\u1ECBch v\u1EE5", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(tableDichVu);
		pnDSDV.setLayout(gl_pnDSDV);
		
		txtTenKH = new JTextField();
		txtTenKH.setEnabled(false);
		txtTenKH.setColumns(10);
		
		txtSoCMND = new JTextField();
		txtSoCMND.setEnabled(false);
		txtSoCMND.setColumns(10);
		
		JRadioButton radNu = new JRadioButton("Nữ");
		
		JRadioButton radNam = new JRadioButton("Nam");
		radNam.setFocusable(false);
		radNu.setFocusable(false);
		
		JDateChooser dateChooserNgayThue = new JDateChooser();
		
		JLabel lblSoPhong = new JLabel("Số phòng:");
		lblSoPhong.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		
		JDateChooser dateChooserNgayTra = new JDateChooser();
		
		JLabel lblNgayTra = new JLabel("Ngày trả:");
		lblNgayTra.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNgayTra.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblKH)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSoCMND, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtSoCMND, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSoPhong, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgayTra, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(radNu, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(radNam, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooserNgayThue, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addComponent(dateChooserNgayTra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(104))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnDSDV, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
						.addComponent(pnTieuDe, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDong, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(122)
							.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTongTien, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(pnTieuDe, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblKH, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSoPhong, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSoCMND, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoCMND, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooserNgayTra, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgayTra, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_1_2_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(radNu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addComponent(radNam, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(dateChooserNgayThue, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(pnDSDV, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLuu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDong, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtTongTien, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}

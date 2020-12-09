package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import connectDB.ConnectDB;

public class GDDoiMatKhau extends JFrame {

	private static final long serialVersionUID = -1373418494584545110L;
	private JPanel contentPane;
	private JTextField txtMKM;
	private JTextField txtNLMKM;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tenTK = "abc";
					GDDoiMatKhau frame = new GDDoiMatKhau(tenTK);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDDoiMatKhau(String tenTK) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 470);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Image imgChinh = new ImageIcon(this.getClass().getResource("/img/logo.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		setIconImage(imgChinh);
		
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		pnTieuDe.setBackground(SystemColor.inactiveCaption);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		pnChucNang.setBackground(SystemColor.inactiveCaption);
		
		JLabel lblMatKhauMoi = new JLabel("Mật khẩu mới");
		lblMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu mới");
		lblNhpLiMt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtMKM = new JTextField();
		txtMKM.setColumns(10);
		
		txtNLMKM = new JTextField();
		txtNLMKM.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(pnTieuDe, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(101)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNhpLiMt, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
						.addComponent(lblMatKhauMoi))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtMKM, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNLMKM, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(117, Short.MAX_VALUE))
				.addComponent(pnChucNang, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pnTieuDe, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMatKhauMoi, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMKM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNLMKM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNhpLiMt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(93)
					.addComponent(pnChucNang, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(128, Short.MAX_VALUE))
		);
		
		JButton btnLuuThayDoi = new JButton("Lưu thay đổi");
		btnLuuThayDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o.equals(btnLuuThayDoi)) {
					String passMoi = txtMKM.getText();
					String passMoiNhapLai = txtNLMKM.getText();
					if(passMoiNhapLai.equals(passMoi)) {
						try {
							ConnectDB.getInstance();
							Connection con = ConnectDB.getConnection();
							String sql = "Update TaiKhoan set MatKhau=? where TaiKhoan=?";
							PreparedStatement ps = con.prepareStatement(sql);
							ps.setString(1, passMoi);
							ps.setString(2, tenTK);
							
							ps.executeUpdate();
							int xacnhan = JOptionPane.showConfirmDialog(null, "Chắc chắn thay đổi mật khẩu này?", "Nhắc nhở", JOptionPane.YES_NO_OPTION);
							if(xacnhan == JOptionPane.YES_OPTION)
								dispose();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}	
					}
					else {
						JOptionPane.showMessageDialog(null, "Không đúng với mật khẩu trên");
					}
				}
			}
		});
		btnLuuThayDoi.setFocusable(false);
		btnLuuThayDoi.setBackground(SystemColor.textHighlight);
		btnLuuThayDoi.setForeground(SystemColor.text);
		btnLuuThayDoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDong = new JButton("Đóng");
		btnDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDong.setForeground(SystemColor.desktop);
		btnDong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDong.setFocusable(false);
		btnDong.setBackground(SystemColor.window);
		GroupLayout gl_pnChucNang = new GroupLayout(pnChucNang);
		gl_pnChucNang.setHorizontalGroup(
			gl_pnChucNang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChucNang.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnLuuThayDoi, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
					.addComponent(btnDong, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_pnChucNang.setVerticalGroup(
			gl_pnChucNang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnChucNang.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_pnChucNang.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDong, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(btnLuuThayDoi, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		pnChucNang.setLayout(gl_pnChucNang);
		pnTieuDe.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDoiMatKhau = new JLabel("ĐỔI MẬT KHẨU");
		lblDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 30));
		Image imgMatKhau = new ImageIcon(this.getClass().getResource("/img/doimatkhau.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
		lblDoiMatKhau.setIcon(new ImageIcon(imgMatKhau));
		pnTieuDe.add(lblDoiMatKhau, BorderLayout.WEST);
		contentPane.setLayout(gl_contentPane);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
}

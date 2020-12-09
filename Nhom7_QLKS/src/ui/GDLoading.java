package ui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class GDLoading extends JFrame {
	
	private static final long serialVersionUID = 3495565261019403772L;
	private JPanel contentPane;
	private static JProgressBar progressBar;

	public static void main(String[] args) {
		int x;
		GDLoading gdLoading = new GDLoading();
		gdLoading.setVisible(true);
		try {
			for(x = 0; x <= 100; x++) {
				gdLoading.progressBar.setValue(x);
				Thread.sleep(50);
				if(x == 100) {
					gdLoading.dispose();
					new GDDangNhap().setVisible(true);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public GDLoading() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		Image imgChinh = new ImageIcon(this.getClass().getResource("/img/logo.jpg")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		setIconImage(imgChinh);
		
		JPanel pnHinhNen = new JPanel();
		pnHinhNen.setBounds(0, 0, 800, 590);
		contentPane.add(pnHinhNen);
		pnHinhNen.setLayout(null);
		
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(100, 149, 237)));
		pnTieuDe.setBounds(0, 44, 800, 52);
		pnHinhNen.add(pnTieuDe);
		pnTieuDe.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("KHÁCH SẠN TÂM BÌNH");
		lblTieuDe.setForeground(new Color(100, 149, 237));
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnTieuDe.add(lblTieuDe, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(677, 563, 123, 27);
		pnHinhNen.add(panel);
		
		JLabel lblHinhNen = new JLabel("");
		lblHinhNen.setBounds(0, 0, 800, 590);
		lblHinhNen.setIcon(new ImageIcon(GDLoading.class.getResource("/img/load.gif")));
		lblHinhNen.setHorizontalAlignment(SwingConstants.CENTER);
		pnHinhNen.add(lblHinhNen);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(100, 149, 237));
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(0, 589, 800, 11);
		contentPane.add(progressBar);
	}
}
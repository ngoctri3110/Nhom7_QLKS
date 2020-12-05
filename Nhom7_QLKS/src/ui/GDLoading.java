package ui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GDLoading extends JFrame {
	
	private static final long serialVersionUID = 3495565261019403772L;
	private JPanel contentPane;

	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDLoading frame = new GDLoading();
					frame.setVisible(true);
					try {
						for(int i = 0; i <= 100; i++) {
							Thread.sleep(50);
							if(i == 100) {
								frame.setVisible(false);
								new GDDangNhap().setVisible(true);
							}
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GDLoading() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		pnHinhNen.setBounds(0, 0, 450, 300);
		contentPane.add(pnHinhNen);
		pnHinhNen.setLayout(null);
		
		JLabel lblHinhNen = new JLabel("New label");
		lblHinhNen.setBounds(0, 0, 450, 300);
		lblHinhNen.setIcon(new ImageIcon(GDLoading.class.getResource("/img/nenloading.jpg")));
		lblHinhNen.setHorizontalAlignment(SwingConstants.CENTER);
		pnHinhNen.add(lblHinhNen);
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
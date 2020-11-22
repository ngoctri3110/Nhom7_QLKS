package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GDDichVu extends JFrame{

	private static final long serialVersionUID = -7803746082041510802L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDDichVu window = new GDDichVu();
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
	public GDDichVu() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

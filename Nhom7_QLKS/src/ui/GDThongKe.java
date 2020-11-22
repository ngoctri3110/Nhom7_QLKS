package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.JButton;
import java.awt.Color;

public class GDThongKe extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7497550087011451461L;
	
	public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ DÂN SỐ VIỆT NAM",
                "Năm", "Số người",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }
	
	private static JFreeChart createCircleChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "CƠ CẤU DÂN SỐ THEO NHÓM TUỔI NĂM 2010", dataset, true, true, true);
        return chart;
    }
	
	@SuppressWarnings("deprecation")
	private static PieDataset createCircleDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Nhóm 0 - 14", new Double(25.0));
        dataset.setValue("Nhóm 15 - 59", new Double(66.0));
        dataset.setValue("Nhóm trên 60", new Double(9.0));
        return dataset;
    }
	
	private static CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(68000000, "Số người", "1990");
        dataset.addValue(80000000, "Số người", "2000");
        dataset.addValue(88000000, "Số người", "2010");
        dataset.addValue(95000000, "Số người", "2020");
        return dataset;
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDThongKe window = new GDThongKe();
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
	public GDThongKe() {

        JFreeChart pieChart = createCircleChart(createCircleDataset());
        ChartPanel chartCirclePanel = new ChartPanel(pieChart);
        ChartPanel chartPanel = new ChartPanel(createChart());
        
        JButton btnThngK = new JButton("THỐNG KÊ");
        btnThngK.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnThngK.setFocusable(false);
        btnThngK.setEnabled(false);
        btnThngK.setBackground(Color.CYAN);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(chartPanel, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(chartCirclePanel, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
        		.addComponent(btnThngK, GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(btnThngK, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addGap(115)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        				.addComponent(chartCirclePanel, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)))
        );
        getContentPane().setLayout(groupLayout);
		
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
	}
}

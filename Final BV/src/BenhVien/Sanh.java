package BenhVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sanh extends JFrame{
	private JFrame jfr;
	public Sanh() {
		// TODO Auto-generated constructor stub
		jfr = new JFrame("Sảnh");
		jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jfr.setSize(797, 453);
		
		JPanel Main = new JPanel();
		Main.setLayout(null);
		jfr.add(Main);
		
		JButton jbtThongTin = new JButton("Thông Tin");
		jbtThongTin.setBackground(Color.LIGHT_GRAY);
		jbtThongTin.setFont(new Font("Times New Roman", Font.BOLD, 19));
		jbtThongTin.setBounds(315, 173, 146, 68);
		Main.add(jbtThongTin);
		jbtThongTin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfr.dispose();
				new GDChinh();
			}
			
		});
		
		JButton jbtDX = new JButton("Đăng Xuất");
		jbtDX.setBackground(Color.LIGHT_GRAY);
		jbtDX.setFont(new Font("Times New Roman", Font.BOLD, 18));
		jbtDX.setBounds(565, 334, 129, 28);
		Main.add(jbtDX);
		jbtDX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfr.dispose();
				new Login();
			}
			
		});
		
		JLabel jlbTD = new JLabel("Trang Chủ");
		jlbTD.setForeground(Color.BLUE);
		jlbTD.setFont(new Font("Times New Roman", Font.BOLD, 30));
		jlbTD.setBounds(302, 48, 159, 28);
		Main.add(jlbTD);
		
		JLabel jlb = new JLabel("");
		jlb.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Sanh.class.getResource("GD1.jpg"))));
		jlb.setBounds(0, 0, 805, 470);
		Main.add(jlb);
		
		
		jfr.setVisible(true);
		jfr.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Sanh();
	}
}

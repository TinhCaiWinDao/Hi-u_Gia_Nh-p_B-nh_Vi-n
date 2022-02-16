package BenhVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DangKy {
	private JFrame jfr;
	private JTextField jtftk;
	private JPasswordField jtfmk;
	private Connection conn;
	private Statement stml;
	private ResultSet rs;
	public DangKy() {
		// TODO Auto-generated constructor stub
		jfr = new JFrame("Login");
		jfr.setDefaultCloseOperation(jfr.EXIT_ON_CLOSE);
		jfr.setBounds(100, 100, 319, 427);
		
		JPanel Main = new JPanel();
		Main.setLayout(null);
		jfr.add(Main);
		
		JLabel jlbTB = new JLabel("Đăng ký tài khoản");
		jlbTB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jlbTB.setBounds(86, 38, 141, 43);
		Main.add(jlbTB);
		
		JLabel jlbTK = new JLabel("Tài Khoản");
		jlbTK.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jlbTK.setBounds(28, 134, 100, 22);
		Main.add(jlbTK);
		
		JLabel jlbmk = new JLabel("Mật Khẩu");
		jlbmk.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jlbmk.setBounds(28, 182, 100, 22);
		Main.add(jlbmk);
		
		jtftk = new JTextField();
		jtftk.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtftk.setBounds(126, 138, 157, 19);
		Main.add(jtftk);
		jtftk.setColumns(10);
		
		jtfmk = new JPasswordField();
		jtfmk.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtfmk.setColumns(10);
		jtfmk.setBounds(126, 186, 157, 19);
		Main.add(jtfmk);
		
		JButton jbtDK = new JButton("Đăng ký");
		jbtDK.setBackground(Color.LIGHT_GRAY);
		jbtDK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jbtDK.setBounds(38, 277, 100, 21);
		Main.add(jbtDK);
		jbtDK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=BenhVien;integratedSecurity=true";
					conn = DriverManager.getConnection(connectionURL, "sa", "sa");
					stml = conn.createStatement();
					//JOptionPane.showMessageDialog(null, "Kết nối thành công!!");	 
					String sql = "Insert into TaiKhoan values ('"+jtftk.getText()+"', '"+jtfmk.getText()+"')";
					stml.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Đăng ký thành công!!");
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Đăng ký thất bại");
				}
			}
			
		});
		
		JButton jbtDN = new JButton("Đăng Nhập");
		jbtDN.setBackground(Color.LIGHT_GRAY);
		jbtDN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jbtDN.setBounds(155, 277, 117, 21);
		Main.add(jbtDN);
		
		jbtDN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfr.dispose();
				new Login();
			}
			
		});
		
		jfr.setVisible(true);
		jfr.setLocationRelativeTo(null);
	}
}

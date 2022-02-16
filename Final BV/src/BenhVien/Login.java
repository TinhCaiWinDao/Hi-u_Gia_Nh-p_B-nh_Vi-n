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

public class Login extends JFrame{
	private JFrame jfr;
	private JTextField jtftk;
	private JPasswordField jtfmk;
	private Connection conn;
	private Statement stml;
	private ResultSet rs;
	public Login() {
		// TODO Auto-generated constructor stub
		jfr = new JFrame("Login");
		jfr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jfr.setBounds(100, 100, 319, 427);
		
		JPanel Main = new JPanel();
		Main.setLayout(null);
		jfr.add(Main);
		
		JLabel jlbTB = new JLabel("Đăng Nhập");
		jlbTB.setFont(new Font("Times New Roman", Font.BOLD, 25));
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
		
		JButton jbtlogin = new JButton("Đăng Nhập");
		jbtlogin.setBackground(Color.LIGHT_GRAY);
		jbtlogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jbtlogin.setBounds(38, 277, 100, 21);
		Main.add(jbtlogin);
		jbtlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jtftk.getText().equals("") && jtfmk.getText().equals("")) {
					 JOptionPane.showMessageDialog(null, "Chưa nhập tài khoản và mật khẩu!!");
				 } else if(jtftk.getText().equals("")) {
					 JOptionPane.showMessageDialog(null, "Chưa nhập tài khoản!!");
				 } else if(jtfmk.getText().equals("")) {
					 JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!!");
				 } else {
					 try {
						 try {
								String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=BenhVien;integratedSecurity=true";
								conn = DriverManager.getConnection(connectionURL, "sa", "sa");
								stml = conn.createStatement();
								//JOptionPane.showMessageDialog(null, "Kết nối thành công!!");	 
								String sql = "Select * from TaiKhoan";
								rs = stml.executeQuery(sql);
								while(rs.next()) {
									 String user = rs.getString(1);
									 String pass = rs.getString(2);
									 
									 if(jtftk.getText().equals(user) && jtfmk.getText().equals(pass)) {
											JOptionPane.showMessageDialog(null, "Đăng nhập thành công!!");
											new Sanh();
											jfr.dispose();
											break;
										} else {
											JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc sai mật khẩu!!");
											return;
										}
								}
							} catch (Exception e1) {
								// TODO: handle exception
								System.out.println(e1);
								JOptionPane.showMessageDialog(null, e1.toString());
							}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				 }
			}
			
		});
		
		JButton jbtDK = new JButton("Đăng ký");
		jbtDK.setBackground(Color.LIGHT_GRAY);
		jbtDK.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jbtDK.setBounds(155, 277, 117, 21);
		Main.add(jbtDK);
		
		jbtDK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfr.dispose();
				new DangKy();
			}
			
		});
		
		jfr.setVisible(true);
		jfr.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Login();
	}
}

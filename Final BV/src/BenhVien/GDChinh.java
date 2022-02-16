package BenhVien;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;

public class GDChinh extends JFrame{
	private JFrame jfr;
	private JTextField jtfID;
	private JTextField jtfName;
	private JTextField jtfGT;
	private JTextField jtfSDT;
	private JTextField jtfCCCD;
	private JTextField jtfNS;
	private JTextField jtfDT;
	private JTextField jtfNN;
	private JTextField jtfMau;
	private JTextField jtfChieuCao;
	private JTextField jtfCanNang;
	private JTextField jtfSearch;
	private DefaultTableModel model;
	private JTable tbl;
	private Connection conn;
	private Statement stml;
	private ResultSet rs;
	public GDChinh() {
		// TODO Auto-generated constructor stub
		jfr = new JFrame("Login");
		jfr.setDefaultCloseOperation(jfr.EXIT_ON_CLOSE);
		jfr.setBounds(100, 100, 968, 703);
		
		Connection();
		
		JPanel Main = new JPanel();
		Main.setLayout(new GridLayout(2,1));
		jfr.add(Main);
		
		JPanel Top = new JPanel();
		Top.setLayout(null);
		Main.add(Top);
		
		JPanel Bot = new JPanel();
		Bot.setLayout(new BorderLayout());
		Main.add(Bot);
		
		JLabel jlbTD = new JLabel("Thông Tin Bệnh Nhân");
		jlbTD.setFont(new Font("Times New Roman", Font.BOLD, 25));
		jlbTD.setBounds(354, 10, 265, 25);
		Top.add(jlbTD);
		
		JLabel jlbID = new JLabel("Mã Hồ Sơ");
		jlbID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbID.setBounds(36, 61, 89, 19);
		Top.add(jlbID);
		
		JLabel jlbName = new JLabel("Họ Tên");
		jlbName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbName.setBounds(36, 90, 89, 19);
		Top.add(jlbName);
		
		JLabel jlbGT = new JLabel("Giới Tính");
		jlbGT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbGT.setBounds(36, 119, 89, 19);
		Top.add(jlbGT);
		
		JLabel jlbSDT = new JLabel("Số Điện Thoại");
		jlbSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbSDT.setBounds(36, 148, 99, 19);
		Top.add(jlbSDT);
		
		JLabel jlbCCCD = new JLabel("CMND/CCCD");
		jlbCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbCCCD.setBounds(36, 177, 99, 19);
		Top.add(jlbCCCD);
		
		JLabel jlbNS = new JLabel("Ngày Sinh");
		jlbNS.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbNS.setBounds(36, 206, 89, 19);
		Top.add(jlbNS);
		
		JLabel jlbDT = new JLabel("Dân Tộc");
		jlbDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbDT.setBounds(486, 65, 89, 19);
		Top.add(jlbDT);
		
		JLabel jlbNN = new JLabel("Nghề Nghiệp");
		jlbNN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbNN.setBounds(486, 94, 89, 19);
		Top.add(jlbNN);
		
		JLabel jlbMau = new JLabel("Nhóm Máu");
		jlbMau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbMau.setBounds(486, 123, 89, 19);
		Top.add(jlbMau);
		
		JLabel jlbChieuCao = new JLabel("Chiều Cao");
		jlbChieuCao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbChieuCao.setBounds(486, 152, 89, 19);
		Top.add(jlbChieuCao);
		
		JLabel jlbCanNang = new JLabel("Cân Nặng");
		jlbCanNang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbCanNang.setBounds(486, 181, 89, 19);
		Top.add(jlbCanNang);
		
		JLabel jlbSearch = new JLabel("Tìm Kiếm");
		jlbSearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbSearch.setBounds(46, 286, 89, 19);
		Top.add(jlbSearch);
		
		JLabel jlbTB = new JLabel("");
		jlbTB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jlbTB.setBounds(618, 290, 273, 19);
		Top.add(jlbTB);
		
		jtfID = new JTextField();
		jtfID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfID.setBounds(150, 60, 174, 19);
		Top.add(jtfID);
		jtfID.setColumns(10);
		
		jtfName = new JTextField();
		jtfName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfName.setColumns(10);
		jtfName.setBounds(150, 91, 174, 19);
		Top.add(jtfName);
		
		jtfGT = new JTextField();
		jtfGT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfGT.setColumns(10);
		jtfGT.setBounds(150, 120, 174, 19);
		Top.add(jtfGT);
		
		jtfSDT = new JTextField();
		jtfSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfSDT.setColumns(10);
		jtfSDT.setBounds(150, 149, 174, 19);
		Top.add(jtfSDT);
		
		jtfCCCD = new JTextField();
		jtfCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfCCCD.setColumns(10);
		jtfCCCD.setBounds(150, 178, 174, 19);
		Top.add(jtfCCCD);
		
		jtfNS = new JTextField();
		jtfNS.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfNS.setColumns(10);
		jtfNS.setBounds(150, 207, 174, 19);
		Top.add(jtfNS);
		
		jtfDT = new JTextField();
		jtfDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfDT.setColumns(10);
		jtfDT.setBounds(596, 62, 174, 19);
		Top.add(jtfDT);
		
		jtfNN = new JTextField();
		jtfNN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfNN.setColumns(10);
		jtfNN.setBounds(596, 91, 174, 19);
		Top.add(jtfNN);
		
		jtfMau = new JTextField();
		jtfMau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfMau.setColumns(10);
		jtfMau.setBounds(596, 120, 174, 19);
		Top.add(jtfMau);
		
		jtfChieuCao = new JTextField();
		jtfChieuCao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfChieuCao.setColumns(10);
		jtfChieuCao.setBounds(596, 151, 174, 19);
		Top.add(jtfChieuCao);
		
		jtfCanNang = new JTextField();
		jtfCanNang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfCanNang.setColumns(10);
		jtfCanNang.setBounds(596, 178, 174, 19);
		Top.add(jtfCanNang);
		
		jtfSearch = new JTextField();
		jtfSearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtfSearch.setBounds(143, 287, 317, 19);
		Top.add(jtfSearch);
		jtfSearch.setColumns(10);
		
		JButton jbtAdd = new JButton("Add");
		jbtAdd.setBackground(Color.WHITE);
		jbtAdd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtAdd.setBounds(43, 241, 97, 29);
		Top.add(jbtAdd);
		jbtAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String sql = "Insert into ThongTin values (N'"+jtfID.getText()+"', N'"+jtfName.getText()+"', N'"+jtfGT.getText()+"', N'"+jtfSDT.getText()+"', N'"+jtfCCCD.getText()+"', N'"+jtfNS.getText()+"', N'"+jtfDT.getText()+"', N'"+jtfNN.getText()+"', N'"+jtfMau.getText()+"',"
							+ "N'"+jtfChieuCao.getText()+"', N'"+jtfCanNang.getText()+"')";
					stml.executeUpdate(sql);
					jlbTB.setText("Đã thêm thành công!!!");
					DefaultTableModel model = (DefaultTableModel)tbl.getModel();
					model.setRowCount(0);
					Show_DL();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.print(e2);
					JOptionPane.showMessageDialog(null, "Thêm thất bại!");
				}
			}
			
		});
		
		JButton jbtNext = new JButton("Next");
		jbtNext.setBackground(Color.WHITE);
		jbtNext.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtNext.setBounds(186, 240, 97, 29);
		Top.add(jbtNext);
		jbtNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtfCanNang.setText(null);
				jtfCCCD.setText(null);
				jtfChieuCao.setText(null);
				jtfDT.setText(null);
				jtfGT.setText(null);
				jtfID.setText(null);
				jtfMau.setText(null);
				jtfName.setText(null);
				jtfNN.setText(null);
				jtfNS.setText(null);
				jtfSDT.setText(null);
				jtfSearch.setText(null);
			}
			
		});
		
		JButton jbtUpdate = new JButton("Update");
		jbtUpdate.setBackground(Color.WHITE);
		jbtUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtUpdate.setBounds(324, 240, 97, 29);
		Top.add(jbtUpdate);
		jbtUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String update = "UPDATE ThongTin set Name = N'"+jtfName.getText()+"', GT = N'"+jtfGT.getText()+"', SDT = N'"+jtfSDT.getText()+""
							+ "', CMND = N'"+jtfCCCD.getText()+"', NgaySinh = N'"+jtfNS.getText()+"', DT = N'"+jtfDT.getText()+"', NN = N'"+jtfNN.getText()+"', Mau = N'"+jtfMau.getText()+"', ChieuCao = N'"+jtfChieuCao.getText()+"', CanNang = N'"+jtfCanNang.getText()+"' where MaHoSo = '"+jtfID.getText()+"'";
					stml.executeUpdate(update);
					jlbTB.setText("Đã cập nhập thành công!!!");
					DefaultTableModel model = (DefaultTableModel)tbl.getModel();
					model.setRowCount(0);
					Show_DL();
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Cập nhập thất bại!!");
				}
			}
			
		});
		
		JButton jbtReset = new JButton("Reset");
		jbtReset.setBackground(Color.WHITE);
		jbtReset.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtReset.setBounds(610, 241, 97, 29);
		Top.add(jbtReset);
		jbtReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtfCanNang.setText(null);
				jtfCCCD.setText(null);
				jtfChieuCao.setText(null);
				jtfDT.setText(null);
				jtfGT.setText(null);
				jtfID.setText(null);
				jtfMau.setText(null);
				jtfName.setText(null);
				jtfNN.setText(null);
				jtfNS.setText(null);
				jtfSDT.setText(null);
				jtfSearch.setText(null);
				DefaultTableModel model = (DefaultTableModel)tbl.getModel();
				model.setRowCount(0);
				Show_DL();
			}
			
		});
		
		JButton jbtDelete = new JButton("Delete");
		jbtDelete.setBackground(Color.WHITE);
		jbtDelete.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtDelete.setBounds(465, 240, 97, 29);
		Top.add(jbtDelete);
		jbtDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String delete = "Delete from ThongTin where MaHoSo = '"+jtfID.getText()+"'";
					stml.executeUpdate(delete);
					DefaultTableModel model = (DefaultTableModel)tbl.getModel();
					model.setRowCount(0);
					Show_DL();
					jlbTB.setText("Đã xóa thành công!!!");
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Xóa thất bại!!");
				}
			}
			
		});
		
		JButton jbtReturn = new JButton("Return");
		jbtReturn.setBackground(Color.WHITE);
		jbtReturn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtReturn.setBounds(773, 241, 97, 29);
		Top.add(jbtReturn);
		jbtReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfr.dispose();
				new Sanh();
			}
			
		});
		
		JButton jbtSearch = new JButton("Search");
		jbtSearch.setBackground(Color.WHITE);
		jbtSearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jbtSearch.setBounds(518, 286, 85, 21);
		Top.add(jbtSearch);
		jbtSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					DefaultTableModel model = (DefaultTableModel)tbl.getModel();
					model.setRowCount(0);
					TimKiem();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		});
		
		model = new DefaultTableModel();
		model.addColumn("Mã Hồ Sơ");
		model.addColumn("Họ Tên");
		model.addColumn("Giới Tính");
		model.addColumn("Số Điện Thoại");
		model.addColumn("CMND/CCCD");
		model.addColumn("Ngày Sinh");
		model.addColumn("Dân Tộc");
		model.addColumn("Nghề Nghiệp");
		model.addColumn("Nhóm Máu");
		model.addColumn("Chiều Cao");
		model.addColumn("Cân Nặng");
		
		tbl = new JTable(model);
		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jtfID.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 0));
				jtfName.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 1));
				jtfGT.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 2));
				jtfSDT.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 3));
				jtfCCCD.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 4));
				jtfNS.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 5));
				jtfDT.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 6));
				jtfNN.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 7));
				jtfMau.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 8));
				jtfChieuCao.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 9));
				jtfCanNang.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 10));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	
		});
		
		JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Bot.add(sc);
		
		Show_DL();
		
		jfr.setVisible(true);
		jfr.setLocationRelativeTo(null);
	}
	public void Connection() {
		try {
			String connectionURL = "jdbc:sqlserver://DESKTOP-QHHHUUQ:1433;databaseName=BenhVien;integratedSecurity=true";
			conn = DriverManager.getConnection(connectionURL, "sa", "sa");
			stml = conn.createStatement();
			//JOptionPane.showMessageDialog(null, "Kết nối thành công!!");	 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	public void Show_DL() {
		try {
			String sql = "Select * from ThongTin";
			rs = stml.executeQuery(sql);
			while (rs.next()) {
				model.addRow(new String [] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void TimKiem() {
		try {
			//String search = "Select MaHoSo, Name, GT, SDT, CMND, NgaySinh, DT, NN, Mau, ChieuCao, CanNang from ThongTin where MaHoSo = '"+jtfSearch.getText()+"'";
			String search = "Select MaHoSo, Name, GT, SDT, CMND, NgaySinh, DT, NN, Mau, ChieuCao, CanNang from ThongTin where MaHoSo = '"+jtfSearch.getText()+"' or Name = N'"+jtfSearch.getText()+"' or GT = N'"+jtfSearch.getText()+"' or SDT = N'"+jtfSearch.getText()+"' or CMND = N'"+jtfSearch.getText()+"' or NgaySinh = N'"+jtfSearch.getText()+"' or DT = N'"+jtfSearch.getText()+"' or NN = N'"+jtfSearch.getText()+"' or Mau = N'"+jtfSearch.getText()+"' or ChieuCao = N'"+jtfSearch.getText()+"' or CanNang = N'"+jtfSearch.getText()+"'";
			rs = stml.executeQuery(search);
			while (rs.next()) {
				model.addRow(new String [] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),});
			} 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
			
	}
	public static void main(String[] args) {
		new GDChinh();
	}
}

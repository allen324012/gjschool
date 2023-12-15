package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.studentDaoImpl;
import model.student;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class studentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentUI frame = new studentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public studentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(55, 20, 388, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員管理系統");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(134, 10, 116, 29);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(55, 90, 388, 77);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(10, 26, 33, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文");
		lblNewLabel_1_1.setBounds(133, 26, 33, 15);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文");
		lblNewLabel_1_2.setBounds(253, 26, 33, 15);
		panel_1.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setBounds(32, 23, 96, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setBounds(153, 23, 96, 21);
		panel_1.add(chi);
		chi.setColumns(10);
		
		eng = new JTextField();
		eng.setBounds(282, 23, 96, 21);
		panel_1.add(eng);
		eng.setColumns(10);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 64));
		panel_2.setBounds(55, 177, 388, 233);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 53, 342, 156);
		panel_2.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JButton btnNewButton_1 = new JButton("查詢(String)");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.queryAll2()--->List
				 * 2.String show="";
				 */
				
				output.setText(new studentDaoImpl().queryAll1());
				
			}
		});
		btnNewButton_1.setBounds(47, 21, 105, 23);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查詢(List)");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.List-->queryAll2();
				 * 2.show:String;
				 * 
				 */
				List<student> l=new studentDaoImpl().queryAll2();
				String show="";
				int sum=0;
				int i=0;
				for(student o:l)
				{
					i++;
					sum=sum+(o.getChi()+o.getEng());
					
					
					
					show=show+"id:"+o.getId()+
							"\t名:"+o.getName()+
							"\t國文:"+o.getChi()+
							"\t英文:"+o.getEng()+
							"\t總分:"+(o.getChi()+o.getEng())+"\n";
					
				}
				
				
				show=show+"\n總分合計="+sum+"\t平均="+(sum/i);
				
				
				output.setText(show);
				
				
			}
		});
		btnNewButton_2.setBounds(225, 21, 87, 23);
		panel_2.add(btnNewButton_2);
		
		
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			/*
			 * 1.擷取 name,chi,eng getText()
			 * 2.name,chi-->轉整數
			 * 3.new student(name,chi,eng);
			 * 4.add(s);
			 */
				
				String Name=name.getText();
				int CHI=Integer.parseInt(chi.getText());
				int ENG=Integer.parseInt(eng.getText());				
				
				student s=new student(Name,CHI,ENG);
				
				new studentDaoImpl().add(s);
			
			
			}
		});
		btnNewButton.setBounds(20, 51, 87, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(453, 90, 403, 320);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		table = new JTable();
		table.setBounds(28, 65, 352, 230);
		panel_3.add(table);
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] s= new studentDaoImpl().queryAll2().toArray();
				DefaultTableModel model=new DefaultTableModel();
				model.setColumnIdentifiers(s);
				table.setModel(model);
				
			}
		});
		btnNewButton_3.setBounds(45, 10, 87, 23);
		panel_3.add(btnNewButton_3);
		
		
	}
}

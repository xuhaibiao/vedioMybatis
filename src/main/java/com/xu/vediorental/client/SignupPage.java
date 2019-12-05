package com.xu.vediorental.client;

import com.xu.vediorental.doMain.table.UserInfo;
import com.xu.vediorental.service.UserService;
import com.xu.vediorental.service.impl.UserServiceImpl;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupPage extends JFrame {
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_password;
	private JTextField textField_tel;

	public SignupPage() {
		final UserService userService = new UserServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ע�����");
		setBounds(100, 100, 817, 644);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((screenWidth - 817)/2, (screenHeight-644)/2);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_name = new JTextField();
		textField_name.setBounds(360, 191, 138, 24);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(360, 240, 138, 24);
		panel.add(textField_password);
		
		textField_tel = new JTextField();
		textField_tel.setColumns(10);
		textField_tel.setBounds(360, 291, 138, 24);
		panel.add(textField_tel);

		JLabel lblNewLabel_Slogan = new JLabel("####��ӭע��####");
		lblNewLabel_Slogan.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		lblNewLabel_Slogan.setBounds(280, 50, 500, 50);
		panel.add(lblNewLabel_Slogan);

		JLabel lblNewLabel_name = new JLabel("�û���:");
		lblNewLabel_name.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		lblNewLabel_name.setBounds(302, 192, 60, 20);
		panel.add(lblNewLabel_name);
		
		JLabel lblNewLabel_password = new JLabel("����:");
		lblNewLabel_password.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		lblNewLabel_password.setBounds(302, 241, 60, 20);
		panel.add(lblNewLabel_password);
		
		JLabel lblNewLabel_tel = new JLabel("�绰:");
		lblNewLabel_tel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		lblNewLabel_tel.setBounds(302, 292, 60, 20);
		panel.add(lblNewLabel_tel);
		
		JButton btnNewButton_register = new JButton("ע ��");
		btnNewButton_register.setForeground(Color.BLACK);
		btnNewButton_register.setBackground(Color.WHITE);
		btnNewButton_register.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_register.setBounds(287, 362, 113, 42);
		panel.add(btnNewButton_register);
		
		JButton btnNewButton_back = new JButton("�� ��");
		btnNewButton_register.setForeground(Color.BLACK);
		btnNewButton_back.setBackground(Color.WHITE);
		btnNewButton_back.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_back.setBounds(431, 362, 113, 42);
		panel.add(btnNewButton_back);

		btnNewButton_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				IndexPage index = new IndexPage();
				index.frame.setVisible(true);
			}
		});

		btnNewButton_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField_name.getText();
				String password = textField_password.getText();
				String phonenum = textField_tel.getText();
				if (username.length() > 11 || password.length() > 11 || phonenum.length() > 11) {
					JOptionPane.showMessageDialog(null, "���Ȳ��ܳ���11λ����淶���룡", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (username.length() == 0 || password.length() == 0 || phonenum.length() == 0) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ���淶���룡", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
					return;
				} else{
					UserInfo user = new UserInfo();
					user.setPhonenum(phonenum);
					user.setUsername(username);
					user.setPassword(password);
					user.setRole(0);
					if (userService.register(user)) {
						JOptionPane.showMessageDialog(null, "ע��ɹ���ȷ����������ҳ...");
						setVisible(false);
						IndexPage index = new IndexPage();
						index.frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "���û����Ѵ��ڣ�", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

	}
}

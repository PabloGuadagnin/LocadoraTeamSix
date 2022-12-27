package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Carro extends JFrame {

	private JPanel contentPane;
	private JTextField textPlacaCarro;
	private JTextField textDiariaCarro;
	private JTextField textKmPorL;
	private JTextField textNpassageiros;
	private JTextField textNPortas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carro frame = new Carro();
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
	public Carro() {
		setMaximumSize(new Dimension(540, 540));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 540);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPlacaCarro = new JTextField();
		textPlacaCarro.setBounds(140, 126, 86, 20);
		contentPane.add(textPlacaCarro);
		textPlacaCarro.setColumns(10);
		
		JTextField textAnoCarro = new JTextField();
		textAnoCarro.setBounds(132, 158, 86, 20);
		contentPane.add(textAnoCarro);
		textAnoCarro.setColumns(10);
		
		textDiariaCarro = new JTextField();
		textDiariaCarro.setBounds(149, 186, 86, 20);
		contentPane.add(textDiariaCarro);
		textDiariaCarro.setColumns(10);
		
		textKmPorL = new JTextField();
		textKmPorL.setBounds(147, 261, 86, 20);
		contentPane.add(textKmPorL);
		textKmPorL.setColumns(10);
		
		textNpassageiros = new JTextField();
		textNpassageiros.setBounds(236, 226, 86, 20);
		contentPane.add(textNpassageiros);
		textNpassageiros.setColumns(10);
		
		textNPortas = new JTextField();
		textNPortas.setBounds(373, 134, 86, 20);
		contentPane.add(textNPortas);
		textNPortas.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Possui");
		chckbxNewCheckBox.setBounds(352, 155, 76, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(174, 356, 187, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Lucas.LUSCA\\Downloads\\Colorful Clean Frame Sign Up Instagram Post (1).png"));
		lblNewLabel.setBounds(0, 0, 524, 501);
		contentPane.add(lblNewLabel);
	}
}

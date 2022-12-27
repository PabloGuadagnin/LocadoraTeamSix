package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Onibus extends JFrame {

	private JPanel contentPane;
	private JTextField textPlacaBus;
	private JTextField textAnoBus;
	private JTextField textDiariaBus;
	private JTextField textNPassageirosBus;
	private JTextField textWifiBus;
	private JComboBox comboBox;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewOnibusCad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Onibus frame = new Onibus();
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
	public Onibus() {
		setMaximumSize(new Dimension(540, 540));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPlacaBus = new JTextField();
		textPlacaBus.setBounds(139, 129, 86, 20);
		contentPane.add(textPlacaBus);
		textPlacaBus.setColumns(10);
		
		textAnoBus = new JTextField();
		textAnoBus.setBounds(133, 157, 86, 20);
		contentPane.add(textAnoBus);
		textAnoBus.setColumns(10);
		
		textDiariaBus = new JTextField();
		textDiariaBus.setBounds(153, 188, 86, 20);
		contentPane.add(textDiariaBus);
		textDiariaBus.setColumns(10);
		
		textNPassageirosBus = new JTextField();
		textNPassageirosBus.setBounds(235, 226, 86, 20);
		contentPane.add(textNPassageirosBus);
		textNPassageirosBus.setColumns(10);
		
		textWifiBus = new JTextField();
		textWifiBus.setBounds(139, 261, 86, 20);
		contentPane.add(textWifiBus);
		textWifiBus.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(357, 156, 72, 22);
		contentPane.add(comboBox);
		
		chckbxNewCheckBox = new JCheckBox("Possui");
		chckbxNewCheckBox.setBounds(347, 128, 82, 23);
		contentPane.add(chckbxNewCheckBox);
		
		btnNewOnibusCad = new JButton("");
		btnNewOnibusCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewOnibusCad.setBorder(null);
		btnNewOnibusCad.setContentAreaFilled(false);
		btnNewOnibusCad.setBounds(179, 357, 183, 37);
		contentPane.add(btnNewOnibusCad);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Lucas.LUSCA\\Downloads\\Colorful Clean Frame Sign Up Instagram Post (4).png"));
		lblNewLabel.setBounds(0, 0, 523, 500);
		contentPane.add(lblNewLabel);
	}
}
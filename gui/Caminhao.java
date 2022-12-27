package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Caminhao extends JFrame {

	private JPanel contentPane;
	private JTextField textPlacaCaminhao;
	private JTextField textAnoCaminhao;
	private JTextField textDiariaCaminhao;
	private JTextField textNEsixosCaminhao;
	private JTextField textCargaMaxCaminhao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caminhao frame = new Caminhao();
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
	public Caminhao() {
		setMaximumSize(new Dimension(540, 540));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPlacaCaminhao = new JTextField();
		textPlacaCaminhao.setBounds(139, 129, 81, 20);
		contentPane.add(textPlacaCaminhao);
		textPlacaCaminhao.setColumns(10);
		
		textAnoCaminhao = new JTextField();
		textAnoCaminhao.setBounds(139, 160, 81, 20);
		contentPane.add(textAnoCaminhao);
		textAnoCaminhao.setColumns(10);
		
		textDiariaCaminhao = new JTextField();
		textDiariaCaminhao.setBounds(149, 189, 81, 20);
		contentPane.add(textDiariaCaminhao);
		textDiariaCaminhao.setColumns(10);
		
		textNEsixosCaminhao = new JTextField();
		textNEsixosCaminhao.setBounds(165, 220, 81, 20);
		contentPane.add(textNEsixosCaminhao);
		textNEsixosCaminhao.setColumns(10);
		
		textCargaMaxCaminhao = new JTextField();
		textCargaMaxCaminhao.setBounds(215, 263, 81, 20);
		contentPane.add(textCargaMaxCaminhao);
		textCargaMaxCaminhao.setColumns(10);
		
		JButton btnNewCaminhaoCad = new JButton("");
		btnNewCaminhaoCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewCaminhaoCad.setContentAreaFilled(false);
		btnNewCaminhaoCad.setBorder(null);
		btnNewCaminhaoCad.setBounds(178, 360, 183, 34);
		contentPane.add(btnNewCaminhaoCad);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Lucas.LUSCA\\Downloads\\Colorful Clean Frame Sign Up Instagram Post (2).png"));
		lblNewLabel.setBounds(0, 0, 525, 501);
		contentPane.add(lblNewLabel);
	}
}

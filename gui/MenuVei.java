package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuVei extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVei frame = new MenuVei();
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
	public MenuVei() {
		setMaximumSize(new Dimension(540, 540));
		setBounds(100, 100, 538, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewCarro = new JButton("");
		btnNewCarro.setBorder(null);
		btnNewCarro.setContentAreaFilled(false);
		btnNewCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carro telaCarro = new Carro();
				telaCarro.setVisible(true);
			}
		});
		btnNewCarro.setBounds(197, 147, 188, 37);
		contentPane.add(btnNewCarro);
		
		JButton btnNewCaminhao = new JButton("");
		btnNewCaminhao.setBorder(null);
		btnNewCaminhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caminhao telaCaminhao = new Caminhao();
				telaCaminhao.setVisible(true);
			}
		});
		btnNewCaminhao.setContentAreaFilled(false);
		btnNewCaminhao.setBounds(201, 227, 182, 36);
		contentPane.add(btnNewCaminhao);
		
		JButton btnNewOnibus = new JButton("");
		btnNewOnibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Onibus telaBus = new Onibus();
				telaBus.setVisible(true);
			}
		});
		btnNewOnibus.setBorder(null);
		btnNewOnibus.setContentAreaFilled(false);
		btnNewOnibus.setBounds(202, 298, 181, 40);
		contentPane.add(btnNewOnibus);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 522, 500);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Lucas.LUSCA\\Downloads\\Colorful Clean Frame Sign Up Instagram Post.png"));
		contentPane.add(lblNewLabel);
	}
}

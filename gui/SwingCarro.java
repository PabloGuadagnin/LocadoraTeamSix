package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cadastramentos.CadVeiculos;
import construtores.Carro;
import construtores.Veiculo;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SwingCarro extends JFrame {

	private JPanel contentPane;
	private JTextField textPlacaCarro;
	private JTextField textDiariaCarro;
	private JTextField textKmPorL;
	private JTextField textNpassageiros;
	private JTextField textNPortas;

	private CadVeiculos listCadVeiculos;
	private ObservableList<Veiculo> listaObsVeiculos;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SwingCarro() {

		listCadVeiculos = MenuInicial.getListaVeiculos();
		listaObsVeiculos = MenuInicial.getObsListaVeiculos();

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

		// Botão cadastro carro
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textPlacaCarro.getText().equals("") ||
						textAnoCarro.getText().equals("") ||
						textDiariaCarro.getText().equals("") ||
						textKmPorL.getText().equals("") ||
						textNPortas.getText().equals("") ||
						textNpassageiros.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Todos os campos são obrigatórios.");
				} else {
					boolean a = false;
					if (chckbxNewCheckBox.isSelected()) {
						a = true;
					} else {
						a = false;
					}

					Carro novoCarro = new Carro(Integer.parseInt(textNpassageiros.getText()),
							Integer.parseInt(textNPortas.getText()),
							Double.parseDouble(textKmPorL.getText()),
							a,
							textPlacaCarro.getText(),
							Integer.parseInt(textAnoCarro.getText()),
							Integer.parseInt(textDiariaCarro.getText()));

					listCadVeiculos.add(novoCarro);
					listaObsVeiculos.add(novoCarro);

					System.out.println(novoCarro.toString());

				}

				setVisible(false);
			}

		});
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(174, 356, 187, 43);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"imgSwing\\SwingCarro.png"));
		lblNewLabel.setBounds(0, 0, 524, 501);
		contentPane.add(lblNewLabel);

	}
}
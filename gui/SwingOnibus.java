package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cadastramentos.CadVeiculos;
import construtores.Onibus;
import construtores.Veiculo;
import javafx.collections.ObservableList;

public class SwingOnibus extends JFrame {

	private JPanel contentPane;
	private JTextField textPlacaBus;
	private JTextField textAnoBus;
	private JTextField textDiariaBus;
	private JTextField textNPassageirosBus;
	private JTextField textWifiBus;
	private JComboBox comboBox;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewOnibusCad;
	private CadVeiculos listCadVeiculos;
	private ObservableList<Veiculo> listaObsVeiculos;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public SwingOnibus() {
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
		
		JComboBox <String> comboBoxWifi = new JComboBox();
		comboBoxWifi.setBounds(139, 257, 97, 22);
		contentPane.add(comboBoxWifi);
		comboBoxWifi.addItem("Sim");
		comboBoxWifi.addItem("Não");
		
		JComboBox  <String> comboBox = new JComboBox();
		comboBox.setBounds(357, 156, 72, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Leito");
		comboBox.addItem("Semi-Leito");
		comboBox.addItem("Executivo");
		
		chckbxNewCheckBox = new JCheckBox("Possui");
		chckbxNewCheckBox.setBounds(347, 128, 82, 23);
		contentPane.add(chckbxNewCheckBox);
		
		btnNewOnibusCad = new JButton("");
		btnNewOnibusCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean wifi = true;
				boolean a = true;
				if(textPlacaBus.getText().equals("") || 
				textAnoBus.getText().equals("") ||
				textDiariaBus.getText().equals("") ||
				textNPassageirosBus.getText().equals("")){
					JOptionPane.showMessageDialog(null,
							"Todos os campos são obrigatórios.");
							
				}else{
					 if(chckbxNewCheckBox.isSelected()){ a = true;}
					else{ a = false;}}

					if(comboBoxWifi.getSelectedItem().equals("Sim")){
						 wifi = true;
					}else{ wifi = false;}


					Onibus novOnibus = new Onibus(Integer.parseInt(textNPassageirosBus.getText()),
					 comboBox.getSelectedItem()+"",
					  wifi,
					   a,
					    textPlacaBus.getText(),
						 0,
						 Integer.parseInt(textDiariaBus.getText()));

					listCadVeiculos.add(novOnibus);
					listaObsVeiculos.add(novOnibus);

					System.out.println(novOnibus.toString());




				setVisible(false);
			}
		});
		btnNewOnibusCad.setBorder(null);
		btnNewOnibusCad.setContentAreaFilled(false);
		btnNewOnibusCad.setBounds(179, 357, 183, 37);
		contentPane.add(btnNewOnibusCad);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imgSwing\\SwingOnibus.png"));
		lblNewLabel.setBounds(0, 0, 523, 500);
		contentPane.add(lblNewLabel);
	}
}

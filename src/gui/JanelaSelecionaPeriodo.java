package gui;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import cadastro.CadClientes;
import cadastro.CadLocacoes;
import cadastro.CadVeiculo;
import exceptions.DataInvalidaException;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

/**
 * Janela de pesquisa de período para emissão de relatórios.
 */
public class JanelaSelecionaPeriodo extends JFrame implements ActionListener{

	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	
	private JFormattedTextField txtDataInicial;
	private JFormattedTextField txtDataFinal;
	
	private JButton btnPesquisar;
	private JButton btnLimpar;
	private JButton btnCancelar;
	
	private CadClientes cadCliente;
	private CadVeiculo cadVeiculo;
	private CadLocacoes cadLocacoes;
	private String tipoRelatorio;
	private String cpf;
	private String placa;
	private String dataInicial;
	private String dataFinal;
	
	public JanelaSelecionaPeriodo(CadClientes cadCliente, CadVeiculo cadVeiculo, CadLocacoes cadLocacoes, String tipoRelatorio, String dataInicial,String dataFinal) {
		this.cadCliente = cadCliente;
		this.cadVeiculo = cadVeiculo;
		this.cadLocacoes = cadLocacoes;
		initializar();
	}

	private void initializar() {
		setTitle("Digite um período:");
		setBounds(100, 100, 332, 171);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lblDataInicial = new JLabel("Data inicial:");
		lblDataInicial.setBounds(27, 30, 81, 14);
		getContentPane().add(lblDataInicial);
		
		lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setBounds(27, 55, 68, 14);
		getContentPane().add(lblDataFinal);
		
		txtDataInicial = new JFormattedTextField();
		txtDataInicial.setBounds(118, 28, 88, 17);
		getContentPane().add(txtDataInicial);
		
		txtDataFinal = new JFormattedTextField();
		txtDataFinal.setBounds(118, 53, 88, 17);
		getContentPane().add(txtDataFinal);
		
		FormatarTextos formatar = new FormatarTextos();
		formatar.formatarData(txtDataInicial);
		formatar.formatarData(txtDataFinal);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(19, 98, 89, 23);
		getContentPane().add(btnPesquisar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(118, 98, 89, 23);
		getContentPane().add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(217, 98, 89, 23);
		getContentPane().add(btnCancelar);
		
		btnPesquisar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource() == this.btnLimpar) { 
			limparCampos();
		}
		
		if(ev.getSource() == this.btnCancelar) {
			limparCampos();
			setVisible(false);
		}
		
		if (ev.getSource() == this.btnPesquisar) {
			
			try {
				if(cadLocacoes.validarData(txtDataInicial.getText()) && cadLocacoes.validarData(txtDataFinal.getText()) 
						&& cadLocacoes.comparaDataInicialComDataFinal(txtDataInicial.getText(), txtDataFinal.getText())){
					tipoRelatorio = "LocacoesPeriodo";
					dataInicial = txtDataInicial.getText();
					dataFinal = txtDataFinal.getText();
					abrirJanelaRelatorio();
				}
			} catch ( ParseException | DataInvalidaException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	public void limparCampos() {
		txtDataInicial.setText("");
		txtDataFinal.setText("");
	}
	
	public void abrirJanelaRelatorio(){
		JanelaRelatorio janelaRelatorio = new JanelaRelatorio(cadCliente, cadVeiculo, cadLocacoes, 
				tipoRelatorio, cpf, placa, dataInicial, dataFinal);
		janelaRelatorio.setVisible(true);
	}
}

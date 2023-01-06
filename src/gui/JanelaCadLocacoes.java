package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import cadastro.CadClientes;
import cadastro.CadLocacoes;
import cadastro.CadVeiculo;
import construtores.Cliente;
import construtores.Locacao;
import construtores.Veiculo;
import excepitions.ClienteInexistenteException;
import excepitions.DataInvalidaException;
import excepitions.VeiculoIndisponivelException;
import excepitions.VeiculoInexistenteException;

public class JanelaCadLocacoes extends JFrame implements ActionListener {
	
	private JPanel pnlRodape;
	private JPanel pnlFormulario;
	private JPanel pnlCabecalho;
	private JPanel pnlEsquerda;
	private JPanel pnlDireita;
	
	private JButton btnSalvar;
	private JButton btnLimparCampos;
	private JButton btnCancelar;
	
	// Cliente
	private JLabel lblCpfCLiente;
	private JFormattedTextField txtCpfCLiente;
	
	// Veículo
	private JLabel lclPlacaVeiculo;
	private JFormattedTextField txtPlacaVeiculo;
	
	// Seguro
	private JLabel lblSeguro;
	private JCheckBox ckbSeguro;
	
	// Data Inicial
	private JLabel lblDataIncial;
	private JFormattedTextField txtDataInicial;
	
	// Data Final
	private JLabel lblDataFinal;
	private JFormattedTextField txtDataFinal;
	
	private CadClientes cadCliente;
	private CadVeiculo cadVeiculo;
	private CadLocacoes cadLocacoes;
	
	public JanelaCadLocacoes(CadClientes cadCliente,CadVeiculo cadVeiculo, CadLocacoes cadLocacoes) {
		this.cadCliente = cadCliente;
		this.cadVeiculo = cadVeiculo;
		this.cadLocacoes = cadLocacoes;
		this.inicializar(); 
	}
	
	private void inicializar() {
		setTitle("Cadastrar Locação");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		
		getContentPane().add(getCabecalho(), BorderLayout.PAGE_START);
		getContentPane().add(getPnlEsquerda(), BorderLayout.EAST);
		getContentPane().add(getPnlDireita(), BorderLayout.WEST);
		getContentPane().add(getFormulario(), BorderLayout.CENTER);
		getContentPane().add(getRodape(), BorderLayout.PAGE_END);
		
		pack(); // Calcula o tamanho da tela
	}	
	
	public JPanel getFormulario() {
		if(pnlFormulario == null) {
			pnlFormulario = new JPanel(new GridLayout(5,2));
			FormatarTextos formatar = new FormatarTextos();
			
			lblCpfCLiente = new JLabel ("CPF do Cliente: ");
			txtCpfCLiente = new JFormattedTextField();
			formatar.formatarTextCpf(txtCpfCLiente);
			
			lclPlacaVeiculo= new JLabel ("Placa do Veículo: ");
			txtPlacaVeiculo = new JFormattedTextField();
			formatar.formatarPlaca(txtPlacaVeiculo);
			
			lblSeguro = new JLabel ("Contratar :");
			ckbSeguro = new JCheckBox("Seguro");
			
			lblDataIncial = new JLabel("Data Inicial: ");
			txtDataInicial = new JFormattedTextField();
			formatar.formatarData(txtDataInicial);
			
			lblDataFinal = new JLabel("Data Final: ");
			txtDataFinal = new JFormattedTextField();
			formatar.formatarData(txtDataFinal);
			
			pnlFormulario.add(lblCpfCLiente);
			pnlFormulario.add(txtCpfCLiente);
			
			pnlFormulario.add(lclPlacaVeiculo);
			pnlFormulario.add(txtPlacaVeiculo);
			
			pnlFormulario.add(lblSeguro);
			pnlFormulario.add(ckbSeguro);
			
			pnlFormulario.add(lblDataIncial);
			pnlFormulario.add(txtDataInicial);
			
			pnlFormulario.add(lblDataFinal);
			pnlFormulario.add(txtDataFinal);
		}
		
		return pnlFormulario;
		
	}
	
	
	public JPanel getRodape() {
		if(pnlRodape == null) {
			
			 pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
			 
			 btnSalvar = new JButton("Salvar");
			 btnLimparCampos = new JButton("Limpar Campos");
			 btnCancelar = new JButton("Cancelar");
			 
			 btnSalvar.addActionListener(this);
			 btnLimparCampos.addActionListener(this);
			 btnCancelar.addActionListener(this);
			 
			 pnlRodape.add(btnSalvar);
			 pnlRodape.add(btnLimparCampos);
			 pnlRodape.add(btnCancelar);	 
			 
		}
		
		return pnlRodape;
	}
	
	private JPanel getCabecalho() {
		if(pnlCabecalho == null) {
			pnlCabecalho = new JPanel();
		}
		return pnlCabecalho;
	}
	
	private JPanel getPnlEsquerda() {
		if(pnlEsquerda == null) {
			pnlEsquerda = new JPanel();
		}
		return pnlEsquerda;
	}
	
	private JPanel getPnlDireita() {
		if(pnlDireita == null) {
			pnlDireita = new JPanel();
		}
		return pnlDireita;
	}
	
	public void actionPerformed (ActionEvent ev) {
		if(ev.getSource() == this.btnSalvar) {
			
			try {
				if (cadCliente.existe(txtCpfCLiente.getText()) && cadVeiculo.existe(txtPlacaVeiculo.getText()) 
						&& cadLocacoes.validarData(txtDataInicial.getText()) && cadLocacoes.validarData(txtDataFinal.getText()) 
						&& cadLocacoes.compararData(txtDataInicial.getText(), txtDataFinal.getText()) 
						&& cadLocacoes.verificarDisponibilidadeVeiculo(txtPlacaVeiculo.getText(), txtDataInicial.getText(), txtDataFinal.getText())) {
					
					Cliente cliente = cadCliente.get(txtCpfCLiente.getText());
					Veiculo veiculo = cadVeiculo.get(txtPlacaVeiculo.getText());
					Locacao locacao = new Locacao(cliente, veiculo, ckbSeguro.isSelected(),
							txtDataInicial.getText(),txtDataFinal.getText());
					cadLocacoes.add(locacao);
					JOptionPane.showMessageDialog(null, "Locação código: " + locacao.getCodigoLocacao() + " registrada.");
					System.out.println(cadLocacoes.getInfo());
					
					limparCampos();
					setVisible(false);
				}
			} catch (VeiculoInexistenteException | ClienteInexistenteException | ParseException 
					| DataInvalidaException | VeiculoIndisponivelException e) {
				JOptionPane.showMessageDialog(null, e);
				limparCampos();
			}
		}
		
		if(ev.getSource() == this.btnLimparCampos) {
			limparCampos();
		}
		if(ev.getSource() == this.btnCancelar) {
			limparCampos();
			setVisible(false);
		}
		
	}
	
	public void limparCampos() {
		txtCpfCLiente.setText("");
		txtPlacaVeiculo.setText("");
		ckbSeguro.setSelected(false);;
		txtDataInicial.setText(""); 
		txtDataFinal.setText("");	
	}
	
}

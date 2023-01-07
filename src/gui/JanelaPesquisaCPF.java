package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cadastro.CadClientes;
import cadastro.CadLocacoes;
import cadastro.CadVeiculo;
import exceptions.ClienteInexistenteException;

public class JanelaPesquisaCPF extends JFrame implements ActionListener{
	private JPanel pnlCabecalho;
	private JPanel pnlEsquerda;
	private JPanel pnlDireita;
	private JPanel formularioCpf;
	private JPanel rodapeCpf;
	
	private JLabel lblVerificaCpf;
	private JFormattedTextField txtVerificaCpf;
	
	private JButton btnPesquisa;
	private JButton btnLimpar;
	private JButton btnCancelarVerificacao;
		
	private FormatarTextos formatar = new FormatarTextos();
	private CadClientes cadClientes;
	private CadLocacoes cadLocacoes;
	private CadVeiculo cadVeiculo;

	private String cpf;
	private String placa;
	private String tipoRelatorio;
	private String dataInicial;
	private String dataFinal;
	
	public JanelaPesquisaCPF(CadClientes cadClientes, CadVeiculo cadVeiculo, CadLocacoes cadLocacoes, String tipoRelatorio, String cpf) {	
		this.cadClientes = cadClientes;
		this.cadLocacoes = cadLocacoes;	
		this.cadVeiculo = cadVeiculo;
		this.tipoRelatorio = tipoRelatorio;
		this.cpf = cpf;
		
		this.inicializar();
	}

	private void inicializar() {
		setTitle("Digite o CPF do Cliente: ");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		getContentPane().add(getCabecalho(), BorderLayout.PAGE_START);
		getContentPane().add(getPnlEsquerda(), BorderLayout.EAST);
		getContentPane().add(getPnlDireita(), BorderLayout.WEST);
		getContentPane().add(getCabecalho(), BorderLayout.PAGE_START);
		getContentPane().add(getFormularioCpf(), BorderLayout.CENTER);
		getContentPane().add(getRodapeCpf(), BorderLayout.PAGE_END);
		
		pack();		
	}
	
	public JPanel getFormularioCpf() {
		formularioCpf = new JPanel(new GridLayout(1, 2));
		
		lblVerificaCpf = new JLabel("CPF :");
		txtVerificaCpf = new JFormattedTextField();
		formatar.formatarTextCpf(txtVerificaCpf);
		
		formularioCpf.add(lblVerificaCpf);
		formularioCpf.add(txtVerificaCpf);
		
		return formularioCpf;
	}
	
	public JPanel getRodapeCpf() {
		rodapeCpf = new JPanel();
		
		btnPesquisa = new JButton("Pesquisar");
		btnLimpar = new JButton("Limpar");
		btnCancelarVerificacao = new JButton("Cancelar");
		
		btnPesquisa.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnCancelarVerificacao.addActionListener(this);
		
		rodapeCpf.add(btnPesquisa);
		rodapeCpf.add(btnLimpar);
		rodapeCpf.add(btnCancelarVerificacao);
		return rodapeCpf;
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
	
	public String getCpfVerificado() {
		return txtVerificaCpf.getText();
	}

	
	public void actionPerformed (ActionEvent ev) { 
		
		if(ev.getSource() == this.btnPesquisa) {
			try {
				if (cadClientes.existe(txtVerificaCpf.getText())) {
					cpf = txtVerificaCpf.getText();
					abrirJanelaRelatorio();
					this.setVisible(false);
				}
					
				
			} catch (ClienteInexistenteException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		
		}
		
		if(ev.getSource() == this.btnLimpar) {
			limparCampos();
		}
		
		if(ev.getSource() == this.btnCancelarVerificacao) {
			limparCampos();
			setVisible(false);
		}
	}
	
	public void limparCampos() {
		txtVerificaCpf.setText("");
	}
	
	public void abrirJanelaRelatorio(){
		JanelaRelatorio janelaRelatorio = new JanelaRelatorio(cadClientes, cadVeiculo, cadLocacoes, 
				tipoRelatorio, cpf, placa, dataInicial, dataFinal);
		janelaRelatorio.setVisible(true);
	}
}

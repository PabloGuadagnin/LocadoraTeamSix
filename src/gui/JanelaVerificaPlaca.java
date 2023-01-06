package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cadastro.CadClientes;
import cadastro.CadVeiculo;
import excepitions.PlacaInvalidaException;
import excepitions.VeiculoInexistenteException;

public class JanelaVerificaPlaca extends JFrame implements ActionListener {
	private JPanel pnlCabecalho;
	private JPanel pnlEsquerda;
	private JPanel pnlDireita;
	private JPanel formularioPlaca;
	private JPanel rodapePlaca;
	
	private JLabel lblVerificaPlaca;
	private JButton btnLimpar;
	private JFormattedTextField txtVerificaPlaca;
	
	private JButton btnVerificar;
	private JButton btnCancelarVerificacao;
		
	private FormatarTextos formatar = new FormatarTextos();
	private CadVeiculo cadVeiculo;
	private String tipoInteracao;
	
	public JanelaVerificaPlaca(CadVeiculo cadVeiculo, String tipoInteracao) {	
		this.tipoInteracao = tipoInteracao;
		this.cadVeiculo = cadVeiculo;
		this.inicializar();
	}

	private void inicializar() {
		setTitle("Digite a Plca do Veículo: ");
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
		formularioPlaca = new JPanel(new GridLayout(1, 2));
		
		lblVerificaPlaca = new JLabel("Placa :");
		txtVerificaPlaca = new JFormattedTextField();
		formatar.formatarPlaca(txtVerificaPlaca);
		
		formularioPlaca.add(lblVerificaPlaca);
		formularioPlaca.add(txtVerificaPlaca);
		
		return formularioPlaca;
	}
	
	public JPanel getRodapeCpf() {
		rodapePlaca = new JPanel();
		
		btnVerificar = new JButton("Verificar");
		btnLimpar = new JButton("Limpar");
		btnCancelarVerificacao = new JButton("Cancelar");

		btnVerificar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnCancelarVerificacao.addActionListener(this);
		
		rodapePlaca.add(btnVerificar);
		rodapePlaca.add(btnLimpar);
		rodapePlaca.add(btnCancelarVerificacao);
		return rodapePlaca;
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

		if(ev.getSource() == this.btnVerificar) {
			
			try {
				
				campoPlacaCorreto(txtVerificaPlaca.getText());
				
				try {
					if (cadVeiculo.existe(txtVerificaPlaca.getText())) 
						JOptionPane.showMessageDialog(null, "Veículo já cadastrado.");
					

				} catch (VeiculoInexistenteException e) {
					switch (tipoInteracao) {
					
					case "Carro":
						this.setVisible(false);
						JanelaCadCarro janelaCadCarro = new JanelaCadCarro(cadVeiculo);
						janelaCadCarro.settxtPlaca(txtVerificaPlaca.getText());
						janelaCadCarro.setVisible(true);
						break;
					
					case "Onibus":
						this.setVisible(false);
						JanelaCadOnibus janelaCadOnibus = new JanelaCadOnibus(cadVeiculo);
						janelaCadOnibus.settxtPlaca(txtVerificaPlaca.getText());
						janelaCadOnibus.setVisible(true);
						break;
							
					case "Caminhao":
						this.setVisible(false);
						JanelaCadCaminhao janelaCadCaminhao = new JanelaCadCaminhao(cadVeiculo);
						janelaCadCaminhao.settxtPlaca(txtVerificaPlaca.getText());
						janelaCadCaminhao.setVisible(true);
						break;
					}
				}
	
			} catch (PlacaInvalidaException e) {
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
		txtVerificaPlaca.setText("");
	}
	
	public boolean campoPlacaCorreto(String placa) throws PlacaInvalidaException {
		if(placa.contains(" ")) {
			throw new PlacaInvalidaException();
		}
		return true;
	}
}

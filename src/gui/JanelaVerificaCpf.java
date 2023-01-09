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
import cadastro.ValidaCPF;
import exceptions.ClienteInexistenteException;
import exceptions.CpfInvalidoException;

/**
 * Janela de verificação e validação de cpf para cadastro de novos clientes.
 */
public class JanelaVerificaCpf extends JFrame implements ActionListener{
	
	private JPanel pnlCabecalho;
	private JPanel pnlEsquerda;
	private JPanel pnlDireita;
	private JPanel formularioCpf;
	private JPanel rodapeCpf;
	
	private JLabel lblVerificaCpf;
	private JFormattedTextField txtVerificaCpf;
	
	private JButton btnVerificar;
	private JButton btnLimpar;
	private JButton btnCancelarVerificacao;
		
	private FormatarTextos formatar = new FormatarTextos();
	private CadClientes cadClientes;
	private ValidaCPF validaCPF;
	
	public JanelaVerificaCpf(CadClientes cadClientes) {	
		this.cadClientes = cadClientes;
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
		
		btnVerificar = new JButton("Verificar");
		btnLimpar = new JButton("Limpar");
		btnCancelarVerificacao = new JButton("Cancelar");
		
		btnVerificar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnCancelarVerificacao.addActionListener(this);
		
		rodapeCpf.add(btnVerificar);
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

		if(ev.getSource() == this.btnVerificar) {			
					
			try {
				if (cadClientes.existe(txtVerificaCpf.getText()))
					JOptionPane.showMessageDialog(null, "Cliente já cadastrado.");
				
			} catch (ClienteInexistenteException e) {

				validaCPF = new ValidaCPF();
				
				try {
					if (validaCPF.isCPF(txtVerificaCpf.getText())) {
						this.setVisible(false);
						JanelaCadClientes janelaCadClientes = new JanelaCadClientes(cadClientes);	
						janelaCadClientes.setVisible(true);
						janelaCadClientes.setTxtCpf(txtVerificaCpf.getText());
					}
				} catch (CpfInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
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
	
}

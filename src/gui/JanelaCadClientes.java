package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import construtores.Cliente;
import excepitions.CampoObrigatorioException;
import excepitions.CnhInvalidaException;
import excepitions.NomeInvalidoException;

public class JanelaCadClientes extends JFrame implements ActionListener{
	
	private JPanel pnlRodape;
	private JPanel pnlFormulario;
	private JPanel pnlCabecalho;
	private JPanel pnlEsquerda;
	private JPanel pnlDireita;

	private JButton btnSalvar;
	private JButton btnLimparCampos;
	private JButton btnCancelar;
	
	// Cliente
	private JLabel lblNome;
	private JFormattedTextField txtNome;
	
	private JLabel lblCpf;
	private JFormattedTextField txtCpf;
	
	private JLabel lblCnh;
	private JFormattedTextField txtCnh;
	
	private JLabel lblTelefone;
	private JFormattedTextField txtTelefone;
	
	private JLabel lblRua;
	private JFormattedTextField txtRua;
	
	private JLabel lblNumero;
	private JFormattedTextField txtNumero;
	
	private JLabel lblComplemento;
	private JFormattedTextField txtComplemento;
	
	private JLabel lblBairro;
	private JFormattedTextField txtBairro;
	
	private JLabel lblCidade;
	private JFormattedTextField txtCidade;
	
	private JLabel lblCep;
	private JFormattedTextField txtCep;
	
	private CadClientes cadClientes;
	private FormatarTextos formatar = new FormatarTextos();
	 
	public JanelaCadClientes(CadClientes cadClientes) {
		this.cadClientes = cadClientes;
		this.inicializar();
	}
	
	private void inicializar() {
		setTitle("Cadastrar Cliente");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		getContentPane().add(getCabecalho(), BorderLayout.PAGE_START);
		getContentPane().add(getPnlEsquerda(), BorderLayout.EAST);
		getContentPane().add(getPnlDireita(), BorderLayout.WEST);
		getContentPane().add(getCabecalho(), BorderLayout.PAGE_START);
		getContentPane().add(getFormulario(), BorderLayout.CENTER);
		getContentPane().add(getRodape(), BorderLayout.PAGE_END);
		
		pack(); // Calcula o tamanho da tela
	}	
	
	public JPanel getFormulario() {
		if(pnlFormulario == null) {
			pnlFormulario = new JPanel(new GridLayout(20, 2));
		
			lblCpf = new JLabel("CPF :");
			txtCpf = new JFormattedTextField();
			formatar.formatarTextCpf(txtCpf);
			
			lblNome = new JLabel("Nome :");
			txtNome = new JFormattedTextField();
				
			lblCnh = new JLabel("CNH :");
			txtCnh = new JFormattedTextField();
			formatar.formatarTextCnh(txtCnh);
			
			lblTelefone = new JLabel("Telefone :");
			txtTelefone = new JFormattedTextField();
			formatar.formatarTextTelefone(txtTelefone);
			
			lblRua = new JLabel("Rua: ");
			txtRua = new JFormattedTextField();
			
			lblNumero = new JLabel("Numero: ");
			txtNumero = new JFormattedTextField();
			
			lblComplemento = new JLabel("Complemento: ");
			txtComplemento = new JFormattedTextField();
			
			lblBairro = new JLabel("Bairro: ");
			txtBairro = new JFormattedTextField();
			
			lblCidade = new JLabel("Cidade: ");
			txtCidade = new JFormattedTextField();
			
			lblCep = new JLabel("CEP:");
			txtCep = new JFormattedTextField();
			formatar.formatarTextCep(txtCep);
			
			pnlFormulario.add(lblCpf);
			pnlFormulario.add(txtCpf);
			
			pnlFormulario.add(lblNome);
			pnlFormulario.add(txtNome);
		
			pnlFormulario.add(lblCnh);
			pnlFormulario.add(txtCnh);
			
			pnlFormulario.add(lblTelefone);
			pnlFormulario.add(txtTelefone);
			
			pnlFormulario.add(lblRua);
			pnlFormulario.add(txtRua);
			
			pnlFormulario.add(lblNumero);
			pnlFormulario.add(txtNumero);
			
			pnlFormulario.add(lblComplemento);
			pnlFormulario.add(txtComplemento);
			
			pnlFormulario.add(lblBairro);
			pnlFormulario.add(txtBairro);
			
			pnlFormulario.add(lblCidade);
			pnlFormulario.add(txtCidade);
			
			pnlFormulario.add(lblCep);
			pnlFormulario.add(txtCep);
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
	
	public void actionPerformed (ActionEvent ev) {
		if(ev.getSource() == this.btnSalvar) {
			try {
				if(verificarCamposObrigatorios(txtNome.getText(),txtCnh.getText())) {
					Cliente cliente = new Cliente (txtNome.getText(), txtCpf.getText(), txtCnh.getText(),
							txtTelefone.getText(), txtRua.getText(), txtNumero.getText(),txtComplemento.getText(),
							txtBairro.getText(),txtCidade.getText(),txtCep.getText());
					cadClientes.add(cliente);
					JOptionPane.showMessageDialog(null,"Cliente cadastrado." + "\n" +  cliente.confirmacaoDados());
					System.out.println(cadClientes.getInfo());
					limparCampos();
					limparAoFechar();
					setVisible(false);	
				}
			} catch (CampoObrigatorioException | CnhInvalidaException | NomeInvalidoException e) {
				JOptionPane.showMessageDialog(null, e);
			}
			

		}
		if(ev.getSource() == this.btnLimparCampos) {
			limparCampos();
		}
		if(ev.getSource() == this.btnCancelar) {
			limparCampos();
			limparAoFechar();
			setVisible(false);
		}	
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
	
	public void setTxtCpf(String cpf) {
		txtCpf.setText(cpf);
		txtCpf.setEditable(false);
	}
	
	
	public void limparCampos() {
		txtNome.setText("");
		txtCnh.setText("");
		txtTelefone.setText(""); 
		txtRua.setText("");
		txtNumero.setText(""); 
		txtComplemento.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtCep.setText("");	
	}
	
	public void limparAoFechar() {
		txtCpf.setText("");
	}
	
	public boolean verificarCamposObrigatorios(String nome, String cnh) throws CampoObrigatorioException, CnhInvalidaException, NomeInvalidoException {
		if (nome.isBlank() || cnh.isBlank()) {
			throw new CampoObrigatorioException();
		}
		
		if (cnh.contains(" ")) {
			throw new CnhInvalidaException();
		}
		
		if (!nome.matches("[a-zA-Z\s]+")) {
			throw new NomeInvalidoException();
		}
			
		return true;
	}
}

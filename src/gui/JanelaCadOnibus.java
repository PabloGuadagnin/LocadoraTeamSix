package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import cadastro.CadVeiculo;
import construtores.Onibus;
import exceptions.AnoInvalidoException;
import exceptions.ValorDiariaException;

public class JanelaCadOnibus extends JFrame implements ActionListener{

	private JPanel pnlRodape;
	private JPanel pnlFormulario;
	private JPanel pnlCabecalho;
	private JPanel pnlEsquerda;
	private JPanel pnlDireita;
	
	private JButton btnSalvar;
	private JButton btnLimparCampos;
	private JButton btnCancelar;
	
	private JLabel lblPlaca;
	private JFormattedTextField txtPlaca;
	
	private JLabel lblAno;
	private JFormattedTextField txtAno;
	
	private JLabel lvlValorDiaria;
	private JFormattedTextField txtValorDiaria;
	
	private JLabel lblPassageiros;
	private JFormattedTextField txtPassageiros;
	
	private JLabel lblCategoria;
	private JFormattedTextField txtCategoria;
	
	private JLabel lblInternet;
	private JCheckBox ckbInternet;
	
	private JLabel lblArCondicionado;
	private JCheckBox ckbArCondicionado;
	
	private CadVeiculo cadVeiculo;
	
	
	public JanelaCadOnibus(CadVeiculo cadVeiculo) {
		this.cadVeiculo = cadVeiculo;
		this.inicializar();
	}
	private void inicializar() {
		setTitle("Cadastrar Onibus");
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
			pnlFormulario = new JPanel(new GridLayout(7,2));
			FormatarTextos formatar = new FormatarTextos();
			
			lblPlaca = new JLabel("Placa:");
			txtPlaca = new JFormattedTextField();
			formatar.formatarPlaca(txtPlaca);
			
			lblAno = new JLabel("Ano:");
			txtAno = new JFormattedTextField();
			formatar.formatarTextAno(txtAno);
			
			lvlValorDiaria = new JLabel("Valor da Diária:");
			txtValorDiaria = new JFormattedTextField();
			
			lblPassageiros = new JLabel("Nr. de Passageiros:");
			txtPassageiros = new JFormattedTextField();
			
			lblCategoria = new JLabel("Categoria:");
			txtCategoria = new JFormattedTextField();
			
			lblInternet = new JLabel("Internet:");
			ckbInternet= new JCheckBox("Possui");
			
			lblArCondicionado = new JLabel("Ar Condicionado:");
			ckbArCondicionado = new JCheckBox("Possui");
			
			pnlFormulario.add(lblPlaca);
			pnlFormulario.add(txtPlaca);
			
			pnlFormulario.add(lblAno);
			pnlFormulario.add(txtAno);
			
			pnlFormulario.add(lvlValorDiaria);
			pnlFormulario.add(txtValorDiaria);
			
			pnlFormulario.add(lblPassageiros);
			pnlFormulario.add(txtPassageiros);
			
			pnlFormulario.add(lblCategoria);
			pnlFormulario.add(txtCategoria);
			
			pnlFormulario.add(lblInternet);
			pnlFormulario.add(ckbInternet);
			
			pnlFormulario.add(lblArCondicionado);
			pnlFormulario.add(ckbArCondicionado);
			
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
				cadVeiculo.verificaAno(txtAno.getText());
				cadVeiculo.verificaValorDiaria(txtValorDiaria.getText());
				
				Onibus onibus = new Onibus(txtPlaca.getText(),txtAno.getText(),
						txtValorDiaria.getText(),txtPassageiros.getText(),txtCategoria.getText(),
						ckbInternet.isSelected(), ckbArCondicionado.isSelected());
				cadVeiculo.add(onibus);
				System.out.println(cadVeiculo.getInfo());
				limparCampos();
				setVisible(false);
				
			} catch (ValorDiariaException | AnoInvalidoException e) {
				JOptionPane.showMessageDialog(null, e);
				
			}

		}
		if(ev.getSource() == this.btnLimparCampos) {
			limparCampos();
		}
		if(ev.getSource() == this.btnCancelar) {
			limparCampos();
		}
		
	}
	
	public void limparCampos() {
		txtPlaca.setText("");
		txtAno.setText("");
		txtValorDiaria.setText("");
		txtPassageiros.setText("");
		txtCategoria.setText("");
		ckbInternet.setSelected(false);
		ckbArCondicionado.setSelected(false);
	}
	
	public void settxtPlaca(String placa) {
		txtPlaca.setText(placa);
		txtPlaca.setEditable(false);
	}
}

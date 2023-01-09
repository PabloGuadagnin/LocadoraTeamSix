package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import cadastro.CadVeiculo;
import construtores.Carro;
import exceptions.AnoInvalidoException;
import exceptions.ValorDiariaException;

/**
 * Janela de cadastro de veiculo do tipo Carro.
 */
public class JanelaCadCarro extends JFrame implements ActionListener {
	
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
	
	private JRadioButton duasPortas;
	private JRadioButton quatroPortas;
	private ButtonGroup nrPortas;
	
	private JLabel lblKmPorLitro;
	private JFormattedTextField txtKmPorLitro;
	
	private JLabel lblArCondicionado;
	private JCheckBox ckbArCondicionado;
	
	private CadVeiculo cadVeiculo;
	
	private FormatarTextos formatar = new FormatarTextos();
	
	public JanelaCadCarro(CadVeiculo cadVeiculo) {
		this.cadVeiculo = cadVeiculo;
		this.inicializar();
	}
	private void inicializar() {
		setTitle("Cadastrar Carro");
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
			
			nrPortas = new ButtonGroup();
			nrPortas.add(duasPortas = new JRadioButton("Duas Portas"));
			nrPortas.add(quatroPortas = new JRadioButton("Quatro Portas"));
			
			lblKmPorLitro = new JLabel("Km por Litros:");
			txtKmPorLitro = new JFormattedTextField();
			
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
			
			pnlFormulario.add(duasPortas);
			pnlFormulario.add(quatroPortas);
			
			pnlFormulario.add(lblKmPorLitro);
			pnlFormulario.add(txtKmPorLitro);
			
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
				
				Carro carro = new Carro (txtPlaca.getText(),txtAno.getText(),
						txtValorDiaria.getText(), txtPassageiros.getText(),
						verificaNrPortas(),txtKmPorLitro.getText(),ckbArCondicionado.isSelected());
				cadVeiculo.add(carro);
				System.out.println(cadVeiculo.getInfo());
				limparCampos();
				limparAoFechar();
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
			limparAoFechar();
			setVisible(false);
		}
		
	}
	
	public void limparCampos() {
		txtAno.setText("");
		txtValorDiaria.setText("");
		txtPassageiros.setText("");
		duasPortas.setSelected(false);
		quatroPortas.setSelected(false);
		txtKmPorLitro.setText("");
		ckbArCondicionado.setSelected(false);;	
	}

	public void limparAoFechar() {
		txtPlaca.setText("");
	}
	
	public void settxtPlaca(String placa) {
		txtPlaca.setText(placa);
		txtPlaca.setEditable(false);
	}
	
	public int verificaNrPortas() {
		if (quatroPortas.isSelected()) 
			return 4;
		return 2;
	}
}

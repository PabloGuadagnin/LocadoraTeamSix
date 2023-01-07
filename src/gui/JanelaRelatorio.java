package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cadastro.CadClientes;
import cadastro.CadLocacoes;
import cadastro.CadVeiculo;
import exceptions.SemLocacoesNoPeriodoException;
import exceptions.SemLocacoesParaClienteException;
import exceptions.SemLocacoesParaVeiculoException;


public class JanelaRelatorio extends JFrame implements ActionListener{
	
	private TextArea areaDeTexto;
	private JPanel pnlRodape;
	
	private CadClientes cadClientes;
	private CadVeiculo cadVeiculo;
	private CadLocacoes cadLocacoes;
	private String tipoRelatorio;
	private String cpf;
	private String placa;
	private String dataInicial;
	private String dataFinal;
	
	private JButton btnFechar;
	
	public JanelaRelatorio(CadClientes cadClientes, CadVeiculo cadVeiculo, CadLocacoes cadLocacoes, 
			String tipoRelatorio, String cpf, String placa, String dataInicial,String dataFinal) {
		this.cadClientes = cadClientes;
		this.cadVeiculo = cadVeiculo;
		this.cadLocacoes = cadLocacoes;
		this.tipoRelatorio = tipoRelatorio;
		this.cpf = cpf;
		this.placa = placa;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		inicializar();
	}
	
	public void inicializar() {
		
		setTitle("Relatórios");
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		
		getContentPane().add(getAreaDeTexto(), BorderLayout.CENTER);
		getContentPane().add(getRodape(), BorderLayout.PAGE_END);
		
	}
	
	public TextArea getAreaDeTexto() {
		areaDeTexto = new TextArea();
		areaDeTexto.setEditable(false);
		areaDeTexto.append(setRelatorio());
		
		return areaDeTexto;
	}
	
	public JPanel getRodape() {
		if(pnlRodape == null) {
			
			 pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));
			 btnFechar = new JButton("Fechar");
			 btnFechar.addActionListener(this);
			 pnlRodape.add(btnFechar); 
		}
		
		return pnlRodape;
	}
	public void actionPerformed (ActionEvent ev) {
		areaDeTexto.setText("");
		setVisible(false);
		
	}
	
	private String setRelatorio() {
		String dados = "";
		switch(tipoRelatorio) {
			case "ListarClientes":
				dados = cadClientes.getResumoInfo();
				break;
			case "RelatorioClientes":
				dados = cadClientes.getInfo();
				break;
			case "ListarVeiculos":
				dados = cadVeiculo.getResumoInfo();
				break;
			case "RelatorioVeiculo":
				dados = cadVeiculo.getInfo();
				break;
			case "ListarLocacoes":
				dados = cadLocacoes.getInfo();
				break;
			case "LocacoesClientes":
				try {
					dados = cadLocacoes.filtrarLocacoesCliente(cpf);
					break;
				} catch (SemLocacoesParaClienteException e) {
					JOptionPane.showMessageDialog(null, e);
					dados = "Não há locações para o cliente informado.";
				}

			case "LocacoesVeiculos":
				try {
					dados = cadLocacoes.filtrarLocacoesVeiculo(placa);
				} catch (SemLocacoesParaVeiculoException e) {
					JOptionPane.showMessageDialog(null, e);
					dados = "Não hálocações para o veículo informado";
				}
				break;
			case "LocacoesPeriodo":
				try {
					dados = cadLocacoes.filtrarLocacoesPeriodo(dataInicial, dataFinal);
				} catch (ParseException | SemLocacoesNoPeriodoException  e) {
					JOptionPane.showMessageDialog(null, e);
					dados = "Não há locações para o período informado.";
				}
				break;
		}
		return dados;
	}
}

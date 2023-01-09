package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import cadastro.CadClientes;
import cadastro.CadLocacoes;
import cadastro.CadVeiculo;
import exceptions.ListaClienteVaziaException;
import exceptions.ListaLocacoesVaziaException;
import exceptions.ListaVeiculosVaziaException;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JMenuBar menu;

	private JMenu mnCLientes;
	private JMenuItem itemCadCliente;
	private JMenuItem itemListarClientes;
	private JMenuItem itemRelatorioClientes;
	
	private JMenu mnVeiculos;
	private JMenu mnCadVeiculo;
	private JMenuItem itemCadCarro;
	private JMenuItem itemCadOnibus;
	private JMenuItem itemCadCaminhao;
	private JMenuItem itemListarVeiculos;
	private JMenuItem itemRelatorioVeiculo;

	private JMenu mnLocacoes;
	private JMenuItem itemCadLocacao;
	private JMenuItem itemListarLocacoes;
	
	private JMenu mnRelatorios;
	private JMenuItem itemLocacoesCliente;
	private JMenuItem itemLocacoesVeiculo;
	private JMenuItem itemLocacoesPeriodo;
	
	private JLabel lblCadastros;
	private JLabel lblRelatorios;
	private JLabel lblVeiculos;
	
	private JPanel pnlCadastro;
	private JPanel pnlRelatorio;
	private JPanel pnlVeiculo;
	
	private JButton btnCliente;
	private JButton btnLocacao;
	private JButton btnCarro;
	private JButton btnOnibus;
	private JButton btnCaminhao;
	private JButton btnRelCliente;
	private JButton btnRelVeiculo;
	private JButton btnRelLocacoes;
	private JButton btnLocCliente;
	private JButton btnLocVeiculo;
	private JButton btnLocPeriodo;
		
	private CadClientes cadClientes;
	private CadVeiculo cadVeiculo;
	private CadLocacoes cadLocacoes;
	
	private JMenu mnSair;
	private JMenuItem itemFecharAplicacao;
	
	private String tipoInteracao;
	private String tipoRelatorio;
	private String cpf;
	private String placa;
	private String dataInicial;
	private String dataFinal;
	
	/**
	 * Janela principal. Permite o acesso a todas as funcionalidades atraves dos botões e menu.
	 */
	public Menu() {
		inicializar();
	}

	private void inicializar() {
		
		cadClientes = new CadClientes();
		cadVeiculo = new CadVeiculo();
		cadLocacoes = new CadLocacoes();
		
		setTitle("Locadora Team Six");
		setResizable(false);
		setBounds(100, 100, 600, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getLabels();
		getContentPane().add(getPnlCliente());
		getContentPane().add(getPnlVeiculo());
		getContentPane().add(getPnlRelatorios());
		setJMenuBar(getMenu());
	}
	
	public void getLabels() {
		lblCadastros = new JLabel("Cadastros: ");
		lblCadastros.setForeground(new Color(128, 128, 128));
		lblCadastros.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastros.setBounds(60, 41, 147, 29);
		getContentPane().add(lblCadastros);
		
		lblRelatorios = new JLabel("Relatórios:");
		lblRelatorios.setForeground(new Color(128, 128, 128));
		lblRelatorios.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRelatorios.setBounds(326, 41, 147, 29);
		getContentPane().add(lblRelatorios);
	}

	public JPanel getPnlCliente() {
		pnlCadastro = new JPanel();
		pnlCadastro.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlCadastro.setBounds(60, 81, 212, 135);
		getContentPane().add(pnlCadastro);
		pnlCadastro.setLayout(null);
		
		btnCliente = new JButton("Clientes");
		btnCliente.setBounds(63, 35, 92, 23);
		evBotoes(btnCliente);
		pnlCadastro.add(btnCliente);
		
		btnLocacao = new JButton("Locação");
		btnLocacao.setBounds(63, 70, 92, 23);
		evBotoes(btnLocacao);
		pnlCadastro.add(btnLocacao);
		
		return pnlCadastro;
	}
	
	public JPanel getPnlVeiculo() {
		pnlVeiculo = new JPanel();
		pnlVeiculo.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlVeiculo.setBounds(60, 228, 212, 179);
		getContentPane().add(pnlVeiculo);
		pnlVeiculo.setLayout(null);
		
		lblVeiculos = new JLabel("Cadastrar Veículos");
		lblVeiculos.setForeground(new Color(128, 128, 128));
		lblVeiculos.setBounds(41, 22, 133, 17);
		lblVeiculos.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlVeiculo.add(lblVeiculos);
		
		btnCarro = new JButton("Carro");
		btnCarro.setBounds(61, 64, 89, 23);
		evBotoes(btnCarro);
		pnlVeiculo.add(btnCarro);
		
		btnOnibus = new JButton("Ônibus");
		btnOnibus.setBounds(61, 98, 89, 23);
		evBotoes(btnOnibus);
		pnlVeiculo.add(btnOnibus);
		
		btnCaminhao = new JButton("Caminhão");
		btnCaminhao.setBounds(61, 132, 89, 23);
		evBotoes(btnCaminhao);
		pnlVeiculo.add(btnCaminhao);
		
		return pnlVeiculo;
	}
	
	public JPanel getPnlRelatorios() {
		pnlRelatorio = new JPanel();
		pnlRelatorio.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlRelatorio.setBounds(326, 81, 212, 326);
		getContentPane().add(pnlRelatorio);
		pnlRelatorio.setLayout(null);
		
		btnRelCliente = new JButton("Relatório Clientes");
		btnRelCliente.setBounds(30, 35, 156, 23);
		evBotoes(btnRelCliente);
		pnlRelatorio.add(btnRelCliente);
		
		btnRelVeiculo = new JButton("Relatório Veículos");
		btnRelVeiculo.setBounds(30, 69, 156, 23);
		evBotoes(btnRelVeiculo);
		pnlRelatorio.add(btnRelVeiculo);
		
		btnRelLocacoes = new JButton("Relatório Locações");
		btnRelLocacoes.setBounds(30, 107, 156, 23);
		evBotoes(btnRelLocacoes);
		pnlRelatorio.add(btnRelLocacoes);
		
		btnLocCliente = new JButton("Locações do Cliente");
		btnLocCliente.setBounds(30, 176, 156, 23);
		evBotoes(btnLocCliente);
		pnlRelatorio.add(btnLocCliente);
		
		btnLocVeiculo = new JButton("Locacões do Veículo");
		btnLocVeiculo.setBounds(30, 210, 156, 23);
		evBotoes(btnLocVeiculo);
		pnlRelatorio.add(btnLocVeiculo);
		
		btnLocPeriodo = new JButton("Locações por Período");
		btnLocPeriodo.setBounds(30, 244, 156, 23);
		evBotoes(btnLocPeriodo);
		pnlRelatorio.add(btnLocPeriodo);
		
		return pnlRelatorio;
	}
	
	public JMenuBar getMenu() {
		menu = new JMenuBar();
		mnCLientes = new JMenu("Clientes");
		itemCadCliente = new JMenuItem("Cadastrar Novo Cliente\r\n");
		itemListarClientes = new JMenuItem("Listar Clientes");
		itemRelatorioClientes = new JMenuItem("Relatório Completo");
		eventos(itemCadCliente);
		eventos(itemListarClientes);
		eventos(itemRelatorioClientes);
		menu.add(mnCLientes);
		mnCLientes.add(itemCadCliente);
		mnCLientes.add(itemListarClientes);
		mnCLientes.add(itemRelatorioClientes);
		
		mnVeiculos = new JMenu("Veículos");
		mnCadVeiculo = new JMenu("Cadastrar Novo Veículo");
		itemCadCarro = new JMenuItem("Carro");
		itemCadOnibus = new JMenuItem("Ônibus");
		itemCadCaminhao = new JMenuItem("Caminhão");
		itemListarVeiculos = new JMenuItem("Listar Veículos");
		itemRelatorioVeiculo = new JMenuItem("Relatório Completo");
		eventos(itemCadOnibus);
		eventos(itemCadCarro);
		eventos(itemCadCaminhao);
		eventos(itemListarVeiculos);
		eventos(itemRelatorioVeiculo); 
		menu.add(mnVeiculos);
		mnVeiculos.add(mnCadVeiculo);
		mnCadVeiculo.add(itemCadCarro);
		mnCadVeiculo.add(itemCadOnibus);
		mnCadVeiculo.add(itemCadCaminhao);
		mnVeiculos.add(itemListarVeiculos);
		mnVeiculos.add(itemRelatorioVeiculo);

		mnLocacoes = new JMenu("Locações");
		itemCadLocacao = new JMenuItem("Nova Locacão");
		itemListarLocacoes = new JMenuItem("Listar Locações");
		eventos(itemListarLocacoes);
		eventos(itemCadLocacao);
		menu.add(mnLocacoes);
		mnLocacoes.add(itemCadLocacao);	
		mnLocacoes.add(itemListarLocacoes);
		
		mnRelatorios = new JMenu("Relatórios");
		itemLocacoesCliente = new JMenuItem("Locações do Cliente");
		itemLocacoesVeiculo = new JMenuItem("Locações do Veículo");
		itemLocacoesPeriodo = new JMenuItem("Locações por período");
		eventos(itemLocacoesCliente);
		eventos(itemLocacoesVeiculo);
		eventos(itemLocacoesPeriodo);
		menu.add(mnRelatorios);
		mnRelatorios.add(itemLocacoesCliente);
		mnRelatorios.add(itemLocacoesVeiculo);
		mnRelatorios.add(itemLocacoesPeriodo);
		
		mnSair = new JMenu("Sair");
		itemFecharAplicacao = new JMenuItem ("Fechar Aplicação");
		eventos(itemFecharAplicacao);
		menu.add(mnSair);
		mnSair.add(itemFecharAplicacao);
		
		return menu;
	}

	
	/** 
	 * Método de controle dos Menus da janela. Recebe qual o subitem do menu que foi acionado pelo usuário.
	 * @param item do menu acionado.
	 */
	public void eventos(JMenuItem item) {
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				//Menu Clientes
				if (ev.getSource() == itemCadCliente) {
					JanelaVerificaCpf janelaVerificaCpf = new JanelaVerificaCpf(cadClientes);
					janelaVerificaCpf.setVisible(true);
				}
				
				if (ev.getSource() == itemListarClientes) {
					try {
						if(cadClientes.existeClienteCadastrado()) {
							tipoRelatorio = "ListarClientes";
							abrirJanelaRelatorio();
						}
					} catch (ListaClienteVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == itemRelatorioClientes) {		
					try {
						if(cadClientes.existeClienteCadastrado()) {
							tipoRelatorio = "RelatorioClientes";
							abrirJanelaRelatorio();
						}
					} catch (ListaClienteVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				//Menu Veículos
				if (ev.getSource() == itemCadCarro) {
					tipoInteracao = "Carro";
					abrirJanelaVerificaPlaca();
				}

				if (ev.getSource() == itemCadOnibus) {
					tipoInteracao = "Onibus";
					abrirJanelaVerificaPlaca();
				}

				if (ev.getSource() == itemCadCaminhao) {
					tipoInteracao = "Caminhao";
					abrirJanelaVerificaPlaca();
				}
				
				if (ev.getSource() == itemListarVeiculos) {
					try {
						if(cadVeiculo.existeVeiculoCadastrado()) {
							tipoRelatorio = "ListarVeiculos";
							abrirJanelaRelatorio();
						}
					} catch (ListaVeiculosVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == itemRelatorioVeiculo) {
					try {
						if(cadVeiculo.existeVeiculoCadastrado()) {
							tipoRelatorio = "RelatorioVeiculo";
							abrirJanelaRelatorio();
						}
					} catch (ListaVeiculosVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}

				//Menu Locacoes
				if (ev.getSource() == itemCadLocacao) {
					try {
						if(cadClientes.existeClienteCadastrado() && cadVeiculo.existeVeiculoCadastrado()){
							JanelaCadLocacoes janela = new JanelaCadLocacoes(cadClientes, cadVeiculo, cadLocacoes);
							janela.limparCampos();
							janela.setVisible(true);
						}
					} catch (ListaClienteVaziaException | ListaVeiculosVaziaException e){
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == itemListarLocacoes) {
					try {
						if(cadLocacoes.existeLocacoesCadastradas()) {
							tipoRelatorio = "ListarLocacoes";
							abrirJanelaRelatorio();
						} 
					} catch (ListaLocacoesVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				//Menu Relatorios
				if (ev.getSource() == itemLocacoesCliente) {
					try {
						if(cadLocacoes.existeLocacoesCadastradas()) {
							tipoRelatorio = "LocacoesClientes";
							abrirJanelaPesquisaCPF();
						}
					} catch (ListaLocacoesVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == itemLocacoesVeiculo) {
					try {
						if(cadLocacoes.existeLocacoesCadastradas()) {
							tipoRelatorio = "LocacoesVeiculos";
							abrirJanelaPesquisaPlaca();
						}
					} catch (ListaLocacoesVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == itemLocacoesPeriodo) {
					try {
						if(cadLocacoes.existeLocacoesCadastradas()) {
							tipoRelatorio = "LocacoesPeriodo";
							abrirJanelaSelecionaPeriodo();
						}
					} catch (ListaLocacoesVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				//Menu Sair
				if (ev.getSource() == itemFecharAplicacao) {
					dispose();
				}
			}
		});
	}
	
	
	/** 
	 * Método de controle dos Botões da janela. Recebe qual o botão da janela que foi acionado pelo usuário.
	 * @param item botão que foi clicado pelo usuário.
	 */
	private void evBotoes(JButton item) {
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				if (ev.getSource() == btnCliente) {
					JanelaVerificaCpf janelaVerificaCpf = new JanelaVerificaCpf(cadClientes);
					janelaVerificaCpf.setVisible(true);
				}
				
				if (ev.getSource() == btnLocacao) {
					try {
						if(cadClientes.existeClienteCadastrado() && cadVeiculo.existeVeiculoCadastrado()){
							JanelaCadLocacoes janela = new JanelaCadLocacoes(cadClientes, cadVeiculo, cadLocacoes);
							janela.limparCampos();
							janela.setVisible(true);
						}
					} catch (ListaClienteVaziaException | ListaVeiculosVaziaException e){
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == btnCarro) {
					tipoInteracao = "Carro";
					abrirJanelaVerificaPlaca();
				}
				
				if (ev.getSource() == btnOnibus) {
					tipoInteracao = "Onibus";
					abrirJanelaVerificaPlaca();
				}
				
				if (ev.getSource() == btnCaminhao) {
					tipoInteracao = "Caminhao";
					abrirJanelaVerificaPlaca();
				}
				
				if (ev.getSource() == btnRelCliente) {
					try {
						if(cadClientes.existeClienteCadastrado()) {
							tipoRelatorio = "RelatorioClientes";
							abrirJanelaRelatorio();
						}
					} catch (ListaClienteVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == btnRelVeiculo) {
					try {
						if(cadVeiculo.existeVeiculoCadastrado()) {
							tipoRelatorio = "RelatorioVeiculo";
							abrirJanelaRelatorio();
						}
					} catch (ListaVeiculosVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == btnRelLocacoes) {
					try {
						if(cadLocacoes.existeLocacoesCadastradas()) {
							tipoRelatorio = "ListarLocacoes";
							abrirJanelaRelatorio();
						} 
					} catch (ListaLocacoesVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == btnLocCliente) {
					try {
						if(cadLocacoes.existeLocacoesCadastradas()) {
							tipoRelatorio = "LocacoesClientes";
							abrirJanelaPesquisaCPF();
						}
					} catch (ListaLocacoesVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}

				if (ev.getSource() == btnLocVeiculo) {
					try {
						if(cadLocacoes.existeLocacoesCadastradas()) {
							tipoRelatorio = "LocacoesVeiculos";
							abrirJanelaPesquisaPlaca();
						}
					} catch (ListaLocacoesVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				if (ev.getSource() == btnLocPeriodo) {
					try {
						if(cadLocacoes.existeLocacoesCadastradas()) {
							tipoRelatorio = "LocacoesPeriodo";
							abrirJanelaSelecionaPeriodo();
						}
					} catch (ListaLocacoesVaziaException e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
	}
		
	public void abrirJanelaVerificaPlaca() {
		JanelaVerificaPlaca janelaVerificaPlaca = new JanelaVerificaPlaca(cadVeiculo, tipoInteracao);
		janelaVerificaPlaca.setVisible(true);
	}
	
	public void abrirJanelaRelatorio(){
		JanelaRelatorio janelaRelatorio = new JanelaRelatorio(cadClientes, cadVeiculo, cadLocacoes, tipoRelatorio, cpf, placa, dataInicial, dataFinal);
		janelaRelatorio.setVisible(true);
	}
	
	public void abrirJanelaPesquisaCPF() {
		JanelaPesquisaCPF janelaPesquisaCPF = new JanelaPesquisaCPF(cadClientes,cadVeiculo,cadLocacoes,tipoRelatorio, cpf);
		janelaPesquisaCPF.setVisible(true);
	}
	
	public void abrirJanelaPesquisaPlaca() {
		JanelaPesquisaPlaca janelaPesquisaPlaca = new JanelaPesquisaPlaca(cadClientes, cadVeiculo, cadLocacoes, tipoRelatorio, placa);
		janelaPesquisaPlaca.setVisible(true);
	}
	
	private void abrirJanelaSelecionaPeriodo() {
		JanelaSelecionaPeriodo janelaSelecionaPerido = new JanelaSelecionaPeriodo(cadClientes, cadVeiculo, cadLocacoes, tipoRelatorio, dataInicial, dataFinal);
		janelaSelecionaPerido.setVisible(true);
	}
}

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Testedelayout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testedelayout window = new Testedelayout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Testedelayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastros = new JLabel("Cadastros: ");
		lblCadastros.setForeground(new Color(128, 128, 128));
		lblCadastros.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastros.setBounds(60, 41, 147, 29);
		frame.getContentPane().add(lblCadastros);
		
		JLabel lblRelatrios = new JLabel("Relatórios:");
		lblRelatrios.setForeground(new Color(128, 128, 128));
		lblRelatrios.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRelatrios.setBounds(326, 41, 147, 29);
		frame.getContentPane().add(lblRelatrios);
		
		JPanel pnlCliente = new JPanel();
		pnlCliente.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlCliente.setBounds(60, 81, 212, 135);
		frame.getContentPane().add(pnlCliente);
		pnlCliente.setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setForeground(new Color(128, 128, 128));
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClientes.setBounds(75, 26, 54, 14);
		pnlCliente.add(lblClientes);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(63, 65, 89, 23);
		pnlCliente.add(btnCadastrar);
		
		
		
		
		
		JPanel pnlRelatorio = new JPanel();
		pnlRelatorio.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlRelatorio.setBounds(326, 81, 212, 326);
		frame.getContentPane().add(pnlRelatorio);
		pnlRelatorio.setLayout(null);
		
		JButton btnRelCliente = new JButton("Relatório Clientes");
		btnRelCliente.setBounds(30, 35, 156, 23);
		pnlRelatorio.add(btnRelCliente);
		
		JButton btnRelVeiculo = new JButton("Relatório Veículos");
		btnRelVeiculo.setBounds(30, 69, 156, 23);
		pnlRelatorio.add(btnRelVeiculo);
		
		JButton btnRelLocacoes = new JButton("Relatório Locações");
		btnRelLocacoes.setBounds(30, 107, 156, 23);
		pnlRelatorio.add(btnRelLocacoes);
		
		JButton btnLocCliente = new JButton("Locações do Cliente");
		btnLocCliente.setBounds(30, 176, 156, 23);
		pnlRelatorio.add(btnLocCliente);
		
		JButton btnLocVeiculo = new JButton("Locacões do Veículo");
		btnLocVeiculo.setBounds(30, 210, 156, 23);
		pnlRelatorio.add(btnLocVeiculo);
		
		JButton btnLocPeriodo = new JButton("Locações por Período");
		btnLocPeriodo.setBounds(30, 244, 156, 23);
		pnlRelatorio.add(btnLocPeriodo);
		
		
		
		
		JPanel pnlVeiculo = new JPanel();
		pnlVeiculo.setBorder(new LineBorder(new Color(128, 128, 128)));
		pnlVeiculo.setBounds(60, 228, 212, 179);
		frame.getContentPane().add(pnlVeiculo);
		pnlVeiculo.setLayout(null);
		
		JLabel lblVeiculos = new JLabel("Cadastrar Veículos");
		lblVeiculos.setForeground(new Color(128, 128, 128));
		lblVeiculos.setBounds(41, 22, 133, 17);
		lblVeiculos.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlVeiculo.add(lblVeiculos);
		
		JButton btnCarro = new JButton("Carro");
		btnCarro.setBounds(61, 64, 89, 23);
		pnlVeiculo.add(btnCarro);
		
		JButton btnOnibus = new JButton("Ônibus");
		btnOnibus.setBounds(61, 98, 89, 23);
		pnlVeiculo.add(btnOnibus);
		
		JButton btnCaminhao = new JButton("Caminhão");
		btnCaminhao.setBounds(61, 132, 89, 23);
		pnlVeiculo.add(btnCaminhao);
	}
}

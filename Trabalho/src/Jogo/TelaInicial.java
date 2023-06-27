package Jogo;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial {

	JFrame frmTelaInicial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frmTelaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmTelaInicial = new JFrame();
		frmTelaInicial.setTitle("Genius");
		frmTelaInicial.setBounds(100, 100, 450, 300);
		frmTelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaInicial.getContentPane().setLayout(null);
				
		
		JLabel LbCampeonato = new JLabel("Campeonato Genius");
		LbCampeonato.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LbCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		LbCampeonato.setBounds(103, 11, 244, 37);
		frmTelaInicial.getContentPane().add(LbCampeonato);
		
		JButton BtOpcoes = new JButton("Quantidade de Jogadores");
		BtOpcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Opcoes().frmOpes.setVisible(true);
				frmTelaInicial.setVisible(false);
			}
		});
		BtOpcoes.setBounds(103, 125, 219, 23);
		frmTelaInicial.getContentPane().add(BtOpcoes);
		
		JButton BtJogar = new JButton("Jogar");
		BtJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTelaInicial.setVisible(false);
				new Interface().frmGenius.setVisible(true);
				
			}
		});
		BtJogar.setBounds(167, 79, 89, 23);
		frmTelaInicial.getContentPane().add(BtJogar);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSair.setBounds(167, 173, 89, 23);
		frmTelaInicial.getContentPane().add(btSair);
	}

}

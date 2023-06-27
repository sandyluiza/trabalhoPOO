package Jogo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Opcoes {
	
	JFrame frmOpes;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Opcoes window = new Opcoes();
					window.frmOpes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Opcoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOpes = new JFrame();
		frmOpes.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				new TelaInicial().frmTelaInicial.setVisible(true);
			}
		});
		frmOpes.setTitle("Op\u00E7\u00F5es");
		frmOpes.setBounds(100, 100, 369, 228);
		frmOpes.getContentPane().setLayout(null);
		
		JLabel LbOpcoes = new JLabel("Op\u00E7\u00F5es");
		LbOpcoes.setHorizontalAlignment(SwingConstants.CENTER);
		LbOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LbOpcoes.setBounds(55, 11, 244, 37);
		frmOpes.getContentPane().add(LbOpcoes);
		
		JLabel lblNewLabel = new JLabel("Quantidade de Jogadores:");
		lblNewLabel.setBounds(42, 65, 151, 14);
		frmOpes.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setColumns(10);
		textField.setBounds(197, 62, 86, 20);
		frmOpes.getContentPane().add(textField);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmOpes.setVisible(false);
				
				DadosJogadores dadosjogadores = new DadosJogadores();
				
				dadosjogadores.setQtdjogadores(Integer.parseInt(textField.getText()));
				
				new DadosJogadores().FrmDados.setVisible(true);
			}
		});
		btOk.setBounds(127, 123, 89, 23);
		frmOpes.getContentPane().add(btOk);
		
	}
	
}

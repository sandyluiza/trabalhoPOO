package Jogo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class DadosJogadores {

	JFrame FrmDados;
	private JTextField Nome;
	private JTextField Apelido;
	protected Object frmDados;
	static ArrayList<String> listaNome = new ArrayList<String>();
	static ArrayList<String> listaApelido = new ArrayList<String>();
	int cont=1;
	JLabel tituloDadosJogadores;
	static int qtdjogadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosJogadores window = new DadosJogadores();
					window.FrmDados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DadosJogadores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrmDados = new JFrame();
		FrmDados.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				new TelaInicial().frmTelaInicial.setVisible(true);
			}
		});
		FrmDados.setTitle("Dados");
		FrmDados.setBounds(100, 100, 450, 300);
		FrmDados.getContentPane().setLayout(null);
		
		tituloDadosJogadores = new JLabel("Dados do Jogador 1");
		tituloDadosJogadores.setHorizontalAlignment(SwingConstants.CENTER);
		tituloDadosJogadores.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloDadosJogadores.setBounds(88, 11, 244, 37);
		FrmDados.getContentPane().add(tituloDadosJogadores);
		
		JLabel EdNom = new JLabel("Nome:");
		EdNom.setBounds(88, 72, 94, 14);
		FrmDados.getContentPane().add(EdNom);
		
		JLabel EdAp = new JLabel("Apelido:");
		EdAp.setBounds(88, 99, 94, 14);
		FrmDados.getContentPane().add(EdAp);
		
		Nome = new JTextField();
		Nome.setColumns(50);
		Nome.setBounds(186, 69, 86, 20);
		FrmDados.getContentPane().add(Nome);
		
		Apelido = new JTextField();
		Apelido.setColumns(50);
		Apelido.setBounds(186, 96, 86, 20);
		FrmDados.getContentPane().add(Apelido);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmDados.setVisible(false);
				listaNome.add(Nome.getText());
				Nome.setText("");
				listaApelido.add(Apelido.getText());
				Apelido.setText("");
				
				cont = cont +1;
				dadosTodosJogadores(cont);
			}
		});
		btOk.setBounds(186, 156, 89, 23);
		FrmDados.getContentPane().add(btOk);
	}
	
	public void dadosTodosJogadores(int cont) {	
		if(qtdjogadores>=cont) {
			tituloDadosJogadores.setText("Dados do Jogador " + cont);
			FrmDados.setVisible(true);
		}
		else {
			FrmDados.dispose();
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			new TelaInicial().frmTelaInicial.setVisible(true);
		}
		
	}

	public int getQtdjogadores() {
		return qtdjogadores;
	}

	public void setQtdjogadores(int qtdjogadores) {
		DadosJogadores.qtdjogadores = qtdjogadores;
	}

	public ArrayList<String> getListaNome() {
		return listaNome;
	}

	public void setListaNome(ArrayList<String> listaNome) {
		DadosJogadores.listaNome = listaNome;
	}

	public ArrayList<String> getListaApelido() {
		return listaApelido;
	}

	public void setListaApelido(ArrayList<String> listaApelido) {
		DadosJogadores.listaApelido = listaApelido;
	}
	
	
	
}

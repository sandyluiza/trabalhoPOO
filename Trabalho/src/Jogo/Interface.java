package Jogo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Interface {
	JButton bt4;
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JButton btIniciar;
	
	private Timer timerPisca;
	private Timer timerUser;
	    
	ArrayList<Integer> listaBotoes = new ArrayList<Integer>();
	ArrayList<Integer> listaUser = new ArrayList<Integer>();
	ArrayList<Integer> pontosJogadores = new ArrayList<Integer>();
	int maiorPonto = 0;
	
	int x = 1, y = 0, z = 0, w = 0;
	boolean fim = false;
	long start, finish, total, tempoTotal, jogadaRapida, valorLido=0;
	int cont=1;
	String nome;
	String apelido;
	static String mensagemfinal;


	public JFrame frmGenius;
	private JLabel titulo;
	private JButton btSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmGenius.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public Interface() {
		initialize();
		mensagemfinal = "";
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	public void initialize() {
		frmGenius = new JFrame();
		frmGenius.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				new TelaInicial().frmTelaInicial.setVisible(true);
			}
		});
		frmGenius.setTitle("Genius: Jogador 1");
		frmGenius.setType(Type.UTILITY);
		frmGenius.setAutoRequestFocus(false);
		frmGenius.setAlwaysOnTop(true);
		frmGenius.setBounds(100, 100, 369, 552);
		frmGenius.getContentPane().setLayout(null);
		
		Novo Novo = new Novo();
		GuardaClickUsuario GuardaClickUsuario = new GuardaClickUsuario();
	
		bt1 = new JButton("");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt1.requestFocus();
                try {
					Thread.sleep(500);
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                titulo.requestFocus();
			}
		});
		ImageIcon img1e = new ImageIcon(this.getClass().getResource("/lado1escuro.png"));
    	ImageIcon img1c = new ImageIcon(this.getClass().getResource("/lado1claro.png"));
    	
    	bt1.setIcon(img1e);
    	bt1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				bt1.setIcon(img1c);
				try {
					AudioAcerto(0);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
    		@Override
    		public void focusLost(FocusEvent e) {
    			bt1.setIcon(img1e);
    		}
		});
		bt1.setBorder(null);
		bt1.setOpaque(false);
		bt1.setContentAreaFilled(false);
		bt1.setBorderPainted(false);
		bt1.setBounds(0, 0, 173, 183);
		bt1.addActionListener(GuardaClickUsuario);
		frmGenius.getContentPane().add(bt1);
		
		bt2 = new JButton("");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt2.requestFocus();
                try {
					Thread.sleep(500);
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                titulo.requestFocus();
			}
		});
		ImageIcon img2e = new ImageIcon(this.getClass().getResource("/lado2escuro.png"));
    	ImageIcon img2c = new ImageIcon(this.getClass().getResource("/lado2claro.png"));
    	bt2.setIcon(img2e);
		bt2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				bt2.setIcon(img2c);
				try {
					AudioAcerto(1);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				bt2.setIcon(img2e);
			}
		});
		
		bt2.setBorder(null);
		bt2.setOpaque(false);
		bt2.setContentAreaFilled(false);
		bt2.setBorderPainted(false);
		bt2.setBounds(172, 0, 180, 183);
		bt2.addActionListener(GuardaClickUsuario);
		frmGenius.getContentPane().add(bt2);
		
		bt3 = new JButton("");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt3.requestFocus();
                try {
					Thread.sleep(500);
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                titulo.requestFocus();
			}
		});
		ImageIcon img3e = new ImageIcon(this.getClass().getResource("/lado3escuro.png"));
    	ImageIcon img3c = new ImageIcon(this.getClass().getResource("/lado3claro.png"));
    	bt3.setIcon(img3e);
		bt3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				bt3.setIcon(img3c);
				try {
					AudioAcerto(2);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				bt3.setIcon(img3e);
			}
		});
		
		bt3.setBorder(null);
		bt3.setOpaque(false);
		bt3.setContentAreaFilled(false);
		bt3.setBorderPainted(false);
		bt3.setBounds(0, 179, 173, 183);
		bt3.addActionListener(GuardaClickUsuario);
		frmGenius.getContentPane().add(bt3);
		
		bt4 = new JButton("");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt4.requestFocus();
                try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                titulo.requestFocus();
                
			}
		});
		ImageIcon img4e = new ImageIcon(this.getClass().getResource("/lado4escuro.png"));
    	ImageIcon img4c = new ImageIcon(this.getClass().getResource("/lado4claro.png"));
		bt4.setIcon(img4e);
		bt4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				bt4.setIcon(img4c);
				try {
					AudioAcerto(3);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				bt4.setIcon(img4e);
			}
		});
		bt4.setBorder(null);
		bt4.setOpaque(false);
		bt4.setContentAreaFilled(false);
		bt4.setBorderPainted(false);
		bt4.setBounds(172, 179, 180, 183);
		bt4.addActionListener(GuardaClickUsuario);
		frmGenius.getContentPane().add(bt4);
		
		btIniciar = new JButton("Iniciar");
		btIniciar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btIniciar.setBounds(137, 373, 89, 23);
		frmGenius.getContentPane().add(btIniciar);
		btIniciar.addActionListener(Novo);
		
		titulo = new JLabel("Genius");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(75, 436, 210, 14);
		frmGenius.getContentPane().add(titulo);
		
		btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGenius.setVisible(false);
				new TelaInicial().frmTelaInicial.setVisible(true);
			}
		});
		btSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btSair.setBounds(137, 402, 89, 23);
		frmGenius.getContentPane().add(btSair);
		
		SwingUtilities.invokeLater(new Runnable() { 
		    public void run() { 
		    	titulo.requestFocus(); 
		    } 
		});
	}
	
	public void seleciona(int botao) {
	    @SuppressWarnings("rawtypes")
		SwingWorker worker = new SwingWorker() {
	        @Override
	        protected Object doInBackground() throws Exception {
	            switch (botao) {
	                case 0:
	                	bt1.requestFocus();
	                    Thread.sleep(500);
	                    titulo.requestFocus();
	                    break;
	                case 1:
	                	bt2.requestFocus();
	                    Thread.sleep(500);
	                    titulo.requestFocus();
	                    break;
	                case 2:
	                	bt3.requestFocus();
	                    Thread.sleep(500);
	                    titulo.requestFocus();
	                    break;
	                case 3:
	                	bt4.requestFocus();
	                    Thread.sleep(500);
	                    titulo.requestFocus();
	                    break;
	            }
	            return null;
	       }

	       @Override
	       protected void done() {

	           super.done();
	           try {
	               get();
	           } catch (InterruptedException | ExecutionException ex) {
	               ex.printStackTrace();
	           }
	       }
	    };
	    worker.execute();
	}
	
	private class Novo implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Random geradorNumeros = new Random();
            fim = false;
            int numeroGerado, j;
            MostraSequencia MostraSequencia = new MostraSequencia();
                       
            for(j = 0; j < 100; j++){
                numeroGerado = geradorNumeros.nextInt(4);
                listaBotoes.add(numeroGerado);
            }

            timerPisca = new Timer(700, MostraSequencia);   
            timerPisca.start();
        }
    }
	
	
	private class MostraSequencia implements ActionListener{
		
        public void actionPerformed(ActionEvent event){  
        	
            AcertouErrou AcertouErrou = new AcertouErrou();
            if((y < x)&&(listaBotoes.size()>0)){
                seleciona(listaBotoes.get(y));
                y++;
            }
            
            if(y==x && fim == false){
                titulo.setText("Insira a sequencia " + y);
                start = System.currentTimeMillis();
                timerUser = new Timer(700, AcertouErrou);  
                timerUser.start();
                finish = System.currentTimeMillis();
                total = finish - start;
                tempoTotal = total+tempoTotal;
                
                if (z > 0) {
                	valorLido = total;
                }
                else if (total < valorLido) {
                	valorLido = total;
                }
                jogadaRapida = valorLido;
            }
            
   
            if(fim == true /*|| total > 700*/){
            	frmGenius.setVisible(false);
            	fim = false;
            	timerPisca.stop();
            	timerUser.stop();
            	DadosJogadores dadosJogadores = new DadosJogadores();
            	
                nome = dadosJogadores.getListaNome().get(cont-1);
                apelido =dadosJogadores.getListaApelido().get(cont-1);
                StringBuilder mensagem = new StringBuilder();
                
                mensagem.append("Nome do Jogador: ").append(""+nome).append("\n").append("Apelido: ").append(""+apelido).
                append("\n").append("Total de pontos: ").append(z-1).append("\n").append("Tempo Total: ").
                append(tempoTotal).append("\n").append("Jogada Mais Rapida: ").append(jogadaRapida);
                JOptionPane.showMessageDialog(null, mensagem); 
                
                mensagemfinal = (mensagemfinal +"\n"+ mensagem+"\n");
               
                pontosJogadores.add(z);
                
                if (maiorPonto < z) {
                	maiorPonto = z;
                }
                                
                cont = cont +1;
                try {
					jogosJogadores(cont);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
            }
        }
    }
	
	public void jogosJogadores(int cont) throws Throwable {
		int contjogadores=0;	
		StringBuilder mensagem1 = new StringBuilder();
		DadosJogadores dadosjogadores = new DadosJogadores();

		if(dadosjogadores.getQtdjogadores()>=cont) {
			frmGenius.setTitle("Genius: Jogador " + cont);
			titulo.setText("Genius");
			listaBotoes.clear();
        	listaUser.clear();
        	x = 1; 
            y = 0; 
            z = 0; 
            w = 0;
        	start=0; 
        	finish=0; 
        	total=0; 
        	tempoTotal=0; 
        	jogadaRapida=0; 
        	valorLido=0;
        	listaBotoes.clear();
        	listaUser.clear();
        	nome = ""; 
        	apelido = "";
        	titulo.requestFocus();
			frmGenius.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Jogo Finalizado!");
			
			if (dadosjogadores.getQtdjogadores()>1) {
				for (int i=0;i<dadosjogadores.getQtdjogadores(); i++) {
					if (maiorPonto == pontosJogadores.get(i)) {
						mensagem1.append(dadosjogadores.getListaNome().get(i)).append("\n");
						contjogadores = contjogadores +1;
					}
				}			
			
				if (contjogadores > 1) {
					JOptionPane.showMessageDialog(null, "Jogo Empatado. É necessário uma terceira rodada!");
					JOptionPane.showMessageDialog(null, "Maiores pontos:\n"+mensagem1); 
				}
				else {
					JOptionPane.showMessageDialog(null, "Ganhador: "+mensagem1);
				}
			}
			
			JOptionPane.showMessageDialog(null, "TORNEIO GENIUS\n\n"+"Relatório Final\n"+"Data da partida: "+dataHora()+"\n"+getMensagemfinal());
			new TelaInicial().frmTelaInicial.setVisible(true);
		}
	}
	

	private class AcertouErrou implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){ 
            int i;
            if(z == x){
                for(i=0; i < x; i++){
                    if(listaBotoes.get(i) == listaUser.get(i)){
                        titulo.setText("Acertou!" );
                    } else {
                        titulo.setText("Errou!" );
                        fim = true;
                       
                    }
                }
                if (fim == false){
                    listaUser.clear();
                    x++;
                    z = 0;
                    y = 0;
                    }
            }
            if(z == 100){
                fim = true;
               
            }
            
        }
    }
	
    
    private class GuardaClickUsuario implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
             if(ae.getSource().equals(bt1)){
                 listaUser.add(0);
                 z++;
             }else if(ae.getSource().equals(bt2)){
                 listaUser.add(1);
                 z++;
             }else if(ae.getSource().equals(bt3)){
                 listaUser.add(2);
                 z++;
             }else if(ae.getSource().equals(bt4)){
                 listaUser.add(3);
                 z++;
             }
        }
    }
    
    void AudioAcerto(int bt) throws UnsupportedAudioFileException, IOException, LineUnavailableException { 
    	 AudioInputStream audioInputStream=null;
    	 
    	 switch (bt) {
         	case 0:
         		audioInputStream = AudioSystem.getAudioInputStream(new File("./Sons/fa.wav").getAbsoluteFile());
         		break;
         	case 1:
         		audioInputStream = AudioSystem.getAudioInputStream(new File("./Sons/notado.wav").getAbsoluteFile());
         		break;
         	case 2:
         		audioInputStream = AudioSystem.getAudioInputStream(new File("./Sons/re.wav").getAbsoluteFile());
         		break;
         	case 3:
         		audioInputStream = AudioSystem.getAudioInputStream(new File("./Sons/sol.wav").getAbsoluteFile());
         		break;
    	 }

         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         clip.loop(0);
    }

    public String getMensagemfinal() {
		return mensagemfinal;
	}
    
    private String dataHora() {
		DateFormat dataatual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dataatual.format(date);
	}
    
}

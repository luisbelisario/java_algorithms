package entities;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class JogoVelha extends JFrame {
	
	final int JOGADOR1 = 1;
	final int JOGADOR2 = 2;
	
	public int vezJogador = JOGADOR1;

	ImageIcon circulo = new ImageIcon(getClass().getResource("cranio.jpeg"));
	ImageIcon x = new ImageIcon(getClass().getResource("ossos.jpeg"));

	
	JPanel tela = new JPanel(new GridLayout(3, 3, 5, 5));
	JLabel infoJogador = new JLabel("Jogador " + JOGADOR1);
	
	Bloco[] blocosJogo = new Bloco[9];
	
	int rodadas = 0;
	
	public JogoVelha() throws DomainException {
		configurarJanela();
		configurarTela();
	}
	
	public void configurarTela() throws DomainException {
			
		add(BorderLayout.CENTER, tela);
		add(BorderLayout.NORTH, infoJogador);
		tela.setBackground(Color.BLACK);
		infoJogador.setFont(new Font("Calibri", Font.BOLD, 20));
		infoJogador.setHorizontalAlignment(SwingConstants.CENTER);
		
		for(int i=0;i<9;i++) {
			Bloco blocoIndividual = new Bloco();
			blocosJogo[i] = blocoIndividual;
			tela.add(blocoIndividual);
		}
	}
	
	
	public void configurarJanela() {
		setTitle("Jogo da Velha");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public class Vitoria {
	
		public Vitoria() {
			
		}
		
		public boolean temVitoria(int j) {
			if(blocosJogo[0].jogadorMarcador==j && blocosJogo[1].jogadorMarcador==j && blocosJogo[2].jogadorMarcador==j) {
				return true;
			}
			if(blocosJogo[3].jogadorMarcador==j && blocosJogo[4].jogadorMarcador==j && blocosJogo[5].jogadorMarcador==j) {
				return true;
			}
			if(blocosJogo[6].jogadorMarcador==j && blocosJogo[7].jogadorMarcador==j && blocosJogo[8].jogadorMarcador==j) {
				return true;
			}
			if(blocosJogo[0].jogadorMarcador==j && blocosJogo[3].jogadorMarcador==j && blocosJogo[6].jogadorMarcador==j) {
				return true;
			}
			if(blocosJogo[1].jogadorMarcador==j && blocosJogo[4].jogadorMarcador==j && blocosJogo[7].jogadorMarcador==j) {
				return true;
			}
			if(blocosJogo[2].jogadorMarcador==j && blocosJogo[5].jogadorMarcador==j && blocosJogo[8].jogadorMarcador==j) {
				return true;
			}
			if(blocosJogo[0].jogadorMarcador==j && blocosJogo[4].jogadorMarcador==j && blocosJogo[8].jogadorMarcador==j) {
				return true;
			}
			if(blocosJogo[2].jogadorMarcador==j && blocosJogo[4].jogadorMarcador==j && blocosJogo[6].jogadorMarcador==j) {
				return true;
			}
			return false;
		}
	}
	
	
	
	public class Bloco extends JButton {
		
		public int jogadorMarcador = 0;
		
		
		Vitoria vitorioso = new Vitoria();
		
		public Bloco() {
			setBackground(Color.WHITE);
			
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(jogadorMarcador == 0) {
						if(vezJogador == JOGADOR1) {
							setIcon(circulo);
							jogadorMarcador = 1;
						}
						else if(vezJogador == JOGADOR2) {
							setIcon(x);
							jogadorMarcador = 2;
						}
						
						if(vitorioso.temVitoria(jogadorMarcador)) {
							JOptionPane.showMessageDialog(null, "Jogador " + jogadorMarcador + " venceu!");
						}
						
						rodadas ++;
						if(vitorioso.temVitoria(jogadorMarcador) == false && rodadas==9) {
							JOptionPane.showMessageDialog(null, "Ninguém venceu!");
						}
						mudarVez();
					}
				}
				
			});
		}
		
		public void mudarVez() {
			if(vezJogador==1) {
				vezJogador = 2;
				infoJogador.setText("Jogador 2");
			}
			else {
				vezJogador = 1;
				infoJogador.setText("Jogador 1");
			}
		}
	}
	
	public static class MenuInicio extends JFrame implements ActionListener {
		
		JogoVelha jogo;
		
		JButton botaoSim = new JButton("Sim");
		JButton botaoNao = new JButton("Não");
		
		public MenuInicio() throws DomainException {
			configurarMenuInicio();
		}
		
		public void configurarMenuInicio() throws DomainException {
			
			
			setTitle("Deseja iniciar um novo jogo?");
			setSize(300, 200);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setVisible(true);
			setResizable(false);
			
			
			setLayout(null);
			botaoSim.setBounds(30, 60, 100, 60);
			getContentPane().add(botaoSim);
			botaoSim.addActionListener(this);
			
			
			setLayout(null);
			botaoNao.setBounds(169, 60, 100, 60);
			getContentPane().add(botaoNao);
			botaoNao.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==botaoSim) {
				try {
					jogo = new JogoVelha();
				} 
				catch (NullPointerException e1) {
					System.out.println("Algo deu errado! Contate o administrador!");
				} 
				catch (DomainException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource()==botaoNao) {
				System.exit(0);
			}
		}
		
		
	}
	
	
	public class DomainException extends Exception {
		
		
		private static final long serialVersionUID = 1L;

		public DomainException(String msg) {
			super(msg);
		}
	}

	
	public static void main(String[] args) throws DomainException {
		try {
			new MenuInicio();	
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
	}
}

package br.dev.aline.temperatura.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.dev.aline.temperatura.model.Temperatura;

public class TelaConversor {

// Declarando Atributos
	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;

	private Font fonteTextCelsius;
	private Font fonteLabelCelsius;
	private Font fonteLabelResultado;
	private Font fonteMensagemErro;
	private Color corLabelMensagemErro;

// Método para criar a tela
	public void criarTelaConversor() {

// Criando fonte do texto Celsius
		fonteTextCelsius = new Font("Arial", 0, 14);

// criando fonte do Label Celsius
		fonteLabelCelsius = new Font("Arial", 1, 14);

// criando fonte do Label Resultado
		fonteLabelResultado = new Font("Arial", 1, 20);

// criando fonte da Mensagem Erro
		fonteMensagemErro = new Font("Arial", 1, 14);

// Definindo Cores cor do Label Mensagem de Erro como vermelho.
		corLabelMensagemErro = new Color(255, 0, 0);

// Criando a Tela Gráfica com objeto JFrame

		JFrame tela = new JFrame();

// Definindo o tamanho da tela pelo objeto Dimension
		Dimension tamanho = new Dimension();
		tamanho.setSize(500, 400);

// configurando tamanho da tela através do Dimension
		tela.setSize(tamanho);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("CONVERSOR DE TEMPERATURA");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);

// Celsius
		labelCelsius = new JLabel();
		labelCelsius.setFont(fonteLabelCelsius);
		labelCelsius.setText("Temperatura em graus celsius: ");
		labelCelsius.setBounds(40, 60, 420, 30);

		textCelsius = new JTextField();
		textCelsius.setFont(fonteTextCelsius);
		textCelsius.setBounds(40, 90, 420, 30);

// Botão Fahreinheit
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("FAHREINHEIT");
		buttonFahreinheit.setBounds(40, 130, 200, 40);

// Botão Kelvin
		buttonKelvin = new JButton();
		buttonKelvin.setText("KELVIN");
		buttonKelvin.setBounds(260, 130, 200, 40);

// Resultado
		labelResultado = new JLabel();
		labelResultado.setFont(fonteLabelResultado);
		labelResultado.setText("Digite um número para começar!");
		labelResultado.setBounds(40, 190, 420, 40);
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);

// criando JLabel para Mensagem de erro
		labelMensagemErro = new JLabel();
		labelMensagemErro.setFont(fonteMensagemErro);
		labelMensagemErro.setForeground(corLabelMensagemErro);
		labelMensagemErro.setBounds(40, 240, 420, 40);
		labelMensagemErro.setHorizontalAlignment(SwingConstants.CENTER);

// Adicionando componentes na tela
		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);

// Listener adicionado ao botão Fahreinheit para monitorar o clic do botão.
		buttonFahreinheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String valorCelsius = textCelsius.getText();
//Utilizando try para um possível erro
				try {
					Temperatura temperatura = new Temperatura();
					double celsius = Double.parseDouble(valorCelsius);
					temperatura.setCelsius(celsius);

					double fahreinheit = temperatura.converterParaFahreinheit();
					labelResultado.setText( fahreinheit + " FAHREINHEIT ");
					labelMensagemErro.setText(null);
					textCelsius.requestFocus();

				} catch (Exception ex) {
					labelMensagemErro.setText("### Por favor, digite apenas caracteres numéricos!!!");
					textCelsius.setText(null);
					textCelsius.requestFocus();
				}
			}
		});

// Listener adicionado ao botão Kelvin para monitorar o clic do botão.
		buttonKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String valorCelsius = textCelsius.getText();

//Utilizando try para um possível erro
				try {
					Temperatura temperatura = new Temperatura();
					double celsius = Double.parseDouble(valorCelsius);
					temperatura.setCelsius(celsius);

					double kelvin = temperatura.converterParaKelvin();

					labelResultado.setText(kelvin + " KELVIN ");

				} catch (NumberFormatException ex) {
					labelMensagemErro.setText("### Por favor, digite apenas caracteres numéricos!!! ");
					textCelsius.setText(null);
					textCelsius.requestFocus();
				}

			}
		});

// Colocando a tela para ser visivel.
		tela.setVisible(true);
	}

}
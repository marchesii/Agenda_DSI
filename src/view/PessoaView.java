package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import constantes.Constantes;
import dao.ContatoDAO;
import dao.UsuarioDAO;
import model.Contato;
import model.Telefone;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class PessoaView extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfDDD;
	private static Contato contato = null;
	

	/**
	 * Launch the application.
	 */
	public static Contato main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PessoaView frame = new PessoaView(args);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return null;
	}

	/**
	 * Create the frame.
	 * @param args 
	 */
	public PessoaView(String[] args) {
		setTitle("Contato");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 39, 0, 0, 0, 0, 0, 85, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 1;
		contentPane.add(lblNome, gbc_lblNome);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.gridwidth = 7;
		gbc_tfNome.insets = new Insets(0, 0, 5, 5);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 2;
		gbc_tfNome.gridy = 1;
		contentPane.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 3;
		contentPane.add(lblTelefone, gbc_lblTelefone);
		
		try {
			tfDDD = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("(##) ##### - ####")));
		} catch (ParseException e2) {
			JOptionPane.showMessageDialog(null, Constantes.ERROR_INPUT_TELEFONE);
		}
		GridBagConstraints gbc_tfDDD = new GridBagConstraints();
		gbc_tfDDD.gridwidth = 7;
		gbc_tfDDD.insets = new Insets(0, 0, 5, 5);
		gbc_tfDDD.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDDD.gridx = 2;
		gbc_tfDDD.gridy = 3;
		contentPane.add(tfDDD, gbc_tfDDD);
		tfDDD.setColumns(2);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					contato = new Contato(tfNome.getText(), tfDDD.getText(), MainView.getUser());
					if(args[0].equals("Alterar")) {
						ContatoDAO.getInstance().alterarPessoa(contato, MainView.getUser());
						JOptionPane.showMessageDialog(null, Constantes.TABLE_CONTATO_ALTER);
					} else if(args[0].equals("Salvar")) {
						ContatoDAO.getInstance().salvarPessoa(contato, MainView.getUser());	
						JOptionPane.showMessageDialog(null, Constantes.TABLE_CONTATO_INSERT);
					}
					dispose();
				} catch (Exception e1) {
					return;
				}
			}
		});
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.gridwidth = 5;
		gbc_btnConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirmar.gridx = 2;
		gbc_btnConfirmar.gridy = 5;
		contentPane.add(btnConfirmar, gbc_btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 5;
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 6;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		
		if(args[0].equals("Alterar")) {
			tfNome.setText(contato.getNome());
			tfDDD.setText(contato.getTelefone());
		}
	}

	public static void main(String[] botao, Contato selectedValue) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contato = selectedValue;
					PessoaView frame = new PessoaView(botao);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}

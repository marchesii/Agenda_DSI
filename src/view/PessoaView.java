package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class PessoaView extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfPrefixo;
	private JTextField tfDDD;
	private JTextField tfSulfixo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PessoaView frame = new PessoaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PessoaView() {
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
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 2;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		tfEmail = new JTextField();
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.gridwidth = 7;
		gbc_tfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmail.gridx = 2;
		gbc_tfEmail.gridy = 2;
		contentPane.add(tfEmail, gbc_tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.anchor = GridBagConstraints.EAST;
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 3;
		contentPane.add(lblTelefone, gbc_lblTelefone);
		
		tfDDD = new JTextField();
		GridBagConstraints gbc_tfDDD = new GridBagConstraints();
		gbc_tfDDD.insets = new Insets(0, 0, 5, 5);
		gbc_tfDDD.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDDD.gridx = 2;
		gbc_tfDDD.gridy = 3;
		contentPane.add(tfDDD, gbc_tfDDD);
		tfDDD.setColumns(2);
		
		tfPrefixo = new JTextField();
		GridBagConstraints gbc_tfPrefixo = new GridBagConstraints();
		gbc_tfPrefixo.gridwidth = 3;
		gbc_tfPrefixo.insets = new Insets(0, 0, 5, 5);
		gbc_tfPrefixo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrefixo.gridx = 3;
		gbc_tfPrefixo.gridy = 3;
		contentPane.add(tfPrefixo, gbc_tfPrefixo);
		tfPrefixo.setColumns(9);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		tfSulfixo = new JTextField();
		tfSulfixo.setColumns(9);
		GridBagConstraints gbc_tfSulfixo = new GridBagConstraints();
		gbc_tfSulfixo.insets = new Insets(0, 0, 5, 5);
		gbc_tfSulfixo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSulfixo.gridx = 8;
		gbc_tfSulfixo.gridy = 3;
		contentPane.add(tfSulfixo, gbc_tfSulfixo);
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
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridwidth = 5;
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 6;
		contentPane.add(btnCancelar, gbc_btnCancelar);
	}

}

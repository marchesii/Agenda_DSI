package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {1, 1, 1, 1};
		gbl_contentPane.rowHeights = new int[] {1, 1};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.VERTICAL;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		contentPane.add(textArea, gbc_textArea);
		
		JButton btnIncPessoa = new JButton("Incluir Pessoa");
		GridBagConstraints gbc_btnIncPessoa = new GridBagConstraints();
		gbc_btnIncPessoa.insets = new Insets(0, 0, 0, 5);
		gbc_btnIncPessoa.gridx = 0;
		gbc_btnIncPessoa.gridy = 1;
		contentPane.add(btnIncPessoa, gbc_btnIncPessoa);
		
		JButton btnRemPessoa = new JButton("Remover Pessoa");
		GridBagConstraints gbc_btnRemPessoa = new GridBagConstraints();
		gbc_btnRemPessoa.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemPessoa.gridx = 1;
		gbc_btnRemPessoa.gridy = 1;
		contentPane.add(btnRemPessoa, gbc_btnRemPessoa);
		
		JButton btnConPessoa = new JButton("Consultar Pessoa");
		GridBagConstraints gbc_btnConPessoa = new GridBagConstraints();
		gbc_btnConPessoa.insets = new Insets(0, 0, 0, 5);
		gbc_btnConPessoa.gridx = 2;
		gbc_btnConPessoa.gridy = 1;
		contentPane.add(btnConPessoa, gbc_btnConPessoa);
		
		JButton btnAltPessoa = new JButton("Alterar Pessoa");
		btnAltPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAltPessoa = new GridBagConstraints();
		gbc_btnAltPessoa.gridx = 3;
		gbc_btnAltPessoa.gridy = 1;
		contentPane.add(btnAltPessoa, gbc_btnAltPessoa);
	}

}

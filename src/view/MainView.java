package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constantes.Constantes;
import dao.ContatoDAO;
import dao.UsuarioDAO;
import model.Contato;
import model.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class MainView extends JFrame {

	private JPanel contentPane;
	private static Usuario user;
	DefaultListModel<Contato> listmodel = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(Usuario user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView(user);
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
	public MainView(Usuario user) {
		this.user = user;
		setTitle("Menu da agenda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {1, 1, 1};
		gbl_contentPane.rowHeights = new int[] {1, 1};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JList<Contato> list = new JList<Contato>();
		
		list.setModel(listmodel);
		try {
			ContatoDAO.contatos = ContatoDAO.getInstance().consultaPorParametro(user.getLogin());
		} catch (SQLException e2) {
			ContatoDAO.contatos.add(null);
		}
		Contato[] contatos = new Contato[ContatoDAO.contatos.size()];
		ContatoDAO.contatos.toArray(contatos);
		list.setListData(contatos);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 3;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		contentPane.add(list, gbc_list);
		
		JButton btnIncPessoa = new JButton("Incluir Pessoa");
		btnIncPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] botao = {"Salvar"};
				PessoaView.main(botao);
				Contato[] contatos = new Contato[ContatoDAO.contatos.size()];
				ContatoDAO.contatos.toArray(contatos);
				list.setListData(contatos);
			}
		});
		GridBagConstraints gbc_btnIncPessoa = new GridBagConstraints();
		gbc_btnIncPessoa.insets = new Insets(0, 0, 0, 5);
		gbc_btnIncPessoa.gridx = 0;
		gbc_btnIncPessoa.gridy = 1;
		contentPane.add(btnIncPessoa, gbc_btnIncPessoa);
		
		JButton btnRemPessoa = new JButton("Remover Pessoa");
		btnRemPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ContatoDAO.getInstance().deletarPessoa(list.getSelectedValue(), user.getLogin());
					listmodel.removeElement(list.getSelectedValue());
					JOptionPane.showMessageDialog(null, Constantes.TABLE_CONTATO_DELETE);
					Contato[] contatos = new Contato[ContatoDAO.contatos.size()];
					ContatoDAO.contatos.toArray(contatos);
					list.setListData(contatos);
					
				} catch (Exception e1) {
					return;
				}
			}
		});
		GridBagConstraints gbc_btnRemPessoa = new GridBagConstraints();
		gbc_btnRemPessoa.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemPessoa.gridx = 1;
		gbc_btnRemPessoa.gridy = 1;
		contentPane.add(btnRemPessoa, gbc_btnRemPessoa);
		
			JButton btnAltPessoa = new JButton("Alterar Pessoa");
			btnAltPessoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] botao = {"Alterar"};
					PessoaView.main(botao, list.getSelectedValue());
					Contato[] contatos = new Contato[ContatoDAO.contatos.size()];
					ContatoDAO.contatos.toArray(contatos);
					list.setListData(contatos);
				}
			});
			GridBagConstraints gbc_btnAltPessoa = new GridBagConstraints();
			gbc_btnAltPessoa.gridx = 2;
			gbc_btnAltPessoa.gridy = 1;
			contentPane.add(btnAltPessoa, gbc_btnAltPessoa);
	}

	public static int getUser() {
		return user.getLogin();
	}
}

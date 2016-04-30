package coinmachine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class CoinMachineApp extends JFrame {

	private JPanel contentPane, InputPanel;
	private JLabel lblBalance, lblStatus;
	private JProgressBar progressBar;
	private JButton btnTenBaht, btnFiveBaht, btnOneBaht;

	public CoinMachineApp() {
		initComponent();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void initComponent() {
		setTitle("CoinMachine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		InputPanel = new JPanel();
		InputPanel.setBorder(new TitledBorder(null, "Insert Money", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblBalance = new JLabel("Balance: 0");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(10);
		progressBar.setForeground(Color.GREEN);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(InputPanel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblBalance)
							.addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(InputPanel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
		);
		InputPanel.setLayout(new BoxLayout(InputPanel, BoxLayout.X_AXIS));
		
		btnOneBaht = new JButton("");
		btnOneBaht.setIcon(new ImageIcon(CoinMachineApp.class.getResource("/images/1baht.png")));
		InputPanel.add(btnOneBaht);
		
		btnFiveBaht = new JButton("");
		btnFiveBaht.setIcon(new ImageIcon(CoinMachineApp.class.getResource("/images/5baht.png")));
		InputPanel.add(btnFiveBaht);
		
		btnTenBaht = new JButton("");
		btnTenBaht.setIcon(new ImageIcon(CoinMachineApp.class.getResource("/images/10baht.png")));
		InputPanel.add(btnTenBaht);
		contentPane.setLayout(gl_contentPane);
	}

}

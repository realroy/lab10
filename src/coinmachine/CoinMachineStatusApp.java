package coinmachine;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class CoinMachineStatusApp extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField textFieldCount;
	private JLabel lblCoins, lblStatus;

	public CoinMachineStatusApp() {
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
		setTitle("CoinMachine Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 121);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblCoins = new JLabel("#Coins:");
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblStatus = new JLabel("Aceppting Coins");
		lblStatus.setForeground(Color.GREEN);
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textFieldCount = new JTextField();
		textFieldCount.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCount.setEditable(false);
		textFieldCount.setText("0");
		textFieldCount.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(lblCoins, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textFieldCount, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(lblStatus, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCoins, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldCount, GroupLayout.PREFERRED_SIZE, 13, Short.MAX_VALUE)
							.addGap(13)))
					.addComponent(lblStatus, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof CoinMachine){
			CoinMachine coinMachine = (CoinMachine) subject;
			this.textFieldCount.setText(String.valueOf(coinMachine.getCount()));
			if(coinMachine.isFull()){
				this.lblStatus.setText("Full capicity");
				this.lblStatus.setForeground(Color.RED);
			}
			
			
		}
		else{}
		
	}
}

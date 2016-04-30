package coinmachine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class CoinMachineApp extends JFrame implements Observer {

	private JPanel contentPane, InputPanel;
	private JLabel lblBalance, lblStatus;
	private JLabel lblCount;
	JProgressBar progressBar;
	JButton btnTenBaht, btnFiveBaht, btnOneBaht;

	public CoinMachineApp() {
		setResizable(false);
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
		InputPanel.setBounds(5, 56, 369, 124);
		InputPanel.setBorder(new TitledBorder(null, "Insert Money", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblBalance = new JLabel("Balance: 0");
		lblBalance.setBounds(15, 16, 100, 22);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(125, 16, 55, 22);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		progressBar = new JProgressBar();
		progressBar.setBounds(198, 21, 166, 17);
		progressBar.setMaximum(10);
		progressBar.setForeground(Color.GREEN);
		contentPane.setLayout(null);
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
		contentPane.add(InputPanel);
		contentPane.add(lblBalance);
		contentPane.add(lblStatus);
		
		lblCount = new JLabel("0");
		lblCount.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCount.setBounds(260, 21, 46, 14);
		contentPane.add(lblCount);
		contentPane.add(progressBar);
	}

	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof CoinMachine){
			CoinMachine coinMachine = (CoinMachine) subject;
			int count 	= coinMachine.getCount(),
				balance = coinMachine.getBalance();
			this.progressBar.setValue(count);
			this.lblCount.setText(String.valueOf(count));
			this.lblBalance.setText("Balance: " + String.valueOf(balance));
			if(coinMachine.isFull()){
				this.progressBar.setForeground(Color.RED);
			}	
		}
		
	}

}

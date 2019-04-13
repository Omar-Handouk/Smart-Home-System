package operatingSystems;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class OperatingSystemsGUI implements ActionListener {

	private JFrame frame;
	JPanel panel;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JButton btnNewButton;
	JButton btnNewButton_1;
	JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("haha");
		new OperatingSystemsGUI();
	}

	/**
	 * Create the application.
	 */
	public OperatingSystemsGUI() {
		System.out.println("hena");
		frame = new JFrame();
		frame.setBounds(100, 100, 711, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\T-parthenos\\Desktop\\lighting-interior-design (1).jpg"));
		lblNewLabel.setBounds(0, 11, 363, 267);
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\T-parthenos\\Desktop\\images.jfif"));
		lblNewLabel_1.setBounds(373, 14, 312, 264);
		panel.add(lblNewLabel_1);

		btnNewButton = new JButton("Lights OFF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("ahha");
				lblNewLabel_1.setIcon(null);
			}
		});
		btnNewButton.setBounds(69, 352, 152, 72);
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("Heater ON");
		btnNewButton_1.setBounds(430, 352, 152, 72);
		panel.add(btnNewButton_1);

		progressBar = new JProgressBar();
		progressBar.setMaximum(300);
		progressBar.setToolTipText("Memory");
		progressBar.setBounds(10, 289, 675, 52);
		panel.add(progressBar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Initialize the contents of the frame.
	 */

}

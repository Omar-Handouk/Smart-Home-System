package operatingSystems;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;

public class GUI extends JFrame {
	private static int i = 1;
	JFrame a;
	JButton connect;
	boolean sent = false;
	boolean connected = false;
	String cname;
	private JPanel panel;
	static boolean heateron = false;
	static boolean lighton = true;

	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JPanel panel1;
	private JScrollPane scrollPane1;

	public static void main(String[] args) throws IOException {
		GUI frame = new GUI();

		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel label;
	private JProgressBar progressBar;
	private JLabel lblMemory;

	public GUI() throws IOException {
		i++;
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}

		a = new JFrame();
		a.setBackground(Color.BLUE);
		a.setResizable(false);
		a.setTitle("Smart Home");
		a.getContentPane().setBackground(new Color(0, 0, 51));
		SwingUtilities.updateComponentTreeUI(a);
		a.setPreferredSize(new Dimension(600, 600));

		a.pack();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new JPanel();
		panel1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 12));
		panel1.setBorder(new LineBorder(new Color(56, 0, 51), 2, true));
		panel1.setForeground(new Color(0, 0, 0));
		panel1.setBackground(new Color(0, 0, 51));
		scrollPane1 = new JScrollPane(panel1);
		scrollPane1.setBounds(10, 31, 572, 341);
		panel1.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 277, 319);
		panel1.add(lblNewLabel);

		BufferedImage dark = ImageIO.read(new File("andrewpic.png"));
		BufferedImage light = ImageIO.read(new File("light.jpg"));
		BufferedImage on = ImageIO.read(new File("kent.jpg"));
		BufferedImage off = ImageIO.read(new File("images.png"));

		ImageIcon off1 = new ImageIcon(off);
		ImageIcon light1 = new ImageIcon(light);
		ImageIcon on1 = new ImageIcon(on);
		ImageIcon dark1 = new ImageIcon(dark);

		label = new JLabel("New label");
		label.setIcon(off1);
		label.setBounds(287, 11, 277, 319);
		panel1.add(label);
		scrollPane1.setBorder(null);
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(light1);
		lblNewLabel.setBounds(10, 11, 277, 319);
		panel1.add(lblNewLabel);

		scrollPane1.setAutoscrolls(true);
		scrollPane1.getViewport().revalidate();
		a.getContentPane().setLayout(null);

		a.getContentPane().add(scrollPane1);

		btnNewButton = new JButton("Hearter ON");
		btnNewButton.setBounds(338, 468, 220, 77);
		btnNewButton.setIcon(null);
		btnNewButton.setIconTextGap(10);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				HeatingSys x = new HeatingSys(3.00, 60.0);
				heaterOn y = new heaterOn(2, 6, 3, 200, x); 
				heateron = (!(heateron));
				if (heateron) {
					label.setIcon(on1);
					btnNewButton.setText("Set Heater Off");
					OS.addProcess(y);
					int h= 300-OS.getfreeMemorySlots();
					progressBar.setValue(h);
				} else {
					label.setIcon(off1);
					btnNewButton.setText("Set Heater On");
					OS.terminateProcess2();

				}
			}
		});
		a.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("Lights OFF !!");
		btnNewButton_1.setBounds(51, 469, 220, 77);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lighton = !lighton;
				Lamps l = new Lamps(true, 30, Color.BLACK);
				Lightson x = new Lightson(1, 3, 2, 200, l);
				if (!lighton) {
					lblNewLabel.setIcon(dark1);

					btnNewButton_1.setText("Set Lights On");
					OS.terminateProcess2();
				} else {
					lblNewLabel.setIcon(light1);

					btnNewButton_1.setText("Set Lights Off");

					OS.addProcess(x);
					int h= 300-OS.getfreeMemorySlots();
					progressBar.setValue(h);
				}

			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		a.getContentPane().add(btnNewButton_1);
		int x = OS.getRemainingMemoryCells();
		progressBar = new JProgressBar();
		progressBar.setValue(300 - x);
		progressBar.setBounds(51, 400, 507, 46);
		a.getContentPane().add(progressBar);

		lblMemory = new JLabel("Memory");
		lblMemory.setForeground(Color.WHITE);
		lblMemory.setEnabled(false);
		lblMemory.setBackground(Color.WHITE);
		lblMemory.setBounds(32, 375, 46, 14);
		a.getContentPane().add(lblMemory);
		a.pack();
		a.setVisible(true);

	}
}

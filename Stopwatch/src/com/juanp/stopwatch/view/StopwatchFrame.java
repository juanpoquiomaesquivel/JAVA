package com.juanp.stopwatch.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class StopwatchFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnPlayPause;
	private JButton btnReset;
	private JLabel lblMiliseconds;
	private JLabel lblSeconds;
	private JLabel lblMinutes;
	private JLabel lblHours;

	public StopwatchFrame() {
		Font font = Font.getFont("Arial");

		try {
			font = Font.createFont(Font.TRUETYPE_FONT,
					this.getClass().getResourceAsStream("/assets/font/E1234-p7pER.ttf"));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 253);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel stopwatchPanel = new JPanel();
		contentPane.add(stopwatchPanel);
		stopwatchPanel.setLayout(null);

		JLabel lblBg1 = new JLabel();
		lblBg1.setOpaque(true);
		lblBg1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBg1.setBackground(new Color(255, 255, 255, 50));
		lblBg1.setBounds(45, 94, 410, 64);
		lblBg1.setFont(font.deriveFont(Font.BOLD, 55f));
		stopwatchPanel.add(lblBg1);

		lblHours = new JLabel("00");
		lblHours.setBorder(null);
		lblHours.setForeground(Color.WHITE);
		lblHours.setBackground(new Color(0, 0, 0));
		lblHours.setFont(font.deriveFont(Font.BOLD, 55f));
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setBounds(45, 81, 100, 100);
		stopwatchPanel.add(lblHours);

		lblMinutes = new JLabel("00");
		lblMinutes.setBorder(null);
		lblMinutes.setBackground(new Color(0, 0, 0));
		lblMinutes.setForeground(Color.WHITE);
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setFont(font.deriveFont(Font.BOLD, 55f));
		lblMinutes.setBounds(165, 81, 100, 100);
		stopwatchPanel.add(lblMinutes);

		lblSeconds = new JLabel("00");
		lblSeconds.setBorder(null);
		lblSeconds.setBackground(new Color(0, 0, 0));
		lblSeconds.setForeground(Color.WHITE);
		lblSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeconds.setFont(font.deriveFont(Font.BOLD, 55f));
		lblSeconds.setBounds(285, 81, 100, 100);
		stopwatchPanel.add(lblSeconds);

		lblMiliseconds = new JLabel("00");
		lblMiliseconds.setFocusCycleRoot(true);
		lblMiliseconds.setFocusTraversalKeysEnabled(false);
		lblMiliseconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiliseconds.setForeground(Color.WHITE);
		lblMiliseconds.setFont(font.deriveFont(Font.BOLD, 27.5f));
		lblMiliseconds.setBorder(null);
		lblMiliseconds.setBackground(Color.BLACK);
		lblMiliseconds.setBounds(405, 117, 50, 50);
		stopwatchPanel.add(lblMiliseconds);

		JLabel lblTitle = new JLabel("S T O P W A T C H");
		lblTitle.setOpaque(true);
		lblTitle.setBackground(new Color(255, 255, 255, 50));
		ImageIcon imgTitle = new ImageIcon(StopwatchFrame.class.getResource("/assets/stopwatch.png"));
		lblTitle.setIcon(resizeIcon(imgTitle, 60, 60));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblTitle.setBounds(75, 11, 350, 64);
		stopwatchPanel.add(lblTitle);

		btnPlayPause = new JButton("");
		btnPlayPause.setBorderPainted(false);
		btnPlayPause.setContentAreaFilled(false);
		btnPlayPause.setName("play");
		btnPlayPause.setIcon(imgBtnPlay);
		btnPlayPause.setFocusPainted(false);
		btnPlayPause.setRequestFocusEnabled(false);
		btnPlayPause.setBorder(null);
		btnPlayPause.setForeground(new Color(0, 0, 0));
		btnPlayPause.setBackground(UIManager.getColor("Button.background"));
		btnPlayPause.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnPlayPause.setBounds(180, 192, 50, 50);
		btnPlayPause.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopwatchPanel.add(btnPlayPause);

		btnReset = new JButton("");
		btnReset.setBorderPainted(false);
		btnReset.setContentAreaFilled(false);
		btnReset.setIcon(imgBtnReset);
		btnReset.setFocusPainted(false);
		btnReset.setRequestFocusEnabled(false);
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setBorder(null);
		btnReset.setBackground(UIManager.getColor("Button.background"));
		btnReset.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnReset.setBounds(270, 192, 50, 50);
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopwatchPanel.add(btnReset);

		JLabel lblHh = new JLabel("hours");
		lblHh.setBackground(new Color(0, 0, 0, 50));
		lblHh.setForeground(Color.WHITE);
		lblHh.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblHh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHh.setBounds(55, 160, 80, 14);
		stopwatchPanel.add(lblHh);

		JLabel lblMm = new JLabel("minutes");
		lblMm.setBackground(new Color(0, 0, 0, 50));
		lblMm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMm.setForeground(Color.WHITE);
		lblMm.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblMm.setBounds(175, 160, 80, 14);
		stopwatchPanel.add(lblMm);

		JLabel lblSs = new JLabel("seconds");
		lblSs.setBackground(new Color(0, 0, 0, 50));
		lblSs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSs.setForeground(Color.WHITE);
		lblSs.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblSs.setBounds(295, 160, 80, 14);
		stopwatchPanel.add(lblSs);

		JButton btnExit = new JButton("");
		btnExit.addActionListener(ae -> System.exit(EXIT_ON_CLOSE));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setContentAreaFilled(false);
		btnExit.setFocusPainted(false);
		btnExit.setIcon(new ImageIcon(StopwatchFrame.class.getResource("/assets/cross.png")));
		btnExit.setBorderPainted(false);
		btnExit.setBounds(470, 0, 30, 30);
		stopwatchPanel.add(btnExit);

		JLabel lblMs = new JLabel("ms");
		lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMs.setForeground(Color.WHITE);
		lblMs.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblMs.setBackground(new Color(0, 0, 0, 50));
		lblMs.setBounds(410, 160, 40, 14);
		stopwatchPanel.add(lblMs);

		JLabel lblDiv1 = new JLabel(":");
		lblDiv1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiv1.setForeground(Color.WHITE);
		lblDiv1.setBorder(null);
		lblDiv1.setBackground(Color.BLACK);
		lblDiv1.setBounds(130, 81, 50, 100);
		lblDiv1.setFont(font.deriveFont(Font.BOLD, 55f));
		stopwatchPanel.add(lblDiv1);

		JLabel lblDiv2 = new JLabel(":");
		lblDiv2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiv2.setForeground(Color.WHITE);
		lblDiv2.setBorder(null);
		lblDiv2.setBackground(Color.BLACK);
		lblDiv2.setBounds(250, 81, 50, 100);
		lblDiv2.setFont(font.deriveFont(Font.BOLD, 55f));
		stopwatchPanel.add(lblDiv2);

		JLabel lblDiv3 = new JLabel(".");
		lblDiv3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiv3.setForeground(Color.WHITE);
		lblDiv3.setBorder(null);
		lblDiv3.setBackground(Color.BLACK);
		lblDiv3.setBounds(370, 86, 50, 100);
		lblDiv3.setFont(font.deriveFont(Font.BOLD, 55f));
		stopwatchPanel.add(lblDiv3);

		JLabel lblBackground = new JLabel("");
		lblBackground.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = StopwatchFrame.this.getLocation();
				StopwatchFrame.this.setLocation(p.x + e.getX() - x, p.y + e.getY() - y);
			}
		});
		lblBackground.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(resizeGifIcon(gif, 505, 253));
		lblBackground.setBounds(0, 0, 500, 253);
		stopwatchPanel.add(lblBackground);
	}

	private int x, y;

	public JButton getBtnPlayPause() {
		return btnPlayPause;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	private final Icon imgBtnPlay = resizeIcon(
			new ImageIcon(StopwatchFrame.class.getResource("/assets/play-button.png")), 50, 50);
	private final Icon imgBtnPause = resizeIcon(
			new ImageIcon(StopwatchFrame.class.getResource("/assets/pause-button.png")), 50, 50);
	private final Icon imgBtnReset = resizeIcon(
			new ImageIcon(StopwatchFrame.class.getResource("/assets/rewind-button.png")), 45, 45);
	private final ImageIcon gif = new ImageIcon(StopwatchFrame.class.getResource("/assets/background.gif"));

	public Icon getImgBtnPlay() {
		return imgBtnPlay;
	}

	public Icon getImgBtnPause() {
		return imgBtnPause;
	}

	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);

		return new ImageIcon(resizedImage);
	}

	private static Icon resizeGifIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_REPLICATE);

		return new ImageIcon(resizedImage);
	}

	public JLabel getLblMiliseconds() {
		return lblMiliseconds;
	}

	public JLabel getLblSeconds() {
		return lblSeconds;
	}

	public JLabel getLblMinutes() {
		return lblMinutes;
	}

	public JLabel getLblHours() {
		return lblHours;
	}
}

// https://stackoverflow.com/questions/36957450/fit-size-of-an-imageicon-to-a-jbutton
package com.juanp.stopwatch.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StopwatchFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnPlayPause;
	private JButton btnReset;
	private JLabel lblMiliseconds;
	private JLabel lblSeconds;
	private JLabel lblMinutes;

	public StopwatchFrame() {
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT,
					this.getClass().getResourceAsStream("/assets/font/E1234-p7pER.ttf")).deriveFont(Font.BOLD, 45f);
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
		stopwatchPanel.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(stopwatchPanel);
		stopwatchPanel.setLayout(null);

		lblMinutes = new JLabel("00");
		lblMinutes.setBorder(null);
		lblMinutes.setOpaque(true);
		lblMinutes.setForeground(Color.WHITE);
		lblMinutes.setBackground(new Color(0, 0, 0, 50));
		lblMinutes.setFont(font);
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setBounds(100, 86, 80, 80);
		stopwatchPanel.add(lblMinutes);

		lblSeconds = new JLabel("00");
		lblSeconds.setBorder(null);
		lblSeconds.setBackground(new Color(0, 0, 0, 50));
		lblSeconds.setOpaque(true);
		lblSeconds.setForeground(Color.WHITE);
		lblSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeconds.setFont(font);
		lblSeconds.setBounds(210, 86, 80, 80);
		stopwatchPanel.add(lblSeconds);

		lblMiliseconds = new JLabel("00");
		lblMiliseconds.setBorder(null);
		lblMiliseconds.setBackground(new Color(0, 0, 0, 50));
		lblMiliseconds.setOpaque(true);
		lblMiliseconds.setForeground(Color.WHITE);
		lblMiliseconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiliseconds.setFont(font);
		lblMiliseconds.setBounds(320, 86, 80, 80);
		stopwatchPanel.add(lblMiliseconds);

		JLabel lblTitle = new JLabel("S T O P W A T C H");
		lblTitle.setOpaque(true);
		lblTitle.setBackground(new Color(0, 0, 0, 50));
		ImageIcon imgTitle = new ImageIcon(StopwatchFrame.class.getResource("/assets/stopwatch.png"));
		lblTitle.setIcon(resizeIcon(imgTitle, 60, 60));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 30));
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

		JLabel lblMinutesTitle = new JLabel("min");
		lblMinutesTitle.setBackground(new Color(0, 0, 0, 50));
		lblMinutesTitle.setOpaque(true);
		lblMinutesTitle.setForeground(Color.WHITE);
		lblMinutesTitle.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblMinutesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutesTitle.setBounds(100, 167, 80, 14);
		stopwatchPanel.add(lblMinutesTitle);

		JLabel lblSec = new JLabel("sec");
		lblSec.setBackground(new Color(0, 0, 0, 50));
		lblSec.setOpaque(true);
		lblSec.setHorizontalAlignment(SwingConstants.CENTER);
		lblSec.setForeground(Color.WHITE);
		lblSec.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblSec.setBounds(210, 169, 80, 14);
		stopwatchPanel.add(lblSec);

		JLabel lblMs = new JLabel("ms");
		lblMs.setBackground(new Color(0, 0, 0, 50));
		lblMs.setOpaque(true);
		lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMs.setForeground(Color.WHITE);
		lblMs.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblMs.setBounds(320, 169, 80, 14);
		stopwatchPanel.add(lblMs);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StopwatchFrame.this.dispose();
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(StopwatchFrame.class.getResource("/assets/cross.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(470, 0, 30, 30);
		stopwatchPanel.add(btnNewButton);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(Color.BLACK);
		lblBackground.setIcon(new ImageIcon(StopwatchFrame.class.getResource("/assets/naruto-background.gif")));
		lblBackground.setBounds(0, 0, 500, 253);
		stopwatchPanel.add(lblBackground);
	}

	public JButton getBtnPlayPause() {
		return btnPlayPause;
	}

	public JButton getBtnReset() {
		return btnReset;
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

	private final Icon imgBtnPlay = resizeIcon(
			new ImageIcon(StopwatchFrame.class.getResource("/assets/play-button.png")), 50, 50);
	private final Icon imgBtnPause = resizeIcon(
			new ImageIcon(StopwatchFrame.class.getResource("/assets/pause-button.png")), 50, 50);
	private final Icon imgBtnReset = resizeIcon(
			new ImageIcon(StopwatchFrame.class.getResource("/assets/rewind-button.png")), 45, 45);

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
}

// https://stackoverflow.com/questions/36957450/fit-size-of-an-imageicon-to-a-jbutton
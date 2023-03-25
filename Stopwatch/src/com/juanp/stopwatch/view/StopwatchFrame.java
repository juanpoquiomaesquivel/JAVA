package com.juanp.stopwatch.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class StopwatchFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnStart;
	private JButton btnStopReset;
	private JLabel lblMiliseconds;
	private JLabel lblSeconds;
	private JLabel lblMinutes;

	public StopwatchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel stopwatchPanel = new JPanel();
		stopwatchPanel.setBackground(new Color(255, 0, 128));
		contentPane.add(stopwatchPanel);
		stopwatchPanel.setLayout(null);

		lblMinutes = new JLabel("00");
		lblMinutes.setForeground(new Color(255, 255, 255));
		lblMinutes.setBackground(new Color(0, 255, 0));
		lblMinutes.setFont(new Font("Trebuchet MS", Font.BOLD, 60));
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setBounds(40, 96, 80, 80);
		stopwatchPanel.add(lblMinutes);

		lblSeconds = new JLabel("00");
		lblSeconds.setForeground(new Color(255, 255, 255));
		lblSeconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeconds.setFont(new Font("Trebuchet MS", Font.BOLD, 60));
		lblSeconds.setBounds(160, 96, 80, 80);
		stopwatchPanel.add(lblSeconds);

		lblMiliseconds = new JLabel("00");
		lblMiliseconds.setForeground(new Color(255, 255, 255));
		lblMiliseconds.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiliseconds.setFont(new Font("Trebuchet MS", Font.BOLD, 60));
		lblMiliseconds.setBounds(280, 96, 80, 80);
		stopwatchPanel.add(lblMiliseconds);

		JLabel lblTitle = new JLabel("Stopwatch");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 60));
		lblTitle.setBounds(10, 11, 384, 80);
		stopwatchPanel.add(lblTitle);

		btnStart = new JButton("START");
		btnStart.setFocusPainted(false);
		btnStart.setRequestFocusEnabled(false);
		btnStart.setBorder(null);
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.setBackground(new Color(255, 128, 255));
		btnStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnStart.setBounds(65, 225, 110, 40);
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopwatchPanel.add(btnStart);

		btnStopReset = new JButton("RESET");
		btnStopReset.setFocusPainted(false);
		btnStopReset.setRequestFocusEnabled(false);
		btnStopReset.setForeground(new Color(255, 255, 255));
		btnStopReset.setBorder(null);
		btnStopReset.setBackground(new Color(255, 128, 255));
		btnStopReset.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnStopReset.setBounds(225, 225, 110, 40);
		btnStopReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stopwatchPanel.add(btnStopReset);
		
		JLabel lblMinutesTitle = new JLabel("min");
		lblMinutesTitle.setForeground(new Color(255, 255, 255));
		lblMinutesTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblMinutesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutesTitle.setBounds(40, 180, 80, 14);
		stopwatchPanel.add(lblMinutesTitle);
		
		JLabel lblSec = new JLabel("sec");
		lblSec.setHorizontalAlignment(SwingConstants.CENTER);
		lblSec.setForeground(Color.WHITE);
		lblSec.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblSec.setBounds(160, 182, 80, 14);
		stopwatchPanel.add(lblSec);
		
		JLabel lblMs = new JLabel("ms");
		lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMs.setForeground(Color.WHITE);
		lblMs.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblMs.setBounds(280, 182, 80, 14);
		stopwatchPanel.add(lblMs);
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public JButton getBtnStopReset() {
		return btnStopReset;
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
}

package com.juanp.stopwatch.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JButton;
import javax.swing.SwingWorker;

import com.juanp.stopwatch.model.Stopwatch;
import com.juanp.stopwatch.view.StopwatchFrame;

public class StopwatchController {

	private Stopwatch model;
	private StopwatchFrame view;

	public StopwatchController(Stopwatch model, StopwatchFrame view) {
		this.model = model;
		this.view = view;
		init();
	}

	public void place() {
		view.setTitle("Stopwatch");
		view.setLocationRelativeTo(null);
		view.setVisible(true);
	}

	private void init() {
		model.addPropertyChangeListener(new SwPropertiesListener());
		view.getBtnStart().addActionListener(new SwBtnStartListener());
		view.getBtnStopReset().addActionListener(new SwBtnStopResetListener());
	}

	private class SwPropertiesListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			if (evt.getPropertyName().equals("miliseconds")) {
				int ms = (int) evt.getNewValue();
				String txt = ms < 10 ? "00"
						: (ms < 100 ? "0" + Integer.toString(ms).charAt(0) : Integer.toString(ms).substring(0, 2));

				view.getLblMiliseconds().setText(txt);
			}

			if (evt.getPropertyName().equals("seconds")) {
				int ss = (int) evt.getNewValue();
				String txt = ss < 10 ? "0" + Integer.toString(ss) : Integer.toString(ss);
				
				view.getLblSeconds().setText(txt);
			}

			if (evt.getPropertyName().equals("minutes")) {
				int mm = (int) evt.getNewValue();
				String txt = mm < 10 ? "0" + Integer.toString(mm) : Integer.toString(mm);
				
				view.getLblMinutes().setText(txt);
			}
		}
	}

	private class SwBtnStartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.start();
			view.getBtnStart().setEnabled(false);
			view.getBtnStopReset().setText("STOP");
			view.getBtnStopReset().setEnabled(true);
		}
	}

	private class SwBtnStopResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			String txt = btn.getText().toLowerCase();

			if (txt.equals("stop")) {
				model.stop();
				view.getBtnStart().setText("RESUME");
				view.getBtnStopReset().setText("RESET");
			} else {
				model.reset();
				view.getBtnStart().setText("START");
				view.getBtnStopReset().setEnabled(false);
			}

			view.getBtnStart().setEnabled(true);
		}
	}
}

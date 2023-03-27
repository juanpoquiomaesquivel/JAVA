package com.juanp.stopwatch.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
		view.getBtnPlayPause().addActionListener(new SwBtnStartPauseListener());
		view.getBtnReset().addActionListener(new SwBtnResetListener());
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

	private class SwBtnStartPauseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = view.getBtnPlayPause().getName();

			if ("play".equals(name)) {
				model.start();
				view.getBtnPlayPause().setIcon(view.getImgBtnPause());
				view.getBtnPlayPause().setName("pause");
			} else {
				model.stop();
				view.getBtnPlayPause().setIcon(view.getImgBtnPlay());
				view.getBtnPlayPause().setName("play");
			}
		}
	}

	private class SwBtnResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.stop();
			model.reset();
			view.getBtnPlayPause().setIcon(view.getImgBtnPlay());
			view.getBtnPlayPause().setName("play");
		}
	}
}

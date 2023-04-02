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
		view.getBtnPlayPause().addActionListener(new SwBtnPlayPauseListener());
		view.getBtnReset().addActionListener(new SwBtnResetListener());
	}

	private class SwPropertiesListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			if (evt.getPropertyName().equals("miliseconds")) {
				int ms = (int) evt.getNewValue();
				String txt = Integer.toString(ms);
				txt = ms >= 100 ? txt.substring(0, 2) : "0" + txt.charAt(0);

				view.getLblMiliseconds().setText(txt);
			}

			if (evt.getPropertyName().equals("seconds")) {
				int ss = (int) evt.getNewValue();
				String txt = Integer.toString(ss);
				txt = ss < 10 ? "0" + txt : txt;

				view.getLblSeconds().setText(txt);
			}

			if (evt.getPropertyName().equals("minutes")) {
				int mm = (int) evt.getNewValue();
				String txt = Integer.toString(mm);
				txt = mm < 10 ? "0" + txt : txt;

				view.getLblMinutes().setText(txt);
			}

			if (evt.getPropertyName().equals("hours")) {
				int hh = (int) evt.getNewValue();
				String txt = Integer.toString(hh);
				txt = hh < 10 ? "0" + txt : txt;

				view.getLblHours().setText(txt);
			}
		}
	}

	private class SwBtnPlayPauseListener implements ActionListener {

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

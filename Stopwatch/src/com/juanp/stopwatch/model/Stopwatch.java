package com.juanp.stopwatch.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.Timer;

public final class Stopwatch {

	private static final int STEP = 10;

	private PropertyChangeSupport pcs;
	private Timer timer;
	private int minutes;
	private int seconds;
	private int miliseconds;

	public Stopwatch() {
		pcs = new PropertyChangeSupport(this);
		reset();
		timer = new Timer(STEP, ae -> {
			miliseconds += STEP;

			if (miliseconds == 1000) {
				miliseconds = 0;
				seconds++;

				if (seconds == 60) {
					seconds = 0;
					minutes++;

					if (minutes == 100) {
						minutes = seconds = miliseconds = 0;
					}
				}
			}

			fire(miliseconds, seconds, minutes);
		});
	}

	private void fire(Integer... values) {
		pcs.firePropertyChange("miliseconds", null, values[0]);
		pcs.firePropertyChange("seconds", null, values[1]);
		pcs.firePropertyChange("minutes", null, values[2]);
	}

	public final void start() {
		timer.start();
	}

	public final void stop() {
		timer.stop();
	}

	public final void reset() {
		minutes = seconds = miliseconds = 0;
		fire(miliseconds, seconds, minutes);
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public int getMiliseconds() {
		return miliseconds;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
}

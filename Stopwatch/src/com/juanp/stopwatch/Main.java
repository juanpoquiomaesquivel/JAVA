package com.juanp.stopwatch;

import com.juanp.stopwatch.controller.StopwatchController;
import com.juanp.stopwatch.model.Stopwatch;
import com.juanp.stopwatch.view.StopwatchFrame;

public class Main {

	public static void main(String[] args) {
		Stopwatch model = new Stopwatch();
		StopwatchFrame view = new StopwatchFrame();
		StopwatchController controller = new StopwatchController(model, view);
		controller.place();
	}
}

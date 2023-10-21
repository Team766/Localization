package com.team766.robot;

import com.team766.robot.mechanisms.*;

public class Robot {
	// Declare mechanisms here
	public static Vision vision;
	public static Lights lights;

	public static void robotInit() {
		// Initialize mechanisms here
		vision = new Vision();
		lights = new Lights();
	}
}

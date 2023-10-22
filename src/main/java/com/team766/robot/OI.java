package com.team766.robot;

import com.team766.framework.Procedure;
import java.sql.Driver;
import com.team766.framework.Context;
import com.team766.hal.JoystickReader;
import com.team766.hal.RobotProvider;
import com.team766.logging.Category;
import com.team766.robot.procedures.*;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the code that allow control of the robot.
 */
public class OI extends Procedure {
	private JoystickReader joystick0;
	// private JoystickReader joystick1;
	// private JoystickReader joystick2;
	int state = 0;
	boolean ignoreState = false;

	public OI() {
		loggerCategory = Category.OPERATOR_INTERFACE;

		joystick0 = RobotProvider.instance.getJoystick(0);
		// joystick1 = RobotProvider.instance.getJoystick(1);
		// joystick2 = RobotProvider.instance.getJoystick(2);
	}

	public void run(Context context) {
		context.takeOwnership(Robot.vision);
		context.takeOwnership(Robot.lights);
		while (true) {
			// wait for driver station data (and refresh it using the WPILib APIs)
			context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData());
			RobotProvider.instance.refreshDriverStationData();	

			if(DriverStation.getMatchTime() < 30 && DriverStation.getMatchTime() > 28){
				Robot.lights.rainbow();
				log("" + DriverStation.getMatchTime());
				ignoreState = true;
			}

			if(DriverStation.getMatchTime() <28 && DriverStation.getMatchTime() > 27.7){
				Robot.lights.clearAnimation();
				ignoreState = false;
			}

			
			
			if(joystick0.getButtonPressed(1)){
				state = 1;
			}
			if(joystick0.getButtonPressed(2)){
				state = 2;
			}
			if(DriverStation.getMatchTime() < 5){
				state = 3;
			}

			switch (state){
				case 1:
					if(ignoreState){ break;}
					Robot.lights.signalCube();
					break;
				case 2:
					if(ignoreState){ break;}
					Robot.lights.signalCone();
					break;
				case 3:
					if(ignoreState){ break;}
					Robot.lights.rainbow();
					break;
				default:
					if(!ignoreState){
					Robot.lights.resetLights();
					}
			}

			//log("X: " + Robot.vision.getX() + " Y: " + Robot.vision.getY());

			// Add driver controls here - make sure to take/release ownership
			// of mechanisms when appropriate.
		}
	}
}

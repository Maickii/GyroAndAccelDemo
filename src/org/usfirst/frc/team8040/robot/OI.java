package org.usfirst.frc.team8040.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team8040.robot.commands.LockInMechanism;

import com.analog.adis16448.frc.ADIS16448_IMU;

public class OI {
	public static Joystick stick = new Joystick(0);
	public static Button trigger = new JoystickButton(stick, 1);
	public static ADIS16448_IMU imu = new ADIS16448_IMU();

	public void commands() {
		trigger.whileHeld(new LockInMechanism());
	}
}

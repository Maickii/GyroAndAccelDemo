package org.usfirst.frc.team8040.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class RobotMap {
	public static RobotDrive myRobot;
	public static Victor frontLeft;
	public static Victor backLeft;
	public static Victor frontRight;
	public static Victor backRight;
	public void init()
	{
		frontLeft = new Victor(0);
    	backLeft = new Victor(1);
    	frontRight = new Victor(2);
    	backRight = new Victor(3);
    
    	
    	myRobot = new RobotDrive(frontLeft,backLeft,frontRight,backRight);
    	
    	myRobot.setInvertedMotor(MotorType.kFrontLeft, true);	// invert the left side motors
    	myRobot.setInvertedMotor(MotorType.kRearLeft, true);
    	
    	
	}
}

package org.usfirst.frc.team8040.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team8040.robot.commands.Auto;
import org.usfirst.frc.team8040.robot.subsystems.LockIn;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static RobotMap robotMap = new RobotMap();
	public static LockIn lockS = new LockIn();
	public static double angle = 0;
	public static Command autonomousCommand;   
    public static double accelX = 0;
   	public static double accelY = 0;
   	public static double accelZ = 0;
	
    public void robotInit() {
    	robotMap.init();
		oi = new OI();
    	OI.imu.calibrate();
		autonomousCommand = new Auto();   
    }
	
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	OI.imu.reset();
    	RobotMap.myRobot.setMaxOutput(0.15);
    	 autonomousCommand.start();
    }
    
    public void autonomousPeriodic() {
    	angle = OI.imu.getAngleZ();
    	accelX = OI.imu.getAccelX();
    	accelY = OI.imu.getAccelY();
    	accelZ = OI.imu.getAccelZ();
    	SmartDashboard.putNumber("gyro angle", angle);
        SmartDashboard.putNumber("accelX", accelX);
        SmartDashboard.putNumber("accelY", accelY);
        SmartDashboard.putNumber("accelZ", accelZ);
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	OI.imu.reset();
    	RobotMap.myRobot.setMaxOutput(0.5);
    }
   

    /**
     *  Hold Joystick trigger to disable robot self-correct. 
     *  This is done by resetting the Gyro angle to 0.
     */
    public void teleopPeriodic() {
    	oi.commands();
    	angle = OI.imu.getAngleZ();
    	accelX = OI.imu.getAccelX();
    	accelY = OI.imu.getAccelY();
    	accelZ = OI.imu.getAccelZ();
    	
    	RobotMap.myRobot.mecanumDrive_Cartesian(OI.stick.getX(), OI.stick.getY(), angle *0.027 , angle);
    	
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("gyro angle", angle);
        SmartDashboard.putNumber("accelX", accelX);
        SmartDashboard.putNumber("accelY", accelY);
        SmartDashboard.putNumber("accelZ", accelZ);
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}

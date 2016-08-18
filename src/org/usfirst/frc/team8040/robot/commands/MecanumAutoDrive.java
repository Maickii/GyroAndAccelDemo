package org.usfirst.frc.team8040.robot.commands;

import org.usfirst.frc.team8040.robot.Robot;
import org.usfirst.frc.team8040.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The MecanumAutoDrive class allows you to autonomously create mecanum drive in
 * any direction. You can also specify a time based system or an obstacle based
 * system. Time based system will run the code from the time it is initialized
 * until the timer runs out in seconds. Obstacle based uses the accelerometer to
 * measure impact and stop.
 */
public class MecanumAutoDrive extends Command {

	private modes mode;
	private directions direction;
	private double time;

	public static enum modes {
		TimeBased, ObstacleBased
	}

	public static enum directions {
		left, right, forward, backward, leftForward, leftBackward, rightForward, rightBackward
	}

	/**two modes, time based or obstacle based.
	 * 
	 * @param mode true for time based, false for obstacle.
	 * @param time in seconds
	 */
	public MecanumAutoDrive(modes mode, directions direction, double time) {
		this.mode = mode;
		this.direction = direction;
		this.time = time;
	}

	protected void initialize() {

	}

	/**
	 * drive in scheduled loop
	 */
	protected void execute() {
		if (this.direction == directions.left) {
			RobotMap.myRobot.mecanumDrive_Cartesian(-1, 0, Robot.angle * 0.027, Robot.angle);
		} else if (this.direction == directions.right) {
			RobotMap.myRobot.mecanumDrive_Cartesian(1, 0, Robot.angle * 0.027, Robot.angle);
		} else if (this.direction == directions.forward) {
			RobotMap.myRobot.mecanumDrive_Cartesian(0, -1, Robot.angle * 0.027, Robot.angle);
		} else if (this.direction == directions.backward) {
			RobotMap.myRobot.mecanumDrive_Cartesian(0, 1, Robot.angle * 0.027, Robot.angle);
		} else if (this.direction == directions.leftForward) {
			RobotMap.myRobot.mecanumDrive_Cartesian(-1, -1, Robot.angle * 0.027, Robot.angle);
		} else if (this.direction == directions.leftBackward) {
			RobotMap.myRobot.mecanumDrive_Cartesian(-1, 1, Robot.angle * 0.027, Robot.angle);
		} else if (this.direction == directions.rightForward) {
			RobotMap.myRobot.mecanumDrive_Cartesian(1, -1, Robot.angle * 0.027, Robot.angle);
		} else if (this.direction == directions.rightBackward) {
			RobotMap.myRobot.mecanumDrive_Cartesian(1, 1, Robot.angle * 0.027, Robot.angle);
		}
	}

	/**
	 * creates the ability to stop in time based or obstacle based
	 */
	protected boolean isFinished() {
		if (this.mode == modes.ObstacleBased) {
			return Robot.accelY > 0.15;
		} else if (this.mode == modes.TimeBased) {
			return timeSinceInitialized() > time;
		}
		return false;
	}

	protected void end() {
		RobotMap.myRobot.drive(0, 0);
	}

	protected void interrupted() {
		end();
	}
}

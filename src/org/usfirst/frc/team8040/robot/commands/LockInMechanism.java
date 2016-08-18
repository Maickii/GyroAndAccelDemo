package org.usfirst.frc.team8040.robot.commands;

import org.usfirst.frc.team8040.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	this class is used to disable the robot self-correction.
 *	this is done by reseting the Gyro angle to 0
 */
public class LockInMechanism extends Command {

    public LockInMechanism() {
    	requires(Robot.lockS);
    	
    }

    protected void initialize() {
    	Robot.lockS.LockIn();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

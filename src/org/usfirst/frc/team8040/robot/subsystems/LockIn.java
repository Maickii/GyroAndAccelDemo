package org.usfirst.frc.team8040.robot.subsystems;

import org.usfirst.frc.team8040.robot.OI;
import org.usfirst.frc.team8040.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LockIn extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void LockIn(){
    	OI.imu.reset();
    }
}


package org.usfirst.frc.team8040.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto extends CommandGroup {
    
    public  Auto() {
    	addSequential(new MecanumAutoDrive(MecanumAutoDrive.modes.ObstacleBased, MecanumAutoDrive.directions.forward, 0));
    	addSequential(new MecanumAutoDrive(MecanumAutoDrive.modes.TimeBased, MecanumAutoDrive.directions.backward, 0.5));
    	addSequential(new MecanumAutoDrive(MecanumAutoDrive.modes.TimeBased, MecanumAutoDrive.directions.right, 7));
    }
}
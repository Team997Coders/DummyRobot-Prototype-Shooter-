package org.usfirst.frc.team997.robot.commands;

import org.usfirst.frc.team997.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConstantSpeed extends Command {

	private Timer mytimer;
    
	public ConstantSpeed() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.dummydrive);
    	mytimer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	mytimer.reset();
    	mytimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dummydrive.shoot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         if (mytimer.get()>2.5){
        	return true;
        	
        }
         else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

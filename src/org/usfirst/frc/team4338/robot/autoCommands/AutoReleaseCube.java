package org.usfirst.frc.team4338.robot.autoCommands;

import org.usfirst.frc.team4338.robot.Robot;
import org.usfirst.frc.team4338.robot.systems.Intake;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class AutoReleaseCube extends TimedCommand {
	
	private Intake intake;

    public AutoReleaseCube(Intake intake, double timeout) {
    		super (timeout);
        this.intake = intake;
        requires (intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		intake.openArms();
    		intake.cubeOut();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after isFinished returns true
    protected void end() {
    		intake.stop();
    		System.out.println("Finished AutoReleaseCube at " + Robot.timeSinceStart());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}

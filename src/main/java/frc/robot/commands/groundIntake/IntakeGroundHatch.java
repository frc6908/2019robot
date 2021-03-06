/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.groundintake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeGroundHatch extends Command {
  public IntakeGroundHatch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.groundIntake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Starting ground intake");
    Robot.groundIntake.wheels.set(0.5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // System.out.println("Running ground intake");
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("isFinished");
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Ending ground hatch intake");
    Robot.groundIntake.wheels.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
